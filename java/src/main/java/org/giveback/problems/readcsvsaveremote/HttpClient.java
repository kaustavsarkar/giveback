package org.giveback.problems.readcsvsaveremote;

public interface HttpClient {
    /**
     * There are going to be separate builders associated with clients. For
     * simplicity of the solution we are ignoring it.
     */
    void post(String content);
}
