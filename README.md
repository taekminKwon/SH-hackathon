# 🧠 SH-Hackathon Server

Spring Boot와 Django가 함께 구성된 백엔드 프로젝트입니다.  
Docker Compose를 통해 PostgreSQL과 함께 통합 실행할 수 있도록 구성되어 있습니다.

---

## 📁 프로젝트 구조

```
hack/
├── .env                      # 환경 변수 설정 파일
├── docker-compose.yml        # 서비스 통합 실행 스크립트
├── server/                   # Spring Boot 프로젝트
│   ├── Dockerfile            # 멀티 스테이지 빌드 설정
│   └── ...                  
├── django-app/               # Django 프로젝트
│   ├── Dockerfile            # Django용 Dockerfile
│   └── manage.py 등          
├── db/                       # PostgreSQL 데이터 디렉토리 (Git 추적 제외)
└── README.md
```

---

## ⚙️ 사용 기술 스택

- **Java 17**, **Spring Boot 3**

- **Python 3.11**, **Django 4**

- **PostgreSQL 15**

- **Docker & Docker Compose**

- Gradle, psycopg2, JPA, REST API, etc.

---

## 🛠️ 서버 실행 방법

아래 명령어 한 줄로 모든 서비스가 실행됩니다.  
(사전 조건: **Docker** 및 **Docker Compose**가 설치되어 있어야 합니다.)

```bash
docker compose up --build
```

> 루트 디렉토리(`docker-compose.yml`이 위치한 곳)에서 실행합니다.  
> 아래 3개의 서비스가 자동으로 실행됩니다:
> 
> - PostgreSQL (DB)
> 
> - Spring Boot (백엔드 API)
> 
> - Django (예: 관리자 서비스)

---

### ✅ 실행 확인

| 서비스         | 주소                                              |
| ----------- | ----------------------------------------------- |
| Spring Boot | [http://localhost:8443](http://localhost:8443/) |
| Django      | [http://localhost:8000](http://localhost:8000/) |
| PostgreSQL  | 내부 컨테이너 `db:5432` 통해 접근                         |

> 로그에 `Started Application`, `Starting development server at...` 문구가 출력되면 성공입니다.

---

### 🛑 서버 종료

```bash
docker compose down
```

> 모든 컨테이너를 종료합니다.  
> 볼륨까지 삭제하려면:

```bash
docker compose down -v
```

---

## 📄 환경 변수 예시 (.env)

```env
# PostgreSQL
POSTGRES_DB=mydb
POSTGRES_USER=myuser
POSTGRES_PASSWORD=mypassword

# Spring Boot
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/mydb
SPRING_DATASOURCE_USERNAME=myuser
SPRING_DATASOURCE_PASSWORD=mypassword
SPRING_BOOT_PORT=8443

# Django
DJANGO_PORT=8000
DJANGO_DB_PORT=5432
```

---

## 🙌 푸시 방법

1. 브랜치 생성: `git checkout -b feat/기능명`

2. 작업 후 커밋: `git commit -m "feat: 작업 내용 설명"`

3. 원격 푸시: `git push origin feat/기능명`

4. GitHub에서 Pull Request 생성
