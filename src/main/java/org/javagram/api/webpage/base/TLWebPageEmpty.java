/*
 * This is the source code of bot v. 2.0
 * It is licensed under GNU GPL v. 3 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Ruben Bermudez, 9/01/15.
 */
package org.javagram.api.webpage.base;

import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL web page empty.
 * @author Ruben Bermudez
 * @version 2.0
 * TLWebPageEmpty
 * @since 09/JAN/2015
 */
public class TLWebPageEmpty extends TLAbsWebPage {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xeb1477e8;

    private long id;

    public TLWebPageEmpty() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeLong(this.id, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.id = StreamingUtils.readLong(stream);
    }

    @Override
    public String toString() {
        return "webPageEmpty#eb1477e8";
    }

}
