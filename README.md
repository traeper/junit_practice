# Spring Testing

[Spring Testing 공식 문서](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-introduction, "Spring Testing")를 보면 Unit Testing, Integration Testing에 대한 소개가 되어 있으며 Spring Framework의 본질을 느낄 수 있는 내용들이 많아 번역/요약 해봤습니다.

## 2. Unit Testing
Spring의 DI를 이용하면 전통적인 Java EE보다 덜 의존적인 코드를 작성할 수 있습니다. 
Spring 철학을 따라서 아키텍처를 충실히 구현한다면 Clean Layering, Componentization을 달성할 수 있으며 Unit Testing을 더욱 쉽게 할 수 있을 것입니다.
예를 들어 service layer를 테스트 한다면 DAO/repository을 mocking하여 비교적 복잡한 persistent data에 access하지 않아도 테스트가 가능합니다. Spring Framework는 mock objects와 testing support classes를 지원합니다.

### 2.1. Mock Objects
* Environment : org.springframework.mock.env
* JNDI : org.springframework.mock.jndi
* Servlet API : org.springframework.mock.web, [MockMvc](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-mvc-test-framework, "")를 이용하여 Integration Testing을 작성하게 됩니다. 
* Spring Web Reactive : org.springframework.mock.http.server.reactive, [WebTestClient](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#webtestclient, "WebTestClient")를 이용하여 HTTP Server 없이 테스트 가능합니다. 

### 2.2. Unit Testing Support Classes
스프링에는 유닛 테스트를 위한 다양한 클래스가 있으며 아래 2가지 카테고리로 크게 나뉩니다.

* General Testing Utilities
* Spring MVC Testing Utilities

#### 2.2.1. General Testing Utilities
org.springframework.test.util 패키지에는 여러 활용수단들이 있습니다.

* ReflectionTestUtils : reflection을 활용한 method들을 모아놓은 클래스입니다.. reflection 기능들을 이용해서 non-public 요소(field, method에 configuration, lifecycle callback method, ..)들을 조작할 수 있습니다.
* AopTestUtils, AopProxyUtils : AOP 관련 util 모음

#### 2.2.2. Spring MVC Testing Utilities
org.springframework.test.web에는 Spring MVC 요소들을 테스트하기 위한 ModelAndViewAssert, MockHttpServletRequest, MockHttpSession 등이 제공됩니다. 
만약 WebApplicationContext와 관련된 Integration Testing을 하려면 [Spring MVC Test Framework](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-mvc-test-framework, "Spring MVC Test Framework")을 이용하면 됩니다. 주로 웹 실무 개발 테스트를 작성할 때는 MockMvc, WebTestClient를 이용하는 편입니다.