package com.speakingclock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpeakingClockApplicationTests {

	@Test
	void contextLoads() {
	}

	private int port = 8080;

	private TestRestTemplate testRestTemplate;

	@Autowired
	public SpeakingClockApplicationTests(TestRestTemplate testRestTemplate) {
		this.testRestTemplate = testRestTemplate;
	}

	@Test
	public void testConvertToWords_Success() {
		String url = "http://localhost:" + port + "/convert?time=10:24";
		ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("It's eight thirty-four", response.getBody());
	}

	@Test
	public void testConvertToWords_InvalidFormat() {
		String url = "http://localhost:" + port + "/convert?time=05:23:09";
		ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid time format", response.getBody());
	}

}
