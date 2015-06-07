package com.anguo.job.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.job.db.mapper.CommonSysJobMapper;
import com.anguo.job.db.domain.CommonSysJob;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class CommonSysJobService extends BaseService<CommonSysJob> {
	@Autowired
	private CommonSysJobMapper mapper;
	
	
	/**
	 * 启动是将暂停状态修改为停用  
	 * @return
	 */
	public int updateDataByPause(){
		return this.mapper.updateDataByPause();
	}
	
	
	public CommonSysJobMapper getMapper() {
		return mapper;
	}
}
