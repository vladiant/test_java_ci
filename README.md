# Java CI/CD Example

[![CI](https://github.com/vladiant/test_java_ci/actions/workflows/ci.yml/badge.svg)](https://github.com/vladiant/test_java_ci/actions/workflows/ci.yml)
[![CodeQL](https://github.com/vladiant/test_java_ci/actions/workflows/codeql.yml/badge.svg)](https://github.com/vladiant/test_java_ci/actions/workflows/codeql.yml)

A simple Java project demonstrating the most common CI/CD patterns with **GitHub Actions**.

## Project structure

```
.
├── .github/
│   ├── dependabot.yml               # Automated dependency updates
│   └── workflows/
│       ├── ci.yml                   # Build, test, coverage & quality checks
│       ├── codeql.yml               # Security scanning (CodeQL)
│       ├── dependency-review.yml    # Dependency vulnerability review on PRs
│       └── release.yml              # Automated release pipeline
├── src/
│   ├── main/java/com/example/
│   │   ├── App.java                 # Entry point
│   │   └── Calculator.java          # Business logic
│   └── test/java/com/example/
│       └── CalculatorTest.java      # JUnit 5 unit tests
├── build.gradle.kts                 # Gradle build script (Kotlin DSL)
├── settings.gradle.kts              # Gradle settings
└── checkstyle.xml                   # Checkstyle rule configuration
```

## Requirements

- Java 21+
- Gradle 8+ (or use the included `./gradlew` wrapper)

## Build & run

```bash
# Compile, run tests, coverage check, SpotBugs and Checkstyle
./gradlew check

# Build the executable fat JAR
./gradlew assemble

# Run the application
java -jar build/libs/java-ci-example-1.0.0.jar
```

## CI/CD workflows

| Workflow | Trigger | Purpose |
|---|---|---|
| **CI** | push / pull_request → `main` | Build, test (Java 21 & 23), JaCoCo coverage, SpotBugs, Checkstyle |
| **CodeQL** | push / PR / weekly schedule | Static security analysis |
| **Dependency Review** | pull_request → `main` | Block PRs that introduce vulnerable dependencies |
| **Release** | push tag `v*.*.*` | Build, version-stamp and publish a GitHub Release |
| **Dependabot** | weekly schedule | Open PRs to keep Maven and Actions dependencies current |

## Tooling

| Tool | Purpose |
|---|---|
| [JUnit 5](https://junit.org/junit5/) | Unit testing |
| [JaCoCo](https://www.jacoco.org/) | Code coverage (≥ 80 % line coverage enforced) |
| [SpotBugs](https://spotbugs.github.io/) | Static bug analysis |
| [Checkstyle](https://checkstyle.org/) | Code style enforcement |
| [Shadow](https://gradleup.com/shadow/) | Fat/uber JAR packaging |
| [Codecov](https://codecov.io/) | Coverage reporting & trend tracking |

## License

[MIT](LICENSE)

