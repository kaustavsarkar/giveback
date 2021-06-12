package org.giveback.problems.readcsvsaveremote;

public final class FileFactory {
    public static File getFile(String system, String path) {
        if (system.equals("linux")) {
            return new LinuxFile();
        }
        throw new IllegalArgumentException();
    }
}
