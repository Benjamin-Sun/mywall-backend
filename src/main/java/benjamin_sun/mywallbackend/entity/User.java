package benjamin_sun.mywallbackend.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "userInfo")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPwd")
    private String userPwd;

    @Column(name = "userAge")
    private Integer userAge;

    @Column(name = "userSex")
    private Integer userSex;

    @Column(name = "userDisc")
    private String userDisc;

    @Column(name = "userCate")
    private Integer userCate;

    @Column(name = "userImg")
    private String userImg;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserDisc() {
        return userDisc;
    }

    public void setUserDisc(String userDisc) {
        this.userDisc = userDisc;
    }

    public Integer getUserCate() {
        return userCate;
    }

    public void setUserCate(Integer userCate) {
        this.userCate = userCate;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public User(String userName, String userPwd, Integer userAge, Integer userSex, String userDisc, Integer userCate, String userImg) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userDisc = userDisc;
        this.userCate = userCate;
        this.userImg = userImg;
    }

    public User(String userName, String userPwd, Integer userAge, Integer userSex, Integer userCate) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userCate = userCate;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userAge=" + userAge +
                ", userSex=" + userSex +
                ", userDisc='" + userDisc + '\'' +
                ", userCate=" + userCate +
                ", userImg='" + userImg + '\'' +
                '}';
    }
}
