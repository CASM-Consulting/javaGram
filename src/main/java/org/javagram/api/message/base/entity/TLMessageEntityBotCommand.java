package org.javagram.api.message.base.entity;

import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Message entity representing a bot /command
 * messageEntityBotCommand#6cef8ac7 offset:int length:int = MessageEntity;
 */
public class TLMessageEntityBotCommand extends TLAbsMessageEntity {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x6cef8ac7;

    /**
     * Offset of message entity within message (in UTF-8 codepoints)
     */
    private int offset;
    
    /**
     * Length of message entity within message (in UTF-8 codepoints)
     */
    private int length;

    public TLMessageEntityBotCommand() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(this.offset, stream);
        StreamingUtils.writeInt(this.length, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.offset = StreamingUtils.readInt(stream);
        this.length = StreamingUtils.readInt(stream);
    }

    @Override
    public String toString() {
        return "message.entity.MessageEntityBotCommand#6cef8ac7";
    }

}