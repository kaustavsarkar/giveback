package org.giveback.problems.readcsvsaveremote;

public final class HttpRpcClient implements HttpClient{
    private final String host;
    private final String path;

    HttpRpcClient(String host, String path) {
        this.host = host;
        this.path = path;
    }
    @Override
    public void post(String content) {
    }
}
