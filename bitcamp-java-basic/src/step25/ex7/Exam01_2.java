// 트랜잭션(transaction) - auto commit
package step25.ex7;

import java.sql.DriverManager;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/java106db",
                "java106", "1111");
        
        // 커넥션을 사용하기 전에 auto commit을 false로 설정하라!
        
        java.sql.PreparedStatement stmt = con.prepareStatement(
                "insert into ex_board(bno,titl,cont,rdt) values(?,?,?,now())");
        con.setAutoCommit(false);
        
        stmt.setInt(1, 111);
        stmt.setString(2, "1111");
        stmt.setString(3, "xxxx");
        stmt.executeUpdate();
        System.out.println("입력 성공!");
        
        stmt.setInt(1, 112);
        stmt.setString(2, "1111");
        stmt.setString(3, "xxxx");
        stmt.executeUpdate();
        System.out.println("입력 성공!");
        
        stmt.setInt(1, 113);
        stmt.setString(2, "1111");
        stmt.setString(3, "xxxx");
        stmt.executeUpdate();
        System.out.println("입력 성공!");
        
        // 이렇게 commit을 해야만 DB의 연결을 끊기 전에
        // 임시 저장소에 보관된 변경 작업 결과(insert|update|delete)를
        // 실제 테이블에 적용한다.
        con.commit();
        
        stmt.close();
        con.close();
        System.out.println("입력 완료!");
    }
}







