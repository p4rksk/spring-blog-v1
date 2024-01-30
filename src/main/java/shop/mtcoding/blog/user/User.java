package shop.mtcoding.blog.user;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //getter,setter to string
@Entity
@Table(name = "user_tb") //테이블명
public class User {
    @Id // prrimary
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement (자동증가)
    private int id;

    @Column(unique = true)
    private String username;

    @Column(length = 60, nullable = false)
    private String password;
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
