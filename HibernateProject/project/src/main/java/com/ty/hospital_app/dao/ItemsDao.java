package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Items;

public interface ItemsDao {
	public Items saveItem(int mid, Items items);

	public Items getItemsById(int iid);

	public boolean deleteItemsByid(int iid);

	public Items updateItemsById(int iid, Items items);

	public List<Items> getAllItems();

}
