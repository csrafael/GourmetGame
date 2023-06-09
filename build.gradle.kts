plugins {
    id("java")
    id ("application")
}

application {
    mainClassName = "org.example.Main"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    testImplementation("junit:junit:4.13.1")
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    testCompileOnly("org.projectlombok:lombok:1.18.26")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.26")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:3.+")
}

tasks.test {
    useJUnitPlatform()
}
