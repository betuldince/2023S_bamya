package UI.otherScreens;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationGiver {
	public InformationGiver() {
		
	}
	public static void run(String the_message , int message_time) throws InterruptedException {
		JFrame frame=new JFrame();
		JLabel label=new JLabel(the_message);
		
		JPanel panel=new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
		
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Message: ");
        frame.pack();
        frame.setVisible(true);
        
        
        TimeUnit.SECONDS.sleep(message_time);
        frame.dispose(); 

		
	}

}
