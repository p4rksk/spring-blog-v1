package shop.mtcoding.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private  final EntityManager em;

    public List<Board> findAll(int page){
        final int COUNT = 3;
        int value = page*3;
        Query query = em.createNativeQuery("select * from board_tb order by id desc limit ?,?", Board.class);
        query.setParameter(1, value);
        query.setParameter(2, COUNT);

        List<Board> boardList = query.getResultList();

        return boardList;
    }
    public int count(){
        Query query = em.createNativeQuery("select count(*) from board_tb");

        BigInteger count = (BigInteger) query.getSingleResult();

        return count.intValue();
    }
}