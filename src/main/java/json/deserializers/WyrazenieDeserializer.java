package json.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import program.Wyrazenie;

import java.lang.reflect.Type;

public class WyrazenieDeserializer implements JsonDeserializer<Wyrazenie> {
    private InstrukcjaDeserializer instrukcjaDeserializer;
    private WyrazenieLogiczneDeserializer wyrazenieLogiczneDeserializer;
    private WyrazenieMatematyczneDeserializer wyrazenieMatematyczneDeserializer;

    public WyrazenieDeserializer(
            InstrukcjaDeserializer instrukcjaDeserializer,
            WyrazenieLogiczneDeserializer wyrazenieLogiczneDeserializer,
            WyrazenieMatematyczneDeserializer wyrazenieMatematyczneDeserializer
    ) {
        this.instrukcjaDeserializer = instrukcjaDeserializer;
        this.wyrazenieLogiczneDeserializer = wyrazenieLogiczneDeserializer;
        this.wyrazenieMatematyczneDeserializer = wyrazenieMatematyczneDeserializer;
    }

    @Override
    public Wyrazenie deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Wyrazenie result = instrukcjaDeserializer.deserialize(json, typeOfT, context);
        if (result != null)
            return result;

        result = wyrazenieLogiczneDeserializer.deserialize(json, typeOfT, context);
        if (result != null)
            return result;

        result = wyrazenieMatematyczneDeserializer.deserialize(json, typeOfT, context);

        return result;
    }
}
