package com.adapter;

import java.io.IOException;

import org.hibernate.proxy.HibernateProxy;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * This TypeAdapter unproxies Hibernate proxied objects, and serializes them
 * through the registered (or default) TypeAdapter of the base class.
 */
public class HibernateProxyTypeAdapter extends TypeAdapter<HibernateProxy> {

	public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
	    @Override
	    @SuppressWarnings("unchecked")
	    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
	        return (HibernateProxy.class.isAssignableFrom(type.getRawType())
	                ? (TypeAdapter<T>) new HibernateProxyTypeAdapter((TypeAdapter)gson.getAdapter(TypeToken.get(type.getRawType().getSuperclass()))) 
	     : null);
	    }
	};
	private final TypeAdapter<Object> delegate;

	private HibernateProxyTypeAdapter(TypeAdapter<Object> delegate) {
	    this.delegate = delegate;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void write(JsonWriter out, HibernateProxy value) throws IOException {
	    if (value == null) {
	        out.nullValue();
	        return;
	    }
	    delegate.write(out, ((HibernateProxy) value).getHibernateLazyInitializer()
	            .getImplementation());
	}

	@Override
	public HibernateProxy read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}


/*public class HibernateProxyTypeAdapter implements JsonSerializer<Message> {

    @Override
    public JsonElement serialize(Message message, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message_id", message.getMessageId());
        jsonObject.addProperty("message", message.getMessage());
        jsonObject.addProperty("user", message.getUsers().getUsername());
        jsonObject.addProperty("date", message.getDate().toString());
        return jsonObject;      
    }
}*/

