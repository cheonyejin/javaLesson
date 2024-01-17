package collection.day12;

import java.util.List;

import collection.myapp.JavaWord;

//자바단어장 클래스는 아래의 추상 메소드를 꼭 구현해야합니다. (기능 또는 규칙)

public interface WordList {

        public static final int MAX_LENGTH=100;   //최대 단어 100개
          //MAX_LENGTH은 100으로 고정시킬거다- static final ->상수(변하지않는값)
          //final:변경못함 
          //static:모든인터페이스에서 참조가능
     

          //추상메서드: 선언만하고 명령코드는 없는거 
          // 아래는 모두 추상메소드다. 선언만 하니까.(//1. ~ 7)
          JavaWord getWord(int i);      //1.
          List<JavaWord> list();        //2.                //🈹여기 이미 구현했는데 
          void add(JavaWord word);      //3.
          int indexOfWord(String english,int position);//4.
          JavaWord remove(int index);                  //5.
          List<JavaWord> searchAllByEnglish(String english);//6.
          void print();                 //7.

          //만약에, 이미 구현 클래스 외에 이후 구현에는 적용하고 싶은 메소드가 있다면 
          //default 키워드로 정의

          default List<JavaWord> search(Object object){ //🈹또 구현하려면 default붙여
               return null;
       }

    }