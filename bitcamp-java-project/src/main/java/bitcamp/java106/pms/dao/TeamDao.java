package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    Team[] teams = new Team[1000];
    int teamIndex = 0;

  
 
    
    public void insert(Team Team) {
        Team.no = teamIndex;   
        this.teams[this.teamIndex++] = Team;
    }
    
    public Team[] list() {
        Team[] arr = new Team[teamIndex];
        for (int i = 0; i < teamIndex; i++)
            arr[i] = teams[i];
        return arr;
    }
    
    public Team get(String name) {
        
        for(int i = 0; i < teamIndex; i++ ) {
            if (teams[i] == null) continue; 
            if (name.equals(teams[i].name.toLowerCase())) {
                return teams[i];
            }
        } return null;
    }
    
    public void update(Team team) {
        teams[team.no] = team;
    }
    
    public void delete(Team team) {
        teams[team.no] = null;
    }
}
