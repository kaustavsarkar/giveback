package org.giveback.problems.readcsvsaveremote;

import java.io.StringReader;
import java.util.List;

/**
 * A {@code File} could either be a document or a folder.
 */
public interface File {
    /**
     * Returns true if the current location is a document.
     */
    boolean isDocument();

    /**
     * Returns true if the current location is a directory.
     */
    boolean isDirectory();

    /**
     * Returns true if the current location is a directory and is empty.
     */
    boolean isEmpty();

    /**
     * If the current location is a directory, it lists all directories and
     * documents  present.
     */
    List<File> listFiles();

    /**
     * Returns the extension of the current location, considering it is a
     * document.
     */
    String getExtension();

    /**
     * Reads the document and returns a {@link StringReader}.
     */
    StringReader readFile();

    File getFile(String path);

    String getPath();
}