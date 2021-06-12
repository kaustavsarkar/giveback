package org.giveback.problems.readcsvsaveremote;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class Runner {

    public void execute(String path) {
        File file = FileFactory.getFile("linux", path);
        ExecutorService executorService = Executors.newFixedThreadPool(12);

        // Adding a path to the Queue ensures the memory does not increase.
        var dirQ = new LinkedBlockingQueue<File>(100);
        dirQ.offer(file);
        var csvPathQ = new LinkedBlockingQueue<String>(100);
        executorService.execute(new CrawlDirectories(dirQ, csvPathQ));

        var csvContentQ = new LinkedBlockingQueue<CsvContent>(100);
        executorService.execute(new ReadCsv(csvPathQ, csvContentQ));
        executorService.execute(new SendPayload(csvContentQ));

        // There needs to be a condition to shut it down.
        executorService.shutdown();
    }
}
