package org.javagram.api.page.base.block;

import org.javagram.api.richtext.base.TLAbsRichText;
import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Ruben Bermudez
 * @version 1.0
 */
public class TLPageBlockPullquote extends TLAbsPageBlock {
    public static final int CLASS_ID = 0x4f4456d3;

    private TLAbsRichText text;
    private TLAbsRichText caption;

    public TLPageBlockPullquote() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsRichText getText() {
        return text;
    }

    public TLAbsRichText getCaption() {
        return caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeTLObject(text, stream);
        StreamingUtils.writeTLObject(caption, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = StreamingUtils.readTLObject(stream, context, TLAbsRichText.class);
        caption = StreamingUtils.readTLObject(stream, context, TLAbsRichText.class);
    }

    @Override
    public String toString() {
        return "pageBlockPullquote#4f4456d3";
    }

}
