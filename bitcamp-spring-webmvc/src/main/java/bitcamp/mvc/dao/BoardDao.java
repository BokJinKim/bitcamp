package bitcamp.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import bitcamp.mvc.vo.Board;

@Repository
public class BoardDao {
    
    public BoardDao() {
        System.out.println("====> BoardDao()");
    }
    
    ArrayList<Board> list = new ArrayList<>();
    
    public void insert(Board board) {
        list.add(board);
    }
    
    public List<Board> selectList() {
        return list;
    }

}
