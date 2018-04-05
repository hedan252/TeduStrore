package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.dict.Area;
import cn.tedu.store.bean.dict.City;
import cn.tedu.store.bean.dict.Province;

public interface DictService {

	List<Province> getProvinceList();

	List<City> getCityList(String provinceCode);

	List<Area> getAreaList(String cityCode);

	String getProvinceNameByCode(String provinceCode);

	String getCityNameByCode(String cityCode);

	String getAreaNameByCode(String areaCode);

}
