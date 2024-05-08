package cmp2804.tse.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@EntityScan("cmp2804.tse.server.storage")
class DoctorsOnHand

fun main(args: Array<String>) {
	runApplication<DoctorsOnHand>(*args)
}