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

		tester.start(ConferenceroomPage.PATH_VIEW + "/" + Datastore.keyToString(key));
		assertPageSuccess();
		assertThat(getPageResponse(), containsString("会議室情報"));
		assertThat((Key)getActualViewModel("key"), is(key));
		assertThat((String)getActualViewModel("title"), is("大会議室"));
		assertThat((Integer)getActualViewModel("capacity"), is(64));
		assertThat((String)getActualViewModel("place"), is("本社2階"));
	}

	@Test
	public void view_NotFound() throws Exception {
		Key key = Datastore.allocateId(ConferenceRoom.class);

		tester.start(ConferenceroomPage.PATH_VIEW + "/" + Datastore.keyToString(key));
		assertPageSuccess();
		assertThat(getPageResponse(), containsString("会議室一覧"));
		assertThat((String)getActualViewModel(ConferenceroomPage.ERROR_MESSAGE_KEY), is("そんな会議室ありません"));
	}

	@Test
	public void register() throws Exception {
		tester.start(ConferenceroomPage.PATH_REGISTER);
		assertPageSuccess();
		assertThat(getPageResponse(), containsString("会議室情報の登録"));
	}

	@Test
	public void registerExecute_EmptyParam() throws Exception {
		tester.param("title", "");
		tester.param("capacity", "");
		tester.param("place", "");
		tester.start(ConferenceroomPage.PATH_REGISTER_EXECUTE);
		assertPageSuccess();
		assertThat(getPageResponse(), containsString("会議室情報の登録"));

		Object[] errorMessageList = getActualViewModel(ConferenceroomPage.ERROR_MESSAGE_KEY);
		assertThat(errorMessageList.length, is(3));
		assertThat((String)errorMessageList[0], is("titleは必須です。"));
		assertThat((String)errorMessageList[1], is("capacityは必須です。"));
		assertThat((String)errorMessageList[2], is("placeは必須です。"));
	}

	@Test
	public void registerExecute_NotNumber() throws Exception {
		tester.param("title", "大会議室");
		tester.param("capacity", "aaa");
		tester.param("place", "本社2階");
		tester.start(ConferenceroomPage.PATH_REGISTER_EXECUTE);
		assertPageSuccess();
		assertThat(getPageResponse(), containsString("会議室情報の登録"));

		Object[] errorMessageList = getActualViewModel(ConferenceroomPage.ERROR_MESSAGE_KEY);
		assertThat(errorMessageList.length, is(1));
		assertThat((String)errorMessageList[0], is("capacityは整数でなければいけません。"));
	}

	@Test
	public void registerExecute_Success() throws Exception {
		tester.param("title", "大会議室");
		tester.param("capacity", "10");
		tester.param("place", "本社2階");
		tester.start(ConferenceroomPage.PATH_REGISTER_EXECUTE);
		assertPageSuccess(302);
		assertThat(tester.isRedirect(), is(true));

		Object[] errorMessageList = getActualViewModel(ConferenceroomPage.ERROR_MESSAGE_KEY);
		assertThat(errorMessageList, is(nullValue()));

		assertThat(tester.count(ConferenceRoom.class), is(1));
	}

	@Test
	public void edit_Found() throws Exception {
		Key key = ConferenceRoomDaoTest.prepareConferenceRoom("大会議室", 64, "本社2階");

		tester.start(ConferenceroomPage.PATH_EDIT + "/" + Datastore.keyToString(key));
		assertPageSuccess();
		assertThat(getPageResponse(), containsString("会議室情報の修正"));
		assertThat((Key)getActualViewModel("key"), is(key));
		assertThat((String)getActualViewModel("title"), is("大会議室"));
		assertThat((Integer)getActualViewModel("capacity"), is(64));
		assertThat((String)getActualViewModel("place"), is("本社2階"));
		assertThat((Integer)getActualViewModel("version"), is(1));
	}
}
