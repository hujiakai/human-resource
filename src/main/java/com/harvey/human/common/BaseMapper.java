package com.harvey.human.common;

import com.harvey.human.model.UserModel;

public interface BaseMapper {
	int deleteByPrimaryKey(Long id);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserModel record);
}
