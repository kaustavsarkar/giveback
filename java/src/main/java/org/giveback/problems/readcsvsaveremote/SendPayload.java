package org.giveback.problems.readcsvsaveremote;

import java.util.concurrent.LinkedBlockingQueue;

public final class SendPayload implements Runnable {
    private final LinkedBlockingQueue<CsvContent> csvContentQ;

    public SendPayload(LinkedBlockingQueue<CsvContent> inputQ) {
        this.csvContentQ = inputQ;
    }

    @Override
    public void run() {
        try {
            while (true) {
                var content = csvContentQ.take();
                var client = new HttpRpcClient("http://host/",
                        content.getPath());
                client.post(content.getContent());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
