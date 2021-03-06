package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressService {

	void addAddress(Address address);
	
	List<Address> getAddressList(Integer uid);
	
	void delete(Integer id, Integer uid);
	
	Address getAddressById(Integer id, Integer uid);
	
	void updateAddressById(Address address);
	
	void setDefaultAddress(Integer id, Integer uid);

}
