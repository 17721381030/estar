package com.estar.judgment.evaluation.web.frame.baseobj;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;


public class BaseDTO implements RowMapper<Object>, Serializable {
	private static final long serialVersionUID = 1L;
	private int pageSize = 15;
	private int pageNo = 1;
	
	private int recTotal = 0;
	private int pageTotal = 0;
	@SuppressWarnings("unchecked")
	private List list;
	private String view = "0";
	
	private String strUpdateDate;
	/**
	 * listResult
	 * 0 待查询
	 * 1 无数据
	 * 2 有数据
	 */
	private int listResult = 0;
	
	
	@Override
	public Object mapRow(final ResultSet arg0, final int arg1) throws SQLException {
		return null;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(final int pageNo) {
		this.pageNo = pageNo;
	}

	@SuppressWarnings("unchecked")
	public List getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	public void setList(final List list) {
		this.list = list;
	}

	public int getListResult() {
		return listResult;
	}

	public void setListResult(final int listResult) {
		this.listResult = listResult;
	}

	public int getRecTotal() {
		return recTotal;
	}

	public void setRecTotal(final int recTotal) {
		this.recTotal = recTotal;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(final int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public String getView() {
		return view;
	}

	public void setView(final String view) {
		this.view = view;
	}

	public String getStrUpdateDate() {
		return strUpdateDate;
	}

	public void setStrUpdateDate(final String strUpdateDate) {
		this.strUpdateDate = strUpdateDate;
	}
}
