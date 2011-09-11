package tddbc.sapporo.service;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import tddbc.sapporo.meta.SampleModelMeta;
import tddbc.sapporo.model.SampleModel;

public class SampleService {

	private SampleService() {
	}

	public static SampleModel newAndPut(String prop1) {
		SampleModel model = new SampleModel();
		model.setProp1(prop1);
		Key key = Datastore.put(model);
		model.setKey(key);
		return model;
	}

	public static List<SampleModel> queryAll() {
		return Datastore.query(SampleModelMeta.get()).asList();
	}
}
