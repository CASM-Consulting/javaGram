package org.telegram.api.bot.base.input;

import org.telegram.utils.StreamingUtils;
import org.telegram.api._primitives.TLContext;
import org.telegram.api._primitives.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Ruben Bermudez
 * @version 1.0
 *  * @since 09/APR/2016
 */
public class TLInputBotInlineMessageId extends TLObject {
    public static final int CLASS_ID = 0x890c3d89;

    private int dcId;
    private long id;
    private long accessHash;

    public TLInputBotInlineMessageId() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getDcId() {
        return dcId;
    }

    public long getId() {
        return id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(dcId, stream);
        StreamingUtils.writeLong(id, stream);
        StreamingUtils.writeLong(accessHash, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        dcId = StreamingUtils.readInt(stream);
        id = StreamingUtils.readLong(stream);
        accessHash = StreamingUtils.readLong(stream);
    }

    @Override
    public String toString() {
        return "inputBotInlineMessageID#890c3d89";
    }

}
