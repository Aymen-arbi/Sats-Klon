package io.realm;


import android.util.JsonReader;
import io.realm.exceptions.RealmException;
import io.realm.internal.RealmJson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import se.greatbrain.sats.data.model.Booking;
import se.greatbrain.sats.data.model.Center;
import se.greatbrain.sats.data.model.ClassCategory;
import se.greatbrain.sats.data.model.ClassCategoryIds;
import se.greatbrain.sats.data.model.ClassType;
import se.greatbrain.sats.data.model.Instructor;
import se.greatbrain.sats.data.model.Profile;
import se.greatbrain.sats.data.model.Region;
import se.greatbrain.sats.data.model.SatsClass;
import se.greatbrain.sats.data.model.TrainingActivity;
import se.greatbrain.sats.data.model.Type;

class RealmJsonImpl
    implements RealmJson {

    @Override
    public <E extends RealmObject> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        if (clazz.equals(ClassCategory.class)) {
            return (E) ClassCategoryRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else if (clazz.equals(Type.class)) {
            return (E) TypeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else if (clazz.equals(ClassCategoryIds.class)) {
            return (E) ClassCategoryIdsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else if (clazz.equals(Region.class)) {
            return (E) RegionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else if (clazz.equals(SatsClass.class)) {
            return (E) SatsClassRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else if (clazz.equals(Profile.class)) {
            return (E) ProfileRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else if (clazz.equals(TrainingActivity.class)) {
            return (E) TrainingActivityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else if (clazz.equals(Instructor.class)) {
            return (E) InstructorRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else if (clazz.equals(Center.class)) {
            return (E) CenterRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else if (clazz.equals(Booking.class)) {
            return (E) BookingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else if (clazz.equals(ClassType.class)) {
            return (E) ClassTypeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update);
        } else {
            throw new RealmException("Could not find the generated proxy class for " + clazz);
        }
    }

    @Override
    public <E extends RealmObject> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        if (clazz.equals(ClassCategory.class)) {
            return (E) ClassCategoryRealmProxy.createUsingJsonStream(realm, reader);
        } else if (clazz.equals(Type.class)) {
            return (E) TypeRealmProxy.createUsingJsonStream(realm, reader);
        } else if (clazz.equals(ClassCategoryIds.class)) {
            return (E) ClassCategoryIdsRealmProxy.createUsingJsonStream(realm, reader);
        } else if (clazz.equals(Region.class)) {
            return (E) RegionRealmProxy.createUsingJsonStream(realm, reader);
        } else if (clazz.equals(SatsClass.class)) {
            return (E) SatsClassRealmProxy.createUsingJsonStream(realm, reader);
        } else if (clazz.equals(Profile.class)) {
            return (E) ProfileRealmProxy.createUsingJsonStream(realm, reader);
        } else if (clazz.equals(TrainingActivity.class)) {
            return (E) TrainingActivityRealmProxy.createUsingJsonStream(realm, reader);
        } else if (clazz.equals(Instructor.class)) {
            return (E) InstructorRealmProxy.createUsingJsonStream(realm, reader);
        } else if (clazz.equals(Center.class)) {
            return (E) CenterRealmProxy.createUsingJsonStream(realm, reader);
        } else if (clazz.equals(Booking.class)) {
            return (E) BookingRealmProxy.createUsingJsonStream(realm, reader);
        } else if (clazz.equals(ClassType.class)) {
            return (E) ClassTypeRealmProxy.createUsingJsonStream(realm, reader);
        } else {
            throw new RealmException("Could not find the generated proxy class for " + clazz);
        }
    }

}
