package org.javagram.api.auth.base.codetype;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @since 16/MAR/2016
 */
public class TLCodeTypeFlashCall extends TLAbsCodeType {
    public static final int CLASS_ID = 0x226ccefb;

    public TLCodeTypeFlashCall() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "auth.codeTypeFlashCall#226ccefb";
    }

}
