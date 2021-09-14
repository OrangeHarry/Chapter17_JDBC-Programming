package com.bitcamp.lecture.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProgram {
	// "jdbc:mysql:IP주소:포트번호:DB명";
	static final String URL = "jdbc:mysql://127.0.0.1:3306/lecture"; // 형식을 지키자
	static final String ID = "bitcamp";
	static final String PW = "1234";

	public static void main(String[] args) {

		Connection con = null; // 연결하고
		Statement stmt = null; // 커리실행할 객체 만들고

		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysq.라이브러리에 있는 driver 클래스 주소
			// DB연결
			con = DriverManager.getConnection(URL, ID, PW); // url = ip주소
			System.out.println("Successfully Connection!");
			// 쿼리실행
			stmt = con.createStatement();

			// 이클립스에서 insert할때는 최대한 간결해보이게 작성한다.
			String sql = "INSERT INTO member(ID,PWD,NAME,GENDER)VALUES('AAAAA7','77777','TESTER07','M')";

			int cnt = stmt.executeUpdate(sql); // 조회(select)를 제외한 나머지 모든 메소드들은 이 update메소드를 사용한다.//행의 수가 리턴이 된다.
			System.out.println("Query OK, " + cnt + "row affected.");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
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
