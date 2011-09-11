package tddbc.sapporo.validator;

import java.util.Map;

import org.slim3.controller.validator.Validator;

import tddbc.sapporo.dao.ConferenceRoomDao;

public class ConferenceRoomValidator implements Validator{
	private final ConferenceRoomDao conferenceRoomDao = new ConferenceRoomDao();


	@Override
	public String validate(Map<String, Object> parameters, String name) {
		String title = (String) parameters.get(name);
		boolean existsTitle = conferenceRoomDao.existsTitle(title);
		if(existsTitle){
			return title + "は既に登録されています";
		}
		return null;
	}

}
