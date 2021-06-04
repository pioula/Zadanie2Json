package json.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import json.JsonManager;
import program.argumenty.wyrazenieLogiczne.WyrazenieLogiczne;
import program.argumenty.wyrazenieLogiczne.dwuargumentowe.And;
import program.argumenty.wyrazenieLogiczne.dwuargumentowe.Or;
import program.argumenty.wyrazenieLogiczne.jednoargumentowe.Not;
import program.argumenty.wyrazenieLogiczne.porownania.*;
import program.argumenty.wyrazenieLogiczne.zeroargumentowe.False;
import program.argumenty.wyrazenieLogiczne.zeroargumentowe.True;

import java.lang.reflect.Type;

public class WyrazenieLogiczneSerializer implements JsonSerializer<WyrazenieLogiczne> {
    private JsonManager jsonManager;

    public WyrazenieLogiczneSerializer(JsonManager jsonManager) {
        this.jsonManager = jsonManager;
    }

    @Override
    public JsonElement serialize(WyrazenieLogiczne src, Type typeOfSrc, JsonSerializationContext context) {
        switch(src.getTyp()) {
            case "And" -> {
                return jsonManager.getGson().toJsonTree(src, And.class);
            }
            case "Or" -> {
                return jsonManager.getGson().toJsonTree(src, Or.class);
            }
            case "False" -> {
                return jsonManager.getGson().toJsonTree(src, False.class);
            }
            case "True" -> {
                return jsonManager.getGson().toJsonTree(src, True.class);
            }
            case "Not" -> {
                return jsonManager.getGson().toJsonTree(src, Not.class);
            }
            case "==" -> {
                return jsonManager.getGson().toJsonTree(src, Rowne.class);
            }
            case "<" -> {
                return jsonManager.getGson().toJsonTree(src, Mniejsze.class);
            }
            case ">" -> {
                return jsonManager.getGson().toJsonTree(src, Wieksze.class);
            }
            case "<=" -> {
                return jsonManager.getGson().toJsonTree(src, MniejszeRowne.class);
            }
            case ">=" -> {
                return jsonManager.getGson().toJsonTree(src, WiekszeRowne.class);
            }
        }
        return null;
    }
}
