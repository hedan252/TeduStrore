package cn.tedu.store.bean;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsByCategory {
	List<Goods> getGoodsByCategory(@Param("categoryId")Integer categoryId,@Param("offset")Integer offset,@Param("pageCount")Integer pageCount);
	
}
