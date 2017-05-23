package th.part_14_TypeInfo.chapter_08_NullObject._03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import th.part_14_TypeInfo.chapter_08_NullObject.NullInterface;
import th.part_14_TypeInfo.chapter_08_NullObject.Robot;
import th.part_14_TypeInfo.chapter_08_NullObject._02.Operation;

public class NullRobotProxyHnadler implements InvocationHandler {
	private String nullName;
	
	private Robot proxied=new NRobot();
	
	public NullRobotProxyHnadler(Class<? extends Robot> type){
		nullName=type.getSimpleName()+"  is a  NullRobot";
	}
	
	private class NRobot implements Robot,NullInterface{

		@Override
		public String name() {
			return nullName;
		}

		@Override
		public String model() {
			return nullName;
		}

		@Override
		public List<Operation> operation() {

			/**
			 * emptyList()对EMPTY_LIST重新封装，提供了泛型支持
			 */
			List<Robot> emptyList = Collections.EMPTY_LIST;
			List<Robot> emptyList2=Collections.emptyList();
			//若是在某个场景下需要将空对象进行赋值那么就需要如下写法
			List<Operation> list=new ArrayList<Operation>();
			list.addAll(Collections.<Operation>emptyList());
			
			return Collections.emptyList();
		}
		
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(proxied, args);
	}

}
