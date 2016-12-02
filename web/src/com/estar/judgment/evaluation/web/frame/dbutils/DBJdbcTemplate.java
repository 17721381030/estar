package com.estar.judgment.evaluation.web.frame.dbutils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

/**
 * 将对数据库的操作封装 留作扩展
* @ClassName: DBJdbcTemplate
* @Description: 
* @author ZhangYong
* @date 2013-8-25 下午03:12:17
*
 */
public class DBJdbcTemplate extends JdbcTemplate {
	protected final Log log = LogFactory.getLog(getClass());

	private final String DB_MYSQL = "dbMySQL";
	private final String DB_ORACLE = "dbOracle";
	
	private String dbName;
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	@SuppressWarnings("unchecked")
	public List getList(String sqlstr, RowMapper rowMapper) throws Exception{
		List list = (List) query(sqlstr,new RowMapperResultSetExtractor(rowMapper));
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List getList(String sqlstr, Object[] args, RowMapper rowMapper)throws Exception{
		List list = (List) query(sqlstr, args, new RowMapperResultSetExtractor(rowMapper));
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Map getList(String sqlstr, int iPageNo, int iPageSize, RowMapper rowMapper)throws Exception {
		Map map = null;
		if (dbName.equals(DB_MYSQL)) {
			map = getMysqlPageMap(sqlstr, iPageNo, iPageSize,rowMapper);
		} else if (dbName.equals(DB_ORACLE)) {
			map = getOraclePageMap(sqlstr, iPageNo, iPageSize,	rowMapper);
		}
			
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map getList(String sqlstr, Object[] args, int iPageNo,int iPageSize, RowMapper rowMapper)throws Exception  {
		Map map = null;
		if (dbName.equals(DB_MYSQL)) {
			map = getMysqlPageMap(sqlstr, args, iPageNo, iPageSize,rowMapper);
		} else if (dbName.equals(DB_ORACLE)) {
			map = getOraclePageMap(sqlstr, args, iPageNo, iPageSize,rowMapper);
		}
		return map;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map getMysqlPageMap(String sql, int pageNo, int pageSize,RowMapper rowMapper)throws Exception  {
		HashMap hashmap = null;
		int recTotal = 0;
		int actualPageNo = 1;
		String sbak = "";
		if (pageSize < 1) {
			throw new Exception("页面大小(pageSize)不能为0或者为负数！");
		}
		// 首先精确的获取记录集的大小
		sbak = "select count(*) from (" + sql + ") a";
		recTotal = queryForInt(sbak);
		int pageTotal = (recTotal - 1) / pageSize + 1;

		// 获得实际有效的页码
		actualPageNo = pageNo < 1 ? 1 : (pageNo > pageTotal ? pageTotal: pageNo);

		sbak = "select * from (" + sql + ") a limit "
				+ String.valueOf((actualPageNo - 1) * pageSize) + ","
				+ pageSize;
		List list = (List) query(sbak,new RowMapperResultSetExtractor(rowMapper));

		// 组织返回的HashMap
		hashmap = new HashMap();
		hashmap.put("PageTotal", new Integer(pageTotal));
		hashmap.put("RecTotal", new Integer(recTotal));
		hashmap.put("List", list);

		return hashmap;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map getMysqlPageMap(String sql, Object[] args, int pageNo,int pageSize, RowMapper rowMapper)throws Exception {
		HashMap hashmap = null;
		int recTotal = 0;
		int actualPageNo = 1;
		String sbak = "";
		if (pageSize < 1) {
			throw new Exception("页面大小(pageSize)不能为0或者为负数！");
		}
		// 首先精确的获取记录集的大小
		sbak = "select count(*) from (" + sql + ") a";
		recTotal = queryForInt(sbak, args);
		int pageTotal = (recTotal - 1) / pageSize + 1;

		// 获得实际有效的页码
		actualPageNo = pageNo < 1 ? 1 : (pageNo > pageTotal ? pageTotal: pageNo);

		sbak = "select * from (" + sql + ") a limit "
				+ String.valueOf((actualPageNo - 1) * pageSize) + ","
				+ pageSize;
		List list = (List) query(sbak, args,new RowMapperResultSetExtractor(rowMapper));

		// 组织返回的HashMap
		hashmap = new HashMap();
		hashmap.put("PageTotal", new Integer(pageTotal));
		hashmap.put("RecTotal", new Integer(recTotal));
		hashmap.put("List", list);
		return hashmap;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map getOraclePageMap(String sql, int pageNo, int pageSize,RowMapper rowMapper)throws Exception  {
		HashMap hashmap = null;
		int recTotal = 0;
		int actualPageNo = 1;
		String sbak = "";
		if (pageSize < 1) {
			throw new Exception("页面大小(pageSize)不能为0或者为负数！");
		}
		// 首先精确的获取记录集的大小
		sbak = "select count(*) from (" + sql + ")";
		recTotal = queryForInt(sbak);

		int pageTotal = (recTotal - 1) / pageSize + 1;

		// 获得实际有效的页码
		actualPageNo = pageNo < 1 ? 1 : (pageNo > pageTotal ? pageTotal: pageNo);

		sbak = "select * from (select row_.*,rownum as orarownum from ("
				+ sql + ") row_ where rownum < "
				+ String.valueOf(actualPageNo * pageSize + 1)
				+ ") where orarownum >= "
				+ String.valueOf((actualPageNo - 1) * pageSize + 1);
		List list = (List) query(sbak,new RowMapperResultSetExtractor(rowMapper));

		// 组织返回的HashMap
		hashmap = new HashMap();
		hashmap.put("PageTotal", new Integer(pageTotal));
		hashmap.put("RecTotal", new Integer(recTotal));
		hashmap.put("List", list);
		return hashmap;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map getOraclePageMap(String sql, Object[] args, int pageNo,int pageSize, RowMapper rowMapper)throws Exception {
		HashMap hashmap = null;
		int recTotal = 0;
		int actualPageNo = 1;
		String sbak = "";
		if (pageSize < 1) {
			throw new Exception("页面大小(pageSize)不能为0或者为负数！");
		}
		// 首先精确的获取记录集的大小
		sbak = "select count(*) from (" + sql + ")";
		recTotal = queryForInt(sbak, args);
		int pageTotal = (recTotal - 1) / pageSize + 1;

		// 获得实际有效的页码
		actualPageNo = pageNo < 1 ? 1 : (pageNo > pageTotal ? pageTotal: pageNo);

		sbak = "select * from (select row_.*,rownum as orarownum from ("
				+ sql + ") row_ where rownum < "
				+ String.valueOf(actualPageNo * pageSize + 1)
				+ ") where orarownum >= "
				+ String.valueOf((actualPageNo - 1) * pageSize + 1);
		List list = (List) query(sbak, args,new RowMapperResultSetExtractor(rowMapper));

		// 组织返回的HashMap
		hashmap = new HashMap();
		hashmap.put("PageTotal", new Integer(pageTotal));
		hashmap.put("RecTotal", new Integer(recTotal));
		hashmap.put("List", list);
		return hashmap;
	}
}
