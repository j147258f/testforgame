package com.test;
import java.awt.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class mt1 extends JFrame {
	MP mp=new MP();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mt1 mt1=new mt1();
	
	//	Thread thread=new Thread(mp);
		//thread.start();
	}
	public mt1(){
		 Thread t2=new Thread(mp);
			t2.start();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
class shot implements Runnable{
	int speed=1;
	int x,y,direct;
	int maxn=10;
	boolean islive=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.print("t1");
			switch(direct){
			case 0:
				y-=speed;
				//System.out.print("0");
				break;
			case 1:
				x+=speed;
			//	System.out.print("1");
				break;
			case 2:
				y+=speed;
		//		System.out.print("2");
				break;
			case 3:
				x-=speed;
	//			System.out.print("3");
				break;
			}
//			System.out.print("x="+x+"y="+y+"\n");
			
			
			if(x<0||x>800||y<0||y>600){
				this.islive=false;
				break;
			}
		}
	} 
	public shot(int x,int y,int direct){
	  this.x=x;
	  this.y=y;
	  this.direct=direct;
	}
	
}

class tank{
	//坐标
	boolean islive=true;
	Vector<shot> ss=new Vector<shot>();
	Vector<shot> oss=new Vector<shot>();
	shot s=null;
		int x;
		int y;
		int type;
		int direct;
		//发射
		void shots(){
			
			switch(this.direct){
			case 0:
				s=new shot(x+9,y,0);
				if(type==0){ss.add(s);}
				else {oss.add(s);}
				break;
			case 2:
				s=new shot(x+9,y+10,2);
				if(type==0){ss.add(s);}
				else {oss.add(s);}
				break;
			case 1:
				s=new shot(x+10,y+9,1);
				if(type==0){ss.add(s);}
				else {oss.add(s);}
				break;
			case 3:
				s=new shot(x,y+9,3);
				if(type==0){ss.add(s);}
				else {oss.add(s);}
				break;
			}
		Thread t=new Thread(s);
			t.start();
			//System.out.print("线程");
		}
	
		public int getDirect() {
			return direct;
		}
		public void setDirect(int direct) {
			this.direct = direct;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		public tank(int x,int y,int t){
			this.x=x;
			this.y=y;
			this.type=t;
		}
}
//主角坦克
class herotk extends tank{
	int type=0;
	public herotk(int x,int y,int t){
		super(x,y,t);
	}
	public int gettype() {
		return type;
	}
	public void settype(int y) {
		this.type = y;
	}
}
//敌人
class othertk extends tank implements Runnable{
	int type=1;
	int speed=1;
	//Vector<shot> ss=new Vector<shot>();
	public othertk(int x,int y,int t){
		super(x,y,t);
	}
	public int gettype() {
		return type;
	}
	public void settype(int y) {
		this.type = y;
	}
	public void move(int x,int y){
		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			switch(this.direct){
				case 0:for(int i=0;i<30;i++){if(y>0){y=y-speed;}try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}break;
				case 2:for(int i=0;i<30;i++){if(y<600){y=y+speed;}try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}break;
				case 1:for(int i=0;i<30;i++){if(x<800){x=x+speed;}try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}break;
				case 3:for(int i=0;i<30;i++){if(x>0){x=x-speed;}try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}break;
			}
		this.direct=(int)(Math.random()*4);
		
		if(this.islive==false)break;
		}
		
	}
	
}
//boom
class boom {
	boolean boom=false;
	int x,y;
	int num=70;
	public boom(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void down(){
		if(num>0){num--;}
		else{
			this.boom=false;
			
		}
	}
}
//面板
class MP extends JPanel  implements KeyListener,Runnable{
	herotk herotk=null;
	tank tank=null;
	Vector<othertk> ets=new Vector<othertk>();
	Vector<boom> bos=new Vector<boom>();
	int en=3;
	int picture=7;
	Image i1=null;
	Image i2=null;
	Image i3=null;
	Image i4=null;
	Image i5=null;
	Image i6=null;
	Image i7=null;
//	Graphics g;
	othertk ots=null;
	//设置随机数
	Random x1=new Random();
	Random x2=new Random();
	int n1=x1.nextInt(100);
	int n2=x2.nextInt(100);
	public MP(){
		
		herotk =new herotk(n1,n1,0);
	
		for(int i=0;i<en;i++){
		ots=new othertk(n2+50*i,n2,1);
	//	shot os=new shot(ots.x,ots.y,ots.direct);
		//Thread t2=new Thread(os);t2.start();
		ets.add(ots);
		
		Thread t=new Thread(ots);
		t.start();
		
		
		}
		
		i1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1.png"));
		i2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/2.png"));
		i3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/3.png"));
		i4=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/4.png"));
		i5=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/5.png"));
		i6=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/6.png"));
		i7=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/7.png"));
	}
	public void paint(Graphics g){
		super.paint(g);
		
		g.fillRect(0,0, 800, 600);
	//	g.setColor(Color.CYAN);
		for(int h=0;h<bos.size();h++){
			if(bos.get(h).boom=true){if(bos.get(h).num<=70&&bos.get(h).num>60)g.drawImage(i1, bos.get(h).x,bos.get(h).y,30,30,this);
			if(bos.get(h).num<=60&&bos.get(h).num>50)g.drawImage(i2, bos.get(h).x,bos.get(h).y,30,30,this);
			if(bos.get(h).num<=50&&bos.get(h).num>40)g.drawImage(i3, bos.get(h).x,bos.get(h).y,30,30,this);
			if(bos.get(h).num<=40&&bos.get(h).num>30)g.drawImage(i4, bos.get(h).x,bos.get(h).y,30,30,this);
			if(bos.get(h).num<=30&&bos.get(h).num>20)g.drawImage(i5, bos.get(h).x,bos.get(h).y,30,30,this);
			if(bos.get(h).num<=20&&bos.get(h).num>10)g.drawImage(i6, bos.get(h).x,bos.get(h).y,30,30,this);
			if(bos.get(h).num<=10)g.drawImage(i7, bos.get(h).x,bos.get(h).y,30,30,this);
			} bos.get(h).down();
			if(bos.get(h).num==0){
						bos.remove(bos.get(h));
				}
	//		System.out.print(bos.get(h).num);
			}
		for(int jj=0;jj<ots.oss.size();jj++)
		{
			if (ots.oss.get(jj)!=null&&ots.oss.get(jj).islive==true){
				g.setColor(Color.red);
				g.draw3DRect(ots.oss.get(jj).x, ots.oss.get(jj).y, 2, 2, false);
			
		}if(ots.oss.get(jj).islive==false){
			ots.oss.remove(jj);
		    }
		}
			for(int j=0;j<herotk.ss.size();j++)
		{
	
				if (herotk.ss.get(j)!=null&&herotk.ss.get(j).islive==true){
						g.setColor(Color.CYAN);
						g.draw3DRect(herotk.ss.get(j).x, herotk.ss.get(j).y, 2, 2, false);
			}
			if(herotk.ss.get(j).islive==false){
				herotk.ss.remove(j);
			}
		}
		if(herotk.islive==true){
			this.dt(herotk.getX(),herotk.getY(), g,herotk.direct, herotk.gettype());
		}
	    
		for(int i=0;i<ets.size();i++){
	    	if(ets.get(i).islive==true)
			this.dt(ets.get(i).getX(),ets.get(i).getY(), g,ets.get(i).getDirect(), ets.get(i).gettype());
	    }
		
	    //this.dt(ots.getX(),ots.getY(), g,ots.getDirect(), ots.gettype());
	   //this.kankang();
	}
	
	public void hit(shot s,tank e){
		switch(e.direct){
		case 0:
			if(s.x>e.x&&s.x<e.x+20&&s.y>e.y&&s.y<e.y+30)
			{
				s.islive=false;
				e.islive =false;
				
				boom b=new boom(e.x,e.y);
				b.boom=true;
				bos.add(b);
				e.setX(0);
				e.setY(0);
				ets.remove(e);
			}
		case 1:
			if(s.x>e.x&&s.x<e.x+30&&s.y>e.y&&s.y<e.y+20){
				s.islive=false;
				e.islive =false;
				
				boom b=new boom(e.x,e.y);
				b.boom=true;
				bos.add(b);
				e.setX(0);
				e.setY(0);
				ets.remove(e);
			}
		case 2:
			if(s.x>e.x&&s.x<e.x+20&&s.y>e.y&&s.y<e.y+30)
			{
				s.islive=false;
				e.islive =false;
				
				boom b=new boom(e.x,e.y);
				b.boom=true;
				bos.add(b);
				e.setX(0);
				e.setY(0);
				ets.remove(e);
			}
		case 3:
			if(s.x>e.x&&s.x<e.x+30&&s.y>e.y&&s.y<e.y+20){
				s.islive=false;
				e.islive =false;
				
				boom b=new boom(e.x,e.y);
				b.boom=true;
				bos.add(b);
				e.setX(0);
				e.setY(0);
				ets.remove(e);
			}
		
		
		}
		
	}
	
	
	
	public void dt(int X,int Y,Graphics g,int direct,int type){
		switch (type)
		{
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.red);
			break;
		}
		switch(direct)
		{
		case 0:
			//up
			  g.fill3DRect(X,Y,5,30,false);
			    g.fill3DRect(X+15,Y,5,30,false);
			    g.fill3DRect(X+5,Y+5,10,20,false);
			    g.fillOval(X+5,Y+10,9,9);
	
			    g.drawLine(X+10,Y+15,X+10,Y);	
			    break;
			    
		case 1://right
			  g.fill3DRect(X,Y,30,5,false);
			    g.fill3DRect(X,Y+15,30,5,false);
			    g.fill3DRect(X+5,Y+5,20,10,false);
			    g.fillOval(X+10,Y+5,9,9);
			    g.drawLine(X+15,Y+10,X+30,Y+10);	
			    break;
		 case 2:
				//down
			 g.fill3DRect(X,Y,5,30,false);
			    g.fill3DRect(X+15,Y,5,30,false);
			    g.fill3DRect(X+5,Y+5,10,20,false);
			  //  g.fillOval(X+10,Y+5,90,90);
			      g.fillOval(X+5,Y+10,9,9);
			    g.drawLine(X+10,Y+15,X+10,Y+30);	
			    break;
			case 3://left
				 g.fill3DRect(X,Y,30,5,false);
				    g.fill3DRect(X,Y+15,30,5,false);
				    g.fill3DRect(X+5,Y+5,20,10,false);
				    g.fillOval(X+10,Y+5,9,9);
				    g.drawLine(X+15,Y+10,X,Y+10);	
				    break;
		
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			this.herotk.setDirect(2);
			herotk.y=herotk.y+10;
			this.repaint();
			}
		else if(e.getKeyCode()==KeyEvent.VK_UP){
			this.herotk.setDirect(0);
			herotk.y=herotk.y-10;	
			this.repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			this.herotk.setDirect(3);
			herotk.x=herotk.x-10;	
			this.repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			this.herotk.setDirect(1);
			herotk.x=herotk.x+10;	
			this.repaint();
		} 
		if(e.getKeyCode()==KeyEvent.VK_Z){
		//	g.fill3DRect(X+5,Y+5,10,20,false);
			if(herotk.ss.size()<100){
			this.herotk.shots();
			}
			}
			//System.out.print("事件");
		}
		
	

	int jishu=1;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(10);

				for(int i=0;i<herotk.ss.size();i++)
				{
					for(int j=0;j<ets.size();j++){
						if(herotk.ss.get(i)!=null&&ets.get(j)!=null)
						this.hit(herotk.ss.get(i), ets.get(j));

					}
				}
						
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				othertk o1=new othertk(200,200,3);
				o1.shots();
				shot s1=new shot(o1.x,o1.y,o1.direct);
				ets.add(o1);
				othertk o2=new othertk(100,100,3);
				shot s2=new shot(o2.x,o2.y,0);
				ets.add(o2);
				o2.shots();
				//ots.oss.add(s2);
				Thread t=new Thread(s1);
				t.start();
				Thread t2=new Thread(s2);
				t2.start();
				//ots.oss.add(s1);
			this.repaint();}
			}
		}
	


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

	
