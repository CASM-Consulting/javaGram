/**
 * This is the source code of Telegram Bot v. 2.0
 * It is licensed under GNU GPL v. 3 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Ruben Bermudez, 13/11/14.
 */
package org.javagram.api.contacts.base;

/**
 * Contact list on the server is the same as the list on the client
 * @author Ruben Bermudez
 * @version 2.0
 * @since 02/MAY/2015
 */
public class TLContactsNotModified extends TLAbsContacts {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xb74ba9d2;

    public TLContactsNotModified() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "contacts.contactsNotModified#b74ba9d2";
    }

}