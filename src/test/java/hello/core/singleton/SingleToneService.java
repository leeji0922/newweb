package hello.core.singleton;

public class SingleToneService {

    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingleToneService instance = new SingleToneService();

    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingleToneService getInstance() {
        return instance;
    }
    //3. 타 클래스에서 new 키워드로 생성 못하게 막는 역할
    private SingleToneService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
