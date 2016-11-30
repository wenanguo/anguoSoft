package com.anguo.mybatis.db.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CodeComments {
	public String value() default "无";
}
