package org.giveback.problems.readcsvsaveremote;

public final class CsvContent {
    private final String content;
    private final String path;

    public CsvContent(String content, String path) {
        this.content = content;
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public String getPath() {
        return path;
    }
}
