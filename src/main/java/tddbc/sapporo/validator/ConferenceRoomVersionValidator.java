package tddbc.sapporo.validator;

import java.util.Map;

import org.slim3.controller.validator.Validator;
import org.slim3.datastore.Datastore;
import org.slim3.util.LongUtil;

import tddbc.sapporo.dao.ConferenceRoomDao;
import tddbc.sapporo.model.ConferenceRoom;

import com.google.appengine.api.datastore.Key;

/**
 * 会議室の楽観的排他制御を行うバリデータ
 * @author sue445
 *
 */
public class ConferenceRoomVersionValidator implements Validator{
	private final ConferenceRoomDao conferenceRoomDao = new ConferenceRoomDao();

	private final String encodedKey;

	public ConferenceRoomVersionValidator(String encodedKey){
		this.encodedKey = encodedKey;
	}

	@Override
	public String validate(Map<String, Object> parameters, String name) {
		try {
			Key key = Datastore.stringToKey(encodedKey);
			ConferenceRoom conferenceRoom = conferenceRoomDao.get(key);
			long modelVersion = conferenceRoom.getVersion();
			long requestVersion = LongUtil.toPrimitiveLong(parameters.get(name));
			if(modelVersion != requestVersion){
				return "他の人が編集したみたいです";
			}
			return null;
		} catch (Exception e) {
			// keyのデコードに失敗した, データが見つからない, versionが不正 etc
			return "不正なデータです";
		}
	}

}
