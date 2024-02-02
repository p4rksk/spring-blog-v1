package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
@Data //getter,setter to string
@Entity //실행시 테이블 만들어주는 어노테이션, 나중에 호출 시에 쿼리를 담을 수 있는 그릇이 되기도한다.
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
