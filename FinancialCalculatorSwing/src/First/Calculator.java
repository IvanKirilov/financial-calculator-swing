package First;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Calculator {

	private JFrame frame;
	private JLabel result, lbl1, lbl2, lbl3;
	private JTextField a, b;
	private JButton calculate, clear;
	private ListenForButton lb;
	private float digitA, digitB;
	private ButtonGroup bg;
	private JRadioButton rb1, rb2, rb3, rb4, rb5, rb6;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lb = new ListenForButton();
		bg = new ButtonGroup();

		frame = new JFrame();
		frame.setBounds(100, 100, 832, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.getContentPane().setBackground(java.awt.Color.green);
		frame.getContentPane().setLayout(null);

		result = new JLabel();
		result.setBounds(0, 29, 298, 20);
		result.setOpaque(true);
		frame.getContentPane().add(result);

		lbl1 = new JLabel("Резултат");
		lbl1.setBounds(10, 4, 99, 14);
		frame.getContentPane().add(lbl1);

		lbl2 = new JLabel("");
		lbl2.setBounds(0, 71, 298, 14);
		frame.getContentPane().add(lbl2);

		lbl3 = new JLabel("");
		lbl3.setBounds(0, 135, 298, 14);
		frame.getContentPane().add(lbl3);

		a = new JTextField();
		a.setBounds(0, 104, 99, 20);
		frame.getContentPane().add(a);
		a.setColumns(10);

		b = new JTextField();
		b.setBounds(0, 169, 99, 20);
		frame.getContentPane().add(b);
		b.setColumns(10);

		calculate = new JButton("Изчисли!");
		calculate.setBounds(0, 227, 99, 23);
		frame.getContentPane().add(calculate);
		calculate.addActionListener(lb);
		calculate.setEnabled(false);

		clear = new JButton("Изтрий!");
		clear.setBounds(199, 328, 99, 23);
		frame.getContentPane().add(clear);
		clear.addActionListener(lb);

		rb1 = new JRadioButton("Коефициент на рентабилност на приходите от продажби");
		rb1.setBounds(348, 7, 397, 23);
		frame.getContentPane().add(rb1);
		rb1.addActionListener(lb);

		rb2 = new JRadioButton("Коефициент на рентабилност на собствения капитал");
		rb2.setBounds(348, 29, 397, 23);
		frame.getContentPane().add(rb2);
		rb2.addActionListener(lb);

		rb3 = new JRadioButton("Коефициент на рентабилност на активите");
		rb3.setBounds(348, 52, 397, 23);
		frame.getContentPane().add(rb3);
		rb3.addActionListener(lb);

		rb4 = new JRadioButton("Коефициент на приходите от обичайна дейност");
		rb4.setBounds(348, 75, 397, 23);
		frame.getContentPane().add(rb4);
		rb4.addActionListener(lb);

		rb5 = new JRadioButton("Коефициент на финансова автономност");
		rb5.setBounds(348, 101, 397, 23);
		frame.getContentPane().add(rb5);
		rb5.addActionListener(lb);

		rb6 = new JRadioButton("Нетен паричен поток");
		rb6.setBounds(348, 126, 397, 23);
		frame.getContentPane().add(rb6);
		rb6.addActionListener(lb);

		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		bg.add(rb5);
		bg.add(rb6);

	}

	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == rb1) {
				calculate.setEnabled(true);
				lbl2.setText("Финансов резултат от продажби");
				lbl3.setText("Нетен размер на приходите от продажби");
			}

			if (e.getSource() == rb2) {
				calculate.setEnabled(true);
				lbl2.setText("Балансова печалба/загуба");
				lbl3.setText("Собствен капитал");
			}

			if (e.getSource() == rb3) {
				calculate.setEnabled(true);
				lbl2.setText("Финансов резултат преди разходи за лихви");
				lbl3.setText("Балансова стойност на активите");

			}

			if (e.getSource() == rb4) {
				calculate.setEnabled(true);
				lbl2.setText("Разходи за обичайна дейност");
				lbl3.setText("Приходи от обичайна дейност");
			}

			if (e.getSource() == rb5) {
				calculate.setEnabled(true);
				lbl2.setText("Собствен капитал");
				lbl3.setText("Обща сума на пасивите");
			}

			if (e.getSource() == rb6) {
				calculate.setEnabled(true);
				lbl2.setText("Входящ паричен поток");
				lbl3.setText("Изходящ паричен поток");
			}

			if (e.getSource() == calculate) {
				digitA=Float.parseFloat(a.getText());
				digitB = Float.parseFloat(b.getText());
				if (rb6.isSelected()) {
					result.setText (String.valueOf(Math.round( digitA - digitB)));
				} else {
				result.setText(String.valueOf(Math.round(digitA / digitB*100)/100F))	;
				}
			}
			if (e.getSource() == clear) {
				result.setText("");
				a.setText("");
				b.setText("");
			}
		}
	}
}
