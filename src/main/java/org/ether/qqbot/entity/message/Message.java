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
    private String id; // ��Ϣ id
    private String channel_id; // ��Ƶ�� id
    private String guild_id; // Ƶ�� id
    private String content; // ��Ϣ����
    private String image; // ͼ������
    private String timestamp; // ��Ϣ����ʱ��
    private String edited_timestamp; // ��Ϣ�༭ʱ��
    private Boolean mention_everyone; // �Ƿ���@ȫԱ��Ϣ
    private User author; // ��Ϣ������
    private MessageAttachment[] attachments; // ����
    private MessageEmbed[] embeds; // embed
    private User[] mentions; // ��Ϣ��@����
    private Member member; // ��Ϣ�����ߵ�member��Ϣ
    private MessageArk ark; // ark��Ϣ
    private Integer seq; // ������Ϣ�������seq ��ͬһ��Ƶ���а����ȵ����˳���������ͬ����Ƶ��֮����Ϣ�޷�����(Ŀǰֻ����Ϣ�¼�����ֵ��2022��8��1�� ��������)
    private String seq_in_channel; // ��Ƶ����Ϣ seq��������Ϣ�������seq ��ͬһ��Ƶ���а����ȵ����˳���������ͬ����Ƶ��֮����Ϣ�޷�����
    private MessageReference message_reference; // ������Ϣ����
    private String src_guild_id; // ����˽�ų�����ʶ����ʵ����ԴƵ��id
}
