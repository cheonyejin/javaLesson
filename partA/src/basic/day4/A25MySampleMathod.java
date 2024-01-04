package basic.day4;

public class A25MySampleMathod {


    //A21의 1~5for문을 메소드로 바꾸기 
    //메소드 안에서 출력문 만들지 않기 
    //메소드명 : 1.sum1ToN 2.multiplyToN 3.sumMtoN 4.multiplyMToN 5.multiplyNof2
    //6. 구구단 출력하는 메소드 리턴은 void. printGugoDan



    public static void main(String[] args) {
        sum1ToN(10);  
        multiplyToN(0);                        //메소드호출
        multiplyMToN(0, 0);
        sumMtoN(0, 0);
        multiplyNof2();


        //int result = addMtoN(2,5);
        
    }
    
    /*public static int addMtoN(int i, int j) {
        int sum =0;
        for(int k =i;k <=j;k++);{
            sum += k;
        }
        return sum;
    }*/
     //3. 시작값 m부터 n가지 더하기 
    static long sumMtoN(int m, int n ){
        m=5; n=8;
        int sum=0;
        for(int i=m;i<=n;i++){
            sum +=i;
        }
        return sum;
    }

    //1.1부터 n까지 더하기
    public static int sum1ToN(int n){
        int sum=0;
        for(int i=0;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    //2. 1부터 n까지 곱하기 
    public static long multiplyToN(int n){
        long longresult = 1;
        for(int i=1;i<=n;i++){
            longresult *= i;
        }
        return longresult;

    }

    //4. 시작값 m부터 n가지 더하기 
    public static int multiplyMToN(int start, int end){
        int m=5;
        int n=8;
        int longresult=1;
        for(int i=m;i<=n;i++){
            longresult *= i;
        }
        return longresult;
        
    }
    //5. 2의 n승 구하기 = 2를 n번 곱하기 
    public static long multiplyNof2(){
        int n=5;
        long longresult=1;
        for(int i=1;i<=n;i++){
            longresult *= 2;
        }
        return longresult;
    }
    //6. 구구단 출력 : for문 안에 for문
    public static void printGugoDan(){
        
        for(int i =2;i<=9;i++){

            System.out.println(String.format("%3d단",i));

            for(int j=1;j<=9;j++){  //
                System.out.println(String.format("%3d x %2d = %2d",i,j,i*j));


            }
        }
    }




}
