package tddbc.sapporo.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SampleServiceTest extends MyServiceTestCase {

	@Test
	public void test() {
		SampleService.newAndPut("abc");
		assertThat(SampleService.queryAll().size(), is(equalTo(1)));
	}
}
