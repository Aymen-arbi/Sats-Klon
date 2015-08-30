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
import se.greatbrain.sats.data.model.ClassType;
import se.greatbrain.sats.data.model.Profile;

public class ClassTypeRealmProxy extends ClassType {

    private static long INDEX_ID;
    private static long INDEX_NAME;
    private static long INDEX_VIDEOURL;
    private static long INDEX_DESCRIPTION;
    private static long INDEX_CLASSCATEGORIES;
    private static long INDEX_PROFILE;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("videoUrl");
        fieldNames.add("description");
        fieldNames.add("classCategories");
        fieldNames.add("profile");
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
    public String getVideoUrl() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_VIDEOURL);
    }

    @Override
    public void setVideoUrl(String value) {
        realm.checkIfValid();
        row.setString(INDEX_VIDEOURL, (String) value);
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
    public RealmList<ClassCategoryIds> getClassCategories() {
        return new RealmList<ClassCategoryIds>(ClassCategoryIds.class, row.getLinkList(INDEX_CLASSCATEGORIES), realm);
    }

    @Override
    public void setClassCategories(RealmList<ClassCategoryIds> value) {
        LinkView links = row.getLinkList(INDEX_CLASSCATEGORIES);
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    @Override
    public RealmList<Profile> getProfile() {
        return new RealmList<Profile>(Profile.class, row.getLinkList(INDEX_PROFILE), realm);
    }

    @Override
    public void setProfile(RealmList<Profile> value) {
        LinkView links = row.getLinkList(INDEX_PROFILE);
        if (value == null) {
            return;
        }
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_ClassType")) {
            Table table = transaction.getTable("class_ClassType");
            table.addColumn(ColumnType.STRING, "id");
            table.addColumn(ColumnType.STRING, "name");
            table.addColumn(ColumnType.STRING, "videoUrl");
            table.addColumn(ColumnType.STRING, "description");
            if (!transaction.hasTable("class_ClassCategoryIds")) {
                ClassCategoryIdsRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "classCategories", transaction.getTable("class_ClassCategoryIds"));
            if (!transaction.hasTable("class_Profile")) {
                ProfileRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "profile", transaction.getTable("class_Profile"));
            table.setIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_ClassType");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_ClassType")) {
            Table table = transaction.getTable("class_ClassType");
            if(table.getColumnCount() != 6) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 6; i++) {
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
            if (!columnTypes.containsKey("videoUrl")) {
                throw new IllegalStateException("Missing column 'videoUrl'");
            }
            if (columnTypes.get("videoUrl") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'videoUrl'");
            }
            if (!columnTypes.containsKey("description")) {
                throw new IllegalStateException("Missing column 'description'");
            }
            if (columnTypes.get("description") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'description'");
            }
            if(!columnTypes.containsKey("classCategories")) {
                throw new IllegalStateException("Missing column 'classCategories'");
            }
            if(columnTypes.get("classCategories") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'ClassCategoryIds' for column 'classCategories'");
            }
            if (!transaction.hasTable("class_ClassCategoryIds")) {
                throw new IllegalStateException("Missing table 'class_ClassCategoryIds' for column 'classCategories'");
            }
            if(!columnTypes.containsKey("profile")) {
                throw new IllegalStateException("Missing column 'profile'");
            }
            if(columnTypes.get("profile") != ColumnType.LINK_LIST) {
                throw new IllegalStateException("Invalid type 'Profile' for column 'profile'");
            }
            if (!transaction.hasTable("class_Profile")) {
                throw new IllegalStateException("Missing table 'class_Profile' for column 'profile'");
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException("Field '" + fieldName + "' not found for type ClassType");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_VIDEOURL = table.getColumnIndex("videoUrl");
            INDEX_DESCRIPTION = table.getColumnIndex("description");
            INDEX_CLASSCATEGORIES = table.getColumnIndex("classCategories");
            INDEX_PROFILE = table.getColumnIndex("profile");
        } else {
            throw new RealmMigrationNeededException("The ClassType class is missing from the schema for this Realm.");
        }
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static ClassType createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        ClassType obj = null;
        if (update) {
            Table table = realm.getTable(ClassType.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("id")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new ClassTypeRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(ClassType.class);
        }
        if (!json.isNull("id")) {
            obj.setId((String) json.getString("id"));
        }
        if (!json.isNull("name")) {
            obj.setName((String) json.getString("name"));
        }
        if (!json.isNull("videoUrl")) {
            obj.setVideoUrl((String) json.getString("videoUrl"));
        }
        if (!json.isNull("description")) {
            obj.setDescription((String) json.getString("description"));
        }
        if (!json.isNull("classCategories")) {
            obj.getClassCategories().clear();
            JSONArray array = json.getJSONArray("classCategories");
            for (int i = 0; i < array.length(); i++) {
                se.greatbrain.sats.data.model.ClassCategoryIds item = ClassCategoryIdsRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                obj.getClassCategories().add(item);
            }
        }
        if (!json.isNull("profile")) {
            obj.getProfile().clear();
            JSONArray array = json.getJSONArray("profile");
            for (int i = 0; i < array.length(); i++) {
                se.greatbrain.sats.data.model.Profile item = ProfileRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                obj.getProfile().add(item);
            }
        }
        return obj;
    }

    public static ClassType createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        ClassType obj = realm.createObject(ClassType.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((String) reader.nextString());
            } else if (name.equals("name")  && reader.peek() != JsonToken.NULL) {
                obj.setName((String) reader.nextString());
            } else if (name.equals("videoUrl")  && reader.peek() != JsonToken.NULL) {
                obj.setVideoUrl((String) reader.nextString());
            } else if (name.equals("description")  && reader.peek() != JsonToken.NULL) {
                obj.setDescription((String) reader.nextString());
            } else if (name.equals("classCategories")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    se.greatbrain.sats.data.model.ClassCategoryIds item = ClassCategoryIdsRealmProxy.createUsingJsonStream(realm, reader);
                    obj.getClassCategories().add(item);
                }
                reader.endArray();
            } else if (name.equals("profile")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    se.greatbrain.sats.data.model.Profile item = ProfileRealmProxy.createUsingJsonStream(realm, reader);
                    obj.getProfile().add(item);
                }
                reader.endArray();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static ClassType copyOrUpdate(Realm realm, ClassType object, boolean update, Map<RealmObject,RealmObject> cache) {
        if (object.realm != null && object.realm.getId() == realm.getId()) {
            return object;
        }
        ClassType realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(ClassType.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstString(pkColumnIndex, object.getId());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new ClassTypeRealmProxy();
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

    public static ClassType copy(Realm realm, ClassType newObject, boolean update, Map<RealmObject,RealmObject> cache) {
        ClassType realmObject = realm.createObject(ClassType.class, newObject.getId());
        cache.put(newObject, realmObject);
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setVideoUrl(newObject.getVideoUrl() != null ? newObject.getVideoUrl() : "");
        realmObject.setDescription(newObject.getDescription() != null ? newObject.getDescription() : "");

        RealmList<ClassCategoryIds> classCategoriesList = newObject.getClassCategories();
        if (classCategoriesList != null) {
            RealmList<ClassCategoryIds> classCategoriesRealmList = realmObject.getClassCategories();
            for (int i = 0; i < classCategoriesList.size(); i++) {
                ClassCategoryIds classCategoriesItem = classCategoriesList.get(i);
                ClassCategoryIds cacheclassCategories = (ClassCategoryIds) cache.get(classCategoriesItem);
                if (cacheclassCategories != null) {
                    classCategoriesRealmList.add(cacheclassCategories);
                } else {
                    classCategoriesRealmList.add(ClassCategoryIdsRealmProxy.copyOrUpdate(realm, classCategoriesList.get(i), update, cache));
                }
            }
        }


        RealmList<Profile> profileList = newObject.getProfile();
        if (profileList != null) {
            RealmList<Profile> profileRealmList = realmObject.getProfile();
            for (int i = 0; i < profileList.size(); i++) {
                Profile profileItem = profileList.get(i);
                Profile cacheprofile = (Profile) cache.get(profileItem);
                if (cacheprofile != null) {
                    profileRealmList.add(cacheprofile);
                } else {
                    profileRealmList.add(ProfileRealmProxy.copyOrUpdate(realm, profileList.get(i), update, cache));
                }
            }
        }

        return realmObject;
    }

    static ClassType update(Realm realm, ClassType realmObject, ClassType newObject, Map<RealmObject, RealmObject> cache) {
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setVideoUrl(newObject.getVideoUrl() != null ? newObject.getVideoUrl() : "");
        realmObject.setDescription(newObject.getDescription() != null ? newObject.getDescription() : "");
        RealmList<ClassCategoryIds> classCategoriesList = newObject.getClassCategories();
        RealmList<ClassCategoryIds> classCategoriesRealmList = realmObject.getClassCategories();
        classCategoriesRealmList.clear();
        if (classCategoriesList != null) {
            for (int i = 0; i < classCategoriesList.size(); i++) {
                ClassCategoryIds classCategoriesItem = classCategoriesList.get(i);
                ClassCategoryIds cacheclassCategories = (ClassCategoryIds) cache.get(classCategoriesItem);
                if (cacheclassCategories != null) {
                    classCategoriesRealmList.add(cacheclassCategories);
                } else {
                    classCategoriesRealmList.add(ClassCategoryIdsRealmProxy.copyOrUpdate(realm, classCategoriesList.get(i), true, cache));
                }
            }
        }
        RealmList<Profile> profileList = newObject.getProfile();
        RealmList<Profile> profileRealmList = realmObject.getProfile();
        profileRealmList.clear();
        if (profileList != null) {
            for (int i = 0; i < profileList.size(); i++) {
                Profile profileItem = profileList.get(i);
                Profile cacheprofile = (Profile) cache.get(profileItem);
                if (cacheprofile != null) {
                    profileRealmList.add(cacheprofile);
                } else {
                    profileRealmList.add(ProfileRealmProxy.copyOrUpdate(realm, profileList.get(i), true, cache));
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
        StringBuilder stringBuilder = new StringBuilder("ClassType = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{videoUrl:");
        stringBuilder.append(getVideoUrl());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(getDescription());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{classCategories:");
        stringBuilder.append("RealmList<ClassCategoryIds>[").append(getClassCategories().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{profile:");
        stringBuilder.append("RealmList<Profile>[").append(getProfile().size()).append("]");
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
        ClassTypeRealmProxy aClassType = (ClassTypeRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aClassType.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aClassType.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aClassType.row.getIndex()) return false;

        return true;
    }

}
