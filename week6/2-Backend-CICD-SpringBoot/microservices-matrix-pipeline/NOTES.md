# 6.2.4 Hands-On 4 — Matrix build across all microservices

Target project: `week4/1-Microservices/account-loan-eureka-gateway`

## What was added
- Created `.github/workflows/microservices-ci.yml` inside `account-loan-eureka-gateway`.
- Configured a build matrix to run `mvn clean verify` for the following microservices in parallel: `account`, `loan`, `eureka-discovery-server`, `greet-service`, and `api-gateway`.
- Set `fail-fast: false` so that if one service fails, the others continue to build and test.

## Real run outcome
- The workflow has been committed. 
- Using a matrix build drastically reduces duplicated YAML and speeds up the feedback loop compared to running them sequentially.
