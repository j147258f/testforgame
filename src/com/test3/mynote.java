package com.test3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class mynote extends JFrame implements ActionListener{
	JTextArea jta=null;
	JMenuBar jmb=null;
	JMenuItem jmi1=null;JMenuItem jmi2=null;
	JMenu jm1=null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			mynote note=new mynote();
	}
	
	
	
	public mynote(){
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm1=new JMenu("文件");
		jmi1=new JMenuItem("打开");jmi2=new JMenuItem("保存");
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi1.setActionCommand("open");
		jmi2.setActionCommand("save");
		jm1.add(jmi1);
		jm1.add(jmi2);
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);
		this.setVisible(true);
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("open")){
			JFileChooser jfc1=new JFileChooser();
			jfc1.setDialogTitle("请选择");
			jfc1.showOpenDialog(null);
			jfc1.setVisible(true);
			 String getname=jfc1.getSelectedFile().getAbsolutePath();
			 FileReader fr=null;
			BufferedReader bfr=null;
			try {
				fr=new FileReader(getname);
				bfr=new BufferedReader(fr);
				String s="";
				String sa="";
				while((s=bfr.readLine())!=null){
					sa=sa+s+"\n";
				}
				jta.setText(sa);
			} catch (Exception ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}finally{
				try {
					bfr.close();
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		}else if(e.getActionCommand().equals("save")){
			JFileChooser jfc1=new JFileChooser();
			jfc1.setDialogTitle("保存到");
			jfc1.showSaveDialog(null);
			jfc1.setVisible(true);
			 String getname=jfc1.getSelectedFile().getAbsolutePath();
			 FileWriter fr=null;
			BufferedWriter bfr=null;
			try {
				fr=new FileWriter(getname);
				bfr=new BufferedWriter(fr);
				bfr.write(jta.getText());
			} catch (Exception ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}finally{
				try {
					fr.close();
					bfr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		}
	}

}
