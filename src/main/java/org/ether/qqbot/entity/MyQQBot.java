package org.ether.qqbot.entity;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.ether.qqbot.entity.channel.Channel;
import org.ether.qqbot.entity.message.Message;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Random;

/**
 * @author IntoEther-7
 * @date 2023/7/5 15:00
 * @project ZhihuProject
 */
@Slf4j
public class MyQQBot {
    private static final String ONLINE_ENV = "https://api.sgroup.qq.com/";
    private static final String TEST_ENV = "https://sandbox.api.sgroup.qq.com/";
    private final String bot_app_id; // 用于识别一个机器人的 id
    private final String bot_secret; // 用于在 oauth 场景进行请求签名的密钥
    private final String bot_token; // 机器人token，用于以机器人身份调用 openapi，格式为 ${app_id}.${random_str}
    private final String authorization; // 使用在 HTTP 上添加 Authorization 头来进行鉴权。支持两种类型的 TOKEN
    // 使用申请机器人时平台返回的机器人 appID + token 拼接而成。此时，所有的操作都是以机器人身份来完成的。
    // 使用 OAUTH2.0 接口，通过一次性 CODE 换取的代表用户登录态的 Token。此时所有的操作都是以授权用户的身份来完成的。

    public MyQQBot() {
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(new FileInputStream("QQBot/src/main/resources/mybot.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.bot_app_id = properties.getProperty("bot_app_id");
        this.bot_secret = properties.getProperty("bot_secret");
        this.bot_token = properties.getProperty("bot_token");
        this.authorization = "Bot %s.%s".formatted(bot_app_id, bot_token);
        System.out.println(authorization);
    }

    public void sendMessage(Channel channel, Message message) {
        // https://sandbox.api.sgroup.qq.com/channels/559365787/messages
        String url;
        if (channel == null) {
            url = "https://sandbox.api.sgroup.qq.com/channels/559365787/messages";
        } else {
            url = "https://sandbox.api.sgroup.qq.com/channels/%s/messages".formatted(channel.getId());
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", authorization);
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            /** 设置通用的请求属性 */
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式
            String bounary = "--------------------------" + new Random().nextInt();
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + bounary); // 发送json数据,
            // 设置为这个

            System.out.println(connection.getRequestProperties());

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(),
                    StandardCharsets.UTF_8);

            String jsonString = JSON.toJSONString(message);
            System.out.println(jsonString);
            outputStreamWriter.write(jsonString);
            outputStreamWriter.flush();
            outputStreamWriter.close();

            System.out.println(connection.getHeaderFields());

            connection.disconnect();

            System.out.println(connection.getResponseCode() + " " + connection.getResponseMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendImageFormdata(Channel channel, File image) {
        log.info("sendImageFormdata");
        String url;
        if (channel == null) {
            url = "https://sandbox.api.sgroup.qq.com/channels/559365787/messages";
        } else {
            url = "https://sandbox.api.sgroup.qq.com/channels/%s/messages".formatted(channel.getId());
        }


        HttpURLConnection connection = null;
        OutputStream outputStream = null;
        String rs = null;
        try {
            URL urls = new URL(url);
            connection = (HttpURLConnection) urls.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Authorization", authorization);
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=--------------------------718217214785238184943055");

            connection.setConnectTimeout(8000);
            connection.setReadTimeout(20000);
            connection.setRequestMethod("POST");

            StringBuffer buffer = new StringBuffer();
            if (image != null) {
                //设置请求参数
//                buffer.append("------footfoodapplicationrequestnetwork\r\n");
//                buffer.append("Content-Disposition: form-data; name=\"");
//                buffer.append("content");
//                buffer.append("\"\r\n\r\n");
//                buffer.append("");
//                buffer.append("\r\n");
//                buffer.append("------footfoodapplicationrequestnetwork--\r\n");

                buffer.append("----------------------------718217214785238184943055\n");
                buffer.append("Content-Disposition: form-data; name=\"file_image\"; ");
                buffer.append("filename=\"%s\"\n".formatted(image.getName()));
                String[] split = image.getName().split("\\.");
                buffer.append("Content-Type: image/%s".formatted(split[split.length - 1]));
                buffer.append("\n\n");

                // 写入文件数据
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(image),
                        StandardCharsets.ISO_8859_1));
                String read;
                byte[] bytes = new byte[10240];
                while ((read = bufferedReader.readLine()) != null) {
                    // 写入文件数据
                    buffer.append(read);
                }

                buffer.append("\n");
                buffer.append("----------------------------718217214785238184943055--\n");
            }

            connection.setRequestProperty("Content-Length", String.valueOf(buffer.toString().length()));

            outputStream = connection.getOutputStream();
            outputStream.write(buffer.toString().getBytes());
            outputStream.flush();

            log.error(String.valueOf(buffer.toString().getBytes().length));
            log.error(String.valueOf(buffer.toString().length()));
            log.error(connection.getRequestProperty("Content-Length"));
            log.error(String.valueOf(connection.getHeaderFields()));
            log.error(buffer.toString());

            try {
                connection.connect();
                if (connection.getResponseCode() == 200) {
                    System.out.println("------------------------------");
                }
            } catch (Exception e) {
                rs = null;
            }
            System.out.println(connection.getResponseCode() + " " + connection.getResponseMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                outputStream.close();
            } catch (Exception e) {
            }
            outputStream = null;

            if (connection != null) {
                connection.disconnect();
            }
            connection = null;
        }

    }

    @Test
    public void test() {
        Message message = new Message();
        message.setContent("safasdfsadfddfsadfsdaf");
        message.setImage("https://ether-bucket-nj.oss-cn-nanjing.aliyuncs.com/img/image-20230630214059437.png");
        sendMessage(null, message);
    }


}
