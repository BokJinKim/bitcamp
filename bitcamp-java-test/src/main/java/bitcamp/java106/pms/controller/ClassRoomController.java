package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.ClassRoomDao;
import bitcamp.java106.pms.domain.ClassRoom;
import bitcamp.java106.pms.util.Console;

public class ClassRoomController {
    Scanner keyScan;

    ClassRoomDao classRoomDao = new ClassRoomDao();
    
    public ClassRoomController(Scanner scanner) {
        this.keyScan = scanner;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("classRoom/add")) {
            this.onClassRoomAdd();
        } else if (menu.equals("classRoom/list")) {
            this.onClassRoomList();
        } else if (menu.equals("classRoom/view")) {
            //this.onClassRoomView(option);
        } else if (menu.equals("classRoom/update")) {
            //this.onClassRoomUpdate(option);
        } else if (menu.equals("classRoom/delete")) {
            //this.onClassRoomDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    void onClassRoomAdd() {
        System.out.println("[수업 등록]");
        ClassRoom classRoom = new ClassRoom();

        System.out.print("수업명? ");
        classRoom.setTitle(this.keyScan.nextLine());

        System.out.print("시작일? ");
        classRoom.setStartDate(Date.valueOf(this.keyScan.nextLine()));
        
        System.out.print("종료일? ");
        classRoom.setEndDate(Date.valueOf(this.keyScan.nextLine()));
        
        System.out.print("교실번호? ");
        classRoom.setClassNo(this.keyScan.nextLine());

        classRoomDao.insert(classRoom);
    }

    void onClassRoomList() {
        System.out.println("[수업 목록]");
        ClassRoom[] list = classRoomDao.list();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) continue;
            System.out.printf("%d, %s, %s ~ %s, %s\n",
                i, list[i].getTitle(), list[i].getStartDate(), 
                list[i].getEndDate(), list[i].getClassNo());
        }
    }
/*
    void onClassRoomView(String option) {
        System.out.println("[게시물 조회]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        ClassRoom classRoom = classRoomDao.get(Integer.parseInt(option));
        
        if (classRoom == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            System.out.printf("팀명: %s\n", classRoom.getTitle());
            System.out.printf("설명: %s\n", classRoom.getContent());
            System.out.printf("등록일: %s\n", classRoom.getCreatedDate());
        }
    }

    void onClassRoomUpdate(String option) {
        System.out.println("[게시물 변경]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        ClassRoom classRoom = classRoomDao.get(Integer.parseInt(option));
        
        if (classRoom == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            ClassRoom updateClassRoom = new ClassRoom();
            System.out.printf("제목(%s)? ", classRoom.getTitle());
            updateClassRoom.setTitle(this.keyScan.nextLine());
            System.out.printf("설명(%s)? ", classRoom.getContent());
            updateClassRoom.setContent(this.keyScan.nextLine());
            updateClassRoom.setCreatedDate(classRoom.getCreatedDate());
            updateClassRoom.setNo(classRoom.getNo());
            classRoomDao.update(updateClassRoom);
            System.out.println("변경하였습니다.");
        }
    }

    void onClassRoomDelete(String option) {
        System.out.println("[게시물 삭제]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return; 
        }
        
        int i = Integer.parseInt(option);
        ClassRoom classRoom = classRoomDao.get(i);
        
        if (classRoom == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                classRoomDao.delete(i);
                System.out.println("삭제하였습니다.");
            }
        }
    }
    */
}

// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - ClassRoomDao를 사용하여 게시물 데이터를 관리한다.
// ver 13 - 게시물 등록할 때 등록일의 문자열을 Date 객체로 만들어 저장.