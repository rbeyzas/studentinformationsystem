package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
import org.w3c.dom.events.MouseEvent;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.AbstractListModel;

public class prof extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTable table;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public static ArrayList<String> studentList;
	public static JList list;
	public static boolean isStudent = false;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public prof() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 739, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.decode("#81A3A7"));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField("");
		textField.setBounds(152, 139, 120, 20);
		textField.setBackground(Color.decode("#F1F3F2"));
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblStudentId = new JLabel("Student Id            :");
		lblStudentId.setBounds(10, 139, 120, 20);
		contentPane.add(lblStudentId);

		JLabel lblStudentSurname = new JLabel("Student Surname : ");
		lblStudentSurname.setBounds(10, 201, 120, 20);
		contentPane.add(lblStudentSurname);

		textField_1 = new JTextField("");
		textField_1.setBounds(152, 170, 120, 20);
		textField_1.setBackground(Color.decode("#F1F3F2"));
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblStudentName = new JLabel("Student Name      :");
		lblStudentName.setBounds(10, 170, 120, 20);
		contentPane.add(lblStudentName);

		textField_2 = new JTextField("");
		textField_2.setBounds(152, 201, 120, 20);
		textField_2.setBackground(Color.decode("#F1F3F2"));
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		studentList = new ArrayList<String>();
		MySql.setArrayList();
		String[] values = new String[studentList.size()];
		for (int i = 0; studentList.size() > i; i++) {
			values[i] = studentList.get(i);
		}

		list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list.setBackground(Color.decode("#F1F3F2"));
		list.setModel(new AbstractListModel() {

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(518, 40, 195, 352);
		contentPane.add(scroll);

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				MySql.listSelection = true;
				String word = list.getSelectedValue().toString();
				String[] parts = word.split(" ");
				MySql.findStu(parts[0]);
			}
		});
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySql.findStu(textField.getText());
			}
		});
		btnFindStudent.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFindStudent.setBounds(296, 138, 100, 23);
		btnFindStudent.setBackground(Color.decode("#F1F3F2"));
		contentPane.add(btnFindStudent);

		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You missed id number!");
				else if (textField_1.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You missed name!");
				else if (textField_2.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You missed surname!");
				else {
					MySql.addStudent();
					setStudent();
				}
			}
		});
		btnNewButton.setBounds(296, 169, 100, 23);
		btnNewButton.setBackground(Color.decode("#F1F3F2"));
		contentPane.add(btnNewButton);

		JLabel lblTeacherInformationPanel = new JLabel("Teacher Information Panel");
		lblTeacherInformationPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherInformationPanel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTeacherInformationPanel.setBounds(152, 40, 343, 43);
		contentPane.add(lblTeacherInformationPanel);

		table = new JTable();
		table.setBackground(Color.decode("#F1F3F2"));
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Student Id", "Student Name", "Student Surname", "Midterm Exam", "Final Exam",
						"Quiz", "Grade" }, { null, null, null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column",
						"New column" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(84);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(44);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(62);
		table.setRowHeight(28);
		table.setBounds(10, 337, 498, 55);
		contentPane.add(table);

		textField_3 = new JTextField();
		textField_3.setBounds(152, 244, 120, 20);
		textField_3.setBackground(Color.decode("#F1F3F2"));
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(152, 275, 120, 20);
		textField_4.setBackground(Color.decode("#F1F3F2"));
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(152, 306, 120, 20);
		textField_5.setBackground(Color.decode("#F1F3F2"));
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblMidterm = new JLabel("Midterm                :");
		lblMidterm.setBounds(10, 244, 120, 20);
		contentPane.add(lblMidterm);

		JLabel lblFinal = new JLabel("Final                     :");
		lblFinal.setBounds(10, 275, 120, 20);
		contentPane.add(lblFinal);

		JLabel lblQuiz = new JLabel("Quiz                     :");
		lblQuiz.setBounds(10, 306, 120, 20);
		contentPane.add(lblQuiz);

		JButton btnSaveGrades = new JButton("Save Grades");
		btnSaveGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.selectAll();
				textField_3.selectAll();
				textField_4.selectAll();
				textField_5.selectAll();
				if (textField.getSelectedText() == null) {
					JOptionPane.showMessageDialog(null, "You have to enter student id!");
				} else {
					MySql.findStu(textField.getSelectedText());
					if (isStudent) {
						if (textField_3.getSelectedText() == null)
							JOptionPane.showMessageDialog(null, "You have to enter a value to midterm!");
						else if (textField_4.getSelectedText() == null)
							JOptionPane.showMessageDialog(null, "You have to enter a value to final!");
						else if (textField_5.getSelectedText() == null)
							JOptionPane.showMessageDialog(null, "You have to enter a value to quiz!");
						else {
							double midterm = Double.parseDouble(textField_3.getSelectedText());
							double fnl = Double.parseDouble(textField_4.getSelectedText());
							double quiz = Double.parseDouble(textField_5.getSelectedText());
							MySql.setGrades(midterm, fnl, quiz);
						}
					}
				}
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);

			}

		});
		btnSaveGrades.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSaveGrades.setBounds(296, 303, 100, 23);
		btnSaveGrades.setBackground(Color.decode("#F1F3F2"));
		contentPane.add(btnSaveGrades);

		JLabel label = new JLabel();
		label.setBounds(10, 11, 120, 117);
		label.setIcon(new ImageIcon("./img/atu_logo_tr_2019.png"));
		contentPane.add(label);

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySql.delete();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				setStudent();
			}
		});
		btnDeleteStudent.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDeleteStudent.setBounds(296, 201, 100, 23);
		btnDeleteStudent.setBackground(Color.decode("#F1F3F2"));
		contentPane.add(btnDeleteStudent);

	}

	public static void setStudent() {
		MySql.setArrayList();
		String[] values = new String[studentList.size()];
		for (int i = 0; studentList.size() > i; i++) {
			values[i] = studentList.get(i);
		}
		list.setModel(new AbstractListModel() {

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}

	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prof frame = new prof();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void setTable(String stuId, String name, String surname, double mid, double fnl, double quiz,
			double grade) {
		String grd = "";
		if (grade <= 100 && grade >= 90) {
			grd = grade + " (AA)";
		} else if (grade <= 89 && grade >= 85) {
			grd = grade + " (BA)";
		} else if (grade <= 84 && grade >= 80) {
			grd = grade + " (BB)";
		} else if (grade <= 79 && grade >= 75) {
			grd = grade + " (CB)";
		} else if (grade <= 74 && grade >= 70) {
			grd = grade + " (CC)";
		} else if (grade <= 69 && grade >= 65) {
			grd = grade + " (DC)";
		} else if (grade <= 64 && grade >= 60) {
			grd = grade + " (DD)";
		} else if (grade <= 59 && grade >= 50) {
			grd = grade + "(FD)";
		} else {
			grd = grade + " (FF)";
		}
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Student Id", "Student Name", "Student Surname", "Midterm Exam", "Final Exam",
						"Quiz", "Grade" }, { stuId, name, surname, mid, fnl, quiz, grd }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column",
						"New column" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}
}
