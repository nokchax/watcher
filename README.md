# watcher

### Concept
주기적으로 패이지 크롤링하여 텔레그램 봇으로 알림
이때, 크롤링하는 페이지와 타겟을 텔레그램 명령어를 통해 자유롭게 설정할 수 있도록 한다.


crawl target이 가지는 속성
- page
- target element
- compare type (exact, like, etc..)
- period
- prev data


### using library
- jsoup
- telegrambots
- etc

### config example
ex) www.nokchax.net / .class #id tag / exact
