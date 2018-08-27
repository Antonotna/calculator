package com.example.calculator;
import org.springframework.stereotype.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}
}

@Service
public class Calculator {
	int sum(int a, int b) {
		return a+b;
	}
}

@RestController
class CalculatorController {
	@Autowired
	private Calculator calculator;

	@RequestMapping("/sum")
	String sum(@RequestParam("a") Integer a,
			@RequestParam("b") Integer b) {
		return String.valueOf(calculator.sum(a, b));
	}
}


public class CalculatorTest {
	private Calculator calculator = new Calculator();
	
	@Test
	public void testSum() {
		assertEquals(5, calculator.sum(2, 3));
	}
}
