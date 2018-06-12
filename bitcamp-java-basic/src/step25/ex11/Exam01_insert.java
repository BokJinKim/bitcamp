// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
package step25.ex11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(""
                        + "step25/ex11/application-context.xml");
        BoardService boardService = iocContainer.getBean(BoardService.class);
        
        Board b1 = new Board().setNo(191).setTitle("1111").setContent("xxxxx");
        Board b2 = new Board().setNo(192).setTitle("1111").setContent("xxxxx");
        Board b3 = new Board().setNo(193).setTitle("1111").setContent("xxxxx");
        Board b4 = new Board().setNo(191).setTitle("1111").setContent("xxxxx");
        Board b5 = new Board().setNo(195).setTitle("1111").setContent("xxxxx");
        
        boardService.test1(b1, b2, b3, b4, b5);
        
    }
}







