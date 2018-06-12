// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
package step25.ex10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(""
                        + "step25/ex10/application-context.xml");
        BoardService boardService = iocContainer.getBean(BoardService.class);
        
        Board b1 = new Board();
        b1.setNo(171);
        b1.setTitle("1111");
        b1.setContent("xxxx");
        
        Board b2 = new Board();
        b2.setNo(172);
        b2.setTitle("2222");
        b2.setContent("xxxx");
        
        Board b3 = new Board();
        b3.setNo(171);
        b3.setTitle("3333");
        b3.setContent("xxxx");
        
        // test1()은 트랜잭션 매니저가 관리하기 때문에
        // 실행 중에 오류가 발생하면 그 전에 실행했던 모든 결과를 취소(rollback)한다.
        // 오류가 없어야만 commit 한다.
        
        // 그러나 test2()는 트랜잭션 매니저의 관리 대상이 아니기 때문에
        // 실행 중에 오류가 발생하면 그 전까지 실행된 결과를 그대로 유지한다.
        boardService.test2(b1, b2, b3);
        
        System.out.println("입력 성공!");
    }
}







