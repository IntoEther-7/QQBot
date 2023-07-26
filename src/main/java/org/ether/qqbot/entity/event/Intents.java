package org.ether.qqbot.entity.event;

import java.util.HashMap;

/**
 * @author IntoEther-7
 * @date 2023/7/7 15:57
 * @project ZhihuProject
 */
public enum Intents {
    READY(null, "READY"),


    GUILDS(1 << 0, "GUILDS"),
    GUILD_CREATE(1 << 0, "当机器人加入新guild时", "GUILD_CREATE"),
    GUILD_UPDATE(1 << 0, "当guild资料发生变更时", "GUILD_UPDATE"),
    GUILD_DELETE(1 << 0, "当机器人退出guild时", "GUILD_DELETE"),
    CHANNEL_CREATE(1 << 0, "当channel被创建时", "CHANNEL_CREATE"),
    CHANNEL_UPDATE(1 << 0, "当channel被更新时", "CHANNEL_UPDATE"),
    CHANNEL_DELETE(1 << 0, "当channel被删除时", "CHANNEL_DELETE"),

    GUILD_MEMBERS(1 << 1, "GUILD_MEMBERS"),
    GUILD_MEMBER_ADD(1 << 1, "当成员加入时", "GUILD_MEMBER_ADD"),
    GUILD_MEMBER_UPDATE(1 << 1, "当成员资料变更时", "GUILD_MEMBER_UPDATE"),
    GUILD_MEMBER_REMOVE(1 << 1, "当成员被移除时", "GUILD_MEMBER_REMOVE"),

    GUILD_MESSAGES(1 << 9, "消息事件，仅 *私域* 机器人能够设置此 intents。", "GUILD_MESSAGES"),
    MESSAGE_CREATE(1 << 9, "发送消息事件，代表频道内的全部消息，而不只是 at 机器人的消息。内容与 AT_MESSAGE_CREATE 相同", "MESSAGE_CREATE"),
    MESSAGE_DELETE(1 << 9, "删除（撤回）消息事件", "MESSAGE_DELETE"),

    GUILD_MESSAGE_REACTIONS(1 << 10, "GUILD_MESSAGE_REACTIONS"),
    MESSAGE_REACTION_ADD(1 << 10, "为消息添加表情表态", "MESSAGE_REACTION_ADD"),
    MESSAGE_REACTION_REMOVE(1 << 10, "为消息删除表情表态", "MESSAGE_REACTION_REMOVE"),

    DIRECT_MESSAGE(1 << 12, "DIRECT_MESSAGE"),
    DIRECT_MESSAGE_CREATE(1 << 12, "当收到用户发给机器人的私信消息时", "DIRECT_MESSAGE_CREATE"),
    DIRECT_MESSAGE_DELETE(1 << 12, "删除（撤回）消息事件", "DIRECT_MESSAGE_DELETE"),

    OPEN_FORUMS_EVENT(1 << 18, "论坛事件, 此为公域的论坛事件", "OPEN_FORUMS_EVENT"),
    OPEN_FORUM_THREAD_CREATE(1 << 18, "当用户创建主题时", "OPEN_FORUM_THREAD_CREATE"),
    OPEN_FORUM_THREAD_UPDATE(1 << 18, "当用户更新主题时", "OPEN_FORUM_THREAD_UPDATE"),
    OPEN_FORUM_THREAD_DELETE(1 << 18, "当用户删除主题时", "OPEN_FORUM_THREAD_DELETE"),
    OPEN_FORUM_POST_CREATE(1 << 18, "当用户创建帖子时", "OPEN_FORUM_POST_CREATE"),
    OPEN_FORUM_POST_DELETE(1 << 18, "当用户删除帖子时", "OPEN_FORUM_POST_DELETE"),
    OPEN_FORUM_REPLY_CREATE(1 << 18, "当用户回复评论时", "OPEN_FORUM_REPLY_CREATE"),
    OPEN_FORUM_REPLY_DELETE(1 << 18, "当用户删除评论时", "OPEN_FORUM_REPLY_DELETE"),

    AUDIO_OR_LIVE_CHANNEL_MEMBER(1 << 19, "音视频/直播子频道成员进出事件", "AUDIO_OR_LIVE_CHANNEL_MEMBER"),
    AUDIO_OR_LIVE_CHANNEL_MEMBER_ENTER(1 << 19, "音视频/直播子频道成员进出事件", "AUDIO_OR_LIVE_CHANNEL_MEMBER_ENTER"),
    AUDIO_OR_LIVE_CHANNEL_MEMBER_EXIT(1 << 19, "当用户进入音视频/直播子频道", "AUDIO_OR_LIVE_CHANNEL_MEMBER_EXIT"),

    INTERACTION(1 << 26, "INTERACTION"),
    INTERACTION_CREATE(1 << 26, "互动事件创建时", "INTERACTION_CREATE"),

    MESSAGE_AUDIT(1 << 27, "MESSAGE_AUDIT"),
    MESSAGE_AUDIT_PASS(1 << 27, "消息审核通过", "MESSAGE_AUDIT_PASS"),
    MESSAGE_AUDIT_REJECT(1 << 27, "消息审核不通过", "MESSAGE_AUDIT_REJECT"),

    FORUMS_EVENT(1 << 28, "论坛事件，仅 *私域* 机器人能够设置此 intents。", "FORUMS_EVENT"),
    FORUM_THREAD_CREATE(1 << 28, "当用户创建主题时", "FORUM_THREAD_CREATE"),
    FORUM_THREAD_UPDATE(1 << 28, "当用户更新主题时", "FORUM_THREAD_UPDATE"),
    FORUM_THREAD_DELETE(1 << 28, "当用户删除主题时", "FORUM_THREAD_DELETE"),
    FORUM_POST_CREATE(1 << 28, "当用户创建帖子时", "FORUM_POST_CREATE"),
    FORUM_POST_DELETE(1 << 28, "当用户删除帖子时", "FORUM_POST_DELETE"),
    FORUM_REPLY_CREATE(1 << 28, "当用户回复评论时", "FORUM_REPLY_CREATE"),
    FORUM_REPLY_DELETE(1 << 28, "当用户删除评论时", "FORUM_REPLY_DELETE"),
    FORUM_PUBLISH_AUDIT_RESULT(1 << 28, "当用户发表审核通过时", "FORUM_PUBLISH_AUDIT_RESULT"),

    AUDIO_ACTION(1 << 29, "AUDIO_ACTION"),
    AUDIO_START(1 << 29, "音频开始播放时", "AUDIO_START"),
    AUDIO_FINISH(1 << 29, "音频播放结束时", "AUDIO_FINISH"),
    AUDIO_ON_MIC(1 << 29, "上麦时", "AUDIO_ON_MIC"),
    AUDIO_OFF_MIC(1 << 29, "下麦时", "AUDIO_OFF_MIC"),

    PUBLIC_GUILD_MESSAGES(1 << 30, "消息事件，此为公域的消息事件", "PUBLIC_GUILD_MESSAGES"),
    AT_MESSAGE_CREATE(1 << 30, "当收到@机器人的消息时", "AT_MESSAGE_CREATE"),
    PUBLIC_MESSAGE_DELETE(1 << 30, "当频道的消息被删除时", "PUBLIC_MESSAGE_DELETE");

    private final Integer code;
    private final String desc;
    private final String name;
    public static final HashMap<String, Intents> map = new HashMap<>();

    static {
        for (Intents intents : Intents.values()) {
            map.put(intents.name, intents);
        }
    }

    Intents() {
        this.code = null;
        this.desc = "";
        this.name = "";
    }

    Intents(Integer code) {
        this.code = code;
        this.desc = "";
        this.name = "";
    }


    Intents(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
        this.name = "";
    }

    Intents(int code, String desc, String name) {
        this.code = code;
        this.desc = desc;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Intents{" + "code=" + code + ", desc='" + desc + '\'' + '}';
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }
}
