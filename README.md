## 🛠️ 서버 실행 방법

아래 순서를 따라하면 로컬에서 서버를 실행할 수 있습니다.  
(사전 조건: **Docker** 및 **Docker Compose**가 설치되어 있어야 합니다.)

---

### 1️⃣ `server` 디렉토리로 이동

```bash
cd server
```

> 백엔드 프로젝트가 위치한 `server` 폴더로 이동합니다.

---

### 2️⃣ Spring Boot 애플리케이션 빌드

```bash
./gradlew bootjar
```

> `bootjar` 명령어를 실행하여 실행 가능한 `.jar` 파일을 생성합니다.  
> 해당 파일은 `build/libs` 경로에 생성됩니다.

💡 만약 권한 문제가 발생한다면 아래 명령어로 실행 권한을 부여해 주세요:

```bash
chmod +x ./gradlew
```

---

### 3️⃣ Docker 이미지 빌드

```bash
docker build -t my-app:latest .
```

> 현재 디렉토리(`server`)에 있는 `Dockerfile`을 기반으로 Docker 이미지를 빌드합니다.  
> 이미지 이름은 `my-app:latest`입니다.

---

### 4️⃣ 상위 디렉토리(`hackathon`)로 이동

```bash
cd ..
```

> `docker-compose.yml` 파일이 위치한 디렉토리로 이동합니다.

---

### 5️⃣ Docker Compose로 컨테이너 실행

```bash
docker-compose up --build -d
```

> 여러 컨테이너를 동시에 실행합니다.
> 
> - `--build`: 이미지가 없거나 변경 사항이 있을 경우 재빌드합니다.
> - `-d`: 백그라운드 모드로 실행합니다.

---

### 6️⃣ 서버 실행 확인

브라우저에서 아래 주소로 접속하여 서버가 정상적으로 작동하는지 확인합니다:

```
http://localhost:8443
```

✅ 메인 페이지나 API 응답이 잘 뜬다면 성공입니다!
