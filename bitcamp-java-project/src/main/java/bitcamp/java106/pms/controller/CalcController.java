// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;

@Component("calc")
public class CalcController implements Controller {
    Scanner keyScan;
    
    public CalcController(Scanner scanner) {
        this.keyScan = scanner;
    }
    
    public void service(String menu, String option) {
        System.out.println("식을 입력하세요? ");
        System.out.println("ex : a + b");
        String[] arr = keyScan.nextLine().split(" ");
        if (arr.length != 3) {
            System.out.println("ex 입력");
        }
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        String op = arr[1];
        int result = 0;
        
        switch (op) {
        case "+": result = a + b; break;
        case "-": result = a - b; break;
        case "*": result = a * b; break;
        case "/": result = a / b; break;
        default:
            System.out.println("재입력");
        }
        System.out.printf("%d %s %d = %d\n", a, op, b, result);
    }
}

//ver 23 - 유지보수 테스트를 위해 임시로 만듦.