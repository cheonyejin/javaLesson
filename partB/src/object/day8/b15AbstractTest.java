package object.day8;
//추상크랠스 테스트 
public class b15AbstractTest {
    public static void main(String[] args) {
        //Animal animal = new Animal();   //추상화된 부모이기때문에 new객체 생성 못한다 . 오류 발생 
        Animal animal = new Animal() {      //Anonymous 익명의 inner(내부 클래스 ) type 침입자 
                                            // 클래스 이름이 없는 내부 클래스 형식
            @Override
            public void sound() {
                System.out.println("익명으로 만들어진 동물 클래스 : 소리는 모름");
            }
        };
        animal.sound();
        System.out.println("animal String : " + animal);

        Puppy puppy = new Puppy("푸들이", "브라운");
        System.out.println("" +puppy);
    }
}
    

