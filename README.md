# 기능

- 20200905
    - ✅ 회원가입
      - 중복 가입 불가 (DB에서 처리)
      - spring validation 추가 예정
        
    - ✅ 로그인
      - 스프링시큐리티 활용 

    - ✅ 로그아웃
      - 스프링시큐리티 활용

    ####
- 20200906
    - ✅ 맞춤 정보 설정
      - 로그인 여부 확인 후, 정보 수정 

    ####
- 20200907
    - ✅ 내 프로필 설정
      - 닉네임 변경, 개인 사이트, 한줄 소개글 등록
    - 일부 페이지 접근제어. (signup, login 제외한 /user/*)
    - 회원가입  spring validation 추가. 

   ####
- 20200908
    - 사진 업로드 [ 미완 ]
    - model들 lombok 사용하게 수정

  ####
- 20200925
    - ✅ JWT
      - 기존 세션 로그인을 JWT 방식으로 변경
      - JWT 토큰에 사용자 email 대신 idx 저장되게 변경.

  ####
- 20200926
    - ✅ JWT 토큰에 사용자 idx 값 저장 방식 변경.
    - 사진 업로드 [ 완성 ]

  ####
- 20200930
    - ✅ 사진 업로드 기능 [ 완성 ]