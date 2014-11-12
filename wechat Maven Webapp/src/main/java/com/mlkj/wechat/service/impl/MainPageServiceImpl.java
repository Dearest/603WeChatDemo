package com.mlkj.wechat.service.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mlkj.wechat.Iservice.MainPageIService;
import com.mlkj.wechat.model.Department;
import com.mlkj.wechat.model.User;
import com.mlkj.wechat.utils.ConfigProperties;
import com.mlkj.wechat.utils.HttpRequest;

public class MainPageServiceImpl implements MainPageIService{

	@Override
	public List<Department> getDepartmentList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User> getUserList() throws Exception {
		List<User> users = new ArrayList<>();
		users.clear();
		String accessToken = ConfigProperties.getProperties().getProperty("accessToken");
		System.out.println("accessToken:"+accessToken);
		String departmentId = "4";
		URL url = new URL(
				"https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token="
						+ accessToken
						+ "&department_id="+departmentId+"&fetch_child=0&status=0");
		
		HttpRequest result = HttpRequest.get(url).connectTimeout(5000);
		if (result.ok()) {
			JSONObject resultJson = JSONObject.fromObject(result.body());
			
			if (resultJson.getInt("errcode") == 0) {
				JSONArray userArray = resultJson.getJSONArray("userlist");
				// 遍历json数组 将每个成员放到list里
				for (int i = 0; i < userArray.size(); i++) {
					JSONObject userJson = userArray.getJSONObject(i);
					User user = new User();
					user.setId(i + 1);
					user.setUserId(userJson.getString("userid"));
					user.setName(userJson.getString("name"));
					users.add(user);
				}
			}
		}
		return users;
	}

}
