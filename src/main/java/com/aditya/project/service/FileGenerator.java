package com.aditya.project.service;

import com.aditya.project.model.Name;
import com.x5.template.Chunk;
import com.x5.template.Theme;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@Service
public class FileGenerator {

    private static final String FILE_NAME = "test";

    private static final String TEMPLATE_NAME = "test.template";

    public void generateFileUsingTemplate() throws IOException {
        Theme theme = new Theme();
        Chunk chunk = theme.makeChunk(TEMPLATE_NAME);
        Name name = givenName();
        chunk.set("name", name);
        File file = new File(FILE_NAME);
        Writer writer = new FileWriter(file);
        chunk.render(writer);
        writer.flush();
        writer.close();
    }

    private Name givenName() {
        Name name = new Name();
        name.setFirst("Aditya");
        name.setLast("Kshettri");
        return name;
    }
}
