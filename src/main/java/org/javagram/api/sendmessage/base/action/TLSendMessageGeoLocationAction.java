/*
 * This is the source code of Telegram Bot v. 2.0
 * It is licensed under GNU GPL v. 3 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Ruben Bermudez, 12/11/14.
 */
package org.javagram.api.sendmessage.base.action;

/**
 * The type TL send message geo location action.
 * @author Ruben Bermudez
 * @version 2.0
 * TLSendMessageGeoLocationAction
 * @since 12/NOV/2014
 */
public class TLSendMessageGeoLocationAction extends TLAbsSendMessageAction {

    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x176f8ba1;

    public TLSendMessageGeoLocationAction() {
        super();
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "sendMessageGeoLocationAction#176f8ba1";
    }

}
