package tddbc.sapporo.validator;

import java.util.Map;

import org.slim3.controller.validator.Validator;
import org.slim3.datastore.Datastore;
import org.slim3.util.StringUtil;

import tddbc.sapporo.dao.ConferenceRoomDao;
import tddbc.sapporo.model.ConferenceRoom;

/**
 * 会議室の名前が重複していないか調べるバリデータ
 * @author sue445
 *
 */
public class ConferenceRoomTitleValidator implements Validator{
	private final ConferenceRoomDao conferenceRoomDao = new ConferenceRoomDao();

	/**
	 * 元データのKey
	 */
	private final String encodedKey;


	public ConferenceRoomTitleValidator(){
		this.encodedKey = null;
	}

	public ConferenceRoomTitleValidator(String encodedKey){
		this.encodedKey = encodedKey;
	}

	@Override
	public String validate(Map<String, Object> parameters, String name) {
		String title = (String) parameters.get(name);
		if(!StringUtil.isEmpty(encodedKey)){
			ConferenceRoom conferenceRoom = conferenceRoomDao.get(Datastore.stringToKey(encodedKey));
			if(conferenceRoom.getTitle().equals(title)){
				// 同一名称の更新時には許容する
				return null;
			}
		}

		boolean existsTitle = conferenceRoomDao.existsTitle(title);
		if(existsTitle){
			return title + "は既に登録されています";
		}
		return null;
	}

}
