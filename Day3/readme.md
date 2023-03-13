# 3일차 정리

## 문자열 리턴하는 GET API 생성하기

다음과 같은 방식으로 StringGetController를 생성한 후,

```java
@Slf4j
@RestController
public class StringGetController {

    @GetMapping("/name")
    public String myName(){
        log.info("------- log test name --------");
        return "김윤식";
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public String getFoos(@PathVariable("id") String name) {
        log.info("----- log test pathvariable-----");
        return name;
    }

}
```
코드를 입력하였다

코드 구성 요소를 하나씩 알아보겠다.

### @RestController

```@Controller``` 는 반환값이 String인 경우 뷰 이름으로 인식되어, 뷰를 찾고 렌더링 함.
```@RestController```는 반환값으로 뷰를 찾는 것이 아니라, HTTP 메세지 바디에 바로 입력
```@ResponseBody``` 와 연관 있음


### HTTP 메서드 매핑

```java
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/mapping-get", method = RequestMethod.GET)
public String mappingGet(){
    log.info("mappingGet via @RequestMapping");
    return "ok";
    }
```

해당 urlPath로 POST 요청이 오는 경우 MVC는 HTTP 405 코드를 반환한다.

### 위 메서드의 축약형

```java
import org.springframework.web.bind.annotation.GetMapping;

@GetMapping(value = "/mapping-get-abbreviated")
public String mappingGet(){
    log.info("mappingGet via @GetMapping");
    return "ok";
    }
```

### PathVariable 사용

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@GetMapping("/mapping/{number}")
public String mappingPath(@PathVariable("userId") String data){
    log.info("mappingPAth userId = {}", data);
    return "ok";
    }

@GetMapping("mapping/admins/{adminId}/employees/{employeeId}")
public String mappingPath(@PathVariable String adminId, @PathVariable Long orderId){
    log.info("mappingPath userId={}, orderId={}", userId, orderId);
    return "ok";
    }
```



