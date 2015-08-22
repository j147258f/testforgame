package com.test2;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class do2 extends JFrame {
	MP3 mp1=null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		do2 do2=new do2();
	}
	public do2(){
		mp1=new MP3();
		//mp1.setBackground(Color.);
		this.addKeyListener(mp1);
		this.add(mp1);
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


}
class MP3 extends JPanel implements KeyListener{
	    int x=10,y=10;
	public void paint(Graphics g){
		
		super.paint(g);
	    g.fillOval(x, y, 10, 10);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			y=y+10;
			this.repaint();
			}
		else if(e.getKeyCode()==KeyEvent.VK_UP){
			y=y-10;	
			this.repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x=x-10;	
			this.repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x=x+10;	
			this.repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}