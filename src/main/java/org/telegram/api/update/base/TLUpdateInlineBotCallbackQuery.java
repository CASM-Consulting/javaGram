/**
 * This file is part of Support Bot.
 *
 *     Foobar is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Foobar is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.api.update.base;

import org.telegram.api.bot.base.input.TLInputBotInlineMessageId;
import org.telegram.utils.StreamingUtils;
import org.telegram.api._primitives.TLBytes;
import org.telegram.api._primitives.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL update channel group
 */
public class TLUpdateInlineBotCallbackQuery extends TLAbsUpdate {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xf9d27a5a;

    private static final int FLAG_DATA    = 0x00000001; // 0
    private static final int FLAG_GAMEID  = 0x00000002; // 1

    private int flags;
    private long queryId;
    private int userId;
    private TLInputBotInlineMessageId msgId;
    private long chatInstance;
    private TLBytes data;
    private String gameShortName;

    public TLUpdateInlineBotCallbackQuery() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public long getQueryId() {
        return queryId;
    }

    public int getUserId() {
        return userId;
    }

    public TLInputBotInlineMessageId getMsgId() {
        return msgId;
    }

    public TLBytes getData() {
        return data;
    }

    public long getChatInstance() {
        return chatInstance;
    }

    public String getGameShortName() {
        return gameShortName;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(this.flags, stream);
        StreamingUtils.writeLong(this.queryId, stream);
        StreamingUtils.writeInt(this.userId, stream);
        StreamingUtils.writeTLObject(this.msgId, stream);
        StreamingUtils.writeLong(this.chatInstance, stream);
        if ((flags & FLAG_DATA) != 0) {
            StreamingUtils.writeTLBytes(this.data, stream);
        }
        if ((flags & FLAG_GAMEID) != 0) {
            StreamingUtils.writeTLString(this.gameShortName, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.flags = StreamingUtils.readInt(stream);
        this.queryId = StreamingUtils.readLong(stream);
        this.userId = StreamingUtils.readInt(stream);
        this.msgId = StreamingUtils.readTLObject(stream, context, TLInputBotInlineMessageId.class);
        this.chatInstance = StreamingUtils.readInt(stream);
        if ((flags & FLAG_DATA) != 0) {
            this.data = StreamingUtils.readTLBytes(stream, context);
        }
        if ((flags & FLAG_GAMEID) != 0) {
            this.gameShortName = StreamingUtils.readTLString(stream);
        }
    }

    @Override
    public String toString() {
        return "updateInlineBotCallbackQuery#f9d27a5a";
    }

}