package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.user.User;

import java.sql.Timestamp;

@Data // SET, GET, ToString
@Entity // 깃발을 꼽는 으로 이해하면될듯
@Table(name = "board_tb") // 테이블 이름 설정
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;

    @ManyToOne
    private User user;

    @CreationTimestamp
    private Timestamp createdAt;
}