package com.estar.judgment.evaluation.web.frame.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

import org.apache.poi.POITextExtractor;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class OfficeReader {
	
	public static String read(File file) throws Exception {
		//return read2003(file);
		InputStream in = null;
		in = new FileInputStream(file);
		if(!in.markSupported()){
			in = new PushbackInputStream(in,8);
		}
		if(POIFSFileSystem.hasPOIFSHeader(in)){
			return read2003(file);
		}
		if(POIXMLDocument.hasOOXMLHeader(in)){
			return read2007(file);
		}
		
		return  "";
//		OfficeFileType v = OfficeFileType.getInstance(FileUtil.getExtension(file.getName()));
//		if (OfficeFileType.WORD_2003.equals(v)) {
//			return read2003(file);
//		} else {
//			return read2007(file);
//		}
	}
	
	private static String read2003(File file) throws IOException {
		InputStream in = null;
		WordExtractor we = null;
		
		String text;
		try {
			in = new FileInputStream(file);
			we = new WordExtractor(in);
			text = we.getText();
		} finally {
			try {
				if (we != null) {
					we.close();
				}
			} finally {
				if (in != null) {
					in.close();
				}
			}
		}
		
		return text;
	}
	
	public static String read2007(File file){
    	OPCPackage in = null;
    	String textString = null;
		try {
			in = POIXMLDocument.openPackage(file.getPath());
			XWPFDocument xwpf = new XWPFDocument(in);
	    	POITextExtractor extractor = new XWPFWordExtractor(xwpf);
	    	textString = extractor.getText();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null){
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	return textString;
    }
}
