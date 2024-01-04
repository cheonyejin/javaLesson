package basic.day4;


//변수 선언의 위치-> 변수의 사용범위 
public class A21VarivableArea {

    int number=999;             //클래스 범위에서 사용되는 변수 
    static int number2=888888;                  //static으로 선언해야 main에서 사용가능
    public static void main(String[] args) {    //static붙어있잖아 그치
        
        int a = 23;             //메인 메소드 범위에서 사용되는 변수 

        for(int i=0;i<10;i++){  // i는 for문 범위에서 사용되는 변수 
            System.out.println("i="+i);
        }

        while (a==23) {
            int count;          // count는 while문 범위에서 사용되는 변수 
                                //while은 종료조건이 필요하다
            System.out.println("a="+a);
            count=100;
            System.out.println("cont="+count);
            a=24;               //이게 종료조건이다
            //System.out.println("number="+number);   //main에서 static 없이 선언한 변수는 사용 불가능
            System.out.println("number="+number2);  //main에서 static으로 선언한 변수는 for,while문에서도 사용 가능
            // main메소드는 static메소드이다. 
            //static이 아닌 클래스 선언 변수는 사용 못함
        }

        System.out.println("a="+a);
        //System.out.println("i="+i); i는 for문에서만 사용가능하기 때문에 오류
        //System.out.println("count="+count); count는 while문에서만 사용가능하기때문에 오류

    }
    
}
