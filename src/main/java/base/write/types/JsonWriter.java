package base.write.types;

import base.config.Configurations;
import base.write.Writer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openjdk.jol.info.GraphLayout;


/**
 * The JsonWriter writes to json files
 * @param <T> - The type of data to be written
 */
public class JsonWriter<T> implements Writer<T> {
    /* Configurations */
    private Configurations configurations;

    /* Files writing */
    private File file;
    private FileWriter writer;
    private ObjectMapper mapper;
    private List<T> batch;

    /* Files metadata */
    private String dirPath;
    private String fileName;
    private final String type = "json";

    /* Counters */
    private int currentFileNumber;
    private int currentRecordsAmount;

    /* Upper bound on batch size */
    private int maxRecordsPerBatch;
    private double maxMbPerBatch;

    /* Writing type */
    private WriteType writeType;


    /**
     * Initialize all writing relevant data
     * @param dirPathKey - Path to the directory in which the files will be written
     * @param writeType - The type of batch size checking
     * @throws IOException - If configurations loading failed
     */
    public JsonWriter(String dirPathKey, WriteType writeType) throws IOException {
        this.configurations = new Configurations();
        this.dirPath = configurations.get(dirPathKey);
        this.fileName = configurations.get("jsonFileName");

        this.writeType = writeType;
        this.maxMbPerBatch = Double.parseDouble(configurations.get("jsonWriterMaxMbPerBatch"));
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

        if (this.writeType == WriteType.RECORDS_AMOUNT) {
            if (this.currentRecordsAmount >= this.maxRecordsPerBatch) {
                batchClean();
            }
        }
        else {
            long batchByteSize = GraphLayout.parseInstance(this.batch).totalSize();
            double batchMbSize = batchByteSize / 1000000.0;

            if (batchMbSize >= this.maxMbPerBatch) {
                batchClean();
            }
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