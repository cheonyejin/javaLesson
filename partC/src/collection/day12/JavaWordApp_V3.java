package collection.day12;

import java.util.ArrayList;
import java.util.List;

import collection.myapp.JavaWord; 

/**
 * JavaWordApp_V3 : 아래의 JavaWordList 를 이용해서 똑같이 메뉴가 동작하도록 
 *                  변경해 봅시다.
 * JavaWord :  단어 객체(myapp패키지)
 * JavaWordList : 단어장 객체(여기패키지)
 * WordList :(여기패키지) :추상메서드, 최대길이값 상수로 선언
 * 객체 지향 프로그래밍은 최대한 객체로 분리시켜서 실행되는 환경에 독립적이 되도록 합니다.
 */

public class JavaWordApp_V3 {
  
    private JavaWordList words = new JavaWordList();
    
 
    private void start(){
            words.initialize();    //JavaWordList에 있는 initialize()
            
            System.out.println("단어장 프로그램 시작합니다.~~~~~~~~~~~~~~");
            while(true){
                System.out.println("\t <메뉴를 선택하세요.>");
                System.out.println("\t 1. 단어 등록");
                System.out.println("\t 2. 단어 목록 출력");
                System.out.println("\t 3. 단어 검색");
                System.out.println("\t 4. 단어 삭제");
                System.out.println("\t 5. 프로그램 종료");
                System.out.print("선택 > ");     
                int select = Integer.parseInt(System.console().readLine());  
            
                switch (select) {
                    case 1:
                        addWord();      
                        break;
                    case 2: listWord();  break;    
                    case 3: searchWordBy();  break;    
                    case 4: removeWord();  break;    
                    case 5: 
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);     
                        break;    
                    default:
                        System.out.println("잘못된 선택값 입니다.");
                        
                } 
            }  
    }   
    
    private void addWord() {
        System.out.println("\t::단어 등록합니다.::");
        System.out.print("영어 단어 입력하세요. _ ");
        String english = System.console().readLine();
        System.out.print("한글 의미 입력하세요. _ ");
        String korean = System.console().readLine();
        System.out.print("단어 레벨 입력하세요.(1:초급 2:중급 3:고급) _");
        int level = Integer.parseInt(System.console().readLine());
        
        words.add(new JavaWord(english, korean, level));
        
    }
    
    //initialize 사라짐: JavaWordList에 있음
    
    private void listWord() {
        System.out.println("\t::단어 목록 출력합니다.::");
        words.print();      // printWordList(words);   ->   words.print(); 
    }

    //JavaWordList 객체의 메소드를 이용해서 수정해보세요.
    private void searchWordBy() {
        System.out.println("\\t단어 검색합니다. 단어 검색은 1, 레벨 검색은 2 를 입력하세요 :");
        String find=null;
        List<JavaWord> list=null;      
        switch (System.console().readLine()) {
            case "1":
            System.out.println("검색할 영문 단어를 입력하세요.__");
            find = System.console().readLine();
            list= words.searchAllByEnglish(find);   //searchAllWord-> searchAllByEnglish (JavaWordList에)
            break;
            case "2":
            System.out.println("검색할 레벨을 입력하세요.__");
            int level = Integer.parseInt(find);
            list = words.searchAllByLevel(level);  //searchAllWord-> searchAllByLevel  (JavaWordList에)
            break;
            default:
            System.out.println("1 혹은 2 만 입력하세요.");
            return;
        }
        if(list.size()==0) {
            System.out.println("존재하지 않는 단어입니다.");}
            else 
            JavaWordList.print(list);     //printWordList(list); ->   JavaWordList.print(list); 
        }
        
        //searchAllWord사라지고 English, level각각 만들었음
    
    private void removeWord() {
        System.out.println("\t::단어 삭제합니다.::");
        System.out.print("삭제할 단어를 영문으로 입력하세요. _");
        String find = System.console().readLine();
        int position=words.indexOfWord(find, 0); //단어의 인덱스를 배열로리턴
        if(position == -1)  {   //인덱스 0부터 단어를 찾아서 -1 이면 찾는 단어가 없음.
            System.out.println("삭제할 단어는 단어장에 없습니다.");
            return;
        }
        while (position !=-1) {
            System.out.println("삭제할 단어 -" + words.getWord(position));
            System.out.println("삭제하려면 엔터, 취소는 n을 입력하세요");
            if(!System.console().readLine().equals("n")){
                //단어삭제
                words.remove(position);
                System.out.println("단어 삭제 완료");
                position--; //삭제했을 때는 인덱스값이 position 뒤의 요소들은 모두 -1 씩 감소.
            }
            position=words.indexOfWord(find, ++position);
            //position은 찾은 단어 다음 위치부터 다시 찾기
        }
    }
    
    public static void main(String[] args) {
        //프로그램 실행하는 객체 생성하고 
        //          (메소드로 기능을 분리할 때 main이 호출하는 static 을 없애기 위함.)
        //         start 메소드 프로그램 실행 내용을 코딩
        JavaWordApp_V3 app = new JavaWordApp_V3();
        app.start();
    }

    
    
}
