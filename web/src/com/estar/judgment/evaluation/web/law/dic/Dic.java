package com.estar.judgment.evaluation.web.law.dic;


public class Dic {
	public class LAW_RELATE {
		public static final String LAW_RELATE_HEIGHT	= "01";	//高关联
		public static final String LAW_RELATE_MIDDLE 	= "02";	//一般关联
		public static final String LAW_RELATE_LOW 		= "03";	//低关联
	}
	
	public static class TAG {
		public static final String[] TAG_ROOT = 					{"0","","文书结构","true",""};
		public static final String[] TAG_COURTNAME = 				{"1","0","法院名称","true","tag_courtname"};
		public static final String[] TAG_ARTICLE_NAME = 			{"2","0","文书名称","true","tag_article_name"};
		public static final String[] TAG_CASE_NO = 					{"3","0","案号","true","tag_case_no"};
		public static final String[] TAG_PLAINTIFF_AND_DEFENDANT = 	{"4","0","原被告","true","tag_plaintiff_and_defendant"};
		public static final String[] TAG_THIRD_PERSON = 			{"5","0","第三人","true","tag_third_person"};
		public static final String[] TAG_CASE_CONTENT = 			{"6","0","案由经过和内容","true","tag_case_content"};
		public static final String[] TAG_PLAINTIFF_DESCRIBE = 		{"7","0","原告诉称","true","tag_plaintiff_describe"};
		public static final String[] TAG_OTHER_CONTENT = 			{"8","0","事实认定和文书论理","true","tag_other_content"};
		public static final String[] TAG_CASE_USELAW_LIST = 		{"9","0","法条","true","tag_case_uselaw_list"};
		public static final String[] TAG_BEFORE_JUDGMENT_CONTENT = 	{"10","0","判决前其它内容","true","tag_before_judgment_content"};
		public static final String[] TAG_APPEAL_INFORM_NOTIFY = 	{"11","0","诉求权利义务告知","true","tag_appeal_inform_notify"};
		public static final String[] TAG_ADJUDICATORY_PERSONNEL = 	{"12","0","审判组织","true","tag_adjudicatory_personnel"};
		public static final String[] TAG_ATTACHMENT_LAW = 			{"13","0","附法律条文","true","tag_attachment_law"};
		public static final String[] TAG_APPEAL_JUDGMENT_LIST = 	{"14","0","诉求","true","tag_appeal_judgment_list"};
		public static final String[] TAG_JUDGMENT_LIST = 			{"15","0","判决","true","tag_udgment_list"};
	}
}
