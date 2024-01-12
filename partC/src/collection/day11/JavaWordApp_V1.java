package collection.day11;
import java.util.ArrayList;
import java.util.List;
import collection.myapp.JavaWord;
//day10에 배운 List 예제 풀어보기 -private

public class JavaWordApp_V1 {
  
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.
  
    private List<JavaWord> words = new ArrayList<>();

    //프로그램 실행 시작하는 메소드 -private
    private void start(){
        initialize();   //word리스트를 몇개만 저장해서 초기화(테스트용)

        //기능 : 등록,목록,검색,삭제
        System.out.println("단어장 시작합니다" +  "_".repeat(30));
        while (true) {
            System.out.println("\t메뉴를 선택하세요");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 조회 ");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 프로그램 종료");
            System.out.println("\t 선택 > ");   //메소드에 입력기능이 있으면 sCANNER관리가 불편하다 - 일일이 꺼야됨
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
        words.add(new JavaWord("public", "공용의", 1));
        words.add(new JavaWord("private", "개인적인", 1));
        words.add(new JavaWord("iterate", "반복하다", 3));
        words.add(new JavaWord("application", "응용프로그램", 2));
    }//initialize

    private void addWord() {
        System.out.println("\t단어를 등록합니다.");
        System.out.println( "영어 단어 입력하세요.__");
        String english = System.console().readLine();
        System.out.println( "한글 단어 입력하세요.__");
        String korean = System.console().readLine();
        System.out.println( "단어 레벨 입력하세요. 0초급 1중급 3고급 __");
        int level = Integer.parseInt(System.console().readLine());

        words.add(new JavaWord(english, korean, level));
    }//addWord

    private void listWord() {
        //리스트  words에 저장된 모든 요소들을 for문을 사용해서 모두 출력해보시오
        System.out.println("\t단어 목록 출력합니다.");
        System.out.println(String.format("%-20s %-30s %-20s", "ENGLISH","KOREAN","LEVEL"));
        for(JavaWord word : words){
            System.out.println(String.format("%-20s %-30s %-20s", word.getEnglish(),word.getKorean(), word.getLevel() ));
        }
    
    }//listWord
    private void searchWord() {
        System.out.println("\t단어를 검색합니다.");
        System.out.println("검색할 단어를 영문으로 검색하세요.");
        String find = System.console().readLine();  //고른값을 find에 넣고 하나하나 맞는지 찾아야됨-> for문
        boolean isfind = false;
        for(JavaWord word : words){     // : 는iterator이다
            if(word.getEnglish().equals(find)){      //문자열 비교는 무조건 equals이다. ==는 정수비교
                System.out.println("검색결과 : "+word.getEnglish()+" = " + word.getKorean()+" 레벨 : " + word.getLevel());
               // return;  //1 단어를 한개 찾으면 search메소드 종료 -> 같은 단어 1번만 저장하게 할때는 사용한다.
                 isfind = true;     //2 같은 단어가 2번이상저장될때 
            }
        }
                if(isfind = false) //2 같은 단어가 2번이상 존재할 때
                System.out.println("존재하지 않는 단어입니다");// 1 2
    }//searchWord


    //리스트에 동일한 단어가 2번 저장된다면?    :  같은 단어 중복 저장 방법에 따라 위와같이 할수있습니다 
    //리스트에 없는 단어를 조회한다면?
    
    private void removeWord() {
        System.out.println("\t단어를 삭제합니다.");
        System.out.println("삭제를 단어를 입력하세요.__");
        String find = System.console().readLine();    //삭제할 단어 입력받기
        boolean isfind = false;
        /* 내가 만들어본 코드 -> 됨
        for (int i = 0; i <words.size(); i++) { 
            JavaWord wordList = words.get(i);
            if (wordList.getEnglish().equals(find)) {
                words.find(i);
                System.out.println("삭제되었습니다.");
                //break; //: 있어도 없어도 되는데 있으면 없는 단어이면 바로 넘어가고 , 있으면 한번 찾고 삭제돼
            }
            
        }if(isfind = false) 
        System.out.println("존재하지 않는 단어입니다");*/
        for (int i = 0; i <words.size(); i++) { 
            if(words.get(i).getEnglish().equals(find)){
                isfind = true;
                System.out.println("인덱스"+i+"에서 단어를 찾았습니다.");
                System.out.println("삭제하려면 엔터, 취소는 n을 입력하세요");
                if(System.console().readLine().equals("n")){
                    continue;
                }else{
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
