package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

public interface GoodsService {
	
	@Deprecated
	List<Goods> 
		getGoodsList(Integer page);
	
	List<Goods> getGoodsListByCategoryId(
		Integer categoryId, 
		String orderBy,
		Integer offset, 
		Integer pageCount);
	
	Integer getRecordCountByCategoryId(
		Integer categoryId);
	
	Goods getGoodsById(Integer id);
	
	List<Goods> 
		getGoodsListByItemType(String itemType);
}
