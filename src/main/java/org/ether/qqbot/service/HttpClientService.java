package org.ether.qqbot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author IntoEther-7
 * @date 2023/7/20 15:49
 * @project QQBot
 */
public class HttpClientService {
    public static final String FORMAL_ENV = "https://api.sgroup.qq.com"; // 正式环境的url
    public static final String SANDBOX_ENV = "https://sandbox.api.sgroup.qq.com"; // 测试环境url
    private static boolean isTestEnv; // 是否是测试环境
    private static String currEnv; // 当前环境url

    public HttpClientService(boolean isTestEnv) {
        if (isTestEnv) {
            currEnv = SANDBOX_ENV;
        } else {
            currEnv = FORMAL_ENV;
        }
    }

    /**
     *
     */
    public <T> T getData(String method, String api, Class clazz, HashMap<String, String> map) throws IOException {
        // 启动http连接
        // 获得数据
        Content content = null;
        switch (method) {
            case "GET":
                content = Request.get(currEnv + api).execute().returnContent();
                break;
            case "POST":
                content = Request.post(currEnv + api)
                        .bodyForm(Form.form().add("?", "?").build())
                        .execute().returnContent();
                break;
        }
        // 解析数据
//        new ObjectMapper().readValue()
        // 返回数据
        return (T) new Object();
    }
}
