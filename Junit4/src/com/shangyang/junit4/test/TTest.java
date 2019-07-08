package com.shangyang.junit4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.shangyang.junit4.T;

class TTest {

	@Test
	void testAdd() {
		int z = new T().add(5,3);
		// fail("Not yet implemented");
		assertEquals(8,z);
	}

}
