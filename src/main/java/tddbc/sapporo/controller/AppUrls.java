package tddbc.sapporo.controller;

import scenic3.UrlsImpl;

import tddbc.sapporo.controller.matcher.FrontPageMatcher;

public class AppUrls extends UrlsImpl {

	public AppUrls() {
		// Add "excludes" to prevent paths to static files from being processed by Scenic3.
//		excludes("/favicon.ico", "/css/*", "/img/*");
		excludes("/favicon.ico", "/ktrwjr", "/ktrwjr/*", "/_ah/*");

		// Add page matchers each time you create a new page class.
		add(FrontPageMatcher.get());
	}
}
