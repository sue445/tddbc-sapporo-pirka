package tddbc.sapporo.dao;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import tddbc.sapporo.model.ConferenceRoom;

import com.google.appengine.api.datastore.Key;

public class ConferenceRoomDaoTest extends AppEngineTestCase {

	private ConferenceRoomDao dao = new ConferenceRoomDao();

	@Test
	public void test() throws Exception {
		assertThat(dao, is(notNullValue()));
	}

	@Test
	public void findAll_NotFound() throws Exception {
		List<ConferenceRoom> actualRooms = dao.findAll();
		assertThat(actualRooms.size(), is(0));
	}

	@Test
	public void findAll_Found() throws Exception {
		prepareConferenceRoom("大会議室", 64, "本社2階");

		List<ConferenceRoom> actualRoomList = dao.findAll();

		assertThat(actualRoomList.size(), is(1));
		ConferenceRoom room = actualRoomList.get(0);
		assertThat(room.getTitle(), is("大会議室"));
		assertThat(room.getCapacity(), is(64));
		assertThat(room.getPlace(), is("本社2階"));
	}

	public static Key prepareConferenceRoom(String title, int capacity, String place) {
		Key key = Datastore.allocateId(ConferenceRoom.class);
		ConferenceRoom model = new ConferenceRoom();
		model.setKey(key);
		model.setTitle(title);
		model.setCapacity(capacity);
		model.setPlace(place);
		Datastore.put(model);

		return key;
	}
}
