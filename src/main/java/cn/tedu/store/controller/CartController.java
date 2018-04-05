package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.dict.Province;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.CartService;
import cn.tedu.store.service.DictService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
	
	@Resource
	private CartService cartService;
	//获取收货人信息
	@Resource
	private AddressService addressService;
	//获取省市区
	@Resource
	private DictService dictService;

	@RequestMapping("/orderConfirm.do")
	public String showOrderConfirm(HttpSession session, ModelMap modelMap) {
				// 获取当前登录的用户ID
				Integer uid = getUidFromSession(session);
				// 根据用户ID获取购物车列表
				List<Cart> carts = cartService.getCartList(uid);
				List<Address> address = addressService.getAddressList(uid);
				
				String s1=null;
				String s2=null;
				String s3=null;
				String addr=null;
				for(Address add:address) {
					s1=add.getRecvProvince();
					s2=add.getRecvCity();
					s3=add.getRecvArea();
					addr=add.getRecvAddr();
				}
				String shen=dictService.getProvinceNameByCode(s1);
				String shi=dictService.getCityNameByCode(s2);
				String qu=dictService.getAreaNameByCode(s3);
				
				// 将数据封装到ModelMap中以转发
				modelMap.addAttribute("carts", carts);
				modelMap.addAttribute("address",address);
				
				modelMap.addAttribute("shen",shen);
				modelMap.addAttribute("shi",shi);
				modelMap.addAttribute("qu",qu);
				modelMap.addAttribute("addr",addr);
				
		return "orderConfirm";
	}
	
	@RequestMapping("/list.do")
	public String showCartList(HttpSession session, ModelMap modelMap) {
		// 获取当前登录的用户ID
		Integer uid = getUidFromSession(session);
		// 根据用户ID获取购物车列表
		List<Cart> carts = cartService.getCartList(uid);
		// 将数据封装到ModelMap中以转发
		modelMap.addAttribute("carts", carts);
		// 执行转发
		return "cart_list";
	}
	
	@RequestMapping(value="add.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleAddCart(Cart cart, HttpSession session) {
		Integer uid = getUidFromSession(session);
		
		cart.setUserId(uid);

		cartService.add(cart);
		
		ResponseResult<Void> rr= new ResponseResult<Void>();
		rr.setState(ResponseResult.STATE_OK);
		rr.setMessage("成功将商品添加到购物车");
		System.out.println("这是成功添加");
		return rr;
	}

	@RequestMapping(value="del_d.do")
	@ResponseBody
	public ResponseResult<Void> handleDel_d(HttpSession session){
		ResponseResult<Void> rr= new ResponseResult<Void>();
		Integer uid=getUidFromSession(session);	
		List<Cart> cs = cartService.getCartList(uid);
		Integer id=null;
		for(Cart ca:cs) {
			id=ca.getId();
		}
		cartService.del_d(id);
		if(uid!=null) {
			rr.setState(ResponseResult.STATE_OK);
			rr.setMessage("删除成功");
		}else {
			rr.setState(ResponseResult.STATE_ERROR);
			rr.setMessage("删除失败");
		}
		return rr;
	}
	
	//支付界面 
	@RequestMapping("/pay.do")
	@Transactional
	public String payment(HttpSession session,ModelMap map) {
		Integer uid=getUidFromSession(session);	
		List<Cart> carts = cartService.getCartList(uid);
		cartService.reduce(uid);
		cartService.empty(uid);
		Integer c1=null;
		Integer sum=0;
		for(int i=0;i<carts.size();i++) {
			 c1=carts.get(i).getGoodsPrice();
			 sum+=c1;
		}
			
		map.addAttribute("price",sum);
		map.addAttribute("carts", carts);
		
		return "payment";
	}
	
}
