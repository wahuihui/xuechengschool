package com.xuecheng.system.controller;

import com.xuecheng.system.model.po.Dictionary;
import com.xuecheng.system.service.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author itcast
 */
@Slf4j
@RestController
@Api(value = "数据字典接口",tags = "数据字典接口")
public class DictionaryController  {

    @Autowired
    private DictionaryService  dictionaryService;

    @ApiOperation("获取所有字典信息列表")
    @GetMapping("/dictionary/all")
    public List<Dictionary> queryAll() {
        return dictionaryService.queryAll();
    }

    @ApiOperation("通过code获取字典信息")
    @GetMapping("/dictionary/code/{code}")
    public Dictionary getByCode(@PathVariable("code") String code) {
        return dictionaryService.getByCode(code);
    }
}
