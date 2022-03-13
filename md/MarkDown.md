마크다운이란?
-
[마크다운](http://whatismarkdown.com/, "")은 텍스트 기반의 마크업언어로 2004년 존그루버에 의해 만들어졌으며 쉽게 쓰고 읽을 수 있으며 HTML로 변환이 가능하다. 특수기호와 문자를 이용한 매우 간단한 구조의 문법을 사용하여 웹에서도 보다 빠르게 컨텐츠를 작성하고 보다 직관적으로 인식할 수 있다.

---

제목 작성하기
-
# 제목 1
## 제목 2
### 제목 3
#### 제목 4
##### 제목 5
###### 제목 6


---

코드 하이라이트 기능 사용하기
-

### 자바코드
```java
public class Test {

    public static void main(String[] args) {
        System.out.println("코드 하이라이트 기능");
    }
}
```

### 자바스크립트 코드
```javascript
function javascriptFunction() {
    console.log("자바 스크립트 코드");
}
```

---

인용문구 사용하기
-

> 인용 문구
> > 인용 문구 겹치기

---

순서 있는 리스트 사용하기
-

1. 숫자 1
2. 숫자 2
3. 숫자 3

---

순서 없는 리스트 사용하기
-

* 요소 1
* 요소 2
* 요소 3


* 이런 식으로
    * 중첩 기능도 사용가능
        * 몇 번이고 중첩가능


---

링크 거는 방법
-

* 글자에 링크 덧 씌우기 => [강아지 사진](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=jubbigi&logNo=221510745354 "")
* 링크 그대로 사용하기 => <https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=jubbigi&logNo=221510745354>


---

글자 강조하기
-

* 기울이기
    * *기울이기*
* 굵은글자
    * **굵은글자**
* 코드지우기
    * ~~코드지우기~~

---

이미지 첨부하기
-

1. img html 태그를 넣어서 하는 방법
    1. <img src="https://mblogthumb-phinf.pstatic.net/MjAxOTA0MTFfMTU0/MDAxNTU0OTE2MTgxMjU1.wiIdy5YQWIRRI3uYwIjOQq0s7r0OMqKAZW6vjf3xCd8g.Ejy7adIC84d3A4Rh14_w8yhyzsOYmtXkEU4YVkNJQMYg.JPEG.jubbigi/%EA%B0%95%EC%95%84%EC%A7%80%EC%A7%A41.jpg?type=w800" width="100px" height="" alt="ㅋㅋㅋ"/>

2. 마크다운 오리지날 문법으로 이미지 넣기
   ![이미지](https://mblogthumb-phinf.pstatic.net/MjAxOTA0MTFfMTU0/MDAxNTU0OTE2MTgxMjU1.wiIdy5YQWIRRI3uYwIjOQq0s7r0OMqKAZW6vjf3xCd8g.Ejy7adIC84d3A4Rh14_w8yhyzsOYmtXkEU4YVkNJQMYg.JPEG.jubbigi/%EA%B0%95%EC%95%84%EC%A7%80%EC%A7%A41.jpg?type=w800)


---

줄바꿈 하기
-

마크다운 문법은 그냥 엔터를 누른다고 줄바꿈이 되지 않는다.  
줄   
바   
꿈
