package com.example.temisdk;
import java.util.Map;
import com.robotemi.sdk.Robot;

public class Server {
    private Robot robot;

    public Server() {
        robot = Robot.getInstance();
    }

    public void processApiResponse(Map<String, String> apiResponse) {
        String location = apiResponse.get("location");

        if (location != null) {
            TemiController temiController = new TemiController();
            temiController.moveToLocation(location);
        } else {
            // 기타 처리 로직
            // 예시로서 'a', 'b', 'c' 이외의 경우에는 여기에 추가적인 로직을 구현할 수 있습니다.
        }
    }
}

class TemiController {
    private Robot robot;

    public TemiController() {
        robot = Robot.getInstance();
    }

    public void moveToLocation(String location) {
        if (location.equals("a")) {
            // 'a'로 지정된 위치로 이동
            robot.goTo("a");
        } else if (location.equals("b")) {
            // 'b'로 지정된 위치로 이동
            robot.goTo("b");
        } else if (location.equals("c")) {
            // 'c'로 지정된 위치로 이동
            robot.goTo("c");
        } else {
            // 서버에서 위치 파라미터 안 받으면 움직이지 않기
        }
    }
}
