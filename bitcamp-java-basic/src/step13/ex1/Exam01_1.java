package step13.ex1;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam01_1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Member("홍길동", 20));
        list.add(new String("Hello"));
        list.add(new Integer(100));
        list.add(new HashSet());
        Member member = (Member)list.get(0);
        System.out.println(member.name);
        System.out.println(member.age);
        
    }

}
