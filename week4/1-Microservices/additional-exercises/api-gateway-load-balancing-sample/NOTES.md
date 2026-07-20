# Hands-On 4.1.4: Edge Services / Load Balancing

- **Ex 1 — Edge service routing/filtering:** Implemented Spring Cloud Gateway using `spring-cloud-starter-gateway`. Configured a basic route targeting `http://example.org` and created a `LoggingFilter` that intercepts and logs the URI of all incoming traffic.
- **Ex 2 — Load balancing in the gateway:** Integrated `spring-cloud-starter-loadbalancer`. Defined a custom `ReactorLoadBalancer` (Random Load Balancer) and routed a path (`/loadbalanced/**`) via the `lb://` protocol.
- **Ex 3 — Resilience patterns in the gateway:** Added `spring-cloud-starter-circuitbreaker-reactor-resilience4j`. Configured properties for a sliding window and failure threshold, and defined a `Customizer<ReactiveResilience4JCircuitBreakerFactory>` bean for reactive gateway-level circuit breaking.
