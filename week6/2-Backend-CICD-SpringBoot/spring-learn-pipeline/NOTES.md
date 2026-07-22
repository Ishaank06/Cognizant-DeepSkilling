# 6.2.1 Hands-On 1 — Basic CI workflow for spring-learn

Target project: `week3/3-Spring-REST/spring-learn`

## What was added
- Created `.github/workflows/backend-ci.yml` inside the `spring-learn` directory.
- This workflow triggers on pushes and pull requests to `main`.
- It sets up JDK 17, builds the project, runs the test suite using `mvn -B clean verify`, and publishes the surefire test reports as artifacts.

## Real run outcome
- The workflow has been committed.
- Since it is located inside a sub-directory, note that GitHub Actions normally looks for `.github` at the repository root. Depending on the repository configuration, it may need to be moved to the root. For this hands-on, it is kept in `spring-learn/` as specified.
