package base.write;

import base.config.Configurations;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The JsonWriter writes to json files
 * @param <T> - The type of data to be written
 */
public class JsonWriter<T> implements Writer<T> {
    /* configurations */
    private Configurations configurations;

    /* Files writing */
    private File file;
    private FileWriter writer;
    private ObjectMapper mapper;
    private List<T> batch;

    /* files metadata */
    private String dirPath;
    private String fileName;
    private final String type = "json";

    /* counters */
    private int currentFileNumber;
    private int currentRecordsAmount;
    private int maxRecordsPerBatch;

    public JsonWriter(String dirPathKey) throws IOException {
        this.configurations = new Configurations();
        this.dirPath = configurations.get(dirPathKey);
        this.fileName = configurations.get("jsonFileName");

        this.maxRecordsPerBatch = Integer.parseInt(configurations.get("jsonWriterMaxRecordsPerBatch"));

        this.batch = new ArrayList<>();
        this.currentRecordsAmount = 0;
        this.currentFileNumber = 1;

        this.file = new File(this.dirPath + "\\" + this.fileName + "_" +
                this.currentFileNumber + "." + this.type);
        this.writer = new FileWriter(this.file);

        this.mapper = new ObjectMapper();

    }

    /**
     * Writes current batch into current file, and re-initializes everything
     * @throws IOException - if writing failed
     */
    private void batchClean() throws IOException {
        this.writer = new FileWriter(this.file);
        this.mapper.writeValue(this.writer, this.batch);
        this.batch = new ArrayList<>();
        this.currentRecordsAmount = 0;
        this.currentFileNumber++;

        this.file = new File(this.dirPath + "\\" + this.fileName + "_" +
                this.currentFileNumber + "." + this.type);
    }

    /**
     * Add an object to current batch, and write batch if batch is of required size
     * @param object - The object to be written
     * @throws IOException - if writing failed
     */
    @Override
    public void write(T object) throws IOException {
        this.batch.add(object);
        this.currentRecordsAmount++;

        if (this.currentRecordsAmount >= this.maxRecordsPerBatch) {
            batchClean();
        }
    }

    /**
     * Flushes current batch into current file
     * @throws IOException - if writing failed
     */
    @Override
    public void flush() throws IOException {
        if (this.currentRecordsAmount > 0) {
            batchClean();
        }
    }
}
