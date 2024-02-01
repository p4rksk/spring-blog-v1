package shop.mtcoding.blog;

import org.junit.jupiter.api.Test;

public class PagingTest {

    //토탈 페이지를 구하시오.
    //한 페이지에는 3개의 아이템이 담길 수 있습니다.
    //아이템은 총 8개가 있습니다.
    //토탈 페이지는 몇 개가 필요할까요?
    @Test
    public void count(){
        //토탈 페이지 구하기
        //안나눠 떨어지면 +1하기
        int boardtotalCount = 8;
        int pagingCount = 3;

        //1. 나머지 여부 확인
        int remainCount = boardtotalCount % pagingCount;
        System.out.println(remainCount);

        int totalPageCount = boardtotalCount;
        //2. 나머지가 있다면?
        if (remainCount > 0){

        }


        //3. 나머지가 없다면?
        if (remainCount == 0){

        }


    }
}
