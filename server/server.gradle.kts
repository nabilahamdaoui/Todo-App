import org.springframework.boot.gradle.tasks.run.BootRun

val localDependency by configurations.creating // Custom configuration for local dependencies
val prodDependency by configurations.creating // Custom configuration for prod dependencies

plugins {
    java
    id("org.springframework.boot") version "2.5.0"
}

apply(plugin = "io.spring.dependency-management")


repositories {
    mavenCentral()
}

tasks {
    getByName<BootRun>("bootRun") {
        val springProfiles: String by project
        systemProperty("spring.profiles.active", springProfiles)

        doFirst {
            if(springProfiles.contains("local")) {
                classpath += localDependency
            }
            if(springProfiles.contains("prod")) {
                classpath += prodDependency
            }
        }
    }
}


dependencies {
    localDependency("com.h2database:h2")
    prodDependency("mysql:mysql-connector-java")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("com.h2database:h2")
}

