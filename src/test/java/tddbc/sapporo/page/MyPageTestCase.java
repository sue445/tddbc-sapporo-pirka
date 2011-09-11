package tddbc.sapporo.page;

import java.io.IOException;

import scenic3.ScenicPage;
import scenic3.tester.PageTestCase;
import tddbc.sapporo.controller.AppUrls;

public abstract class MyPageTestCase extends PageTestCase {

	public MyPageTestCase(Class<? extends ScenicPage> pageClass) {
		super(AppUrls.class, pageClass);
	}

	@Override
	public void setUp() throws Exception {
		tester = new MyPirkaPageTester(this.getClass());
		tester.setUp();
	}

	/**
	 * Pageのレスポンスを取得する
	 * @return
	 * @throws IOException
	 */
	protected String getPageResponse() throws IOException {
		return tester.response.getOutputAsString();
	}
}