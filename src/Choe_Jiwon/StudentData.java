package Choe_Jiwon;

public class StudentData {
	
	private int stdID; 				// 학번
	private String name; 			// 이름
	private String gender; 			// 성별
	private int korScore; 			// 국어점수
	private int mathScore;			// 수학점수
	private int engScore;			// 영어점수
	private int sciScore;			// 과학점수
	
	//생성자
	
	public StudentData (int stdID, String name, String gender, int korScore, int mathScore, int engScore, int sciScore) {
		this.stdID= stdID;
		this.name = name;
		this.gender = gender; 
		this.korScore = korScore;
		this.mathScore = mathScore;
		this.engScore = engScore;
		this.sciScore = sciScore;
	}

	public int getStdID() {
		return this.stdID;
	}
	public void getStdID(int stdID) {
		this.stdID = stdID;
	}
	public String getName() {
		return this.name;
	}
	public void getName(String name) {
		this.name = name;
	}
	public String getGender() {
		return this.gender;
	}
	public void getGender(String gender) {
		this.gender = gender;
	}
	public int getKorScore() {
		return this.korScore;
	}
	public void getKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getMathScore() {
		return this.mathScore;
	}
	public void getMathScore(int math) {
		this.mathScore = math;
	}
	public int getEngScore() {
		return this.engScore;
	}
	public void getEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getSciScore() {
		return this.sciScore;
	}
	public void getSciScore(int sciScore) {
		this.sciScore = sciScore;
	}

}
