package com.anguo.mybatis.db.core;

import java.util.List;

public class PageResult<T> {
	
	@Override
	public String toString() {
		return "PageResult [total=" + total + ", rows=" + rows + "]";
	}

	private int total;
	
	private int page;
	
	private List<T> rows;
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
