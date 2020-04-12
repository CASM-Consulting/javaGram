package org.telegram.api.update.base;

import org.telegram.utils.StreamingUtils;
import org.telegram.api._primitives.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL update channel too long
 */
public class TLUpdateChannelTooLong extends TLAbsUpdate {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xeb0467fb;

    private static final int FLAG_PTS = 0x00000001; // 0

    private int channelId;
    private int pts;

    public TLUpdateChannelTooLong() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    @Override
    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(this.flags, stream);
        StreamingUtils.writeInt(this.channelId, stream);
        if ((flags & FLAG_PTS) != 0) {
            StreamingUtils.writeInt(this.pts, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = StreamingUtils.readInt(stream);
        channelId = StreamingUtils.readInt(stream);
        if ((flags & FLAG_PTS) != 0) {
            pts = StreamingUtils.readInt(stream);
        }
    }

    @Override
    public String toString() {
        return "update.TLUpdateChannelTooLong#eb0467fb";
    }

}