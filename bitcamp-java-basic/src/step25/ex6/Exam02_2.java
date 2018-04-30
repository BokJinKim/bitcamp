// Mybatis - 자바 객체의 프로퍼티 이름과 컬럼명을 일치시키기 II
package step25.ex6;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam02_2 {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(
                "step25/ex6/mybatis-config05.xml");
        SqlSessionFactory factory = 
                new SqlSessionFactoryBuilder().build(inputStream);
        
        SqlSession sqlSession = factory.openSession();
        
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("limitSQL", "limit 9, 3");
        paramMap.put("pageSize", 3);
        List<Board> list = 
                sqlSession.selectList("BoardMapper.selectBoard", paramMap);
        
        for (Board board : list) {
            System.out.printf("%d, %s, %s, %s\n", 
                    board.getNo(), 
                    board.getTitle(), 
                    board.getContent(),
                    board.getRegisteredDate());
        }
        
        sqlSession.close();
    }

}











