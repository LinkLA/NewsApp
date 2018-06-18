package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_news_newsapp_Data_NewRealmProxy extends com.news.newsapp.Data.New
    implements RealmObjectProxy, com_news_newsapp_Data_NewRealmProxyInterface {

    static final class NewColumnInfo extends ColumnInfo {
        long idIndex;
        long authorIndex;
        long titleIndex;
        long descriptionIndex;
        long urlIndex;
        long publishedTimeIndex;
        long urlToImageIndex;
        long sourceIndex;

        NewColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("New");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.authorIndex = addColumnDetails("author", "author", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", "description", objectSchemaInfo);
            this.urlIndex = addColumnDetails("url", "url", objectSchemaInfo);
            this.publishedTimeIndex = addColumnDetails("publishedTime", "publishedTime", objectSchemaInfo);
            this.urlToImageIndex = addColumnDetails("urlToImage", "urlToImage", objectSchemaInfo);
            this.sourceIndex = addColumnDetails("source", "source", objectSchemaInfo);
        }

        NewColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new NewColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final NewColumnInfo src = (NewColumnInfo) rawSrc;
            final NewColumnInfo dst = (NewColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.authorIndex = src.authorIndex;
            dst.titleIndex = src.titleIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.urlIndex = src.urlIndex;
            dst.publishedTimeIndex = src.publishedTimeIndex;
            dst.urlToImageIndex = src.urlToImageIndex;
            dst.sourceIndex = src.sourceIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private NewColumnInfo columnInfo;
    private ProxyState<com.news.newsapp.Data.New> proxyState;

    com_news_newsapp_Data_NewRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (NewColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.news.newsapp.Data.New>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$author() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.authorIndex);
    }

    @Override
    public void realmSet$author(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.authorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.authorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.authorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.authorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlIndex);
    }

    @Override
    public void realmSet$url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.urlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$publishedTime() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.publishedTimeIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.publishedTimeIndex);
    }

    @Override
    public void realmSet$publishedTime(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.publishedTimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.publishedTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.publishedTimeIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.publishedTimeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$urlToImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlToImageIndex);
    }

    @Override
    public void realmSet$urlToImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.urlToImageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.urlToImageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.urlToImageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.urlToImageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$source() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sourceIndex);
    }

    @Override
    public void realmSet$source(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sourceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sourceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sourceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sourceIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("New", 8, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("author", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("publishedTime", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("urlToImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("source", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static NewColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new NewColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "New";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "New";
    }

    @SuppressWarnings("cast")
    public static com.news.newsapp.Data.New createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.news.newsapp.Data.New obj = null;
        if (update) {
            Table table = realm.getTable(com.news.newsapp.Data.New.class);
            NewColumnInfo columnInfo = (NewColumnInfo) realm.getSchema().getColumnInfo(com.news.newsapp.Data.New.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.news.newsapp.Data.New.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_news_newsapp_Data_NewRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_news_newsapp_Data_NewRealmProxy) realm.createObjectInternal(com.news.newsapp.Data.New.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_news_newsapp_Data_NewRealmProxy) realm.createObjectInternal(com.news.newsapp.Data.New.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_news_newsapp_Data_NewRealmProxyInterface objProxy = (com_news_newsapp_Data_NewRealmProxyInterface) obj;
        if (json.has("author")) {
            if (json.isNull("author")) {
                objProxy.realmSet$author(null);
            } else {
                objProxy.realmSet$author((String) json.getString("author"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("url")) {
            if (json.isNull("url")) {
                objProxy.realmSet$url(null);
            } else {
                objProxy.realmSet$url((String) json.getString("url"));
            }
        }
        if (json.has("publishedTime")) {
            if (json.isNull("publishedTime")) {
                objProxy.realmSet$publishedTime(null);
            } else {
                Object timestamp = json.get("publishedTime");
                if (timestamp instanceof String) {
                    objProxy.realmSet$publishedTime(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$publishedTime(new Date(json.getLong("publishedTime")));
                }
            }
        }
        if (json.has("urlToImage")) {
            if (json.isNull("urlToImage")) {
                objProxy.realmSet$urlToImage(null);
            } else {
                objProxy.realmSet$urlToImage((String) json.getString("urlToImage"));
            }
        }
        if (json.has("source")) {
            if (json.isNull("source")) {
                objProxy.realmSet$source(null);
            } else {
                objProxy.realmSet$source((String) json.getString("source"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.news.newsapp.Data.New createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.news.newsapp.Data.New obj = new com.news.newsapp.Data.New();
        final com_news_newsapp_Data_NewRealmProxyInterface objProxy = (com_news_newsapp_Data_NewRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("author")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$author((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$author(null);
                }
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("url")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$url((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$url(null);
                }
            } else if (name.equals("publishedTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$publishedTime(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$publishedTime(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$publishedTime(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("urlToImage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$urlToImage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$urlToImage(null);
                }
            } else if (name.equals("source")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$source((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$source(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.news.newsapp.Data.New copyOrUpdate(Realm realm, com.news.newsapp.Data.New object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.news.newsapp.Data.New) cachedRealmObject;
        }

        com.news.newsapp.Data.New realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.news.newsapp.Data.New.class);
            NewColumnInfo columnInfo = (NewColumnInfo) realm.getSchema().getColumnInfo(com.news.newsapp.Data.New.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.news.newsapp.Data.New.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_news_newsapp_Data_NewRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.news.newsapp.Data.New copy(Realm realm, com.news.newsapp.Data.New newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.news.newsapp.Data.New) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.news.newsapp.Data.New realmObject = realm.createObjectInternal(com.news.newsapp.Data.New.class, ((com_news_newsapp_Data_NewRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_news_newsapp_Data_NewRealmProxyInterface realmObjectSource = (com_news_newsapp_Data_NewRealmProxyInterface) newObject;
        com_news_newsapp_Data_NewRealmProxyInterface realmObjectCopy = (com_news_newsapp_Data_NewRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$author(realmObjectSource.realmGet$author());
        realmObjectCopy.realmSet$title(realmObjectSource.realmGet$title());
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectCopy.realmSet$url(realmObjectSource.realmGet$url());
        realmObjectCopy.realmSet$publishedTime(realmObjectSource.realmGet$publishedTime());
        realmObjectCopy.realmSet$urlToImage(realmObjectSource.realmGet$urlToImage());
        realmObjectCopy.realmSet$source(realmObjectSource.realmGet$source());
        return realmObject;
    }

    public static long insert(Realm realm, com.news.newsapp.Data.New object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.news.newsapp.Data.New.class);
        long tableNativePtr = table.getNativePtr();
        NewColumnInfo columnInfo = (NewColumnInfo) realm.getSchema().getColumnInfo(com.news.newsapp.Data.New.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$author = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        }
        String realmGet$title = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$description = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$url = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        }
        java.util.Date realmGet$publishedTime = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$publishedTime();
        if (realmGet$publishedTime != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.publishedTimeIndex, rowIndex, realmGet$publishedTime.getTime(), false);
        }
        String realmGet$urlToImage = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$urlToImage();
        if (realmGet$urlToImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlToImageIndex, rowIndex, realmGet$urlToImage, false);
        }
        String realmGet$source = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$source();
        if (realmGet$source != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sourceIndex, rowIndex, realmGet$source, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.news.newsapp.Data.New.class);
        long tableNativePtr = table.getNativePtr();
        NewColumnInfo columnInfo = (NewColumnInfo) realm.getSchema().getColumnInfo(com.news.newsapp.Data.New.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.news.newsapp.Data.New object = null;
        while (objects.hasNext()) {
            object = (com.news.newsapp.Data.New) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$author = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$author();
            if (realmGet$author != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
            }
            String realmGet$title = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
            String realmGet$description = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            String realmGet$url = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$url();
            if (realmGet$url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
            }
            java.util.Date realmGet$publishedTime = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$publishedTime();
            if (realmGet$publishedTime != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.publishedTimeIndex, rowIndex, realmGet$publishedTime.getTime(), false);
            }
            String realmGet$urlToImage = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$urlToImage();
            if (realmGet$urlToImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlToImageIndex, rowIndex, realmGet$urlToImage, false);
            }
            String realmGet$source = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$source();
            if (realmGet$source != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sourceIndex, rowIndex, realmGet$source, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.news.newsapp.Data.New object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.news.newsapp.Data.New.class);
        long tableNativePtr = table.getNativePtr();
        NewColumnInfo columnInfo = (NewColumnInfo) realm.getSchema().getColumnInfo(com.news.newsapp.Data.New.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$author = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
        }
        String realmGet$title = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$description = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$url = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
        }
        java.util.Date realmGet$publishedTime = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$publishedTime();
        if (realmGet$publishedTime != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.publishedTimeIndex, rowIndex, realmGet$publishedTime.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.publishedTimeIndex, rowIndex, false);
        }
        String realmGet$urlToImage = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$urlToImage();
        if (realmGet$urlToImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlToImageIndex, rowIndex, realmGet$urlToImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlToImageIndex, rowIndex, false);
        }
        String realmGet$source = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$source();
        if (realmGet$source != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sourceIndex, rowIndex, realmGet$source, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sourceIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.news.newsapp.Data.New.class);
        long tableNativePtr = table.getNativePtr();
        NewColumnInfo columnInfo = (NewColumnInfo) realm.getSchema().getColumnInfo(com.news.newsapp.Data.New.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.news.newsapp.Data.New object = null;
        while (objects.hasNext()) {
            object = (com.news.newsapp.Data.New) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$author = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$author();
            if (realmGet$author != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
            }
            String realmGet$title = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
            String realmGet$description = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            String realmGet$url = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$url();
            if (realmGet$url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
            }
            java.util.Date realmGet$publishedTime = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$publishedTime();
            if (realmGet$publishedTime != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.publishedTimeIndex, rowIndex, realmGet$publishedTime.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.publishedTimeIndex, rowIndex, false);
            }
            String realmGet$urlToImage = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$urlToImage();
            if (realmGet$urlToImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlToImageIndex, rowIndex, realmGet$urlToImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.urlToImageIndex, rowIndex, false);
            }
            String realmGet$source = ((com_news_newsapp_Data_NewRealmProxyInterface) object).realmGet$source();
            if (realmGet$source != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sourceIndex, rowIndex, realmGet$source, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sourceIndex, rowIndex, false);
            }
        }
    }

    public static com.news.newsapp.Data.New createDetachedCopy(com.news.newsapp.Data.New realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.news.newsapp.Data.New unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.news.newsapp.Data.New();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.news.newsapp.Data.New) cachedObject.object;
            }
            unmanagedObject = (com.news.newsapp.Data.New) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_news_newsapp_Data_NewRealmProxyInterface unmanagedCopy = (com_news_newsapp_Data_NewRealmProxyInterface) unmanagedObject;
        com_news_newsapp_Data_NewRealmProxyInterface realmSource = (com_news_newsapp_Data_NewRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$author(realmSource.realmGet$author());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$url(realmSource.realmGet$url());
        unmanagedCopy.realmSet$publishedTime(realmSource.realmGet$publishedTime());
        unmanagedCopy.realmSet$urlToImage(realmSource.realmGet$urlToImage());
        unmanagedCopy.realmSet$source(realmSource.realmGet$source());

        return unmanagedObject;
    }

    static com.news.newsapp.Data.New update(Realm realm, com.news.newsapp.Data.New realmObject, com.news.newsapp.Data.New newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_news_newsapp_Data_NewRealmProxyInterface realmObjectTarget = (com_news_newsapp_Data_NewRealmProxyInterface) realmObject;
        com_news_newsapp_Data_NewRealmProxyInterface realmObjectSource = (com_news_newsapp_Data_NewRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$author(realmObjectSource.realmGet$author());
        realmObjectTarget.realmSet$title(realmObjectSource.realmGet$title());
        realmObjectTarget.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectTarget.realmSet$url(realmObjectSource.realmGet$url());
        realmObjectTarget.realmSet$publishedTime(realmObjectSource.realmGet$publishedTime());
        realmObjectTarget.realmSet$urlToImage(realmObjectSource.realmGet$urlToImage());
        realmObjectTarget.realmSet$source(realmObjectSource.realmGet$source());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("New = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{author:");
        stringBuilder.append(realmGet$author() != null ? realmGet$author() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{url:");
        stringBuilder.append(realmGet$url() != null ? realmGet$url() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{publishedTime:");
        stringBuilder.append(realmGet$publishedTime() != null ? realmGet$publishedTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{urlToImage:");
        stringBuilder.append(realmGet$urlToImage() != null ? realmGet$urlToImage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{source:");
        stringBuilder.append(realmGet$source() != null ? realmGet$source() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

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
        com_news_newsapp_Data_NewRealmProxy aNew = (com_news_newsapp_Data_NewRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aNew.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aNew.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aNew.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
