package shop.mtcoding.blog.board;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

public class BoardResponse {

    //bt.id, bt.content, bt.title, bt.created_at, ut.id uid, ut.username
    @AllArgsConstructor
    @Data
    //쿼리 순서랑 똑같이 해야된다.
    public static class DetailDTO{
        private Integer id;
        private String title;
        private String content;
        private Timestamp createdAt;
        private Integer userId; //작성자 id
        private String username;
    }
}
