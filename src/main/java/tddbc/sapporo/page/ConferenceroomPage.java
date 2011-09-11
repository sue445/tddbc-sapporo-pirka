package tddbc.sapporo.page;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import scenic3.annotation.ActionPath;
import scenic3.annotation.Page;
import tddbc.sapporo.dao.ConferenceRoomDao;
import tddbc.sapporo.model.ConferenceRoom;

@Page("/conferenceroom")
public class ConferenceroomPage extends AbstractPirkaPage{
	public static final String PATH_LIST = "/conferenceroom/list";

	private final ConferenceRoomDao conferenceRoomDao = new ConferenceRoomDao();


	@ActionPath("list")
	public Navigation list() throws Exception {
		List<ConferenceRoom> conferenceRoomList = conferenceRoomDao.findAll();

		// TODO 登録ページを作るまでの暫定
		if(conferenceRoomList.size() == 0){
			conferenceRoomList = createMock();
			conferenceRoomDao.put(conferenceRoomList);
		}
		viewModel("conferenceRoomList", conferenceRoomList);

		return render(VIEW_PREFIX + "conferenceroom/list.html");
	}

	private List<ConferenceRoom> createMock(){
		List<ConferenceRoom> result = new ArrayList<ConferenceRoom>();

		ConferenceRoom model1 = new ConferenceRoom();
		model1.setKey(Datastore.allocateId(ConferenceRoom.class));
		model1.setTitle("大会議室");
		model1.setCapacity(64);
		model1.setPlace("本社2階");
		result.add(model1);

		ConferenceRoom model2 = new ConferenceRoom();
		model2.setKey(Datastore.allocateId(ConferenceRoom.class));
		model2.setTitle("ミーティングルームA");
		model2.setCapacity(20);
		model2.setPlace("本社2階");
		result.add(model2);

		return result;
	}
}
