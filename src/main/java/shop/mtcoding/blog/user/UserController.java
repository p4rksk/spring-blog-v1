package shop.mtcoding.blog.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




/**
 * 컨트롤러
 * 1. 요청받기 (URL - URI포함)
 * 2. http body는 어떻게 (DTO)
 * 3. 기본 MIME 전략 : X-www.form-urlencoded(username=ssar@password=1234)
 * 4. 유효성 검사하기 (BODY 데이터가 있다면)
 * 5. 클라이언트가 view(mustache)만 원하는지? 혹은 DB 처리 후 View도 원하는지?
 * 6. view만 원하면 view를 응답하면 끝
 * 7. DB처리를 원하면 Model(DAO)에게 위임후 view를 응답하면 끝
 */
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserRepository userRepository;
    private final HttpSession session;



    @PostMapping("/login")// login은 select인데 예외로 post요청
    public String login(UserRequest.JoinDto requestDTO){
        //1. 유효성 검사
        if (requestDTO.getUsername().length() < 3){
            return "error/400";
        }

        //2. 모델 필요 select * from user_tb where username = ? and password=?
        User user = userRepository.findByUsernameAndPassword(requestDTO);

        if (user == null){
            return "error/401";
        }else{
            session.setAttribute("sessionUser",user);
            return "redirect:/";
        }



    }
    @PostMapping("/join")
    public String join(UserRequest.JoinDto requestDTO){
        System.out.println(requestDTO);

        //1. 유효성 검사
        if (requestDTO.getUsername().length() < 3){
            return "error/400";
        }



        //2. 동일 username체크 (유효성 검사랑 다르다. 비즈니스 코드라 명칭한다.) (나중에 하나의 트랜잭션으로 묶는 것이 좋다.)
        User user = userRepository.findByUsernameAndPassword(requestDTO.getUsername());
        if (user==null){
            userRepository.save(requestDTO);
        }else{
            return "error/400";
        }


        //3. Model에게 위임하기.

            userRepository.save2(requestDTO);




        return "redirect:/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();//서랍안에 있는 내용을 다삭제
        return "redirect:/";
    }
}
