package tddbc.sapporo.page;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slim3.datastore.Datastore;

import tddbc.sapporo.dao.ConferenceRoomDaoTest;
import tddbc.sapporo.model.ConferenceRoom;

import com.google.appengine.api.datastore.Key;

public class ConferenceroomPageTest extends MyPageTestCase {

	public ConferenceroomPageTest() {
		super(ConferenceroomPage.class);
	}

	@Test
	public void list() throws Exception {
		ConferenceRoomDaoTest.prepareConferenceRoom("大会議室", 64, "本社2階");
		ConferenceRoomDaoTest.prepareConferenceRoom("ミーティングルームA", 20, "本社2階");

		tester.start(ConferenceroomPage.PATH_LIST);
		assertPageSuccess();
		assertThat(getPageResponse(), containsString("会議室一覧"));

		List<ConferenceRoom> conferenceRoomList = getActualViewModel("conferenceRoomList");
		assertThat(conferenceRoomList.size(), is(greaterThan(0)));
	}

	@Test
	public void view_Found() throws Exception {
		Key key = ConferenceRoomDaoTest.prepareConferenceRoom("大会議室", 64, "本社2階");
		tester.param("key", Datastore.keyToString(key));

		tester.start(ConferenceroomPage.PATH_VIEW);
		assertPageSuccess();
		assertThat(getPageResponse(), containsString("会議室情報"));
		assertThat((Key)getActualViewModel("key"), is(key));
		assertThat((String)getActualViewModel("title"), is("大会議室"));
		assertThat((Integer)getActualViewModel("capacity"), is(64));
		assertThat((String)getActualViewModel("place"), is("本社2階"));
	}

}
