import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Ball extends Applet implements ActionListener,Runnable
	{
	Button b1,b2,b3,b4;
	Font f;
	TextField tf1,tf2;
	Label l1,l2;
	Thread t;
	public void init()
	{
	b1=new Button("Life");
	b2=new Button("Kill");
	b3=new Button("pause");
	b4=new Button("Resume");
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	f=new Font("Arial",Font.BOLD,22);
	b1.setFont(f);
	b2.setFont(f);
	b3.setFont(f);
	b4.setFont(f);
	l1=new Label("No of Balls:");
	l1.setFont(f);
	tf1=new TextField(5);
	tf1.setFont(f);
	l2=new Label("Speed:");
	tf2=new TextField(5);
	tf2.setFont(f);
	
	add(l1);
	add(tf1);
	add(l2);
	add(tf2);
	add(b1);
	add(b2);
	add(b3);
	add(b4);
	}
	public void actionPerformed(ActionEvent ae)
		{
		if((ae.getSource()==b1)&&(t==null))
			{
			t=new Thread(this);
			t.start();
			}
		else if((ae.getSource()==b2)&&(t!=null))
			{
			t.stop();
			t=null;
			}
		else if((ae.getSource()==b3)&&(t!=null))
				{
				t.suspend();
				}
		else if((ae.getSource()==b4)&& (t!=null))
			{
			t.resume();
			}
		}
	public void run()
			{
			while(true)
				{
				repaint();
				try{
				Thread.sleep(Long.parseLong(tf2.getText()));
				}catch(Exception ee)
					{
					ee.printStackTrace();
					}
				}
			}
	public void paint(Graphics g)
			{
			for(int i=1;i<=(Integer.parseInt(tf1.getText()));i++)
				{
				int r=(int)(Math.random()*1000%254);
				int g1=(int)(Math.random()*1000%254);
				int b=(int)(Math.random()*1000%254);
				Color c=new Color(r,g1,b);
				g.setColor(c);
				int x=(int)(Math.random()*1000%599);
				int y=(int)(Math.random()*1000%599);
				g.fillOval(x,y,70,70);
				}
			}
		}

/*<applet code="Ball" width=400 height=600></applet>*/
	
	
