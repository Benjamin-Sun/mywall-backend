package benjamin_sun.mywallbackend.dto;

import org.springframework.web.multipart.MultipartFile;

public class PictureUploadDTO {
    private String picName;
    private Integer picCate;
    private String userId;
    private MultipartFile file;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public PictureUploadDTO(String picName, Integer picCate, String userId, MultipartFile file) {
        this.picName = picName;
        this.picCate = picCate;
        this.userId = userId;
        this.file = file;
    }

    @Override
    public String toString() {
        return "PictureUploadDTO{" +
                "picName='" + picName + '\'' +
                ", picCate=" + picCate +
                ", userId='" + userId + '\'' +
                ", file=" + file +
                '}';
    }
}
