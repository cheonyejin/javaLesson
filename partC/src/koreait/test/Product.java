package koreait.test;

public abstract class Product { //[2]
    protected int price;
    protected String prdName;

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPrdName() {
        return this.prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }
    //[1]


    public abstract String sell(Object obj); //[2]


    @Override
    public String toString() {
        return String.format("상품명: %s, 가격: %d", prdName, price);
    }
}









