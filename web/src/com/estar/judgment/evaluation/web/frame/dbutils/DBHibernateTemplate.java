package com.estar.judgment.evaluation.web.frame.dbutils;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.estar.judgment.evaluation.web.law.dto.ErrorRateDetailDto;
/**
 * * 将对数据库的操作封装。 由于spring不支持hibernate4的template 所以将来升级时修改此类 避免修改过多的业务模块代码
 * 
 * @ClassName: DBHibernateTemplate
 * @Description:
 * @author ZhangYong
 * @date 2013-8-25 下午03:12:24
 * 
 */
public class DBHibernateTemplate extends HibernateTemplate {

	protected final Log log = LogFactory.getLog(getClass());

	protected DBHibernateTemplate() {
		super();
	}

	@SuppressWarnings("unchecked")
	public Object getObject(String paramString) throws Exception {
		List list = find(paramString);
		if (list.iterator().hasNext()) {
			return list.iterator().next();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List getList(final String sqlstr) throws Exception {
		return find(sqlstr);
	}
	
	@SuppressWarnings("unchecked")
	public Map getList(final String sqlstr, final int iPageNo,final int iPageSize) throws Exception {
		return (Map<String, Object>) execute(new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Query query = session.createQuery(sqlstr);
						return setQueryPage(query, iPageNo, iPageSize);
					}
				});

	}
	
	@SuppressWarnings("unchecked")
	public List queryWithSql(final String sqlstr) throws Exception {
		
		List list = executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sqlstr);
				List list= query.list();
				return list;
			}
			
		});
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List queryWithSql(final String sqlstr,final Map mapps) throws Exception {
		
		List list = executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sqlstr);
				
				if (mapps != null && !mapps.isEmpty()) {
					Iterator<Object> it = mapps.keySet().iterator();
					while (it.hasNext()) {
						String numStr = (String) it.next();
						int num = Integer.parseInt(numStr);
						query.setParameter(num, mapps.get(numStr));
					}
				}
				
				
				List list= query.list();
				return list;
			}
			
		});
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	protected Map setQueryPage(final Query query, int pageNo, int pageSize) {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				String queryString = null;
				String hql = query.getQueryString().toString();
				int groupint = hql.toUpperCase().indexOf("GROUP");
				int distinctint = hql.toUpperCase().indexOf("DISTINCT");
				if ((groupint > 0) || (distinctint > 0)) {
					queryString = query.getQueryString();
					int inttmp = session.createQuery(queryString).list().size();
					Integer num = new Integer(inttmp);
					return num;
				}

				int j = hql.toUpperCase().indexOf("ORDER");

				if (j > 0) {
					hql = hql.substring(0, j);
				}
				if (hql.toUpperCase().indexOf("SELECT") != -1) {
					int i = hql.toUpperCase().indexOf("FROM");
					queryString = "Select count(*) "+ hql.substring(i, hql.length());
				} else {
					queryString = "Select count(*) " + hql;
				}

				// 设置分页起始记录号
				return (Long) session.createQuery(queryString).uniqueResult();

			}
		};

		Integer rectotal = new Integer(String.valueOf(execute(callback)));
		Integer pagetotal = (rectotal - 1) / pageSize + 1;
		if (pageNo > pagetotal) pageNo = pagetotal;
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("RecTotal", rectotal);
		map.put("PageTotal", pagetotal);
		map.put("List", query.list());
		return map;
	}

	@SuppressWarnings("unchecked")
	public Object getByPrimaryKey(Class type, Object pk) throws Exception {
		return get(type, (Serializable) pk);
	}
	
	@SuppressWarnings("unchecked")
	public List getList(final String sqlstr, final Map mapps) throws Exception {
		return (List) execute(new HibernateCallback() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				Query query = getQuery(session,sqlstr, mapps);
				return query.list();
			}
		});
	}
	
	
	@SuppressWarnings("unchecked")
	private Query getQuery(Session session,String sqlstr, Map mapps) {
		Query query = session.createQuery(sqlstr);
		if (mapps != null && !mapps.isEmpty()) {
			Iterator<Object> it = mapps.keySet().iterator();
			while (it.hasNext()) {
				String numStr = (String) it.next();
				int num = Integer.parseInt(numStr);
				query.setParameter(num, mapps.get(numStr));
			}
		}
		return query;
	}

	@SuppressWarnings("unchecked")
	public Map getList(final String sqlstr, final Map mapps, final int iPageNo,final int iPageSize) throws Exception {
		return (Map) execute(new HibernateCallback() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				return setQueryPage(session,sqlstr, mapps, iPageNo, iPageSize);
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	protected Map setQueryPage(Session session,final String sqlstr, final Map mapps, int iPageNo,int iPageSize) {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				Query query = getQuery(session,sqlstr,mapps);
				String hql = query.getQueryString().toString();
				String queryString = null;
				int groupint = hql.toUpperCase().indexOf(" GROUP ");
				int distinctint = hql.toUpperCase().indexOf(" DISTINCT ");
				if ((groupint > 0) || (distinctint > 0)) {
					queryString = query.getQueryString();
					int inttmp = query.list().size();
					Integer num = new Integer(inttmp);
					return num;
				}

				int j = query.getQueryString().toUpperCase().indexOf(" ORDER ");

				if (j > 0) {
					hql = hql.substring(0, j);
				}
				if (hql.toUpperCase().indexOf("SELECT") != -1) {
					int i = hql.toUpperCase().indexOf("FROM");
					queryString = "Select count(*) " + hql.substring(i, hql.length());
				} else {
					queryString = "Select count(*) " + hql;
				}
				return (Long)getQuery(session,queryString,mapps).uniqueResult();
			}
		};

		Integer rectotal = new Integer(String.valueOf(execute(callback)));
		Integer pagetotal = (rectotal - 1) / iPageSize + 1;

		if (iPageNo > pagetotal)iPageNo = pagetotal;
		Query query2 = getQuery(session,sqlstr,mapps);
		query2.setFirstResult((iPageNo - 1) * iPageSize);
		query2.setMaxResults(iPageSize);

		// 组织返回结果
		Map map = new HashMap();
		map.put("RecTotal", rectotal);
		map.put("PageTotal", pagetotal);
		map.put("List", query2.list());
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public void execute(final String sql) throws Exception {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				Query query = session.createQuery(sql);
				query.executeUpdate();
				return null;
			}
		};
		execute(callback);
	}
	
	@SuppressWarnings("unchecked")
	public void execute(final String sqlstr, final Map mapps) throws Exception {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				Query query = getQuery(session,sqlstr,mapps);
				query.executeUpdate();
				return null;
			}
		};
		execute(callback);
	}
}
