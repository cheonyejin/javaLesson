package object.day8_interface.Beable;

public class Dog implements Runnable{

    @Override
    public String beAble() {
        return "달리기";
    }
    @Override
    public String run(int speed) {
        return "Dog은 " + speed+ "km/h로 달립니다. \n최대속도 50km/h,,,";
    }

    
}
