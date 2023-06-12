package ra.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.entity.Comment;
import ra.entity.Subscription;
import ra.entity.Videos;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long user_id;
    @Column(name = "username")
    @Size(min = 6)
    private String username;
    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @Size(min = 6)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions = new ArrayList<>();
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Videos> listVideos;

    public Users(String username, String email, String password, List<Comment> comments, List<Subscription> subscriptions, Set<Roles> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.comments = comments;
        this.subscriptions = subscriptions;
        this.roles = roles;
    }

    public Users( String username, String email, String password, Set<Roles> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

}
