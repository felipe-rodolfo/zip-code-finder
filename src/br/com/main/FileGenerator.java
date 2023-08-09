package br.com.main;

import br.com.main.models.ZipCode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public void generatesJson(ZipCode address) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writeAddress = new FileWriter(address.cep() + ".json");
        writeAddress.write(gson.toJson(address));
        writeAddress.close();
    }

}
