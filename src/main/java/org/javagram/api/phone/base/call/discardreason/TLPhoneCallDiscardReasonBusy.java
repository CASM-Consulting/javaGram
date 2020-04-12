package org.javagram.api.phone.base.call.discardreason;

import org.javagram.api._primitives.TLObject;

/**
 * @author Ruben Bermudez
 * @version 1.0
 */
public class TLPhoneCallDiscardReasonBusy extends TLAbsPhoneCallDiscardReason {
    public static final int CLASS_ID = 0xfaf7e8c9;

    public TLPhoneCallDiscardReasonBusy() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "phoneCallDiscardReasonBusy#faf7e8c9";
    }

}
