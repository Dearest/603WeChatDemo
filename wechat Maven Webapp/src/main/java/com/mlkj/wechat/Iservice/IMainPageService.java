package com.mlkj.wechat.Iservice;

import java.util.List;

import com.mlkj.wechat.model.Department;
import com.mlkj.wechat.model.User;

public interface IMainPageService {
	/**
	 * 得到部门列表
	 * @return
	 */
	public List<Department> getDepartmentList() throws Exception;
	
	/**
	 * 得到人员列表
	 * @return
	 */
	public List<User> getUserList() throws Exception;
}
