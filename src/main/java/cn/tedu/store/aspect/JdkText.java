package cn.tedu.store.aspect;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.catalina.Host;
import org.springframework.cglib.proxy.InvocationHandler;

public class JdkText implements InvocationHandler{

	private Object tarjet;
	
	JdkText(Object tarjet){
		this.tarjet=tarjet;
	}
	
	public Object invoke(Object parObject, Method parMethod, Object[] arg2) throws Throwable {
		System.out.println("我是代理开始了");
		Object object=parMethod.invoke(tarjet, arg2);
		System.out.println("我是代理结束 了！！！");
		
		return object;
	}

	public static void main(String[] args) {
		hedan hd=new hedan();
		JdkText jdk=new JdkText(hd);
		Host host=(Host)Proxy.newProxyInstance(hd.getClass().getClassLoader(),hd.getClass().getInterfaces(), (java.lang.reflect.InvocationHandler) jdk);
		System.out.println(host);
	}
	
}

class hedan{
	hedan(){
		System.out.println("我是何丹，我要买房");
	}
}
