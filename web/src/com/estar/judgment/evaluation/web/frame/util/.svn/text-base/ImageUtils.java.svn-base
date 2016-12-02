package com.estar.judgment.evaluation.web.frame.util;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageUtils {
	public static final String small_pre = "s_";
	public static String getImageFormatName(File file) throws IOException {
		String formatName = null;
		ImageInputStream iis = ImageIO.createImageInputStream(file);
		Iterator<ImageReader> imageReader = ImageIO.getImageReaders(iis);
		if (imageReader.hasNext()) {
			ImageReader reader = imageReader.next();
			formatName = reader.getFormatName();
		}
		return formatName;
	}
	

	public static String cutImage(File file, String targetPath,int scaleLength) throws IOException {
		BufferedImage image = ImageIO.read(file);
		int srcWidth = image.getWidth();
		int srcHeight = image.getHeight();
		int startX;
		int startY;
		int length;
		if (srcWidth > srcHeight) {
			startX = (srcWidth - srcHeight) / 2;
			startY = 0;
			length = srcHeight;
		} else {
			startX = 0;
			startY = (srcHeight - srcWidth) / 2;
			length = srcWidth;
		}
		image = image.getSubimage(startX, startY, length, length);
		
		ImageInputStream iis = ImageIO.createImageInputStream(file);
		Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);
		int imageNumber = 0;
		if (imageReaders.hasNext()) {
			ImageReader reader = imageReaders.next();
			reader.setInput(iis);
			imageNumber = reader.getNumImages(true);
		}
		image = zoom(image,imageNumber,scaleLength,scaleLength);
		ImageIO.write(image, getImageFormatName(file), new File(targetPath));
		return targetPath;
	}
	

	private static BufferedImage zoom(BufferedImage sourceImage,int imageNumber, int width,int height) {
		BufferedImage zoomImage = new BufferedImage(width, height, imageNumber);
		Image image = sourceImage.getScaledInstance(width, height,Image.SCALE_SMOOTH);
		Graphics gc = zoomImage.getGraphics();
		gc.setColor(Color.WHITE);
		gc.drawImage(image, 0, 0, null);
		return zoomImage;
	}
	
	private static String createSmailPicPath(File file)throws Exception{
		String path = file.getParentFile().getAbsolutePath();
		String name = file.getName();
		return path+File.separator+small_pre+name;
	}
	
	private static String createPicName(String name)throws Exception{
		String p = name.substring(name.lastIndexOf(".")+1,name.length());
		return System.currentTimeMillis()+"."+p;
	}
	
	public static String[] saveImage(File imageFile, String basePath,String dir,String fileName,boolean ynScale) throws Exception{
		FileInputStream in = new FileInputStream(imageFile);
		String picName = createPicName(fileName);
		String[] dirs = TimestampTool.getDateDirPath(basePath);
		String path = basePath + File.separator + dirs[0] + File.separator + dirs[1] + File.separator + dirs[2];
		File dirFile = new File(path + File.separator + dir);
		if(!dirFile.exists()){
			dirFile.mkdir();
		}
        File file = new File(dirFile.getAbsolutePath()+ "/"+picName);
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        int c;
        byte buffer[] = new byte[1024];
        while((c = in.read(buffer))!= -1){
            for(int i = 0;i < c;i++)
                out.write(buffer[i]);        
        }
        in.close();
        out.close();
        
        if(ynScale){
        	cutImage(imageFile,createSmailPicPath(file),150);
        }
        dirs[3] = picName;
        return dirs;
	}
	
	
}
