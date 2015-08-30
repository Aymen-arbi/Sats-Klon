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
import se.greatbrain.sats.data.model.Type;

public class TypeRealmProxy extends Type {

    private static long INDEX_NAME;
    private static long INDEX_SUBTYPE;
    private static long INDEX_TYPE;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("subType");
        fieldNames.add("type");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
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
    public String getSubType() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_SUBTYPE);
    }

    @Override
    public void setSubType(String value) {
        realm.checkIfValid();
        row.setString(INDEX_SUBTYPE, (String) value);
    }

    @Override
    public String getType() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_TYPE);
    }

    @Override
    public void setType(String value) {
        realm.checkIfValid();
        row.setString(INDEX_TYPE, (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_Type")) {
            Table table = transaction.getTable("class_Type");
            table.addColumn(ColumnType.STRING, "name");
            table.addColumn(ColumnType.STRING, "subType");
            table.addColumn(ColumnType.STRING, "type");
            table.setIndex(table.getColumnIndex("name"));
            table.setPrimaryKey("name");
            return table;
        }
        return transaction.getTable("class_Type");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_Type")) {
            Table table = transaction.getTable("class_Type");
            if(table.getColumnCount() != 3) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 3; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("name")) {
                throw new IllegalStateException("Missing column 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'name'");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("name")) {
                throw new IllegalStateException("Primary key not defined for field 'name'");
            }
            if (!table.hasIndex(table.getColumnIndex("name"))) {
                throw new IllegalStateException("Index not defined for field 'name'");
            }
            if (!columnTypes.containsKey("subType")) {
                throw new IllegalStateException("Missing column 'subType'");
            }
            if (columnTypes.get("subType") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'subType'");
            }
            if (!columnTypes.containsKey("type")) {
                throw new IllegalStateException("Missing column 'type'");
            }
            if (columnTypes.get("type") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'type'");
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException("Field '" + fieldName + "' not found for type Type");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_SUBTYPE = table.getColumnIndex("subType");
            INDEX_TYPE = table.getColumnIndex("type");
        } else {
            throw new RealmMigrationNeededException("The Type class is missing from the schema for this Realm.");
        }
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Type createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Type obj = null;
        if (update) {
            Table table = realm.getTable(Type.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("name")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("name"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new TypeRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(Type.class);
        }
        if (!json.isNull("name")) {
            obj.setName((String) json.getString("name"));
        }
        if (!json.isNull("subType")) {
            obj.setSubType((String) json.getString("subType"));
        }
        if (!json.isNull("type")) {
            obj.setType((String) json.getString("type"));
        }
        return obj;
    }

    public static Type createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Type obj = realm.createObject(Type.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name") && reader.peek() != JsonToken.NULL) {
                obj.setName((String) reader.nextString());
            } else if (name.equals("subType")  && reader.peek() != JsonToken.NULL) {
                obj.setSubType((String) reader.nextString());
            } else if (name.equals("type")  && reader.peek() != JsonToken.NULL) {
                obj.setType((String) reader.nextString());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Type copyOrUpdate(Realm realm, Type object, boolean update, Map<RealmObject,RealmObject> cache) {
        if (object.realm != null && object.realm.getId() == realm.getId()) {
            return object;
        }
        Type realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(Type.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstString(pkColumnIndex, object.getName());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new TypeRealmProxy();
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

    public static Type copy(Realm realm, Type newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        Type realmObject = realm.createObject(Type.class, newObject.getName());
        cache.put(newObject, realmObject);
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setSubType(newObject.getSubType() != null ? newObject.getSubType() : "");
        realmObject.setType(newObject.getType() != null ? newObject.getType() : "");
        return realmObject;
    }

    static Type update(Realm realm, Type realmObject, Type newObject, Map<RealmObject, RealmObject> cache) {
        realmObject.setSubType(newObject.getSubType() != null ? newObject.getSubType() : "");
        realmObject.setType(newObject.getType() != null ? newObject.getType() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Type = [");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subType:");
        stringBuilder.append(getSubType());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(getType());
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
        TypeRealmProxy aType = (TypeRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aType.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aType.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aType.row.getIndex()) return false;

        return true;
    }

}
