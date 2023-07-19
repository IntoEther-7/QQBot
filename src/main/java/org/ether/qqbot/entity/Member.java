package org.ether.qqbot.entity;

import lombok.Data;

/**
 * @author IntoEther-7
 * @date 2023/7/5 16:04
 * @project ZhihuProject
 */
@Data
public class Member {
    private User user;
    private String nick;
    private String[] roles;
    private String joined_at;
    private String guild_id;
}
