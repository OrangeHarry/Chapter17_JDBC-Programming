package com.bitcamp.lecture.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bitcamp.lecture.comm.Member;

public class InsertProgram2 {
	// "jdbc:mysql:IP주소:포트번호:DB명";
	static final String URL = "jdbc:mysql://localhost:3306/lecture"; // 뒤에 포트번호를 붙여도 되넹
	static final String ID = "root";
	static final String PW = "dkdlxl";

	public static void main(String[] args) {

		Connection con = null; // 연결하고
		PreparedStatement preStmt = null; 

		//UI쪽 인터페이스를 통해서 CRUD 관련 데이터를 전달 받는다.
		Member member = new Member(); //클래스 import받자!!
		member.setId("Orange29");
		member.setPwd("12345");
		member.setName("테스트용 하헌민");
		member.setGender("M");
		
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysq.라이브러리에 있는 driver 클래스 주소
			// DB연결
			con = DriverManager.getConnection(URL, ID, PW); // url = ip주소
			System.out.println("Successfully Connection!");
			// 쿼리실행

			// 뒤에 values에는 입력 갯수에 맞게 ?로만 표시한다. 
			String sql = "INSERT INTO member(ID,PWD,NAME,GENDER)VALUES(?,?,?,?)";
			
			preStmt = con.prepareStatement(sql);
			preStmt.setString(1, member.getId());
			preStmt.setString(2, member.getPwd());
			preStmt.setString(3, member.getName());
			preStmt.setString(4, member.getGender());

			//PreparedStatement 객체 사용시
			//preStmt.executeUpdate(sql)->(); <--주의!!!
			int cnt = preStmt.executeUpdate();//변수값을 넣어서 실행할 때는 안에 값sql을 넣지 말하야 한다.
			System.out.println("Query OK, " + cnt + "row affected.");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					preStmt.close();
					con.close();
					System.out.println("리소스 해제 완료");
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
