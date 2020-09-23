import org.javagram.MyTLAppConfiguration;
import org.javagram.TelegramClient;
import org.javagram.api.chat.base.TLAbsChat;
import org.javagram.api.message.base.TLAbsMessage;
import org.javagram.api.update.base.*;
import org.javagram.api.update.base.encrypted.TLUpdateEncryptedChatTyping;
import org.javagram.api.update.base.encrypted.TLUpdateEncryptedMessagesRead;
import org.javagram.api.update.base.encrypted.TLUpdateEncryption;
import org.javagram.api.update.base.encrypted.TLUpdateNewEncryptedMessage;
import org.javagram.api.updates.base.TLUpdateShort;
import org.javagram.api.updates.base.TLUpdateShortChatMessage;
import org.javagram.api.updates.base.TLUpdateShortMessage;
import org.javagram.api.updates.base.TLUpdateShortSentMessage;
import org.javagram.api.user.base.TLAbsUser;
import org.javagram.client.handlers.AbstractChatsHandler;
import org.javagram.client.handlers.AbstractMessagesHandler;
import org.javagram.client.handlers.AbstractUpdatesHandler;
import org.javagram.client.handlers.AbstractUsersHandler;
import org.javagram.client.kernel.AbstractDatabaseManager;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClient {

    public static void main(String[] args) {
        MyTLAppConfiguration.Builder builder = new MyTLAppConfiguration.Builder();
        builder.setApiId(1303658)
            .setApiHash("2293e64ddb1f557a7c50d8deb0931d11")
                .setPhoneNumber("+447795804837")
                .setAuthFilename("/Users/jp242/Desktop/447795804837.telegram_auth")
                .setDatabaseManager(new AbstractDatabaseManager() {
                    @Override
                    public boolean addUser(TLAbsUser user) {
                        return false;
                    }

                    @Override
                    public boolean updateUser(TLAbsUser user) {
                        return false;
                    }

                    @Override
                    public boolean deleteUser(TLAbsUser user) {
                        return false;
                    }

                    @Override
                    public boolean addChat(TLAbsChat chat) {
                        return false;
                    }

                    @Override
                    public boolean updateChat(TLAbsChat chat) {
                        return false;
                    }

                    @Override
                    public Map<Integer, int[]> getDifferencesData() {
                        return new HashMap<>();
                    }

                    @Override
                    public boolean updateDifferencesData(int botId, int pts, int date, int seq) {
                        return false;
                    }

                    @Override
                    public void free() throws Throwable {

                    }
                })
                .setUsersHandler(new AbstractUsersHandler() {
                    @Override
                    protected void onUsersCustom(List<TLAbsUser> users) {

                    }

                    @Override
                    protected void onUserCustom(TLAbsUser user) {

                    }
                })
                .setChatsHandler(new AbstractChatsHandler() {
                    @Override
                    protected void onChatsCustom(List<TLAbsChat> chats) {

                    }

                    @Override
                    protected void onChatCustom(TLAbsChat chat) {

                    }
                })
                .setMessagesHandler(new AbstractMessagesHandler() {
                    @Override
                    protected void onTLAbsMessagesCustom(List<TLAbsMessage> messages) {

                    }

                    @Override
                    protected void onTLAbsMessageCustom(TLAbsMessage message) {

                    }
                })
                .setUpdatesHandler(new AbstractUpdatesHandler() {
                    @Override
                    protected void onTLFakeUpdateCustom(TLFakeUpdate update) {

                    }

                    @Override
                    protected void onTLUpdateBotCallbackQueryCustom(TLUpdateBotCallbackQuery update) {

                    }

                    @Override
                    protected void onTLUpdateBotInlineQueryCustom(TLUpdateBotInlineQuery update) {

                    }

                    @Override
                    protected void onTLUpdateBotInlineSendCustom(TLUpdateBotInlineSend update) {

                    }

                    @Override
                    protected void onTLUpdateBotPrecheckoutQueryCustom(TLUpdateBotPrecheckoutQuery update) {

                    }

                    @Override
                    protected void onTLUpdateBotShippingQueryCustom(TLUpdateBotShippingQuery update) {

                    }

                    @Override
                    protected void onTLUpdateBotWebhookJSONCustom(TLUpdateBotWebhookJSON update) {

                    }

                    @Override
                    protected void onTLUpdateBotWebhookJSONQueryCustom(TLUpdateBotWebhookJSONQuery update) {

                    }

                    @Override
                    protected void onTLUpdateChannelCustom(TLUpdateChannel update) {

                    }

                    @Override
                    protected void onTLUpdateChannelAvailableMessagesCustom(TLUpdateChannelAvailableMessages update) {

                    }

                    @Override
                    protected void onTLUpdateChannelMessageViewsCustom(TLUpdateChannelMessageViews update) {

                    }

                    @Override
                    protected void onTLUpdateChannelNewMessageCustom(TLUpdateChannelNewMessage update) {

                    }

                    @Override
                    protected void onTLUpdateChannelPinnedMessageCustom(TLUpdateChannelPinnedMessage update) {

                    }

                    @Override
                    protected void onTLUpdateChannelReadMessagesContentsCustom(TLUpdateChannelReadMessagesContents update) {

                    }

                    @Override
                    protected void onTLUpdateChannelWebPageCustom(TLUpdateChannelWebPage update) {

                    }

                    @Override
                    protected void onTLUpdateChatDefaultBannedRightsCustom(TLUpdateChatDefaultBannedRights update) {

                    }

                    @Override
                    protected void onTLUpdateChatParticipantAddCustom(TLUpdateChatParticipantAdd update) {

                    }

                    @Override
                    protected void onTLUpdateChatParticipantAdminCustom(TLUpdateChatParticipantAdmin update) {

                    }

                    @Override
                    protected void onTLUpdateChatParticipantDeleteCustom(TLUpdateChatParticipantDelete update) {

                    }

                    @Override
                    protected void onTLUpdateChatParticipantsCustom(TLUpdateChatParticipants update) {

                    }

                    @Override
                    protected void onTLUpdateChatPinnedMessageCustom(TLUpdateChatPinnedMessage update) {

                    }

                    @Override
                    protected void onTLUpdateChatUserTypingCustom(TLUpdateChatUserTyping update) {

                    }

                    @Override
                    protected void onTLUpdateConfigCustom(TLUpdateConfig update) {

                    }

                    @Override
                    protected void onTLUpdateContactsResetCustom(TLUpdateContactsReset update) {

                    }

                    @Override
                    protected void onTLUpdateDcOptionsCustom(TLUpdateDcOptions update) {

                    }

                    @Override
                    protected void onTLUpdateDeleteChannelMessagesCustom(TLUpdateDeleteChannelMessages update) {

                    }

                    @Override
                    protected void onTLUpdateDeleteMessagesCustom(TLUpdateDeleteMessages update) {

                    }

                    @Override
                    protected void onTLUpdateDeleteScheduledMessageCustom(TLUpdateDeleteScheduledMessage update) {

                    }

                    @Override
                    protected void onTLUpdateDialogPinnedCustom(TLUpdateDialogPinned update) {

                    }

                    @Override
                    protected void onTLUpdateDialogUnreadMarkCustom(TLUpdateDialogUnreadMark update) {

                    }

                    @Override
                    protected void onTLUpdateDraftMessageCustom(TLUpdateDraftMessage update) {

                    }

                    @Override
                    protected void onTLUpdateEditChannelMessageCustom(TLUpdateEditChannelMessage update) {

                    }

                    @Override
                    protected void onTLUpdateEditMessageCustom(TLUpdateEditMessage update) {

                    }

                    @Override
                    protected void onTLUpdateFavedStickerCustom(TLUpdateFavedSticker update) {

                    }

                    @Override
                    protected void onTLUpdateFolderPeersCustom(TLUpdateFolderPeers update) {

                    }

                    @Override
                    protected void onTLUpdateGeoLiveViewedCustom(TLUpdateGeoLiveViewed update) {

                    }

                    @Override
                    protected void onTLUpdateInlineBotCallbackQueryCustom(TLUpdateInlineBotCallbackQuery update) {

                    }

                    @Override
                    protected void onTLUpdateLangPackCustom(TLUpdateLangPack update) {

                    }

                    @Override
                    protected void onTLUpdateLangPackTooLongCustom(TLUpdateLangPackTooLong update) {

                    }

                    @Override
                    protected void onTLUpdateLoginTokenCustom(TLUpdateLoginToken update) {

                    }

                    @Override
                    protected void onTLUpdateMessageIdCustom(TLUpdateMessageId update) {

                    }

                    @Override
                    protected void onTLUpdateMessagePollCustom(TLUpdateMessagePoll update) {

                    }

                    @Override
                    protected void onTLUpdateNewMessageCustom(TLUpdateNewMessage update) {

                    }

                    @Override
                    protected void onTLUpdateNewScheduledMessageCustom(TLUpdateNewScheduledMessage update) {

                    }

                    @Override
                    protected void onTLUpdateNewStickerSetCustom(TLUpdateNewStickerSet update) {

                    }

                    @Override
                    protected void onTLUpdateNotifySettingsCustom(TLUpdateNotifySettings update) {

                    }

                    @Override
                    protected void onTLUpdatePeerLocatedCustom(TLUpdatePeerLocated update) {

                    }

                    @Override
                    protected void onTLUpdatePeerSettingsCustom(TLUpdatePeerSettings update) {

                    }

                    @Override
                    protected void onTLUpdatePhoneCallCustom(TLUpdatePhoneCall update) {

                    }

                    @Override
                    protected void onTLUpdatePinnedDialogsCustom(TLUpdatePinnedDialogs update) {

                    }

                    @Override
                    protected void onTLUpdatePrivacyCustom(TLUpdatePrivacy update) {

                    }

                    @Override
                    protected void onTLUpdatePtsChangedCustom(TLUpdatePtsChanged update) {

                    }

                    @Override
                    protected void onTLUpdateReadChannelInboxCustom(TLUpdateReadChannelInbox update) {

                    }

                    @Override
                    protected void onTLUpdateReadChannelOutboxCustom(TLUpdateReadChannelOutbox update) {

                    }

                    @Override
                    protected void onTLUpdateReadFeaturedStickersCustom(TLUpdateReadFeaturedStickers update) {

                    }

                    @Override
                    protected void onTLUpdateReadHistoryInboxCustom(TLUpdateReadHistoryInbox update) {

                    }

                    @Override
                    protected void onTLUpdateReadMessagesContentsCustom(TLUpdateReadMessagesContents update) {

                    }

                    @Override
                    protected void onTLUpdateReadMessagesInboxCustom(TLUpdateReadMessagesInbox update) {

                    }

                    @Override
                    protected void onTLUpdateReadMessagesOutboxCustom(TLUpdateReadMessagesOutbox update) {

                    }

                    @Override
                    protected void onTLUpdateRecentStickersCustom(TLUpdateRecentStickers update) {

                    }

                    @Override
                    protected void onTLUpdateSavedGifsCustom(TLUpdateSavedGifs update) {

                    }

                    @Override
                    protected void onTLUpdateServiceNotificationCustom(TLUpdateServiceNotification update) {

                    }

                    @Override
                    protected void onTLUpdateStickerSetsCustom(TLUpdateStickerSets update) {

                    }

                    @Override
                    protected void onTLUpdateStickerSetsOrderCustom(TLUpdateStickerSetsOrder update) {

                    }

                    @Override
                    protected void onTLUpdateThemeCustom(TLUpdateTheme update) {

                    }

                    @Override
                    protected void onTLUpdateUserBlockedCustom(TLUpdateUserBlocked update) {

                    }

                    @Override
                    protected void onTLUpdateUserNameCustom(TLUpdateUserName update) {

                    }

                    @Override
                    protected void onTLUpdateUserPhoneCustom(TLUpdateUserPhone update) {

                    }

                    @Override
                    protected void onTLUpdateUserPhotoCustom(TLUpdateUserPhoto update) {

                    }

                    @Override
                    protected void onTLUpdateUserPinnedMessageCustom(TLUpdateUserPinnedMessage update) {

                    }

                    @Override
                    protected void onTLUpdateUserStatusCustom(TLUpdateUserStatus update) {

                    }

                    @Override
                    protected void onTLUpdateUserTypingCustom(TLUpdateUserTyping update) {

                    }

                    @Override
                    protected void onTLUpdateWebPageCustom(TLUpdateWebPage update) {

                    }

                    @Override
                    protected void onTLUpdateEncryptedChatTypingCustom(TLUpdateEncryptedChatTyping update) {

                    }

                    @Override
                    protected void onTLUpdateEncryptedMessagesReadCustom(TLUpdateEncryptedMessagesRead update) {

                    }

                    @Override
                    protected void onTLUpdateEncryptionCustom(TLUpdateEncryption update) {

                    }

                    @Override
                    protected void onTLUpdateNewEncryptedMessageCustom(TLUpdateNewEncryptedMessage update) {

                    }

                    @Override
                    protected void onTLUpdateShortCustom(TLUpdateShort update) {

                    }

                    @Override
                    protected void onTLUpdateShortMessageCustom(TLUpdateShortMessage update) {

                    }

                    @Override
                    protected void onTLUpdateShortChatMessageCustom(TLUpdateShortChatMessage update) {

                    }

                    @Override
                    protected void onTLUpdateShortSentMessageCustom(TLUpdateShortSentMessage update) {

                    }
                });

        TelegramClient client = new TelegramClient(builder);
        ExecutorService service = Executors.newSingleThreadExecutor();
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        client.init(false);
                        client.start();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });

        try {
            Thread.sleep(10000);
//            client.stop();
//            client.getConfig().getKernelAuthenticator().stop();
            client.getConfig().getApi().close();
            client.getConfig().getExecutor().shutdownNow();
            client.getConfig().getKernelAuthenticator().stop();
            service.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
