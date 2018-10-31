package com.anguo.mybatis.db.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlTransient;

/**
 * 分页参数类
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseVo {

	public static final int DEFAULT_PAGE_SIZE = 20;

	private int rows;
	private int page;
	private int prePage;
	private int nextPage;
	private int totalPage;
	private int totalCount;


    /**
     * 编号批量
     */
	private String ids;

	/**
	 * 用户名
	 */
	private String realName;
	/**
	 * 排序规则 desc ，asc
	 */
	private String order;

	/**
	 * 排序字段
	 */
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
