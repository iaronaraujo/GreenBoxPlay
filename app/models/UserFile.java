package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

/**
 * Created by Iaron-PC on 20/07/2016.
 */
public class UserFile {
    private UUID uuid;
    private File internFile;
    private String name;

    public UserFile(String name, String extension, StringBuffer content) throws Exception{
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.internFile = new File(name + extension);
        writeInFile(internFile, content);
    }

    private void writeInFile(File file, StringBuffer fileContent) throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // This throws an exception.
        writer.write(fileContent.toString());
        writer.close();
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }
    // We should check later if this get should exist
    public File getInternFile() {
        return internFile;
    }
}
