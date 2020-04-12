package org.javagram.api.messages.functions;

import org.javagram.api.sticker.base.input.set.TLAbsInputStickerSet;
import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLBool;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLMethod;
import org.javagram.api._primitives.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Uninstall a stickerset
 * messages.uninstallStickerSet#f96e55de stickerset:InputStickerSet = Bool;
 */
public class TLRequestMessagesUninstallStickerSet extends TLMethod<TLBool> {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xf96e55de;

    /**
     * The stickerset to uninstall
     */
    private TLAbsInputStickerSet stickerSet;

    public TLRequestMessagesUninstallStickerSet() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeTLObject(this.stickerSet, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.stickerSet = StreamingUtils.readTLObject(stream, context, TLAbsInputStickerSet.class);
    }

    @Override
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        } else if (res instanceof TLBool) {
            return (TLBool) res;
        } else {
            throw new IOException("Incorrect response type. Expected org.telegram.api.TLBool, got: " + res.getClass().getCanonicalName());
        }
    }

    @Override
    public String toString() {
        return "stickers.uninstallStickersSet#f96e55de";
    }

}