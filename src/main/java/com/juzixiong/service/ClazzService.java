package com.juzixiong.service;


import com.juzixiong.pojo.Clazz;
import com.juzixiong.pojo.PageResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ClazzService {

    /**
     * 新增班级
     * @Param clazz
     * */
    void save(Clazz clazz);

    /**条件分页查询
    *@param name 班级名称
    *@param begin 开始时间
    *@param end 结束时间
    *@param page 页码
    *@param pageSize 每页条数
    *@return 分页结果
    *
    */
    PageResult page(String name, LocalDate begin , LocalDate end, Integer page, Integer pageSize);

    /**
     * 根据ID查询班级详情
     * @param id
     * @return
     */
    Clazz getInfo(Integer id);

    /**
     * 修改班级信息
     * @param clazz
     */
    void update(Clazz clazz);

    /**
     * 删除班级
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 查询全部班级
     * @return
     */
    List<Clazz> findAll();


}
