package com.bitcamp.lecture.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectProgram {
	// "jdbc:mysql:IP주소:포트번호:DB명";
	static final String URL = "jdbc:mysql://221.148.138.87:3306/lecture"; // 형식을 지키자
	static final String ID = "bitcamp";
	static final String PW = "1234";

	public static void main(String[] args) {

		Connection con = null; // 연결하고
		Statement stmt = null; // 커리실행할 객체 만들고
		ResultSet rs = null; // 결과 받아주고

		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysq.라이브러리에 있는 driver 클래스 주소
			// DB연결
			con = DriverManager.getConnection(URL, ID, PW); // url = ip주소
			System.out.println("Successfully Connection!");
			// 쿼리실행
			stmt = con.createStatement();

			String sql = "select * from idol_group";
			rs = stmt.executeQuery(sql); //조회 할때만 쓰는 메소드

			System.out.println("-------------------------------------------------------");
			System.out.println("COMPANY        GROUP_NAME");
			System.out.println("-------------------------------------------------------");

			while (rs.next()) { // rs.next(); == 행 한줄을 읽는다.
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
					System.out.println("리소스 해제 완료");
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
