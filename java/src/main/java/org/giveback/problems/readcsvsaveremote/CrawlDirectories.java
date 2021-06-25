package org.giveback.problems.readcsvsaveremote;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public final class CrawlDirectories implements Runnable {

    private final LinkedBlockingQueue<File> directoryQ;
    private final LinkedBlockingQueue<String> csvPath;

    public CrawlDirectories(LinkedBlockingQueue<File> inputQueue,
                            LinkedBlockingQueue<String> outputQueue) {
        this.directoryQ = inputQueue;
        this.csvPath = outputQueue;
    }


    @Override
    public void run() {
        try {
            while (true) {
                var directory = directoryQ.take();
                var files = directory.listFiles();
                // if it is a directory it gets added to the queue.
                for (var file : files) {
                    if (file.isDirectory()) {
                        directoryQ.offer(file);
                    } else if (file.isDocument() &&
                            !file.getExtension().isBlank() &&
                            file.getExtension().equals("csv")) {
                        csvPath.offer(file.getPath());
                    }
                }
            }
        } catch (InterruptedException e) {
            // Log error here.
            Thread.currentThread().interrupt();
        }
    }
}
