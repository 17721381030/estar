package com.estar.judgment.evaluation.web.law.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseService;
import com.estar.judgment.evaluation.web.frame.dbutils.DBHibernateTemplate;
import com.estar.judgment.evaluation.web.law.dto.ErrorCasueRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorContentAndNumBycourtAndJudgeDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorContentAndNumDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorCourtRoomRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorCourtYearRateDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorJudgeNameRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorNumAndRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorRankRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorRateDetailDto;
import com.estar.judgment.evaluation.web.law.dto.ErrorYearRateDetailDto;
@Service
public class EchartsAnalysisService extends BaseService {
	@Autowired
	private  DBHibernateTemplate hp;
	
	@SuppressWarnings("unchecked")
	public List<ErrorRateDetailDto> getEchartRateDetail(){
		List<ErrorRateDetailDto> list = new ArrayList<ErrorRateDetailDto>();
		StringBuffer sql = new StringBuffer();
		//select totalnum.court,errnum.num/totalnum.num*100 as rate from (select a.court,count(*) as num from gz_judgment a
		sql.append("select totalnum.court,errnum.num/totalnum.num*100 as rate from (select a.court,count(DISTINCT(a.case_number)) as num from gz_judgment a "
					+"LEFT JOIN gz_judgment_info b "
					+"on a.id = b.id "
					+"where b.id is not null "
					+"and b.valid_flag <> 'N' "
					+"and (a.case_number not like '%终%' and a.case_number not like '%再%') "
					+"group by a.court "
					+"order by a.court) totalnum "
					+"left join "
					+"( "
					//+"select bb.court,count(*) as num from "
					+"select bb.court,count(DISTINCT(bb.case_number)) as num from "
					+"(select DISTINCT id from gz_judgment_error a "
					+"where a.user_defined_error_type <> 'I') aa "
					+"LEFT JOIN gz_judgment bb "
					+"on aa.id = bb.id "
					+"left join gz_judgment_info cc "
					+"on aa.id=cc.id "
					+"where aa.id is not null "
					+"and (bb.case_number not like '%终%' and bb.case_number not like '%再%') "
					+"and cc.valid_flag <> 'N' "
					+"group by bb.court "
					+"order by bb.court) errnum "
					+"on totalnum.court = errnum.court " 
					+"where errnum.court is not null");
		try {
			List queryList = hp.queryWithSql(sql.toString());
			for(int i=0;i<queryList.size();i++){
				Object[] objectArray =(Object[])queryList.get(i);
				ErrorRateDetailDto errorDetailDto = new ErrorRateDetailDto();
				errorDetailDto.setCourtName((String)objectArray[0]);
				errorDetailDto.setErrorRate((BigDecimal)objectArray[1]);
				list.add(errorDetailDto);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<ErrorRankRateDetailDto> getEchartRankRateDetail(){
		List<ErrorRankRateDetailDto> list = new ArrayList<ErrorRankRateDetailDto>();
		StringBuffer sql = new StringBuffer();
		//select totalnum.court,errnum.num/totalnum.num*100 as rate from (select a.court,count(*) as num from gz_judgment a
		sql.append("select totalnum.court,errnum.num/totalnum.num*100 as rate from (select a.court,count(DISTINCT(a.case_number)) as num from gz_judgment a "
					+"LEFT JOIN gz_judgment_info b "
					+"on a.id = b.id "
					+"where b.id is not null "
					+"and b.valid_flag <> 'N' "
					+"and (a.case_number not like '%终%' and a.case_number not like '%再%') "
					+"group by a.court "
					+"order by a.court) totalnum "
					+"left join "
					+"( "
					//+"select bb.court,count(*) as num from "
					+"select bb.court,count(DISTINCT(bb.case_number)) as num from "
					+"(select DISTINCT id from gz_judgment_error a "
					+"where a.user_defined_error_type <> 'I') aa "
					+"LEFT JOIN gz_judgment bb "
					+"on aa.id = bb.id "
					+"left join gz_judgment_info cc "
					+"on aa.id=cc.id "
					+"where aa.id is not null "
					+"and (bb.case_number not like '%终%' and bb.case_number not like '%再%') "
					+"and cc.valid_flag <> 'N' "
					+"group by bb.court "
					+"order by bb.court) errnum "
					+"on totalnum.court = errnum.court " 
					+"where errnum.court is not null "
					+"order by rate asc ");
		try {
			List queryList = hp.queryWithSql(sql.toString());
			String[] courtArray = new String[queryList.size()];
			BigDecimal[] errorRateArray = new BigDecimal[queryList.size()];
			for(int i=0;i<queryList.size();i++){
				Object[] objectArray =(Object[])queryList.get(i);
				courtArray[i] = (String)objectArray[0];
				errorRateArray[i] = (BigDecimal)objectArray[1];
			}
			ErrorRankRateDetailDto errorRankRateDetailDto = new ErrorRankRateDetailDto();
			errorRankRateDetailDto.setCourtArray(courtArray);
			errorRankRateDetailDto.setErrorRateArray(errorRateArray);
			list.add(errorRankRateDetailDto);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<ErrorNumAndRateDetailDto> getEchartNumberAndRateDetail(){
		
		List<ErrorNumAndRateDetailDto> list = new ArrayList<ErrorNumAndRateDetailDto>();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select totalnum.court,totalnum.num,errnum.num/totalnum.num*100 as rate from "
					//+"(select a.court,count(*) as num from gz_judgment a "
					+"(select a.court,count(DISTINCT(a.case_number)) as num from gz_judgment a "
					+"LEFT JOIN gz_judgment_info b "
					+"on a.id = b.id "
					+"where b.id is not null "
					+"and b.valid_flag <> 'N' "
					+"and (a.case_number not like '%终%' and a.case_number not like '%再%') "
					+"group by a.court "
					+"order by a.court) totalnum "
					+"left join "
					+"( "
					//+"select bb.court,count(*) as num from "
					+"select bb.court,count(DISTINCT(bb.case_number)) as num from "
					+"(select DISTINCT id from gz_judgment_error a "
					+"where a.user_defined_error_type <> 'I') aa "
					+"LEFT JOIN gz_judgment bb "
					+"on aa.id = bb.id "
					+"left join gz_judgment_info cc "
					+"on aa.id=cc.id "
					+"where aa.id is not null "
					+"and (bb.case_number not like '%终%' and bb.case_number not like '%再%') "
					+"and cc.valid_flag <> 'N' "
					+"group by bb.court "
					+"order by bb.court) errnum "
					+"on totalnum.court = errnum.court "
					+"where errnum.court is not null");
		
		try {
			List queryList = hp.queryWithSql(sql.toString());
			for(int i=0;i<queryList.size();i++){
				Object[] objectArray =(Object[])queryList.get(i);
				String courtName = (String)objectArray[0];
				BigInteger number = (BigInteger)objectArray[1];
				BigDecimal rate = (BigDecimal)objectArray[2];
				BigDecimal[] bigDecimals = new BigDecimal[3];
				bigDecimals[0] = new BigDecimal(i+1);
				bigDecimals[1] = rate;
				bigDecimals[2] = new BigDecimal(number);
				ErrorNumAndRateDetailDto errorNumAndRateDetailDto = new ErrorNumAndRateDetailDto();
				errorNumAndRateDetailDto.setCourtName(courtName);
				errorNumAndRateDetailDto.setNumAndRateArray(bigDecimals);
				list.add(errorNumAndRateDetailDto);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ErrorCasueRateDetailDto> getEchartCauseAndRateDetail(){
		
		List<ErrorCasueRateDetailDto> list = new ArrayList<ErrorCasueRateDetailDto>();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select totalnum.cause,totalnum.num,errnum.num/totalnum.num*100 as rate "
					+"from "
					//+"(select a.cause,count(*) as num from gz_judgment_info a "
					+"(select a.cause,count(DISTINCT(a.case_number)) as num from gz_judgment_info a "
					+"LEFT JOIN gz_judgment b "
					+"on a.id =b.id "
					+"where a.valid_flag <> 'N' "
					+"and b.id is not null "
					+"and (b.case_number not like '%终%' and b.case_number not like '%再%') "
					+"and a.cause <> '合同纠纷' and a.cause <> '纠纷' "
					+"group by a.cause "
					+"ORDER BY num desc "
					+"limit 20) totalnum "
					+"LEFT JOIN "
					//+"(select b.cause,count(*) as num from  "
					+"(select b.cause,count(DISTINCT(c.case_number)) as num from  "
					+"(select DISTINCT id from gz_judgment_error "
					+"where user_defined_error_type <> 'I') a "
					+"LEFT JOIN gz_judgment_info b "
					+"on a.id = b.id "
					+"LEFT JOIN gz_judgment c "
					+"on a.id = c.id "
					+"where b.valid_flag <> 'N' "
					+"and b.id is not null "
					+"and c.id is not null "
					+"and (c.case_number not like '%终%' and c.case_number not like '%再%') "
					+"and b.cause <> '合同纠纷' and b.cause <> '纠纷' "
					+"group by b.cause) errnum "
					+"on totalnum.cause = errnum.cause "
					+"where errnum.cause is not null");
		
		try {
			List queryList = hp.queryWithSql(sql.toString());
			for(int i=0;i<queryList.size();i++){
				Object[] objectArray =(Object[])queryList.get(i);
				String caueName = (String)objectArray[0];
				BigInteger number = (BigInteger)objectArray[1];
				BigDecimal rate = (BigDecimal)objectArray[2];
				
				BigDecimal[] bigDecimals = new BigDecimal[3];
				bigDecimals[0] = new BigDecimal(i+1);
				bigDecimals[1] = rate;
				bigDecimals[2] = new BigDecimal(number);
				ErrorCasueRateDetailDto errorCasueRateDetailDto = new ErrorCasueRateDetailDto();
				errorCasueRateDetailDto.setCauseName(caueName);
				errorCasueRateDetailDto.setCauseAndRateArray(bigDecimals);
				list.add(errorCasueRateDetailDto);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ErrorContentAndNumDetailDto> getErrorContentAndNumDetail(){
		
		List<ErrorContentAndNumDetailDto> list = new ArrayList<ErrorContentAndNumDetailDto>();
		
		StringBuffer sql = new StringBuffer();
		//select a.error_content,count(*) as num from gz_judgment_error a
		sql.append("select a.error_content,count(DISTINCT(c.case_number)) as num from gz_judgment_error a "
					+"LEFT JOIN gz_judgment_info b "
					+"on a.id = b.id "
					+"LEFT JOIN gz_judgment c "
					+"on a.id = c.id "
					+"where a.user_defined_error_type <> 'I' "
					+"and b.valid_flag <> 'N' "
					+"and (c.case_number not like '%终%' and c.case_number not like '%再%') "
					+"group by a.error_content "
					+"order by num");
		
		try {
			List queryList = hp.queryWithSql(sql.toString());
			String[] errorContentArray = new String[queryList.size()];
			BigInteger[] numArray = new BigInteger[queryList.size()];
			for(int i=0;i<queryList.size();i++){
				Object[] objectArray =(Object[])queryList.get(i);
				String errorContent = (String)objectArray[0];
				BigInteger number = (BigInteger)objectArray[1];
				errorContentArray[i] = errorContent;
				numArray[i]= number;
			}
			ErrorContentAndNumDetailDto errorContentAndNumDetailDto = new ErrorContentAndNumDetailDto();
			errorContentAndNumDetailDto.setErrorContentArray(errorContentArray);
			errorContentAndNumDetailDto.setNumberArray(numArray);
			list.add(errorContentAndNumDetailDto);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
		
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ErrorContentAndNumBycourtAndJudgeDetailDto> getErrorContentAndNumBycourtAndjude(String court,String courtRoom ,String judge){
		
		List<ErrorContentAndNumBycourtAndJudgeDetailDto> list = new ArrayList<ErrorContentAndNumBycourtAndJudgeDetailDto>();
		
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		//select a.error_content,count(*) as num from gz_judgment_error a
		sql.append("select a.error_content,count(DISTINCT(c.case_number)) as num from gz_judgment_error a "
					+"LEFT JOIN gz_judgment_info b "
					+"on a.id = b.id "
					+"LEFT JOIN gz_judgment c "
					+"on a.id = c.id "
					+"where a.user_defined_error_type <> 'I' "
					+"and b.valid_flag <> 'N' "
					+"and (c.case_number not like '%终%' and c.case_number not like '%再%') ");
		if(court != null){
			sql.append("and c.court = ?  ");
			para.add(court);
		}
		if(courtRoom != null){
			sql.append("and b.courtroom = ? ");
			para.add(courtRoom);
		}
		if(judge != null){
			sql.append("and b.judge = ? ");
			para.add(judge);
		}
		sql.append("group by a.error_content "
					+"order by num");
		try {
			List queryList = hp.queryWithSql(sql.toString(),list2Map(para));
			for(int i=0;i<queryList.size();i++){
				Object[] objectArray =(Object[])queryList.get(i);
				String errorContent = (String)objectArray[0];
				BigInteger number = (BigInteger)objectArray[1];
				ErrorContentAndNumBycourtAndJudgeDetailDto detailDto = new ErrorContentAndNumBycourtAndJudgeDetailDto();
				detailDto.setNum(number);
				detailDto.setErrorContent(modifyErrorContentName(errorContent));
				list.add(detailDto);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
		
		
		
	}
	
	private static String modifyErrorContentName(String errorContent){
		if("法院名称".equals(errorContent)){
			errorContent = "法院名称瑕疵";
		}else if ("文书名称".equals(errorContent)) {
			errorContent = "文书名称瑕疵";
		}else if ("案号".equals(errorContent)) {
			errorContent = "案号瑕疵";
		}else if ("原告".equals(errorContent)) {
			errorContent = "原告记载瑕疵";
		}
		else if ("被告".equals(errorContent)) {
			errorContent = "被告记载瑕疵";
		}
		else if ("第三人".equals(errorContent)) {
			errorContent = "第三人记载瑕疵";
		}
		else if ("原告陈述".equals(errorContent)) {
			errorContent = "原告陈述瑕疵";
		}
		else if ("原告举证".equals(errorContent)) {
			errorContent = "原告举证瑕疵";
		}
		else if ("被告答辩和事实查明".equals(errorContent)) {
			errorContent = "被告辩称瑕疵";
		}
		else if ("案由和审理经过".equals(errorContent)) {
			errorContent = "审理经过书写瑕疵";
		}
		else if ("诉请".equals(errorContent)) {
			errorContent = "诉请记载瑕疵";
		}
		else if ("文书论理".equals(errorContent)) {
			errorContent = "文书论理瑕疵";
		}
		else if ("法律条文".equals(errorContent)) {
			errorContent = "法条书写瑕疵";
		}
		else if ("判决".equals(errorContent)) {
			errorContent = "判决主文瑕疵";
		}
		else if ("诉讼权利义务告知".equals(errorContent)) {
			errorContent = "诉讼权利义务告知瑕疵";
		}
		else if ("审判组织和落款日期".equals(errorContent)) {
			errorContent = "审判组织瑕疵";
		}
		else if ("附相关法律条文".equals(errorContent)) {
			errorContent = "附法律条文瑕疵";
		}
		else if ("法条适用瑕疵".equals(errorContent)) {
			errorContent = "无判诉求瑕疵";
		}
		else if ("法条适用".equals(errorContent)) {
			errorContent = "法条适用瑕疵";
		}
		else if ("判决内容".equals(errorContent)) {
			errorContent = "无诉判决瑕疵";
		}
		return errorContent;
	}
	
	@SuppressWarnings("unchecked")
	public List<ErrorYearRateDetailDto> getEchartYearRateDetail(){
		List<ErrorYearRateDetailDto> list = new ArrayList<ErrorYearRateDetailDto>();
		StringBuffer sql = new StringBuffer();
		sql.append("select totalnum.court,totalnum.case_number_year,errnum.num/totalnum.num*100 as rate "
				+"from "
				//+"(select cc.case_number_year as case_number_year,bb.court as court,count(*) as num from "
				+"(select DATE_FORMAT(bb.CREATEDATE,'%y/%m') as case_number_year,bb.court as court,count(distinct bb.case_number) as num from "
				+"(select DISTINCT id from gz_judgment_error a "
				+"where a.user_defined_error_type <> 'I') aa "
				+"left join gz_judgment bb "
				+"on aa.id = bb.id "
				+"left join gz_judgment_info cc "
				+"on aa.id=cc.id "
				+"where bb.id is not null "
				+"and (bb.case_number not like '%终%' and bb.case_number not like '%再%') "
				+"and cc.id is not null "
				+"and cc.valid_flag <> 'N' "
				+"and cc.case_number_year is not null "
			  //+"group by cc.case_number_year,bb.court) errnum "	
				+"group by DATE_FORMAT(bb.CREATEDATE,'%y/%m'),bb.court) errnum "
				+"left join "
				+"(select DATE_FORMAT(b.CREATEDATE,'%y/%m') as case_number_year,b.court as court,count(distinct b.case_number) as num "
				+"from gz_judgment_info a "
				+"left join gz_judgment b "
				+"on a.id = b.id "
				+"where a.valid_flag <> 'N' "
				+"and b.id is not null "
				+"and (b.case_number not like '%终%' and b.case_number not like '%再%') "
				+"and a.case_number_year is not null "
				//+"group by a.case_number_year,b.court) totalnum "
				+"group by DATE_FORMAT(b.CREATEDATE,'%y/%m'),b.court) totalnum "
				+"on totalnum.court = errnum.court and totalnum.case_number_year = errnum.case_number_year "
				+"where totalnum.court is not null "
				+"and totalnum.case_number_year is not null "
				//+"and totalnum.case_number_year BETWEEN 2000 and year(now()) "
				+"order by totalnum.court,totalnum.case_number_year asc");
		try {
			List queryList = hp.queryWithSql(sql.toString());
			list = getSortErrorYearRateDetail(queryList);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
		
	}
	
//	@SuppressWarnings("unchecked")
//	public List<ErrorCourtYearRateDto> getEchartCourtYearRateBycourtAndTrialProduce(String court,String trial_procedure){
//		List<ErrorCourtYearRateDto> list = new ArrayList<ErrorCourtYearRateDto>();
//		StringBuffer sql = new StringBuffer();
//		List para = new ArrayList();
//		sql.append("select totalnum.case_number_year,errnum.num/totalnum.num*100 as rate "
//					+"from "
//					//+"(select cc.case_number_year as case_number_year,count(*) as num from  "
//					+"(select DATE_FORMAT(bb.CREATEDATE,'%y/%m') as case_number_year,count(distinct bb.case_number) as num from  "
//					+"(select DISTINCT id from gz_judgment_error a "
//					+"where a.user_defined_error_type <> 'I') aa "
//					+"left join gz_judgment bb "
//					+"on aa.id = bb.id "
//					+"left join gz_judgment_info cc "
//					+"on aa.id=cc.id "
//					+"where bb.id is not null " 
//					+"and (bb.case_number not like '%终%' and bb.case_number not like '%再%') "
//					+"and cc.id is not null "
//					+"and cc.valid_flag <> 'N' "
//					+"and cc.case_number_year is not null "
//					+"and bb.court= ? "
//					+"and cc.trial_procedure = ? "
//					//+"group by cc.case_number_year) errnum "
//					+"group by DATE_FORMAT(bb.CREATEDATE,'%y/%m')) errnum "
//					+"left join "
//					//+"(select a.case_number_year as case_number_year,count(*) as num "
//					+"(select DATE_FORMAT(b.CREATEDATE,'%y/%m') as case_number_year,count(distinct b.case_number) as num "
//					+"from gz_judgment_info a "
//					+"left join gz_judgment b "
//					+"on a.id = b.id "
//					+"where a.valid_flag <> 'N' "
//					+"and b.id is not null "
//					+"and (b.case_number not like '%终%' and b.case_number not like '%再%') "
//					+"and a.case_number_year is not null "
//					+"and b.court= ? "
//					+"and a.trial_procedure = ? "
//					//+"group by a.case_number_year) totalnum "
//					+"group by DATE_FORMAT(b.CREATEDATE,'%y/%m')) totalnum "
//					+"on totalnum.case_number_year = errnum.case_number_year "
//					+"where totalnum.case_number_year is not null "
//					//+"and totalnum.case_number_year BETWEEN 2000 and year(now()) "
//					+"order by totalnum.case_number_year asc");
//		para.add(court);
//		para.add(trial_procedure);
//		para.add(court);
//		para.add(trial_procedure);
//		try {
//			List queryList = hp.queryWithSql(sql.toString(),list2Map(para));
//			
//			String[] courtYearArray = new String[queryList.size()];
//			BigDecimal[] courtErrorRateArray = new BigDecimal[queryList.size()];
//			for(int i=0;i<queryList.size();i++){
//				Object[] objectArray =(Object[])queryList.get(i);
//				String year= (String)objectArray[0];
//				BigDecimal rate= (BigDecimal)objectArray[1];
//				courtYearArray[i] = year;
//				courtErrorRateArray[i]= rate;
//			}
//			ErrorCourtYearRateDto errorCourtYearRateDto = new ErrorCourtYearRateDto();
//			errorCourtYearRateDto.setCourtErrorRateArray(courtErrorRateArray);
//			errorCourtYearRateDto.setCourtYearArray(courtYearArray);
//			list.add(errorCourtYearRateDto);
//		} catch (Exception e) {;
//			
//			e.printStackTrace();
//		}
//		return list;
//		
//	}
	
	
	@SuppressWarnings("unchecked")
	public List<ErrorCourtYearRateDto> getEchartCourtYearRateBycourtAndTrialProduce(String court){
		List<ErrorCourtYearRateDto> list = new ArrayList<ErrorCourtYearRateDto>();
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select totalnum.case_number_year,totalnum.trial_procedure,errnum.num/totalnum.num*100 as rate "
					+"from "
					//+"(select cc.case_number_year as case_number_year,count(*) as num from  "
					+"(select DATE_FORMAT(bb.CREATEDATE,'%y/%m') as case_number_year,cc.trial_procedure as trial_procedure ,count(distinct bb.case_number) as num from  "
					+"(select DISTINCT id from gz_judgment_error a "
					+"where a.user_defined_error_type <> 'I') aa "
					+"left join gz_judgment bb "
					+"on aa.id = bb.id "
					+"left join gz_judgment_info cc "
					+"on aa.id=cc.id "
					+"where bb.id is not null " 
					+"and (bb.case_number not like '%终%' and bb.case_number not like '%再%') "
					+"and cc.id is not null "
					+"and cc.valid_flag <> 'N' "
					+"and cc.case_number_year is not null "
					+"and bb.court= ? "
					//+"and cc.trial_procedure = ? "
					//+"group by cc.case_number_year) errnum "
					+"group by DATE_FORMAT(bb.CREATEDATE,'%y/%m'),cc.trial_procedure) errnum "
					+"left join "
					//+"(select a.case_number_year as case_number_year,count(*) as num "
					+"(select DATE_FORMAT(b.CREATEDATE,'%y/%m') as case_number_year,a.trial_procedure as trial_procedure ,count(distinct b.case_number) as num "
					+"from gz_judgment_info a "
					+"left join gz_judgment b "
					+"on a.id = b.id "
					+"where a.valid_flag <> 'N' "
					+"and b.id is not null "
					+"and (b.case_number not like '%终%' and b.case_number not like '%再%') "
					+"and a.case_number_year is not null "
					+"and b.court= ? "
					//+"and a.trial_procedure = ? "
					//+"group by a.case_number_year) totalnum "
					+"group by DATE_FORMAT(b.CREATEDATE,'%y/%m'),a.trial_procedure) totalnum "
					+"on totalnum.case_number_year = errnum.case_number_year and totalnum.trial_procedure = errnum.trial_procedure "
					+"where totalnum.case_number_year is not null "
					//+"and totalnum.case_number_year BETWEEN 2000 and year(now()) "
					+"order by totalnum.case_number_year asc");
		para.add(court);
		para.add(court);
		try {
			List queryList = hp.queryWithSql(sql.toString(),list2Map(para));
			
			List<String> scourtYearList = new ArrayList<String>();
			List<BigDecimal> scourtErrorRateList = new ArrayList<BigDecimal>();
			List<String> gcourtYearList = new ArrayList<String>();
			List<BigDecimal> gcourtErrorRateList = new ArrayList<BigDecimal>();
			for(int i=0;i<queryList.size();i++){
				Object[] objectArray =(Object[])queryList.get(i);
				String trialProcedure = String.valueOf((Character)objectArray[1]);
				if("G".endsWith(trialProcedure)){
					String year= (String)objectArray[0];
					BigDecimal rate= (BigDecimal)objectArray[2];
					gcourtYearList.add(year);
					gcourtErrorRateList.add(rate);
				}else{
					String year= (String)objectArray[0];
					BigDecimal rate= (BigDecimal)objectArray[2];
					scourtYearList.add(year);
					scourtErrorRateList.add(rate);
				}
				
			}
			ErrorCourtYearRateDto errorCourtYearRateDto = new ErrorCourtYearRateDto();
			errorCourtYearRateDto.setScourtErrorRateArray((BigDecimal[])scourtErrorRateList.toArray(new BigDecimal[scourtErrorRateList.size()]));
			errorCourtYearRateDto.setGcourtErrorRateArray((BigDecimal[])gcourtErrorRateList.toArray(new BigDecimal[gcourtErrorRateList.size()]));
			errorCourtYearRateDto.setCourtYearArray((String[])scourtYearList.toArray(new String[scourtYearList.size()]));
			list.add(errorCourtYearRateDto);
		} catch (Exception e) {;
			
			e.printStackTrace();
		}
		return list;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ErrorCourtRoomRateDetailDto> getErrorCourtRoomRateDetailDto(String court){
		List<ErrorCourtRoomRateDetailDto> list = new ArrayList<ErrorCourtRoomRateDetailDto>();
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select concat(totalnum.court,'/',totalnum.courtroom),IFNULL(errnum.num,0)/totalnum.num*100 as rate "
					+"from "
					+"(select b.court as court,a.courtroom as courtroom,count(distinct a.case_number) as num " 
					+"from gz_judgment_info a "
					+"left join gz_judgment b "
					+"on a.id = b.id "
					+"where a.valid_flag <> 'N' "
					+"and b.id is not null "
					+"and (b.case_number not like '%终%' and b.case_number not like '%再%') "
					+"and a.case_number_year is not null "
					+"and (a.courtroom is not null or a.courtroom <>'') "
					+"and b.court = ? "
					+"group by b.court,a.courtroom) totalnum  "
					+"left join "
					+"(select bb.court as court,cc.courtroom as courtroom,count(distinct bb.case_number) as num from  "
					+"(select DISTINCT id from gz_judgment_error a "
					+"where a.user_defined_error_type <> 'I') aa  "
					+"left join gz_judgment bb "
					+"on aa.id = bb.id "
					+"left join gz_judgment_info cc "
					+"on aa.id=cc.id "
					+"where bb.id is not null  "
					+"and (bb.case_number not like '%终%' and bb.case_number not like '%再%') "
					+"and cc.id is not null "
					+"and cc.valid_flag <> 'N' "
					+"and (cc.courtroom is not null or cc.courtroom <>'') "
					+"and bb.court = ? "
					+"group by bb.court,cc.courtroom) errnum "
					+"on totalnum.court = errnum.court and totalnum.courtroom = errnum.courtroom "
					+"order by rate desc ");
		para.add(court);
		para.add(court);
		try {
			List queryList = hp.queryWithSql(sql.toString(),list2Map(para));
			
			String[] courtRoomArray = new String[queryList.size()];
			BigDecimal[] errorRateArray = new BigDecimal[queryList.size()];
			for(int i=0;i<queryList.size();i++){
				Object[] objectArray =(Object[])queryList.get(i);
				String courtRoom= (String)objectArray[0];
				BigDecimal rate= (BigDecimal)objectArray[1];
				courtRoomArray[i] = courtRoom;
				errorRateArray[i]= rate;
			}
			ErrorCourtRoomRateDetailDto errorCourtRoomRateDetailDto = new ErrorCourtRoomRateDetailDto();
			errorCourtRoomRateDetailDto.setCourtRoomArray(courtRoomArray);
			errorCourtRoomRateDetailDto.setErrorRateArray(errorRateArray);
			list.add(errorCourtRoomRateDetailDto);
		} catch (Exception e) {;
			
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ErrorJudgeNameRateDetailDto> getErrorJudgeRateDetail(String court,String courtRoom){
		List<ErrorJudgeNameRateDetailDto> list = new ArrayList<ErrorJudgeNameRateDetailDto>();
		StringBuffer sql = new StringBuffer();
		List para = new ArrayList();
		sql.append("select concat(totalnum.court,'/',totalnum.courtroom,'/',totalnum.judge),IFNULL(errnum.num,0)/totalnum.num*100 as rate  "
					+"from "
					+"(select b.court as court,a.courtroom as courtroom,a.judge as judge,count(distinct a.case_number) as num  "
					+"from gz_judgment_info a  "
					+"left join gz_judgment b  "
					+"on a.id = b.id "
					+"where a.valid_flag <> 'N'  "
					+"and b.id is not null  "
					+"and (b.case_number not like '%终%' and b.case_number not like '%再%') "
					+"and a.case_number_year is not null "
					+"and (a.courtroom is not null or a.courtroom <>'') "
					+"and a.judge is not null "
					+"and b.court = ? "
					+"and a.courtroom = ? "
					+"group by b.court,a.courtroom,a.judge) totalnum  "
					+"left join "
					+"(select bb.court as court,cc.courtroom as courtroom,cc.judge as judge,count(distinct bb.case_number) as num from  "
					+"(select DISTINCT id from gz_judgment_error a "
					+"where a.user_defined_error_type <> 'I') aa  "
					+"left join gz_judgment bb "
					+"on aa.id = bb.id "
					+"left join gz_judgment_info cc "
					+"on aa.id=cc.id "
					+"where bb.id is not null  "
					+"and (bb.case_number not like '%终%' and bb.case_number not like '%再%') "
					+"and cc.id is not null "
					+"and cc.valid_flag <> 'N' "
					+"and (cc.courtroom is not null or cc.courtroom <>'') "
					+"and cc.judge is not null "
					+"and bb.court = ? "
					+"and cc.courtroom = ? "
					+"group by bb.court,cc.courtroom,cc.judge) errnum "
					+"on totalnum.court = errnum.court  "
					+"and totalnum.courtroom = errnum.courtroom "
					+"and totalnum.judge = errnum.judge "
					+"order by rate desc ");
		para.add(court);
		para.add(courtRoom);
		para.add(court);
		para.add(courtRoom);
		try {
			List queryList = hp.queryWithSql(sql.toString(),list2Map(para));
			
			String[] judgeNameArray = new String[queryList.size()];
			BigDecimal[] errorRateArray = new BigDecimal[queryList.size()];
			for(int i=0;i<queryList.size();i++){
				Object[] objectArray =(Object[])queryList.get(i);
				String judgeName= (String)objectArray[0];
				BigDecimal rate= (BigDecimal)objectArray[1];
				judgeNameArray[i] = judgeName;
				errorRateArray[i]= rate;
			}
			ErrorJudgeNameRateDetailDto errorJudgeNameRateDetailDto = new ErrorJudgeNameRateDetailDto();
			errorJudgeNameRateDetailDto.setErrorRateArray(errorRateArray);
			errorJudgeNameRateDetailDto.setJudgeNameArray(judgeNameArray);
			list.add(errorJudgeNameRateDetailDto);
		} catch (Exception e) {;
			
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	@SuppressWarnings("unchecked")
	private List<ErrorYearRateDetailDto>  getSortErrorYearRateDetail(List list){
		
		List<ErrorYearRateDetailDto> errorYearRateDetailDtoList = new ArrayList<ErrorYearRateDetailDto>();
		Map<String, List<String>> yearMap = new HashMap<String, List<String>>();
		Map<String, List<BigDecimal>> rateMap = new HashMap<String, List<BigDecimal>>();
		for(int m = 0; m< list.size(); m++){
			Object[] objectArray =(Object[])list.get(m);
			String courtName = (String)objectArray[0];
			//String year = String.valueOf((Integer)objectArray[1]);
			String year = (String)objectArray[1];
			BigDecimal rate = (BigDecimal)objectArray[2];
			if(yearMap.containsKey(courtName) && rateMap.containsKey(courtName) ){
				List<String> yeaList = yearMap.get(courtName);
				List<BigDecimal> rateList = rateMap.get(courtName);
				yeaList.add(year);
				rateList.add(rate);
			}else{
				List<String> yeaList = new ArrayList<String>();
				List<BigDecimal> rateList = new ArrayList<BigDecimal>();
				yeaList.add(year);
				rateList.add(rate);
				yearMap.put(courtName, yeaList);
				rateMap.put(courtName, rateList);
			}
			
		}
		
		
		for(String key :yearMap.keySet()){
			ErrorYearRateDetailDto errorYearRateDetailDto = new ErrorYearRateDetailDto();
			errorYearRateDetailDto.setCourtName(key);
			errorYearRateDetailDto.setYearArray((String[]) yearMap.get(key).toArray(new String[yearMap.get(key).size()]));
			errorYearRateDetailDto.setErrorRateArray((BigDecimal[])rateMap.get(key).toArray(new BigDecimal[rateMap.get(key).size()]));
			errorYearRateDetailDtoList.add(errorYearRateDetailDto);
		}
		
		
		return errorYearRateDetailDtoList;
	}
}
