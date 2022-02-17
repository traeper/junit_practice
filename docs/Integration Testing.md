## 3. Integration Testing

### 3.1 Overview
실제 애플리케이션 서버나 기타 인프라스트럭쳐에 연결하지 않고 integration testing을 하는 것은 중요하며 아래와 같은 테스트를 할 수 있습니다.
* The correct wiring of your Spring IoC container contexts.
* JDBC, ORM 등 data access. SQL 문의 정확성과 Hibernate 쿼리, JPA Entity 매핑 등을 테스트 할 수 있습니다.

### 3.2. Goals of Integration Testing
Spring의 integration testing support는 아래의 중요한 기능들을 제공하는 것을 목표로 하고 있습니다.

* To manage [Spring IoC container caching](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-ctx-management "") between tests.
* To provide [Dependency Injection of test fixture instances](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-fixture-di "").
* To provide [transaction management](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-tx "") appropriate to integration testing.
* To supply [Spring-specific base classes](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-support-classes "") that assist developers in writing integration tests.

#### 3.2.1. Context Management and Caching

기본적으로 ApplicationContext 한번 로드되면 각 테스트마다 재활용되어 객체 생성의 부하를 줄일 수 있습니다. 한 번의 test suite에 오직 한 번만 셋업되며 이후의 테스트 실행이 더욱 빨라집니다.
여기서 "test suite"라 함은 동일한 JVM에서 실행되는 모든 테스트들을 총칭하는 개념입니다. 드물지만 테스트가 응용 프로그램 컨텍스트를 손상시켜서 다시 로드해야 하는 경우, TestContext 프레임워크가 다음 테스트를 실행하기 전에 구성을 다시 로드하고 응용 프로그램 컨텍스트를 다시 빌드할 수 있습니다.

