package cybersoft.javabackend.gira.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping
	public Object welcome() {
		return "Welcome to Gira appication";
	}
}
