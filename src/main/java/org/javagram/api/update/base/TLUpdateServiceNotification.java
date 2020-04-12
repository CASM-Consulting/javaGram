package org.javagram.api.update.base;

import org.javagram.api.message.base.entity.TLAbsMessageEntity;
import org.javagram.api.message.base.media.TLAbsMessageMedia;
import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL update service notification.
 */
public class TLUpdateServiceNotification extends TLAbsUpdate {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xebe46819;

    private static final int FLAG_POPUP          = 0x00000001; // 0
    private static final int FLAG_INBOX_DATE     = 0x00000002; // 1

    private int inboxDate;
    private String type;
    private String message;
    private TLAbsMessageMedia media;
    private TLVector<TLAbsMessageEntity> entities;

    public TLUpdateServiceNotification() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public TLAbsMessageMedia getMedia() {
        return media;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public boolean isPopup() {
        return (flags & FLAG_POPUP) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(this.flags, stream);
        if ((flags & FLAG_INBOX_DATE) != 0) {
            StreamingUtils.writeInt(inboxDate, stream);
        }
        StreamingUtils.writeTLString(this.type, stream);
        StreamingUtils.writeTLString(this.message, stream);
        StreamingUtils.writeTLObject(this.media, stream);
        StreamingUtils.writeTLVector(this.entities, stream);

    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = StreamingUtils.readInt(stream);
        if ((flags & FLAG_INBOX_DATE) != 0) {
            inboxDate = StreamingUtils.readInt(stream);
        }
        this.type = StreamingUtils.readTLString(stream);
        this.message = StreamingUtils.readTLString(stream);
        this.media = StreamingUtils.readTLObject(stream, context, TLAbsMessageMedia.class);
        this.entities = StreamingUtils.readTLVector(stream, context, TLAbsMessageEntity.class);
    }

    @Override
    public String toString() {
        return "updateServiceNotification#ebe46819";
    }

}