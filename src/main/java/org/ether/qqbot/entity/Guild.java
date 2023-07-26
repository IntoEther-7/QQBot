package org.ether.qqbot.entity;

/**
 * @author IntoEther-7
 * @date 2023/7/5 15:10
 * @project ZhihuProject
 */

import lombok.Data;

/**
 * 频道对象(Guild)
 */
@Data
public class Guild {
    private String id;
    private String name;
    private String icon;
    private String owner_id;
    private boolean owner;
    private int member_count;
    private int max_members;
    private String description;
    private String joined_at;

}
