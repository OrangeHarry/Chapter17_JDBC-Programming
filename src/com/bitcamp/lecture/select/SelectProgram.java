package com.bitcamp.lecture.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectProgram {
	// "jdbc:mysql:IP�ּ�:��Ʈ��ȣ:DB��";
	static final String URL = "jdbc:mysql://221.148.138.87:3306/lecture"; // ������ ��Ű��
	static final String ID = "bitcamp";
	static final String PW = "1234";

	public static void main(String[] args) {

		Connection con = null; // �����ϰ�
		Statement stmt = null; // Ŀ�������� ��ü �����
		ResultSet rs = null; // ��� �޾��ְ�

		try {
			// ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysq.���̺귯���� �ִ� driver Ŭ���� �ּ�
			// DB����
			con = DriverManager.getConnection(URL, ID, PW); // url = ip�ּ�
			System.out.println("Successfully Connection!");
			// ��������
			stmt = con.createStatement();

			String sql = "select * from idol_group";
			rs = stmt.executeQuery(sql); //��ȸ �Ҷ��� ���� �޼ҵ�

			System.out.println("-------------------------------------------------------");
			System.out.println("COMPANY        GROUP_NAME");
			System.out.println("-------------------------------------------------------");

			while (rs.next()) { // rs.next(); == �� ������ �д´�.
				System.out.print(rs.getString("COMPANY") + "\t" + rs.getString("GROUP_NAME") + "\n");
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					rs.close();
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
