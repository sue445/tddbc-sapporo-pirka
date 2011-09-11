package tddbc.sapporo.page;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.IntegerUtil;

import scenic3.annotation.ActionPath;
import scenic3.annotation.Page;
import scenic3.annotation.RequestParam;
import scenic3.annotation.Var;
import tddbc.sapporo.dao.ConferenceRoomDao;
import tddbc.sapporo.meta.ConferenceRoomMeta;
import tddbc.sapporo.model.ConferenceRoom;
import tddbc.sapporo.validator.ConferenceRoomValidator;

/**
 * 会議室ページ
 * @author sue445
 *
 */
@Page("/conferenceroom")
public class ConferenceroomPage extends AbstractPirkaPage{
	public static final String PATH_LIST = "/conferenceroom/list";
	public static final String PATH_VIEW = "/conferenceroom/view";
	public static final String PATH_REGISTER = "/conferenceroom/register";
	public static final String PATH_REGISTER_EXECUTE = "/conferenceroom/registerExecute";
	public static final String PATH_EDIT = "/conferenceroom/edit";

	public static final String ERROR_MESSAGE_KEY = "errorMessage";

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
//		if(conferenceRoomList.size() == 0){
//			conferenceRoomList = createMock();
//			conferenceRoomDao.put(conferenceRoomList);
//		}
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
			viewModel(ERROR_MESSAGE_KEY, "そんな会議室ありません");
			return list();
		}
	}

	/**
	 * 会議室登録（入力フォーム表示）
	 * @return
	 * @throws Exception
	 */
	@ActionPath("register")
	public Navigation register() throws Exception {
		return render(VIEW_PREFIX + "conferenceroom/register.html");
	}

	/**
	 * 会議室登録（登録実行）
	 * @return
	 * @throws Exception
	 */
	@ActionPath("registerExecute")
	public Navigation registerExecute(
			@RequestParam("title") String title,
			@RequestParam("capacity") String capacity,
			@RequestParam("place") String place) throws Exception {
		Validators v = createDefaultValidators();

		if(!v.validate()){
			// 入力ページに戻る
			viewModel("title", title);
			viewModel("capacity", capacity);
			viewModel("place", place);
			viewModel(ERROR_MESSAGE_KEY, v.getErrors().toArray());
			return render(VIEW_PREFIX + "conferenceroom/register.html");
		}

		// 登録する
		ConferenceRoom conferenceRoom = new ConferenceRoom();
		conferenceRoom.setTitle(title);
		conferenceRoom.setCapacity(IntegerUtil.toPrimitiveInt(capacity));
		conferenceRoom.setPlace(place);
		conferenceRoomDao.put(conferenceRoom);

		return redirect(PATH_LIST);
	}

	/**
	 * 登録ページと編集ページで共通のバリデータ
	 * @return
	 */
	private Validators createDefaultValidators() {
		Validators v = new Validators(request);
		ConferenceRoomMeta e = ConferenceRoomMeta.get();
		v.add(e.title, v.required(), v.maxlength(30), new ConferenceRoomValidator());
		v.add(e.capacity, v.required(), v.integerType(), v.longRange(1, Long.MAX_VALUE));
		v.add(e.place, v.required(), v.maxlength(140));
		return v;
	}

	/**
	 * 会議室更新
	 * @return
	 * @throws Exception
	 */
	@ActionPath("edit/{key}")
	public Navigation edit(@Var("key") String key) throws Exception {
		try {
			ConferenceRoom conferenceRoom = conferenceRoomDao.get(Datastore.stringToKey(key));
			BeanUtil.copy(conferenceRoom, viewModel);
			return render(VIEW_PREFIX + "conferenceroom/edit.html");
		} catch (Exception e) {
			viewModel(ERROR_MESSAGE_KEY, "そんな会議室ありません");
			return list();
		}
	}
}
