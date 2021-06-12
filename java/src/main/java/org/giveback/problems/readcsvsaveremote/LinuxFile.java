package org.giveback.problems.readcsvsaveremote;

import java.io.StringReader;
import java.util.List;

public final class LinuxFile implements File {

    @Override
    public boolean isDocument() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public List<File> listFiles() {
        return null;
    }

    @Override
    public String getExtension() {
        return null;
    }

    @Override
    public StringReader readFile() {
        return null;
    }

    @Override
    public File getFile(String path) {
        return null;
    }

    @Override
    public String getPath() {
        return null;
    }
}

