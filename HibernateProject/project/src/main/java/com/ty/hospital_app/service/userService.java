 package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.HospitalDaoImp;
import com.ty.hospital_app.dao.imp.userDaoImp;
import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.dto.User;

public class userService {
	public void saveUser(User user) {
		userDaoImp udi = new userDaoImp();
		User user1 = udi.saveUser(user);
		if (user1 != null) {
			System.out.println("data saved");
		} else {
			System.out.println("data not saved");
		}
	}
	public User getUserById(int uid) {
		userDaoImp udi = new userDaoImp();
		User user = udi.getUserById(uid);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public void deleteUserById(int u_id) {
		userDaoImp udi = new userDaoImp();
		boolean flag = udi.deleteUserByid(u_id);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public User updateUserById(int u_id , User user) {
		userDaoImp udi = new userDaoImp();
		User user1 = udi.updateUserById(u_id, user);
		if (user1 != null) {
			return user1;
		} else {
			return null;
		}
	}

	public List<User> getAllUser() {
		userDaoImp udi = new userDaoImp();
		List<User> users = udi.getAllUser();
		if (users != null) {
			return users;
		} else {
			return null;
		}
	}
	
	public List<User> getUserByRole(String role) {
		userDaoImp udi = new userDaoImp();
		List<User> users = udi.getUserByRole(role);
		if (users != null) {
			return users;
		} else {
			return null;
		}
	}
	

}
