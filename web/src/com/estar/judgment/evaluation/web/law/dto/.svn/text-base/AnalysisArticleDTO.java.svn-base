package com.estar.judgment.evaluation.web.law.dto;

import java.util.ArrayList;
import java.util.List;

import com.estar.judgment.appealjudgment.AppealJudgmentChecker;
import com.estar.judgment.appealjudgment.BaseAppealJudgment;
import com.estar.judgment.content.JudgmentContent;
import com.estar.judgment.evaluation.JudgmentInfo;
import com.estar.judgment.evaluation.JudgmentReport;
import com.estar.judgment.evaluation.web.frame.util.StringUtils;
import com.estar.judgment.law.LawArticle;

public class AnalysisArticleDTO {

	private static final long serialVersionUID = 1L;
	private String id;
	private String articleContent;
	private String court;//("法院"),
	private String type;//("文书类型"),
	private String case_number;//("案号"),
	private String plaintiff;//("原告"),
	private String defendant;//("被告"),
	private String third_party;//("第三人"),
	//private String cause;//("案由"),
	private String cause_content;//("案由和经过"),
	private String plaintiff_claims;//("原告陈述"),
	private String appeal;//("诉求"),
	private String plaintiff_quote;//("原告举证"),
	private String answer;//("被告答辩"),
	private String reason;//("理由"),
	private String law_article;//("法律条文"),
	private String judgment_description;//("判决说明文"),
	private String judgment_content;//("判决"),
	private String rights_obligations;//("诉讼权利义务告知"),
	private String trial_group;//("审判组织"),
	private String appendix_law_article;//("附相关法律条文");
	private String user_error_message;//("用户质疑错误信息");
	private String user_suggest;//("用户建议")
	private List<AppealJudgmentUtilDTO> appealList;//BaseAppealJudgment-->content,type
	private List<AppealJudgmentUtilDTO> judgmentList;//BaseAppealJudgment-->content,type
	private List<String> lawArticleList;
	private List<ArticleTreeDTO> articleTreeDTOList;
	private AnalysisArticleReportDTO analysisArticleReportDTO;
	
	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public void setInfo(JudgmentInfo info) {
		JudgmentReport judgment = info.getJudgmentReport();
		this.court = judgment.getContentTextWithBr(JudgmentContent.COURT);//("法院"),
		this.type = judgment.getContentTextWithBr(JudgmentContent.TYPE);//("文书类型"),
		this.case_number = judgment.getContentTextWithBr(JudgmentContent.CASE_NUMBER);//("案号"),
		this.plaintiff = judgment.getContentTextWithBr(JudgmentContent.PLAINTIFF);//("原告"),
		this.defendant = judgment.getContentTextWithBr(JudgmentContent.DEFENDANT);//("被告"),
		this.third_party = judgment.getContentTextWithBr(JudgmentContent.THIRD_PARTY);//("第三人"),
		//this.cause = judgment.getContentTextWithBr(JudgmentContent.CAUSE);//("案由"),
		this.cause_content = judgment.getContentTextWithBr(JudgmentContent.CAUSE_CONTENT);//("案由和经过"),
		this.plaintiff_claims = judgment.getContentTextWithBr(JudgmentContent.PLAINTIFF_CLAIMS);//("原告陈述"),
		this.appeal = judgment.getContentTextWithBr(JudgmentContent.APPEAL);//("诉求"),
		this.plaintiff_quote = judgment.getContentTextWithBr(JudgmentContent.PLAINTIFF_QUOTE);//("原告举证"),
		this.answer = judgment.getContentTextWithBr(JudgmentContent.ANSWER);//("被告答辩"),
		this.reason = judgment.getContentTextWithBr(JudgmentContent.REASON);//("理由"),
		this.law_article = judgment.getContentTextWithBr(JudgmentContent.LAW_ARTICLE);//("法律条文"),
		this.judgment_description = judgment.getContentTextWithBr(JudgmentContent.JUDGMENT_DESCRIPTION);//("判决说明文"),
		this.judgment_content = judgment.getContentTextWithBr(JudgmentContent.JUDGMENT_CONTENT);//("判决"),
		this.rights_obligations = judgment.getContentTextWithBr(JudgmentContent.RIGHTS_OBLIGATIONS);//("诉讼权利义务告知"),
		this.trial_group = judgment.getContentTextWithBr(JudgmentContent.TRIAL_GROUP_DATE);//("审判组织"),
		this.appendix_law_article = judgment.getContentTextWithBr(JudgmentContent.APPENDIX_LAW_ARTICLE);//("附相关法律条文");
		if(null != info.getAppealList() && null != info.getJudgmentList() && null != info.getResponseFromJudgments()){
			this.appealList = randerAppeal2SimpleDTO(info.getAppealList().getValid(),info.getJudgmentList().getValid(),info.getResponseFromJudgments());
			this.judgmentList = randerAppeal2SimpleDTO(info.getJudgmentList().getValid(),info.getAppealList().getValid(),info.getResponseToAppeals());
		}
		this.analysisArticleReportDTO = new AnalysisArticleReportDTO(info);
		
		
		if(null != info.getLawArticleList() && null != info.getLawArticleList().getAll()){
			List<LawArticle> lawList = info.getLawArticleList().getAll();
			List<String> lawString = new ArrayList<String>();
			if(null != lawList && lawList.size() > 0){
				for(LawArticle o:lawList){
					lawString.add(o.getOriginalText());
				}
				lawArticleList = lawString;
			}
		}
		
		randerTree();
	}
	

	
	private List<AppealJudgmentUtilDTO> randerAppeal2SimpleDTO(List<BaseAppealJudgment> list,List<BaseAppealJudgment> listDy,int[] dyNum){
		List<AppealJudgmentUtilDTO> returnList = new ArrayList<AppealJudgmentUtilDTO>();
		if(null != list && list.size() > 0){
			for(int i = 0; i< list.size(); i++ ){
				BaseAppealJudgment o = list.get(i);
				String dyContent = "";
				if(dyNum[i] >= 0){
					dyContent = listDy.get(dyNum[i]).getContent();
				}else{
					dyContent = "无对应";
				}
				AppealJudgmentUtilDTO dto = new AppealJudgmentUtilDTO(o.getType().getName(),o.getContent(),dyNum[i],dyContent);
				returnList.add(dto);
			}
		}
		return returnList;
	}
	
	
	private void randerTree(){
		this.articleTreeDTOList = new ArrayList<ArticleTreeDTO>();
		articleTreeDTOList.add(createTree("0","","文书结构",true,""));
		if(!StringUtils.nullOrBlank(court) && court.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("1","0",JudgmentContent.COURT.getName(),true,JudgmentContent.COURT.toString()));
		}
		if(!StringUtils.nullOrBlank(type) && type.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("2","0",JudgmentContent.TYPE.getName(),true,JudgmentContent.TYPE.toString()));
		}
		if(!StringUtils.nullOrBlank(case_number) && case_number.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("3","0",JudgmentContent.CASE_NUMBER.getName(),true,JudgmentContent.CASE_NUMBER.toString()));
		}
		if(!StringUtils.nullOrBlank(plaintiff) && plaintiff.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("4","0",JudgmentContent.PLAINTIFF.getName(),true,JudgmentContent.PLAINTIFF.toString()));
		}
		if(!StringUtils.nullOrBlank(defendant) && defendant.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("5","0",JudgmentContent.DEFENDANT.getName(),true,JudgmentContent.DEFENDANT.toString()));
		}
		if(!StringUtils.nullOrBlank(third_party) && third_party.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("6","0",JudgmentContent.THIRD_PARTY.getName(),true,JudgmentContent.THIRD_PARTY.toString()));
		}
//		if(!StringUtils.nullOrBlank(cause) && cause.split(JudgmentReport.SPLIT_TEXT).length == 2){
//			articleTreeDTOList.add(createTree("7","0",JudgmentContent.CAUSE.getName(),true,JudgmentContent.CAUSE.toString()));
//		}
		if(!StringUtils.nullOrBlank(cause_content) && cause_content.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("8","0",JudgmentContent.CAUSE_CONTENT.getName(),true,JudgmentContent.CAUSE_CONTENT.toString()));
		}
		if(!StringUtils.nullOrBlank(plaintiff_claims) && plaintiff_claims.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("9","0",JudgmentContent.PLAINTIFF_CLAIMS.getName(),true,JudgmentContent.PLAINTIFF_CLAIMS.toString()));
		}
		if(!StringUtils.nullOrBlank(appeal) && appeal.split(JudgmentReport.SPLIT_TEXT).length == 2){//诉请
			articleTreeDTOList.add(createTree("10","0",JudgmentContent.APPEAL.getName(),true,JudgmentContent.APPEAL.toString()));
			if(null != appealList && appealList.size() > 0){
				for(int i = 0 ;i < appealList.size(); i++){
					articleTreeDTOList.add(createTree("10"+"_"+i,"10",JudgmentContent.APPEAL.getName()+"_"+(i+1),true,JudgmentContent.APPEAL.toString()+"_"+i));
				}
			}
		}
		if(!StringUtils.nullOrBlank(plaintiff_quote) && plaintiff_quote.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("11","0",JudgmentContent.PLAINTIFF_QUOTE.getName(),true,JudgmentContent.PLAINTIFF_QUOTE.toString()));
		}
		if(!StringUtils.nullOrBlank(answer) && answer.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("12","0",JudgmentContent.ANSWER.getName(),true,JudgmentContent.ANSWER.toString()));
		}
		if(!StringUtils.nullOrBlank(reason) && reason.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("13","0",JudgmentContent.REASON.getName(),true,JudgmentContent.REASON.toString()));
		}
		if(!StringUtils.nullOrBlank(law_article) && law_article.split(JudgmentReport.SPLIT_TEXT).length == 2){//法律条文
			articleTreeDTOList.add(createTree("14","0",JudgmentContent.LAW_ARTICLE.getName(),true,JudgmentContent.LAW_ARTICLE.toString()));
			if(null != lawArticleList && lawArticleList.size() > 0){
				for(int i = 0 ;i < lawArticleList.size(); i++){
					articleTreeDTOList.add(createTree("14"+"_"+i,"14",JudgmentContent.LAW_ARTICLE.getName()+"_"+(i+1),true,JudgmentContent.LAW_ARTICLE.toString()+"_"+i));
				}
			}
		}
		if(!StringUtils.nullOrBlank(judgment_description) && judgment_description.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("15","0",JudgmentContent.JUDGMENT_DESCRIPTION.getName(),true,JudgmentContent.JUDGMENT_DESCRIPTION.toString()));
		}
		if(!StringUtils.nullOrBlank(judgment_content) && judgment_content.split(JudgmentReport.SPLIT_TEXT).length == 2){//判决
			articleTreeDTOList.add(createTree("16","0",JudgmentContent.JUDGMENT_CONTENT.getName(),true,JudgmentContent.JUDGMENT_CONTENT.toString()));
			if(null != judgmentList && judgmentList.size() > 0){
				for(int i = 0 ;i < judgmentList.size(); i++){
					articleTreeDTOList.add(createTree("16"+"_"+i,"16",JudgmentContent.JUDGMENT_CONTENT.getName()+"_"+(i+1),true,JudgmentContent.JUDGMENT_CONTENT.toString()+"_"+i));
				}
			}
		}
		if(!StringUtils.nullOrBlank(rights_obligations) && rights_obligations.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("17","0",JudgmentContent.RIGHTS_OBLIGATIONS.getName(),true,JudgmentContent.RIGHTS_OBLIGATIONS.toString()));
		}
		if(!StringUtils.nullOrBlank(trial_group) && trial_group.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("18","0",JudgmentContent.TRIAL_GROUP_DATE.getName(),true,JudgmentContent.TRIAL_GROUP_DATE.toString()));
		}
		if(!StringUtils.nullOrBlank(appendix_law_article) && appendix_law_article.split(JudgmentReport.SPLIT_TEXT).length == 2){
			articleTreeDTOList.add(createTree("19","0",JudgmentContent.APPENDIX_LAW_ARTICLE.getName(),true,JudgmentContent.APPENDIX_LAW_ARTICLE.toString()));
		}
	}
	
	private ArticleTreeDTO createTree(String id, String id2, String name, boolean open,String tag){
		ArticleTreeDTO dto = new ArticleTreeDTO(id,id2,name,open,tag);
		return dto;
	}
	
	

//	private List<ArticleReportDTO> randerException2SimpleDTO(InvalidJudgmentReportException[] errs){
//		List<ArticleReportDTO> articleReportDTOList = new ArrayList<ArticleReportDTO>();
//		if(!ArrayUtil.isEmpty(errs)){
//			for(Object o:errs){
//				if(o instanceof InvalidJudgmentReportException){
//					InvalidJudgmentReportException obj = (InvalidJudgmentReportException)o;
//					ArticleReportDTO dto = new ArticleReportDTO(obj);
//					articleReportDTOList.add(dto);
//				}
//			}
//		}
//		return articleReportDTOList;
//	}
	
	public String getCourt() {
		return court;
	}


	public void setCourt(String court) {
		this.court = court;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCase_number() {
		return case_number;
	}


	public void setCase_number(String case_number) {
		this.case_number = case_number;
	}


	public String getPlaintiff() {
		return plaintiff;
	}


	public void setPlaintiff(String plaintiff) {
		this.plaintiff = plaintiff;
	}


	public String getDefendant() {
		return defendant;
	}


	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}


	public String getThird_party() {
		return third_party;
	}


	public void setThird_party(String third_party) {
		this.third_party = third_party;
	}


//	public String getCause() {
//		return cause;
//	}
//
//
//	public void setCause(String cause) {
//		this.cause = cause;
//	}


	public String getCause_content() {
		return cause_content;
	}


	public void setCause_content(String cause_content) {
		this.cause_content = cause_content;
	}


	public String getPlaintiff_claims() {
		return plaintiff_claims;
	}


	public void setPlaintiff_claims(String plaintiff_claims) {
		this.plaintiff_claims = plaintiff_claims;
	}


	public String getAppeal() {
		return appeal;
	}


	public void setAppeal(String appeal) {
		this.appeal = appeal;
	}


	public String getPlaintiff_quote() {
		return plaintiff_quote;
	}


	public void setPlaintiff_quote(String plaintiff_quote) {
		this.plaintiff_quote = plaintiff_quote;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getLaw_article() {
		return law_article;
	}


	public void setLaw_article(String law_article) {
		this.law_article = law_article;
	}


	public String getJudgment_description() {
		return judgment_description;
	}


	public void setJudgment_description(String judgment_description) {
		this.judgment_description = judgment_description;
	}


	public String getJudgment_content() {
		return judgment_content;
	}


	public void setJudgment_content(String judgment_content) {
		this.judgment_content = judgment_content;
	}


	public String getRights_obligations() {
		return rights_obligations;
	}


	public void setRights_obligations(String rights_obligations) {
		this.rights_obligations = rights_obligations;
	}


	public String getTrial_group() {
		return trial_group;
	}


	public void setTrial_group(String trial_group) {
		this.trial_group = trial_group;
	}


	public String getAppendix_law_article() {
		return appendix_law_article;
	}


	public void setAppendix_law_article(String appendix_law_article) {
		this.appendix_law_article = appendix_law_article;
	}

	public List<AppealJudgmentUtilDTO> getAppealList() {
		return appealList;
	}

	public void setAppealList(List<AppealJudgmentUtilDTO> appealList) {
		this.appealList = appealList;
	}

	public List<AppealJudgmentUtilDTO> getJudgmentList() {
		return judgmentList;
	}

	public void setJudgmentList(List<AppealJudgmentUtilDTO> judgmentList) {
		this.judgmentList = judgmentList;
	}

	

	public List<ArticleTreeDTO> getArticleTreeDTOList() {
		return articleTreeDTOList;
	}

	public void setArticleTreeDTOList(List<ArticleTreeDTO> articleTreeDTOList) {
		this.articleTreeDTOList = articleTreeDTOList;
	}

	public AnalysisArticleReportDTO getAnalysisArticleReportDTO() {
		return analysisArticleReportDTO;
	}

	public void setAnalysisArticleReportDTO(
			AnalysisArticleReportDTO analysisArticleReportDTO) {
		this.analysisArticleReportDTO = analysisArticleReportDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getLawArticleList() {
		return lawArticleList;
	}

	public void setLawArticleList(List<String> lawArticleList) {
		this.lawArticleList = lawArticleList;
	}

	public String getUser_error_message() {
		return user_error_message;
	}

	public void setUser_error_message(String user_error_message) {
		this.user_error_message = user_error_message;
	}

	public String getUser_suggest() {
		return user_suggest;
	}

	public void setUser_suggest(String user_suggest) {
		this.user_suggest = user_suggest;
	}
	
	
	
}