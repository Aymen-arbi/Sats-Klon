package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObject;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import se.greatbrain.sats.data.model.ClassCategoryIds;
import se.greatbrain.sats.data.model.SatsClass;

public class SatsClassRealmProxy extends SatsClass {

    private static long INDEX_ID;
    private static long INDEX_CENTERFILTERID;
    private static long INDEX_CLASSTYPEID;
    private static long INDEX_DURATIONINMINUTES;
    private static long INDEX_INSTRUCTORID;
    private static long INDEX_NAME;
    private static long INDEX_STARTTIME;
    private static long INDEX_BOOKEDPERSONSCOUNT;
    private static long INDEX_MAXPERSONSCOUNT;
    private static long INDEX_REGIONID;
    private static long INDEX_WAITINGLISTCOUNT;
    private static long INDEX_CLASSCATEGORYIDS;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("centerFilterId");
        fieldNames.add("classTypeId");
        fieldNames.add("durationInMinutes");
        fieldNames.add("instructorId");
        fieldNames.add("name");
        fieldNames.add("startTime");
        fieldNames.add("bookedPersonsCount");
        fieldNames.add("maxPersonsCount");
        fieldNames.add("regionId");
        fieldNames.add("waitingListCount");
        fieldNames.add("classCategoryIds");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    @Override
    public String getId() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_ID);
    }

    @Override
    public void setId(String value) {
        realm.checkIfValid();
        row.setString(INDEX_ID, (String) value);
    }

    @Override
    public String getCenterFilterId() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_CENTERFILTERID);
    }

    @Override
    public void setCenterFilterId(String value) {
        realm.checkIfValid();
        row.setString(INDEX_CENTERFILTERID, (String) value);
    }

    @Override
    public String getClassTypeId() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_CLASSTYPEID);
    }

    @Override
    public void setClassTypeId(String value) {
        realm.checkIfValid();
        row.setString(INDEX_CLASSTYPEID, (String) value);
    }

    @Override
    public int getDurationInMinutes() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_DURATIONINMINUTES);
    }

    @Override
    public void setDurationInMinutes(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_DURATIONINMINUTES, (long) value);
    }

    @Override
    public String getInstructorId() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_INSTRUCTORID);
    }

    @Override
    public void setInstructorId(String value) {
        realm.checkIfValid();
        row.setString(INDEX_INSTRUCTORID, (String) value);
    }

    @Override
    public String getName() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_NAME);
    }

    @Override
    public void setName(String value) {
        realm.checkIfValid();
        row.setString(INDEX_NAME, (String) value);
    }

    @Override
    public String getStartTime() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_STARTTIME);
    }

    @Override
    public void setStartTime(String value) {
        realm.checkIfValid();
        row.setString(INDEX_STARTTIME, (String) value);
    }

    @Override
    public int getBookedPersonsCount() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_BOOKEDPERSONSCOUNT);
    }

    @Override
    public void setBookedPersonsCount(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_BOOKEDPERSONSCOUNT, (long) value);
    }

    @Override
    public int getMaxPersonsCount() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_MAXPERSONSCOUNT);
    }

    @Override
    public void setMaxPersonsCount(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_MAXPERSONSCOUNT, (long) value);
    }

    @Override
    public String getRegionId() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_REGIONID);
    }

    @Override
    public void setRegionId(String value) {
        realm.checkIfValid();
        row.setString(INDEX_REGIONID, (String) value);
    }

    @Override
    public int getWaitingListCount() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_WAITINGLISTCOUNT);
    }

    @Override
    public void setWaitingListCount(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_WAITINGLISTCOUNT, (long) value);
    }

    @Override
    public RealmList<ClassCategoryIds> getClassCategoryIds() {
        return new RealmList<ClassCategoryIds>(ClassCategoryIds.class, row.getLinkList(INDEX_CLASSCATEGORYIDS), realm);
    }

    @Override
    public void setClassCategoryIds(RealmList<ClassCategoryIds> value) {
        LinkView links = row.getLinkList(INDEX_CLASSCATEGORYIDS);
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_SatsClass")) {
            Table table = transaction.getTable("class_SatsClass");
            table.addColumn(ColumnType.STRING, "id");
            table.addColumn(ColumnType.STRING, "centerFilterId");
            table.addColumn(ColumnType.STRING, "classTypeId");
            table.addColumn(ColumnType.INTEGER, "durationInMinutes");
            table.addColumn(ColumnType.STRING, "instructorId");
            table.addColumn(ColumnType.STRING, "name");
            table.addColumn(ColumnType.STRING, "startTime");
            table.addColumn(ColumnType.INTEGER, "bookedPersonsCount");
            table.addColumn(ColumnType.INTEGER, "maxPersonsCount");
            table.addColumn(ColumnType.STRING, "regionId");
            table.addColumn(ColumnType.INTEGER, "waitingListCount");
            if (!transaction.hasTable("class_ClassCategoryIds")) {
                ClassCategoryIdsRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "classCategoryIds", transaction.getTable("class_ClassCategoryIds"));
            table.setIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_SatsClass");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_SatsClass")) {
            Table table = transaction.getTable("class_SatsClass");
            if(table.getColumnCount() != 12) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 12; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("id")) {
                throw new IllegalStateException("Missing column 'id'");
            }
            if (columnTypes.get("id") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'id'");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new IllegalStateException("Primary key not defined for field 'id'");
            }
            if (!table.hasIndex(table.getColumnIndex("id"))) {
                throw new IllegalStateException("Index not defined for field 'id'");
            }
            if (!columnTypes.containsKey("centerFilterId")) {
                throw new IllegalStateException("Missing column 'centerFilterId'");
            }
            if (columnTypes.get("centerFilterId") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'centerFilterId'");
            }
            if (!columnTypes.containsKey("classTypeId")) {
                throw new IllegalStateException("Missing column 'classTypeId'");
            }
            if (columnTypes.get("classTypeId") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'classTypeId'");
            }
            if (!columnTypes.containsKey("durationInMinutes")) {
                throw new IllegalStateException("Missing column 'durationInMinutes'");
            }
            if (columnTypes.get("durationInMinutes") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'durationInMinutes'");
            }
            if (!columnTypes.containsKey("instructorId")) {
                throw new IllegalStateException("Missing column 'instructorId'");
            }
            if (columnTypes.get("instructorId") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'instructorId'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new IllegalStateException("Missing column 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'name'");
            }
            if (!columnTypes.containsKey("startTime")) {
                throw new IllegalStateException("Missing column 'startTime'");
            }
            if (columnTypes.get("startTime") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'startTime'");
            }
            if (!columnTypes.containsKey("bookedPersonsCount")) {
                throw new IllegalStateException("Missing column 'bookedPersonsCount'");
            }
            if (columnTypes.get("bookedPersonsCount") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'bookedPersonsCount'");
            }
            if (!columnTypes.containsKey("maxPersonsCount")) {
                throw new IllegalStateException("Missing column 'maxPersonsCount'");
            }
            if (columnTypes.get("maxPersonsCount") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'maxPersonsCount'");
            }
            if (!columnTypes.containsKey("regionId")) {
                throw new IllegalStateException("Missing column 'regionId'");
            }
            if (columnTypes.get("regionId") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'regionId'");
            }
            if (!columnTypes.containsKey("waitingListCount")) {
                throw new IllegalStateException("Missing column 'waitingListCount'");
            }
            if (columnTypes.get("waitingListCount") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'waitingListCount'");
            }
            if(!columnTypes.containsKey("classCategoryIds")) {
                throw new IllegalStateException("Missing column 'classCategoryIds'");
            }
            if(columnTypes.get("classCategoryIds") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'ClassCategoryIds' for column 'classCategoryIds'");
            }
            if (!transaction.hasTable("class_ClassCategoryIds")) {
                throw new IllegalStateException("Missing table 'class_ClassCategoryIds' for column 'classCategoryIds'");
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException("Field '" + fieldName + "' not found for type SatsClass");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_CENTERFILTERID = table.getColumnIndex("centerFilterId");
            INDEX_CLASSTYPEID = table.getColumnIndex("classTypeId");
            INDEX_DURATIONINMINUTES = table.getColumnIndex("durationInMinutes");
            INDEX_INSTRUCTORID = table.getColumnIndex("instructorId");
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_STARTTIME = table.getColumnIndex("startTime");
            INDEX_BOOKEDPERSONSCOUNT = table.getColumnIndex("bookedPersonsCount");
            INDEX_MAXPERSONSCOUNT = table.getColumnIndex("maxPersonsCount");
            INDEX_REGIONID = table.getColumnIndex("regionId");
            INDEX_WAITINGLISTCOUNT = table.getColumnIndex("waitingListCount");
            INDEX_CLASSCATEGORYIDS = table.getColumnIndex("classCategoryIds");
        } else {
            throw new RealmMigrationNeededException("The SatsClass class is missing from the schema for this Realm.");
        }
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static SatsClass createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        SatsClass obj = null;
        if (update) {
            Table table = realm.getTable(SatsClass.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("id")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new SatsClassRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(SatsClass.class);
        }
        if (!json.isNull("id")) {
            obj.setId((String) json.getString("id"));
        }
        if (!json.isNull("centerFilterId")) {
            obj.setCenterFilterId((String) json.getString("centerFilterId"));
        }
        if (!json.isNull("classTypeId")) {
            obj.setClassTypeId((String) json.getString("classTypeId"));
        }
        if (!json.isNull("durationInMinutes")) {
            obj.setDurationInMinutes((int) json.getInt("durationInMinutes"));
        }
        if (!json.isNull("instructorId")) {
            obj.setInstructorId((String) json.getString("instructorId"));
        }
        if (!json.isNull("name")) {
            obj.setName((String) json.getString("name"));
        }
        if (!json.isNull("startTime")) {
            obj.setStartTime((String) json.getString("startTime"));
        }
        if (!json.isNull("bookedPersonsCount")) {
            obj.setBookedPersonsCount((int) json.getInt("bookedPersonsCount"));
        }
        if (!json.isNull("maxPersonsCount")) {
            obj.setMaxPersonsCount((int) json.getInt("maxPersonsCount"));
        }
        if (!json.isNull("regionId")) {
            obj.setRegionId((String) json.getString("regionId"));
        }
        if (!json.isNull("waitingListCount")) {
            obj.setWaitingListCount((int) json.getInt("waitingListCount"));
        }
        if (!json.isNull("classCategoryIds")) {
            obj.getClassCategoryIds().clear();
            JSONArray array = json.getJSONArray("classCategoryIds");
            for (int i = 0; i < array.length(); i++) {
                se.greatbrain.sats.data.model.ClassCategoryIds item = ClassCategoryIdsRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                obj.getClassCategoryIds().add(item);
            }
        }
        return obj;
    }

    public static SatsClass createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        SatsClass obj = realm.createObject(SatsClass.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((String) reader.nextString());
            } else if (name.equals("centerFilterId")  && reader.peek() != JsonToken.NULL) {
                obj.setCenterFilterId((String) reader.nextString());
            } else if (name.equals("classTypeId")  && reader.peek() != JsonToken.NULL) {
                obj.setClassTypeId((String) reader.nextString());
            } else if (name.equals("durationInMinutes")  && reader.peek() != JsonToken.NULL) {
                obj.setDurationInMinutes((int) reader.nextInt());
            } else if (name.equals("instructorId")  && reader.peek() != JsonToken.NULL) {
                obj.setInstructorId((String) reader.nextString());
            } else if (name.equals("name")  && reader.peek() != JsonToken.NULL) {
                obj.setName((String) reader.nextString());
            } else if (name.equals("startTime")  && reader.peek() != JsonToken.NULL) {
                obj.setStartTime((String) reader.nextString());
            } else if (name.equals("bookedPersonsCount")  && reader.peek() != JsonToken.NULL) {
                obj.setBookedPersonsCount((int) reader.nextInt());
            } else if (name.equals("maxPersonsCount")  && reader.peek() != JsonToken.NULL) {
                obj.setMaxPersonsCount((int) reader.nextInt());
            } else if (name.equals("regionId")  && reader.peek() != JsonToken.NULL) {
                obj.setRegionId((String) reader.nextString());
            } else if (name.equals("waitingListCount")  && reader.peek() != JsonToken.NULL) {
                obj.setWaitingListCount((int) reader.nextInt());
            } else if (name.equals("classCategoryIds")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    se.greatbrain.sats.data.model.ClassCategoryIds item = ClassCategoryIdsRealmProxy.createUsingJsonStream(realm, reader);
                    obj.getClassCategoryIds().add(item);
                }
                reader.endArray();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static SatsClass copyOrUpdate(Realm realm, SatsClass object, boolean update, Map<RealmObject,RealmObject> cache) {
        if (object.realm != null && object.realm.getId() == realm.getId()) {
            return object;
        }
        SatsClass realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(SatsClass.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstString(pkColumnIndex, object.getId());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new SatsClassRealmProxy();
                realmObject.realm = realm;
                realmObject.row = table.getRow(rowIndex);
                cache.put(object, realmObject);
            } else {
                canUpdate = false;
            }
        }

        if (canUpdate) {
            return update(realm, realmObject, object, cache);
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static SatsClass copy(Realm realm, SatsClass newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        SatsClass realmObject = realm.createObject(SatsClass.class, newObject.getId());
        cache.put(newObject, realmObject);
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        realmObject.setCenterFilterId(newObject.getCenterFilterId() != null ? newObject.getCenterFilterId() : "");
        realmObject.setClassTypeId(newObject.getClassTypeId() != null ? newObject.getClassTypeId() : "");
        realmObject.setDurationInMinutes(newObject.getDurationInMinutes());
        realmObject.setInstructorId(newObject.getInstructorId() != null ? newObject.getInstructorId() : "");
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setStartTime(newObject.getStartTime() != null ? newObject.getStartTime() : "");
        realmObject.setBookedPersonsCount(newObject.getBookedPersonsCount());
        realmObject.setMaxPersonsCount(newObject.getMaxPersonsCount());
        realmObject.setRegionId(newObject.getRegionId() != null ? newObject.getRegionId() : "");
        realmObject.setWaitingListCount(newObject.getWaitingListCount());

        RealmList<ClassCategoryIds> classCategoryIdsList = newObject.getClassCategoryIds();
        if (classCategoryIdsList != null) {
            RealmList<ClassCategoryIds> classCategoryIdsRealmList = realmObject.getClassCategoryIds();
            for (int i = 0; i < classCategoryIdsList.size(); i++) {
                ClassCategoryIds classCategoryIdsItem = classCategoryIdsList.get(i);
                ClassCategoryIds cacheclassCategoryIds = (ClassCategoryIds) cache.get(classCategoryIdsItem);
                if (cacheclassCategoryIds != null) {
                    classCategoryIdsRealmList.add(cacheclassCategoryIds);
                } else {
                    classCategoryIdsRealmList.add(ClassCategoryIdsRealmProxy.copyOrUpdate(realm, classCategoryIdsList.get(i), update, cache));
                }
            }
        }

        return realmObject;
    }

    static SatsClass update(Realm realm, SatsClass realmObject, SatsClass newObject, Map<RealmObject, RealmObject> cache) {
        realmObject.setCenterFilterId(newObject.getCenterFilterId() != null ? newObject.getCenterFilterId() : "");
        realmObject.setClassTypeId(newObject.getClassTypeId() != null ? newObject.getClassTypeId() : "");
        realmObject.setDurationInMinutes(newObject.getDurationInMinutes());
        realmObject.setInstructorId(newObject.getInstructorId() != null ? newObject.getInstructorId() : "");
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setStartTime(newObject.getStartTime() != null ? newObject.getStartTime() : "");
        realmObject.setBookedPersonsCount(newObject.getBookedPersonsCount());
        realmObject.setMaxPersonsCount(newObject.getMaxPersonsCount());
        realmObject.setRegionId(newObject.getRegionId() != null ? newObject.getRegionId() : "");
        realmObject.setWaitingListCount(newObject.getWaitingListCount());
        RealmList<ClassCategoryIds> classCategoryIdsList = newObject.getClassCategoryIds();
        RealmList<ClassCategoryIds> classCategoryIdsRealmList = realmObject.getClassCategoryIds();
        classCategoryIdsRealmList.clear();
        if (classCategoryIdsList != null) {
            for (int i = 0; i < classCategoryIdsList.size(); i++) {
                ClassCategoryIds classCategoryIdsItem = classCategoryIdsList.get(i);
                ClassCategoryIds cacheclassCategoryIds = (ClassCategoryIds) cache.get(classCategoryIdsItem);
                if (cacheclassCategoryIds != null) {
                    classCategoryIdsRealmList.add(cacheclassCategoryIds);
                } else {
                    classCategoryIdsRealmList.add(ClassCategoryIdsRealmProxy.copyOrUpdate(realm, classCategoryIdsList.get(i), true, cache));
                }
            }
        }
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SatsClass = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{centerFilterId:");
        stringBuilder.append(getCenterFilterId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{classTypeId:");
        stringBuilder.append(getClassTypeId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{durationInMinutes:");
        stringBuilder.append(getDurationInMinutes());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{instructorId:");
        stringBuilder.append(getInstructorId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{startTime:");
        stringBuilder.append(getStartTime());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bookedPersonsCount:");
        stringBuilder.append(getBookedPersonsCount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxPersonsCount:");
        stringBuilder.append(getMaxPersonsCount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{regionId:");
        stringBuilder.append(getRegionId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{waitingListCount:");
        stringBuilder.append(getWaitingListCount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{classCategoryIds:");
        stringBuilder.append("RealmList<ClassCategoryIds>[").append(getClassCategoryIds().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        String realmName = realm.getPath();
        String tableName = row.getTable().getName();
        long rowIndex = row.getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SatsClassRealmProxy aSatsClass = (SatsClassRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aSatsClass.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aSatsClass.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aSatsClass.row.getIndex()) return false;

        return true;
    }

}
