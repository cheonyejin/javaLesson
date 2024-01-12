package collection.day11;
import java.util.ArrayList;
import java.util.List;
import collection.myapp.JavaWord;

/*
 * JavaWordApp_V2 : 검색메소드, print메소드 리팩토리
 */
public class JavaWordApp_V2 {

    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.
    //day10에 배운 List 예제 풀어보기 -private
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
                case 3:  searchWordBy(); break;        //단어 검색 메소드
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


    //출력메소드: 출력할 여러개의 JavaWord 객체를 -> List
    //                                  전달받아 -> 인자 
    //                                  이쁘게 화면에 출력 ->print  
    private void printWordList(List<JavaWord> list){
        for(JavaWord word : list){
            System.out.println(String.format("%-20s %-30s %-20s", word.getEnglish(),word.getKorean(), word.getLevel() ));
        }
    
    }// 이 메소드는 searchWord 와 listWord 같은 다른 메소드들이 리스트를 출력할때 쓰인다 

    private void listWord() {
        //리스트  words에 저장된 모든 요소들을 for문을 사용해서 모두 출력해보시오
        System.out.println("\t단어 목록 출력합니다.");
        System.out.println(String.format("%-20s %-30s %-20s", "ENGLISH","KOREAN","LEVEL"));
        
        printWordList(words);       //출력할 words전달
    
    }//listWord


    private void searchWordBy(){ // //단어 검색 메소드  searchWord()를 업그레이드 함 
        System.out.println("\t단어 검색합니다. 단어 검색은 1, 레벨 검색은 2 를 입력하세요 :");
        String find =null;
        List<JavaWord> list = null;
        switch (System.console().readLine()) {
            case "1":
                System.out.println("검색할 영문 단어를 입력하세요.__");
                find = System.console().readLine();
                list = searchAllWord(find); //searchAllWord : 일치하는 결과 모두 리턴하는 메소드
                break;
            case "2":
                System.out.println("검색할 레벨을 입력하세요.__");
                int level = Integer.parseInt(System.console().readLine());
                list = searchAllWord(level);
                break;
            default:
                System.out.println("1 혹은 2 만 입력하세요.");
                return;
        }
        if(list.size()==0){
            System.out.println("존재하지 않는 단어입니다");
        }else   
        printWordList(list);     //출력할  results를 메소드에 전달


    }//searchWordBy
    
    private List<JavaWord> searchAllWord(int level) {
        List<JavaWord> list = new ArrayList<>();        //list :검색결과를 저장할 리스트 
        for(JavaWord word : words){
            if (word.getLevel()==(level)) {
                list.add(word);  
            }
        }
        return list;

    }

    //검색 방법 메소드
    //1. 단어검색 : 첫번째로 일치하는 결과 1개만 리턴
    //메소드의 인자를 입력데이터로 하여 메소드의 코드가 실행되고 결과는 return으로 출력
    /*private JavaWord searchFirstWord(String english){
        for(JavaWord word : words){
            if (word.getEnglish().equals(english)) {
                return word;        //인자로 전달된 english와 같은 word리턴
            }
        }
        return null;    //찾는 english단어가 없으면 for문이 리스트 모두 반복하고 종료, null리턴
    }*/
    //2. 단어검색 :        일치하는 결과 모두 리턴
    private List<JavaWord> searchAllWord(String english){
        List<JavaWord> list = new ArrayList<>();        //list :검색결과를 저장할 리스트 
        for(JavaWord word : words){
            if (word.getEnglish().equals(english)) {
                list.add(word);                         //일치하는 단어를 만날때마다 저장한다->for문
            }
        }
        return list;    
    }




    /*위의 검색방법메소드를 이용해서 검색하는 메소드 
    private void searchWord() {                             //JavaWordApp_V1랑 코드 약간 다름 이거 주의해서 보기 
        System.out.println("\t단어를 검색합니다.");
        System.out.println("검색할 단어를 영문으로 검색하세요.");
        String find = System.console().readLine();  
        
        1. 단어 1개만 리턴
        JavaWord word = searchFirstWord(find);
        if(word!=null){
            System.out.println("검색결과 : "+word.getEnglish()+" = " + word.getKorean()+" 레벨 : " + word.getLevel());
        }else
            System.out.println("존재하지 않는 단어입니다");
        
        // 2. 단어 여러개 리턴
        List<JavaWord> results = searchAllWord(find);
        if(results.size()==0){
            System.out.println("존재하지 않는 단어입니다");
        }else   
        printWordList(results);     //출력할  results를 메소드에 전달
    }
    */
        

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
                    words.remove(i);    //같은 값이 2개인 경우 먼저 입력된것이 삭제된다
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
        JavaWordApp_V2 app = new JavaWordApp_V2();
        app.start();

    }//main


    
}
