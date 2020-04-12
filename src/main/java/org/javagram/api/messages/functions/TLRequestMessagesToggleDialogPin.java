package org.javagram.api.messages.functions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.javagram.api._primitives.TLBool;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLMethod;
import org.javagram.api._primitives.TLObject;
import org.javagram.api.dialog.base.input.TLAbsInputDialogPeer;
import org.javagram.utils.StreamingUtils;

/**
 * Pin/unpin a dialog
 * messages.toggleDialogPin#a731e257 flags:# pinned:flags.0?true peer:InputDialogPeer = Bool;
 */
public class TLRequestMessagesToggleDialogPin extends TLMethod<TLBool> {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xa731e257;

    private static final int FLAG_PINNED      = 0x00000001; // 0

    /**
     * The dialog to pin
     */
    private TLAbsInputDialogPeer peer;

    public TLRequestMessagesToggleDialogPin() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public boolean isPinned() {
        return (this.isFlagSet(FLAG_PINNED));
    }

    public void setPinned(boolean value) {
        this.setFlag(FLAG_PINNED, value);
    }

    public TLAbsInputDialogPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputDialogPeer peer) {
        this.peer = peer;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(this.flags, stream);
        StreamingUtils.writeTLObject(this.peer, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.flags = StreamingUtils.readInt(stream);
        this.peer = StreamingUtils.readTLObject(stream, context, TLAbsInputDialogPeer.class);
    }

    @Override
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        } else if (res instanceof TLBool) {
            return (TLBool) res;
        } else {
            throw new IOException("Incorrect response type. Expected " + TLBool.class.getName() + ", got: " + res.getClass().getCanonicalName());
        }
    }

    @Override
    public String toString() {
        return "messages.toggleDialogPin#a731e257";
    }

}