package com.xuecheng.base.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 分页参数类
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageParams {
    /**
     * 默认页码
     */
    public static final long DEFAULT_PAGE_CURRENT = 1L;
    /**
     * 页面默认大小
     */
    public static final long DEFAULT_PAGE_SIZE = 10L;
    /**
     * 当前页码
     */
    @ApiModelProperty("当前页码")
    private Long pageNo = DEFAULT_PAGE_CURRENT;
    /**
     * 页面大小
     */
    @ApiModelProperty("页面大小")
    private Long pageSize = DEFAULT_PAGE_SIZE;
}
