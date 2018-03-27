// 게시글 데이터를 저장할 새 데이터 타입을 정의한다.
package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Task {
    public static final int READY = 0;
    public static final int WORKING = 1;
    public static final int COMPLETE = 9;
    
    private int no;
    private String title;
    private Date startDate;
    private Date endDate;
    private int state;
    private Member Worker;
    private Team team;
    
    public Task(Team team) {
        this.team = team;
    }
    

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Member getWorker() {
        return Worker;
    }

    public void setWorker(Member worker) {
        Worker = worker;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Task [no=" + no + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", state="
                + state + ", Worker=" + Worker + ", team=" + team + "]";
    }
    
    
}

