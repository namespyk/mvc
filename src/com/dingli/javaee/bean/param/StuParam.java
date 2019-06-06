package com.dingli.javaee.bean.param;

public class StuParam {
    private String name;
    // 获取参数时，参数应该使用包装类型，因为原生类型没有null
    private Integer start;
    private Integer end;
    private Integer curPage;
    private Integer pageSize;

    public StuParam() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "StuParam{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", curPage=" + curPage +
                ", pageSize=" + pageSize +
                '}';
    }
}

