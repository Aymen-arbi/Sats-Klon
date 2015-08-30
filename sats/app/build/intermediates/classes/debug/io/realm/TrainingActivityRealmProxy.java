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
import se.greatbrain.sats.data.model.TrainingActivity;

public class TrainingActivityRealmProxy extends TrainingActivity {

    private static long INDEX_ID;
    private static long INDEX_BOOKING;
    private static long INDEX_COMMENT;
    private static long INDEX_DATE;
    private static long INDEX_DISTANCEINKM;
    private static long INDEX_DURATIONINMINUTES;
    private static long INDEX_SOURCE;
    private static long INDEX_STATUS;
    private static long INDEX_SUBTYPE;
    private static long INDEX_TYPE;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("booking");
        fieldNames.add("comment");
        fieldNames.add("date");
        fieldNames.add("distanceInKm");
        fieldNames.add("durationInMinutes");
        fieldNames.add("source");
        fieldNames.add("status");
        fieldNames.add("subType");
        fieldNames.add("type");
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
    public Booking getBooking() {
        if (row.isNullLink(INDEX_BOOKING)) {
            return null;
        }
        return realm.get(se.greatbrain.sats.data.model.Booking.class, row.getLink(INDEX_BOOKING));
    }

    @Override
    public void setBooking(Booking value) {
        if (value == null) {
            row.nullifyLink(INDEX_BOOKING);
            return;
        }
        row.setLink(INDEX_BOOKING, value.row.getIndex());
    }

    @Override
    public String getComment() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_COMMENT);
    }

    @Override
    public void setComment(String value) {
        realm.checkIfValid();
        row.setString(INDEX_COMMENT, (String) value);
    }

    @Override
    public String getDate() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_DATE);
    }

    @Override
    public void setDate(String value) {
        realm.checkIfValid();
        row.setString(INDEX_DATE, (String) value);
    }

    @Override
    public int getDistanceInKm() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_DISTANCEINKM);
    }

    @Override
    public void setDistanceInKm(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_DISTANCEINKM, (long) value);
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
    public String getSource() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_SOURCE);
    }

    @Override
    public void setSource(String value) {
        realm.checkIfValid();
        row.setString(INDEX_SOURCE, (String) value);
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
        if(!transaction.hasTable("class_TrainingActivity")) {
            Table table = transaction.getTable("class_TrainingActivity");
            table.addColumn(ColumnType.STRING, "id");
            if (!transaction.hasTable("class_Booking")) {
                BookingRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "booking", transaction.getTable("class_Booking"));
            table.addColumn(ColumnType.STRING, "comment");
            table.addColumn(ColumnType.STRING, "date");
            table.addColumn(ColumnType.INTEGER, "distanceInKm");
            table.addColumn(ColumnType.INTEGER, "durationInMinutes");
            table.addColumn(ColumnType.STRING, "source");
            table.addColumn(ColumnType.STRING, "status");
            table.addColumn(ColumnType.STRING, "subType");
            table.addColumn(ColumnType.STRING, "type");
            table.setIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_TrainingActivity");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_TrainingActivity")) {
            Table table = transaction.getTable("class_TrainingActivity");
            if(table.getColumnCount() != 10) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 10; i++) {
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
            if (!columnTypes.containsKey("booking")) {
                throw new IllegalStateException("Missing column 'booking'");
            }
            if (columnTypes.get("booking") != ColumnType.LINK) {
                throw new IllegalStateException("Invalid type 'Booking' for column 'booking'");
            }
            if (!transaction.hasTable("class_Booking")) {
                throw new IllegalStateException("Missing table 'class_Booking' for column 'booking'");
            }
            if (!columnTypes.containsKey("comment")) {
                throw new IllegalStateException("Missing column 'comment'");
            }
            if (columnTypes.get("comment") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'comment'");
            }
            if (!columnTypes.containsKey("date")) {
                throw new IllegalStateException("Missing column 'date'");
            }
            if (columnTypes.get("date") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'date'");
            }
            if (!columnTypes.containsKey("distanceInKm")) {
                throw new IllegalStateException("Missing column 'distanceInKm'");
            }
            if (columnTypes.get("distanceInKm") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'distanceInKm'");
            }
            if (!columnTypes.containsKey("durationInMinutes")) {
                throw new IllegalStateException("Missing column 'durationInMinutes'");
            }
            if (columnTypes.get("durationInMinutes") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'durationInMinutes'");
            }
            if (!columnTypes.containsKey("source")) {
                throw new IllegalStateException("Missing column 'source'");
            }
            if (columnTypes.get("source") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'source'");
            }
            if (!columnTypes.containsKey("status")) {
                throw new IllegalStateException("Missing column 'status'");
            }
            if (columnTypes.get("status") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'status'");
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
                    throw new RealmMigrationNeededException("Field '" + fieldName + "' not found for type TrainingActivity");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_BOOKING = table.getColumnIndex("booking");
            INDEX_COMMENT = table.getColumnIndex("comment");
            INDEX_DATE = table.getColumnIndex("date");
            INDEX_DISTANCEINKM = table.getColumnIndex("distanceInKm");
            INDEX_DURATIONINMINUTES = table.getColumnIndex("durationInMinutes");
            INDEX_SOURCE = table.getColumnIndex("source");
            INDEX_STATUS = table.getColumnIndex("status");
            INDEX_SUBTYPE = table.getColumnIndex("subType");
            INDEX_TYPE = table.getColumnIndex("type");
        } else {
            throw new RealmMigrationNeededException("The TrainingActivity class is missing from the schema for this Realm.");
        }
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static TrainingActivity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        TrainingActivity obj = null;
        if (update) {
            Table table = realm.getTable(TrainingActivity.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("id")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new TrainingActivityRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(TrainingActivity.class);
        }
        if (!json.isNull("id")) {
            obj.setId((String) json.getString("id"));
        }
        if (!json.isNull("booking")) {
            se.greatbrain.sats.data.model.Booking bookingObj = BookingRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("booking"), update);
            obj.setBooking(bookingObj);
        }
        if (!json.isNull("comment")) {
            obj.setComment((String) json.getString("comment"));
        }
        if (!json.isNull("date")) {
            obj.setDate((String) json.getString("date"));
        }
        if (!json.isNull("distanceInKm")) {
            obj.setDistanceInKm((int) json.getInt("distanceInKm"));
        }
        if (!json.isNull("durationInMinutes")) {
            obj.setDurationInMinutes((int) json.getInt("durationInMinutes"));
        }
        if (!json.isNull("source")) {
            obj.setSource((String) json.getString("source"));
        }
        if (!json.isNull("status")) {
            obj.setStatus((String) json.getString("status"));
        }
        if (!json.isNull("subType")) {
            obj.setSubType((String) json.getString("subType"));
        }
        if (!json.isNull("type")) {
            obj.setType((String) json.getString("type"));
        }
        return obj;
    }

    public static TrainingActivity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        TrainingActivity obj = realm.createObject(TrainingActivity.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((String) reader.nextString());
            } else if (name.equals("booking")  && reader.peek() != JsonToken.NULL) {
                se.greatbrain.sats.data.model.Booking bookingObj = BookingRealmProxy.createUsingJsonStream(realm, reader);
                obj.setBooking(bookingObj);
            } else if (name.equals("comment")  && reader.peek() != JsonToken.NULL) {
                obj.setComment((String) reader.nextString());
            } else if (name.equals("date")  && reader.peek() != JsonToken.NULL) {
                obj.setDate((String) reader.nextString());
            } else if (name.equals("distanceInKm")  && reader.peek() != JsonToken.NULL) {
                obj.setDistanceInKm((int) reader.nextInt());
            } else if (name.equals("durationInMinutes")  && reader.peek() != JsonToken.NULL) {
                obj.setDurationInMinutes((int) reader.nextInt());
            } else if (name.equals("source")  && reader.peek() != JsonToken.NULL) {
                obj.setSource((String) reader.nextString());
            } else if (name.equals("status")  && reader.peek() != JsonToken.NULL) {
                obj.setStatus((String) reader.nextString());
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

    public static TrainingActivity copyOrUpdate(Realm realm, TrainingActivity object, boolean update, Map<RealmObject,RealmObject> cache) {
        if (object.realm != null && object.realm.getId() == realm.getId()) {
            return object;
        }
        TrainingActivity realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(TrainingActivity.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstString(pkColumnIndex, object.getId());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new TrainingActivityRealmProxy();
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

    public static TrainingActivity copy(Realm realm, TrainingActivity newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        TrainingActivity realmObject = realm.createObject(TrainingActivity.class, newObject.getId());
        cache.put(newObject, realmObject);
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");

        se.greatbrain.sats.data.model.Booking bookingObj = newObject.getBooking();
        if (bookingObj != null) {
            se.greatbrain.sats.data.model.Booking cachebooking = (se.greatbrain.sats.data.model.Booking) cache.get(bookingObj);
            if (cachebooking != null) {
                realmObject.setBooking(cachebooking);
            } else {
                realmObject.setBooking(BookingRealmProxy.copyOrUpdate(realm, bookingObj, update, cache));
            }
        }
        realmObject.setComment(newObject.getComment() != null ? newObject.getComment() : "");
        realmObject.setDate(newObject.getDate() != null ? newObject.getDate() : "");
        realmObject.setDistanceInKm(newObject.getDistanceInKm());
        realmObject.setDurationInMinutes(newObject.getDurationInMinutes());
        realmObject.setSource(newObject.getSource() != null ? newObject.getSource() : "");
        realmObject.setStatus(newObject.getStatus() != null ? newObject.getStatus() : "");
        realmObject.setSubType(newObject.getSubType() != null ? newObject.getSubType() : "");
        realmObject.setType(newObject.getType() != null ? newObject.getType() : "");
        return realmObject;
    }

    static TrainingActivity update(Realm realm, TrainingActivity realmObject, TrainingActivity newObject, Map<RealmObject, RealmObject> cache) {
        Booking bookingObj = newObject.getBooking();
        if (bookingObj != null) {
            Booking cachebooking = (Booking) cache.get(bookingObj);
            if (cachebooking != null) {
                realmObject.setBooking(cachebooking);
            } else {
                realmObject.setBooking(BookingRealmProxy.copyOrUpdate(realm, bookingObj, true, cache));
            }
        } else {
            realmObject.setBooking(null);
        }
        realmObject.setComment(newObject.getComment() != null ? newObject.getComment() : "");
        realmObject.setDate(newObject.getDate() != null ? newObject.getDate() : "");
        realmObject.setDistanceInKm(newObject.getDistanceInKm());
        realmObject.setDurationInMinutes(newObject.getDurationInMinutes());
        realmObject.setSource(newObject.getSource() != null ? newObject.getSource() : "");
        realmObject.setStatus(newObject.getStatus() != null ? newObject.getStatus() : "");
        realmObject.setSubType(newObject.getSubType() != null ? newObject.getSubType() : "");
        realmObject.setType(newObject.getType() != null ? newObject.getType() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TrainingActivity = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{booking:");
        stringBuilder.append(getBooking() != null ? "Booking" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{comment:");
        stringBuilder.append(getComment());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(getDate());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{distanceInKm:");
        stringBuilder.append(getDistanceInKm());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{durationInMinutes:");
        stringBuilder.append(getDurationInMinutes());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{source:");
        stringBuilder.append(getSource());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(getStatus());
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
        TrainingActivityRealmProxy aTrainingActivity = (TrainingActivityRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aTrainingActivity.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aTrainingActivity.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aTrainingActivity.row.getIndex()) return false;

        return true;
    }

}
