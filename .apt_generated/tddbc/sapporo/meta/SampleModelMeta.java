package tddbc.sapporo.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-09-11 20:08:08")
/** */
public final class SampleModelMeta extends org.slim3.datastore.ModelMeta<tddbc.sapporo.model.SampleModel> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<tddbc.sapporo.model.SampleModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<tddbc.sapporo.model.SampleModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tddbc.sapporo.model.SampleModel> prop1 = new org.slim3.datastore.StringAttributeMeta<tddbc.sapporo.model.SampleModel>(this, "prop1", "prop1");

    private static final SampleModelMeta slim3_singleton = new SampleModelMeta();

    /**
     * @return the singleton
     */
    public static SampleModelMeta get() {
       return slim3_singleton;
    }

    /** */
    public SampleModelMeta() {
        super("SampleModel", tddbc.sapporo.model.SampleModel.class);
    }

    @Override
    public tddbc.sapporo.model.SampleModel entityToModel(com.google.appengine.api.datastore.Entity entity) {
        tddbc.sapporo.model.SampleModel model = new tddbc.sapporo.model.SampleModel();
        model.setKey(entity.getKey());
        model.setProp1((java.lang.String) entity.getProperty("prop1"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        tddbc.sapporo.model.SampleModel m = (tddbc.sapporo.model.SampleModel) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("prop1", m.getProp1());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        tddbc.sapporo.model.SampleModel m = (tddbc.sapporo.model.SampleModel) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        tddbc.sapporo.model.SampleModel m = (tddbc.sapporo.model.SampleModel) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(tddbc.sapporo.model.SampleModel) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        tddbc.sapporo.model.SampleModel m = (tddbc.sapporo.model.SampleModel) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getProp1() != null){
            writer.setNextPropertyName("prop1");
            encoder0.encode(writer, m.getProp1());
        }
        writer.endObject();
    }

    @Override
    protected tddbc.sapporo.model.SampleModel jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        tddbc.sapporo.model.SampleModel m = new tddbc.sapporo.model.SampleModel();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("prop1");
        m.setProp1(decoder0.decode(reader, m.getProp1()));
        return m;
    }
}