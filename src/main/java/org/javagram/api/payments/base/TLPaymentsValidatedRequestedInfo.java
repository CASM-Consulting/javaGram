package org.javagram.api.payments.base;

import org.javagram.api.payment.base.TLShippingOption;
import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLObject;
import org.javagram.api._primitives.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Ruben Bermudez
 * @version 1.0
 */
public class TLPaymentsValidatedRequestedInfo extends TLObject {
    public static final int CLASS_ID = 0xd1451883;

    private static final int FLAG_ID                     = 0x00000001; // 0
    private static final int FLAG_SHIPPING_OPTIONS       = 0x00000002; // 1

    private String id;
    private TLVector<TLShippingOption> shippingOptions;

    public TLPaymentsValidatedRequestedInfo() {
        super();
    }

    public String getId() {
        return id;
    }

    public TLVector<TLShippingOption> getShippingOptions() {
        return shippingOptions;
    }

    public boolean hasId() {
        return (flags & FLAG_ID) != 0;
    }

    public boolean hasShippingOptions() {
        return (flags & FLAG_SHIPPING_OPTIONS) != 0;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(this.flags, stream);
        if (hasId()) {
            StreamingUtils.writeTLString(id, stream);
        }
        if (hasShippingOptions()) {
            StreamingUtils.writeTLVector(shippingOptions, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = StreamingUtils.readInt(stream);
        if (hasId()) {
            id = StreamingUtils.readTLString(stream);
        }
        if (hasShippingOptions()) {
            shippingOptions = StreamingUtils.readTLVector(stream, context, TLShippingOption.class);
        }
    }

    @Override
    public String toString() {
        return "payments.validatedRequestedInfo#d1451883";
    }

}
