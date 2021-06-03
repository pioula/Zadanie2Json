package json.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import json.JsonManager;
import json.JsonWrapper;
import program.instrukcje.*;

import java.lang.reflect.Type;

public class InstrukcjaDeserializer implements JsonDeserializer<Instrukcja> {
    private JsonManager jsonManager;

    public InstrukcjaDeserializer(JsonManager jsonManager) {
        this.jsonManager = jsonManager;
    }

    @Override
    public Instrukcja deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        switch (JsonWrapper.getString(json, "typ")) {
            case "If" -> {
                return jsonManager.getGson().fromJson(json, If.class);
            }
            case "Blok" -> {
                return jsonManager.getGson().fromJson(json, Blok.class);
            }
            case "While" -> {
                return jsonManager.getGson().fromJson(json, While.class);
            }
            case "Przypisanie" -> {
                return jsonManager.getGson().fromJson(json, Przypisanie.class);
            }
        }
        return null;
    }
}
