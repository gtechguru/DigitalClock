import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.*;
class DigitalClock extends JFrame
{
	DigitalClock()
	{

		add(new Board());
		setVisible(true);
		setSize(400,195);
		setResizable(false);
		// pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main(String[] args) {
		DigitalClock dc=new DigitalClock();
	}


}
