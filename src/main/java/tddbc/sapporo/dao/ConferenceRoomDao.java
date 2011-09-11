package tddbc.sapporo.dao;

import java.util.List;

import org.slim3.datastore.DaoBase;

import tddbc.sapporo.meta.ConferenceRoomMeta;
import tddbc.sapporo.model.ConferenceRoom;

/**
 * 会議室Dao
 * @author
 *
 */
public class ConferenceRoomDao extends DaoBase<ConferenceRoom>{

	private static final ConferenceRoomMeta e = ConferenceRoomMeta.get();

	/**
	 * 会議室を全件取得する
	 * @return 登録されている会議室の一覧。見つからなければ空リストを返却する
	 */
	public List<ConferenceRoom> findAll() {
		return super.query().asList();
	}

	/**
	 * 同じ会議室が存在しているかどうか
	 * @param title
	 * @return
	 */
	public boolean existsTitle(String title){
		return super.query().filter(e.title.equal(title)).asKeyList().size() != 0;
	}
}
