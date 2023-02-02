package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程基本信息 服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class CourseBaseServiceImpl extends ServiceImpl<CourseBaseMapper, CourseBase> implements CourseBaseService {

    /**
     * 查询课程信息实现方法
     *
     * @param params    分页参数
     * @param paramsDto 查询参数
     * @return 课程信息分页列表
     */
    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams params, QueryCourseParamsDto paramsDto) {
        LambdaQueryWrapper<CourseBase> query = new LambdaQueryWrapper<>();
        //课程名模糊查询
        query.like(StringUtils.isNotEmpty(paramsDto.getCourseName()), CourseBase::getName, paramsDto.getCourseName());
        //审核状态查询
        query.eq(StringUtils.isNotEmpty(paramsDto.getAuditStatus()), CourseBase::getAuditStatus, paramsDto.getAuditStatus());

        query.eq(StringUtils.isNotEmpty(paramsDto.getPublishStatus()), CourseBase::getStatus, paramsDto.getPublishStatus());

        IPage<CourseBase> page = new Page<>(params.getPageNo(), params.getPageSize());

        IPage<CourseBase> courseBaseIPage = baseMapper.selectPage(page, query);

        return new PageResult<>(
                courseBaseIPage.getRecords(),
                courseBaseIPage.getTotal(),
                courseBaseIPage.getCurrent(),
                courseBaseIPage.getSize()
        );
    }
}
