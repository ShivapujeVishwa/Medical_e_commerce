package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Hospital;

public interface BranchDao {
	public Branch saveBranch(int hid, Branch branch);

	public Branch getBranchById(int bid);

	public boolean deleteBranchByid(int bid);

	public Branch updateBranchById(int bid, Branch branch);

	public List<Branch> getAllBranch();

}
