package com.youmeek.ssm.module.rpc;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fanbo on 2017/4/14.
 */

@Service
public class ThriftClient {
    @Autowired
    private ConnectionManager connectionManager;

    public void open(TFramedTransport transport) {
        if (transport != null && !transport.isOpen()) {
            try {
                transport.open();
            } catch (TTransportException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(TFramedTransport transport) {
        if (transport != null && transport.isOpen()) {
            transport.close();
        }
    }

    public void invoke() {
        TFramedTransport transport = new TFramedTransport(connectionManager.getSocket());
        TProtocol protocol = new TCompactProtocol(transport);
        IDataCheckThriftService.Client client = new IDataCheckThriftService.Client(protocol);

        String jsonStr = "{\"query\":{\"bool\":{\"must\":[{\"match_all\":{}}],\"must_not\":[],\"should\":[]}},\"from\":0,\"size\":10,\"sort\":[],\"aggs\":{}}";
        try {
            Result result = client.dataCheck(Action.QUERY, 10, jsonStr);
            if (null != result) {
                System.out.println("Thrift client result1 =: " + result.toString());
            }
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
}
