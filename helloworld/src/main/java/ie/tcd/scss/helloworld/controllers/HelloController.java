package ie.tcd.scss.helloworld.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// @RestController tells Spring this class will handle web requests.
@RestController
public class HelloController {
	// @GetMapping maps HTTP GET requests for "/hello" to this method.
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, World!";
	}
}
