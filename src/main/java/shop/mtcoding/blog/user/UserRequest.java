package shop.mtcoding.blog.user;

import lombok.Data;

public class UserRequest {
/**
* 요청 DTO = Data Transfer Object
 */
@Data //getter, setter 다들고 있는 어노테이션
    public static class JoinDto { //user한테 요청되는 가입 데이터
        private String username;
        private String password;
        private String email;
    }

    @Data //getter, setter 다들고 있는 어노테이션
    public static class LoginDto { //user한테 요청 되는 로그인 데이터
        private String username;
        private String password;
    }
}
