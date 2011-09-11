package tddbc.sapporo.page;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import scenic3.ScenicPage;
import scenic3.tester.PageTestCase;
import tddbc.sapporo.controller.AppUrls;

public abstract class MyPageTestCase extends PageTestCase {
	private final Class<? extends ScenicPage> pageClass;

	public MyPageTestCase(Class<? extends ScenicPage> pageClass) {
		super(AppUrls.class, pageClass);
		this.pageClass = pageClass;
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

	/**
	 * ページが正常終了したことを表明する
	 */
	protected void assertPageSuccess() {
		assertPageSuccess(HttpServletResponse.SC_OK);
	}

	/**
	 * ページが終了したことを表明する
	 * @param responseCode レスポンスコード
	 */
	protected void assertPageSuccess(int responseCode) {
		assertThat(tester.getPage(), is(instanceOf(pageClass)));
		assertThat(tester.response.getStatus(), is(responseCode));
	}

	/**
	 * ページ実行後のviewModelを取得する
	 * @param key
	 * @return
	 */
	protected <T> T getActualViewModel(String key) {
		AbstractPirkaPage page = (AbstractPirkaPage) tester.getPage();
		return page.viewModel(key);
	}
}