package benjamin_sun.mywallbackend.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userLikeInfo")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UserLike implements Serializable {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String userLikeId;

    @Column(name = "picId")
    private String picId;

    @Column(name = "userId")
    private String userId;

    @Override
    public String toString() {
        return "UserLike{" +
                "userLikeId='" + userLikeId + '\'' +
                ", picId='" + picId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
