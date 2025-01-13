plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "experienced.dev"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Spring
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.3")
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Other
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	//Test dependencies
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework:spring-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks {
	named<Jar>("jar") {
		enabled = false
	}
}
