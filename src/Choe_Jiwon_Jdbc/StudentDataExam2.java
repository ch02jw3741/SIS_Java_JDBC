package Choe_Jiwon_Jdbc;

import java.util.*;

public class StudentDataExam2 {

	public static void main(String[] args) {
		
		StudentDataManager2 stdDataManager2 = new StudentDataManager2();
        
        int choice = 0;
        
        Scanner sc = new Scanner(System.in);
        
        while (choice != 5) {											// 5면 프로그램 종료.
        	System.out.println("\n# # # 학생 성적 관리 프로그램 # # #");
        	System.out.println();
        	System.out.println(" 1. 학생 정보 입력 ");
        	System.out.println(" 2. 학생 정보 조회 ");
        	System.out.println(" 3. 성적 변경 ");
        	System.out.println(" 4. 학생 정보 삭제 ");
        	System.out.println(" 5. 프로그램 종료 ");
        	System.out.print("이용하실 메뉴 번호를 입력하세요. >>>>>");
        	
        	choice = sc.nextInt();
        	
        	if (choice == 1) {
        		StudentData2 sd2 = new StudentData2();
        		
        	    sd2.setStdID(9999);
        	    sd2.setName("조슈아");
        	    sd2.setGender("남성");
        	    sd2.setKorScore(95);
        	    sd2.setMathScore(96);
        	    sd2.setEngScore(97);
        	    sd2.setSciScore(98);
        	    
        	    stdDataManager2.InsertStdData(sd2);
        	}
            else if (choice == 2) {
            	System.out.println(stdDataManager2.showAllStdData());
            }
            else if (choice == 3) {
            	StudentData2 sd2 = new StudentData2();
            	
            	sd2.setKorScore(10);
        	    sd2.setMathScore(11);
        	    sd2.setEngScore(12);
        	    sd2.setSciScore(13);
        	    sd2.setStdID(7777);
            	
            	stdDataManager2.updateStdData(sd2);
            }
            else if (choice == 4) {
            	StudentData2 sd2 = new StudentData2();
            	
            	sd2.setStdID(7777);
            	
            	stdDataManager2.deleteStdData(sd2);
            }
            else if (choice == 5) {
            	System.out.print("프로그램을 종료합니다.");
            	sc.close();		// 프로그램 종료(: 무한 반복 종료, 입력할 정보 없음, 스캐너 닫아주기.)
            	break;
            }
            else {
            	System.out.print("\n1번 ~ 5번 사이의 메뉴 번호를 입력하세요. \n");
            }
         }
	}
} // 끝!

