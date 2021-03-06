	package race;	
	import javax.swing.*;
	import javax.swing.event.*;
	import java.awt.*;
	import java.awt.event.*;
	public class racing extends JFrame{
		final int width=900,height=650;
		double p1_speed =0.5,p2_speed=0.5;
		final int up1=0,right1=1,down1=2,left1=3;
		final int up2=0,right2=1,down2=2,left2=3;
		int p1_direction=up1;
		int p2_direction=up2;
		Rectangle left =new Rectangle(0,0,width/9,height);
		Rectangle right =new Rectangle((width/9)*8,0,width/9,height);
		Rectangle top =new Rectangle(0,0,width,height/9);
		Rectangle bottom =new Rectangle(0,(height/9)*8,width,height/9);
		Rectangle center = new Rectangle((int)((width/9)*2.5),(int)((height/9)*2.5),(int)((width/9)*5),(int)((height/9)*4));
		Rectangle obstacle1 =new Rectangle(width/2,(int)((height/9)*7),width/10,height/9);
		Rectangle obstacle2 = new Rectangle(width/3,(int)((height/9)*5),width/10,height/4);
		Rectangle obstacle3 = new Rectangle(2*(width/3),(int)((height/9)*5),width/10,height/4);
		Rectangle obstacle4 = new Rectangle(width/3,height/9,width/30,height/9);
		Rectangle obstacle5 = new Rectangle(width/2,(int)((height/9)*1.5),width/30,height/4);
		Rectangle finish = new Rectangle(100,400,150,10);
		Rectangle lineO = new Rectangle(100,380,75,4);
		Rectangle lineI = new Rectangle(175,360,75,4);
		Rectangle p1 =new Rectangle(100,380,35,20);
		Rectangle p2 =new Rectangle(175,360,35,20);
	
		public racing(){
		super("Radical racing tournament");
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Move1 ob1 =new Move1();
		ob1.start();
		Move2 ob2 =new Move2();
		ob2.start();	
		}
		public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0,width,height);
		g.setColor(Color.YELLOW);
		g.fillRect(left.x,left.y,left.width,left.height);
		g.fillRect(right.x,right.y,right.width,right.height);
		g.fillRect(top.x,top.y,top.width,top.height);
		g.fillRect(bottom.x,bottom.y,bottom.width,bottom.height);
		g.fillRect(center.x,center.y,center.width,center.height);
		g.fillRect(obstacle1.x,obstacle1.y,obstacle1.width,obstacle1.height);
		g.fillRect(obstacle2.x,obstacle2.y,obstacle2.width,obstacle2.height);
		g.fillRect(obstacle3.x,obstacle3.y,obstacle3.width,obstacle3.height);
		g.fillRect(obstacle4.x,obstacle4.y,obstacle3.width,obstacle4.height);
		g.fillRect(obstacle5.x,obstacle5.y,obstacle5.width,obstacle5.height);
		g.setColor(Color.GREEN);
		g.fillRect(lineO.x,lineO.y,lineO.width,lineO.height);
		g.fillRect(lineI.x,lineI.y,lineI.width,lineI.height);
		g.setColor(Color.YELLOW);
		g.fillRect(finish.x,finish.y,finish.width,finish.height);
		g.setColor(Color.BLACK);
		g.drawString("Finish Line",100,412);
		g.drawString("Player1",100,384);
		g.drawString("Player2",175,364);
		g.setColor(Color.BLUE);
		g.fill3DRect(p1.x,p1.y,p1.width,p1.height,true);
		g.setColor(Color.RED);
		g.fill3DRect(p2.x,p2.y,p2.width,p2.height,true);
	
	
		}
		private class Move1 extends Thread implements KeyListener{
			public void run(){
			addKeyListener(this);		
			while(true){
				try{
				repaint();
				if(p1.intersects(left) ||p1.intersects(right) ||p1.intersects(bottom) ||p1.intersects(top) ||p1.intersects(obstacle1) ||p1.intersects(obstacle2) ||p1.intersects(obstacle3) ||p1.intersects(obstacle4) ||p1.intersects(obstacle5)){
				p1_speed=-6;
				}
				if(p1.intersects(center)){p1_speed=-4.5;}
			
				if(p1_speed<5)
					p1_speed=p1_speed+0.2;
				if(p1_direction==up1)
				{
				p1.y-=(int)p1_speed;
				}
				if(p1_direction==down1)
				{
				p1.y+=(int)p1_speed;
				}
				if(p1_direction==left1)
				{
				p1.x-=(int)p1_speed;
				}
				if(p1_direction==right1)
				{			
				p1.x+=(int)p1_speed;
				}
				//p1.y=p1.y-(int)(p1_speed*10);
				/*if(p1.y<70){break;}
				Thread.sleep(200);
				}*/
				Thread.sleep(175);
				}
				catch(Exception e){break;}
			
			}		
			}	
	
		public void keyReleased(KeyEvent event)
	{
	}
		public void keyPressed(KeyEvent event){}
		public void keyTyped(KeyEvent event){
				if(event.getKeyChar() == 'a')
					p1_direction=left1;
				if(event.getKeyChar() == 's')
					p1_direction=right1;
				if(event.getKeyChar() == 'w')
					p1_direction=up1;
				if(event.getKeyChar() == 'z')
					p1_direction=down1;				
		
				}
	}
		private class Move2 extends Thread implements KeyListener{
			public void run(){
			addKeyListener(this);
			while(true){
		
			try{
				repaint();
				if(p2.intersects(left) ||p2.intersects(right) ||p2.intersects(bottom) ||p2.intersects(top) ||p2.intersects(obstacle1) ||p2.intersects(obstacle2) ||p2.intersects(obstacle3) ||p2.intersects(obstacle4) ||p2.intersects(obstacle5)){
				p2_speed=-6;
				}
				if(p2.intersects(center)){p2_speed=-4.5;}
			
				if(p2_speed<5)
					p2_speed=p2_speed+0.2;
				if(p2_direction==up1)
				{
				p2.y-=(int)p2_speed;
				}
				if(p2_direction==down1)
				{
				p2.y+=(int)p2_speed;
				}
				if(p2_direction==left1)
				{
				p2.x-=(int)p2_speed;
				}
				if(p2_direction==right1)
				{			
				p2.x+=(int)p2_speed;
				}
				//p1.y=p1.y-(int)(p1_speed*10);
				/*if(p1.y<70){break;}
				Thread.sleep(200);
				}*/
				Thread.sleep(175);
				}
				catch(Exception e){break;}
			}		
			}	
	
		public void keyReleased(KeyEvent event)
	{
	}
		public void keyPressed(KeyEvent event){}
		public void keyTyped(KeyEvent event){
				if(event.getKeyChar() == 'j')
					p2_direction=left2;
				if(event.getKeyChar() == 'k')
					p2_direction=right2;
				if(event.getKeyChar() == 'i')
					p2_direction=up2;
				if(event.getKeyChar() == 'm')
					p2_direction=down2;				
		
				}
	}
		public void race(){
		new racing();
		}
		public static void main(String args[]){
		racing object =new racing();
		object.race();	
		}

	}
