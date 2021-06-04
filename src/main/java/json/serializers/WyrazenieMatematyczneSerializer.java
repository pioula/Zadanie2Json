package json.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import json.JsonManager;
import program.argumenty.wyrazeniaMatematyczne.WyrazenieMatematyczne;
import program.argumenty.wyrazeniaMatematyczne.dwuargumentowe.Dzielenie;
import program.argumenty.wyrazeniaMatematyczne.dwuargumentowe.Minus;
import program.argumenty.wyrazeniaMatematyczne.dwuargumentowe.Plus;
import program.argumenty.wyrazeniaMatematyczne.dwuargumentowe.Razy;
import program.argumenty.wyrazeniaMatematyczne.jednoargumentowe.Liczba;
import program.argumenty.wyrazeniaMatematyczne.jednoargumentowe.Zmienna;

import java.lang.reflect.Type;

public class WyrazenieMatematyczneSerializer implements JsonSerializer<WyrazenieMatematyczne> {
    private JsonManager jsonManager;

    public WyrazenieMatematyczneSerializer(JsonManager jsonManager) {
        this.jsonManager = jsonManager;
    }

    @Override
    public JsonElement serialize(WyrazenieMatematyczne src, Type typeOfSrc, JsonSerializationContext context) {
        switch(src.getTyp()) {
            case "Dzielenie" -> {
                return jsonManager.getGson().toJsonTree(src, Dzielenie.class);
            }
            case "Minus" -> {
                return jsonManager.getGson().toJsonTree(src, Minus.class);
            }
            case "Plus" -> {
                return jsonManager.getGson().toJsonTree(src, Plus.class);
            }
            case "Razy" -> {
                return jsonManager.getGson().toJsonTree(src, Razy.class);
            }
            case "Liczba" -> {
                return jsonManager.getGson().toJsonTree(src, Liczba.class);
            }
            case "Zmienna" -> {
                return jsonManager.getGson().toJsonTree(src, Zmienna.class);
            }
        }
        return null;
    }
}
