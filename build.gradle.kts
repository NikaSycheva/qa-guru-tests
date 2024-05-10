plugins {
    id("java")
    id("io.freefair.lombok") version "8.6"
    id("io.qameta.allure") version "2.11.2"
}

group = "otcuda.zvuk"
version = "1.0-SNAPSHOT"


allure {
    version.set("2.19.0")
    adapter {   //отвечает за появление папки аллюр резалт
        allureJavaVersion.set("2.19.0")

        autoconfigure.set(true)//обработка аннотации @Step
        autoconfigureListeners.set(true)
        aspectjWeaver.set(true)

        categoriesFile.set(layout.projectDirectory.file("config/allure/categories.json"))
        frameworks {
            junit5 {
                adapterVersion.set("2.19.0")
                enabled.set(true)

                autoconfigureListeners.set(true)
            }
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:7.3.1")
    testImplementation("com.github.javafaker:javafaker:1.0.2")
    testImplementation("io.qameta.allure:allure-selenide:2.19.0")
}

tasks.test {
    useJUnitPlatform()
}