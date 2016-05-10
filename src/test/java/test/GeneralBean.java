package test;

import java.lang.reflect.ParameterizedType;

public class GeneralBean<T> {

	protected Class getActualTypeClass() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		Class<T> entityClass = (Class<T>) type.getActualTypeArguments()[0];
		return entityClass;
	}
}
