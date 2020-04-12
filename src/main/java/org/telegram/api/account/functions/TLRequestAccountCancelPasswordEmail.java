package org.telegram.api.account.functions;

import org.telegram.utils.StreamingUtils;
import org.telegram.api._primitives.TLBool;
import org.telegram.api._primitives.TLContext;
import org.telegram.api._primitives.TLMethod;
import org.telegram.api._primitives.TLObject;
import java.io.IOException;
import java.io.InputStream;

/**
 * Cancel the code that was sent to verify an email to use as @see <a href="https://core.telegram.org/api/srp">2FA recovery method</a>.
 * account.cancelPasswordEmail#c1cbd5b6 = Bool;
 */
public class TLRequestAccountCancelPasswordEmail extends TLMethod<TLBool> {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xc1cbd5b6;

    public TLRequestAccountCancelPasswordEmail() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
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
        return "account.cancelPasswordEmail#c1cbd5b6";
    }

}