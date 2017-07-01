import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

buildscript {
    val springBootVersion: String = "1.5.4.RELEASE"
    repositories {
        maven { setUrl("https://repo.gradle.org/gradle/repo") }
        maven { setUrl("https://repo.spring.io/snapshot") }
        maven { setUrl("https://repo.spring.io/milestone") }
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath(kotlin("gradle-plugin"))
        classpath(kotlin("allopen"))
        classpath(kotlin("noarg"))
    }
}

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    maven { setUrl("https://repo.gradle.org/gradle/repo") }
    maven { setUrl("https://repo.spring.io/snapshot") }
    maven { setUrl("https://repo.spring.io/milestone") }
}

configure<DependencyManagementExtension> {
    val springBootVersion: String = "1.5.4.RELEASE"
    val springCloudVersion: String = "Dalston.SR1"
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

dependencies {
    compile(kotlin("stdlib-jre8"))
    compile(kotlin("reflect"))
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-actuator")
    compile("org.springframework.cloud:spring-cloud-starter-eureka-server")
}

