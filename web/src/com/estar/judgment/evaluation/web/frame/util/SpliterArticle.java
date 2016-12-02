package com.estar.judgment.evaluation.web.frame.util;

import com.estar.common.textutil.TextProcessor;
import com.estar.judgment.evaluation.JudgmentProcessorFactory;
import com.estar.judgment.evaluation.judgmentprocessor.JudgmentProcessorManager;

public class SpliterArticle {
	
	private static final JudgmentProcessorManager PROCESSOR_MANAGER = new JudgmentProcessorManager();
	
	public TextProcessor getTextProcessor(){
		return JudgmentProcessorFactory.getJudgmentInfoProcessor(PROCESSOR_MANAGER);
	}
}
