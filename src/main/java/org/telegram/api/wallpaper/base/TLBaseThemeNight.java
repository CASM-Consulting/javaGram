package org.telegram.api.wallpaper.base;

import org.telegram.api._primitives.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Webpage attributes
 */
public class TLBaseThemeNight extends TLAbsBaseTheme {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xb7b31ea8;

    public TLBaseThemeNight() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
    }

    @Override
    public String toString() {
        return "baseThemeNight#b7b31ea8";
    }

}