package bitcamp.java106.pms.domain;

import java.sql.Date;
import java.util.Arrays;

// Team 클래스
// => 팀 정보를 저장할 수 있는 메모리를 구조를 설계한 클래스이다.
// => 즉 팀 정보를 위해 사용자(자바 언어 사용자. 즉 개발자)가 새로 정의한 데이터 타입이다.
//
public class ClassRoom {
    private int no;
    private String title;
    private Date startDate;
    private Date endDate;
    private String classNo;
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getClassNo() {
        return classNo;
    }
    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }
    
    
    
    // 사용자 정의 데이터 타입에서 메서드 정의란?
    // => 새 데이터 타입의 값을 다룰 연산자를 정의하는 것을 의미한다.
    

}

//ver 16 - 캡슐화 적용. 겟터, 셋터 추가.
//ver 15 - 멤버를 저장할 인스턴스 변수를 추가한다.
//          팀 멤버 배열에 멤버 객체를 추가하고 빼는 메서드를 새로 정의한다.
//ver 13 - 시작일, 종료일의 데이터 타입을 String에서 Date으로 변경