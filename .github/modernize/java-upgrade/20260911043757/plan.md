# Upgrade Plan: parabank-ui-automation (20260911043757)

- **Generated**: 2026-09-11
- **HEAD Branch**: main
- **HEAD Commit ID**: available through repository status at planning time

## Available Tools

**JDKs**
- JDK 17.0.19: `C:\Users\Dhrub Chatterjee\AppData\Local\Programs\Eclipse Adoptium\jdk-17.0.19.10-hotspot` (current project JDK, used for baseline)
- JDK 25: **<TO_BE_INSTALLED>** (required for upgrade and final validation)

**Build Tools**
- Maven 3.9.16: `C:\Users\Dhrub Chatterjee\apache-maven-3.9.16` (used for baseline and validation)
- Maven Wrapper: not present

## Guidelines

> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred.

## Options

- Working branch: appmod/java-upgrade-20260911043757
- Run tests before and after the upgrade: true

## Upgrade Goals

- Upgrade Java runtime/compiler target from 17 to 25, the latest Java LTS version.

## Technology Stack

| Technology/Dependency | Current | Min Compatible Version | Why Incompatible |
| --------------------- | ------- | ---------------------- | ---------------- |
| Java | 17 | 25 | User requested Java 25 LTS |
| Maven | 3.9.16 | 3.9.16 | Compatible with Java 25; no upgrade required |
| maven-compiler-plugin | Maven default/inherited | 3.14.1 | Explicit modern plugin version recommended for Java 25 release support |
| Selenium Java | 4.48.0 | 4.48.0 | No upgrade required for Java target change |
| TestNG | 7.12.0 | 7.12.0 | No upgrade required for Java target change |
| Maven Surefire | 3.6.0 | 3.6.0 | Compatible and already modern |
| WebDriverManager | 5.9.2 | 5.9.2 | No upgrade required for Java target change |

## Derived Upgrades

- Java 25 requires a Java 25 JDK for compilation and runtime validation; install it before upgrade steps.
- Maven 3.9.16 is retained because it is already compatible and available.
- The Maven Compiler Plugin is made explicit at 3.14.1 so the build uses a version with Java 25 release support rather than an inherited default.
- No Kotlin, Spring Boot, Jakarta EE, or framework migration is present, so no derived framework changes are required.

## Impact Analysis

### Dependency Changes

| File | Dependency | Current | Action | Target | Reason |
|------|------------|---------|--------|--------|--------|
| `pom.xml` | `maven.compiler.source` | 17 | upgrade | 25 | Compile main and test sources for Java 25 |
| `pom.xml` | `maven.compiler.target` | 17 | upgrade | 25 | Emit Java 25 bytecode |
| `pom.xml` | `maven.compiler.release` | absent | add | 25 | Keep Java API and bytecode level aligned with Java 25 |
| `pom.xml` | `maven-compiler-plugin` | inherited/default | add | 3.14.1 | Explicit Java 25-compatible compiler plugin |

### Source Code Changes

| File | Location | Current | Required Change | Reason |
|------|----------|---------|----------------|--------|
| None | N/A | No target-incompatible imports, reflection, or removed APIs found | No source changes | Existing Java source is compatible with Java 25 |

### Configuration Changes

| File | Property/Setting | Current | Required Change | Reason |
|------|------------------|---------|----------------|--------|
| None | N/A | No runtime configuration references Java 17 | No change | The Java version is controlled by Maven properties |

### CI/CD Changes

| File | Location | Current | Required Change |
|------|----------|---------|----------------|
| None detected | N/A | No CI/CD or container files were found in the project root | No change required |

### Risks & Warnings

- **JDK availability**: Java 25 is not installed in the detected JDK paths. **Mitigation**: Install JDK 25 before applying the Maven change and use it for compile/test validation.
- **Browser-based smoke test**: `SmokeTest` may require a reachable Parabank application and browser/driver availability, independent of the Java version. **Mitigation**: Run the baseline and final suite; fix Java-related failures and record any environment-specific failure with evidence.
- **Compiler release alignment**: `source`, `target`, and `release` must remain aligned. **Mitigation**: configure all three to 25 and run `mvn clean test-compile` followed by `mvn clean test` under JDK 25.

## Upgrade Steps

- Step 1: Setup Environment
  - **Rationale**: Install the required Java 25 JDK before changing the project target.
  - **Changes to Make**: Install JDK 25; retain Maven 3.9.16.
  - **Verification**: List JDKs and confirm Java 25 is available; expected result is a valid Java 25 installation path.

- Step 2: Setup Baseline
  - **Rationale**: Establish current Java 17 compilation and test behavior for comparison.
  - **Changes to Make**: No project changes.
  - **Verification**: `mvn clean compile test-compile -q && mvn clean test -q` using JDK 17; expected result is a recorded baseline.

- Step 3: Upgrade Maven Java Target
  - **Rationale**: Set the Maven project to compile and test against Java 25 with explicit compiler support.
  - **Changes to Make**: Apply all Dependency Changes listed above in `pom.xml`.
  - **Verification**: `mvn clean test-compile -q` using JDK 25; expected result is successful main and test compilation.

- Step 4: Final Validation
  - **Rationale**: Confirm the requested Java target and full test behavior after the upgrade.
  - **Changes to Make**: Resolve all compilation or test failures caused by the upgrade; leave no temporary TODOs or workarounds.
  - **Verification**: `mvn clean test-compile -q` and `mvn clean test -q` using JDK 25; expected result is successful compilation and 100% tests passing.
