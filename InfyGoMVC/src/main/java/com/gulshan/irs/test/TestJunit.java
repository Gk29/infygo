package com.gulshan.irs.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJunit {

	@Test
	public void testSetuo() {
		String str="I am done with Junit Setup";
		assertEquals("I am done with Junit Setup",str);
	}
}
