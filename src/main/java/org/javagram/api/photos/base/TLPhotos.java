package org.javagram.api.photos.base;

import org.javagram.api.photo.base.TLAbsPhoto;
import org.javagram.api.user.base.TLAbsUser;
import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL photos.
 */
public class TLPhotos extends TLAbsPhotos {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x8dca6aa5;

    public TLPhotos() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeTLVector(this.photos, stream);
        StreamingUtils.writeTLVector(this.users, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.photos = StreamingUtils.readTLVector(stream, context, TLAbsPhoto.class);
        this.users = StreamingUtils.readTLVector(stream, context, TLAbsUser.class);
    }

    @Override
    public String toString() {
        return "photos.photos#8dca6aa5";
    }

}