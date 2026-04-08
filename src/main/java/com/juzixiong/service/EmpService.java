package com.juzixiong.service;


import com.juzixiong.pojo.Emp;
import com.juzixiong.pojo.EmpQueryParam;
import com.juzixiong.pojo.LoginInfo;
import com.juzixiong.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {

    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);

    //根据id查询
    Emp getInfo(Integer id);

    /**
     * 分页查询
     * Integer page, Integer pageSize , String name , Integer gender , LocalDate begin , LocalDate end
     */
    PageResult page(EmpQueryParam empQueryParam);

    /**
     * 添加员工
     * @param emp
     */
    void save(Emp emp);


    //删除员工
    void deleteByIds(List<Integer> ids);

    /**
     * 查询所有的员工数据
     */
    List<Emp> list();

    //登录
    LoginInfo login (Emp emp);

}
