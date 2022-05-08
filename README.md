# vendingmachine
작은 시스템을 만들며 캡슐화에 관점을 두어 진행
 * getter setter 사용 x 
 * void 타입의 리턴을 통한 객체의 변화에 대한 안전성(호출부에서는 함수를 호출하는것으로 끝이난다 -> 비즈니스 로직의 변화로 인해 코드수정이 필요시 수정부분이 집약적)?? 보장 

next step
스프링을 이용한 웹 환경으로 발전시키고 db를 사용하는 환경으로 개발
 - prob 1 : getter setter 가 없을때 정상적으로 동작할지 ? jackson 라이브러리와 mybatis 또는 jpa 의 데이터 매핑 과정을 디버거를 통해 직접 확인
 - prob 2 : 현재 만들어지는 Item 객체는 quantitiy의 상태가 계속 변함으로 VO 로써의 사용이 적절치 못하다. Item 을 VO로 사용하기 위해서는 어떻게 개선 해야할까
