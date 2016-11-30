package com.anguo.mybatis.db.mapper;

import java.util.List;

import com.anguo.mybatis.db.core.BaseVo;

/**
 * mapper基类
 * @author Andrew.Wen
 *
 * @param <T>
 */
public interface BaseMapper<T> {
	
	/**
	 * 获得分页数据
	 * @param obj
	 * @return
	 */
	public List<T> getPageData(BaseVo page);
	
	/**
	 * 获得所有数据
	 * @param obj
	 * @return
	 */
	public List<T> getAllData(T obj);
	
	/**
	 * 获得单条数据
	 * @param obj
	 * @return
	 */
	public T getData(T obj);
	
	/**
	 * 新增数据
	 * @param obj
	 * @return
	 */
	public int insertData(T obj);
	
	/**
	 * 修改数据
	 * @param obj
	 * @return
	 */
	public int updateData(T obj);
	
	
	/**
	 * 删除数据
	 * @param obj
	 * @return
	 */
	public int deleteData(T obj);


}
