package com.bitcamp.lecture.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bitcamp.lecture.comm.Notice;

public class UpdateProgram {
	// "jdbc:mysql:IP주소:포트번호:DB명";
	static final String URL = "jdbc:mysql://localhost:3306/lecture"; 
	static final String ID = "root";
	static final String PW = "dkdlxl";

	public static void main(String[] args) {

		Connection con = null; // 연결하고
		PreparedStatement preStmt = null; 

		//UI쪽 인터페이스를 통해서 CRUD 관련 데이터를 전달 받는다.
		Notice notice = new Notice();
		notice.setId(18);
		notice.setTitle("테스트용 바꾸기(update)");
		notice.setWriterId("하헌민");
		
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysq.라이브러리에 있는 driver 클래스 주소
			// DB연결
			con = DriverManager.getConnection(URL, ID, PW); // url = ip주소
			System.out.println("Successfully Connection!");
			// 쿼리실행

			// 뒤에 values에는 입력 갯수에 맞게 ?로만 표시한다. 
			String sql = "UPDATE notice SET TITLE = ?, WRITER_ID = ? WHERE ID = ?";	//그냥 워크벤스 가서 형식 확인해서 긁어오쟈
		
			preStmt = con.prepareStatement(sql);
			preStmt.setString(1, notice.getTitle());
			preStmt.setString(2, notice.getWriterId());
			preStmt.setInt(3, notice.getId());

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
