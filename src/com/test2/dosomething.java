package com.test2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class dosomething  extends JFrame implements ActionListener{
	MP2 mp=null;
	do2 dodo=null;
	JButton j1=null,j2=null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dosomething ds=new dosomething();
	}
	public dosomething(){
		mp=new MP2();
		mp.setBackground(Color.black);
		j1=new JButton(" ºÚÉ«");
		j2=new JButton("ºìÉ«");
		this.add(j1,BorderLayout.NORTH);
		this.add(mp);
		this.add(j2,BorderLayout.SOUTH);
		j1.addActionListener(this);
		j1.setActionCommand("b");
		j2.addActionListener(this);
		j2.setActionCommand("r");
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(e.getActionCommand().equals("b")){
	     	//System.out.print("done");
				dodo=new do2();
	     	mp.setBackground(Color.black);
	     	}
			if(e.getActionCommand().equals("r")){
				mp.setBackground(Color.red);
			}
	}
}
class MP2 extends JPanel{
	public void paint(Graphics g){
		super.paint(g);
	//	g.fillRect(x, y, width, height)
	}
}