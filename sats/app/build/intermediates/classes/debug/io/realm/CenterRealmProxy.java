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
import se.greatbrain.sats.data.model.Center;

public class CenterRealmProxy extends Center {

    private static long INDEX_ID;
    private static long INDEX_AVAILABLEFORONLINEBOOKING;
    private static long INDEX_DESCRIPTION;
    private static long INDEX_FILTERID;
    private static long INDEX_LAT;
    private static long INDEX_LNG;
    private static long INDEX_NAME;
    private static long INDEX_REGIONID;
    private static long INDEX_URL;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("availableForOnlineBooking");
        fieldNames.add("description");
        fieldNames.add("filterId");
        fieldNames.add("lat");
        fieldNames.add("lng");
        fieldNames.add("name");
        fieldNames.add("regionId");
        fieldNames.add("url");
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
    public boolean isAvailableForOnlineBooking() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(INDEX_AVAILABLEFORONLINEBOOKING);
    }

    @Override
    public void setAvailableForOnlineBooking(boolean value) {
        realm.checkIfValid();
        row.setBoolean(INDEX_AVAILABLEFORONLINEBOOKING, (boolean) value);
    }

    @Override
    public String getDescription() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_DESCRIPTION);
    }

    @Override
    public void setDescription(String value) {
        realm.checkIfValid();
        row.setString(INDEX_DESCRIPTION, (String) value);
    }

    @Override
    public String getFilterId() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_FILTERID);
    }

    @Override
    public void setFilterId(String value) {
        realm.checkIfValid();
        row.setString(INDEX_FILTERID, (String) value);
    }

    @Override
    public float getLat() {
        realm.checkIfValid();
        return (float) row.getFloat(INDEX_LAT);
    }

    @Override
    public void setLat(float value) {
        realm.checkIfValid();
        row.setFloat(INDEX_LAT, (float) value);
    }

    @Override
    public float getLng() {
        realm.checkIfValid();
        return (float) row.getFloat(INDEX_LNG);
    }

    @Override
    public void setLng(float value) {
        realm.checkIfValid();
        row.setFloat(INDEX_LNG, (float) value);
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
    public String getUrl() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_URL);
    }

    @Override
    public void setUrl(String value) {
        realm.checkIfValid();
        row.setString(INDEX_URL, (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_Center")) {
            Table table = transaction.getTable("class_Center");
            table.addColumn(ColumnType.STRING, "id");
            table.addColumn(ColumnType.BOOLEAN, "availableForOnlineBooking");
            table.addColumn(ColumnType.STRING, "description");
            table.addColumn(ColumnType.STRING, "filterId");
            table.addColumn(ColumnType.FLOAT, "lat");
            table.addColumn(ColumnType.FLOAT, "lng");
            table.addColumn(ColumnType.STRING, "name");
            table.addColumn(ColumnType.STRING, "regionId");
            table.addColumn(ColumnType.STRING, "url");
            table.setIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_Center");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_Center")) {
            Table table = transaction.getTable("class_Center");
            if(table.getColumnCount() != 9) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 9; i++) {
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
            if (!columnTypes.containsKey("availableForOnlineBooking")) {
                throw new IllegalStateException("Missing column 'availableForOnlineBooking'");
            }
            if (columnTypes.get("availableForOnlineBooking") != ColumnType.BOOLEAN) {
                throw new IllegalStateException("Invalid type 'boolean' for column 'availableForOnlineBooking'");
            }
            if (!columnTypes.containsKey("description")) {
                throw new IllegalStateException("Missing column 'description'");
            }
            if (columnTypes.get("description") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'description'");
            }
            if (!columnTypes.containsKey("filterId")) {
                throw new IllegalStateException("Missing column 'filterId'");
            }
            if (columnTypes.get("filterId") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'filterId'");
            }
            if (!columnTypes.containsKey("lat")) {
                throw new IllegalStateException("Missing column 'lat'");
            }
            if (columnTypes.get("lat") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'lat'");
            }
            if (!columnTypes.containsKey("lng")) {
                throw new IllegalStateException("Missing column 'lng'");
            }
            if (columnTypes.get("lng") != ColumnType.FLOAT) {
                throw new IllegalStateException("Invalid type 'float' for column 'lng'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new IllegalStateException("Missing column 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'name'");
            }
            if (!columnTypes.containsKey("regionId")) {
                throw new IllegalStateException("Missing column 'regionId'");
            }
            if (columnTypes.get("regionId") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'regionId'");
            }
            if (!columnTypes.containsKey("url")) {
                throw new IllegalStateException("Missing column 'url'");
            }
            if (columnTypes.get("url") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'url'");
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException("Field '" + fieldName + "' not found for type Center");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_AVAILABLEFORONLINEBOOKING = table.getColumnIndex("availableForOnlineBooking");
            INDEX_DESCRIPTION = table.getColumnIndex("description");
            INDEX_FILTERID = table.getColumnIndex("filterId");
            INDEX_LAT = table.getColumnIndex("lat");
            INDEX_LNG = table.getColumnIndex("lng");
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_REGIONID = table.getColumnIndex("regionId");
            INDEX_URL = table.getColumnIndex("url");
        } else {
            throw new RealmMigrationNeededException("The Center class is missing from the schema for this Realm.");
        }
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Center createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Center obj = null;
        if (update) {
            Table table = realm.getTable(Center.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("id")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new CenterRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(Center.class);
        }
        if (!json.isNull("id")) {
            obj.setId((String) json.getString("id"));
        }
        if (!json.isNull("availableForOnlineBooking")) {
            obj.setAvailableForOnlineBooking((boolean) json.getBoolean("availableForOnlineBooking"));
        }
        if (!json.isNull("description")) {
            obj.setDescription((String) json.getString("description"));
        }
        if (!json.isNull("filterId")) {
            obj.setFilterId((String) json.getString("filterId"));
        }
        if (!json.isNull("lat")) {
            obj.setLat((float) json.getDouble("lat"));
        }
        if (!json.isNull("lng")) {
            obj.setLng((float) json.getDouble("lng"));
        }
        if (!json.isNull("name")) {
            obj.setName((String) json.getString("name"));
        }
        if (!json.isNull("regionId")) {
            obj.setRegionId((String) json.getString("regionId"));
        }
        if (!json.isNull("url")) {
            obj.setUrl((String) json.getString("url"));
        }
        return obj;
    }

    public static Center createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Center obj = realm.createObject(Center.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((String) reader.nextString());
            } else if (name.equals("availableForOnlineBooking")  && reader.peek() != JsonToken.NULL) {
                obj.setAvailableForOnlineBooking((boolean) reader.nextBoolean());
            } else if (name.equals("description")  && reader.peek() != JsonToken.NULL) {
                obj.setDescription((String) reader.nextString());
            } else if (name.equals("filterId")  && reader.peek() != JsonToken.NULL) {
                obj.setFilterId((String) reader.nextString());
            } else if (name.equals("lat")  && reader.peek() != JsonToken.NULL) {
                obj.setLat((float) reader.nextDouble());
            } else if (name.equals("lng")  && reader.peek() != JsonToken.NULL) {
                obj.setLng((float) reader.nextDouble());
            } else if (name.equals("name")  && reader.peek() != JsonToken.NULL) {
                obj.setName((String) reader.nextString());
            } else if (name.equals("regionId")  && reader.peek() != JsonToken.NULL) {
                obj.setRegionId((String) reader.nextString());
            } else if (name.equals("url")  && reader.peek() != JsonToken.NULL) {
                obj.setUrl((String) reader.nextString());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Center copyOrUpdate(Realm realm, Center object, boolean update, Map<RealmObject,RealmObject> cache) {
        if (object.realm != null && object.realm.getId() == realm.getId()) {
            return object;
        }
        Center realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(Center.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstString(pkColumnIndex, object.getId());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new CenterRealmProxy();
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

    public static Center copy(Realm realm, Center newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        Center realmObject = realm.createObject(Center.class, newObject.getId());
        cache.put(newObject, realmObject);
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        realmObject.setAvailableForOnlineBooking(newObject.isAvailableForOnlineBooking());
        realmObject.setDescription(newObject.getDescription() != null ? newObject.getDescription() : "");
        realmObject.setFilterId(newObject.getFilterId() != null ? newObject.getFilterId() : "");
        realmObject.setLat(newObject.getLat());
        realmObject.setLng(newObject.getLng());
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setRegionId(newObject.getRegionId() != null ? newObject.getRegionId() : "");
        realmObject.setUrl(newObject.getUrl() != null ? newObject.getUrl() : "");
        return realmObject;
    }

    static Center update(Realm realm, Center realmObject, Center newObject, Map<RealmObject, RealmObject> cache) {
        realmObject.setAvailableForOnlineBooking(newObject.isAvailableForOnlineBooking());
        realmObject.setDescription(newObject.getDescription() != null ? newObject.getDescription() : "");
        realmObject.setFilterId(newObject.getFilterId() != null ? newObject.getFilterId() : "");
        realmObject.setLat(newObject.getLat());
        realmObject.setLng(newObject.getLng());
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setRegionId(newObject.getRegionId() != null ? newObject.getRegionId() : "");
        realmObject.setUrl(newObject.getUrl() != null ? newObject.getUrl() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Center = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{availableForOnlineBooking:");
        stringBuilder.append(isAvailableForOnlineBooking());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(getDescription());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{filterId:");
        stringBuilder.append(getFilterId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lat:");
        stringBuilder.append(getLat());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lng:");
        stringBuilder.append(getLng());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{regionId:");
        stringBuilder.append(getRegionId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{url:");
        stringBuilder.append(getUrl());
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
        CenterRealmProxy aCenter = (CenterRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aCenter.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aCenter.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aCenter.row.getIndex()) return false;

        return true;
    }

}
