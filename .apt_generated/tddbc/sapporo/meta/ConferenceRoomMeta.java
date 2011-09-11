package tddbc.sapporo.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-09-11 21:28:29")
/** */
public final class ConferenceRoomMeta extends org.slim3.datastore.ModelMeta<tddbc.sapporo.model.ConferenceRoom> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<tddbc.sapporo.model.ConferenceRoom, java.lang.Integer> capacity = new org.slim3.datastore.CoreAttributeMeta<tddbc.sapporo.model.ConferenceRoom, java.lang.Integer>(this, "capacity", "capacity", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<tddbc.sapporo.model.ConferenceRoom, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<tddbc.sapporo.model.ConferenceRoom, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tddbc.sapporo.model.ConferenceRoom> place = new org.slim3.datastore.StringAttributeMeta<tddbc.sapporo.model.ConferenceRoom>(this, "place", "place");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<tddbc.sapporo.model.ConferenceRoom> title = new org.slim3.datastore.StringAttributeMeta<tddbc.sapporo.model.ConferenceRoom>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<tddbc.sapporo.model.ConferenceRoom, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<tddbc.sapporo.model.ConferenceRoom, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final ConferenceRoomMeta slim3_singleton = new ConferenceRoomMeta();

    /**
     * @return the singleton
     */
    public static ConferenceRoomMeta get() {
       return slim3_singleton;
    }

    /** */
    public ConferenceRoomMeta() {
        super("ConferenceRoom", tddbc.sapporo.model.ConferenceRoom.class);
    }

    @Override
    public tddbc.sapporo.model.ConferenceRoom entityToModel(com.google.appengine.api.datastore.Entity entity) {
        tddbc.sapporo.model.ConferenceRoom model = new tddbc.sapporo.model.ConferenceRoom();
        model.setCapacity(longToPrimitiveInt((java.lang.Long) entity.getProperty("capacity")));
        model.setKey(entity.getKey());
        model.setPlace((java.lang.String) entity.getProperty("place"));
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        tddbc.sapporo.model.ConferenceRoom m = (tddbc.sapporo.model.ConferenceRoom) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("capacity", m.getCapacity());
        entity.setProperty("place", m.getPlace());
        entity.setProperty("title", m.getTitle());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        tddbc.sapporo.model.ConferenceRoom m = (tddbc.sapporo.model.ConferenceRoom) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        tddbc.sapporo.model.ConferenceRoom m = (tddbc.sapporo.model.ConferenceRoom) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        tddbc.sapporo.model.ConferenceRoom m = (tddbc.sapporo.model.ConferenceRoom) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        tddbc.sapporo.model.ConferenceRoom m = (tddbc.sapporo.model.ConferenceRoom) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
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
        tddbc.sapporo.model.ConferenceRoom m = (tddbc.sapporo.model.ConferenceRoom) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("capacity");
        encoder0.encode(writer, m.getCapacity());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getPlace() != null){
            writer.setNextPropertyName("place");
            encoder0.encode(writer, m.getPlace());
        }
        if(m.getTitle() != null){
            writer.setNextPropertyName("title");
            encoder0.encode(writer, m.getTitle());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected tddbc.sapporo.model.ConferenceRoom jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        tddbc.sapporo.model.ConferenceRoom m = new tddbc.sapporo.model.ConferenceRoom();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("capacity");
        m.setCapacity(decoder0.decode(reader, m.getCapacity()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("place");
        m.setPlace(decoder0.decode(reader, m.getPlace()));
        reader = rootReader.newObjectReader("title");
        m.setTitle(decoder0.decode(reader, m.getTitle()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}