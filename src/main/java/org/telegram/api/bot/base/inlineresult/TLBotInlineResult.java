package org.telegram.api.bot.base.inlineresult;

import org.telegram.api.bot.base.inlinemessage.TLAbsBotInlineMessage;
import org.telegram.utils.StreamingUtils;
import org.telegram.api._primitives.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.telegram.api.document.base.web.TLWebDocument;

/**
 * @author Ruben Bermudez
 * @version 1.0
  * @since 13/FEB/2016
 */
public class TLBotInlineResult extends TLAbsBotInlineResult {
    public static final int CLASS_ID = 0x11965f3a;

    private static final int FLAG_TITLE           = 0x00000002; // 1
    private static final int FLAG_DESCRIPTION     = 0x00000004; // 2
    private static final int FLAG_URL             = 0x00000008; // 3
    private static final int FLAG_THUMB           = 0x00000010; // 4
    private static final int FLAG_CONTENT         = 0x00000020; // 5

    private String id;
    private String type;
    private String title;
    private String description;
    private String url;
    private TLWebDocument thumb;
    private TLWebDocument content;
    private TLAbsBotInlineMessage sendMessage;

    protected TLBotInlineResult() {
        super();
    }

    public TLWebDocument getThumb() {
        return thumb;
    }

    public void setThumb(TLWebDocument thumb) {
        this.thumb = thumb;
    }

    public TLWebDocument getContent() {
        return content;
    }

    public void setContent(TLWebDocument content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TLAbsBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(this.flags, stream);
        StreamingUtils.writeTLString(this.id, stream);
        StreamingUtils.writeTLString(this.type, stream);
        if ((this.flags & FLAG_TITLE) != 0) {
            StreamingUtils.writeTLString(this.title, stream);
        }
        if ((this.flags & FLAG_DESCRIPTION) != 0) {
            StreamingUtils.writeTLString(this.description, stream);
        }
        if ((this.flags & FLAG_URL) != 0) {
            StreamingUtils.writeTLString(this.url, stream);
        }
        if ((this.flags & FLAG_THUMB) != 0) {
            StreamingUtils.writeTLObject(this.thumb, stream);
        }
        if ((this.flags & FLAG_CONTENT) != 0) {
            StreamingUtils.writeTLObject(this.content, stream);
        }
        StreamingUtils.writeTLObject(this.sendMessage, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.flags = StreamingUtils.readInt(stream);
        this.id = StreamingUtils.readTLString(stream);
        this.type = StreamingUtils.readTLString(stream);
        if ((this.flags & FLAG_TITLE) != 0) {
            this.title = StreamingUtils.readTLString(stream);
        }
        if ((this.flags & FLAG_DESCRIPTION) != 0) {
            this.description = StreamingUtils.readTLString(stream);
        }
        if ((this.flags & FLAG_URL) != 0) {
            this.url = StreamingUtils.readTLString(stream);
        }
        if ((this.flags & FLAG_THUMB) != 0) {
            this.thumb = StreamingUtils.readTLObject(stream, context, TLWebDocument.class);
        }
        if ((this.flags & FLAG_CONTENT) != 0) {
            this.content = StreamingUtils.readTLObject(stream, context, TLWebDocument.class);
        }
        this.sendMessage = StreamingUtils.readTLObject(stream, context, TLAbsBotInlineMessage.class);
    }

    @Override
    public String toString() {
        return "botInlineResult#11965f3a";
    }

}
