// Spring과 Mybatis 연동 : mybatis에서 제공해주는 spring 연동 라이브러리 사용하기
package bitcamp.java106.step12.ex3;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;
import bitcamp.java106.step12.Board;

public class Exam01 {

    public static void main(String[] args) {
        // 우리가 직접 스프링 Ioc 컨테이너에서 사용할
        // SqlSessionFactory 빌더 클래스를 만들 필요가 없다.
        // mybatis 팀에서 제공해주는 FactoryBean을 사용하자!
        // 1) mvnrepository.com 에서 mybatis-spring라이브러리 검색
        // 2) "build.gradle" 에 의존 라이브러리 정보 추가
        // 3) "gradle eclipse" 실행
        // 4) 이클립스 프로젝트 갱신
        // 5) 이 라이브러리에서 제공하는 FactoryBean 사용!
        
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step12/ex3/application-context.xml");
        
        BeanUtils.printBeanNames(iocContainer);
    
        BoardDao boardDao = iocContainer.getBean(BoardDao.class); 
        
        //1) 게시물 입력
        Board board = new Board();
        board.setTitle("제목입니다.");
        board.setContent("내용입니다.");
        boardDao.insert(board);

        //2) 게시물 조회
        List<Board> list = boardDao.selectList(1, 5);
        for (Board b : list) {
            System.out.printf("%d, %s, %s\n",
                    b.getNo(),
                    b.getTitle(),
                    b.getRegisteredDate());
        }
    }
}





