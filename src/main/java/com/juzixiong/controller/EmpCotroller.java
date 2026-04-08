package com.juzixiong.controller;

import com.juzixiong.pojo.Emp;
import com.juzixiong.pojo.EmpQueryParam;
import com.juzixiong.pojo.PageResult;
import com.juzixiong.pojo.Result;
import com.juzixiong.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpCotroller {

    @Autowired
    private EmpService empService;

    //修改员工信息
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }

    /**
     * 查询回显
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工的详细信息");
        Emp emp  = empService.getInfo(id);
        return Result.success(emp);
    }

    //删除员工  可多选
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除员工ids：{}" , ids);
        empService.deleteByIds(ids);
        return Result.success();
    }


    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {

        log.info("查询请求参数：{}" ,empQueryParam);
        PageResult pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /*
     * 添加员工
     * */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("请求参数emp：{}" , emp);
        empService.save(emp);
        return Result.success();
    }

    //查询所有员工
    @GetMapping("/list")
    public Result findAll() {
        log.info("查询所有员工数据");
        List<Emp> empList = empService.list();
        return Result.success(empList);
    }



}
