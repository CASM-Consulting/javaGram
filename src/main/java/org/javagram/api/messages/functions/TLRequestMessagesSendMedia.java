package org.javagram.api.messages.functions;

import org.javagram.api.input.media.TLAbsInputMedia;
import org.javagram.api.peer.base.input.TLAbsInputPeer;
import org.javagram.api.keyboard.base.replymarkup.TLAbsReplyMarkup;
import org.javagram.api.updates.base.TLAbsUpdates;
import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLMethod;
import org.javagram.api._primitives.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.javagram.api.message.base.entity.TLAbsMessageEntity;
import org.javagram.api._primitives.TLVector;

/**
 * Send a media
 * messages.sendMedia#3491eba9 flags:# silent:flags.5?true background:flags.6?true clear_draft:flags.7?true peer:InputPeer reply_to_msg_id:flags.0?int media:InputMedia message:string random_id:long reply_markup:flags.2?ReplyMarkup entities:flags.3?Vector&lt;MessageEntity&gt; schedule_date:flags.10?int = Updates;
 */
public class TLRequestMessagesSendMedia extends TLMethod<TLAbsUpdates> {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x3491eba9;

    private static final int FLAG_REPLY_TO_MSG_ID  = 0x00000001; //  0 : The message ID to which this message will reply to
    private static final int FLAG_REPLY_MARKUP     = 0x00000004; //  2 : Reply markup for sending bot buttons
    private static final int FLAG_ENTITIES         = 0x00000008; //  3 : Message @see <a href="https://core.telegram.org/api/entities">entities</a> for sending styled text
    private static final int FLAG_SILENT           = 0x00000020; //  5 : Send this message silently (no notifications for the receivers)
    private static final int FLAG_BACKGROUND       = 0x00000040; //  6 : Send this message as background message
    private static final int FLAG_CLEAR_DRAFT      = 0x00000080; //  7 : Clear the draft field
    private static final int FLAG_SCHEDULE_DATE    = 0x00000400; // 10 : Scheduled message date for scheduled messages

     /**
      * Destination
      */
    private TLAbsInputPeer peer;

    /**
     * Message ID to which this message should reply to
     */
    private int replyToMsgId;
    
    /**
     * Attached media
     */
    private TLAbsInputMedia media;

    /**
     * Caption
     */
    private String message;

    /**
     * Random ID to avoid resending the same message
     */
    private long randomId;

    /**
     * Reply markup for bot keyboards
     */
    private TLAbsReplyMarkup replyMarkup;

    /**
     * Message @see <a href="https://core.telegram.org/api/entities">entities</a> for sending styled text
     */
    private TLVector<TLAbsMessageEntity> entities;
    
    /**
     * Scheduled message date for scheduled messages
     */
    private int scheduleDate;

    public TLRequestMessagesSendMedia() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public boolean isSilent() {
        return this.isFlagSet(FLAG_SILENT);
    }

    public void setSilent(boolean value) {
        this.setFlag(FLAG_SILENT, value);
    }

    public boolean isBackground() {
        return this.isFlagSet(FLAG_BACKGROUND);
    }

    public void setBackground(boolean value) {
        this.setFlag(FLAG_BACKGROUND, value);
    }

    public boolean isClearDraft() {
        return this.isFlagSet(FLAG_CLEAR_DRAFT);
    }

    public void setClearDraft(boolean value) {
        this.setFlag(FLAG_CLEAR_DRAFT, value);
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public boolean hasReplyToMsgId() {
        return this.isFlagSet(FLAG_REPLY_TO_MSG_ID);
    }

    public int getReplyToMsgId() {
        return replyToMsgId;
    }

    public void setReplyToMsgId(int replyToMsgId) {
        this.replyToMsgId = replyToMsgId;
        this.setFlag(FLAG_REPLY_TO_MSG_ID, this.replyToMsgId != 0);
    }

    public TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsInputMedia media) {
        this.media = media;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }

    public boolean hasReplyMarkup() {
        return this.isFlagSet(FLAG_REPLY_MARKUP);
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        this.setFlag(FLAG_REPLY_MARKUP, this.replyMarkup != null);
    }

    public boolean hasEntities() {
        return this.isFlagSet(FLAG_ENTITIES);
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
        this.setFlag(FLAG_ENTITIES, this.entities != null && !this.entities.isEmpty());
    }

    public boolean hasScheduleDate() {
        return this.isFlagSet(FLAG_SCHEDULE_DATE);
    }

    public int getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(int scheduleDate) {
        this.scheduleDate = scheduleDate;
        this.setFlag(FLAG_SCHEDULE_DATE, this.scheduleDate != 0);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(this.flags, stream);
        StreamingUtils.writeTLObject(this.peer, stream);
        if (this.hasReplyToMsgId()) {
            StreamingUtils.writeInt(this.replyToMsgId, stream);
        }
        StreamingUtils.writeTLObject(this.media, stream);
        StreamingUtils.writeTLString(this.message, stream);
        StreamingUtils.writeLong(this.randomId, stream);
        if (this.hasReplyMarkup()) {
            StreamingUtils.writeTLObject(this.replyMarkup, stream);
        }
        if (this.hasEntities()) {
            StreamingUtils.writeTLVector(this.entities, stream);
        }
        if (this.hasScheduleDate()) {
            StreamingUtils.writeInt(this.scheduleDate, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.flags = StreamingUtils.readInt(stream);
        this.peer = StreamingUtils.readTLObject(stream, context, TLAbsInputPeer.class);
        if (this.hasReplyToMsgId()) {
            this.replyToMsgId = StreamingUtils.readInt(stream);
        }
        this.media = StreamingUtils.readTLObject(stream, context, TLAbsInputMedia.class);
        this.message = StreamingUtils.readTLString(stream);
        this.randomId = StreamingUtils.readLong(stream);
        if (this.hasReplyMarkup()) {
            this.replyMarkup = StreamingUtils.readTLObject(stream, context, TLAbsReplyMarkup.class);
        }
        if (this.hasEntities()) {
            this.entities = StreamingUtils.readTLVector(stream, context, TLAbsMessageEntity.class);
        }
        if (this.hasScheduleDate()) {
            this.scheduleDate = StreamingUtils.readInt(stream);
        }
    }

    @Override
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        } else if (res instanceof TLAbsUpdates) {
            return (TLAbsUpdates) res;
        } else {
            throw new IOException("Incorrect response type. Expected org.telegram.api.updates.TLAbsUpdates, got: " + res.getClass().getCanonicalName());
        }
    }

    @Override
    public String toString() {
        return "messages.sendMedia#3491eba9";
    }

}