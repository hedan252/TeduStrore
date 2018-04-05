package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	
	List<Goods> getGoodsListByCategoryId(
		@Param("categoryId") 	Integer categoryId, 
		@Param("orderBy")		String orderBy,
		@Param("offset") 		Integer offset,
		@Param("pageCount") 	Integer pageCount
	);
	
	Integer getRecordCountByCategoryId(
			Integer categoryId);
	
	Goods getGoodsById(Integer id);
	
	List<Goods> 
		getGoodsListByItemType(String itemType);
	
	/**
	 * 接下来的这1个方法仅用于测试
	 * @param offset
	 * @return
	 */
	@Deprecated
	List<Goods> 
		getGoodsList(Integer offset);
	
}
