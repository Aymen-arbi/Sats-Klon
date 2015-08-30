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
import se.greatbrain.sats.data.model.Booking;
import se.greatbrain.sats.data.model.SatsClass;

public class BookingRealmProxy extends Booking {

    private static long INDEX_ID;
    private static long INDEX_CENTERID;
    private static long INDEX_POSITIONINQUEUE;
    private static long INDEX_STATUS;
    private static long INDEX_SATSCLASS;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("centerId");
        fieldNames.add("positionInQueue");
        fieldNames.add("status");
        fieldNames.add("satsClass");
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
    public String getCenterId() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_CENTERID);
    }

    @Override
    public void setCenterId(String value) {
        realm.checkIfValid();
        row.setString(INDEX_CENTERID, (String) value);
    }

    @Override
    public int getPositionInQueue() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_POSITIONINQUEUE);
    }

    @Override
    public void setPositionInQueue(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_POSITIONINQUEUE, (long) value);
    }

    @Override
    public String getStatus() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_STATUS);
    }

    @Override
    public void setStatus(String value) {
        realm.checkIfValid();
        row.setString(INDEX_STATUS, (String) value);
    }

    @Override
    public SatsClass getSatsClass() {
        if (row.isNullLink(INDEX_SATSCLASS)) {
            return null;
        }
        return realm.get(se.greatbrain.sats.data.model.SatsClass.class, row.getLink(INDEX_SATSCLASS));
    }

    @Override
    public void setSatsClass(SatsClass value) {
        if (value == null) {
            row.nullifyLink(INDEX_SATSCLASS);
            return;
        }
        row.setLink(INDEX_SATSCLASS, value.row.getIndex());
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_Booking")) {
            Table table = transaction.getTable("class_Booking");
            table.addColumn(ColumnType.STRING, "id");
            table.addColumn(ColumnType.STRING, "centerId");
            table.addColumn(ColumnType.INTEGER, "positionInQueue");
            table.addColumn(ColumnType.STRING, "status");
            if (!transaction.hasTable("class_SatsClass")) {
                SatsClassRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "satsClass", transaction.getTable("class_SatsClass"));
            table.setIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_Booking");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_Booking")) {
            Table table = transaction.getTable("class_Booking");
            if(table.getColumnCount() != 5) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 5; i++) {
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
            if (!columnTypes.containsKey("centerId")) {
                throw new IllegalStateException("Missing column 'centerId'");
            }
            if (columnTypes.get("centerId") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'centerId'");
            }
            if (!columnTypes.containsKey("positionInQueue")) {
                throw new IllegalStateException("Missing column 'positionInQueue'");
            }
            if (columnTypes.get("positionInQueue") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'positionInQueue'");
            }
            if (!columnTypes.containsKey("status")) {
                throw new IllegalStateException("Missing column 'status'");
            }
            if (columnTypes.get("status") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'status'");
            }
            if (!columnTypes.containsKey("satsClass")) {
                throw new IllegalStateException("Missing column 'satsClass'");
            }
            if (columnTypes.get("satsClass") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'SatsClass' for column 'satsClass'");
            }
            if (!transaction.hasTable("class_SatsClass")) {
                throw new IllegalStateException("Missing table 'class_SatsClass' for column 'satsClass'");
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException("Field '" + fieldName + "' not found for type Booking");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_CENTERID = table.getColumnIndex("centerId");
            INDEX_POSITIONINQUEUE = table.getColumnIndex("positionInQueue");
            INDEX_STATUS = table.getColumnIndex("status");
            INDEX_SATSCLASS = table.getColumnIndex("satsClass");
        } else {
            throw new RealmMigrationNeededException("The Booking class is missing from the schema for this Realm.");
        }
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Booking createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Booking obj = null;
        if (update) {
            Table table = realm.getTable(Booking.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("id")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new BookingRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(Booking.class);
        }
        if (!json.isNull("id")) {
            obj.setId((String) json.getString("id"));
        }
        if (!json.isNull("centerId")) {
            obj.setCenterId((String) json.getString("centerId"));
        }
        if (!json.isNull("positionInQueue")) {
            obj.setPositionInQueue((int) json.getInt("positionInQueue"));
        }
        if (!json.isNull("status")) {
            obj.setStatus((String) json.getString("status"));
        }
        if (!json.isNull("satsClass")) {
            se.greatbrain.sats.data.model.SatsClass satsClassObj = SatsClassRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("satsClass"), update);
            obj.setSatsClass(satsClassObj);
        }
        return obj;
    }

    public static Booking createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Booking obj = realm.createObject(Booking.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((String) reader.nextString());
            } else if (name.equals("centerId")  && reader.peek() != JsonToken.NULL) {
                obj.setCenterId((String) reader.nextString());
            } else if (name.equals("positionInQueue")  && reader.peek() != JsonToken.NULL) {
                obj.setPositionInQueue((int) reader.nextInt());
            } else if (name.equals("status")  && reader.peek() != JsonToken.NULL) {
                obj.setStatus((String) reader.nextString());
            } else if (name.equals("satsClass")  && reader.peek() != JsonToken.NULL) {
                se.greatbrain.sats.data.model.SatsClass satsClassObj = SatsClassRealmProxy.createUsingJsonStream(realm, reader);
                obj.setSatsClass(satsClassObj);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Booking copyOrUpdate(Realm realm, Booking object, boolean update, Map<RealmObject,RealmObject> cache) {
        if (object.realm != null && object.realm.getId() == realm.getId()) {
            return object;
        }
        Booking realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(Booking.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstString(pkColumnIndex, object.getId());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new BookingRealmProxy();
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

    public static Booking copy(Realm realm, Booking newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        Booking realmObject = realm.createObject(Booking.class, newObject.getId());
        cache.put(newObject, realmObject);
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        realmObject.setCenterId(newObject.getCenterId() != null ? newObject.getCenterId() : "");
        realmObject.setPositionInQueue(newObject.getPositionInQueue());
        realmObject.setStatus(newObject.getStatus() != null ? newObject.getStatus() : "");

        se.greatbrain.sats.data.model.SatsClass satsClassObj = newObject.getSatsClass();
        if (satsClassObj != null) {
            se.greatbrain.sats.data.model.SatsClass cachesatsClass = (se.greatbrain.sats.data.model.SatsClass) cache.get(satsClassObj);
            if (cachesatsClass != null) {
                realmObject.setSatsClass(cachesatsClass);
            } else {
                realmObject.setSatsClass(SatsClassRealmProxy.copyOrUpdate(realm, satsClassObj, update, cache));
            }
        }
        return realmObject;
    }

    static Booking update(Realm realm, Booking realmObject, Booking newObject, Map<RealmObject, RealmObject> cache) {
        realmObject.setCenterId(newObject.getCenterId() != null ? newObject.getCenterId() : "");
        realmObject.setPositionInQueue(newObject.getPositionInQueue());
        realmObject.setStatus(newObject.getStatus() != null ? newObject.getStatus() : "");
        SatsClass satsClassObj = newObject.getSatsClass();
        if (satsClassObj != null) {
            SatsClass cachesatsClass = (SatsClass) cache.get(satsClassObj);
            if (cachesatsClass != null) {
                realmObject.setSatsClass(cachesatsClass);
            } else {
                realmObject.setSatsClass(SatsClassRealmProxy.copyOrUpdate(realm, satsClassObj, true, cache));
            }
        } else {
            realmObject.setSatsClass(null);
        }
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Booking = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{centerId:");
        stringBuilder.append(getCenterId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{positionInQueue:");
        stringBuilder.append(getPositionInQueue());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(getStatus());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{satsClass:");
        stringBuilder.append(getSatsClass() != null ? "SatsClass" : "null");
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
        BookingRealmProxy aBooking = (BookingRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aBooking.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aBooking.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aBooking.row.getIndex()) return false;

        return true;
    }

}
