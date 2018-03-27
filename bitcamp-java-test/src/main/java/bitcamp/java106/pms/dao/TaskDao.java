package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    Task[] tasks = new Task[1000];
    int taskIndex = 0;
    
    public void insert(Task task) {
        task.setNo(taskIndex);
        this.tasks[this.taskIndex++] = task;
    }
    
    private int count(String teamName) {
        int cnt = 0;
        for (int i = 0; i < taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName)) {
                cnt++;
            }
        }
        return cnt;
    }
    public Task[] list(String teamName) {
        Task[] arr = new Task[this.count(teamName)];
        for (int i = 0, x = 0; i < taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName)) {
                arr[x++] = tasks[i];    
            }
        }
        return arr;
    }
        
    
    public Task get(String teamName, int taskNo) {
        for (int i = 0; i < taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName) &&
                    tasks[i].getNo() == taskNo) {
                return tasks[i];
            }
        }
        return null;
    }
    
    public void update(Task task) {
        tasks[task.getNo()] = task;
    }
    
    public void delete(int i) {
        tasks[i] = null;
    }
}

// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - TaskController로부터 데이터 관리 기능을 분리하여 TaskDao 생성.





