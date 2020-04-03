package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static int[] rdmGrades;
	public static JTextPane txtpnStudentName, textPane, textPane_1, textPane_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(330, 100, 745, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.decode("#81A3A7"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblResim = new JLabel("");
		lblResim.setIcon(new ImageIcon("./img/ögrenci.jpg"));
		lblResim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResim.setForeground(Color.BLACK);
		lblResim.setBackground(Color.CYAN);
		lblResim.setBounds(10, 87, 127, 131);
		contentPane.add(lblResim);

		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#81A3A7"));
		panel.setBounds(147, 87, 551, 131);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextPane txtpnStudentId = new JTextPane();
		txtpnStudentId.setBackground(Color.LIGHT_GRAY);
		txtpnStudentId.setText("Student Id              :");
		txtpnStudentId.setBounds(20, 24, 113, 20);
		panel.add(txtpnStudentId);
		txtpnStudentId.setEditable(false);

		txtpnStudentName = new JTextPane();
		txtpnStudentName.setBackground(Color.LIGHT_GRAY);
		txtpnStudentName.setText("Student Name      :");
		txtpnStudentName.setBounds(20, 55, 113, 20);
		panel.add(txtpnStudentName);
		txtpnStudentName.setEditable(false);

		JTextPane txtpnStudentSurname = new JTextPane();
		txtpnStudentSurname.setBackground(Color.LIGHT_GRAY);
		txtpnStudentSurname.setText("Student Surname :");
		txtpnStudentSurname.setBounds(20, 86, 113, 20);
		panel.add(txtpnStudentSurname);
		txtpnStudentSurname.setEditable(false);

		textPane = new JTextPane();
		textPane.setBackground(Color.decode("#F1F3F2"));
		textPane.setBounds(143, 24, 122, 20);
		panel.add(textPane);

		textPane_1 = new JTextPane();
		textPane_1.setBackground(Color.decode("#F1F3F2"));
		textPane_1.setBounds(143, 55, 122, 20);
		panel.add(textPane_1);

		textPane_2 = new JTextPane();
		textPane_2.setBackground(Color.decode("#F1F3F2"));
		textPane_2.setBounds(143, 86, 122, 20);
		panel.add(textPane_2);

		JTextPane txtpnGga = new JTextPane();
		txtpnGga.setBackground(Color.LIGHT_GRAY);
		txtpnGga.setText("G.G.A        :");
		txtpnGga.setBounds(303, 24, 83, 20);
		panel.add(txtpnGga);
		txtpnGga.setEditable(false);

		JTextPane txtpnGca = new JTextPane();
		txtpnGca.setBackground(Color.LIGHT_GRAY);
		txtpnGca.setText("G.C.A        :");
		txtpnGca.setBounds(303, 55, 83, 20);
		panel.add(txtpnGca);
		txtpnGca.setEditable(false);

		JTextPane txtpnAdvisor = new JTextPane();
		txtpnAdvisor.setBackground(Color.LIGHT_GRAY);
		txtpnAdvisor.setText("Advisor     :");
		txtpnAdvisor.setBounds(303, 86, 83, 20);
		panel.add(txtpnAdvisor);
		txtpnAdvisor.setEditable(false);

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBackground(Color.decode("#F1F3F2"));
		textPane_3.setBounds(396, 24, 122, 20);
		panel.add(textPane_3);

		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBackground(Color.decode("#F1F3F2"));
		textPane_4.setBounds(396, 55, 122, 20);
		panel.add(textPane_4);

		JTextPane txtpnFatihKl = new JTextPane();
		txtpnFatihKl.setBackground(Color.decode("#F1F3F2"));
		txtpnFatihKl.setText("Dr.Lt.Fatih KILI\u00C7");
		txtpnFatihKl.setBounds(396, 86, 122, 20);
		panel.add(txtpnFatihKl);

		JLabel label = new JLabel();
		label.setBounds(10, 11, 60, 60);
		label.setIcon(new ImageIcon("./img/atu.png"));
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("Student Information Panel");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 19));
		lblNewLabel.setBounds(189, 11, 520, 60);
		contentPane.add(lblNewLabel);

		rdmGrades = new int[21];

		MySql.setOop();

		table = new JTable();
		table.setBackground(Color.decode("#F1F3F2"));
		for (int i = 0; i < rdmGrades.length - 3; i++) {
			rdmGrades[i] = (int)(Math.random() * 100);

		}
		double grade = rdmGrades[18] * 0.3 + rdmGrades[19] * 0.6 + rdmGrades[20] * 0.1;
		double grade1 = rdmGrades[0] * 0.3 + rdmGrades[1] * 0.6 + rdmGrades[2] * 0.1;
		double grade2 = rdmGrades[3] * 0.3 + rdmGrades[4] * 0.6 + rdmGrades[5] * 0.1;
		double grade3 = rdmGrades[6] * 0.3 + rdmGrades[7] * 0.6 + rdmGrades[8] * 0.1;
		double grade4 = rdmGrades[9] * 0.3 + rdmGrades[10] * 0.6 + rdmGrades[11] * 0.1;
		double grade5 = rdmGrades[12] * 0.3 + rdmGrades[13] * 0.6 + rdmGrades[14] * 0.1;
		double grade6 = rdmGrades[15] * 0.3 + rdmGrades[16] * 0.6 + rdmGrades[17] * 0.1;
		String grd, grd1, grd2, grd3, grd4, grd5, grd6;
		if (grade <= 100 && grade >= 90) {
			grd = grade + " (AA)";
			grd1 = grade1 + " (AA)";
			grd2 = grade2 + " (AA)";
			grd3 = grade3 + " (AA)";
			grd4 = grade4 + " (AA)";
			grd5 = grade5 + " (AA)";
			grd6 = grade6 + " (AA)";
		} else if (grade <= 89 && grade >= 85) {
			grd = grade + " (BA)";
			grd1 = grade1 + " (BA)";
			grd2 = grade2 + " (BA)";
			grd3 = grade3 + " (BA)";
			grd4 = grade4 + " (BA)";
			grd5 = grade5 + " (BA)";
			grd6 = grade6 + " (BA)";
		} else if (grade <= 84 && grade >= 80) {
			grd = grade + " (BB)";
			grd1 = grade1 + " (BB)";
			grd2 = grade2 + " (BB)";
			grd3 = grade3 + " (BB)";
			grd4 = grade4 + " (BB)";
			grd5 = grade5 + " (BB)";
			grd6 = grade6 + " (BB)";
		} else if (grade <= 79 && grade >= 75) {
			grd = grade + " (CB)";
			grd1 = grade1 + " (CB)";
			grd2 = grade2 + " (CB)";
			grd3 = grade3 + " (CB)";
			grd4 = grade4 + " (CB)";
			grd5 = grade5 + " (CB)";
			grd6 = grade6 + " (CB)";
		} else if (grade <= 74 && grade >= 70) {
			grd = grade + " (CC)";
			grd1 = grade1 + " (CC)";
			grd2 = grade2 + " (CC)";
			grd3 = grade3 + " (CC)";
			grd4 = grade4 + " (CC)";
			grd5 = grade5 + " (CC)";
			grd6 = grade6 + " (CC)";
		} else if (grade <= 69 && grade >= 65) {
			grd = grade + " (DC)";
			grd1 = grade1 + " (DC)";
			grd2 = grade2 + " (DC)";
			grd3 = grade3 + " (DC)";
			grd4 = grade4 + " (DC)";
			grd5 = grade5 + " (DC)";
			grd6 = grade6 + " (DC)";
		} else if (grade <= 64 && grade >= 60) {
			grd = grade + " (DD)";
			grd1 = grade1 + " (DD)";
			grd2 = grade2 + " (DD)";
			grd3 = grade3 + " (DD)";
			grd4 = grade4 + " (DD)";
			grd5 = grade5 + " (DD)";
			grd6 = grade6 + " (DD)";
		} else if (grade <= 59 && grade >= 50) {
			grd = grade + "(FD)";
			grd1 = grade1 + "(FD)";
			grd2 = grade2 + "(FD)";
			grd3 = grade3 + "(FD)";
			grd4 = grade4 + "(FD)";
			grd5 = grade5 + "(FD)";
			grd6 = grade6 + "(FD)";
		} else {
			grd = grade1 + " (FF)";
			grd1 = grade2 + " (FF)";
			grd2 = grade3 + " (FF)";
			grd3 = grade4 + " (FF)";
			grd4 = grade5 + " (FF)";
			grd5 = grade6 + " (FF)";
			grd6 = grade6 + " (FF)";
		}

		table.setModel(
				new DefaultTableModel(
			new Object[][] {
				{"Lessons", "Midterm Exam", "Final Exam", "Quiz", "Grades"},
				{"OOP", rdmGrades[18],rdmGrades[19] , rdmGrades[20], grd},
				{"Discrete Mathematics", rdmGrades[0],rdmGrades[1], rdmGrades[2], grd1},
				{"Calculus", rdmGrades[3], rdmGrades[4], rdmGrades[5], grd2},
				{"Physics", rdmGrades[6], rdmGrades[7], rdmGrades[8], grd3},
				{"English", rdmGrades[9], rdmGrades[10], rdmGrades[11], grd4},
				{"History", rdmGrades[12], rdmGrades[13], rdmGrades[14], grd5},
				{"Literature", rdmGrades[15], rdmGrades[16], rdmGrades[17],grd6},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(73);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(73);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(73);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(73);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(87);
		
		table.setBounds(10, 250, 710, 152);
		table.setRowHeight(19);
		contentPane.add(table);

		double gno1 = (grade1) * 5;
		double gno2 = (grade2) * 7;
		double gno3 = (grade3) * 7;
		double gno4 = (grade4) * 2;
		double gno5 = (grade) * 6;
		double gno = (gno1 + gno2 + gno3 + gno4 + gno5) / 27;

		textPane_3.setText("" + gno / 25);
		textPane_4.setText("" + MySql.gca()/24);

	}

	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}