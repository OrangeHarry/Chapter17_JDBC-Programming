package com.bitcamp.lecture.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bitcamp.lecture.comm.Member;

public class InsertProgram3 {
	// "jdbc:mysql:IP�ּ�:��Ʈ��ȣ:DB��";
	static final String URL = "jdbc:mysql://localhost:3306/lecture"; // �ڿ� ��Ʈ��ȣ�� �ٿ��� �ǳ�
	static final String ID = "root";
	static final String PW = "dkdlxl";

	public static void main(String[] args) {

		Connection con = null; // �����ϰ�
		PreparedStatement preStmt = null; 

		//UI�� �������̽��� ���ؼ� CRUD ���� �����͸� ���� �޴´�.
		//�����ε��� �����ڷ� �����°�
		Member member1 = new Member("test_id", "4862", "������", "M", "1993-11-26", "010-7254-7761", "hhm12345@naver.com");

		try {
			// ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysq.���̺귯���� �ִ� driver Ŭ���� �ּ�
			// DB����
			con = DriverManager.getConnection(URL, ID, PW); // url = ip�ּ�
			System.out.println("Successfully Connection!");
			// ��������

			// �ڿ� values���� �Է� ������ �°� ?�θ� ǥ���Ѵ�. 
			String sql = "INSERT INTO member(ID,PWD,NAME,GENDER,BIRTHDAY,PHONE,EMAIL)VALUES(?,?,?,?,?,?,?)";
			
			preStmt = con.prepareStatement(sql);
			preStmt.setString(1, member1.getId());
			preStmt.setString(2, member1.getPwd());
			preStmt.setString(3, member1.getName());
			preStmt.setString(4, member1.getGender());
			preStmt.setString(5, member1.getBirthday());
			preStmt.setString(6, member1.getPhone());
			preStmt.setString(7, member1.getEmail());

			//PreparedStatement ��ü ����
			//preStmt.executeUpdate(sql)->(); <--����!!!
			int cnt = preStmt.executeUpdate();//�������� �־ ������ ���� �ȿ� ��sql�� ���� ���Ͼ� �Ѵ�.
			System.out.println("Query OK, " + cnt + "row affected.");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					preStmt.close();
					con.close();
					System.out.println("���ҽ� ���� �Ϸ�");
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
