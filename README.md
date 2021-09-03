
# 에어비엔비 프로젝트

사용 언어 : <img src="https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=Kotlin&logoColor=white">

### :wrench: 기능설명

+ Naver Map APi를 이용하여 지도를 띄운다.
+ 내 위치를 받아와 화면을 이동해준다.
+ Mock API에서 예약가능 숙소 목록을 받아와서 지도에 표시한다.
+ BottomSheetView를 활용하여 예약 가능 숙소목록을 볼 수 있다.
+ ViewPager2를 활용하여 현재 보고 있는 숙소로 지도가 움직이며 간단한 섬네일 정보를 볼 수 있다.
+ 숙소 버튼을 눌러 숙소의 장보를 앱 외부로 공유 가능하다.

***

### :lollipop: 완성 화면

<img src = "https://user-images.githubusercontent.com/48902047/131960264-c355d2aa-df56-4b62-b54f-216c684aded5.jpg" width="20%" height="20%">   <img src = "https://user-images.githubusercontent.com/48902047/131966752-f643302f-67e8-45db-b0cd-ba03cc813b75.jpg" width="20%" height="20%">   <img src = "https://user-images.githubusercontent.com/48902047/131966853-1d287878-c9c0-4942-8395-dec79bc516db.jpg" width="20%" height="20%">   <img src = "https://user-images.githubusercontent.com/48902047/131966896-57e04181-8b45-4b1a-9022-0d5295a7909d.jpg" width="20%" height="20%">

***
####  Naver Map APi 활용

1. 기본 구성으로 [NaverCloudPlatfrom](https://www.ncloud.com/)에서 신청을 하여 clientID를 받아와 라이브러리와 몇가지 추가를 통해 메인 화면에 구성하였습니다.

2. Map의 기본 세팅은 **mapView.getMapAsync** 를 통해  OnMapReadyCallback의 인터페이스를 받아와 기본 정보를 세팅하였습니다.

+ 기본세팅
  + 초기 주소값 -> 강남역
  +  권한 코드 불러오기(내 위치를 불러오기) -> 안드로이드 버젼이 업데이트 후 팝업을 띄워 물어봐야 한다.
  +  retrofit 정보를 불러오는 함수

####  Mock API를 서버에 업로드 후 retrofit으로 정보 가져오기

1. house.json이라는 파일을 만들어 해당정보를 Mock사이트에 올려 주소를 받아옵니다.
+ 강남역에서 아무곳이나 찍어 위도경도를 받은 후 작성하였습니다.
+ 사진은 picsum이란 사이트를 이용하여 더미 사진을 불러왔습니다.
+ 해당 만든 json 형식의 정보를 서버에서 내려준 것 처럼 가져 올 수 있다. [만든사이트](http://run.mocky.io/v3/511c37d3-79c1-455f-9efb-98b5d594e640)

2. 안드로이드를 돌아와서 해당 정보를 받아올 수 있게 세팅 합니다.
+ Housedto.java : items를 리스트 형으로 받아올 수 있게 해주는 모델
+ HouseModle.java : item에 담겨 있는 정보들을 설정해 줍니다.
+ HouseService.java : api정보(json형식)를 불러와서 해당정보를 불러온다.
+ MainActivity 에서 getHouseListFromAPI 함수 : 해당 정보를 불러와 마커를 찍어주고 viewPagerAdapter 에 정보를 넘겨주는 함수

####  BottomSheetView를 활용하여 예약 가능 숙소목록 보기
1. 올렸다 내렸다 해야하기 위해 Coordinatelayout을 이용하였습니다. (Coordinatelayout는 Framelayout의 진화형)
2. 리스트들을 볼 수 있어야 하므로 하단은 Recyclerview로 세팅하였습니다.
+ bottom_sheet.xml : view의 기본 세팅
+ top_radius_white_background.xml : 상단 백그라운드의 라운드를 깎아주고 배경색을 흰색으로 지정
+ HouseListAdapter.java : 리사이클러뷰에 보여질 아이템 어뎁터
+ item_house.xml : 아이템 기본 xml


#### ViewPager2를 활용하여 현재 보고 있는 숙소로 지도가 움직이며 간단한 섬네일 정보보기
기본적으로 ViewModel은 이전 버젼이고 ViewPager2이므로 일단 이걸 선택했다.(뭐 JetPack 사용해봐야 하기도 했고....:confused:)
( ViewPager는 PagerAdapter 기반으로 구성되어있는데 스크롤을 진행할 때 마다 instantiateItem() 와 destroyItem() 메서드가 호출되기 때문에 스크롤 할 때 버벅거리는 현상이 나타나서 라던데
흐음....:neutral_face: 조치원 수호대를 ViewPager 를 써봤는데 진짜 사알짝 멈추는 느낌이 있긴 했는데 그건가..??)

+ item_house_detail_for_viewpager.xml : viewPager의 기본 xml
+ HouseListAdapter.java : viewpager의 기본 세팅 
+ MainActivity 에서 getHouseListFromAPI 함수 : 해당 정보를 불러와 마커를 찍어주고 viewPagerAdapter 에 정보를 넘겨주는 함수
+ MainActivity의 viewPager.registerOnPageChangeCallback : 뷰페이져를 바꿀떄마다 해당정보로 찍혀있는 마커로 카메라가 이동된다.

***

### :paperclip: 소감
먼저 코틀린을 이용한 프로젝트이므로 (물론 예제 코드를 보고 공부한 거지만 ㅎ :kissing_heart:) 다 아는 내용을 코틀린으로 해보니까 어려웠다.

그치만 나름 자바보다 코틀린이 더 쉬운 언어인건 확실하고 SPring에서 제공하는 lombok과 비슷한 느낌이였다.

또한 이번 프로젝트에서 값지게 알아낸것이 retrofit 활용에 대해 정확히 어떻게 써야 하는지 알게 되서 좋았다. ㅎ
