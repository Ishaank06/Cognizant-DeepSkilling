# Hands-On 4.1.3: Centralized Auth / SSO

- **Ex 1 — Centralized Authentication with OAuth 2.1 / OIDC:** Configured `spring-boot-starter-oauth2-client` and `.oauth2Login()` to act as an OAuth2 client. We mocked Google IdP credentials in `application.yml`.
- **Ex 2 — Authorization Server & Resource Server:** Configured `spring-boot-starter-oauth2-resource-server` and `.oauth2ResourceServer().jwt()` to act as a Resource Server validating tokens from an issuer.
- **Ex 3 — JWT for secure communication:** Added JJWT dependencies and built a manual `JwtTokenProvider` and `JwtTokenFilter` to intercept and decode custom `Bearer` tokens, setting the `SecurityContextHolder` for inter-service communication without hitting an external IdP. Note that `WebSecurityConfigurerAdapter` was modernized to a `SecurityFilterChain` bean.
