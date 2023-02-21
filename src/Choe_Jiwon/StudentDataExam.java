package Choe_Jiwon;

import java.util.*;

public class StudentDataExam {

	public static void main(String[] args) {
		
		StudentDataManager stdDataManager = new StudentDataManager();
        
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
        		stdDataManager.inputStdData();
        	}
            else if (choice == 2) {
            	stdDataManager.showAllStdData();
            }
            else if (choice == 3) {
            	stdDataManager.scoreModify();
            }
            else if (choice == 4) {
            	stdDataManager.Datadelete();
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

/*
# # # 어떻게 구현할까? # # #

1. 클래스는 크게 3개로 구성이 필요할 것 같다.
1) StudentData: 학셩 정보를 모아 놓은 클래스. 
ex. 학생 학번, 학생 이름, 학생 성별, 국어점수...과학점수 등 	-> 오버로딩해서 매개변수 있는 것과 없는 것으로 나눠보고 싶다.

2) StudentDataManager: 1~5 번 버튼을 누를 때, 해당하는 기능을 모아 놓은 클래스. 
ex.학생정보 입력하는 매서드, 입력한 정보 전체다 보여주는 매서드, 입력한 정보 수정하는 매서드...  -> StudentData의 매서드를 통해 학생 정보를 호출해야할 듯...

3) StudentDataExam: 실행할 main 매서드가 있는 클래스.
ex.메뉴 화면 출력, 1 ~ 5번 누를 때, 필요한 매서드 호출하기, 
메인메뉴는 입력한 번호의 기능을 다 수행하면 메인메뉴로 돌아온다. 
(=> 무한반복 필요할 것 같음. 따라서 while 반복문이 필요할 것 같다. 단, 5번 누르면 프로그램 종료 즉, 반복문 break.)  

2. 문제 발생 
1) Scanner에서 입력받을 때, 숫자(nextInt) 와 문자열(nextLine: 개행 효과 있음)을 연속적으로 입력 받을 수 없다...
2) sc.nextLine 을 삽입해서 개행 효과를 줘도 해결이 안됨... 왜일까...
3) ArrayList에서 comparator 클래스를 별도로 만들고 사용해서, 정렬하고, Collections.sort,add,remove, sublist 등등 사용해보고 싶었는데...무리였다^^
4) 더 숙달되면 Collections 꼭 써보자... (숫자와 문자열이 혼합되있는 정보에서 comparator 사용해서 비교순위 정하는 것을 구현하는 것이 생각보다 안된다... ㅠㅠ )
5) 중복검사 매서드 구현하는게 생각보다 쉽지 않다. input 매서드 밖으로 별도의 매서드로 만들어서 input 매서드안에서 호출하게 하고싶은데...
6) 예외처리 try catch도 사용해보고 싶었는데... 무리였다^^ 숫자,문자 타입 잘못 입력하는 등 오류나면 아예 프로그램 다운 돼버림 ㅋㅋㅋㅋ(예외처리 다시 공부하자...)
7) 시간 부족. -> 힉생정보 조회에서도 전체 조회 부분조회 나눠보기, 정보 삭제에서도 부분 삭제, 전체 삭제 구현해보기...


3. 궁금한 점(과제 종료 후 찾아보자.)
1) 래퍼런스 private 선언해야할 것 같은데, 음... 해도 되고 안해도 되는 걸까? 1차이가 잘 느껴지진 않는다...
2) 매서드에 static 붙이고 인스턴스 생성 안하고 호출해서 사용해도 될까?... (해보기.)  

4. 개인적으로 주의할 점! 
1) 변수명, 매서드명, 클래스명 이름짓고 기억하기 생각보다 어렵다!....
*/
