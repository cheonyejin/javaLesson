package koreait.test;

public class Bike extends Product {
    private int speed; //[4]

    public Bike(int price, String prdName, int speed) { //[3] 커스텀 생성자 
        super(price, prdName);      //product클래스에 있는 필드를 초기화 하고 ->super
        this.speed = speed;         //현재 클래스의 필드를 초기화 하는것 ->this
    }

    public int getSpeed() { //[4] getter
        return speed;
    }

    public void setSpeed(int speed) { //[4] setter
        this.speed = speed;
    }

    public String ride() { //[5] 메소드
        return String.format("당신은 이것을 시속 %dkm 로 탈 수 있습니다.", speed);
    }

    @Override
    public String sell(Object obj) { //[8] product의 sell()재정의 
        int discount = (int) obj;
        return String.format("[%s] 행사 - %d%% 인하", prdName, discount);
    }

    @Override
    public String toString() { //[10] toString재정의
        return super.toString() + String.format(", 속도: %d", speed);
    }
}

class Electronics extends Product {
    private double kwh; //[6]

    public Electronics(int price, String prdName, double kwh) { //[3] 커스텀 생성자
        super(price, prdName);  //product클래스에 있는 필드를 초기화 하고 ->super
        this.kwh = kwh;         //현재 클래스의 필드를 초기화 하는것 ->this
    }

    public double getKwh() { //[6] getter
        return kwh;
    }

    public void setKwh(double kwh) { //[6] setter
        this.kwh = kwh;
    }

    public double power() { //[7] 메소드 
        return kwh * 24;
    }

    @Override
    public String sell(Object obj) { //[9] product의 sell()재정의
        String gift = (String) obj;
        return String.format("[%s] 증정 - %s", prdName, gift);
    }

    @Override
    public String toString() { //[10] toString재정의
        return super.toString() + String.format(", 전력 소모량: %.2f", kwh);
    }
}

