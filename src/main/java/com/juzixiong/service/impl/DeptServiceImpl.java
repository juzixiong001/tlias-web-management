package com.juzixiong.service.impl;

import com.juzixiong.exception.BusinessException;
import com.juzixiong.mapper.DeptMapper;
import com.juzixiong.mapper.EmpMapper;
import com.juzixiong.pojo.Dept;
import com.juzixiong.service.DeptService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private  DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;



    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        Integer count = empMapper.countByDeptId(id);
        if(count > 0){
            throw new BusinessException("部门下有员工， 不能删除");
        } else {
            deptMapper.deleteById(id);
        }
    }

    @Override
    public void save(Dept dept) {
        //补全基础属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getByID(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}