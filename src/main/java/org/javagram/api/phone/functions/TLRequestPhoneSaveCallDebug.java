package org.javagram.api.phone.functions;

import org.javagram.api.json.base.TLDataJSON;
import org.javagram.api.phone.base.call.input.TLInputPhoneCall;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.javagram.api._primitives.TLBool;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLMethod;
import org.javagram.api._primitives.TLObject;
import org.javagram.utils.StreamingUtils;

/**
 * @author Ruben Bermudez
 * @version 1.0
 */
public class TLRequestPhoneSaveCallDebug extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0x277add7e;

    private TLInputPhoneCall peer;
    private TLDataJSON debug;

    public TLRequestPhoneSaveCallDebug() {
        super();
    }

    public TLInputPhoneCall getPeer() {
        return peer;
    }

    public void setPeer(TLInputPhoneCall peer) {
        this.peer = peer;
    }

    public TLDataJSON getDebug() {
        return debug;
    }

    public void setDebug(TLDataJSON debug) {
        this.debug = debug;
    }

    @Override
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        } else if (res instanceof TLBool) {
            return (TLBool) res;
        }
        throw new IOException("Incorrect response type. Expected " + TLBool.class.getCanonicalName() +
                ", got: " + res.getClass().getCanonicalName());
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeTLObject(peer, stream);
        StreamingUtils.writeTLObject(debug, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = StreamingUtils.readTLObject(stream, context, TLInputPhoneCall.class);
        debug = StreamingUtils.readTLObject(stream, context, TLDataJSON.class);
    }

    @Override
    public String toString() {
        return "phone.saveCallDebug#277add7e";
    }

}
