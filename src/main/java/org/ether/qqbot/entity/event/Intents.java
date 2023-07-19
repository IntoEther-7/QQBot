package org.ether.qqbot.entity.event;

/**
 * @author IntoEther-7
 * @date 2023/7/7 15:57
 * @project ZhihuProject
 */
public enum Intents {
    READY,



    GUILDS(1 << 0),
    GUILD_CREATE(1 << 0, "�������˼�����guildʱ"),
    GUILD_UPDATE(1 << 0, "��guild���Ϸ������ʱ"),
    GUILD_DELETE(1 << 0, "���������˳�guildʱ"),
    CHANNEL_CREATE(1 << 0, "��channel������ʱ"),
    CHANNEL_UPDATE(1 << 0, "��channel������ʱ"),
    CHANNEL_DELETE(1 << 0, "��channel��ɾ��ʱ"),

    GUILD_MEMBERS(1 << 1),
    GUILD_MEMBER_ADD(1 << 1, "����Ա����ʱ"),
    GUILD_MEMBER_UPDATE(1 << 1, "����Ա���ϱ��ʱ"),
    GUILD_MEMBER_REMOVE(1 << 1, "����Ա���Ƴ�ʱ"),

    GUILD_MESSAGES(1 << 9, "��Ϣ�¼����� *˽��* �������ܹ����ô� intents��"),
    MESSAGE_CREATE(1 << 9, "������Ϣ�¼�������Ƶ���ڵ�ȫ����Ϣ������ֻ�� at �����˵���Ϣ�������� AT_MESSAGE_CREATE ��ͬ"),
    MESSAGE_DELETE(1 << 9, "ɾ�������أ���Ϣ�¼�"),

    GUILD_MESSAGE_REACTIONS(1 << 10),
    MESSAGE_REACTION_ADD(1 << 10, "Ϊ��Ϣ��ӱ����̬"),
    MESSAGE_REACTION_REMOVE(1 << 10, "Ϊ��Ϣɾ�������̬"),

    DIRECT_MESSAGE(1 << 12),
    DIRECT_MESSAGE_CREATE(1 << 12, "���յ��û����������˵�˽����Ϣʱ"),
    DIRECT_MESSAGE_DELETE(1 << 12, "ɾ�������أ���Ϣ�¼�"),

    OPEN_FORUMS_EVENT(1 << 18, "��̳�¼�, ��Ϊ�������̳�¼�"),
    OPEN_FORUM_THREAD_CREATE(1 << 18, "���û���������ʱ"),
    OPEN_FORUM_THREAD_UPDATE(1 << 18, "���û���������ʱ"),
    OPEN_FORUM_THREAD_DELETE(1 << 18, "���û�ɾ������ʱ"),
    OPEN_FORUM_POST_CREATE(1 << 18, "���û���������ʱ"),
    OPEN_FORUM_POST_DELETE(1 << 18, "���û�ɾ������ʱ"),
    OPEN_FORUM_REPLY_CREATE(1 << 18, "���û��ظ�����ʱ"),
    OPEN_FORUM_REPLY_DELETE(1 << 18, "���û�ɾ������ʱ"),

    AUDIO_OR_LIVE_CHANNEL_MEMBER(1 << 19, "����Ƶ/ֱ����Ƶ����Ա�����¼�"),
    AUDIO_OR_LIVE_CHANNEL_MEMBER_ENTER(1 << 19, "����Ƶ/ֱ����Ƶ����Ա�����¼�"),
    AUDIO_OR_LIVE_CHANNEL_MEMBER_EXIT(1 << 19, "���û���������Ƶ/ֱ����Ƶ��"),

    INTERACTION(1 << 26),
    INTERACTION_CREATE(1 << 26, "�����¼�����ʱ"),

    MESSAGE_AUDIT(1 << 27),
    MESSAGE_AUDIT_PASS(1 << 27, "��Ϣ���ͨ��"),
    MESSAGE_AUDIT_REJECT(1 << 27, "��Ϣ��˲�ͨ��"),

    FORUMS_EVENT(1 << 28, "��̳�¼����� *˽��* �������ܹ����ô� intents��"),
    FORUM_THREAD_CREATE(1 << 28, "���û���������ʱ"),
    FORUM_THREAD_UPDATE(1 << 28, "���û���������ʱ"),
    FORUM_THREAD_DELETE(1 << 28, "���û�ɾ������ʱ"),
    FORUM_POST_CREATE(1 << 28, "���û���������ʱ"),
    FORUM_POST_DELETE(1 << 28, "���û�ɾ������ʱ"),
    FORUM_REPLY_CREATE(1 << 28, "���û��ظ�����ʱ"),
    FORUM_REPLY_DELETE(1 << 28, "���û�ɾ������ʱ"),
    FORUM_PUBLISH_AUDIT_RESULT(1 << 28, "���û��������ͨ��ʱ"),

    AUDIO_ACTION(1 << 29),
    AUDIO_START(1 << 29, "��Ƶ��ʼ����ʱ"),
    AUDIO_FINISH(1 << 29, "��Ƶ���Ž���ʱ"),
    AUDIO_ON_MIC(1 << 29, "����ʱ"),
    AUDIO_OFF_MIC(1 << 29, "����ʱ"),

    PUBLIC_GUILD_MESSAGES(1 << 30, "��Ϣ�¼�����Ϊ�������Ϣ�¼�"),
    AT_MESSAGE_CREATE(1 << 30, "���յ�@�����˵���Ϣʱ"),
    PUBLIC_MESSAGE_DELETE(1 << 30, "��Ƶ������Ϣ��ɾ��ʱ");

    private final int code;
    private final String desc;

    Intents() {
        this.code = 0;
        this.desc = "";
    }

    Intents(int code) {
        this.code = code;
        this.desc = "";
    }

    Intents(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Intents{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
