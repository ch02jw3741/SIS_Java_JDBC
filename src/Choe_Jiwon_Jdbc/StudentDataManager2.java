package Choe_Jiwon_Jdbc;

import java.sql.*;
import java.util.ArrayList;

public class StudentDataManager2 {
	//변수 선언
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
    String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "scott";
    String pwd = "tiger";
    Connection conn = null;
    PreparedStatement pstmt = null;
	
	//DB 연결 메소드
	public void JdbcOpen() {
		try {
	      // 드라이버를 로딩
	      Class.forName(jdbc_driver);

	      // 데이터베이스 연결.
	      conn = DriverManager.getConnection(jdbc_url, user, pwd);

	     
	    } catch (ClassNotFoundException e) {
	      System.out.println("JDBC 드라이버를 찾을 수 없습니다.");
	      e.printStackTrace();

	    } catch (SQLException e) {
	      System.out.println("데이터베이스 연결에 실패했습니다.");
	      e.printStackTrace();
	    }
	}
		
	//DB 종료 메소드	
	public void JdbcClose() {  
		try {
	    	  if(!pstmt.isClosed()) {
				  pstmt.close();
	    	  }
	      }
	      catch (SQLException e) {
	    	  e.printStackTrace();
	      }
	      try {
	    	  if (!conn.isClosed()) { 
	        	   conn.close();
	    	  }
	      }
	      catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	
	// 1. 정보 입력
	public void InsertStdData(StudentData2 sd2) {
		//DB 연결 메소드 호출
		JdbcOpen();
		
		// SQL문 작성
		String Insert_Sql = "INSERT INTO STD VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
		
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(Insert_Sql);

			//값 설정
			pstmt.setInt(1, sd2.getStdID());		
			pstmt.setString(2, sd2.getName());
			pstmt.setString(3, sd2.getGender());
			pstmt.setInt(4, sd2.getKorScore());
			pstmt.setInt(5, sd2.getMathScore());
			pstmt.setInt(6, sd2.getEngScore());
			pstmt.setInt(7, sd2.getSciScore());

			// SQL 문을 실행합니다.
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " 명의 학생정보가 입력되었습니다.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//DB 종료 메소드 호출
		finally {
			JdbcClose();
		}
	}

	// 2. 전체 정보 조회    	
	public ArrayList <StudentData2> showAllStdData(){
		JdbcOpen();
		ArrayList <StudentData2> studentList = new ArrayList<>();
	  
       	try {
       		pstmt = conn.prepareStatement("select * from STD");
       		ResultSet rs = pstmt.executeQuery();
       		
       		while(rs.next()) {
       			StudentData2 sd2 = new StudentData2();			// StudentData2 클래스의 디폴트 생성자 사용.
       			
       			sd2.setStdID(rs.getInt("STDNO"));
       			sd2.setName(rs.getString("SNAME"));
       			sd2.setGender(rs.getString("GENDER"));
       			sd2.setKorScore(rs.getInt("KORSCO"));
       			sd2.setMathScore(rs.getInt("MATHSCO"));
       			sd2.setEngScore(rs.getInt("ENGSCO"));
       			sd2.setSciScore(rs.getInt("SCISCO"));
    			
    			studentList.add(sd2);
       		}
       	}
       	catch(Exception e) {
        	e.printStackTrace();
        	}
       	finally {
			JdbcClose();
		}
       	return studentList;
	}
	
	//3. 전체 성적 수정
	public void updateStdData(StudentData2 sd2) {
		JdbcOpen();
		String Update_Sql = "UPDATE STD SET KORSCO = ?, MATHSCO = ?, ENGSCO = ?, SCISCO = ? WHERE STDNO = ?";
		
		try {
			pstmt = conn.prepareStatement(Update_Sql);
			
			pstmt.setInt(1, sd2.getKorScore());
			pstmt.setInt(2, sd2.getMathScore());
			pstmt.setInt(3, sd2.getEngScore());
			pstmt.setInt(4, sd2.getSciScore());
			pstmt.setInt(5, sd2.getStdID());
			
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " 명의 성적이 수정되었습니다.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			JdbcClose();
		}
	}
	
	//4. 특정 학생 정보 삭제
	public void deleteStdData(StudentData2 sd2) {
		JdbcOpen();
		String Delete_Sql = "delete STD WHERE STDNO = ?";
		
		try {
			pstmt = conn.prepareStatement(Delete_Sql);
			
			pstmt.setInt(1, sd2.getStdID());
			
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " 명의 학생정보가 삭제되었습니다.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			JdbcClose();
		}
	}
	

}// 끝!...
