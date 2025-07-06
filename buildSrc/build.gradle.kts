plugins {
    `kotlin-dsl`
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(18))
}

repositories {
    google()
    mavenCentral()
}
