package object.day9;

import object.day8_interface.Beable.BeAble;
import object.day8_interface.Beable.Cookable;

//익명의 객체- 추상클래스 상속 도는 인터페이스 구현 할때 클래스 이름없이 객체 생성되는 것 
//          ㄴinner 타입

public class C23AnonimousClass {

    public static void main(String[] args) {
        Cookable aiCooker = new Cookable() {
            //추상메서드 정의(구현)
            //컨트롤 스페이스바 누르면 오버라이드할거 나옴
            @Override
            public String beAble() {
                return "cookin machine";
            }    
            @Override
            public void cook(String material) {
                System.out.println("요리하는 기계입니다."+ material +" 레시피를 주세요");
        }
        };
        System.out.println(aiCooker.beAble());
        aiCooker.cook("생닭");


        BeAble  beAble = new BeAble() {
            //재정의 할 메소드가 1개이다 -> Beable 인터페이스의 추상메소드가 1개이다 
            //  = 함수형 인터페이스 : 익명 클래스를 람다식으로도 정의할수있습니다.
            @Override
            public String beAble() {
                return "무엇이든 합니다 ~"; 
            }
        };
        System.out.println(beAble.beAble());
// 람다식 : 복잡한식을 축약하는것
// 람다식에서는 메소드의 인자 () -> {}   :  {}메소드 몸통에 추상메소드 구현부분 작성
        BeAble  beAble2 = () ->{        //자바 스크립트(웹)에서는 -> 화살표를 사용한다 
            return "무엇이든 합니다 ~";
            
        };
        System.out.println(beAble.beAble());

    }//main
    
}//class

//*함수형 인터페이스* 정의 : 추상메소드가 1개인 것     /  function 키워드는 c언어, 자바스크립트에서 함수 정으에 사용
//인터페이스 중에 *추상메소드가 1개인 것*은 다른 프로그래밍 언어에서 사용되는 `함수` 의 형식으로 표현할 수 있습니다.
//      함수와 메소드 공통점은 인자와 리턴값이 있다는 것. 다른 점은 메소드는 클래스(또는 객체)에 구성요소로 포함.
//      자바에서 함수형 인터페이스는 익명으로 많이 사용

//자바 라이브러리에는 인자의 형식과 개수와 리턴 타입 등 여러 유형에 따라 
//      Consumer, Producer(자바8까지 이후 Supplier), Function, Predicate 등의
//      함수형 인터페이스가 미리 정의되어 있습니다.
//@FunctionalInterface//함수형 인터페이스에 사용합니다. 애노테이션이라는 주석으로 `코드를 체크하는 기능`을 합니다.