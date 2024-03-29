package cmp2804.tse.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DoctorsOnHand

fun main(args: Array<String>) {
	runApplication<DoctorsOnHand>(*args)
}

@RestController
class HelloController {

	@GetMapping("/")
	fun root(): String {
		return "OK"
	}

}