package org.javagram.api.payment.base;

import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Ruben Bermudez
 * @version 1.0
 */
public class TLLabeledPrice extends TLObject {
    public static final int CLASS_ID = 0xcb296bf8;

    private String label;
    private long amount;

    public TLLabeledPrice() {
        super();
    }

    public String getLabel() {
        return label;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeTLString(label, stream);
        StreamingUtils.writeLong(amount, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        label = StreamingUtils.readTLString(stream);
        amount = StreamingUtils.readLong(stream);
    }

    @Override
    public String toString() {
        return "labeledPrice#cb296bf8";
    }

}
