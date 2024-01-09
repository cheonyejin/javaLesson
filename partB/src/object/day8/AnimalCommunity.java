package object.day8;


public class AnimalCommunity {

	public static void main(String[] args)  {
		System.out.println("여기는 유기동물 분양소입니다.");
			Animal[] animals = new Animal[10];
			animals[0] = new Puppy("푸들이","브라운");
			animals[1] = new Cat("그레이");
			animals[2] = new Rabbit();
			animals[2].setColor("화이트");
			animals[3] = new Puppy("말티즈","화이트");


			//퀴즈 : 아래와 같이 객체를 배열요소에 대입했습니다 수정이 필요한 코드는?  break를 없애고 continue를 쓰면 됨
			animals [7] = new Animal() {
				static final String TYPE = "새";
				@Override
				public void sound(){
					System.out.println("앵무새는 안녕이라고 말합니다.");
				}
				@Override
				public String toString(){
					return TYPE + "[color = "  +color + "] , "+ "[name = " +name +"]";
				}

			};

			animals[7].setName("앵무새");
			animals[7].setColor("빨강");

			//퀴즈 끝


			System.out.println("\n[[반려동물 목록을 보여드리겠습니다.]] \n");
			for(int i=0;i<animals.length;i++) {
				if(animals[i]!= null)		//배열요소에 참조되는 객체가 있는지 검사  만약 null일때 sound()실행하면 오류난다
					animals[i].sound();
			}	
			
	//	모모회원이 동물 보호소의 모든 동물들을 분양 받을 수 있는지 셀프 체크
	// 동물보호소 규정(비지니스 로직)-> 메소드로 직접 만들어 
	//	ㄴ강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 분양받을 수 있습니다.	
	//  ㄴMember클래스의 isAdopt()에서 실행- instanceof연산 사용		
		
		String name="모모";
		int age = 17;
	    Member member = new Member(age, name);
		//Member클래스의 인스턴스 필드는 age, name 2개

		StringBuilder sb = new StringBuilder(name);		
		//String은 문자열 연결과 다른 문자열이 나오면 객체 새로 만들어 저장 -> StringBuilder
		//string은 불변객체이다. 값 못 바꿔
		//StringBuilder은 가변객체이다. 문자열 바꿀수있움
		//StringBuilder은 .append로 문자열을 추가해도 동일객체에 저장한다 
		// ㄴ문자열 연결연산에 사용한다 

		sb.append(" 회원님 \n");				//message += "회원님 \n"						//여기까지 모모회원님

		//boolean result;
		for(int i=0;i<animals.length;i++) {			//배열요소에 참조갑이 더이상 없으니 //animal.length은 4
			if(animals[i]==null) 
			//break;								// null(새))을 만나면 break
			continue;								// continue는 null(새)을 만나면 다음 명렁어들 실행 안하고 for문을 아예 다시 시작한다 
			      									// animals [7] = new Animal() 앵무새는 7번인까 4,5,6이 null이잖아 

			//result =member.isAdopt(animals[i]);	//인자를 animal타입으로 전달받는 메소드 (다형성 )
			 sb.append(animals[i].toString());	// /message += "animals[i].toString()"

			if(member.isAdopt(animals[i])) {
				sb.append("  😃 분양 가능합니다. \n");
			} else {
				sb.append("  😓 분양 자격이 안됩니다.\n");
			}
		
			//위의 if문을 아래의 삼항연산자( ? : )로 축약가능하다 
			String temp = member.isAdopt(animals[i]) ? "😃 분양 가능합니다. \n" : "😓 분양 자격이 안됩니다.\n";
			sb.append(temp);
		}
		System.out.println();
		System.out.println(sb);	//toString은 생략 가능하다

	}//main end
	
}







