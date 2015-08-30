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
import se.greatbrain.sats.data.model.Region;

public class RegionRealmProxy extends Region {

    private static long INDEX_ID;
    private static long INDEX_NAME;
    private static long INDEX_CENTERS;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("centers");
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
    public RealmList<Center> getCenters() {
        return new RealmList<Center>(Center.class, row.getLinkList(INDEX_CENTERS), realm);
    }

    @Override
    public void setCenters(RealmList<Center> value) {
        LinkView links = row.getLinkList(INDEX_CENTERS);
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_Region")) {
            Table table = transaction.getTable("class_Region");
            table.addColumn(ColumnType.STRING, "id");
            table.addColumn(ColumnType.STRING, "name");
            if (!transaction.hasTable("class_Center")) {
                CenterRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "centers", transaction.getTable("class_Center"));
            table.setIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_Region");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_Region")) {
            Table table = transaction.getTable("class_Region");
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
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new IllegalStateException("Primary key not defined for field 'id'");
            }
            if (!table.hasIndex(table.getColumnIndex("id"))) {
                throw new IllegalStateException("Index not defined for field 'id'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new IllegalStateException("Missing column 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'name'");
            }
            if(!columnTypes.containsKey("centers")) {
                throw new IllegalStateException("Missing column 'centers'");
            }
            if(columnTypes.get("centers") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'Center' for column 'centers'");
            }
            if (!transaction.hasTable("class_Center")) {
                throw new IllegalStateException("Missing table 'class_Center' for column 'centers'");
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException("Field '" + fieldName + "' not found for type Region");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_CENTERS = table.getColumnIndex("centers");
        } else {
            throw new RealmMigrationNeededException("The Region class is missing from the schema for this Realm.");
        }
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Region createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Region obj = null;
        if (update) {
            Table table = realm.getTable(Region.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("id")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new RegionRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(Region.class);
        }
        if (!json.isNull("id")) {
            obj.setId((String) json.getString("id"));
        }
        if (!json.isNull("name")) {
            obj.setName((String) json.getString("name"));
        }
        if (!json.isNull("centers")) {
            obj.getCenters().clear();
            JSONArray array = json.getJSONArray("centers");
            for (int i = 0; i < array.length(); i++) {
                se.greatbrain.sats.data.model.Center item = CenterRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                obj.getCenters().add(item);
            }
        }
        return obj;
    }

    public static Region createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Region obj = realm.createObject(Region.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((String) reader.nextString());
            } else if (name.equals("name")  && reader.peek() != JsonToken.NULL) {
                obj.setName((String) reader.nextString());
            } else if (name.equals("centers")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    se.greatbrain.sats.data.model.Center item = CenterRealmProxy.createUsingJsonStream(realm, reader);
                    obj.getCenters().add(item);
                }
                reader.endArray();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Region copyOrUpdate(Realm realm, Region object, boolean update, Map<RealmObject,RealmObject> cache) {
        if (object.realm != null && object.realm.getId() == realm.getId()) {
            return object;
        }
        Region realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(Region.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstString(pkColumnIndex, object.getId());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new RegionRealmProxy();
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

    public static Region copy(Realm realm, Region newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        Region realmObject = realm.createObject(Region.class, newObject.getId());
        cache.put(newObject, realmObject);
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");

        RealmList<Center> centersList = newObject.getCenters();
        if (centersList != null) {
            RealmList<Center> centersRealmList = realmObject.getCenters();
            for (int i = 0; i < centersList.size(); i++) {
                Center centersItem = centersList.get(i);
                Center cachecenters = (Center) cache.get(centersItem);
                if (cachecenters != null) {
                    centersRealmList.add(cachecenters);
                } else {
                    centersRealmList.add(CenterRealmProxy.copyOrUpdate(realm, centersList.get(i), update, cache));
                }
            }
        }

        return realmObject;
    }

    static Region update(Realm realm, Region realmObject, Region newObject, Map<RealmObject, RealmObject> cache) {
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        RealmList<Center> centersList = newObject.getCenters();
        RealmList<Center> centersRealmList = realmObject.getCenters();
        centersRealmList.clear();
        if (centersList != null) {
            for (int i = 0; i < centersList.size(); i++) {
                Center centersItem = centersList.get(i);
                Center cachecenters = (Center) cache.get(centersItem);
                if (cachecenters != null) {
                    centersRealmList.add(cachecenters);
                } else {
                    centersRealmList.add(CenterRealmProxy.copyOrUpdate(realm, centersList.get(i), true, cache));
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
        StringBuilder stringBuilder = new StringBuilder("Region = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{centers:");
        stringBuilder.append("RealmList<Center>[").append(getCenters().size()).append("]");
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
        RegionRealmProxy aRegion = (RegionRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aRegion.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aRegion.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aRegion.row.getIndex()) return false;

        return true;
    }

}
