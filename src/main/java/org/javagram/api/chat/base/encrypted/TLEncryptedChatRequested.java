/*
 * This is the source code of Telegram Bot v. 2.0
 * It is licensed under GNU GPL v. 3 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Ruben Bermudez, 13/11/14.
 */
package org.javagram.api.chat.base.encrypted;

import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLBytes;
import org.javagram.api._primitives.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Request to create an encrypted chat with another user
 * @author Ruben Bermudez
 * @version 2.0
 * @since 11/APR/2015
 */
public class TLEncryptedChatRequested extends TLAbsEncryptedChat {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xc878527e;
    private long accessHash; ///< Check sum dependant on the user ID
    private int date; ///< Chat creation date
    private int adminId; ///< Creator user id
    private int participantId; ///< Second participant user id
    /**
     * <code>A = g ^ a mod p</code>
     * @see <a href="http://en.wikipedia.org/wiki/Diffie%E2%80%93Hellman_key_exchange">Wikipedia</a>
     */
    private TLBytes gA;

    public TLEncryptedChatRequested() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    /**
     * Gets access hash.
     *
     * @return the access hash
     */
    public long getAccessHash() {
        return this.accessHash;
    }

    /**
     * Sets access hash.
     *
     * @param accessHash the access hash
     */
    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public int getDate() {
        return this.date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * Gets admin id.
     *
     * @return the admin id
     */
    public int getAdminId() {
        return this.adminId;
    }

    /**
     * Sets admin id.
     *
     * @param adminId the admin id
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * Gets participant id.
     *
     * @return the participant id
     */
    public int getParticipantId() {
        return this.participantId;
    }

    /**
     * Sets participant id.
     *
     * @param participantId the participant id
     */
    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }
    /**
     * Gets a.
     *
     * @return the a
     */
    public TLBytes getgA() {
        return this.gA;
    }

    /**
     * Sets a.
     *
     * @param gA the g a
     */
    public void setgA(TLBytes gA) {
        this.gA = gA;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeInt(this.id, stream);
        StreamingUtils.writeLong(this.accessHash, stream);
        StreamingUtils.writeInt(this.date, stream);
        StreamingUtils.writeInt(this.adminId, stream);
        StreamingUtils.writeInt(this.participantId, stream);
        StreamingUtils.writeTLBytes(this.gA, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.id = StreamingUtils.readInt(stream);
        this.accessHash = StreamingUtils.readLong(stream);
        this.date = StreamingUtils.readInt(stream);
        this.adminId = StreamingUtils.readInt(stream);
        this.participantId = StreamingUtils.readInt(stream);
        this.gA = StreamingUtils.readTLBytes(stream, context);
    }

    @Override
    public String toString() {
        return "encryptedChatRequested#c878527e";
    }

}