package com.estar.judgment.evaluation.web.law.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.frame.util.ContentType;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.evaluation.web.law.dto.AllJudgmentInfoDTO;
import com.estar.judgment.evaluation.web.law.dto.AllJudgmentPartyDTO;
import com.estar.judgment.evaluation.web.law.dto.M2JudgmentInfoDTO;
import com.estar.judgment.evaluation.web.law.service.AllJudgmentInfoService;

@Scope("prototype")  
public class BatchAnalysisArticleAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AllJudgmentInfoService judgmentInfoService;
//	@Autowired
//	private M2JudgmentInfoService m2JudgmentInfoService;
//	@Autowired
//	private AllJudgmentPartyService judgmentPartyService;

	private M2JudgmentInfoDTO d = new M2JudgmentInfoDTO();
	private M2JudgmentInfoDTO s = new M2JudgmentInfoDTO();
	private AllJudgmentInfoDTO a = new AllJudgmentInfoDTO();
	private AllJudgmentPartyDTO p = new AllJudgmentPartyDTO();
	private Long judgmentDocNum;
	private Long judgmentDocErrorNum;
	private String startTime;
	private String endTime;
	private byte[] fileObj;
	private String fileName;
	private String contentType;
	
	public String initPage() throws Exception {
		this.judgmentDocNum = (long)0;
		this.judgmentDocErrorNum = (long)0;
		return "list";
	}

	@SuppressWarnings("unchecked")
	public String search() throws Exception {
		Map<String,Object> map = judgmentInfoService.getJudgmentInfoDTO(a,p,getPageNo(),getPageSize());
		super.setPageInfoFromDB(this.d,map);
		if(!StringUtils.nullOrBlank(a.getJudgmentDate())){
			String[] temp = a.getJudgmentDate().split(", ");
			if(temp.length > 0){
				if(temp.length == 1){
					this.startTime = temp[0];
				}else{
					this.startTime = temp[0];
					this.endTime = temp[1];
				}
			}
		}
		this.judgmentDocNum = (Long)map.get("judgmentDocNum");
		this.judgmentDocErrorNum = (Long)map.get("judgmentDocErrorNum");
		return "list";
	}

	@SuppressWarnings("unchecked")
	public String export() throws Exception {
		System.out.println(a.getCourt());
		System.out.println(a.getCauseId());
		System.out.println(a.getJudgmentDate());
		try{
			Map<String,Object> map = judgmentInfoService.getAllJudgmentInfoDTOForExport(a,p);
//			Map<String,Object> map = m2JudgmentInfoService.getM2JudgmentInfoDTOForExport(s);
			setFileObj(writeExcel(map));
			setContentType(ContentType.XLS);
			setFileName("judgment_error.xls");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "stream";
	}

	public InputStream getInputStream() throws Exception{
		if(null != fileObj){
			return new ByteArrayInputStream(fileObj);
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private byte[] writeExcel(Map<String,Object> map){
		Object oList = map.get("list");
		Object oJudgmentDocNum = map.get("judgmentDocNum");
		Object oJudgmentDocErrorNum = map.get("judgmentDocErrorNum");
		List list = null;
		Long iJudgmentDocNum = new Long(0);
		Long iJudgmentDocErrorNum = new Long(0);
		
		if(null != oList){
			list = (ArrayList)oList;
		}
		
		if(null != oJudgmentDocNum){
			iJudgmentDocNum = (Long)oJudgmentDocNum;
		}
		
		if(null != oJudgmentDocErrorNum){
			iJudgmentDocErrorNum = (Long)oJudgmentDocErrorNum;
		}
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("瑕疵");
			HSSFRow row = sheet.createRow(0);
			row.createCell(0).setCellValue("瑕疵判决书:"+iJudgmentDocNum+"篇");
			row.createCell(1).setCellValue("瑕疵:"+iJudgmentDocErrorNum+"个");
			
			if(null != list && list.size() > 0){
				row = sheet.createRow(2);
				row.createCell(0).setCellValue("#");
				row.createCell(1).setCellValue("法院");
				row.createCell(2).setCellValue("案号");
				row.createCell(3).setCellValue("编号");
				row.createCell(4).setCellValue("错误场所");
				row.createCell(5).setCellValue("错误信息");
				row.createCell(6).setCellValue("错误类型");
				for(int i = 0; i < list.size(); i++){
					AllJudgmentInfoDTO o = (AllJudgmentInfoDTO)list.get(i);
					//M2JudgmentInfoDTO o = (M2JudgmentInfoDTO)list.get(i);
					row = sheet.createRow((2+1)+i);
					row.createCell(0).setCellValue(i+1);
					row.createCell(1).setCellValue(o.getCourt());
					row.createCell(2).setCellValue(o.getCaseNumber());
					row.createCell(3).setCellValue(o.getId());
					row.createCell(4).setCellValue(o.getErrorContent());
					row.createCell(5).setCellValue(o.getErrorMessage());
					row.createCell(6).setCellValue("E".equals(o.getErrorType())?"错误":"警告");
				}
			}
			
			wb.write(output);
			wb.close();
			output.flush();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toByteArray();
	}
	
	public String edit() throws Exception {
		return "edit";
	}
	
	public String edit2() throws Exception {
		return "edit2";
	}
	
	public M2JudgmentInfoDTO getD() {
		return d;
	}

	public void setD(M2JudgmentInfoDTO d) {
		this.d = d;
	}

	public M2JudgmentInfoDTO getS() {
		return s;
	}

	public void setS(M2JudgmentInfoDTO s) {
		this.s = s;
	}
	
	public AllJudgmentInfoDTO getA() {
		return a;
	}

	public void setA(AllJudgmentInfoDTO a) {
		this.a = a;
	}

	public AllJudgmentPartyDTO getP() {
		return p;
	}

	public void setP(AllJudgmentPartyDTO p) {
		this.p = p;
	}

	public Long getJudgmentDocNum() {
		return judgmentDocNum;
	}

	public void setJudgmentDocNum(Long judgmentDocNum) {
		this.judgmentDocNum = judgmentDocNum;
	}

	public Long getJudgmentDocErrorNum() {
		return judgmentDocErrorNum;
	}

	public void setJudgmentDocErrorNum(Long judgmentDocErrorNum) {
		this.judgmentDocErrorNum = judgmentDocErrorNum;
	}
	
	public byte[] getFileObj() {
		return fileObj;
	}

	public void setFileObj(byte[] fileObj) {
		this.fileObj = fileObj;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
