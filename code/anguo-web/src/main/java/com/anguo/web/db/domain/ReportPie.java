
package com.anguo.web.db.domain;




import com.anguo.mybatis.db.core.BaseVo;


/**
 * 实体类
 * @ClassName: ReportPie 
 * @author Andrew.Wen
 */
public class ReportPie extends BaseVo  {

	/**
	 * .
	 */
	private Integer id;
	/**
	 * .
	 */
	private String name;
	/**
	 * .
	 */
	private Integer y;
	/**
	 * .
	 */
	private Integer sliced;
	/**
	 * .
	 */
	private Integer selected;




    
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
    
public Integer getSliced() {
		return sliced;
	}
	public void setSliced(Integer sliced) {
		this.sliced = sliced;
	}
    
public Integer getSelected() {
		return selected;
	}
	public void setSelected(Integer selected) {
		this.selected = selected;
	}
	
}
