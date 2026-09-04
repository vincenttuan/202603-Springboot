# 上課講義
https://docs.google.com/document/d/1Ty8AeuoDcs-u8OzMYncGBxc9ASlI-8Pa3yaYD0fF_7E/edit?usp=drive_link

# 租用設備專題
# 建立資料庫
CREATE DATABASE rental_db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

# 安裝 Maven 
<pre>
1. 到 Maven 官方下載頁下載 Binary zip：
https://maven.apache.org/download.cgi
  
* 找到 apache-maven-3.9.x-bin.zip 並下載

2. 解壓縮到例如：
C:\tools\apache-maven-3.9.16

3. 設定環境變數
新增系統變數：
MAVEN_HOME=C:\tools\apache-maven-3.9.16

然後在 Path 加入：
%MAVEN_HOME%\bin
</pre>

# 啟動後端
cd backend-rental <br />
mvn spring-boot:run

# 啟動前端
cd frontend-rental <br />
npm install <br />
npm run dev
