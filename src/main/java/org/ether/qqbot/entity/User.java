package org.ether.qqbot.entity;

import lombok.Data;

/**
 * @author IntoEther-7
 * @date 2023/7/5 16:05
 * @project ZhihuProject
 */
@Data
public class User {
    private String id;
    private String username;
    private String avatar;
    private boolean bot;
    private String union_openid;
    private String union_user_account;
}
