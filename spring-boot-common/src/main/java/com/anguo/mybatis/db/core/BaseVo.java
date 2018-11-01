package com.anguo.mybatis.db.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlTransient;

/**
 * 分页参数类
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseVo {

	public static final int DEFAULT_PAGE_SIZE = 20;

    @ApiModelProperty(value="rows",hidden=true)
	private int rows;
    @ApiModelProperty(value="page",hidden=true)
	private int page;
    @ApiModelProperty(value="上一页",hidden=true)
	private int prePage;
    @ApiModelProperty(value="下一页",hidden=true)
	private int nextPage;
    @ApiModelProperty(value="总页数",hidden=true)
	private int totalPage;
    @ApiModelProperty(value="总条数",hidden=true)
	private int totalCount;


    /**
     * 编号批量
     */
    @ApiModelProperty(value="id数组",hidden=true)
	private String ids;

	/**
	 * 用户名
	 */
    @ApiModelProperty(value="真实用户名",hidden=true)
	private String realName;
	/**
	 * 排序规则 desc ，asc
	 */
    @ApiModelProperty(value="排序规则",hidden=true)
	private String order;

	/**
	 * 排序字段
	 */
    @ApiModelProperty(value="排序字段",hidden=true)
	private String sort;

	public BaseVo() {
		this.page = 1;
		this.rows = DEFAULT_PAGE_SIZE;
	}

	/**
	 * 
	 * @param page
	 * @param pageSize
	 */
	public BaseVo(int page, int pageSize) {
		this.page = page;
		this.rows = pageSize;
	}


    @XmlTransient
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
    @XmlTransient
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
    @XmlTransient
	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
    @XmlTransient
	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
    @XmlTransient
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
    @XmlTransient
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
    @XmlTransient
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
    @XmlTransient
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
    @XmlTransient
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
    @XmlTransient
    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
