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
import se.greatbrain.sats.data.model.Instructor;

public class InstructorRealmProxy extends Instructor {

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
        if(!transaction.hasTable("class_Instructor")) {
            Table table = transaction.getTable("class_Instructor");
            table.addColumn(ColumnType.STRING, "id");
            table.setIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_Instructor");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_Instructor")) {
            Table table = transaction.getTable("class_Instructor");
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
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new IllegalStateException("Primary key not defined for field 'id'");
            }
            if (!table.hasIndex(table.getColumnIndex("id"))) {
                throw new IllegalStateException("Index not defined for field 'id'");
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException("Field '" + fieldName + "' not found for type Instructor");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
        } else {
            throw new RealmMigrationNeededException("The Instructor class is missing from the schema for this Realm.");
        }
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Instructor createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Instructor obj = null;
        if (update) {
            Table table = realm.getTable(Instructor.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("id")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new InstructorRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(Instructor.class);
        }
        if (!json.isNull("id")) {
            obj.setId((String) json.getString("id"));
        }
        return obj;
    }

    public static Instructor createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Instructor obj = realm.createObject(Instructor.class);
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

    public static Instructor copyOrUpdate(Realm realm, Instructor object, boolean update, Map<RealmObject,RealmObject> cache) {
        if (object.realm != null && object.realm.getId() == realm.getId()) {
            return object;
        }
        Instructor realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(Instructor.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstString(pkColumnIndex, object.getId());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new InstructorRealmProxy();
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

    public static Instructor copy(Realm realm, Instructor newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        Instructor realmObject = realm.createObject(Instructor.class, newObject.getId());
        cache.put(newObject, realmObject);
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        return realmObject;
    }

    static Instructor update(Realm realm, Instructor realmObject, Instructor newObject, Map<RealmObject, RealmObject> cache) {
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Instructor = [");
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
        InstructorRealmProxy aInstructor = (InstructorRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aInstructor.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aInstructor.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aInstructor.row.getIndex()) return false;

        return true;
    }

}
