package com.juzixiong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.juzixiong.exception.BusinessException;
import com.juzixiong.mapper.ClazzMapper;
import com.juzixiong.mapper.StudentMapper;
import com.juzixiong.pojo.Clazz;
import com.juzixiong.pojo.PageResult;
import com.juzixiong.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public PageResult page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Clazz> dataList = clazzMapper.list(name, begin, end);
        Page<Clazz> p = (Page<Clazz>) dataList;
        return new PageResult(p.getTotal() , p.getResult());
    }

    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getInfo(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public void deleteById(Integer id) {
//        查询班级下是否有学员
        Integer count = studentMapper.countByClazzId(id);
        if(count > 0) {
            throw new BusinessException("班级下有学员, 不能直接删除~");
        }
        //没有
        clazzMapper.deleteById(id);
    }

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }
}
