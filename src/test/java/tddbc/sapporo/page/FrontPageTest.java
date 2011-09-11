package tddbc.sapporo.page;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class FrontPageTest extends MyPageTestCase {

	public FrontPageTest() {
		super(FrontPage.class);
	}

	@Test
	public void index() throws Exception {
		tester.start("/");
		assertThat(tester.response.getStatus(),
				is(equalTo(HttpServletResponse.SC_OK)));
		assertTrue(tester.response.getOutputAsString().contains("Hello, world!"));
	}

	@Test
	public void test() throws Exception {
		tester.start("/test");
		assertThat(tester.response.getStatus(),
				is(equalTo(HttpServletResponse.SC_OK)));
		assertTrue(tester.response.getOutputAsString().contains("Test page!"));
	}
}
