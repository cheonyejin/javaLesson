package koreait.test;

public class ProductApp {
    public static void main(String[] args) {

        Product[] cart = new Product[10]; //[1]
        cart[0] = new Bike(123000, "MTB", 25);
        cart[1] = new Electronics(35000, "USB", 0);
        cart[3] = new Bike(99000, "삼천리", 15);
        cart[5] = new Electronics(527000, "스마트TV", 0);
        cart[7] = new Electronics(225000, "lg냉장고", 0);

        ((Electronics) cart[5]).setKwh(0.9);//[2]
        double powerResult = ((Electronics) cart[5]).power();
        System.out.println("\n2. cart의 인덱스 5번의 power 결과: " + powerResult);

        System.out.println("\n3. 가격이 10만원 이상인것은? : "); //[3]
        for (Product product : cart) {
            if (product != null && product.getPrice() >= 100000) {
                System.out.println("\t" + product);
            }
        }

        System.out.println("\n4. Bike 객체의 ride 메소드 실행 결과:"); //[4]
        for (Product product : cart) {
            if (product instanceof Bike) {
                System.out.println("\t" + ((Bike) product).ride());
            }
        }

        System.out.println("\n5. 인덱스 3번 객체에 sell()실행 결과 : " + cart[3].sell(20)); //[5]

        System.out.println("\n6. 인덱스 5번 객체에 sell()실행 결과 : " + cart[5].sell("사운드바")); //[6]
    }
}



