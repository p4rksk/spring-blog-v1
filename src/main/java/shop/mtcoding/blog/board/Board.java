package shop.mtcoding.blog.board;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data //getter,setter to string
@Entity //실행시 테이블 만들어주는 어노테이션
@Table(name = "board_tb") //테이블명
public class Board {
    @Id // prrimary
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement (자동증가)
    private int id;
    private String title;
    private String content;
    private int userId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
