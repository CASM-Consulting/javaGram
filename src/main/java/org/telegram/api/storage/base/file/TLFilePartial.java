package org.telegram.api.storage.base.file;

/**
 * The type TL file partial.
 */
public class TLFilePartial extends TLAbsFileType {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x40bc6f52;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "storage.filePartial#40bc6f52";
    }

}