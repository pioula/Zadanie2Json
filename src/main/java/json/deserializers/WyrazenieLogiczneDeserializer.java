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
import program.argumenty.wyrazenieLogiczne.WyrazenieLogiczne;
import program.argumenty.wyrazenieLogiczne.dwuargumentowe.And;
import program.argumenty.wyrazenieLogiczne.dwuargumentowe.Or;
import program.argumenty.wyrazenieLogiczne.porownania.*;
import program.argumenty.wyrazenieLogiczne.zeroargumentowe.False;
import program.argumenty.wyrazenieLogiczne.zeroargumentowe.True;

import java.lang.reflect.Type;

public class WyrazenieLogiczneDeserializer implements JsonDeserializer<WyrazenieLogiczne> {
    private JsonManager jsonManager;

    public WyrazenieLogiczneDeserializer(JsonManager jsonManager) {
        this.jsonManager = jsonManager;
    }

    @Override
    public WyrazenieLogiczne deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        switch(JsonWrapper.getString(json, "typ")) {
            case "And" -> {
                return jsonManager.getGson().fromJson(json, And.class);
            }
            case "Or" -> {
                return jsonManager.getGson().fromJson(json, Or.class);
            }
            case "False" -> {
                return jsonManager.getGson().fromJson(json, False.class);
            }
            case "True" -> {
                return jsonManager.getGson().fromJson(json, True.class);
            }
            case "==" -> {
                return jsonManager.getGson().fromJson(json, Rowne.class);
            }
            case "<" -> {
                return jsonManager.getGson().fromJson(json, Mniejsze.class);
            }
            case ">" -> {
                return jsonManager.getGson().fromJson(json, Wieksze.class);
            }
            case "<=" -> {
                return jsonManager.getGson().fromJson(json, MniejszeRowne.class);
            }
            case ">=" -> {
                return jsonManager.getGson().fromJson(json, WiekszeRowne.class);
            }
        }
        return null;
    }
}
