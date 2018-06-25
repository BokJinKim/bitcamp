package bitcamp.mvc.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import bitcamp.mvc.vo.Board;
import bitcamp.mvc.vo.Member;

@Repository
public class BoardDao {
    
    public BoardDao() {
        System.out.println("====> BoardDao()");
        Member writer = new Member();
        writer.setId("hong");
        writer.setEmail("hong@test.com");
        
        Board b1 = new Board();
        b1.setNo(1);
        b1.setTitle("제목입니다!");
        b1.setUser(writer);
        b1.setCreatedDate(Date.valueOf("2018-6-22"));
        list.add(b1);
        
        b1 = new Board();
        b1.setNo(2);
        b1.setTitle("제목입니다!2");
        b1.setUser(writer);
        b1.setCreatedDate(Date.valueOf("2018-6-22"));
        list.add(b1);
        
        b1 = new Board();
        b1.setNo(3);
        b1.setTitle("제목입니다!3");
        b1.setUser(writer);
        b1.setCreatedDate(Date.valueOf("2018-6-22"));
        list.add(b1);
        
        b1 = new Board();
        b1.setNo(4);
        b1.setTitle("제목입니다!4");
        b1.setUser(writer);
        b1.setCreatedDate(Date.valueOf("2018-6-22"));
        list.add(b1);
        
        b1 = new Board();
        b1.setNo(5);
        b1.setTitle("제목입니다!5");
        b1.setUser(writer);
        b1.setCreatedDate(Date.valueOf("2018-6-22"));
        list.add(b1);
    }
    
    ArrayList<Board> list = new ArrayList<>();
    
    public void insert(Board board) {
        list.add(board);
    }
    
    public List<Board> selectList() {
        return list;
    }
}
