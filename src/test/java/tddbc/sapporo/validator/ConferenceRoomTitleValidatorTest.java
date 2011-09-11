package tddbc.sapporo.validator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slim3.datastore.Datastore;

import tddbc.sapporo.dao.ConferenceRoomDaoTest;
import tddbc.sapporo.service.MyServiceTestCase;

import com.google.appengine.api.datastore.Key;

public class ConferenceRoomTitleValidatorTest extends MyServiceTestCase{
	private ConferenceRoomTitleValidator validator = new ConferenceRoomTitleValidator();


	@Test
	public void validate_Exists() {
		ConferenceRoomDaoTest.prepareConferenceRoom("大会議室", 64, "本社2階");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("title", "大会議室");

		String actual = validator.validate(parameters, "title");
		assertThat(actual, is("大会議室は既に登録されています"));
	}

	@Test
	public void validate_NotExists() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("title", "大会議室");

		String actual = validator.validate(parameters, "title");
		assertThat(actual, is(nullValue()));
	}

	@Test
	public void validate_Accept() {
		Key key = ConferenceRoomDaoTest.prepareConferenceRoom("大会議室", 64, "本社2階");
		validator = new ConferenceRoomTitleValidator(Datastore.keyToString(key));
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("title", "大会議室");

		String actual = validator.validate(parameters, "title");
		assertThat(actual, is(nullValue()));
	}
}
