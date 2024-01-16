package collection.myapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
//단어 여러개를 저장하는 단어장 클래스
// JavaWord 여러개를 저장할 클래스 입니다.
//          조회 기능에 유리한 Map을 사용하겠습니다.
public class JavaWordBook {

    //굳이 list대신에 map을 사용한 이유 : 조회를 편하게 하려고 
    // 조회 이외에는 특히 출력에는 map.values()로 vaule값만 사용.
    private Map<String,JavaWord> wordBook;
    // Map<>타입으로 wordBook;이라는 변수 선언한거다 
    //키(key)는 String 타입이고 값(value)은 JavaWord
    //key : 영어단어
    //value : JavaWord (영어,한글,레벨)

    public JavaWordBook() {
        this.wordBook = new TreeMap<>();    
        //key 값인 영어 단어 순으로 정렬하여 접근.
    }
    
    //getter
    public Map<String, JavaWord> getWordBook() {
        return this.wordBook;
    }
    
    //단어 추가하기-void
    public void addWord(JavaWord word){     //JavaWord타입의 변수 word
        this.wordBook.put(word.getEnglish(), word); 
                    //put(키,값)을 this.wordBook에 넣는다
    }
    
    //영어로 단어 조회(단어 하나를 보여주는)-JavaWord
    public JavaWord searchWord(String english){     //String타입의 변수 english
        return this.wordBook.get(english);
    }

    //레벨로 단어 조회 (같은 레벨의 단어 여러개)-List<JavaWord>
    public List<JavaWord> searchWordByLevel(int level) {
        List<JavaWord> results = new ArrayList<>(); //ArrayList<>: 배열 리스트
        // TO DO : 인자로 전달된 level 만 results 리스트에 저장하기
        for ( JavaWord word : this.wordBook.values()){  //출력에는 map.values()로 vaule값만 사용. value : JavaWord (영어,한글,레벨)
            if(word.getLevel()==level)
                results.add(word);
        }
        return results;
    }
    //단어 삭제
    public void removeWord(String english) {
        this.wordBook.remove(english);
    }
    
    //전체 단어 출력하기
    public void wordAllPrint(){
        //TreeMap은 정렬되어 있으므로 Map의 values 를 리스트로 변환하여 출력메소드로 전달하기
        List<JavaWord> all =  new ArrayList<>(this.wordBook.values());      // value : JavaWord (영어,한글,레벨)
        wordListPrint(all);
    }

    //인자로 전달된 list 출력하기
    public void wordListPrint(List<JavaWord> list){
        System.out.println("~".repeat(20)+"~ 단어장 ~" + "~".repeat(20));
        System.out.println(String.format("%-15s %-15s\t %s","<english>","<korean>","<level>")); 
                                                                //<english>       <korean>         <level> 
        for( JavaWord word : list) {
            System.out.println(String.format("%-15s %-15s\t %d",
                            word.getEnglish(),word.getKorean(), word.getLevel()));
        }
    }

}
