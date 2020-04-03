package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 38, 560, 131);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(107, 11, 89, 27);
		panel.add(lblNewLabel);
		
		JLabel lblMidterm = new JLabel("Midterm");
		lblMidterm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMidterm.setBounds(206, 11, 57, 27);
		panel.add(lblMidterm);
		
		JLabel lblQuiz = new JLabel("Quiz");
		lblQuiz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuiz.setBounds(368, 11, 57, 27);
		panel.add(lblQuiz);
		
		JLabel lblFinal = new JLabel("Final");
		lblFinal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFinal.setBounds(286, 11, 57, 27);
		panel.add(lblFinal);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(117, 43, 57, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(206, 43, 57, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(369, 43, 57, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(286, 43, 57, 20);
		panel.add(textField_3);
		
		JButton btnUpdate = new JButton("Add");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(176, 84, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnFetch = new JButton("Fetch");
		btnFetch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFetch.setBounds(283, 84, 89, 23);
		panel.add(btnFetch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 560, 38);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblOgretmenBilgiSistemi = new JLabel("Ogretmen Bilgi Sistemi");
		lblOgretmenBilgiSistemi.setFont(new Font("Verdana", Font.BOLD, 16));
		lblOgretmenBilgiSistemi.setBounds(24, 0, 217, 38);
		panel_2.add(lblOgretmenBilgiSistemi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 168, 560, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(28, 11, 507, 136);
		panel_1.add(table);
		
	}
}
