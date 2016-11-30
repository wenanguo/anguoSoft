package com.anguo.job.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.job.db.domain.CommonSysJob;

public interface CommonSysJobMapper extends BaseMapper<CommonSysJob> {
	
	/**
	 * 启动是将暂停状态修改为停用  
	 * @return
	 */
	int updateDataByPause();

}
