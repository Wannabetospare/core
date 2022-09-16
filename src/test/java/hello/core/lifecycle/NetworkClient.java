package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient  {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }
    //서비스 시작시 호출
    public void connect() {

        System.out.println("connect: " + url);
    }
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }


    /*

    스프링 컨테이너 빈의 라이프 사이클 (빈이 생성되고 사용되고 소멸하는 과정)

    컨테이너 생성 > 빈 생성 > 의존관계 주입 > 초기화 콜백 > 사용 > 소멸전 콜백 > 스프링 종료

    */



    


    // 빈이 초기화된 시점을 알려주는 어노테이션
    // 초기화 콜백 - 빈이 생성되고, 빈의 의존관계 주입이 완료된 후에 호출
    // 빈의 초기화 부분이며, 빈이 생성된 후 별도의 초기화 작업을 위해 실행하는 메서드라고 선언
    // 이 방법을 쓰는것을 권장한다.
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결메세지");

    }


    // 소멸되기 직전의 시점을 알려주는 어노테이션
    // 소멸전 콜백 - 빈이 소멸되기 직전에 호출
    // 스프링 컨테이너에서 빈을 제거하기전에 해야 할 작업이 있을때 실행하는 메서드라고 선언
    // close() 전에 선언
    // 이 방법을 쓰는것을 권장한다.
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
