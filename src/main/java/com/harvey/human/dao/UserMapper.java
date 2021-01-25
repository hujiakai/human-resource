package com.harvey.human.dao;

import java.util.List;

import com.harvey.human.common.BaseMapper;
import com.harvey.human.model.UserModel;

public interface UserMapper extends BaseMapper{
	
    List<UserModel> findUserModels(UserModel user);
}