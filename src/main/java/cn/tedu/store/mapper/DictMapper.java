package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.dict.Area;
import cn.tedu.store.bean.dict.City;
import cn.tedu.store.bean.dict.Province;

public interface DictMapper {

	List<Province> getProvinceList();

	List<City> getCityList(String provinceCode);

	List<Area> getAreaList(String cityCode);

	String getProvinceNameByCode(String provinceCode);

	String getCityNameByCode(String cityCode);

	String getAreaNameByCode(String areaCode);

}
