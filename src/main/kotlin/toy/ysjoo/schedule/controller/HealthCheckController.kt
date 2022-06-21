package toy.ysjoo.schedule.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health/check")
class HealthCheckController {
    @GetMapping
    fun getHealthCheck(): ResponseEntity<Any> {
        return ResponseEntity.ok("Hello! Welcome to Toy Project for Schedule!")
    }
}