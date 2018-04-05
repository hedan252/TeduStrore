package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Cart;

public interface CartMapper {
	
	void add(Cart cart);
		
	List<Cart> getCartList(Integer uid);
	
	void del_d(Integer id);
	
	//结算后购物车清空，库存各减一
	void empty(Integer uid);
	void reduce(Integer uid);
}
