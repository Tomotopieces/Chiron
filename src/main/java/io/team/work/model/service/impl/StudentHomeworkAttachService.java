package io.team.work.model.service.impl;

import io.team.work.model.bean.StudentHomework;
import io.team.work.model.bean.StudentHomeworkAttach;
import io.team.work.model.dao.impl.StudentHomeworkAttachDao;
import io.team.work.model.dao.impl.StudentHomeworkDao;

import java.util.List;

/**
 * 学生附件Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 18:02
 */
public class StudentHomeworkAttachService {
    private final StudentHomeworkAttachDao studentHomeworkAttachDao=StudentHomeworkAttachDao.getInstance();
    private StudentHomeworkAttachService(){}
    public static StudentHomeworkAttachService getInstance(){
        return StudentHomeworkAttachService.Instance.INSTANCE;
    }

    //增加
    public Boolean addStudentHomeworkAttach(StudentHomeworkAttach studentHomeworkAttach){
        return studentHomeworkAttachDao.insert(studentHomeworkAttach)==1;
    }
    //删除
    public Boolean removeStudentHomeworkAttach(Integer id){
        return studentHomeworkAttachDao.delete(id)==1;
    }
    //根据Id查询
    public StudentHomeworkAttach getStudentHomeworkAttachById(Integer id){
        return studentHomeworkAttachDao.queryById(id);
    }

    //查询所有
    public List<StudentHomeworkAttach> listStudentHomeworkAttach() {
        return studentHomeworkAttachDao.queryAll();
    }
    //分页查询
    public List<StudentHomeworkAttach> getStudentHomeworkAttachByPage(Integer pageNo,Integer pageSize) {
        return studentHomeworkAttachDao.queryByPage(pageNo, pageSize);
    }
    //每次只显示5页的分页
    public List<StudentHomeworkAttach> getStudentHomeworkAttachByPage(Integer pageNo) {
        return studentHomeworkAttachDao.queryByPage(pageNo, 5);
    }
    //更新
    public <P> Boolean updateStudentHomeworkAttach(Integer id, String attribute, P propertyValue) {
        return studentHomeworkAttachDao.update(id, attribute, propertyValue) == 1;
    }
    private static final class Instance {
        public static final StudentHomeworkAttachService INSTANCE = new StudentHomeworkAttachService();
    }
}
