package json;

import com.google.gson.JsonElement;

public abstract class JsonWrapper {
    public static String getString(JsonElement jsonElement, String field) {
        return jsonElement.getAsJsonObject().get(field).getAsString();
    }
}
