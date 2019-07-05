package benjamin_sun.mywallbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "picInfo")
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Picture implements Serializable {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String picId;

    @Column(name = "picName")
    private String picName;

    @Column(name = "picCate")
    private Integer picCate;

    @Column(name = "viewTimes")
    private Integer viewTimes = 0;

    @Column(name = "userId")
    private String userId;

    @Column(name = "uploadTime")
    private Date uploadTime;

    @Column(name = "favoTimes")
    private Integer favoTimes = 0;

    @Column(name = "imagePath")
    private String imagePath;

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public Integer getPicCate() {
        return picCate;
    }

    public void setPicCate(Integer picCate) {
        this.picCate = picCate;
    }

    public Integer getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(Integer viewTimes) {
        this.viewTimes = viewTimes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getFavoTimes() {
        return favoTimes;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String image) {
        this.imagePath = image;
    }

    public void setFavoTimes(Integer favoTimes) {
        this.favoTimes = favoTimes;
    }

    public Picture(String picName, Integer picCate, String userId) {
        this.picName = picName;
        this.picCate = picCate;
        this.userId = userId;
        this.uploadTime = new Date();
    }

    public Picture() {
        this.uploadTime = new Date();
    }

    public Picture(String picName, Integer picCate, Integer viewTimes, String userId, Integer favoTimes, String imagePath) {
        this.picName = picName;
        this.picCate = picCate;
        this.viewTimes = viewTimes;
        this.userId = userId;
        this.uploadTime = new Date();
        this.favoTimes = favoTimes;
        this.imagePath = imagePath;
    }

    //用于数据库查询的构造参数
    public Picture(String picId, String picName, Integer picCate, Integer viewTimes, String userId, Date uploadTime, Integer favoTimes, String imagePath) {
        this.picId = picId;
        this.picName = picName;
        this.picCate = picCate;
        this.viewTimes = viewTimes;
        this.userId = userId;
        this.uploadTime = uploadTime;
        this.favoTimes = favoTimes;
        this.imagePath = imagePath;
    }


    @Override
    public String toString() {
        return "Picture{" +
                "picId='" + picId + '\'' +
                ", picName='" + picName + '\'' +
                ", picCate=" + picCate +
                ", viewTimes=" + viewTimes +
                ", userId='" + userId + '\'' +
                ", uploadTime=" + uploadTime +
                ", favoTimes=" + favoTimes +
                '}';
    }
}
