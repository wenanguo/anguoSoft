package com.anguo.web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anguo.web.db.mapper.CommonRoleInfoMapper;
import com.anguo.web.db.domain.CommonRoleInfo;
import com.anguo.mybatis.db.service.BaseService;


@Service
public class CommonRoleInfoService extends BaseService<CommonRoleInfo> {
    @Autowired
    private CommonRoleInfoMapper mapper;
    public CommonRoleInfoMapper getMapper() {
        return mapper;
    }
}
