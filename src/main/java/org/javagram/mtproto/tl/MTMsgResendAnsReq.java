package org.javagram.mtproto.tl;

import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLLongVector;
import org.javagram.api._primitives.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import org.javagram.utils.StreamingUtils;

public class MTMsgResendAnsReq extends TLObject {

    public static final int CLASS_ID = 0x8610baeb;

    private TLLongVector messages;

    public MTMsgResendAnsReq(TLLongVector messages) {
        this.messages = messages;
    }

    public MTMsgResendAnsReq() {
        this.messages = new TLLongVector();
    }

    public MTMsgResendAnsReq(long[] msgIds) {
        this.messages = new TLLongVector();
        for (long id : msgIds) {
            this.messages.add(id);
        }
    }

    public MTMsgResendAnsReq(Long[] msgIds) {
        this.messages = new TLLongVector();
        Collections.addAll(this.messages, msgIds);
    }

    public TLLongVector getMessages() {
        return this.messages;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeTLVector(this.messages, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.messages = StreamingUtils.readTLLongVector(stream, context);
    }

    @Override
    public String toString() {
        return "msg_resend_req#7d861a08";
    }

}