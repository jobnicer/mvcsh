package org.ssh.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.ssh.common.ConditionQuery;
import org.ssh.common.OrderBy;
import org.ssh.common.exception.DaoException;
import org.ssh.common.model.BasePojo;


/**
 *  Dao基类接口
 * @author Drunker
 * @version 2.2
 * @date 2012-5-21 上午9:36:56
 */
public interface IBaseDao <M extends BasePojo,PK extends Serializable> {
	
	/**
	 * 获取当前seesion
	 * @return
	 */
	public Session getSession();
	/**
	 * 持久化一个对象A
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public PK save(M po) throws DaoException;


	/**
	 * 移除一个持久化对象A
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void delete(M po) throws DaoException;


	/**
	 * 移除一个持久化对象A
	 * @param id
	 * @throws DaoException
	 */
	public void delete(PK id) throws DaoException;


	/**
	 * 使用update的时候，执行完成后，我们提供的对象A的状态变成持久化状态
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void update(M po) throws DaoException;

	/**
	 * 使用saveOrUpdate时，对象A不存在时，持久化A，存在时，修改对象属性持久化。
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void saveOrUpdate(M po) throws DaoException;

	/**
	 * 使用merge的时候，执行完成，我们提供的对象A还是脱管状态，
	 * hibernate或者new了一个B，或者检索到 一个持久对象B，
	 * 并把我们提供的对象A的所有的值拷贝到这个B，执行完成后B是持久状态，
	 * 而我们提供的A还是托管状态。
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void merge(M po) throws DaoException;

	/**
	 * 返回给定ID的实体
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public M get(PK id) throws DaoException;

	/**
	 * 判断实体是否存在
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean exist(PK id) throws DaoException;

	/**
	 * 获取某个实体的所有数量
	 * @return
	 * @throws DaoException
	 */
	public int countAll() throws DaoException;

	
	/**
	 * 获取某个实体的所有数据
	 * @param clz
	 * @return
	 * @throws DaoException
	 */
	public List<M> listAll() throws DaoException;

    /**
     * 根据条件分页查询
     * @param pageSize
     * @param pageNow
     * @param conditionQuery
     * @param orderBy
     * @return
     * @throws DaoException
     */
	public List<M> executeQueryByPage(int pageSize,int pageNow,ConditionQuery conditionQuery,OrderBy orderBy) throws DaoException;	
	
	/**
	 * sql语句条件查询
	 * @param hql
	 * @return
	 * @throws DaoException
	 */
	public List<M> query(String hql) throws DaoException;


	/**
	 * 条件查询
	 * @param conditionQuery
	 * @param orderBy
	 * @return
	 * @throws DaoException
	 */
	public List<M> query(ConditionQuery conditionQuery,OrderBy orderBy) throws DaoException;


	/**
	 * @see org.hibernate.Session.flush()
	 * @throws DaoException
	 */
	public void flush() throws DaoException;


	/**
	 * @see org.hibernate.Session.clear()
	 * @throws DaoException
	 */
	public void clear() throws DaoException;
}

