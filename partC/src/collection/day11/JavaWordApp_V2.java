package collection.day11;
import java.util.ArrayList;
import java.util.List;
import collection.myapp.JavaWord;

/*
 * JavaWordApp_V2 : 1) for문을 printWordList에 만들어서 출력메소드
 *                  2) searchAllWord(String)1, searchAllWord(Int)2,로 나누어 검색searchWordBy
 */
public class JavaWordApp_V2 {

    
    
    private List<JavaWord> words = new ArrayList<>();    

    
    private void start(){
        initialize();   

    
        System.out.println("단어장 시작합니다" +  "_________________");
        while (true) {
            System.out.println("\t메뉴를 선택하세요");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 조회 ");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 프로그램 종료");
            System.out.println("\t 선택 > ");   
            
            int select = Integer.parseInt(System.console().readLine()); 
     
     


            switch (select) {
                case 1:
                    addWord();         
                    break;
                case 2:  listWord(); break;        
                case 3:  searchWordBy(); break;        //searchWord->searchWordBy
                case 4:  removeWord(); break;        
                case 5:  
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                    break;       
    
                default:
                    System.out.println("잘못된 선택값입니다");
                    break;
            }  
        }
    }

    private void initialize() {
        words.add(new JavaWord("public", "공용의", 1));
        words.add(new JavaWord("private", "개인적인", 1));
        words.add(new JavaWord("iterate", "반복하다", 3));
        words.add(new JavaWord("application", "응용프로그램", 2));
    }

    private void addWord() {
        System.out.println("\t단어를 등록합니다.");
        System.out.println( "영어 단어 입력하세요.__");
        String english = System.console().readLine();
        System.out.println( "한글 단어 입력하세요.__");
        String korean = System.console().readLine();
        System.out.println( "단어 레벨 입력하세요. 0초급 1중급 3고급 __");
        int level = Integer.parseInt(System.console().readLine());

        words.add(new JavaWord(english, korean, level));
    }


    //출력메소드: 출력할 여러개의 JavaWord 객체를 -> List
    //                                  전달받아 -> 인자 
    //                                  이쁘게 화면에 출력 ->print  
    private void printWordList(List<JavaWord> list){
        for(JavaWord word : list){
            System.out.println(String.format("%-20s %-30s %-20s", word.getEnglish(),word.getKorean(), word.getLevel() ));
        }
    
    }// 이 메소드는 searchWord 와 listWord 같은 다른 메소드들이 리스트를 출력할때 쓰인다 

    private void listWord() {
        
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
        String find = System.console().readLine();    
        boolean isfind = false;
        for (int i = 0; i <words.size(); i++) { 
            if(words.get(i).getEnglish().equals(find)){
                isfind = true;
                System.out.println("인덱스"+i+"에서 단어를 찾았습니다.");
                System.out.println("삭제하려면 엔터, 취소는 n을 입력하세요");
                if(System.console().readLine().equals("n")){
                    continue;
                }else{
                    words.remove(i);  
                    System.out.println("단어가 삭제되었습니다.");
                }
            }
        }
        if (!isfind) {
            System.out.println("존재하지 않는 단어입니다.");
            
        }

    }
    

    public static void main(String[] args) {
        
        JavaWordApp_V2 app = new JavaWordApp_V2();
        app.start();

    }


    
}
