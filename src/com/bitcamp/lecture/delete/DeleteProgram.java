package com.bitcamp.lecture.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bitcamp.lecture.comm.Notice;

public class DeleteProgram {
	// "jdbc:mysql:IP�ּ�:��Ʈ��ȣ:DB��";
	static final String URL = "jdbc:mysql://localhost:3306/lecture"; 
	static final String ID = "root";
	static final String PW = "dkdlxl";

	public static void main(String[] args) {

		Connection con = null; // �����ϰ�
		PreparedStatement preStmt = null; 

		//UI�� �������̽��� ���ؼ� CRUD ���� �����͸� ���� �޴´�.
		Notice notice = new Notice();
		notice.setId(21);
		
		try {
			// ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysq.���̺귯���� �ִ� driver Ŭ���� �ּ�
			// DB����
			con = DriverManager.getConnection(URL, ID, PW); // url = ip�ּ�
			System.out.println("Successfully Connection!");
			// ��������

			// �ڿ� values���� �Է� ������ �°� ?�θ� ǥ���Ѵ�. 
			String sql = "DELETE FROM notice WHERE ID = ?";	//�׳� ��ũ���� ���� ���� Ȯ���ؼ� �ܾ����
		
			preStmt = con.prepareStatement(sql);
			preStmt.setInt(1, notice.getId());

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
