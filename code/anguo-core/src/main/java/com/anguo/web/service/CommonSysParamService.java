package com.anguo.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.web.db.mapper.CommonSysParamMapper;
import com.anguo.web.db.domain.CommonSysParam;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class CommonSysParamService extends BaseService<CommonSysParam> {
	@Autowired
	private CommonSysParamMapper mapper;
	
	/**
	 * 根据名称获取参数值
	 * @param name 参数名
	 * @return
	 */
	public String getDataByName(String name){
		return getDataByName(name,"");
	} 
	
	/**
	 * 根据名称获取参数值
	 * @param name 参数名
	 * @param defalutValue 默认值
	 * @return
	 */
	public String getDataByName(String name,String defalutValue){
		CommonSysParam csp=new CommonSysParam();
		csp.setName(name);
		
		csp=this.mapper.getDataByName(csp);
		if(csp==null){
			return defalutValue;
		}else{
			
			return csp.getValue();
		}
	}
	
	
	
	public CommonSysParamMapper getMapper() {
		return mapper;
	}
}
