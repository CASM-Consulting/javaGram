package org.javagram.api.messages.functions;

import org.javagram.api.messages.base.TLMessagesPeerDialogs;
import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLMethod;
import org.javagram.api._primitives.TLObject;
import java.io.IOException;
import java.io.InputStream;
import org.javagram.api.message.base.TLMessageRange;

/**
 * Get message ranges for saving the user's chat history
 * messages.getSplitRanges#1cff7e08 = Vector&lt;MessageRange&gt;;
 */
public class TLRequestMessagesGetSplitRanges extends TLMethod<TLMessageRange> {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x1cff7e08;

    public TLRequestMessagesGetSplitRanges() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLMessageRange deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        } else if (res instanceof TLMessageRange) {
            return (TLMessageRange) res;
        } else {
            throw new IOException("Incorrect response type. Expected " + TLMessagesPeerDialogs.class.getName() + ", got: " + res.getClass().getCanonicalName());
        }
    }

    @Override
    public String toString() {
        return "messages.getSplitRanges#1cff7e08";
    }

}