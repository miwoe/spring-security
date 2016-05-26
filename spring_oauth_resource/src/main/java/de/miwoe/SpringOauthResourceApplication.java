package de.miwoe;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.Principal;
import java.util.UUID;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SpringOauthResourceApplication extends WebMvcConfigurerAdapter {
	@RequestMapping("/")
	public Message home(Principal principal) {
		System.out.println("The principal is: " + principal.getName());
		return new Message("Hello World");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringOauthResourceApplication.class, args);
	}

}

class Message {
	private String id = UUID.randomUUID().toString();
	private String content;

	Message() {
	}

	public Message(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
