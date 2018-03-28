package step12.ex1;

public class Exam01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(5);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        
        print(list); // aaa, bbb, ccc, ddd,
        
        list.remove(2);
        
        print(list); // aaa, bbb, ddd,
       
        list.remove(0);
        
        print(list); // bbb, ddd
        
        list.remove(4);
        
        print(list);
        
        list.add(1, "xxx"); // bbb, xxx, ddd, 
        list.add(1, "yyy"); // bbb, yyy, xxx, ddd
        list.add(0, "zzz"); // zzz, bbb, yyy, xxx, ddd
        list.add(5, "ttt"); // zzz, bbb, yyy, xxx, ddd
        
        print(list);
        
        list.set(1, "aaa"); // zzz, aaa, yyy, xxx, ddd
        
        print(list);
        
        list.add("ccc");
        list.add("eee");
        list.add("eee");
        list.add("eee");
        list.add("eee");
        list.add("eee");
        list.add("eee");
        list.add("eee");
        list.add("eee");
        
        print(list);
    }
    static void print(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.println();
    }

}
