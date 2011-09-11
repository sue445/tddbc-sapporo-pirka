package tddbc.sapporo.service;

import org.junit.After;
import org.junit.Before;
import org.slim3.tester.AppEngineTester;

public class MyServiceTestCase {

	protected AppEngineTester tester;

	@Before
	public void setUp() throws Exception {
		tester = new AppEngineTester();
		tester.setUp();
	}

	@After
	public void tearDown() throws Exception {
		tester.tearDown();
	}

}