package ra.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.entity.user.Users;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Videos")
public class Videos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Long video_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "likes")
    private Long like;

    @Column(name = "disLikes")
    private Long disLikes;

    @Column(name = "is_status")
    private boolean status;

    @Column(name = "viewss")
    private int views;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
