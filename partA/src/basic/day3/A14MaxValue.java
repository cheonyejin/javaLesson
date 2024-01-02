package basic.day3;

public class A14MaxValue {

    public static void main(String[] args) {
        
        int n1 = 5;
        int n2 = 6;
        int n3 = 7;
        int max;

        if (n1 >n2) {
            max = n1 ;

        }
        else {
            max = n2;
        }


        if (max < n3) {
            max= n3;
            System.out.println("가장큰 값은 " + max);
        }
        else{

            System.out.println("가장 큰 값은 "+ max);

        }
        //이번엔 삼항연산식으로 표현해보기
        max = (n1 > n2 ? n1 : n2);
        max = (max < n3 ? n3 : max );
        System.err.println(max);
    }
}
