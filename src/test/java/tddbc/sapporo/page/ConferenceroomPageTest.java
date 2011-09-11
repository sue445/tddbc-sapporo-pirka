package tddbc.sapporo.page;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import tddbc.sapporo.dao.ConferenceRoomDaoTest;
import tddbc.sapporo.model.ConferenceRoom;

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

}
