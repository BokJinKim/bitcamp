package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;

public class MemberDao {
    Member[] members = new Member[1000];
    int memberIndex = 0;

  
 
    
    public void insert(Member Member) {
        Member.no = memberIndex;   
        this.members[this.memberIndex++] = Member;
    }
    
    public Member[] list() {
        Member[] arr = new Member[memberIndex];
        for (int i = 0; i < memberIndex; i++)
            arr[i] = members[i];
        return arr;
    }
    
    public Member get(String name) {
        
        for(int i = 0; i < memberIndex; i++ ) {
            if (members[i] == null) continue; 
            if (name.equals(members[i].id.toLowerCase())) {
                return members[i];
            }
        } return null;
    }
    
    public void update(Member member) {
        members[member.no] = member;
    }
    
    public void delete(Member member) {
        members[member.no] = null;
    }
}
