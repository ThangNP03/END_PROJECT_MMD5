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
    private int statusCode;
    @Column(name = "status")
    private boolean status = setStatus();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        switch (this.statusCode){
            case 0:
            case 1:
            case 2:
            case 3: return true;
            default: return false;
        }
    }

    public boolean setStatus() {
        switch (this.statusCode){
            case 0: return false;
            case 1:
            case 2:
            case 3: return true;
            default: return false;
        }

    }
}
