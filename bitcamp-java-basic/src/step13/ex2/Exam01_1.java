// LinkedList 구현과 사용
package step13.ex2;

public class Exam01_1 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Member("홍길동", 20));
        list.add(new Member("임꺽정", 20));
        list.add(new Member("유관순", 20));
        
        for (int i = 0; i < list.size(); i++) {
            Member member = (Member) list.get(i);
            System.out.printf("%s(%d)\n", member.name, member.age);
        }
    }
}     
   