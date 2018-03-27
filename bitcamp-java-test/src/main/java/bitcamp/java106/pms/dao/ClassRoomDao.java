package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.ClassRoom;

public class ClassRoomDao {
    ClassRoom[] classRooms = new ClassRoom[1000];
    int classRoomIndex = 0;
    
    public void insert(ClassRoom classRoom) {
        classRoom.setNo(classRoomIndex);
        this.classRooms[this.classRoomIndex++] = classRoom;
    }
    
    public ClassRoom[] list() {
        ClassRoom[] arr = new ClassRoom[classRoomIndex];
        for (int i = 0; i < classRoomIndex; i++) 
            arr[i] = classRooms[i];
        return arr;
    }
    
    public ClassRoom get(int i) {
        if (i < 0 || i >= classRoomIndex)
            return null;
        return classRooms[i];
    }
    
    public void update(ClassRoom classRoom) {
        classRooms[classRoom.getNo()] = classRoom;
    }
    
    public void delete(int i) {
        classRooms[i] = null;
    }
}

// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - ClassRoomController로부터 데이터 관리 기능을 분리하여 ClassRoomDao 생성.





