package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Professor extends JFrame {

	private JPanel contentPane;
	private JButton btnCancel, btnOkey;
	JTextPane lessons, disc, cal, prog, phy, eng, his, lit;
	private JTextPane txtpnMidtermExam, txtpnFinalExam, txtpnQuiz, txtpnAvarage;
	private static JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6,
			textField_7, textField_8, textField_9, textField_10, textField_11, textField_12, textField_13, textField_14,
			textField_15, textField_16, textField_17, textField_18, textField_19, textField_20;
	private static JTextPane textPane, textPane_1, textPane_2, textPane_3, textPane_4, textPane_5, textPane_6;
	private static JTextField[] textfields = { textField, textField_1, textField_2, textField_3, textField_4, textField_5,
			textField_6, textField_7, textField_8, textField_9, textField_10, textField_11, textField_12, textField_13,
			textField_14, textField_15, textField_16, textField_17, textField_18, textField_19, textField_20 };
	private static JTextPane[] textPanes = { textPane, textPane_1, textPane_2, textPane_3, textPane_4, textPane_5,
			textPane_6 };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Professor frame = new Professor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Professor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(130, 11, 484, 122);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(10, 11, 98, 122);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 144, 604, 202);
		panel_2.setLayout(null);
		contentPane.add(panel_2);

		lessons = new JTextPane();
		lessons.setText("Lessons");
		lessons.setBounds(10, 10, 98, 20);
		lessons.setEditable(false);

		disc = new JTextPane();
		disc.setText("Discrete Math");
		disc.setBounds(10, 33, 98, 20);
		disc.setEditable(false);

		cal = new JTextPane();
		cal.setText("Calculus");
		cal.setBounds(10, 54, 98, 20);
		cal.setEditable(false);

		prog = new JTextPane();
		prog.setText("Programming");
		prog.setBounds(10, 75, 98, 20);
		prog.setEditable(false);

		phy = new JTextPane();
		phy.setText("Physics");
		phy.setBounds(10, 96, 98, 20);
		phy.setEditable(false);

		eng = new JTextPane();
		eng.setText("English");
		eng.setBounds(10, 117, 98, 20);
		eng.setEditable(false);

		his = new JTextPane();
		his.setText("History");
		his.setBounds(10, 138, 98, 20);
		his.setEditable(false);

		lit = new JTextPane();
		lit.setText("Literature");
		lit.setBounds(10, 159, 98, 20);
		lit.setEditable(false);

		panel_2.add(lessons);
		panel_2.add(disc);
		panel_2.add(cal);
		panel_2.add(prog);
		panel_2.add(phy);
		panel_2.add(eng);
		panel_2.add(his);
		panel_2.add(lit);

		txtpnMidtermExam = new JTextPane();
		txtpnMidtermExam.setText("Midterm Exam");
		txtpnMidtermExam.setBounds(118, 10, 79, 20);
		txtpnMidtermExam.setEditable(false);
		panel_2.add(txtpnMidtermExam);

		txtpnFinalExam = new JTextPane();
		txtpnFinalExam.setText("Final Exam");
		txtpnFinalExam.setBounds(207, 10, 79, 20);
		txtpnFinalExam.setEditable(false);
		panel_2.add(txtpnFinalExam);

		txtpnQuiz = new JTextPane();
		txtpnQuiz.setText("Quiz");
		txtpnQuiz.setBounds(296, 10, 65, 20);
		txtpnQuiz.setEditable(false);
		panel_2.add(txtpnQuiz);

		txtpnAvarage = new JTextPane();
		txtpnAvarage.setText("Avarage");
		txtpnAvarage.setBounds(403, 10, 98, 20);
		txtpnAvarage.setEditable(false);
		panel_2.add(txtpnAvarage);

		textfields[0] = new JTextField();
		textfields[0].setBounds(118, 33, 79, 20);
		panel_2.add(textfields[0]);
		textfields[0].setColumns(10);

		textfields[1] = new JTextField();
		textfields[1].setBounds(207, 33, 79, 20);
		panel_2.add(textfields[1]);
		textfields[1].setColumns(10);

		textfields[2] = new JTextField();
		textfields[2].setBounds(296, 33, 65, 20);
		panel_2.add(textfields[2]);
		textfields[2].setColumns(10);

		textfields[3] = new JTextField();
		textfields[3].setBounds(118, 54, 79, 20);
		panel_2.add(textfields[3]);
		textfields[3].setColumns(10);

		textfields[4] = new JTextField();
		textfields[4].setBounds(207, 54, 79, 20);
		panel_2.add(textfields[4]);
		textfields[4].setColumns(10);

		textfields[5] = new JTextField();
		textfields[5].setBounds(296, 54, 65, 20);
		panel_2.add(textfields[5]);
		textfields[5].setColumns(10);

		textfields[6] = new JTextField();
		textfields[6].setBounds(118, 75, 79, 20);
		panel_2.add(textfields[6]);
		textfields[6].setColumns(10);

		textfields[7] = new JTextField();
		textfields[7].setBounds(207, 75, 79, 20);
		panel_2.add(textfields[7]);
		textfields[7].setColumns(10);

		textfields[8] = new JTextField();
		textfields[8].setBounds(296, 75, 65, 20);
		panel_2.add(textfields[8]);
		textfields[8].setColumns(10);

		textfields[9] = new JTextField();
		textfields[9].setBounds(118, 96, 79, 20);
		panel_2.add(textfields[9]);
		textfields[9].setColumns(10);

		textfields[10] = new JTextField();
		textfields[10].setBounds(207, 96, 79, 20);
		panel_2.add(textfields[10]);
		textfields[10].setColumns(10);

		textfields[11] = new JTextField();
		textfields[11].setBounds(296, 96, 65, 20);
		panel_2.add(textfields[11]);
		textfields[11].setColumns(10);

		textfields[12] = new JTextField();
		textfields[12].setBounds(118, 117, 79, 20);
		panel_2.add(textfields[12]);
		textfields[12].setColumns(10);

		textfields[13] = new JTextField();
		textfields[13].setBounds(207, 117, 79, 20);
		panel_2.add(textfields[13]);
		textfields[13].setColumns(10);

		textfields[14] = new JTextField();
		textfields[14].setBounds(296, 117, 65, 20);
		panel_2.add(textfields[14]);
		textfields[14].setColumns(10);

		textfields[15] = new JTextField();
		textfields[15].setBounds(118, 138, 79, 20);
		panel_2.add(textfields[15]);
		textfields[15].setColumns(10);

		textfields[16] = new JTextField();
		textfields[16].setBounds(207, 138, 79, 20);
		panel_2.add(textfields[16]);
		textfields[16].setColumns(10);

		textfields[17] = new JTextField();
		textfields[17].setBounds(296, 138, 65, 20);
		panel_2.add(textfields[17]);
		textfields[17].setColumns(10);
		
		textfields[18] = new JTextField();
		textfields[18].setBounds(118, 159, 79, 20);
		panel_2.add(textfields[18]);
		textfields[18].setColumns(10);

		textfields[19] = new JTextField();
		textfields[19].setBounds(207, 159, 79, 20);
		panel_2.add(textfields[19]);
		textfields[19].setColumns(10);

		textfields[20] = new JTextField();
		textfields[20].setBounds(296, 159, 65, 20);
		panel_2.add(textfields[20]);
		textfields[20].setColumns(10);

		textPanes[0] = new JTextPane();
		textPanes[0].setBounds(403, 33, 98, 20);
		textPanes[0].setEditable(false);
		panel_2.add(textPanes[0]);

		textPanes[1] = new JTextPane();
		textPanes[1].setBounds(403, 54, 98, 20);
		textPanes[1].setEditable(false);
		panel_2.add(textPanes[1]);

		textPanes[2] = new JTextPane();
		textPanes[2].setBounds(403, 75, 98, 20);
		textPanes[2].setEditable(false);
		panel_2.add(textPanes[2]);

		textPanes[3] = new JTextPane();
		textPanes[3].setBounds(403, 96, 98, 20);
		textPanes[3].setEditable(false);
		panel_2.add(textPanes[3]);

		textPanes[4] = new JTextPane();
		textPanes[4].setBounds(403, 117, 98, 20);
		textPanes[4].setEditable(false);
		panel_2.add(textPanes[4]);

		textPanes[5] = new JTextPane();
		textPanes[5].setBounds(403, 138, 98, 20);
		textPanes[5].setEditable(false);
		panel_2.add(textPanes[5]);

		textPanes[6] = new JTextPane();
		textPanes[6].setBounds(403, 159, 98, 20);
		textPanes[6].setEditable(false);
		panel_2.add(textPanes[6]);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnCancel.setBounds(328, 377, 79, 23);
		contentPane.add(btnCancel);

		btnOkey = new JButton("Okey");
		btnOkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int a = 0; a < textfields.length; a += 3) {
					textfields[a].selectAll();
					textfields[a+1].selectAll();
					textfields[a+2].selectAll();
					String x = textfields[a].getSelectedText();
					String y = textfields[a+1].getSelectedText();
					String z = textfields[a+2].getSelectedText();
					calculate(x, y, z);	
				}
			}
		});
		btnOkey.setBounds(215, 377, 79, 23);
		contentPane.add(btnOkey);
	}

	public void calculate(String text, String text1, String text2) {
		double mid = Double.parseDouble(text);
		double fnl = Double.parseDouble(text1);
		double quiz = Double.parseDouble(text2);
		double avarage = mid * 0.3 + fnl * 0.6
				+ quiz * 0.1;
		
	}
}
