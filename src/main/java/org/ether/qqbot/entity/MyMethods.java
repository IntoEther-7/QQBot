package org.ether.qqbot.entity;

/**
 * @author IntoEther-7
 * @date 2023/7/22 16:51
 * @project QQBot
 */
public enum MyMethods {
    WSS("/gateway"), // https://bot.q.qq.com/wiki/develop/api/openapi/wss/url_get.html
    WSS_SHARDING("/gateway/bot"), // https://bot.q.qq.com/wiki/develop/api/openapi/wss/shard_url_get.html

    ;
    private String METHOD;
    private String API;
    private String CONTENT_TYPE;

    MyMethods(String API) {
        this.API = API;
        this.METHOD = "GET";
        this.CONTENT_TYPE = "application/json";
    }

    MyMethods(String METHOD, String API, String CONTENT_TYPE) {
        this.METHOD = METHOD;
        this.API = API;
        this.CONTENT_TYPE = CONTENT_TYPE;
    }

    public String getMETHOD() {
        return METHOD;
    }

    public String getAPI() {
        return API;
    }

    public String getCONTENT_TYPE() {
        return CONTENT_TYPE;
    }
}
