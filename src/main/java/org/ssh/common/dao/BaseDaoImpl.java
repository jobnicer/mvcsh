package org.ssh.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ssh.common.ConditionQuery;
import org.ssh.common.OrderBy;
import org.ssh.common.exception.DaoException;
import org.ssh.common.model.BasePojo;


/**
 * Dao基类抽象类
 * @author Drunker
 * @version 2.2 2012/5/21
 */
public abstract class BaseDaoImpl<M extends BasePojo,PK extends Serializable> implements IBaseDao<M,PK> {

	protected static final Logger logger = Logger.getLogger(BaseDaoImpl.class);
	
	protected SessionFactory sessionFactory;
	private final Class<M> entityClass;
	private final String HQL_LIST_ALL;
	private final String HQL_COUNT_ALL;

	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 构造函数
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// 获取泛型的实际类型
		this.entityClass = (Class<M>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		HQL_LIST_ALL = "from " + this.entityClass.getSimpleName();
		HQL_COUNT_ALL = " select count(*) from " + this.entityClass.getSimpleName();
	}

	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public PK save(M po) throws DaoException {
		PK id = null;
		try {
			id = (PK)sessionFactory.getCurrentSession().save(po);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}
		return id;
	}

	public void delete(M po) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(po);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}

	}

	public void delete(PK id) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(get(id));
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}

	}

	public void update(M po) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(po);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}

	}

	public void saveOrUpdate(M po) throws DaoException {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(po);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}

	public void merge(M po) throws DaoException {
		try {
			sessionFactory.getCurrentSession().merge(po);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public M get(PK id) throws DaoException {
		M po = null;
		try {
			po = (M)sessionFactory.getCurrentSession().get(entityClass,id);
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}
		return po;
	}

	public boolean exist(PK id) throws DaoException {
		boolean flag = false;
		try {
			M po = get(id);
			if(po!=null)
				flag = true;
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}

		return flag;
	}

	public int countAll() throws DaoException {
		Long total = null;
		try{
			Query query = sessionFactory.getCurrentSession().createQuery(HQL_COUNT_ALL);
			total = (Long) query.uniqueResult();
		}catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}
		return total.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<M> listAll() throws DaoException {
		List<M> list = null;
		try{
			Query query = sessionFactory.getCurrentSession().createQuery(HQL_LIST_ALL);
			list = query.list();
		}catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}
		return list;
	}
	/**
     * 分页查询某个实体数据
     */
	@SuppressWarnings("unchecked")
    public List<M> executeQueryByPage(int pageSize,int pageNow,ConditionQuery conditionQuery,OrderBy orderBy) throws DaoException
    {
        List<M> list = null;
        try{
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(this.entityClass);
            conditionQuery.build(criteria);
            orderBy.build(criteria);
            criteria.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize);
            list=criteria.list();
        }catch (Exception e) {
            throw new DaoException(this.getClass(), e.getMessage());
        }
        return list;
    }
    
	@SuppressWarnings("unchecked")
	public List<M> query(String hql) throws DaoException {
		List<M> list = null;
		try{
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			list = query.list();
		}catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<M> query(ConditionQuery conditionQuery, OrderBy orderBy)
			throws DaoException {
		List<M> list = null;
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(this.entityClass);
			conditionQuery.build(criteria);
			orderBy.build(criteria);
			list = criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(this.getClass(), e.getMessage());
		}
		return list;
	}

	public void flush() throws DaoException {
		try{
			sessionFactory.getCurrentSession().flush();
		}catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}

	}

	public void clear() throws DaoException {
		try {
			sessionFactory.getCurrentSession().clear();
		} catch (Exception e) {
			throw new DaoException(this.getClass(), e.getMessage());
		}
	}
}
