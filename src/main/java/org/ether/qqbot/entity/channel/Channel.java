package org.ether.qqbot.entity.channel;

import lombok.Data;

/**
 * @author IntoEther-7
 * @date 2023/7/5 15:55
 * @project ZhihuProject
 */
@Data
public class Channel {
    private String id;
    private String guild_id;
    private String name;
    private int type;
    private int sub_type;
    private int position;
    private String parent_id;
    private String owner_id;
    private int private_type;
    private int speak_permission;
    private String application_id;
    private String permissions;
}
