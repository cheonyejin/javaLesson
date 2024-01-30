package koreait.test;

public class ProductApp {
    public static void main(String[] args) {

        Product[] cart = new Product[10]; //[1]
        cart[0] = new Bike(123000, "MTB", 25);
        cart[1] = new Electronics(35000, "USB", 0);
        cart[3] = new Bike(99000, "삼천리", 15);
        cart[5] = new Electronics(527000, "스마트TV", 0);
        cart[7] = new Electronics(225000, "lg냉장고", 0);

        if (cart[5] instanceof Electronics) {//[2]      //다운캐스팅을 할땐 instanceof로 타입찾는 방법 먼저 하기!
            Electronics tv = (Electronics) cart[5];
            tv.setKwh(0.9);
            System.out.println("\n2. cart의 인덱스 5번의 power 결과: " + tv.power());
        }
        else{
            System.out.println("Eletronics 타입으로 변경 불가");
        }


        //[3]가격이 10만원 이상인것은? --배열10개중에 가격이 있는것은 5개이다. 
        //                              반복문으로 null이 아닌것만 실행하도록 한다 
        //                              null인경우 NullPointerException 예외 발생하기
        System.out.println("\n3. 가격이 10만원 이상인것은? : "); //[3]
        for (Product p : cart) {
            if (p != null && p.getPrice() >= 100000) {
                System.out.println("\t" + p);
            }
        }

        //[4]
        System.out.println("\n4. Bike 객체의 ride 메소드 실행 결과:"); 
        for (Product p : cart) {
            if (p != null && p instanceof Bike) {   //instanceof
                Bike bike = (Bike) p;               //다운캐스팅
                System.out.println("\t" + (bike.ride()));
            }
        }

        System.out.println("\n5. 인덱스 3번 객체에 sell()실행 결과 : " + cart[3].sell(20)); //[5]

        System.out.println("\n6. 인덱스 5번 객체에 sell()실행 결과 : " + cart[5].sell("사운드바")); //[6]
    }
}

/*
 * 자바교재204페이지 
 *      라이브러리 클래스 : pubuct,nike,productapp 그리고 제일 중요한 자바 클래스들 
 *      프로그래밍에 필요한 재료로 사용되는 클래스 
 *      인스턴스 메소드와 static메소드로 제공되는 기능을 사용함
 * 
 * 실행클래스 productapp
 *      main메소드를 포함하여 프로그램을 실행함
 *      main메소드는 반드시 static이어야 합니다 
 *      main메소드를 위한 객체를 먼저 생성할수없다 그래서 static입니다 
 * 
 * 설명예시 
 *      Bike클래스와 sell메소드 Object인자값은 외부에서 줍니다 
 *      여기서 외부는 이 메소드를 이용하는 main 또는 다른 클래스를 말합니다 
 *      라이브러리 클래스의 특히 인스턴스 필드값은 실행될때 결정됩니다
 * 
 */



