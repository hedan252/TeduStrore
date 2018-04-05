package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;

@Service("goodsService")
public class GoodsServiceImpl 
	implements GoodsService {
	
	@Resource
	private GoodsMapper goodsMapper;

	@SuppressWarnings("deprecation")
	public List<Goods> getGoodsList(Integer page) {
		if (--page < 0) {
			page = 0;
		}
		
		int offset = page * 25;
		
		return goodsMapper.getGoodsList(offset);
	}

	public List<Goods> getGoodsListByCategoryId(
			Integer categoryId, 
			String orderBy, 
			Integer offset, 
			Integer pageCount) {
		if (offset != null) {
			if (pageCount == null || 
					pageCount < 0 || 
					pageCount > 20) {
				pageCount = 20;
			}
		}
		return goodsMapper
				.getGoodsListByCategoryId(
						categoryId, 
						orderBy, 
						offset, 
						pageCount);
	}

	public Integer getRecordCountByCategoryId(
			Integer categoryId) {
		return goodsMapper
				.getRecordCountByCategoryId(
						categoryId);
	}

	public Goods getGoodsById(Integer id) {
		return goodsMapper.getGoodsById(id);
	}

	public List<Goods> getGoodsListByItemType(String itemType) {
		return goodsMapper.getGoodsListByItemType(itemType);
	}

}
