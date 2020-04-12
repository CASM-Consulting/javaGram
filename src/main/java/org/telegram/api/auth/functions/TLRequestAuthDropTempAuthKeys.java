package org.telegram.api.auth.functions;

import org.telegram.utils.StreamingUtils;
import org.telegram.api._primitives.TLBool;
import org.telegram.api._primitives.TLContext;
import org.telegram.api._primitives.TLLongVector;
import org.telegram.api._primitives.TLMethod;
import org.telegram.api._primitives.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Delete all temporary authorization keys <strong>except for</strong> the ones specified
 * auth.dropTempAuthKeys#8e48a188 except_auth_keys:Vector&lt;long&gt; = Bool;
 */
public class TLRequestAuthDropTempAuthKeys extends TLMethod<TLBool> {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x8e48a188;

    /**
     * The auth keys that <strong>shouldn't</strong> be dropped.
     */
    private TLLongVector exceptAuthKeys;

    public TLRequestAuthDropTempAuthKeys() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLLongVector getExceptAuthKeys() {
        return exceptAuthKeys;
    }

    public void setExceptAuthKeys(TLLongVector exceptAuthKeys) {
        this.exceptAuthKeys = exceptAuthKeys;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeTLVector(this.exceptAuthKeys, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.exceptAuthKeys = StreamingUtils.readTLLongVector(stream, context);
    }

    @Override
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        } else if (res instanceof TLBool) {
            return (TLBool) res;
        } else {
            throw new IOException("Incorrect response type. Expected " + TLBool.class.getCanonicalName() + ", got: " + res.getClass().getCanonicalName());
        }
    }

    @Override
    public String toString() {
        return "auth.dropTempAuthKeys#8e48a188";
    }

}