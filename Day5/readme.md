# 5일차 미션

## 1. 데이터베이스 면접 단골질문
### 1. 데이터베이스의 특징에 대해 설명하시오

실시간 접근 가능  
지속적인 변화 CRUD 갱신 가능  
동시 공용 : 동시성 제어 필요  
내용에 의한  참조


### 2. 데이터베이스 언어(DDL, DML, DCL)에 대해 서술하시오

DDL : 데이터베이스를 정의하는 언어이며, 데이터리를 생성, 수정, 삭제하는 등의 데이터의 전체의 골격을 결정하는 역할을 하는 언어 입니다. 데이터베이스, 테이블등을 생성하는 역할을 합니다.  
DML : 정의된 데이터베이스에 입력된 레코드를 조회하거나 수정하거나 삭제하는 등의 역할을 하는 언어를 말합니다.  
DCL(Data Control Language, 데이터 제어어)  
GRANT<REVOKE<COMMIT<ROLLBACK

### 3. 트랜잭션이란 무엇인지 서술하시오

트랜잭션이란? 트랜잭션(Transaction 이하 트랜잭션)이란, 데이터베이스의 상태를 변화시키기 해서 수행하는 작업의 단위를 뜻한다.

## 2. SQL문 연습하기
### 1. SQL문으로 다음 조건을 만족하는 Student 테이블 생성하기
|컬럼명|데이터타입|조건|
|------|---|---|
|id|bigint|primary key, not null, auto increment|
|name|varchar|not null|
|class|varchar|미 입력시 default값인 'basic'으로 저장되도록 설정|

```mysql
CREATE TABLE Student(
    id BIGINT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    class VARCHAR(20) DEFAULT 'basic',
    PRIMARY KEY (id)
)
```

## 3. Student Entity로 연결하기

테이블 연결 성공 / 코드 정상적으로 작동합니다


