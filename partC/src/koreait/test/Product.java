package koreait.test;

public abstract class Product { //[2]
    protected int price;
    protected String prdName; //[1]

    public Product(int price, String prdName) {
        this.price = price;
        this.prdName = prdName;
    }

    public abstract String sell(Object obj); //[2]

    public int getPrice(){ //2번의[3]
        return price;
    }

    @Override
    public String toString() {
        return String.format("상품명: %s, 가격: %d", prdName, price);
    }
}









