package benjamin_sun.mywallbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "forumInfo")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Forum implements Serializable {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String forumId;

    @Column(name = "forumName")
    private String forumName;

    @Column(name = "userId")
    private String userId;

    @Column(name = "picId")
    private String picId;

    @Column(name = "messageDisc")
    private String messageDisc;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "updateTime")
    private Date updateTime;

    public String getForumId() {
        return forumId;
    }

    public void setForumId(String forumId) {
        this.forumId = forumId;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getMessageDisc() {
        return messageDisc;
    }

    public void setMessageDisc(String messageDisc) {
        this.messageDisc = messageDisc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Forum(String forumId, String forumName, String userId, String picId, String messageDisc, Date createTime, Date updateTime) {
        this.forumId = forumId;
        this.forumName = forumName;
        this.userId = userId;
        this.picId = picId;
        this.messageDisc = messageDisc;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Forum(String forumName, String userId, String picId, String messageDisc) {
        this.forumName = forumName;
        this.userId = userId;
        this.picId = picId;
        this.messageDisc = messageDisc;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public Forum() {
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forumId='" + forumId + '\'' +
                ", userId='" + userId + '\'' +
                ", picId='" + picId + '\'' +
                ", messageDiscl='" + messageDisc + '\'' +
                '}';
    }
}
