package io.team.work.model.service.impl;

import io.team.work.model.bean.Homework;
import io.team.work.model.bean.StudentHomework;
import io.team.work.model.dao.impl.StudentHomeworkDao;

import java.util.List;

/**
 * 学生作业Service
 *
 * @author liuxuhui
 * <p>
 * 2020/12/10 16:54
 */
public class StudentHomeworkService {
    private final StudentHomeworkDao studentHomeworkDao=StudentHomeworkDao.getInstance();
    private StudentHomeworkService(){}
    public static StudentHomeworkService getInstance(){
        return Instance.INSTANCE;
    }

    //增加
    public Boolean addStudentHomework(StudentHomework studentHomework){
        return studentHomeworkDao.insert(studentHomework)==1;
    }
    //删除
    public Boolean removeStudentHomework(Integer id){
        return studentHomeworkDao.delete(id)==1;
    }
    //根据Id查询
    public StudentHomework getStudentHomeworkById(Integer id){
        return studentHomeworkDao.queryById(id);
    }

    //查询所有
    public List<StudentHomework> listStudentHomework() {
        return studentHomeworkDao.queryAll();
    }
    //分页查询
    public List<StudentHomework> getStudentHomeworkByPage(Integer pageNo,Integer pageSize) {
        return studentHomeworkDao.queryByPage(pageNo, pageSize);
    }
    //每次只显示5页的分页
    public List<StudentHomework> getStudentHomeworkByPage(Integer pageNo) {
        return studentHomeworkDao.queryByPage(pageNo, 5);
    }
    //更新
    public <P> Boolean updateStudentHomework(Integer id, String attribute, P propertyValue) {
        return studentHomeworkDao.update(id, attribute, propertyValue) == 1;
    }
    private static final class Instance {
        public static final StudentHomeworkService INSTANCE = new StudentHomeworkService();
    }
}
