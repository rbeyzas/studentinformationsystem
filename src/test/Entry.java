package test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ClientInfoStatus;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Entry extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField pass;
	private JTextPane usrLabel, passLabel;
	private JButton btnEnter, btnCancel;
	public static String usr, psw;
	public static boolean student = false, prf = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entry frame = new Entry();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Entry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 100, 603, 452);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#81A3A7"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel logo = new JLabel();
		logo.setBounds(0, 0, 619, 115);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon("./img/atu_logo_tr_2019.png"));
		contentPane.add(logo);

		JTextPane schollName = new JTextPane();
		schollName.setFont(new Font("Verdana", Font.BOLD, 15));
		schollName.setBackground(Color.decode("#81A3A7"));
		schollName.setEditable(false);
		schollName.setText("ADANA ALPARSLAN TURKES UNIVERSITY");
		schollName.setBounds(120, 126, 361, 35);
		contentPane.add(schollName);
		

		JTextPane grd = new JTextPane();
		grd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		grd.setBackground(Color.decode("#81A3A7"));
		grd.setText("GRADE SYSTEM");
		grd.setBounds(242, 172, 125, 20);
		grd.setEditable(false);
		contentPane.add(grd);

		JButton btnStudent = new JButton("STUDENT\r\n");
		btnStudent.setBackground(Color.decode("#AFBADC"));
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userName.setVisible(true);
				pass.setVisible(true);
				usrLabel.setVisible(true);
				passLabel.setVisible(true);
				btnEnter.setVisible(true);
				btnCancel.setVisible(true);
				student = true;
				prf = false ;
			}
		});
		btnStudent.setBounds(145, 235, 125, 46);
		contentPane.add(btnStudent);

		JButton btnProfessor = new JButton("PROFESSOR");
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName.setVisible(true);
				pass.setVisible(true);
				usrLabel.setVisible(true);
				passLabel.setVisible(true);
				btnEnter.setVisible(true);
				btnCancel.setVisible(true);
				prf = true;
				student = false ;
			}
		});
		btnProfessor.setBounds(326, 235, 125, 46);
		btnProfessor.setBackground(Color.decode("#AFBADC"));
		contentPane.add(btnProfessor);

		usrLabel = new JTextPane();
		usrLabel.setText("USER NAME :");
		usrLabel.setBounds(43, 313, 84, 20);
		usrLabel.setBackground(Color.decode("#81A3A7"));
		usrLabel.setVisible(false);
		usrLabel.setEditable(false);
		contentPane.add(usrLabel);

		passLabel = new JTextPane();
		passLabel.setText("PASSWORD :");
		passLabel.setBounds(43, 344, 84, 20);
		passLabel.setBackground(Color.decode("#81A3A7"));
		passLabel.setVisible(false);
		passLabel.setEditable(false);
		contentPane.add(passLabel);

		userName = new JTextField();
		userName.setBounds(145, 313, 306, 20);
		userName.setBackground(Color.decode("#F1F3F2"));
		userName.setColumns(10);
		userName.setVisible(false);
		contentPane.add(userName);

		pass = new JPasswordField();
		pass.setBounds(145, 344, 306, 20);
		pass.setBackground(Color.decode("#F1F3F2"));
		pass.setColumns(10);
		pass.setVisible(false);
		contentPane.add(pass);

		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (prf) {
					userName.selectAll();
					usr = userName.getSelectedText();
					pass.selectAll();
					psw = pass.getSelectedText();
					MySql.who = "prof";
					if (MySql.checkAccount(usr, psw)) {
						dispose();
						prof.start();

					}
				}
				if (student) {
					userName.selectAll();
					usr = userName.getSelectedText();
					pass.selectAll();
					psw = pass.getSelectedText();
					MySql.who = "students";
					if (MySql.checkAccount(usr, psw)) {
						Student.start();
						dispose();

					}
				}
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEnter.setBackground(Color.decode("#F1F3F2"));
		btnEnter.setBounds(242, 379, 67, 23);
		btnEnter.setVisible(false);
		contentPane.add(btnEnter);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userName.setText("");
				pass.setText("");
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCancel.setBackground(Color.decode("#F1F3F2"));
		btnCancel.setBounds(326, 379, 72, 23);
		btnCancel.setVisible(false);
		contentPane.add(btnCancel);

	}
}
