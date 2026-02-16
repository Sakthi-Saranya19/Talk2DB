package com.example.spring_db_ai;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class StudentCourseController {

	private final StudentCourseResource studentCourseResource;

	public StudentCourseController(StudentCourseResource studentCourseResource) {
		this.studentCourseResource = studentCourseResource;
	}

	@GetMapping("/hello")
	public ResponseEntity<String> greeting(String name) {
		String htmlResponse = "Hello "+name+" !Welcome!";
		return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(htmlResponse);
	}
	
	@GetMapping("/ask")
	public ResponseEntity<String> askQuestion(@RequestParam String question) {
		System.out.println("Question:"+question);
		String htmlResponse = studentCourseResource.processQuestion(question);
		return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(htmlResponse);
	}
	
	@GetMapping("/ai-prompt")
	public ResponseEntity<AiResponse> askPrompt(@RequestParam String question) {
		System.out.println("Question:"+question);
		AiResponse htmlResponse = studentCourseResource.getResponse(question);
		System.out.println(htmlResponse);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(htmlResponse);
	}
}