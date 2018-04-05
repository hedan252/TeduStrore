package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;

@Service("cartService")
public class CartServiceImpl implements CartService {
	
	@Resource
	private CartMapper cartMapper;

	public void add(Cart cart) {
		cartMapper.add(cart);
		
	}

	public List<Cart> getCartList(Integer id) {
		return cartMapper.getCartList(id);
	}

	public void del_d(Integer id) {
		
		cartMapper.del_d(id);
		
	}

	public void empty(Integer uid) {
		cartMapper.empty(uid);
		
	}

	public void reduce(Integer uid) {
		
		cartMapper.reduce(uid);
		
	}

	
}
