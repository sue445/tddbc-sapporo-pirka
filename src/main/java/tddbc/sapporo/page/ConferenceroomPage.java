package tddbc.sapporo.page;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import scenic3.annotation.ActionPath;
import scenic3.annotation.Page;
import scenic3.annotation.Var;
import tddbc.sapporo.dao.ConferenceRoomDao;
import tddbc.sapporo.model.ConferenceRoom;

/**
 * 会議室ページ
 * @author sue445
 *
 */
@Page("/conferenceroom")
public class ConferenceroomPage extends AbstractPirkaPage{
	public static final String PATH_LIST = "/conferenceroom/list";
	public static final String PATH_VIEW = "/conferenceroom/view";

	private static final String ERROR_MESSAGE_KEY = "errorMessage";

	private final ConferenceRoomDao conferenceRoomDao = new ConferenceRoomDao();


	/**
	 * 会議室一覧
	 * @return
	 * @throws Exception
	 */
	@ActionPath("list")
	public Navigation list() throws Exception {
		List<ConferenceRoom> conferenceRoomList = conferenceRoomDao.findAll();

		// TODO 登録ページを作るまでの暫定
		if(conferenceRoomList.size() == 0){
			conferenceRoomList = createMock();
			conferenceRoomDao.put(conferenceRoomList);
		}
		viewModel("conferenceRoomList", conferenceRoomList);

		if(conferenceRoomList.size() == 0){
			viewModel(ERROR_MESSAGE_KEY, "会議室が見つかりませんでした");
		}

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

	/**
	 * 会議室照会
	 * @return
	 * @throws Exception
	 */
	@ActionPath("view/{key}")
	public Navigation view(@Var("key") String key) throws Exception {
		try {
			ConferenceRoom conferenceRoom = conferenceRoomDao.get(Datastore.stringToKey(key));
			BeanUtil.copy(conferenceRoom, viewModel);
			return render(VIEW_PREFIX + "conferenceroom/view.html");
		} catch (Exception e) {
			viewModel(ERROR_MESSAGE_KEY, "会議室が見つかりませんでした");
			return list();
		}
	}
}
