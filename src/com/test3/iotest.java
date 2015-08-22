package com.test3;
import java.io.*;
public class iotest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("d:\\记账.txt");
//		if(f.isDirectory()){
//			File list[]=f.listFiles();
//			for(int i=0;i<list.length;i++)
//			{
//				
//				System.out.print("文件名是："+list[i].getName()+"\n");
//			}
//			
//			
//		}else{
//			
//			
//			
//		}
//		
		try {
			FileInputStream fil=new FileInputStream(f);
		    byte[] b=new byte[1024];
		    fil.read(b);
		    String s=new String(b);
		    System.out.print(s);
		    fil.close();
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.print("d:"+f.getAbsolutePath());
	}

}
