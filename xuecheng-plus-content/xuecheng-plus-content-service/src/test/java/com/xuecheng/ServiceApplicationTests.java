package com.xuecheng;

import com.alibaba.fastjson.JSON;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceApplicationTests {

    @Autowired
    CourseBaseMapper courseBaseMapper;

    @Autowired
    CourseBaseService courseBaseService;

    @Test
    void courseBaseMapperTest(){
        CourseBase courseBase = courseBaseMapper.selectById(1);
        Assertions.assertNotNull(courseBase);
    }

    @Test
    void courseBaseServiceTest(){
        QueryCourseParamsDto queryCourseParamsDto = new QueryCourseParamsDto();
        queryCourseParamsDto.setCourseName("S");
        queryCourseParamsDto.setPublishStatus("203001");
        queryCourseParamsDto.setAuditStatus("202004");
        PageResult<CourseBase> courseBasePageResult = courseBaseService.queryCourseBaseList(new PageParams(1L,3L), queryCourseParamsDto);
        System.out.println(JSON.toJSONString(courseBasePageResult));
    }

}
