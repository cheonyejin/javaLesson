package object.day9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class C21ArraySortTest {

    public static void main(String[] args) {
        int[]  numbers = {67,34,77,89,82};
        System.out.println("초기 numbers = " + Arrays.toString(numbers));
        Arrays.sort(numbers);   //정렬메소드 (123456789~)
        System.out.println("정렬 후 numbers = " + Arrays.toString(numbers));
        
        String[] names = {"momo","nayeon", "dahyeon", "Zewi", "Beo"};
        System.out.println("초기 names = " + Arrays.toString(names));
        Arrays.sort(names);   //정렬메소드 (ABC~ abc~) 
        System.out.println("정렬 후  names = " + Arrays.toString(names));
        
        // 정렬메소드 Arrays.sort(배열변수) : 기본형 배열, String배열의 오름차순 정렬가능하다.
        // 내림차순 또는 다른 참조 타입에 대한 정렬은 메소드 2번째 인자로 정렬기준공식을 인터페이스로 전달한다.

        // 순차정렬 알고리즘 :  가장 단순한 알고리즘
        //      오른쪽 정렬 : 왼 < 오  그렇지 않다면 교환  
        

        //내림차순 정렬 - Comparator는 <>제너릭 타입에 기본형을 사용 못합니다 (int말고 Integer를 써야된단소리임)
        //Wrapper클래스를 사용한다 
        Integer[] numbers2 = {67,34,77,89,82};
        Arrays.sort(numbers2, new Comparator<Integer>() { 

            @Override
            public int compare(Integer o1, Integer o2) {    
                return o2-o1; //정수 배열이니까 걍 빼면 됨
            }
        });
        //위에꺼 람다식으로 더 간단하게 만들면 이렇게 됨 
        Arrays.sort(numbers2,(o1,o2) -> {
            return o2-o1;
        });
        System.out.println("numbers2 내림차순 정렬 후 : " + Arrays.toString(numbers2));

    }
        
    
}
