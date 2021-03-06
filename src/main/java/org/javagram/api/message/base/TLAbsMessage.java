package org.javagram.api.message.base;

import org.javagram.api._primitives.TLObject;

/**
 * The Message type.
 */
public abstract class TLAbsMessage extends TLObject {

    protected TLAbsMessage() {
        super();
    }
    
    public int getId() {
        return -1;
    }
    
    public abstract int getChatId();

    public String toLog() {
        return "--UNKNOWN--";
    }

}