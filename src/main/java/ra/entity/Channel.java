package ra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.entity.user.Users;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "channel")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_id")
    private Long channel_id;
    @Column(name = "chanel_name")
    private String chanel_name;
    @Column(name = "create_at")
    private Date create_at;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    

}
