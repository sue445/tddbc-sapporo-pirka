package tddbc.sapporo.page;

import org.pirkaengine.core.PirkaContext;
import org.slim3.util.AppEngineUtil;

import scenic3.tester.PageTester;

public class MyPirkaPageTester extends PageTester {

	public MyPirkaPageTester(Class<?> testClass) throws NullPointerException {
		super(testClass);

		PirkaContext ctx = PirkaContext.getInstance();
		ctx.setTemplatePath(AppEngineUtil.isServer() ? "" : "war");
		ctx.setEnableCache(false);
	}
}
