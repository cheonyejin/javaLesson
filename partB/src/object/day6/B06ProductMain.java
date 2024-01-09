package object.day6;

public class B06ProductMain {
    public static void main(String[] args) {
        
        //product 객체를 4개 만들어보겠습니다 
        //이거 Product.java에서 만든 커스텀 생성자 이용해서 객체 만드는 거임 
        Product snack = new Product("새우깡", 1200, "농심", new String[3]);
        Product drink = new Product("칠성사이다", 2200, "롯데", new String[3]);
        Product fruit = new Product("부사", 12000, "우리농원", new String[3]);
        Product icecream = new Product("투게더", 7000, "빙그레", new String[3]);

        System.out.println(snack.getData());
        System.out.println(drink.getData());
        System.out.println(fruit.getData());
        System.out.println(icecream.getData());

        //퀴즈 snack의 etc 필드 배열요소 0번에 "10개묶음"문자열을 저장하시오 

        String[] temp = snack.getEtc(); //가져온값 어떻게 저장? = temp라는 바구니 만들고 거기에 저장해야지
        temp[0] = "10개묶음";            //0번에 "10개묶음"문자열을 저장
        System.out.println(snack.getData());
        //snack.setPrice(1000); -> set메소드 없어서 오류  
        //snack.price = 1000;  -> private이라  오류 


        // 장바구니를 만들어보겠습니다 -> 커스텀 생성자를 이용해서 객체 만들기 
        Product[] mycarts = new Product[5]; // 장바구니 크기는 5개 

        mycarts[0] = drink;
        mycarts[1] = icecream;
        //mycarts[2] = drink;
        mycarts[3] = fruit;
        mycarts[4] = snack;

        //배열이므로 반복문으로 출력할수있습니다 -getData()메소드 사용
        for(int i=0; i<mycarts.length;i++){
            if(mycarts[i] != null)     // 장바구니[2] 2번방은 비어있어서 null이 나와욤
                System.out.println(mycarts[i].getData()); //mycarts[i]가 NULL일때는  메모리에 할당이 안된 상태 -메소드를 쓸수없는 상태 
        }

    }

}
