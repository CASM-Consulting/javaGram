package org.telegram.api.privacy.base.privacyrule;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.telegram.utils.StreamingUtils;
import org.telegram.api._primitives.TLContext;
import org.telegram.api._primitives.TLVector;

/**
 * Disallow only participants of certain chats
 * privacyValueDisallowChatParticipants#acae0690 chats:Vector&lt;int&gt; = PrivacyRule;
 */
public class TLPrivacyValueDisallowChatParticipants extends TLAbsPrivacyRule {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xacae0690;

    /**
     * Disallowed chats
     */
    private TLVector<Integer> chats = new TLVector<>();

    public TLPrivacyValueDisallowChatParticipants() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<Integer> getChats() {
        return chats;
    }

    public void setChats(TLVector<Integer> chats) {
        this.chats = chats;
    }
    

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeTLVector(this.chats, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.chats = StreamingUtils.readTLIntVector(stream, context);
    }

    @Override
    public String toString() {
        return "privacyValueDisallowChatParticipants#acae0690";
    }

}