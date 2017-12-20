package com.yks.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:FilterBean
 *
 * @Dec: 用于接收JqGrid分页数据
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/12/20 10:24
 */
public class FilterBean {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());// 日志类
    private List<Object> paramList = new ArrayList<Object>();// 参数值

    private Integer pageSize = 10;// 页大小(每页记录条)
    private Integer rowCount;// 记录总数
    private Integer pageCount;// 总页数
    private Integer curPage = 1;// 当前页码

    public List<Object> getParamList() {
        return paramList;
    }

    public void setParamList(List<Object> paramList) {
        this.paramList = paramList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }
}
