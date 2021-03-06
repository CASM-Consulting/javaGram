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

/*
 * This is the source code of Telegram Bot v. 2.0
 * It is licensed under GNU GPL v. 3 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Ruben Bermudez, 21/11/14.
 */
package org.javagram.api.privacy.base.privacyrule;

import org.javagram.api.user.base.TLAbsUser;
import org.javagram.utils.StreamingUtils;
import org.javagram.api._primitives.TLContext;
import org.javagram.api._primitives.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL privacy value allow users.
 * @author Ruben Bermudez
 * @version 2.0
 * TLPrivacyValueAllowUsers
 * @since 21/NOV/2014
 */
public class TLPrivacyValueAllowUsers extends TLAbsPrivacyRule {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x4d5bbe0c;

    /**
     * The Users.
     */
    protected TLVector<TLAbsUser> users = new TLVector<>();

    public TLPrivacyValueAllowUsers() {
        super();
    }

    public TLVector<TLAbsUser> getUsers() {
        return this.users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamingUtils.writeTLVector(this.users, stream);

    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        this.users = StreamingUtils.readTLVector(stream, context, TLAbsUser.class);
    }

    @Override
    public String toString() {
        return "privacy.PrivacyValueAllowUsers#4d5bbe0c";
    }

}
