package op06;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Window to observe threads easily by showing bars.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class ThreadViewerWithBars extends JFrame {
	
	private JPanel panel;
	
	/**
	 * Constructs a ThreadViewer visualizing the race of the threads
	 * by using bars.
	 * @param threads is an array of thread to visualize
	 * @param limit is the max value the threads are running to. 
	 *              If limit <= 0 no visualization is shown 
	 */
	public ThreadViewerWithBars(Runnable[] threads, long limit) {
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
			public void paintComponent(Graphics gr) {
				super.paintComponent(gr); // never forget!

				Graphics2D g = (Graphics2D)(gr);
				long[] values = new long[threads.length];
				long min = -1;
				long max = 0;
				for (int i = 0; i < threads.length; i++) {
					if (threads[i] instanceof GetCounter) {
						// interface is implemented -> cast is safe
						GetCounter gc = (GetCounter) threads[i];
						// now fetch the value
						values[i] = gc.getCounter();
						if (values[i] > max) { 
							max = values[i]; 
						}
						if (values[i] < min || min == -1) {
							min = values[i];
						}
					} else {
						values[i] = -4711;
					}
				}	
				// compute current position in the race
				int[] pos = new int[threads.length];
				for (int i = 0; i < pos.length; i++) {
					pos[i] = 0;
					for (int j = 0; j < pos.length; j++) {
						if (values[i] < values[j]) {
							pos[i]++;
						}
					}
				}
				// get the current dimension of the panel
				Dimension d = getSize();
				int w = d.width;
				int h = d.height;
				long[] averages = new long[11]; // average value of prio
				int[] memberOfPrio = new int[11]; // how many have this prio

				int heightInc = h / (threads.length + 9);
				g.setColor(Color.red);
				g.drawRect(1, 1, w - 2, h - 2);
				g.setColor(Color.blue);
				for (int i = 0; i < threads.length; i++) {
					// if it is a thread, we want to see the name
					if (threads[i] instanceof Thread) {
						// cast is safe now
						Thread t = (Thread) threads[i];
						int prio = t.getPriority();
						averages[prio] += values[i];
						memberOfPrio[prio]++; 

						g.setColor(new Color(0,0,100 + (threads.length - pos[i]) * 155 / threads.length));
						g.fillRect(200, heightInc * (i + prio - 1), 
								(int) (((w - 204) * values[i]) / (max+1)), heightInc - 2);

						g.setColor(Color.black);
						g.drawString("" + i + " Prio: " + prio
								+ " V: " + values[i] + " Position : " + pos[i], 
								4,heightInc * (i + prio) - 3);
					}
				}
				// now draw the red line for the average values 
				for (int prio = 1; prio <= 10; prio++) {
					if (memberOfPrio[prio] > 0) {
						averages[prio] /= memberOfPrio[prio];
					}
				}
				int y = heightInc * memberOfPrio[1] / 2;
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.red);

				for (int prio = 1; prio <= 9; prio++) {
					int y2 = y + heightInc * (1 + memberOfPrio[prio + 1]);
					if (memberOfPrio[prio] > 0 && memberOfPrio[prio + 1] > 0) {
						g.drawLine(
								200 + (int) (((w - 204) * averages[prio]) / (max+1)), y, 
								200 + (int) (((w - 204) * averages[prio + 1]) / (max+1)), y2);
					}
					y = y2;
				}
			}
		}; // end of anonymous class

		add(panel);

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				panel.repaint();
			}
		};
		Timer timer = new Timer();
		timer.schedule(task,0,100);



		setVisible(true); // show time!
	}

	/**
	 * Update the panel showing the values of the threads.
	 */
	public void update() { 
		// instead of repainting all the time we
		// installed a timed task to do this all 0.1 seconds
		// panel.repaint();
	}
}

