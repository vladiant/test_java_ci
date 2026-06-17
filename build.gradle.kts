import com.github.spotbugs.snom.SpotBugsTask

plugins {
    java
    jacoco
    checkstyle
    id("com.github.spotbugs") version "6.0.26"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.example"
version = project.findProperty("projectVersion") as String? ?: "1.0.0"

val javaToolchainVersion = (project.findProperty("javaToolchainVersion") as String?)?.toInt() ?: 21

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(javaToolchainVersion)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:6.1.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// ── Tests ─────────────────────────────────────────────────────────────────────

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

// ── JaCoCo ────────────────────────────────────────────────────────────────────

jacoco {
    toolVersion = "0.8.12"
}

val jacocoExcludes = listOf("**/App.class")

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    classDirectories.setFrom(
        files(sourceSets.main.get().output.classesDirs).asFileTree.matching {
            exclude(jacocoExcludes)
        }
    )
    reports {
        xml.required = true
        html.required = true
    }
}

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport)
    classDirectories.setFrom(
        files(sourceSets.main.get().output.classesDirs).asFileTree.matching {
            exclude(jacocoExcludes)
        }
    )
    violationRules {
        rule {
            limit {
                counter = "LINE"
                value = "COVEREDRATIO"
                minimum = "0.80".toBigDecimal()
            }
        }
    }
}

tasks.check {
    dependsOn(tasks.jacocoTestCoverageVerification)
}

// ── Checkstyle ────────────────────────────────────────────────────────────────

checkstyle {
    toolVersion = "10.17.0"
    configFile = file("checkstyle.xml")
    isIgnoreFailures = false
}

// ── SpotBugs ──────────────────────────────────────────────────────────────────

spotbugs {
    toolVersion.set("4.8.6")
    ignoreFailures.set(false)
}

tasks.withType<SpotBugsTask>().configureEach {
    reports.maybeCreate("html").required.set(true)
    reports.maybeCreate("xml").required.set(false)
}

// ── Fat JAR ───────────────────────────────────────────────────────────────────

tasks.shadowJar {
    archiveClassifier = ""
    manifest {
        attributes["Main-Class"] = "com.example.App"
    }
}

tasks.assemble {
    dependsOn(tasks.shadowJar)
}
