package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Hashtag implements Serializable {
    private static final long serialVersionUID = 1L;

    
    private String no;
    private String Hashtag;
    
    
    
    @Override
    public String toString() {
        return "Hashtag [no=" + no + ", Hashtag=" + Hashtag + "]";
    }
    
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getHashtag() {
        return Hashtag;
    }
    public void setHashtag(String hashtag) {
        Hashtag = hashtag;
    }
    
    
    
    
}

//ver 31 - 생성자 제거 및 count 변수 제거
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - setNo() 변경
//ver 18 - 게시물 객체의 고유 번호(no)를 static 변수(count)를 이용하여 자동 설정한다. 
// ver 16 - 캡슐화 적용. 겟터, 셋터 추가.
// ver 13 - 등록일의 데이터 타입을 String에서 Date으로 변경






