package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;

/**
 * <p>
 * 课程基本信息 服务类
 * </p>
 *
 * @author itcast
 * @since 2023-02-02
 */
public interface CourseBaseService extends IService<CourseBase> {
    /**
     * 课程列表查询
     * @param params 分页参数
     * @param paramsDto 查询参数
     * @return 课程信息分页列表
     */
    PageResult<CourseBase> queryCourseBaseList(PageParams params, QueryCourseParamsDto paramsDto);

}
