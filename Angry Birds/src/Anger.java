import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Anger { //Private is to keep the stuff inside the swing
	private JFrame main;
	private JLabel target_lbl;
	private JLabel theta_lbl;
	private JLabel v_lbl;
	private JLabel x_lbl;
	private JLabel y_lbl;
	private JPanel ctrl_pane;
	private JFormattedTextField target;
	private JFormattedTextField angle_of_elv;
	private JFormattedTextField int_velocity;
	private JFormattedTextField x_position;
	private JFormattedTextField y_position;

	private Anger() { //Before the program actually starts
		set();
	}

	public static void main(String[] args) { //Main method redirects to swing 
		Anger a = new Anger();
		a.show();
	}

	private MaskFormatter getMaskFormatter(String format) {
		MaskFormatter m = null;

		try {
			m = new MaskFormatter(format);
			m.setPlaceholderCharacter('_');
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return m;
	}

	private void set() {
		ctrl_pane = new JPanel();
		main = new JFrame("Information Center: Angry Birds");

		ctrl_pane.setLayout(new SpringLayout());
		ctrl_pane.setSize(400,400);

		main.add(ctrl_pane);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(400,220);
		main.setLayout(new GridLayout(1,4));
		main.setVisible(true); 
	}

	private void show(){
		JButton reveal = new JButton("Snipe!!");
		JButton clear = new JButton("Reset");
		target_lbl = new JLabel("Please enter the position of the target (ground): ");
		theta_lbl = new JLabel("Please enter the angle of elevation (degree): ");
		v_lbl = new JLabel("Please enter the initial velocity: ");;
		x_lbl = new JLabel("Please enter the initial position (x): ");
		y_lbl = new JLabel("Please enter the initial position (y): ");;
		target = new JFormattedTextField(getMaskFormatter("####"));
		angle_of_elv = new JFormattedTextField(getMaskFormatter("##"));
		int_velocity = new JFormattedTextField(getMaskFormatter("###.##"));
		x_position = new JFormattedTextField(getMaskFormatter("###.##"));
		y_position = new JFormattedTextField(getMaskFormatter("###.##"));

		ctrl_pane.add(target_lbl);
		ctrl_pane.add(target);
		ctrl_pane.add(theta_lbl);
		ctrl_pane.add(angle_of_elv);
		ctrl_pane.add(v_lbl);
		ctrl_pane.add(int_velocity);
		ctrl_pane.add(x_lbl);
		ctrl_pane.add(x_position);
		ctrl_pane.add(y_lbl);
		ctrl_pane.add(y_position);
		ctrl_pane.add(reveal);
		ctrl_pane.add(clear);
		SpringUtilities.makeCompactGrid(ctrl_pane,
				6, 2,
				6, 6,    
				6, 6
				);
		
		target.setHorizontalAlignment(SwingConstants.CENTER);
		angle_of_elv.setHorizontalAlignment(SwingConstants.CENTER);
		int_velocity.setHorizontalAlignment(SwingConstants.CENTER); 
		x_position.setHorizontalAlignment(SwingConstants.CENTER);
		y_position.setHorizontalAlignment(SwingConstants.CENTER);

		clear.setActionCommand("Reset");
		clear.addActionListener(new BListen());

		reveal.addActionListener(new BListen());

		main.addMouseListener(new MListen());
		main.addMouseMotionListener(new MMListen());
		main.setVisible(true);
	}

	private class BListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double theta, v0, x0, y0;
			int t;
			String[] args = new String[0];
			String command = e.getActionCommand();

			if (command.equals("Reset")){
				target.setText("");
				angle_of_elv.setText("");
				int_velocity.setText("");
				x_position.setText("");
				y_position.setText("");
			}
			else{
				try{
					t = Integer.valueOf(target.getText());
					theta = Double.valueOf(angle_of_elv.getText())*Math.PI/180;
					v0 = Double.valueOf(int_velocity.getText());
					x0 = Double.valueOf(x_position.getText());
					y0 = Double.valueOf(y_position.getText());
					LineChart_AWT.main(args,theta,v0,x0,y0,t);
				}
				catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(main, "Please fill in every slot (including placeholders).");
				}
				catch (Exception ex){
					JOptionPane.showMessageDialog(main, "How'd you get here?");
					ex.printStackTrace();
				}
			}
		}	
	}

	private class MListen implements MouseListener {
		public void mousePressed(MouseEvent e){
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
	}

	private class MMListen implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
		}

		public void mouseMoved(MouseEvent e) {
		}
	}

	@SuppressWarnings("serial")
	private static class LineChart_AWT extends ApplicationFrame {
		public LineChart_AWT(String applicationTitle, String chartTitle, double theta, double v0, double x0, double y0, double yequal0) {
			super(applicationTitle);
			final XYSeries series = new XYSeries("Position");
			for (double t = 0.0; t <= 200.0; t += 0.01){
				double g = 9.81;
				double x = x0 + v0*t*Math.cos(theta);
				double y = y0 + v0*t*Math.sin(theta)-g*t*t/2.0;

				if (y < 0.0)
					y = Double.NaN;
				if (x < 0.0 || x > (yequal0 + 100.0))
					continue;
				series.add(x,y);
			}
			final XYSeriesCollection data = new XYSeriesCollection(series);
			final JFreeChart sin = ChartFactory.createXYLineChart(
					chartTitle,
					"Distance (Horizontal)",
					"Altitude",
					data,
					PlotOrientation.VERTICAL,
					true,
					true,
					false
					);
			final ChartPanel chartPanel = new ChartPanel(sin);
			chartPanel.setPreferredSize(new java.awt.Dimension(560,367));
			setContentPane(chartPanel);
		}

		public static void main(String[] args, double theta, double v0, double x0, double y0, int t) {
			double g = 9.81;
			double a = -g/2.0;
			double b = v0*Math.sin(theta);
			double c = y0;
			double top = -Math.sqrt(b*b - (4.0*a*c)) - b;
			double tequal0 = top/2.0/a;
			double yequal0 = x0 + v0*tequal0*Math.cos(theta);
			double maxt = v0*Math.sin(theta)/g;
			double maxy = y0 + v0*maxt*Math.sin(theta)-g*maxt*maxt/2.0;
			String result = "";
			
			DecimalFormat place2 = new DecimalFormat("0.00");
			final LineChart_AWT chart = new LineChart_AWT("Graph","S(t) - Position",theta,v0,x0,y0,yequal0);

			chart.pack();
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
			
			if (t == (int) yequal0)
				result = "The target that was " + t + "m away was hit!!!!";
			else if (t > (int) yequal0)
				result = "YOU HAVE SHAMED YOUR FAMILY!!!\n(You were too short...)";
			else if (t < (int) yequal0)
				result = "YOU HAVE SHAMED YOUR FAMILY!!!\n(You were too far...)";
				
			JOptionPane.showMessageDialog(null, result + "\nThe maximum altitude your bird reached was " + place2.format(maxy) + ".");
		}
	}
}
