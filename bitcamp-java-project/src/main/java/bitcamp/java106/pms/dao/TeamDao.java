package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    private LinkedList<Team> collection = new LinkedList<>();
    
    public void insert(Team team) {
        // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        this.collection.add(team);
    }
    
    public Team[] list() {
        Team[] arr = new Team[this.collection.size()];
        for (int i = 0; i < this.collection.size(); i++) 
            arr[i] = this.collection.get(i);
        return arr;
    }
    
    public Team get(String name) {
        int i = this.getTeamIndex(name);
        if (i == -1)
            return null;
        return collection.get(i);
    }
    
    public void update(Team team) {
        int i = this.getTeamIndex(team.getName());
        if (i != -1)
            collection.set(i, team);
    }
    
    public void delete(String name) {
        int i = this.getTeamIndex(name);
        if (i != -1) 
            collection.remove(i);
    }
    
    private int getTeamIndex(String name) {
        for (int i = 0; i < this.collection.size(); i++) {
            if (this.collection.get(i) == null) continue;
            if (name.toLowerCase().equals((this.collection.get(i)).getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

}

//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.





