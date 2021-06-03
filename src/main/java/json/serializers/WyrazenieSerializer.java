package json.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import json.JsonManager;
import program.Wyrazenie;
import program.argumenty.wyrazeniaMatematyczne.WyrazenieMatematyczne;
import program.argumenty.wyrazenieLogiczne.WyrazenieLogiczne;
import program.instrukcje.Instrukcja;

import java.lang.reflect.Type;

public class WyrazenieSerializer implements JsonSerializer<Wyrazenie> {
    private JsonManager jsonManager;

    public WyrazenieSerializer(JsonManager jsonManager) {
        this.jsonManager = jsonManager;
    }

    @Override
    public JsonElement serialize(Wyrazenie src, Type typeOfSrc, JsonSerializationContext context) {
        if (src instanceof Instrukcja)
            return jsonManager.getGson().toJsonTree(src, Instrukcja.class);

        if (src instanceof WyrazenieLogiczne)
            return jsonManager.getGson().toJsonTree(src, WyrazenieLogiczne.class);

        if (src instanceof  WyrazenieMatematyczne)
            return jsonManager.getGson().toJsonTree(src, WyrazenieMatematyczne.class);

        return null;
    }
}
