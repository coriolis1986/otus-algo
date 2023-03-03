package ru.algo.common;

import lombok.SneakyThrows;

import java.io.FileWriter;
import java.util.Random;

public abstract class CommonExternalSort {

    protected static final int PART_SIZE = 1000;
    protected static final String INPUT_FILE_NAME = "/opt/payload.dat";
    protected static final String OUTPUT_FILE_NAME = "/opt/payload_sorted.dat";
    protected static final String PARTS_DIR = "/opt/sort";

    @SneakyThrows
    protected void generate() {
        final int n = 10000;
        final int t = 100000;

        var random = new Random(t);

        try (FileWriter writer = new FileWriter(INPUT_FILE_NAME)) {
            for (int i = 1; i <= n; i++) {
                int num = random.nextInt(t);
                writer.write(num + "\n");
            }
        }
    }
}
