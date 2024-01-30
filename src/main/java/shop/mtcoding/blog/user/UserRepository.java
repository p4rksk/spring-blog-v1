package shop.mtcoding.blog.user;

import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository //이 어노테이션을 붙이면 em을 들고있는 UserRepository가 ioc에 뜬다. (DAO)
public class UserRepository {
    private EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }


    @Transactional
    public void save(UserRequest.JoinDto requestDTO){
        System.out.println("UserRepository에 save 메서드 호출됨");
        Query query = em.createNativeQuery("insert into user_tb(username, password, email) values(?, ?, ?)");
        query.setParameter(1, requestDTO.getUsername());
        query.setParameter(2, requestDTO.getPassword());
        query.setParameter(3, requestDTO.getEmail());

        query.executeUpdate();
    }

    @Transactional
    public void save2(UserRequest.JoinDto requestDTO){ //통신으로 받은 데이터를 Entity에 옮기기
        User user = new User();
        user.setUsername(requestDTO.getUsername());
        user.setPassword(requestDTO.getPassword());
        user.setEmail(requestDTO.getEmail());
        em.persist(user);
    }

    public User findByUsernameAndPassword(UserRequest.JoinDto requestDTO) {
        Query query = em.createNativeQuery("select * from user_tb where username=? and password=?", User.class); //
        query.setParameter(1, requestDTO.getUsername());
        query.setParameter(2, requestDTO.getPassword());


        User user = (User) query.getSingleResult(); //single Result는 한건
        return user;
    }
}


