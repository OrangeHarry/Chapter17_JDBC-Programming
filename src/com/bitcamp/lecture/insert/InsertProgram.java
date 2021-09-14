package com.bitcamp.lecture.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProgram {
	// "jdbc:mysql:IP�ּ�:��Ʈ��ȣ:DB��";
	static final String URL = "jdbc:mysql://127.0.0.1:3306/lecture"; // ������ ��Ű��
	static final String ID = "bitcamp";
	static final String PW = "1234";

	public static void main(String[] args) {

		Connection con = null; // �����ϰ�
		Statement stmt = null; // Ŀ�������� ��ü �����

		try {
			// ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysq.���̺귯���� �ִ� driver Ŭ���� �ּ�
			// DB����
			con = DriverManager.getConnection(URL, ID, PW); // url = ip�ּ�
			System.out.println("Successfully Connection!");
			// ��������
			stmt = con.createStatement();

			// ��Ŭ�������� insert�Ҷ��� �ִ��� �����غ��̰� �ۼ��Ѵ�.
			String sql = "INSERT INTO member(ID,PWD,NAME,GENDER)VALUES('AAAAA7','77777','TESTER07','M')";

			int cnt = stmt.executeUpdate(sql); // ��ȸ(select)�� ������ ������ ��� �޼ҵ���� �� update�޼ҵ带 ����Ѵ�.//���� ���� ������ �ȴ�.
			System.out.println("Query OK, " + cnt + "row affected.");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					stmt.close();
					con.close();
					System.out.println("���ҽ� ���� �Ϸ�");
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
