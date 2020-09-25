package org.javagram.client.handlers;

import org.javagram.client.handlers.interfaces.IUpdatesHandler;
import java.util.PriorityQueue;
import org.javagram.client.structure.UpdateWrapper;
import org.javagram.client.structure.UpdateWrapperComparator;
import org.javagram.utils.BotLogger;

public class UpdateHandlerThread extends Thread {

    private static final String LOGTAG = "[UpdateHandlerThread]";
    private final IUpdatesHandler updatesHandler;
    private boolean isAlive = true;
    private final PriorityQueue<UpdateWrapper> updates = new PriorityQueue<>(new UpdateWrapperComparator());

    protected UpdateHandlerThread(IUpdatesHandler updatesHandler) {
        super("UpdateHandlerThread");
        this.setPriority(9);
        this.updatesHandler = updatesHandler;
    }

    void addUpdate(UpdateWrapper newUpdate) {
        synchronized(this.updates) {
            this.updates.offer(newUpdate);
            this.updates.notifyAll();
        }
    }

    @Override
    public void interrupt() {
        this.isAlive = false;
        super.interrupt();
    }

    @Override
    public void run() {
        UpdateWrapper update;
        while (this.isAlive) {
            try {
                synchronized(this.updates) {
                    update = this.updates.poll();
                }
                if (update == null) {
                    synchronized(this.updates) {
                        try {
                            this.updates.wait();
                        } catch (InterruptedException e) {
                            BotLogger.warning(LOGTAG,"Shutting down: Updates handler interrupted");
                            return;
                        }
                    }
                } else {
                    this.updatesHandler.processUpdate(update);
                }
            } catch (Exception e) {
                BotLogger.error(LOGTAG, e);
            }
        }
        BotLogger.info(LOGTAG, "Quitting UpdateHandlerThread.");
    }

}