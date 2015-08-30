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

public class ClassCategoryIdsRealmProxy extends ClassCategoryIds {

    private static long INDEX_ID;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
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

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_ClassCategoryIds")) {
            Table table = transaction.getTable("class_ClassCategoryIds");
            table.addColumn(ColumnType.STRING, "id");
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_ClassCategoryIds");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_ClassCategoryIds")) {
            Table table = transaction.getTable("class_ClassCategoryIds");
            if(table.getColumnCount() != 1) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 1; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("id")) {
                throw new IllegalStateException("Missing column 'id'");
            }
            if (columnTypes.get("id") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'id'");
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException("Field '" + fieldName + "' not found for type ClassCategoryIds");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
        } else {
            throw new RealmMigrationNeededException("The ClassCategoryIds class is missing from the schema for this Realm.");
        }
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static ClassCategoryIds createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        ClassCategoryIds obj = realm.createObject(ClassCategoryIds.class);
        if (!json.isNull("id")) {
            obj.setId((String) json.getString("id"));
        }
        return obj;
    }

    public static ClassCategoryIds createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        ClassCategoryIds obj = realm.createObject(ClassCategoryIds.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((String) reader.nextString());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static ClassCategoryIds copyOrUpdate(Realm realm, ClassCategoryIds object, boolean update, Map<RealmObject,RealmObject> cache) {
        if (object.realm != null && object.realm.getId() == realm.getId()) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static ClassCategoryIds copy(Realm realm, ClassCategoryIds newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        ClassCategoryIds realmObject = realm.createObject(ClassCategoryIds.class);
        cache.put(newObject, realmObject);
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        return realmObject;
    }

    static ClassCategoryIds update(Realm realm, ClassCategoryIds realmObject, ClassCategoryIds newObject, Map<RealmObject, RealmObject> cache) {
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ClassCategoryIds = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
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
        ClassCategoryIdsRealmProxy aClassCategoryIds = (ClassCategoryIdsRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aClassCategoryIds.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aClassCategoryIds.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aClassCategoryIds.row.getIndex()) return false;

        return true;
    }

}
