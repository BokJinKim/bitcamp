// java.util.HashMap - key 목록을 사용하여 맵에서 값을 꺼내기
package step12.ex6;

import java.util.Hashtable;
import java.util.Set;

public class Exam03_3 {
    public static void main(String[] args) {
        Member v1 = new Member("홍길동", 20);
        Member v2 = new Member("임꺽정", 30);
        Member v3 = new Member("유관순", 16);
        Member v4 = new Member("안중근", 20);
        Member v5 = new Member("윤봉길", 25);
        
        Hashtable table = new Hashtable();
        table.put("s01", v1);
        table.put("s02", v2);
        table.put("s03", v3);
        table.put("s04", v4);
        table.put("s05", v5);
        
        Set keys = table.keySet();
        
        table.remove("s01");
        table.remove("s02");
        table.remove("s03");
        
        for (Object key : keys) {
            System.out.println(key);
        }
    }

}

