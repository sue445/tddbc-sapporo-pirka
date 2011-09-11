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

public class ConferenceRoomVersionValidatorTest extends MyServiceTestCase {
	private ConferenceRoomVersionValidator validator;


	@Test
	public void validate_VersionError() {
		Key key = ConferenceRoomDaoTest.prepareConferenceRoom("大会議室", 64, "本社2階");

		validator = new ConferenceRoomVersionValidator(Datastore.keyToString(key));

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("version", "2");

		String actual = validator.validate(parameters, "version");
		assertThat(actual, is("他の人が編集したみたいです"));
	}

	@Test
	public void validate_KeyError() {
		validator = new ConferenceRoomVersionValidator("aaaaa");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("version", "1");

		String actual = validator.validate(parameters, "version");
		assertThat(actual, is("不正なデータです"));
	}

	@Test
	public void validate_Success() {
		Key key = ConferenceRoomDaoTest.prepareConferenceRoom("大会議室", 64, "本社2階");

		validator = new ConferenceRoomVersionValidator(Datastore.keyToString(key));

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("version", "1");

		String actual = validator.validate(parameters, "version");
		assertThat(actual, is(nullValue()));
	}

}
