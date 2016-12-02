package com.estar.judgment.evaluation.web.law.action;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.estar.judgment.evaluation.JudgmentInfo;
import com.estar.judgment.evaluation.web.frame.baseobj.BaseAction;
import com.estar.judgment.evaluation.web.frame.util.ContentType;
import com.estar.judgment.evaluation.web.frame.util.FileType;
import com.estar.judgment.evaluation.web.frame.util.OfficeReader;
import com.estar.judgment.evaluation.web.frame.util.TxtReader;
import com.estar.judgment.evaluation.web.law.dto.AnalysisArticleDTO;
import com.estar.judgment.evaluation.web.law.entity.AllJudgment;
import com.estar.judgment.evaluation.web.law.entity.AnalysisJudgmentLog;
import com.estar.judgment.evaluation.web.law.entity.M2Judgment;
import com.estar.judgment.evaluation.web.law.service.AnalysisArticleService;

@Scope("prototype")  
public class AnalysisArticleAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AnalysisArticleService analysisArticleService;
	private List<File> Filedata;      
	private List<String> FiledataFileName;      
	private List<String> FiledataContentType;
	
	
	private byte[] fileObj;
	private String fileName;
	private String contentType;
	

	private AnalysisArticleDTO d = new AnalysisArticleDTO();
	public AnalysisArticleDTO getD() {
		return d;
	}

	public void setD(AnalysisArticleDTO d) {
		this.d = d;
	}

	public String initPage() throws Exception {
		return "detail";
	}

	public String analysisTxtArticle() throws Exception {
		try{
			String article = analysisArticleService.clearHtmlTag(d.getArticleContent());
			JudgmentInfo info = analysisArticleService.AnalysisArticle(article);
			d.setInfo(info);
			AnalysisJudgmentLog judgmentLog = analysisArticleService.saveJudgmentLog(info,article);
			analysisArticleService.saveJudgmentErrorLog(info,judgmentLog);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "json";
	}
	
	
	public String analysisHTxtArticle() throws Exception {
		try{
			String article = analysisArticleService.clearHtmlTag(d.getArticleContent());
			JudgmentInfo info = analysisArticleService.AnalysisArticle(article);
			d.setInfo(info);
			AnalysisJudgmentLog judgmentLog = analysisArticleService.saveJudgmentLog(info,article);
			analysisArticleService.saveJudgmentErrorLog(info,judgmentLog);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "json";
	}

	/*
	 * 待删除，旧功能只处理买卖合同
	 */
	public String analysisArticleFromDb2() throws Exception {
		try{
			M2Judgment m2Judgment = analysisArticleService.getArticleById(d.getId());
			if(null != m2Judgment){
				d.setArticleContent(m2Judgment.getJudgmentContent());
				d.setInfo(analysisArticleService.AnalysisArticle(m2Judgment.getJudgmentContent()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "json";
	}
	
	
	
	public String analysisArticleFromDb() throws Exception {
		try{
			AllJudgment allJudgment = analysisArticleService.getAllArticleById(d.getId());
			if(null != allJudgment){
				d.setArticleContent(allJudgment.getJudgmentContent());
				d.setInfo(analysisArticleService.AnalysisArticle(allJudgment.getJudgmentContent()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "json";
	}
	
	
	public String analysisSavesuggest() throws Exception {
		String articleContent = analysisArticleService.clearHtmlTag(d.getArticleContent());
		String userErrorMessage = d.getUser_error_message();
		String userSuggest = d.getUser_suggest();
		analysisArticleService.saveUserFeedBack(articleContent, userErrorMessage, userSuggest);
		return "json";
	}
	
	public String analysisDocArticle() throws Exception {
		String articleContent = "";
		String fileType = null;
		if (Filedata != null) {
            for (int i = 0; i < Filedata.size(); i++){
            	fileType = FileType.getFileByFile(Filedata.get(i));
            	if(fileType == null){
            		articleContent = TxtReader.readtext(Filedata.get(i));
            	}else{
            		articleContent = OfficeReader.read(Filedata.get(i));
            	}
            }
        }
		
		d.setInfo(analysisArticleService.AnalysisArticle(articleContent));
		d.setArticleContent(articleContent);
		return "json";
	}

	
	public List<File> getFiledata() {
		return Filedata;
	}

	public void setFiledata(List<File> filedata) {
		Filedata = filedata;
	}

	public List<String> getFiledataFileName() {
		return FiledataFileName;
	}

	public void setFiledataFileName(List<String> filedataFileName) {
		FiledataFileName = filedataFileName;
	}

	public List<String> getFiledataContentType() {
		return FiledataContentType;
	}

	public void setFiledataContentType(List<String> filedataContentType) {
		FiledataContentType = filedataContentType;
	}
	
	
	
	public InputStream getInputStream() throws Exception{
		if(null != fileObj){
			return new ByteArrayInputStream(fileObj);
		}else{
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public String export() throws Exception {
		try{
			String articleContent = d.getArticleContent();
			String name = "LawArticleContent.doc";
			setFileObj(writeWord(articleContent));
			setContentType(ContentType.WORD);
			setFileName(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "stream";
	}

	@SuppressWarnings("unchecked")
	private byte[] writeWord(String articleContent){
	
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			articleContent = "<html><body>"+articleContent+"</body></html>"; 
			InputStream bodyIs = new ByteArrayInputStream(articleContent.getBytes());
			String body = getContent(bodyIs);
			String content = "<html><head><style></style></head><body>" + body + "</body></html>";
			
			InputStream is = new ByteArrayInputStream(content.getBytes());
			POIFSFileSystem fs = new POIFSFileSystem();
			DirectoryEntry directory = fs.getRoot();
			directory.createDocument("WordDocument", is);
			fs.writeFilesystem(output); 
			is.close();
			output.flush();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toByteArray();	
	
	}
	
    private static String getContent(InputStream... ises) throws IOException {
        if (ises != null) {
           StringBuilder result = new StringBuilder();
           BufferedReader br;
           String line;
           for (InputStream is : ises) {
              //br = new BufferedReader(new InputStreamReader(is, "gb2312"));
        	   br = new BufferedReader(new InputStreamReader(is));
              while ((line=br.readLine()) != null) {
                  result.append(line);
              }
           }
           return result.toString();
        }
        return null;
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
}
