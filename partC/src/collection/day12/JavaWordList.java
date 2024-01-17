package collection.day12;

import java.util.ArrayList;
import java.util.List;

import collection.myapp.JavaWord;

/**
 * JavaWordList : WordList인터페이스를 구현한다.
 *                 WordList인터페이스에서 선언된 추상메소드 다 재정의하기
 */
public class JavaWordList implements WordList{
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.
    private List<JavaWord> words;   //words 만들어
    
    public JavaWordList() {
        System.out.println("단어장의 최대 개수 : " +WordList.MAX_LENGTH); //다른 인터페이스의 상수값 참조
        words = new ArrayList<>();
    }
    
    public void initialize() {
        words.add(new JavaWord("public", "공용의", 1));
        words.add(new JavaWord("public", "공동의", 2));
        words.add(new JavaWord("private", "사적인", 1));
        words.add(new JavaWord("iterator", "반복자", 3));
        words.add(new JavaWord("application", "응용프로그램", 2));
    }

    //wordList인터페이스에서 선언된 추상메소드 재정의 (//1. ~ //7.)
    @Override
    public JavaWord getWord(int i) {                            //1.
       return words.get(i);                 //get(인덱스위치) : 지정된 인덱스 i의 요소(JavaWord 객체) 리턴
    }


    //단어장 전체 리스트 리턴
    @Override
    public List<JavaWord> list() {                              //2.
        return words;
    }

    //단어 추가
    @Override
    public void add(JavaWord word) {                            //3.
        if(words.size()==WordList.MAX_LENGTH){  //public static final int MAX_LENGTH=100
        System.out.println("단어장이 꽉 찼습니다.");
        }
        words.add(word);
    }

    //전달받은 영어 단어의 인덱스를 배열로 리턴합니다.-조회 및 삭제 기능에 사용할 새로운 메소드
    // words 리스트의 인덱스 위치 position 부터 단어 english 를 찾기.
    @Override
    public int indexOfWord(String english,int position){        //4. 
        for(int i=position;i<words.size();i++){
            if(words.get(i).getEnglish().equals(english))
                return i;       //찾으면 인덱스 리턴
        }   
        return -1;  //일치하는 단어를 찾지 못한 경우 -1을 반환
    }

    //단어를 인덱스로 삭제
    @Override
    public JavaWord remove(int index) {                         //5.
        JavaWord word = words.remove(index);
        return word;
    }

    //단어 목록 조회//원래는 V2에 있던거
    @Override
    public List<JavaWord> searchAllByEnglish(String english){   //6.
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    @Override
    // 인스턴스 메소드 : 인스턴스 필드 words 를 사용하여 동작.      //7.
    public void print(){
        for(JavaWord word : words) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }


    //단어 1개 조회(여러개 일때는 처음 1개)
    public JavaWord searchFirstByEnglish(String english) {  
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
                return word;        //인자로 전달된 english 와 같은 word 리턴(메소드 종료)
            }
        }
        return null;  //1번만해           
    }
    

    //단어 여러개 조회: list
    public List<JavaWord> searchAllByLevel(int level){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getLevel()==level ) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

   

    // 위의 재정의한 //7.과 다른 점 : 인스턴스필드를 사용하지 않고 인자를 받아서 동작한다
    public static void print(List<JavaWord> list){
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }

   
   

}