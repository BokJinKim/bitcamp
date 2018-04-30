package step25.ex1;

import java.sql.DriverManager;

public class Exam03_4 {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106","1111"); 
        System.out.println("dbms와 연결됨");
        
        java.sql.Statement stmt = con.createStatement();
        
        java.sql.ResultSet rs = stmt.executeQuery(
            "select bno,titl,cont,rdt from ex_board");

        boolean isReceived = rs.next();
        
        while (rs.next()) {
        System.out.printf("%d,%s,%s,%s\n",
                rs.getInt("bno"),
                rs.getString("titl"),
                rs.getString("cont"),
                rs.getDate("rdt"));
                                                                                                                             }
        rs.close();
        stmt.close();
        con.close();
    }
}







