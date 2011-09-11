package tddbc.sapporo.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

public class ConferenceRoomTest extends AppEngineTestCase {

	private ConferenceRoom model = new ConferenceRoom();

	@Test
	public void test() throws Exception {
		assertThat(model, is(notNullValue()));
	}

	@Test
	public void getKeyString() throws Exception {
		model.setKey(Datastore.createKey(ConferenceRoom.class, "1"));
		assertThat(model.getKeyString().length(), is(greaterThan(0)));
	}
}
