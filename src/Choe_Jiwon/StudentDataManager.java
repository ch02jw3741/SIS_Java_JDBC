package Choe_Jiwon;

import java.util.*;

public class StudentDataManager {
	
	StudentData student;
    ArrayList <StudentData> studentList = new ArrayList<>();

    private int stdID, korScore, mathScore, engScore, sciScore;
    private String name, gender;
   
    Scanner sc = new Scanner(System.in);

 // 중복 검사
    public boolean isDuplicate(int stdID, ArrayList<StudentData> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStdID() == stdID) {
                return true;
            }
        }
        return false;
    }

    // 1. 정보 입력
    void inputStdData() {
        boolean isDuplicate = true;
        while (isDuplicate) {  
            System.out.print("학번을 입력하세요: ");			
            stdID = sc.nextInt();
            isDuplicate = isDuplicate(stdID, studentList); // 학번이 중복되는지 검사
            if (isDuplicate) {
                System.out.println("이미 존재하는 학번입니다. 다시 입력해주세요.");
            } else {
                break;  // 중복이 아닌 경우 while 루프를 빠져나옴
            }
        }
        
        // 학번이 중복되지 않았을 때 실행되는 코드
        System.out.print("이름을 입력하세요: ");
        name = sc.next();

        System.out.print("성별을 입력하세요: ");
        gender = sc.next();

        System.out.print("국어점수 입력: ");
        korScore = sc.nextInt();

        System.out.print("수학점수 입력: ");
        mathScore = sc.nextInt();

        System.out.print("영어점수 입력: ");
        engScore = sc.nextInt();
                    
        System.out.print("과학점수 입력: ");
        sciScore = sc.nextInt();
                    
        student = new StudentData(stdID, name, gender, korScore, mathScore, engScore, sciScore);
        studentList.add(student);	
    }
    	
//		2. 정보 조회    	
    	void showAllStdData(){
    		System.out.println(" * * * 학생 성적 관리 프로그램 * * * ");
       	 	System.out.printf("   학번\t 이름\t성별\t국어점수\t수학점수\t영어점수\t과학점수\n ");
       	 	System.out.println("=====================================================");
            
       	 	for (int i = 0; i < studentList.size(); i++) {
       	 		System.out.printf("%5d\t%5s\t%5s\t%5d\t%5d\t%5d\t%5d\n" , studentList.get(i).getStdID() , studentList.get(i).getName() ,studentList.get(i).getGender(), 
                studentList.get(i).getKorScore(), studentList.get(i).getMathScore(), studentList.get(i).getEngScore(), studentList.get(i).getSciScore());
       	 	}
        }
//		3. 정보 수정    	
    	void scoreModify() {
    		int modStuID;
    		int choice;
    		
        	System.out.println("성적을 수정할 학생의 학번을 입력하세요: ");	// 타정보는 중복 가능성이 있기 때문에 학번으로 검색하기로 결정!
        	
        	modStuID = sc.nextInt();
        	
        	for (int i = 0; i < studentList.size(); i++) {	
        		if(modStuID == studentList.get(i).getStdID()) {
        		   System.out.println("수정할 부분을 선택해주세요: 1.일괄수정 2.국어점수 3.수학점수 4.영어점수 5.과학점수 6.취소 ");
        		   choice = sc.nextInt();
        		
    	    		if(choice == 1) {
    					System.out.print("변경할 국어점수를 입력하세요: ");
    					studentList.get(i).getKorScore(sc.nextInt());
    					
    					System.out.print("변경할 수학점수를 입력하세요: ");
    					studentList.get(i).getMathScore(sc.nextInt());
    					
    					System.out.print("변경할 영어점수를 입력하세요: ");
    					studentList.get(i).getEngScore(sc.nextInt());
    					
    					System.out.print("변경할 과학점수를 입력하세요: ");
    					studentList.get(i).getSciScore(sc.nextInt());
    					
    					
    					System.out.println("입력하신 점수로 수정이 완료되었습니다.\n");
    		    		System.out.println("   학번\t 이름\t성별\t국어점수\t수학점수\t영어점수\t과학점수\n ");
    		    		System.out.println("=====================================================");
    		    		System.out.printf("%5d\t%5s\t%5s\t%5d\t%5d\t%5d\t%5d\n" , studentList.get(i).getStdID() , studentList.get(i).getName() ,studentList.get(i).getGender(), 
    		                    studentList.get(i).getKorScore(), studentList.get(i).getMathScore(), studentList.get(i).getEngScore(), studentList.get(i).getSciScore());
    		    		break;
    		    	  }
    	    		
    	    		else if(choice == 2) { //변경 전 점수를 변수에 저장해서 값을 남겨둬야하는데, 계속 studentList.get(i).getKorScore()에서 studentList.get(i).getKorScore(i)로 변경되었다고 해서... 후 ^^..... 기억하자...
    	    			int pastKorScore;
    	    			pastKorScore = studentList.get(i).getKorScore();
    	    			
        				System.out.print("변경할 국어점수를 입력하세요: ");
        				studentList.get(i).getKorScore(sc.nextInt()); 
        				System.out.printf("\n국어점수가 %d에서 %d로 변경되었습니다.\n" , pastKorScore , studentList.get(i).getKorScore());
        				break;
        			}
    	    		else if(choice == 3) { 
    	    			int pastMathScore;
    	    			pastMathScore = studentList.get(i).getMathScore();
    	    			
        				System.out.print("변경할 수학점수를 입력하세요: ");
        				studentList.get(i).getMathScore(sc.nextInt()); 
        				System.out.printf("\n수학점수가 %d에서 %d로 변경되었습니다.\n" , pastMathScore , studentList.get(i).getMathScore());
        				break;
        			}
    	    		else if(choice == 4) { 
    	    			int pastEngScore;
    	    			pastEngScore = studentList.get(i).getEngScore();
    	    			
        				System.out.print("변경할 영어점수를 입력하세요: ");
        				studentList.get(i).getEngScore(sc.nextInt()); 
        				System.out.printf("\n영어점수가 %d에서 %d로 변경되었습니다.\n" , pastEngScore , studentList.get(i).getEngScore());
        				break;
    	    		}
    	    		else if(choice == 5) { 
    	    			int pastSciScore;
    	    			pastSciScore = studentList.get(i).getSciScore();
    	    			
        				System.out.print("변경할 과학점수를 입력하세요: ");
        				studentList.get(i).getSciScore(sc.nextInt()); 
        				System.out.printf("\n과학점수가 %d에서 %d로 변경되었습니다.\n" , pastSciScore , studentList.get(i).getSciScore());
        				break;
    	    		}
    	    		else if(choice == 6) {
    	    			System.out.println("메인 메뉴로 돌아갑니다.");
    	    			break;
    	    		}
    	    		else {
    	    			System.out.println("1번 ~ 7번 사이의 메뉴 번호를 입력해주세요. ");
    	    		}
        		}
        	}
        }
//    	4.정보 삭제
    	void Datadelete() {
    		int choice;
    		
        	System.out.println("모든 학생 정보를 삭제합니다. 동의하십니까? ");
        	System.out.print("1. 예		2. 아니오 >>>\n");
        	choice = sc.nextInt();
        	
        	while(true) {
        		if (choice == 1) {
        			studentList.clear();
        			System.out.println("모든 학생 정보가 삭제되었습니다.");
        			break;
        		}
        		else if(choice == 2) {
        			System.out.println("메인메뉴로 돌아갑니다.");
        			break;
        		}
        		else {
        		System.out.println("1번 혹은 2번을 입력해주세요.");
        		System.out.print("1. 예		2. 아니오 >>>\n");
        		choice = sc.nextInt();
        		}
        	}	
    	}
	
}// 끝!...
