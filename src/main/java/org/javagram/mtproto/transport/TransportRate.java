package org.javagram.mtproto.transport;

import org.javagram.mtproto.log.Logger;
import org.javagram.mtproto.state.ConnectionInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TransportRate {

    private static final String LOGTAG = "[TransportRate]";

    private final Map<Integer, Transport> transports = new HashMap<>();

    public TransportRate(ConnectionInfo[] connectionInfos) {
        int min = Integer.MAX_VALUE;
        for (ConnectionInfo connectionInfo : connectionInfos) {
            min = Math.min(connectionInfo.getPriority(), min);
        }
        for (ConnectionInfo connectionInfo : connectionInfos) {
            synchronized(this.transports) {
                this.transports.put(connectionInfo.getId(), new Transport(new ConnectionType(connectionInfo.getId(), connectionInfo.getAddress(), connectionInfo.getPort(), ConnectionType.TYPE_TCP), connectionInfo.getPriority() - min + 1));
            }
        }
        this.normalize();
    }

    public ConnectionType tryConnection() {
        Transport[] currentTransports;
        ConnectionType type;
        synchronized(this.transports) {
            currentTransports = this.transports.values().toArray(new Transport[0]);
            Arrays.sort(currentTransports, (Transport transport, Transport transport2) -> -Float.compare(transport.getRate(), transport2.getRate()));
            type = currentTransports[0].getConnectionType();
        }
        Logger.d(LOGTAG, "tryConnection #" + type.getId());
        return type;
    }

    public void onConnectionFailure(int transportId) {
        Logger.d(LOGTAG, "onConnectionFailure #" + transportId);
        synchronized(this.transports) {
            this.transports.get(transportId).rate *= 0.5;
        }
        this.normalize();
    }

    public void onConnectionSuccess(int transportId) {
        Logger.d(LOGTAG, "onConnectionSuccess #" + transportId);
        synchronized(this.transports) {
            this.transports.get(transportId).rate *= 1.0;
        }
        this.normalize();
    }

    private synchronized void normalize() {
        float sum = 0;
        synchronized(this.transports) {
            sum = this.transports.keySet().stream().map((id) -> this.transports.get(id).rate).reduce(sum, (accumulator, _item) -> accumulator + _item);
            for (Integer id : this.transports.keySet()) {
                Transport transport = this.transports.get(id);
                transport.rate /= sum;
                Logger.d(LOGTAG, "Transport: #" + transport.connectionType.getId() + " " + transport.connectionType.getHost() + ":" + transport.getConnectionType().getPort() + " #" + transport.getRate());
            }
        }
    }

    private class Transport {
        
        private ConnectionType connectionType;
        private float rate;

        private Transport(ConnectionType connectionType, float rate) {
            this.connectionType = connectionType;
            this.rate = rate;
        }

        public ConnectionType getConnectionType() {
            return this.connectionType;
        }

        public void setConnectionType(ConnectionType connectionType) {
            this.connectionType = connectionType;
        }

        public float getRate() {
            return this.rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }
        
    }

}