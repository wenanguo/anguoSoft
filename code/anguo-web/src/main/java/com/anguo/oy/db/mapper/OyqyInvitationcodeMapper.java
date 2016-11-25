package com.anguo.oy.db.mapper;

import com.anguo.mybatis.db.mapper.BaseMapper;
import com.anguo.oy.db.domain.OyqyInvitationcode;

public interface OyqyInvitationcodeMapper extends BaseMapper<OyqyInvitationcode> {

	
	public OyqyInvitationcode getDatabyOpenid(OyqyInvitationcode obj);
}
