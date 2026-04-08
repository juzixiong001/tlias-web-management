package com.juzixiong.controller;

import com.juzixiong.pojo.Clazz;
import com.juzixiong.pojo.PageResult;
import com.juzixiong.pojo.Result;
import com.juzixiong.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 新增班级
     * */
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        clazzService.save(clazz);
        return Result.success();
    }

    //班级列表数据条件分页查询
    @GetMapping
    public Result page(String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer pae,
                       @RequestParam(defaultValue = "10") Integer PageSize) {
        PageResult pageResult = clazzService.page(name,begin,end,pae,PageSize);
        return Result.success(pageResult);
    }

    //根据id查询班级信息
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    //更新班级
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        clazzService.update(clazz);
        return Result.success();
    }

    //根据id删除班级
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }

    //查询所有班级
    @GetMapping("/list")
    public Result findAll() {
        List<Clazz> clazzList  = clazzService.findAll();
        return Result.success(clazzList);
    }



}
