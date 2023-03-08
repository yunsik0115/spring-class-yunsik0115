# JSCode 1주차 월요일 공부한 내용 기록


##1. 깃 사용을 위한 준비

git이 설치되어 있다 가정하고

```
git config --global user.name "홍길동"
git config --global user.email "youremail@domain.com"
```
으로 전역설정을 마무리 한 뒤,

```
Git remote add origin [본인의 git repository 주소]
Git commit add .
Git commit -m "커밋 메시지"
Git push origin main
```
으로 생성한 파일을 스테이징 한 뒤, 커밋하고 푸시를 통해 리포지토리에 업로드 할 수 있다.

----

## 2. 브랜치
독립적으로 어떤 작업을 진행하기 위한 개념.
각각의 브랜치는 다른 브랜치의 영향을 Merge하기 전까지 받지 않음.

여러명이서 협업을 수행할 때 다른 사람의 작업이나 다른 사람이 내 작업에 영향을 주지 않도록
메인 브랜치에서 자신의 작업 전용 브랜치를 만들고, 작업이 끝난 사람은 merge를 통해
main 브랜치에 자신의 변경사항을 적용함.

Master 브랜치의 이름이 원래는 기본값이였는데, 최근 main으로 이름이 바뀜

### 브랜치 생성

다음과 같은 명령어를 통해 Git Branch의 생성이 가능함
```
Git branch <branchname>
```

그리고 다음과 같은 명령어를 통해 Git Branch의 전체 목록을 조회할 수 있음
```
Git branch
```

다음과 같은 명령어를 통해 branch를 생성함과 동시에 해당 branch로의 이동이 가능함
```
Git checkout -b <branch>
```


### 브랜치 병합
브랜치의 병합은 merge 명령어를 통해 실행함.
명령어에 병합할 커밋 이름을 넣어 실행, 지정한 커밋 내용이 HEAD(현재) 가리키고 있는 브랜치에 넣어짐.
HEAD가 Merge될 (즉 Merge 되어져 최종적으로 효과를 반영해야할) 브랜치에 위치해야 함.

예시는 HEAD를 Main에 위치하게 한 뒤, feature/day1 브랜치를 병합하는 과정을 나타냄

```
Git checkout main
Git merge feature/day1
```

하게 되면 master 브랜치가 가리키는 커밋이 issue1과 같은 위치로 이동하게 됨. 
이런 방식의 병합을 fast-forward(빨리감기) 병합이라고 함.

마지막 병합 명령을 취소하는 방법
```
Git reset --hard HEAD-
```

### 브랜치 삭제

```
Git branch -d <branchname>

Git branch -d issue1
```

### rebase를 통한 병합

Rebase? : base를 재설정, 하나의 브랜치가 다른 브랜치에서 파생되어 나온 경우,
다른 브랜치에서 진행된 커밋을 다시 가져와서 base를 재설정하는것.

브랜치를 병합할 때 rebase를 먼저 실행한 뒤 병합한다면, 그 **이력**을 하나의 줄기로 만들 수 있음

```
Git checkout feature/day1
Git rebase master
```

### fetch
원격 저장소의 최신 이력을 사용할 수 있음, 이때 최신 커밋 이력은 이름 없는 브랜치로 로컬에 가져오게 됨.
해당 명령어를 실행한 이후 merge하기를 원할 경우, FETCH_HEAD 브랜치를 merge하거나 다시 pull을 실행하면 됨.



### 태그
커밋을 차모하기 쉽도록, 알기 쉬운 이름을 붙이는 것을 말함.

Git에서는 일반적으로 두 종류의 태그를 사용.

1) 일반 태그 : 이름만 지정 가능
2) 주석 태그 : 이름 + 태그에 대한 설명 + 서명 + 태그 생성자, 만든 날짜정보 포함 가능

보통 릴리즈 브랜치에서는 주석 태그를 사용함
로컬에서는 일반태그 사용

태그를 지정하여 checkout하거나 reset하여 간단하게 과거의 특정 상태로 되돌리기 가능

```
Git add myfile.txt
Git commit -m "first commit"
Git tag apple
```

위 코드는 커밋한 이후 HEAD가 가르키는 커밋에 'apple'이라는 태그를 지정한 것.
파라미터 없이 tag 실행시 태그 목록을 볼 수 있음.

```--decorate``` 옵션 사용시 태그 정보를 포함한 이력의 확인이 가능함.

#### 주석 달린 태그 추가

```
Git tag -a <tagname>

Git tag -am <commit message> <tagname>
```

#### 태그 제거

```
Git tag -d <tagname>
```

### 커밋 변경

```--amend``` 옵션을 통해 이전에 커밋했던 내용에 새로운 내용 추가 / 설명 수정 가능

```revert``` 명령어를 통해 특정 커밋의 내용을 삭제할 수 있음


```reset``` 명령어를 통해 더 이상 필요 없어진 커밋들을 버릴 수 있음

Soft - Head의 위치 변경함, 인덱스 변경 안함, 작업트리 변경 안함
(커밋만 되돌리고 싶을 때)
Mixed - Head의 위치 변경함, 인덱스 변경함, 작업트리 변경 안함
(변경한 인덱스의 상태를 원래대로 되돌리고 싶을때)
Hard - Head의 위치 변경함, 인덱스 변경함, 작업트리 변경함
(완전히 커밋을 버리고, 이전 상태를 되돌리고 싶을때) - 왠만하면 사용하지 않는게...?


```cherry-pick``` 을 이용하면 다른 브랜치에서 지정한 커밋을 **복사**하여 현재 브랜치로 가져올 수 있음.

```rebase -i``` 옵션을 통해 커밋을 다시 쓰거나 다른 커밋과 바꿔 넣을 수 있으며
특정 위치의 커밋을 삭제하거나 여러 커밋을 하나로 통합하는 작업을 할 수 있습니다.


```merge --squash``` 옵션 지정을 통해 브랜치 병합시, 해당 브랜치의 커밋 전체를 통합한 커밋이 추가됨.
이 옵션으로 브랜치 병합시, 해당 브랜치의 커밋 전체를 통합한 커밋이 추가됨.


