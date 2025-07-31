
## 🧠 SH-Hackathon Server

Spring Boot, Django, PostgreSQL을 통합한 백엔드 프로젝트입니다.  
Nginx를 리버스 프록시로 구성하여 `/api`는 Spring Boot, `/django`는 Django, `/`는 Flutter 정적 화면을 제공하도록 설계되었습니다.

---

## 📁 프로젝트 구조
```

hack/  
├── .env # 환경 변수 설정 파일  
├── docker-compose.yml # 통합 실행 스크립트  
├── nginx/ # Nginx 설정  
│ └── default.conf # 라우팅 및 정적 파일 프록시 설정  
├── flutter-web-build/ # Flutter 빌드 결과물 (index.html 등)  
├── server/ # Spring Boot 프로젝트  
│ ├── Dockerfile  
│ └── ...  
├── django-app/ # Django 프로젝트  
│ ├── Dockerfile  
│ └── manage.py 등  
├── db/ # PostgreSQL 데이터 디렉토리 (Git 추적 제외)  
└── README.md

```
---

## ⚙️ 사용 기술 스택

- **Java 17**, **Spring Boot 3**
- **Python 3.11**, **Django 4**
- **PostgreSQL 15**
- **Docker & Docker Compose**
- **Nginx (Reverse Proxy)**
- Gradle, psycopg2, JPA, REST API, etc.

---

## 🛠️ 서버 실행 방법

아래 명령어 한 줄로 모든 서비스가 실행됩니다.  
(사전 조건: **Docker** 및 **Docker Compose**가 설치되어 있어야 합니다.)

```bash
docker compose up --build
```

> 루트 디렉토리(`docker-compose.yml`이 위치한 곳)에서 실행합니다.  
> 실행되는 주요 서비스:
> 
> - `db` : PostgreSQL 15
> 
> - `app` : Spring Boot (내부 포트 8080 → `/api`로 접근)
> 
> - `django` : Django 앱 (내부 포트 8000 → `/django`로 접근)
> 
> - `nginx` : 포트 80으로 모든 요청 수신 (Flutter 정적 페이지 포함)

---

### ✅ 실행 경로 확인

| 경로           | 설명              |
| ------------ | --------------- |
| `/`          | 웹 정적 화면         |
| `/api/**`    | Spring Boot API |
| `/django/**` | Django 서비스      |

예시:

- `http://localhost/` → Flutter index.html

- `http://localhost/api/hello` → Spring Boot API

- `http://localhost/django/admin` → Django 관리자 페이지

---

### 🛑 서버 종료

```bash
docker compose down
```

> 모든 컨테이너를 종료합니다.

```bash
docker compose down -v
```

> 데이터 볼륨까지 삭제할 경우 사용

---

## 📄 환경 변수 예시 (.env)

```env
# PostgreSQL
PSQL_PORT=5432
POSTGRES_DB=mydb
POSTGRES_USER=myuser
POSTGRES_PASSWORD=mypassword

# Spring Boot
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/mydb
SPRING_DATASOURCE_USERNAME=myuser
SPRING_DATASOURCE_PASSWORD=mypassword
SPRING_BOOT_PORT=8080

# Django
DJANGO_PORT=8000
DJANGO_DB_PORT=5432

# Nginx
NGINX_PORT=80
```

---

## 🙌 Git 작업 흐름

```bash
# 1. 새 브랜치 생성
git checkout -b chore/nginx

# 2. 작업 후 커밋
git commit -m "chore: nginx 설정 리팩토링"

# 3. 원격 브랜치 푸시
git push origin chore/nginx

# 4. GitHub에서 Pull Request 생성
```
