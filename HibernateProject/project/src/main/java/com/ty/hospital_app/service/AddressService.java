package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.AddressDaoImp;
import com.ty.hospital_app.dao.imp.BranchDaoImp;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;

public class AddressService {
		public void saveAddress(Address address, int bid) {
			AddressDaoImp adi = new AddressDaoImp();
			Address address1 = adi.saveAddress(bid, address);
			if (address1 != null) {
				System.out.println("Data Saved");
			} else {
				System.out.println("Unfortunatly data not saved..!");
			}
		}

		public Address getAddressById(int aid) {
			AddressDaoImp adi = new AddressDaoImp();
			Address address = adi.getAddressById(aid);
			if (address != null) {
				return address;
			} else {
				return null;
			}
		}

		public void deleteAddressById(int aid) {
			AddressDaoImp adi = new AddressDaoImp();
			boolean flag = adi.deleteAddressByid(aid);
			if (flag) {
				System.out.println("Data Deleted");
			} else {
				System.out.println("Data not found..!");
			}
		}

		public Address updateAddressById(int b_id) {
			AddressDaoImp adi = new AddressDaoImp();
			Address address1 = adi.getAddressById(b_id);
			if (address1 != null) {
				return address1;
			} else {
				return null;
			}
		}
		public List<Address> getAllAddress() {
			AddressDaoImp adi = new AddressDaoImp();
			List<Address> address = adi.getAddressAll();
			if (address != null) {
				return address;
			} else {
				return null;
			}

		}
}
