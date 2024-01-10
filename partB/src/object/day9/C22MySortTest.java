package object.day9;

import java.util.Arrays;

public class C22MySortTest {


    //순차정렬 : 기본은 오름차순 
    //배열 보는 메소드 : Arrays.toString();
    //배열 정렬 메소드 : Arrays.sort();
    public static void main(String[] args) {

        int[] numbers = {67,34,65,89,54};
        System.out.println("초기 numbers : " + Arrays.toString(numbers));

        for(int i=0 ;i<numbers.length ; i++){
            for(int j=i+1; j<numbers.length ; j ++){

                //비교조건이 맞지 않으면 numbers[i]와 numbers[j]를 교환하기 
                // 오름차순은 i < j   
                if (numbers[i] > numbers[j]) {            
                    // 교환하는 방법 
                    // numbers[i] = numbers[j]  : X 이건 잘못된거다.
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
                System.out.println(String.format("중간 상태 i=%d , j=%d : %s",i,j,Arrays.toString(numbers)));
            }
        }
        System.out.println("오름차순 정렬 후 numbers : " + Arrays.toString(numbers));
        System.out.println("\n내림차순 정렬 전 numbers : " + Arrays.toString(numbers));

        for(int i=0 ;i<numbers.length ; i++){
            for(int j=0; j<numbers.length ; j ++){
                // 내림차순은 i > j
                if (numbers[i] > numbers[j]) {            
                    // 교환하는 방법 
                    // numbers[i] = numbers[j]  : X 이건 잘못된거다.
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
                System.out.println(String.format("중간 상태 i=%d , j=%d : %s",i,j,Arrays.toString(numbers)));
            }
        }
        System.out.println("내림차순 정렬 후 numbers : " + Arrays.toString(numbers));

    }
    
}
