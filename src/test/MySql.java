package test;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MySql {
	private static String url = "jdbc:mysql://localhost:3306/proje?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
	private static String name = "root";
	private static String password = "qwert1234";
	protected static String usr;
	protected static String psw;
	protected static String id = null;
	public static boolean listSelection = false;
	public static String who = null;

	public static boolean checkAccount(String usr, String psw) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, name, password); 
			stm = con.createStatement(); 
			rs = stm.executeQuery("select * from " + who + ";"); 

			String id = null, pass = null, name = null, surname = null;

			while (rs.next()) {
				if(usr.equals(rs.getString("id"))) {
					id = rs.getString("id");
					name = rs.getString("name");
					surname = rs.getString("surname");
					pass = rs.getString("pass");
				}
			}
			if (usr.equals(id) && pass.equals(psw)) {
				JOptionPane.showMessageDialog(null, "Welcome " + name + " " + surname, "", JOptionPane.INFORMATION_MESSAGE);
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "User name or Password is not true!", "",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return false;
	}

	public static void findStu(String stId) {
		boolean success = false;
		Connection con = null;
		Statement stm = null;
		try {
			con = DriverManager.getConnection(url, name, password);
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from students;");
			String name = null, surname = null;

			while (rs.next()) {
				if (stId.equals(rs.getString("id"))) {
					success = true;
					id = rs.getString("id");
					name = rs.getString("name");
					surname = rs.getString("surname");
				}
			}
			if (success) {
				if (listSelection) {
					prof.textField.setText(id);
					prof.textField_1.setText(name.toUpperCase());
					prof.textField_2.setText(surname.toUpperCase());
					listSelection = false;
					prof.isStudent = true;
					showNotesOnTable(id);
				} else {
					JOptionPane.showMessageDialog(null, "Student is found");
					prof.textField.setText(id);
					prof.textField_1.setText(name.toUpperCase());
					prof.textField_2.setText(surname.toUpperCase());
					prof.isStudent = true;
					showNotesOnTable(id);
				}
			} else {
				int n = JOptionPane.showConfirmDialog(null, "Student could not found! Do you want to add?");
				prof.textField_1.setText("");
				prof.textField_2.setText("");
				if (n == 0 && prof.textField_1.getText().equals("") && prof.textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter student name and surname!");
				} else if (n == 0) {
					addStudent();
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void delete() {
		Connection con = null;
		Statement stm = null;
		try {
			con = DriverManager.getConnection(url, name, password);
			stm = con.createStatement();
			boolean rs = stm.execute("delete from students where id = " + id + ";");
			JOptionPane.showMessageDialog(null, "Deleting is succesful");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void addStudent() {
		Connection con = null;
		Statement stm = null;
		try {
			con = DriverManager.getConnection(url, name, password);
			stm = con.createStatement();
			prof.textField.selectAll();
			id = prof.textField.getSelectedText();
			prof.textField_1.selectAll();
			String name = prof.textField_1.getText().toUpperCase();
			prof.textField_2.selectAll();
			String surname = prof.textField_2.getText().toUpperCase();
			boolean add = stm.execute("insert into students (id,name,surname,pass) values(\"" + id + "\",\"" + name
					+ "\",\"" + surname + "\",\"" + id + "\");");
			JOptionPane.showMessageDialog(null, "Assigning is successful!");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void setArrayList() {
		Connection con = null;
		Statement stm = null;
		try {
			con = DriverManager.getConnection(url, name, password);
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from students;");
			String id = null, pass = null, name = null, surname = null;
			prof.studentList.clear();
			while (rs.next()) {
				id = rs.getString("id");
				name = rs.getString("name");
				surname = rs.getString("surname");
				String list = id + " - " + name + " " + surname;
				prof.studentList.add(list);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void setGrades(double mid, double fnl, double quiz) {
		Connection con = null;
		Statement stm = null;
		try {
			con = DriverManager.getConnection(url, name, password);
			stm = con.createStatement();
			double grades = mid * 0.3 + fnl * 0.6 + quiz * 0.1;
			boolean add = stm.execute("UPDATE students SET midterm = " + mid + " , final =" + fnl + " , quiz =" + quiz
					+ " , grade =" + grades + " where id = \"" + id + "\" ;");
			JOptionPane.showMessageDialog(null, "Grades are saved!");
			showNotesOnTable(id);
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void showNotesOnTable(String id) {
		Connection con = null;
		Statement stm = null;
		try {
			con = DriverManager.getConnection(url, name, password);
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from students where id = \"" + id + "\";");
			String stuId = null, name = null, surname = null;
			double mid = 0, fnl = 0, quiz = 0, grades = 0;
			prof.studentList.clear();
			while (rs.next()) {
				stuId = rs.getString("id");
				name = rs.getString("name");
				surname = rs.getString("surname");
				mid = rs.getDouble("midterm");
				fnl = rs.getDouble("final");
				quiz = rs.getDouble("quiz");
				grades = rs.getDouble("grade");
			}
			prof.setTable(stuId, name, surname, mid, fnl, quiz, grades);

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void setOop() {
		Connection con = null;
		Statement stm = null;
		try {
			con = DriverManager.getConnection(url, name, password);
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from students where id = \"" + Entry.usr + "\";");

			String stuId = null, name = null, surname = null;
			double mid = 0, fnl = 0, quiz = 0;
			while (rs.next()) {
				stuId = rs.getString("id");
				name = rs.getString("name");
				surname = rs.getString("surname");
				mid = rs.getDouble("midterm");
				fnl = rs.getDouble("final");
				quiz = rs.getDouble("quiz");
			}
			Student.textPane.setText(stuId);
			Student.textPane_1.setText(name);
			Student.textPane_2.setText(surname);
			Student.rdmGrades[18] = (int)mid;
			Student.rdmGrades[19] = (int)fnl;
			Student.rdmGrades[20] = (int)quiz;
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static double gca() {
		Connection con = null;
		Statement stm = null;
		double avarage = 0;
		try {
			con = DriverManager.getConnection(url, name, password);
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select grade from students;");

			int count = 0;
			while (rs.next()) {
				avarage += rs.getDouble("grade");
				count++;
			}
			avarage = avarage / count;
			return avarage;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return avarage;
	}
}
