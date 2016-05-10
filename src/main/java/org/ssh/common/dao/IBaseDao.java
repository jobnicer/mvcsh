package org.ssh.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.ssh.common.ConditionQuery;
import org.ssh.common.OrderBy;
import org.ssh.common.exception.DaoException;
import org.ssh.common.model.BasePojo;


/**
 *  Dao����ӿ�
 * @author Drunker
 * @version 2.2
 * @date 2012-5-21 ����9:36:56
 */
public interface IBaseDao <M extends BasePojo,PK extends Serializable> {
	
	/**
	 * ��ȡ��ǰseesion
	 * @return
	 */
	public Session getSession();
	/**
	 * �־û�һ������A
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public PK save(M po) throws DaoException;


	/**
	 * �Ƴ�һ���־û�����A
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void delete(M po) throws DaoException;


	/**
	 * �Ƴ�һ���־û�����A
	 * @param id
	 * @throws DaoException
	 */
	public void delete(PK id) throws DaoException;


	/**
	 * ʹ��update��ʱ��ִ����ɺ������ṩ�Ķ���A��״̬��ɳ־û�״̬
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void update(M po) throws DaoException;

	/**
	 * ʹ��saveOrUpdateʱ������A������ʱ���־û�A������ʱ���޸Ķ������Գ־û���
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void saveOrUpdate(M po) throws DaoException;

	/**
	 * ʹ��merge��ʱ��ִ����ɣ������ṩ�Ķ���A�����ѹ�״̬��
	 * hibernate����new��һ��B�����߼����� һ���־ö���B��
	 * ���������ṩ�Ķ���A�����е�ֵ���������B��ִ����ɺ�B�ǳ־�״̬��
	 * �������ṩ��A�����й�״̬��
	 * 
	 * @param po
	 * @throws DaoException
	 */
	public void merge(M po) throws DaoException;

	/**
	 * ���ظ���ID��ʵ��
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public M get(PK id) throws DaoException;

	/**
	 * �ж�ʵ���Ƿ����
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean exist(PK id) throws DaoException;

	/**
	 * ��ȡĳ��ʵ�����������
	 * @return
	 * @throws DaoException
	 */
	public int countAll() throws DaoException;

	
	/**
	 * ��ȡĳ��ʵ�����������
	 * @param clz
	 * @return
	 * @throws DaoException
	 */
	public List<M> listAll() throws DaoException;

    /**
     * ����������ҳ��ѯ
     * @param pageSize
     * @param pageNow
     * @param conditionQuery
     * @param orderBy
     * @return
     * @throws DaoException
     */
	public List<M> executeQueryByPage(int pageSize,int pageNow,ConditionQuery conditionQuery,OrderBy orderBy) throws DaoException;	
	
	/**
	 * sql���������ѯ
	 * @param hql
	 * @return
	 * @throws DaoException
	 */
	public List<M> query(String hql) throws DaoException;


	/**
	 * ������ѯ
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

