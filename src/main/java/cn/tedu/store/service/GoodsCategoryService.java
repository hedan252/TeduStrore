package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryService {

	@Deprecated
	List<GoodsCategory> 
		getGoodsCategoryList(Integer page);
	
	GoodsCategory 
		getGoodsCategroyById(Integer id);
	
	List<GoodsCategory> getGoodsCategoryListByParentId(
			Integer parentId, 
			Integer offset, 
			Integer pageCount
	);
}
