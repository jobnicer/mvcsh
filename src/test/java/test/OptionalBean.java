package test;

public class OptionalBean<Object> extends GeneralBean {

	public static void main(String[] args) {
		OptionalBean opt = new OptionalBean() ;
		Class clazz = opt.getActualTypeClass();
		System.out.println(clazz);
	}
	
}
