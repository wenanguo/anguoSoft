package com.anguo.mybatis.db.service;

import java.util.List;

import com.anguo.mybatis.db.core.BaseVo;
import com.anguo.mybatis.db.core.PageResult;
import com.anguo.mybatis.db.mapper.BaseMapper;

/**
 * 业务逻辑父类
 * @author Andrew.Wen
 *
 * @param <T>
 */
public class BaseService<T> {
	
	private BaseMapper<T> mapper;


	public PageResult<T> getPageData(BaseVo page) {
		
		//获得查询结果
		List<T> list=this.getMapper().getPageData(page);
		//设置分页参数
		PageResult<T> rePage=new PageResult();
		
		rePage.setTotal(page.getTotalCount());
		rePage.setRows(list);
		rePage.setPage(page.getPage());
		
		  return  rePage;
	}
	
	/**
	 * 获得所有数据
	 * @param obj
	 * @return
	 */
	public List<T> getAllData(T obj)
	{
		return this.getMapper().getAllData(obj);
	}
	
	/**
	 * 获得单条数据
	 * @param obj
	 * @return
	 */
	public T getData(T obj)
	{
		return this.getMapper().getData(obj);
	}
	
	
	public int insertData(T obj)
	{
		return this.getMapper().insertData(obj);
	}

	
	public int updateData(T obj)
	{
		return this.getMapper().updateData(obj);
	}
	
	
	public int deleteData(T obj)
	{
		return this.getMapper().deleteData(obj);
	}

	public BaseMapper<T> getMapper() {
		return mapper;
	}


	public void setMapper(BaseMapper<T> mapper) {
		this.mapper = mapper;
	}


	
	
	
	
}
