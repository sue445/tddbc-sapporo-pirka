package tddbc.sapporo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tddbc.sapporo.page.FrontPageTest;
import tddbc.sapporo.service.SampleServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	FrontPageTest.class,
	SampleServiceTest.class,
})
public class AllTests {
}
