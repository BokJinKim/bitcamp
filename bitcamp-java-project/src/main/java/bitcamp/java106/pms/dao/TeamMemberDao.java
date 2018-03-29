package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.util.ArrayList;

public class TeamMemberDao {
    ArrayList teamCollection = new ArrayList();
    ArrayList memberCollection = new ArrayList();
    
    //private Object[][] teamMembers = new Object[1000][2];
    //private int rowIndex;
    
    private int getIndex(String teamName, String memberId) {
        for (int i = 0; i < this.teamCollection.size(); i++) {
            if (this.teamCollection.get(i) == null) continue;
            if (((String)this.teamCollection.get(i)).toLowerCase().equals(
                    teamName.toLowerCase()) && 
                    (memberCollection.get(i).toString().toLowerCase().equals(
                            memberId.toLowerCase()))) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
    
    public int addMember(String teamName, String memberId) {
        if (this.isExist(teamName, memberId)) {
            return 0;
        }
        this.teamCollection.add(teamName);
        this.memberCollection.add(memberId);
        return 1;
    }
    
    
    public int deleteMember(String teamName, String memberId) {
        int index = this.getIndex(teamName,  memberId);
        if (index < 0) { // 존재하지 않는 멤버라면,
            return 0;
        }
        this.teamCollection.remove(index);
        this.memberCollection.remove(index);
        return 1;
    }
    
    public boolean isExist(String teamName, String memberId) {
        if (this.getIndex(teamName, memberId) < 0) {
            return false;
        } else {
            return true;
        }
    }
    
    private int getMemberCount(String teamName) {
        int cnt = 0;
        
        for (int i = 0; i < this.teamCollection.size(); i++) {
            if (this.teamCollection.get(i) == null) continue;
            if (((String)this.teamCollection.get(i)).toLowerCase().equals(
                    teamName.toLowerCase())) {
                cnt++;
            }
        }
        return cnt;
    }
    public String[] getMembers(String teamName) {
        String[] members = new String[this.getMemberCount(teamName)];
        
        for (int i = 0, x = 0; i < this.teamCollection.size(); i++) {
            if (this.teamCollection.get(i) == null) continue;
            if (((String)this.teamCollection.get(i)).toLowerCase().equals(
                    teamName.toLowerCase())) {
                members[x++] = (String)this.memberCollection.get(i);
            }
        }
        return members;
    }
}

// 용어 정리
// 메서드 시그니처(method signature) = 함수 프로토타입(function prototype)
// 메서드의 이름과 파라미터 형식, 리턴 타입에 대한 정보를 말한다.
