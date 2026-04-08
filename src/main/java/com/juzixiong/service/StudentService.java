package com.juzixiong.service;


import com.juzixiong.pojo.ClazzCountOption;
import com.juzixiong.pojo.PageResult;
import com.juzixiong.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    //条件分页查询
    PageResult page(String name, Integer degree, Integer clazzId, Integer page, Integer pageSize);


    //添加学员
    void save(Student  student);

    //根据id查询学生
    Student getInfo(Integer id);

    //修改学生信息
    void update(Student student);

    //删除学生信息
    void deleteById(List<Integer> ids);

    //违纪处理
    void violationHandle(Integer id,Integer score);


}
