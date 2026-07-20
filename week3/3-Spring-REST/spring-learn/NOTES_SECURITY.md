# Hands-On: JWT Security

- **Objective:** Secure REST endpoints using Spring Security and JSON Web Tokens.
- **Implemented:**
  - Added `spring-boot-starter-security` and `jjwt` dependencies.
  - Created `JwtUtil` class to generate tokens using `HS256` and validate token claims/expiration.
  - Created `JwtRequestFilter` (`OncePerRequestFilter`) to intercept requests, extract the `Authorization: Bearer` token, parse the claims, and populate the `SecurityContextHolder`.
  - Configured `SecurityConfig` to disable CSRF, set session management to `STATELESS`, explicitly permit the `/authenticate` endpoint, and secure all other endpoints. Inserted the `JwtRequestFilter` before `UsernamePasswordAuthenticationFilter`.
  - Created `AuthenticationController` for logging in, validating `admin/admin` credentials, and returning the generated JWT.
- **Verification:** 
  - Ran `curl` against `/countries` without a token -> 403 Forbidden.
  - Authenticated via `/authenticate` -> Received JWT token.
  - Passed token into `Authorization` header -> 200 OK and JSON response returned successfully.
