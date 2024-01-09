package object.day7;

public class B11DiamondTest {
    public static void main(String[] args) {
        Diamond diamond = new Diamond();
        System.out.println("다이아몬드 너비 " + diamond.getWidth());
        System.out.println("다이아몬드 높이 " + diamond.getHeight());
        System.out.println("다이아몬드 넓이 " + diamond.calculateArea());
        diamond.print();


        /* 
        ///B11 DiamondTest는 Shape에서 상속받은 자식클래스가 아님.
        diamond.round = 3;

        //shpar과 같은 패키지가 아님 
        diamond.etc = "테스트";

        System.out.println("변경되 내용 확인 : " + diamond.round);
        System.out.println("변경되 내용 확인 : " + diamond.etc);

        */
        // 위의 주석은 모두 오류


        diamond.border = 3.0 ;  // 패키지도 다르고 상속도 아닌데 public 이여서 사용 가능함
    
}
}

// B10과 B11은 코드가 모두 같은데 차이점이 무엇이냐 ?
