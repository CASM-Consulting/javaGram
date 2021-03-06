package org.javagram.api.updates.functions;

import org.javagram.api.updates.base.TLUpdatesState;
import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLMethod;
import org.javagram.api._primitives.TLObject;
import java.io.IOException;
import java.io.InputStream;

/**
 * The type TL request updates get state.
 */
public class TLRequestUpdatesGetState extends TLMethod<TLUpdatesState> {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xedd4882a;

    public TLRequestUpdatesGetState() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public TLUpdatesState deserializeResponse(InputStream stream, TLContext context) throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if (res instanceof TLUpdatesState)
            return (TLUpdatesState) res;
        throw new IOException("Incorrect response type. Expected org.telegram.api.updates.TLState, got: " + res.getClass().getCanonicalName());
    }

    @Override
    public String toString() {
        return "updates.getState#edd4882a";
    }

}