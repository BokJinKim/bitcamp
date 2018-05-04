package bitcamp.java106.step04;

public class Engine {
    String maker;
    int value;
    int cylinder;
    
    public Engine() {
        System.out.println("Engine() 생성자 호출됨!");
    }
    
    @Override
    public String toString() {
        return "Engine [maker=" + maker + ", value=" + value + ", cylinder=" + cylinder + "]";
    }
    
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        System.out.println("Engine().setMaker() 생성자 호출됨!");
        this.maker = maker;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
        System.out.println("Engine().setValue() 생성자 호출됨!");
    }
    public int getCylinder() {
        return cylinder;
    }
    public void setCylinder(int cylinder) {
        System.out.println("Engine().setCylinder 생성자 호출됨!");
        this.cylinder = cylinder;
    }

}
