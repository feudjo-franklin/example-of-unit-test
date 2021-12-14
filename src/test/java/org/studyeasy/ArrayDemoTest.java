package org.studyeasy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayDemoTest {

	@Test
	void test() {
		ArrayDemo demo = new ArrayDemo();
		int[] actual = demo.returnArray();
		int[] expected = {1,2,3};
		assertArrayEquals(expected, actual);
	}

}
