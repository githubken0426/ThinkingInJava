package cn.cglib.lazyload;

import net.sf.cglib.proxy.Enhancer;

public class LazyBean {
	private String name;
	private int age;
	private PropertyBean propertyBean;
	private PropertyBean propertyBeanDispatcher;

	public LazyBean(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("lazy bean init");
		this.propertyBean = createPropertyBean();
		this.propertyBeanDispatcher = createPropertyBeanDispatcher();
	}

	/**
	 * ʹ��cglib���������� ����Ҫ�ӳټ��صĶ�����Ӵ����ڻ�ȡ�ö�������ʱ��ͨ��������ص��������ж����ʼ����
	 * �ڲ���Ҫ���ظö���ʱ��ֻҪ��ȥ��ȡ�ö��������ԣ��ö���Ͳ��ᱻ��ʼ����
	 * ����CGLib��ʵ����ֻҪȥ���ʸö��������Ե�getter�������ͻ��Զ�����������ص���
	 */
	public PropertyBean createPropertyBean() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PropertyBean.class);
		PropertyBean pb = (PropertyBean) Enhancer.create(PropertyBean.class,
				new ConcreteClassLazyLoader());
		return pb;
	}

	/**
	 * ÿ�ζ�������
	 * 
	 * @return
	 */
	public PropertyBean createPropertyBeanDispatcher() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PropertyBean.class);
		PropertyBean pb = (PropertyBean) Enhancer.create(PropertyBean.class,
				new ConcreteClassDispatcher());
		return pb;
	}

	// ʡ��get set����
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PropertyBean getPropertyBean() {
		return propertyBean;
	}

	public void setPropertyBean(PropertyBean propertyBean) {
		this.propertyBean = propertyBean;
	}

	public PropertyBean getPropertyBeanDispatcher() {
		return propertyBeanDispatcher;
	}

	public void setPropertyBeanDispatcher(PropertyBean propertyBeanDispatcher) {
		this.propertyBeanDispatcher = propertyBeanDispatcher;
	}
}
