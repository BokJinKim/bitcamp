package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    Task[] tasks = new Task[1000];
    int taskIndex = 0;
    
    public void insert(Task task) {
        // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        this.tasks[this.taskIndex++] = task;
    }
    
    public Task[] list() {
        Task[] arr = new Task[this.taskIndex];
        for (int i = 0; i < this.taskIndex; i++) 
            arr[i] = this.tasks[i];
        return arr;
    }
    
    public Task get(String name) {
        int i = this.gettaskIndex(name);
        if (i == -1)
            return null;
        return tasks[i];
    }
    
    public void update(Task task) {
        int i = this.gettaskIndex(Task.getName());
        if (i != -1)
            tasks[i] = task;
    }
    
    public void delete(String name) {
        int i = this.gettaskIndex(name);
        if (i != -1) 
            tasks[i] = null;
    }
    
    private int gettaskIndex(String name) {
        for (int i = 0; i < this.taskIndex; i++) {
            if (this.tasks[i] == null) continue;
            if (name.equals(this.tasks[i].getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

}

//ver 14 - TaskController로부터 데이터 관리 기능을 분리하여 TaskDao 생성.





