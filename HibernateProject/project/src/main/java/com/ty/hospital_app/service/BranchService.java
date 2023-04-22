package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.BranchDaoImp;
import com.ty.hospital_app.dto.Branch;

public class BranchService {
	public void saveBranch(Branch branch,int hid) {
		BranchDaoImp daoImp = new BranchDaoImp();
		Branch branch1 = daoImp.saveBranch(hid,branch);
		if (branch1 != null) {
			System.out.println("branch saved");
		} else {
			System.out.println("branch not saved");
		}
	}

	public Branch getBranchById(int bid) {
		BranchDaoImp daoImp = new BranchDaoImp();
		Branch branch1 = daoImp.getBranchById(bid);
		if (branch1 != null) {
			return branch1;
		}
		return null;
	}
	public void deleteBranchById(int bid) {
		BranchDaoImp daoImp = new BranchDaoImp();
		boolean flag=daoImp.deleteBranchByid(bid);
		if(flag) {
			System.out.println("branch deleted");
		}
		else {
			System.out.println("branch not deleted");
		}
	}
	public Branch updateBranchById(int bid,Branch branch) {
		BranchDaoImp daoImp = new BranchDaoImp();
		Branch branch1 = daoImp.updateBranchById(bid, branch);
		if(branch1!=null) {
			return branch1;
		}
		return null;
	}
	public List<Branch> getAllBranch() {
		BranchDaoImp bdi = new BranchDaoImp();
		List<Branch> branchs = bdi.getAllBranch();
		if (branchs != null) {
			return branchs;
		} else {
			return null;
		}

	}

}
