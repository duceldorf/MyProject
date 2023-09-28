plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.8.0")
    implementation("com.codeborne:selenide:6.18.0")
    implementation("io.qameta.allure:allure-selenide:2.24.0")
    implementation("io.qameta.allure:allure-testng:2.24.0")
    implementation("io.qameta.allure:allure-rest-assured:2.24.0")
    //implementation("io.qameta.allure:allure-gradle:2.5")
    testImplementation("io.rest-assured:rest-assured:5.3.2")
    runtimeOnly("org.aspectj:aspectjweaver:1.9.19")
}

tasks.test {
    useTestNG()
    /*filter {
        //include specific method in any of the tests
        includeTestsMatching("somepack.ExampleTests")
    }*/
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}