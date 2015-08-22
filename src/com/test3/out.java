package com.test3;
import java.io.*;
public class out {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			File f2=new File("d://output.txt");
			FileOutputStream fos=null;
			try{
				fos=new FileOutputStream(f2);
				String s=new String("hell world");
				byte[] ss=new byte[1024];
				//ss=(byte)s;
				fos.write(s.getBytes());
				fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				
			}
	}

}
