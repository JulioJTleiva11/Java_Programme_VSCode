package op05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Example how to use labels.
 * 
 * @author Henning Dierks
 * @version 1.0
 */
public class SimpleCalendar extends JFrame
implements ActionListener { // to get information 

	private JButton today;
	private JButton nextDay;
	private JButton prevDay;
	private JButton nextMonth;
	private JButton prevMonth;
	
	private JLabel textOfDate;
	private JLabel[] tableOfDays;

	private GregorianCalendar day;
	private static final SimpleDateFormat f 
	  = new SimpleDateFormat("EEEE, dd.MM.yyyy");

	public SimpleCalendar() {
		super("Einfacher Kalender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout(10, 10));

		// initialise the day and the table
		day = new GregorianCalendar(); // now
		tableOfDays = new JLabel[49];
		for (int i=0; i<tableOfDays.length; i++) {
			tableOfDays[i] = new JLabel("");
			tableOfDays[i].setBackground(Color.white);
			tableOfDays[i].setOpaque(true);
			tableOfDays[i].setHorizontalAlignment(SwingConstants.RIGHT);
		}

		// Create the buttons
		today = new JButton("Heute");
		nextDay = new JButton("+1 Tag");
		prevDay = new JButton("-1 Tag");
		nextMonth = new JButton("+1 Monat");
		prevMonth = new JButton("-1 Monat");	


		// Subscribe to information of the radio buttons
		today.addActionListener(this);
		nextDay.addActionListener(this);
		prevDay.addActionListener(this);
		nextMonth.addActionListener(this);
		prevMonth.addActionListener(this);



		// Put all buttons in a panel 
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(prevMonth);
		buttonPanel.add(prevDay);
		buttonPanel.add(today);
		buttonPanel.add(nextDay);
		buttonPanel.add(nextMonth);
		add(buttonPanel, BorderLayout.SOUTH); 

		// Create the JLabel containing the text
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout());
		textOfDate = new JLabel("Noch nichts gedrückt");
		textPanel.add(textOfDate);
		add(textPanel, BorderLayout.NORTH);

		// Create the table of days 
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout(7,7,2,2));
		for (int i=0;i<49;i++) {
			tablePanel.add(tableOfDays[i]);
		}
		
		// we put a panel to draw on in the center
		add(tablePanel, BorderLayout.CENTER); 
		pack(); // organise all the elements
		setVisible(true); // show time!
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == today) {
			day = new GregorianCalendar();
		} else if (ev.getSource() == nextDay) {
			day.add(Calendar.DAY_OF_MONTH, 1);
		} else if (ev.getSource() == prevDay) {
			day.add(Calendar.DAY_OF_MONTH, -1);
		} else if (ev.getSource() == nextMonth) {
			day.add(Calendar.MONTH, 1);
		} else if (ev.getSource() == prevMonth) {
			day.add(Calendar.MONTH, -1);
		} 
		
		// now update the text of the day in JLabel
		String dateText = f.format(day.getTime());
		textOfDate.setText( // HTML is allowed!
				"<html><h1 align=\"center\">" 
				+ dateText
				+ "</h1></html>");
		updateTable();

	}
	private void updateTable() {
		// first get the short symbols of the days {"Mo", "Di",...}
		DateFormatSymbols symbols = new DateFormatSymbols();
		String[] dayNames = symbols.getShortWeekdays();
		
		// now we consider when a week starts...
		int weekStartsWith = day.getFirstDayOfWeek();
		int sundayColumn = (8-weekStartsWith)%7; 
		
		// fill the first row with short names
		for (int i=1; i<dayNames.length; i++) {// i=1 is OK!
			String prefix = "<html><h2>";
			if (i==1) prefix += "<FONT COLOR=RED>";
			tableOfDays[(i-1+sundayColumn)%7].setText(
					prefix +dayNames[i] +"</html>" ); 
		}
		
		// compute the first day of the month
		GregorianCalendar firstOfMonth = 
				(GregorianCalendar) day.clone();
		firstOfMonth.set(Calendar.DAY_OF_MONTH, 1);
		
		// which labels have to be filled?
		int start = (sundayColumn+firstOfMonth.get(Calendar.DAY_OF_WEEK)-1)%7+7;
		int end = start+firstOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH); 

		// fill the labels
		int j=1;
		for (int i = 7 ; i<tableOfDays.length; i++) {
			if (i>=start && i<end) { // valid day
				// sunday shall be red
				String prefix = "<html><h2>";
				if (i%7==sundayColumn) {
					prefix += "<FONT COLOR=RED>";
				}
				
				// mark the current day in green
				if (i-start+1 == day.get(Calendar.DAY_OF_MONTH)) {
					tableOfDays[i].setBackground(Color.yellow);
				} 
				
				// write the day
				tableOfDays[i].setText(prefix+j+"</html>");
				j++; // proceed with tomorrow
			} else { 
				// erase text otherwise!
				tableOfDays[i].setBackground(Color.white);					
				tableOfDays[i].setText("");
			}
		}
	}

	public static void main(String[] args) {
		new SimpleCalendar();
	}
}
