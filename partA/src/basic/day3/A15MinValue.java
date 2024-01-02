package basic.day3;

public class A15MinValue {


    public static void main(String[] args) {
        
        int n1 = 5;
        int n2 = 6;
        int n3 = 7;
        int min;
        if (n1 <n2) {
            min = n1 ;

        }
        else {
            min = n2;
        }


        if (min > n3) {
            min= n3;
            System.out.println("가장 작은 값은 " + min);
        }
        else{

            System.out.println("가장 작은 값은 "+ min);

        }
        //이번엔 삼항연산식으로 표현해보기
        min = (n1 < n2 ? n1 : n2);
        min = (min < n3 ? n3 : min );
        System.err.println(min);

    }
    
}
