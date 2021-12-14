package org.studyeasy;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

// Few important habits
// Keep your test method independent



//By default with Lifecycle.PER_METHOD, Junit creates a new object of the class MathFunctionsTest at every call of the method
@TestInstance(Lifecycle.PER_CLASS) // with Lifecycle.PER_CLASS, we are asking JUNIT to create only one object of the class MathFunctionsTest during its testing lifecycle
class MathFunctionsTest {   // why the default setting ? for Junit to use fresh data at each call of test method
	MathFunctions mathFunctions;
	
	@BeforeAll     // Usually used for initializing things, the method is executed even before the first object creation of the class MathFunctionsTest
	void beforeAll() {  // That's why we define the method as static, no object creation needed. No static keyword needed with Lifecycle.PER_ClASS 
		System.out.println("Before All");
	}
	
	@AfterAll  // Usually used to clean things up
	void afterAll() {  // in Analogy to  BeforeAll
		System.out.println("After All");
	}
	
	@BeforeEach
	void beforeEach() {
		mathFunctions = new MathFunctions();
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("Execute after each");
	}
	
	@Test
	@Tag("runIt")
	void testAdd() {
		int expected = 40;
		int actual = mathFunctions.add(10, 30);
		assertEquals(expected, actual, () -> "Addition operation failed");
	}
	
	@Test
	@Tag("runIt")   // With this tag and additional configuration we can decide whether the method gets executed or not
	void testSub() {
		int expected = -20;
		int actual = mathFunctions.sub(10, 30);
		assertEquals(expected, actual, () -> "Substraction operation failed");
	}

	@Test
	void testMultiple() {
		int expected = 300;
		int actual = mathFunctions.multiple(10, 30);
		//Using the lambda expression the string will be generated only when the test has failed, it improves the speed and efficiency
		assertEquals(expected, actual, () -> "Multiplication operation failed"); //Without the lambda expression the String is created before the execution of the test
	}

	@Test
	//@RepeatedTest(5)
	void repeatMe(){
		System.out.println("I am alive");
	}
	
	@Disabled  //To disable the test case (notice the icon)
	@Test
	@DisplayName("AssertAll Example") // Assign a name to the test case
	void testDivide() {
		
		assertEquals(0, mathFunctions.divide(10, 30));
		assertEquals(0, mathFunctions.divide(5, 25));
		int zero = 0;
		assumeTrue(zero == 0); // if boolean value == true then the all of coming lines will get executed else
		System.out.println("Zero value in denominator");
		assertThrows(ArithmeticException.class, () -> mathFunctions.divide(10, zero));
		

		
		//***** Alternativ by using assertAll() function ************
		
		/*assertAll(() -> assertEquals(0, mathFunctions.divide(10, 30)),
				  () -> assertThrows(ArithmeticException.class, () -> mathFunctions.divide(10, 0)),
				  () -> assertEquals(5, mathFunctions.divide(5, 25))
				 );
		*/
	}
}
