package org.ether.qqbot.entity.channel;

import lombok.Data;

/**
 * @author IntoEther-7
 * @date 2023/7/5 16:04
 * @project ZhihuProject
 */
@Data
public class ChannelPermissions {
    private String channel_id;
    private String role_id;
    private String user_id;
    private String permissions;
}
