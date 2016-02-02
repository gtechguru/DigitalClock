import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.*;

public class Board extends JPanel implements ActionListener
{
	private JLabel hourLabel,colon1,minuteLabel,colon2,secondLabel,clockLabel,ssecondLabel,sminuteLabel,logoLabel,shourLabel;
	private JButton clock,timer,stopwatch,stop,pause,spause,restart,start;
	public int sec=0,min=0,hvr=0,ssec=0,smin=0,shvr=0;
	public javax.swing.Timer t = new javax.swing.Timer(1000, this);
	public Timer t1=new Timer(1000,null);

	int seconds=-1;
	public Board()
	{
		// JFrame frame=new JFrame("DIGITAL CLOCK");
		// JPanel panel=new JPanel();


		setLayout(null);
		setSize(400,400);
		setBounds(10,20,200,100);

		ImageIcon icon = new ImageIcon("pix.png");
		logoLabel = new JLabel(icon);
		logoLabel.setBounds(5,130,340,40);
		logoLabel.setVisible(true);

		clock=new JButton("CLOCK");
		clock.setBounds(5,5,100,30);
		clock.setBackground(Color.red);
		clock.setForeground(Color.yellow);
		timer=new JButton("TIMER");
		timer.setBackground(Color.red);
		timer.setForeground(Color.yellow);
		timer.setBounds(125,5,100,30);
		stopwatch=new JButton("STOPWATCH");
		stopwatch.setBounds(250,5,130,30);
		stopwatch.setBackground(Color.red);
		stopwatch.setForeground(Color.yellow);
		clockLabel=new JLabel();
		clockLabel.setBackground(Color.red);
		clockLabel.setForeground(Color.blue);
		clockLabel.setBounds(5,50,350,30);
		clockLabel.setFont(new Font("Chiller", Font.BOLD, 20));
		clockLabel.setVisible(false);
		setBackground(Color.black);
		
		hourLabel=new JLabel("00");
		hourLabel.setBounds(5,100,30,30);
		hourLabel.setForeground(Color.blue);
		hourLabel.setFont(new Font("Chiller", Font.BOLD, 20));
		hourLabel.setVisible(false);

		minuteLabel=new JLabel("00");
		minuteLabel.setBounds(50,100,30,30);
		minuteLabel.setForeground(Color.blue);
		minuteLabel.setFont(new Font("Chiller", Font.BOLD, 20));
		minuteLabel.setVisible(false);

		secondLabel=new JLabel("00");
		secondLabel.setBounds(95,100,30,30);
		secondLabel.setForeground(Color.blue);
		secondLabel.setFont(new Font("Chiller", Font.BOLD, 20));
		secondLabel.setVisible(false);

		shourLabel=new JLabel("00");
		shourLabel.setBounds(5,100,30,30);
		shourLabel.setForeground(Color.blue);
		shourLabel.setFont(new Font("Chiller", Font.BOLD, 20));
		shourLabel.setVisible(false);

		sminuteLabel=new JLabel("00");
		sminuteLabel.setBounds(50,100,30,30);
		sminuteLabel.setForeground(Color.blue);
		sminuteLabel.setFont(new Font("Chiller", Font.BOLD, 20));
		sminuteLabel.setVisible(false);

		ssecondLabel=new JLabel("00");
		ssecondLabel.setBounds(95,100,30,30);
		ssecondLabel.setForeground(Color.blue);
		ssecondLabel.setFont(new Font("Chiller", Font.BOLD, 20));
		ssecondLabel.setVisible(false);

		start=new JButton("START");
		start.setBounds(135,100,90,30);
		start.setBackground(Color.red);
		start.setForeground(Color.yellow);
		start.setVisible(false);

		pause=new JButton("PAUSE");
		pause.setBounds(255,100,100,30);
		pause.setBackground(Color.red);
		pause.setForeground(Color.yellow);
		pause.setVisible(false);

		restart=new JButton("RESTART");
		restart.setBounds(135,100,100,30);
		restart.setBackground(Color.red);
		restart.setForeground(Color.yellow);
		restart.setVisible(false);

		spause=new JButton("PAUSE");
		spause.setBounds(255,100,100,30);
		spause.setBackground(Color.red);
		spause.setForeground(Color.yellow);
		spause.setVisible(false);

		add(clock);
		add(timer);
		add(stopwatch);
		add(clockLabel);
		add(hourLabel);
		
		add(minuteLabel);
		
		add(secondLabel);
		add(shourLabel);
		add(sminuteLabel);
		add(ssecondLabel);
		add(start);
		add(pause);
		add(restart);
		add(spause);
		add(logoLabel);
		// frame.add(panel);
		
		// frame.setVisible(true);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//ActionListener
		pause.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event)
			{
				pause.setVisible(false);
				start.setVisible(true);
				t.stop();
			}
		});

		restart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event)
			{
								spause.setVisible(true);
								restart.setVisible(false);
								t1.start();
			}
		});

		spause.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event)
			{
				spause.setVisible(false);
				restart.setVisible(true);
				t1.stop();
			}
		});

		clock.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event)
			{
				t.start();
				hourLabel.setVisible(false);
				minuteLabel.setVisible(false);
				secondLabel.setVisible(false);
				start.setVisible(false);
				pause.setVisible(false);
				clockLabel.setVisible(true);
				
				
			}
		});

		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event)
			{
								pause.setVisible(true);
								start.setVisible(false);
								t.start();
			}
		});

		stopwatch.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event)
			{
		 		clockLabel.setVisible(false);
				hourLabel.setVisible(false);
				minuteLabel.setVisible(false);
				secondLabel.setVisible(false);
				shourLabel.setVisible(true);
				sminuteLabel.setVisible(true);
				ssecondLabel.setVisible(true);
				//restart.setVisible(true);
				spause.setVisible(true);

				t1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt)
			{
				ssec=ssec+1;
             	int hour=ssec/3600;
				updateLabel(shourLabel,hour);
				int minute=(ssec%3600)/60;
				updateLabel(sminuteLabel,minute);
				int second=ssec%60;
				updateLabel(ssecondLabel,second);
			}

			
		});
				t1.start();
			}
		});

		timer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event)
			{
				t.stop();
				// t1.stop();
				clockLabel.setVisible(false);
				hourLabel.setVisible(true);
				minuteLabel.setVisible(true);
				secondLabel.setVisible(true);
				shourLabel.setVisible(false);
				sminuteLabel.setVisible(false);
				ssecondLabel.setVisible(false);
				start.setVisible(true);
				restart.setVisible(false);
				spause.setVisible(false);
				//t2.cancel();
				
				String secValue = (String)JOptionPane.showInputDialog(null, "Please enter your seconds", "Set Time",
				JOptionPane.QUESTION_MESSAGE, null, new Object[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"},"1");
				sec=Integer.valueOf(secValue);	
				updateLabel(secondLabel,sec);
	
				//secondds updation is end

				//minute updation is Starts
				String minValue = (String)JOptionPane.showInputDialog(null, "Please enter your minute", "Set Time",
				JOptionPane.QUESTION_MESSAGE, null,new Object[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"},"1");
				min=Integer.valueOf(minValue);
				updateLabel(minuteLabel,min);
				
				//minute updation is end

				//Hour updation is Start
				String hvrValue = (String)JOptionPane.showInputDialog(null, "Please enter your Hour", "Set Time",
				JOptionPane.QUESTION_MESSAGE, null, null, hvr);
				hvr=Integer.valueOf(hvrValue);
				if(hvr<0)
				{
					hvr=0;
					updateLabel(hourLabel,hvr);
					
				}
				else
				{
					updateLabel(hourLabel,hvr);
				}
				//hour updation is end

				//Converting Into second
				seconds=(hvr*3600)+(min*60)+sec;
			}
		});
	}


	public void updateLabel(JLabel label,Integer value)
	{
        label.setText(String.format("%02d",value));
	}

	public void setLabel(int seconds)
	{
			int hour=seconds/3600;
			updateLabel(hourLabel,hour);
			int minute=(seconds%3600)/60;
			updateLabel(minuteLabel,minute);
			int second=seconds%60;
			updateLabel(secondLabel,second);
	}

	public void actionPerformed(ActionEvent A) 
	{
		
		
		
		
			if(seconds==0)
		{
			updateLabel(secondLabel,seconds);	
			updateLabel(minuteLabel,seconds);
			updateLabel(hourLabel,seconds);
			
			pause.setVisible(false);
			t.stop();
			MakeSound ms=new MakeSound();
			ms.playSound("sound1.WAV");
		}
		else
		{
			seconds=seconds-1;
			setLabel(seconds);
		}
			clockLabel.setText((new Date( )).toString( ));
		 
	}


}