plugins {
	java
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
	id("com.github.bjornvester.wsdl2java") version "2.0.2"
}

group = "rest-api"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	}

wsdl2java {
	wsdlDir.set(layout.projectDirectory.dir("src/main/resources/wsdl"))
}

tasks.withType<Test> {
	useJUnitPlatform()
}
