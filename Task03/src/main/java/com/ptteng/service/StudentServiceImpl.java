package com.ptteng.service;

import com.ptteng.dao.StudentMapper;
import com.ptteng.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangshun on 2017/5/31.
 */
//@Service表示创建一个实现类的实例Bean，括号里的内容是Bean的id
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    /*
    * @Autowired与@Resource都可以用来装配bean. 都可以写在字段上,或写在setter方法上。
    * Autowired默认按类型装配（这个注解是属于spring的）
    * @Resource（这个注解属于J2EE的），默认按照名称进行装配，名称可以通过name属性进行指定
    * 推荐使用：@Resource注解在字段上，且这个注解是属于J2EE的，减少了与spring的耦合。
    * */
    @Resource//父类的重写
    private StudentMapper studentMapper;


    @Override
    public int addStudent(Student stu) {

        return studentMapper.addStudent(stu);
    }

    @Override
    public int deleteStudent(int id) {
        return studentMapper.deleteStudentById(id);
    }

    @Override
    public int updateStudent(Student stu) {
        return studentMapper.updateStudent(stu);
    }

    @Override
    public Student findStudentById(int id) {
        return studentMapper.findStudentById(id);
    }

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();

    }
}
