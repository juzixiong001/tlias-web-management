package com.juzixiong.controller;

import com.juzixiong.pojo.Dept;
import com.juzixiong.pojo.Emp;
import com.juzixiong.pojo.Result;
import com.juzixiong.service.DeptService;
import com.juzixiong.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 部门管理控制器
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //查询部门列表
    @GetMapping
    public Result list() {
        log.info("查询部门列表");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    //根据id删除部门
    @DeleteMapping
    public Result delete(Integer id) {
        log.info("根据ID删除部门,id: {}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    //新增部门
    @PostMapping
    public Result save(@RequestBody Dept dept) {
        log.info("新增部门, dept: {}", dept);
        deptService.save(dept);
        return Result.success();
    }

    //根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id) {
        log.info("根据ID查询, id: {}", id);
        Dept dept = deptService.getByID(id);
        return Result.success(dept);
    }

    //修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门, dept: {}", dept);
        deptService.update(dept);
        return Result.success();
    }


}