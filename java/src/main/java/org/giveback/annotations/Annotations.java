package org.giveback.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public final class Annotations {
    private Annotations() {}

    @Retention(RUNTIME)
    public @interface VisibleForTests {}
}
