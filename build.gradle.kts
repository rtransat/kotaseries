import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("com.vanniktech.maven.publish") version "0.25.3"
    id("org.jetbrains.dokka") version "1.9.10"
}

kotlin {
    group = "fr.rtransat"
    jvmToolchain(17)

    sourceSets {
        all {
            languageSettings.optIn("kotlinx.serialization.ExperimentalSerializationApi")
        }
    }
}


repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlinx", "kotlinx-serialization-json", "1.6.2")
    implementation("io.ktor", "ktor-client-core", "2.3.7")
    implementation("io.ktor", "ktor-client-okhttp", "2.3.7")
    implementation("io.ktor", "ktor-client-okhttp-jvm","2.3.7")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets.configureEach {
        externalDocumentationLink("https://api.ktor.io/")
        externalDocumentationLink("https://kotlinlang.org/api/kotlinx.serialization/")
    }
}

mavenPublishing {
    coordinates("io.github.rtransat", "kotaseries", "0.0.1")
    publishToMavenCentral(SonatypeHost.S01, true)
    signAllPublications()

    pom {
        name = "Kotaseries"
        description = "Betaseries API wrapper"
        inceptionYear = "2023"
        url = "https://github.com/rtransat/kotaseries/"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "rtransat"
                name = "Florent Sorel"
                url = "https://github.com/rtransat/"
            }
        }
        scm {
            url = "https://github.com/rtransat/kotaseries/"
            connection = "scm:git:git://github.com/rtransat/kotaseries.git"
            developerConnection = "scm:git:ssh://git@github.com/rtransat/kotaseries.git"
        }
    }
}
