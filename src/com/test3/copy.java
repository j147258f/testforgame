package com.test3;
import java.io.*;
public class copy {
	public static void main(String[] args) {
		File f2=new File("e://1.jpg");
		File f1=new File("d://1.jpg");
		FileInputStream fi=null;
		FileOutputStream fo=null;
		
		try {
			fi=new FileInputStream(f1);
			fo=new FileOutputStream(f2);
			byte[] b=new byte[1024];
			int n=0;
			while((n=fi.read(b))!=-1){
				fo.write(b);
				
				
			}
			fi.close();
			fo.close();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	
	
	
	}
}
