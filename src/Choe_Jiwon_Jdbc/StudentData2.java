package Choe_Jiwon_Jdbc;

public class StudentData2 {
	// private 맴버변수 선언
		private int stdID; 				// 학번
		private String name; 			// 이름
		private String gender; 			// 성별
		private int korScore; 			// 국어점수
		private int mathScore;			// 수학점수
		private int engScore;			// 영어점수
		private int sciScore;			// 과학점수
		

		
		//getter, setter 메소드
		public int getStdID() {
			return stdID;
		}
		public void setStdID(int stdID) {
			this.stdID = stdID;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getKorScore() {
			return korScore;
		}
		public void setKorScore(int korScore) {
			this.korScore = korScore;
		}
		public int getMathScore() {
			return mathScore;
		}
		public void setMathScore(int mathScore) {
			this.mathScore = mathScore;
		}
		public int getEngScore() {
			return engScore;
		}
		public void setEngScore(int engScore) {
			this.engScore = engScore;
		}
		public int getSciScore() {
			return sciScore;
		}
		public void setSciScore(int sciScore) {
			this.sciScore = sciScore;
		}
		
		//toString 메소드
		@Override
		public String toString() {
			return "학번: " + stdID + ", 이름: " + name + ", 성별: " + gender + ", 국어점수: " + korScore
					+ ", 수학점수: " + mathScore + ", 영어점수: " + engScore + ", 과학점수: " + sciScore + "\n";
		}

	}


	// 궁금점 해결:
	// toString().docx 파일 참고.
