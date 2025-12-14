2021145050 유정연

# 🎵 MoodMusic AI

텍스트 기반 감정 분석을 통해 사용자 기분에 맞는 음악을 추천하는  
**AI 기능을 가진 안드로이드 애플리케이션**입니다.

---

## 📌 프로젝트 소개
**MoodMusic AI**는 사용자가 입력한 문장을 분석하여  
감정 상태를 분류하고(긍정 / 중립 / 부정),  
해당 감정에 어울리는 음악을 추천해주는 앱입니다.

본 프로젝트는  
**「AI 기능을 가진 안드로이드 앱 설계」 과제**를 목적으로 제작되었습니다.

---

## 🤖 AI 기능 개요
- **입력 데이터**: 사용자 텍스트
- **분류 대상**: 감정 상태 (Positive / Neutral / Negative)
- **AI 방식**
  - 텍스트 키워드 기반 감정 분류 로직
  - TensorFlow Lite 적용이 가능한 구조로 설계
- **모델 유형**
  - Pre-trained 모델 구조를 참고한 텍스트 분류 설계

---

## ✨ 주요 기능
- 텍스트 입력을 통한 감정 분석
- 감정 분석 결과에 따른 음악 추천
- 감정별 음악 리스트 제공
- 음악 선택 시 YouTube 검색 페이지 연동
- Jetpack Compose 기반 UI 구성

---

## 🛠️ 사용 기술
| 구분 | 내용 |
|---|---|
| Language | Kotlin |
| UI | Jetpack Compose (Material3) |
| Architecture | MVVM |
| AI / ML | TensorFlow Lite (설계 기반) |
| Data Parsing | Gson |
| Async | Kotlin Coroutines |
| IDE | Android Studio |

---

## 📂 데이터셋 설명
- **데이터 위치**: `assets/music_list.json`
- **데이터 형식**: JSON
- **구성 내용**
  - 감정 상태별 음악 리스트
    - positive
    - neutral
    - negative
  - 음악 제목, 아티스트, YouTube 검색 URL 포함

### 🔄 데이터 처리 흐름
1. 사용자 텍스트 입력
2. 감정 분류 로직 실행
3. 분류 결과에 맞는 음악 리스트 로드
4. UI에 음악 추천 결과 출력

---

## 🖥️ 화면 구성
### 1️⃣ 메인 화면
- 사용자 감정 텍스트 입력
- 추천 버튼

### 2️⃣ 결과 화면
- 감정 분석 결과 표시
- 추천 음악 리스트 출력

### 3️⃣ 외부 연동
- 음악 선택 시 YouTube 브라우저 이동

---

## 📁 프로젝트 구조
com.example.moodmusicai
├─ data
│ ├─ MoodClassifier.kt
│ └─ MusicRepository.kt
├─ model
│ └─ Song.kt
├─ ui
│ └─ HomeScreen.kt
├─ ui.theme
└─ MainActivity.kt

📸 실행 화면

<img width="415" height="919" alt="스크린샷 2025-12-14 112033" src="https://github.com/user-attachments/assets/46990fea-982a-4190-af48-2ac89e1b272d" /><img width="408" height="918" alt="스크린샷 2025-12-14 112103" src="https://github.com/user-attachments/assets/de69d20f-b9cf-4f4c-84c4-621e23c08645" />
<img width="413" height="918" alt="스크린샷 2025-12-14 112136" src="https://github.com/user-attachments/assets/6052e036-d0ac-4a25-8bcb-4260f637eba7" /><img width="415" height="918" alt="스크린샷 2025-12-14 112200" src="https://github.com/user-attachments/assets/a2d6b9c3-1f2a-47dc-a8b4-995ef961561f" />




👩‍💻 개발자

이름: (유정연)

과목: 안드로이드프로그래밍응용

프로젝트: AI 기능을 가진 안드로이드 앱 설계
