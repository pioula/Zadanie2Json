package json.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import json.JsonManager;
import json.JsonWrapper;
import program.argumenty.wyrazeniaMatematyczne.WyrazenieMatematyczne;
import program.argumenty.wyrazeniaMatematyczne.dwuargumentowe.Dzielenie;
import program.argumenty.wyrazeniaMatematyczne.dwuargumentowe.Minus;
import program.argumenty.wyrazeniaMatematyczne.dwuargumentowe.Plus;
import program.argumenty.wyrazeniaMatematyczne.dwuargumentowe.Razy;
import program.argumenty.wyrazeniaMatematyczne.jednoargumentowe.Liczba;
import program.argumenty.wyrazeniaMatematyczne.jednoargumentowe.Zmienna;

import java.lang.reflect.Type;

public class WyrazenieMatematyczneDeserializer implements JsonDeserializer<WyrazenieMatematyczne> {
    private JsonManager jsonManager;

    public WyrazenieMatematyczneDeserializer(JsonManager jsonManager) {
        this.jsonManager = jsonManager;
    }

    @Override
    public WyrazenieMatematyczne deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        switch(JsonWrapper.getString(json, "typ")) {
            case "Dzielenie" -> {
                return jsonManager.getGson().fromJson(json, Dzielenie.class);
            }
            case "Minus" -> {
                return jsonManager.getGson().fromJson(json, Minus.class);
            }
            case "Plus" -> {
                return jsonManager.getGson().fromJson(json, Plus.class);
            }
            case "Razy" -> {
                return jsonManager.getGson().fromJson(json, Razy.class);
            }
            case "Liczba" -> {
                return jsonManager.getGson().fromJson(json, Liczba.class);
            }
            case "Zmienna" -> {
                return jsonManager.getGson().fromJson(json, Zmienna.class);
            }
        }
        return null;
    }
}
