package op06;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Window to observe threads easily.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class ThreadViewer  extends JFrame {

	private JLabel[] labels;
	private JPanel panel;

	/**
	 * Creates a window showing all given threads.
	 * @param threads the threads to present.
	 */
	public ThreadViewer(Runnable[] threads) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// how large is the whole screen?
		Dimension d = getToolkit().getScreenSize();
		d.width = (d.width / 3) * 2;
		d.height = (d.height / 5) * 2;
		// ok, take 66% of the width and 40% of the height
		setSize(d);

		setLocation(0,0);
		setTitle("ThreadViewer");

			panel = new JPanel() { // anonymous class
				public void paintComponent(Graphics g) {
					super.paintComponent(g); // never forget!

					for (int i = 0; i < threads.length; i++) {
						long value = -1; 
						String text = "";
						// show all threads that provide getCounter()
						if (threads[i] instanceof GetCounter) {
							// interface is implemented -> cast is safe
							GetCounter gc = (GetCounter) threads[i];
							// now fetch the value
							value = gc.getCounter();
						}
						// if it is a thread, we want to see the name
						if (threads[i] instanceof Thread) {
							// cast is safe now
							Thread t = (Thread) threads[i];
							// get name of thread
							text = t.getName() + " : " + value;
						} else { // otherwise we don't write the name
							text = "Value of " + i + " : " + value;
						}
						// now change the ith label
						labels[i].setText(text);
					}
				}
			}; // end of anonymous class

			// building the content of the panel now
			panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
			if (threads != null) {
				Font f = new Font("Monospace",Font.BOLD,32);
				labels = new JLabel[threads.length];
				for (int i = 0; i < threads.length; i++) {
					labels[i] = new JLabel("" + i);
					labels[i].setFont(f);
					labels[i].setPreferredSize(new Dimension(400,40));
					panel.add(labels[i]);
				}
			}
		add(panel);

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				panel.repaint();
			}
		};
		Timer timer = new Timer();
		timer.schedule(task,0,1000);



		setVisible(true); // show time!
	}

	/**
	 * Update the panel showing the values of the threads.
	 */
	public void update() { 
		// instead of repainting all the time we
		// installed a timed task to do this all 0.1 seconds
		//panel.repaint(); 
	}
}

