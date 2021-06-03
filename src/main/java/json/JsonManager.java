package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import json.deserializers.*;
import json.serializers.*;
import program.instrukcje.Blok;
import program.Wyrazenie;
import program.argumenty.wyrazeniaMatematyczne.WyrazenieMatematyczne;
import program.argumenty.wyrazenieLogiczne.WyrazenieLogiczne;
import program.instrukcje.Instrukcja;

import java.io.*;

public class JsonManager {
    private GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson;
    private File file;
    private JsonReader reader;
    private Blok program;

    public JsonManager(File file) {
        InstrukcjaDeserializer instrukcjaDeserializer = new InstrukcjaDeserializer(this);
        WyrazenieLogiczneDeserializer wyrazenieLogiczneDeserializer = new WyrazenieLogiczneDeserializer(this);
        WyrazenieMatematyczneDeserializer wyrazenieMatematyczneDeserializer = new WyrazenieMatematyczneDeserializer(this);

        gsonBuilder.setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(Wyrazenie.class, new WyrazenieDeserializer(instrukcjaDeserializer,
                wyrazenieLogiczneDeserializer,
                wyrazenieMatematyczneDeserializer));
        gsonBuilder.registerTypeAdapter(Instrukcja.class, instrukcjaDeserializer);
        gsonBuilder.registerTypeAdapter(WyrazenieMatematyczne.class, wyrazenieMatematyczneDeserializer);
        gsonBuilder.registerTypeAdapter(WyrazenieLogiczne.class, wyrazenieLogiczneDeserializer);

        gsonBuilder.registerTypeAdapter(Instrukcja.class, new InstrukcjaSerializer(this));
        gsonBuilder.registerTypeAdapter(WyrazenieLogiczne.class, new WyrazenieLogiczneSerializer(this));
        gsonBuilder.registerTypeAdapter(WyrazenieMatematyczne.class, new WyrazenieMatematyczneSerializer(this));
        gsonBuilder.registerTypeAdapter(Wyrazenie.class, new WyrazenieSerializer(this));

        //wyświetlanie <>= zamiast ich unicode
        gsonBuilder.disableHtmlEscaping();

        gson = gsonBuilder.create();
        this.file = file;
        program = new Blok();
        try {
            reader = new JsonReader(new FileReader(file.getPath()));
        }
        catch(FileNotFoundException ex) {
            System.out.println("Nieznaleziono Pliku!");
        }
        reload();
    }

    private void reload() {
        try {
            if (file.exists())
                program = gson.fromJson(reader, program.getClass());

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public Blok getProgram() {
        return this.program;
    }

    public Gson getGson() {
        return gson;
    }

    public void writeToJson(File json) {
        FileWriter writer;
        try {
            writer = new FileWriter(json);
            writer.write(gson.toJson(program));
            writer.close();
            System.out.println();
        }
        catch(Exception ex) {
            System.out.println("Blad");
        }
    }
}
