package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.ItemsDaoImp;
import com.ty.hospital_app.dto.Items;

public class ItemsService {
	public void saveItems(Items items, int mid) {
		ItemsDaoImp idi = new ItemsDaoImp();
		Items items1 = idi.saveItem(mid, items);
		if (items1 != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Unfortunatly data not saved..!");
		}
	}

	public Items getItemsById(int iid) {
		ItemsDaoImp idi = new ItemsDaoImp();
		Items items = idi.getItemsById(iid);
		if (items != null) {
			return items;
		} else {
			return null;
		}
	}

	public void deleteItemsById(int iid) {
		ItemsDaoImp idi = new ItemsDaoImp();
		boolean flag = idi.deleteItemsByid(iid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data not found..!");
		}
	}

	public Items updateItemsById(int iid) {
		ItemsDaoImp idi = new ItemsDaoImp();
		Items items1 = idi.getItemsById(iid);
		if (items1 != null) {
			return items1;
		} else {
			return null;
		}
	}

	public List<Items> getAlliItems() {
		ItemsDaoImp idi = new ItemsDaoImp();
		List<Items> items = idi.getAllItems();
		if (items != null) {
			return items;
		} else {
			return null;
		}
	}

}
