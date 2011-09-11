package tddbc.sapporo.page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pirkaengine.slim3.PirkaPage;
import org.slim3.controller.Navigation;

import scenic3.annotation.ActionPath;
import scenic3.annotation.Default;
import scenic3.annotation.Page;

import tddbc.sapporo.model.SampleModel;
import tddbc.sapporo.service.SampleService;

@Page("/")
public class FrontPage extends PirkaPage {

	@ActionPath("test")
	public Navigation test() throws Exception {
		viewModel("title", "Test page!");

		return render("test.html");
	}
	
	@Default
	public Navigation index() throws Exception {
		SampleService.newAndPut(new Date().toString());
		
		List<SampleModel> list = SampleService.queryAll();
		List<String> dates = new ArrayList<String>();
		for (SampleModel model : list) {
			dates.add(model.getProp1());
		}
		
		viewModel("title", "Hello, world!");
		viewModel("dates", dates);

		return render("index.html");
	}
}
