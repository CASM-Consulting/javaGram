package org.javagram.api.sticker.base.input.set;

import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Ruben Bermudez
 * @version 1.0
 *  * @since 07/JUL/2015
 */
public class TLInputStickerSetId extends TLAbsInputStickerSet {
    public static final int CLASS_ID = 0x9de7a269;

    private long id;
    private long accessHash;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return this.accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeLong(this.id, stream);
        StreamingUtils.writeLong(this.accessHash, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.id = StreamingUtils.readLong(stream);
        this.accessHash = StreamingUtils.readLong(stream);
    }

    @Override
    public String toString() {
        return "sticker.set.inputStickerSetId#9de7a269";
    }

}
