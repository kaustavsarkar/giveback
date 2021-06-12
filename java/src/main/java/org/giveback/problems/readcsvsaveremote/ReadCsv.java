package org.giveback.problems.readcsvsaveremote;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public final class ReadCsv implements Runnable {

    private final LinkedBlockingQueue<String> csvPathQ;
    private final LinkedBlockingQueue<CsvContent> csvContentQ;

    public ReadCsv(LinkedBlockingQueue<String> inputQ,
                   LinkedBlockingQueue<CsvContent> outputQ) {
        this.csvPathQ = inputQ;
        this.csvContentQ = outputQ;
    }

    @Override
    public void run() {
        try {
            while (true) {
                var path = csvPathQ.take();
                var csv = FileFactory.getFile("linux", path);
                var reader = csv.readFile();
                var stringBuilder = new StringBuilder();
                int character = 0;
                while ((character = reader.read()) != 0) {
                    stringBuilder.append((char) character);
                }
                csvContentQ.offer(new CsvContent(stringBuilder.toString(),
                        path));
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
