package object.day7;

//Shape 클래스 상속 예시2
public class Diamond extends Shape{
    
    //생성자 정의가 명시적으로 없으면 기본생성자를 실행합니다.
    // 자식 클래스는 부모클래스 기본생성자를 먼저 실행합니다.

    //자식이지만 부모가 private 으로 했으므로 오류
    public void setShapeName(String shapeName){
        // this.shapeName = shapeName;
    }

    //부모가 protected 로 선언한 필드는 자식은 자유롭게 접근 가능함.
    public void setetc(String etc){
        this.etc = etc;
    }

    @Override
    public void draw() {
        System.out.println("다이아몬드" + this.getShapeName()+"를 그립니다.");
        
    }

    
/*
 * 접근 한정자
 * public       :모두에게 공개
 * private      :모두에게 숨기기. 같은 클래스 안에서만 사용.
 * protected    :같은패키지 클래스와 다른 패키지인 경우에는 자식에게만 공개
 *                  ㄴ Shape의 etc는 자식인 Triangle, Diamond 에게는 공개 / B10DiamondTest 에게는 숨기기
 *                  ㄴ 그 외의 경우는 비공개. 다른 패키지이지만 자식클래스라면 공개
 * 아무것도 안씀 :거의 사용하지 않습니다.
 *                  ㄴ day7 패키지 클래스에게는 모두 공개 / 그 외에는 숨기기
 */             

    //이건 Diamond.java에서 정의한 메소드이므로, Diamond타입으로 선언한 참조변수만 사용가능.
    public void iAmDiamond(){
        System.out.println("나는 다이아온드~ 반짝 반짝!!");
    }

    
    //day8 :  Obiect클래스의 toStr5ing메소드르 오버라이드
    @Override                   //오른쪽 마우스 ,source Action , toString누름  
    public String toString() {  //Obiect클래스의 toStr5ing메소드르 오버라이드
        return "Diamond []";    //원래 출력값 : object.day7.Diamond@1fb3ebeb
                                //현재 출력값 : Diamond []



    }

}
