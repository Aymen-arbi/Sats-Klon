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
import se.greatbrain.sats.data.model.Profile;

public class ProfileRealmProxy extends Profile {

    private static long INDEX_ID;
    private static long INDEX_NAME;
    private static long INDEX_VALUE;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("value");
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
    public int getValue() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_VALUE);
    }

    @Override
    public void setValue(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_VALUE, (long) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_Profile")) {
            Table table = transaction.getTable("class_Profile");
            table.addColumn(ColumnType.STRING, "id");
            table.addColumn(ColumnType.STRING, "name");
            table.addColumn(ColumnType.INTEGER, "value");
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Profile");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_Profile")) {
            Table table = transaction.getTable("class_Profile");
            if(table.getColumnCount() != 3) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 3; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("id")) {
                throw new IllegalStateException("Missing column 'id'");
            }
            if (columnTypes.get("id") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'id'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new IllegalStateException("Missing column 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'name'");
            }
            if (!columnTypes.containsKey("value")) {
                throw new IllegalStateException("Missing column 'value'");
            }
            if (columnTypes.get("value") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'value'");
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException("Field '" + fieldName + "' not found for type Profile");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_VALUE = table.getColumnIndex("value");
        } else {
            throw new RealmMigrationNeededException("The Profile class is missing from the schema for this Realm.");
        }
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Profile createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Profile obj = realm.createObject(Profile.class);
        if (!json.isNull("id")) {
            obj.setId((String) json.getString("id"));
        }
        if (!json.isNull("name")) {
            obj.setName((String) json.getString("name"));
        }
        if (!json.isNull("value")) {
            obj.setValue((int) json.getInt("value"));
        }
        return obj;
    }

    public static Profile createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Profile obj = realm.createObject(Profile.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((String) reader.nextString());
            } else if (name.equals("name")  && reader.peek() != JsonToken.NULL) {
                obj.setName((String) reader.nextString());
            } else if (name.equals("value")  && reader.peek() != JsonToken.NULL) {
                obj.setValue((int) reader.nextInt());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Profile copyOrUpdate(Realm realm, Profile object, boolean update, Map<RealmObject,RealmObject> cache) {
        if (object.realm != null && object.realm.getId() == realm.getId()) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Profile copy(Realm realm, Profile newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        Profile realmObject = realm.createObject(Profile.class);
        cache.put(newObject, realmObject);
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setValue(newObject.getValue());
        return realmObject;
    }

    static Profile update(Realm realm, Profile realmObject, Profile newObject, Map<RealmObject, RealmObject> cache) {
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setValue(newObject.getValue());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Profile = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{value:");
        stringBuilder.append(getValue());
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
        ProfileRealmProxy aProfile = (ProfileRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aProfile.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aProfile.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aProfile.row.getIndex()) return false;

        return true;
    }

}
