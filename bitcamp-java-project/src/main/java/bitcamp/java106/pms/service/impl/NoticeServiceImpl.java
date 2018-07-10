// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.NoticeDao;
import bitcamp.java106.pms.domain.Notice;
import bitcamp.java106.pms.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
    
    NoticeDao noticeDao;
    
    public NoticeServiceImpl(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }
    
    @Override
    public List<Notice> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return noticeDao.selectList(params);
    }
    
    @Override
    public Notice get(int no) {
        return noticeDao.selectOne(no);
    }
    
    @Override
    public int add(Notice notice) {
        return noticeDao.insert(notice);
    }
    
    @Override
    public int update(Notice notice) {
        return noticeDao.update(notice);
    }
    
    @Override
    public int delete(int no) {
        return noticeDao.delete(no);
    }
}

//ver 53 - 클래스 추가






