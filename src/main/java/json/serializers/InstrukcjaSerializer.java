package json.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import json.JsonManager;
import program.instrukcje.*;

import java.lang.reflect.Type;

public class InstrukcjaSerializer implements JsonSerializer<Instrukcja> {
    private JsonManager jsonManager;

    public InstrukcjaSerializer(JsonManager jsonManager) {
        this.jsonManager = jsonManager;
    }

    @Override
    public JsonElement serialize(Instrukcja src, Type typeOfSrc, JsonSerializationContext context) {
        switch (src.getTyp()) {
            case "If" -> {
                return jsonManager.getGson().toJsonTree(src, If.class);
            }
            case "Blok" -> {
                return jsonManager.getGson().toJsonTree(src, Blok.class);
            }
            case "While" -> {
                return jsonManager.getGson().toJsonTree(src, While.class);
            }
            case "Przypisanie" -> {
                return jsonManager.getGson().toJsonTree(src, Przypisanie.class);
            }
        }
        return null;
    }
}
