package collection.day11;
import java.util.ArrayList;
import java.util.List;
import collection.myapp.JavaWord;
//day10에 배운 List 예제 풀어보기 -private

public class JavaWordApp_V1 {
  
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.
  
    private List<JavaWord> words = new ArrayList<>();       
    //ArrayList()을 이용해 words라는 배열리스트를 만들었다

    //프로그램 실행 시작하는 메소드 -private
    private void start(){
        initialize();   //시작하면 바로 intialize()실행하기

        //기능 : 등록,목록,검색,삭제
        System.out.println("단어장 시작합니다" +  "____________");
        while (true) {
            System.out.println("\t메뉴를 선택하세요");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 조회");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 프로그램 종료");
            System.out.println("\t 선택 > ");   
            //메소드에 입력기능이 있으면 scanner관리가 불편하다 - 일일이 꺼야됨
            
            int select = Integer.parseInt(System.console().readLine()); //console : 표준 입출력장치
            // parseInt :정수로 변환      
            //입력받는 방법 : 1. System.In 2.System.console().readLine()


            switch (select) {
                case 1:
                    addWord();          //단어 등록 메소드 
                    break;
                case 2:  listWord(); break;        //단어 목록 조회 메소드
                case 3:  searchWord(); break;        //단어 목록 조회 메소드
                case 4:  removeWord(); break;        //단어 삭제 메소드
                case 5:  
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0); //main실행을 종료
                    break;       
    
                default:
                    System.out.println("잘못된 선택값입니다");
                    break;
            }//switch

            
        }//while



    }//start

    private void initialize() {
        //word리스트를 몇개만 저장해서 초기화(테스트용)
        //myapp패키지에 있는 JavaWord클래스
        //words는 위에서 만든 변수
        words.add(new JavaWord("public", "공용의", 1));
        words.add(new JavaWord("private", "개인적인", 1));
        words.add(new JavaWord("iterate", "반복하다", 3));
        words.add(new JavaWord("application", "응용프로그램", 2));
    }//initialize

    private void addWord() {
        System.out.println("\t단어를 등록합니다.");
        System.out.println( "영어 단어 입력하세요.__");
        String english = System.console().readLine(); 
        //               System.console().readLine()으로 입력받고 english변수에 저장
        System.out.println( "한글 단어 입력하세요.__");
        String korean = System.console().readLine();
        System.out.println( "단어 레벨 입력하세요. 0초급 1중급 3고급 __");
        int level = Integer.parseInt(System.console().readLine());
        //          Integer.parseInt() : 문자열-> 정수로 변환

        words.add(new JavaWord(english, korean, level));
    }//addWord

    private void listWord() {
        //리스트  words에 저장된 모든 요소들을 for문을 사용해서 모두 출력해보시오
        System.out.println("\t단어 목록 출력합니다.");
        System.out.println(String.format("%-20s %-30s %-20s", "ENGLISH","KOREAN","LEVEL")); //이건 그냥 미관용
        for(JavaWord word : words){ //words(리스트)의 각 원소를 word라는 변수에 할당하여 반복(:)
            System.out.println(String.format("%-20s %-30s %-20s", word.getEnglish(),word.getKorean(), word.getLevel() ));
        }
    
    }//listWord

    private void searchWord() {
        System.out.println("\t단어를 검색합니다.");
        System.out.println("검색할 단어를 영문으로 검색하세요.");
        String find = System.console().readLine();  
        boolean isfind = false;
        for(JavaWord word : words){         //words(리스트)의 원소 하나하나를 JavaWord타입의 word(변수)에 할당하는것을 반복
            if(word.getEnglish().equals(find)){      // .equals() : 문자열비교 / == :  정수비교
                System.out.println("검색결과 : "+word.getEnglish()+" = " + word.getKorean()+" 레벨 : " + word.getLevel());
               // return;  //1 단어를 한개 찾으면  종료 -> 
                 isfind = true;     //2 같은 단어가 2번이상있을때  / isfind에 true를 넣는것이고
                                    // = 은 대입, ==은 비교이다. 
            }
        }                           
                if(isfind == false) //2 같은 단어가 2번이상 존재할 때   /isfind가 false인지 비교하는것.
                System.out.println("존재하지 않는 단어입니다");// 1 2
    }//searchWord

    private void removeWord() {
        System.out.println("\t단어를 삭제합니다.");
        System.out.println("삭제를 단어를 입력하세요.__");
        String find = System.console().readLine();    //삭제할 단어 입력받기
        boolean isfind = false;
        for (int i = 0; i <words.size(); i++) { 
            if(words.get(i).getEnglish().equals(find)){
                isfind = true;
                System.out.println("인덱스"+i+"에서 단어를 찾았습니다.");
                System.out.println("삭제하려면 엔터, 취소는 n을 입력하세요");
                if(System.console().readLine().equals("n")){    
                    continue;   // n->continue->남은for문 실행하지않고 다음으로 넘어가기 
                }else{          // 엔터를 누르면 
                    words.remove(i);    //같은 값이 2개인 경우 최근입력값을 먼저 삭제한다.
                    System.out.println("단어가 삭제되었습니다.");
                }
            }
        }
        if (!isfind) {
            System.out.println("존재하지 않는 단어입니다.");
            
        }

    }//removeWord
    

    public static void main(String[] args) {
        //프로그램 실행하는 객체 생성하고 (메소드로 기능을 분리할때 main이 호출하는 static을 없애기 위함)
        //start 메소드 프로그램 실행 내용을 코딩
        JavaWordApp_V1 app = new JavaWordApp_V1();
        app.start();

    }//main


    
}
