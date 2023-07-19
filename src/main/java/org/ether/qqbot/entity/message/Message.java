package org.ether.qqbot.entity.message;

import lombok.Data;
import org.ether.qqbot.entity.Member;
import org.ether.qqbot.entity.User;

/**
 * @author IntoEther-7
 * @date 2023/7/5 16:04
 * @project ZhihuProject
 */
@Data
public class Message {
    private String id; // 消息 id
    private String channel_id; // 子频道 id
    private String guild_id; // 频道 id
    private String content; // 消息内容
    private String image; // 图像链接
    private String timestamp; // 消息创建时间
    private String edited_timestamp; // 消息编辑时间
    private Boolean mention_everyone; // 是否是@全员消息
    private User author; // 消息创建者
    private MessageAttachment[] attachments; // 附件
    private MessageEmbed[] embeds; // embed
    private User[] mentions; // 消息中@的人
    private Member member; // 消息创建者的member信息
    private MessageArk ark; // ark消息
    private Integer seq; // 用于消息间的排序，seq 在同一子频道中按从先到后的顺序递增，不同的子频道之间消息无法排序。(目前只在消息事件中有值，2022年8月1日 后续废弃)
    private String seq_in_channel; // 子频道消息 seq，用于消息间的排序，seq 在同一子频道中按从先到后的顺序递增，不同的子频道之间消息无法排序
    private MessageReference message_reference; // 引用消息对象
    private String src_guild_id; // 用于私信场景下识别真实的来源频道id
}
