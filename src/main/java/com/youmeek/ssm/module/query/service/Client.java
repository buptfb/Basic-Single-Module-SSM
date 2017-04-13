package com.youmeek.ssm.module.query.service;

/**
 * Created by fanbo on 2017/3/13.
 */


import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;


public class Client {

    //public static final String SERVER_IP = "localhost";
    public static final String SERVER_IP = "101.201.210.129";
    public static final int SERVER_PORT = 8020;//Thrift server listening port
    public static final int TIMEOUT = 30000;

    /**
     * @param action
     * @param jsonStr
     */
    public void startClient(Action action, long taskID, String jsonStr) {
        TFramedTransport transport = new TFramedTransport(new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT));
        // 协议要和服务端一致

        TProtocol protocol = new TCompactProtocol(transport);
        TMultiplexedProtocol mp = new TMultiplexedProtocol(protocol, IDataCheckThriftService.class.getName());
        IDataCheckThriftService.Client client = new IDataCheckThriftService.Client(mp);
        try {
            open(transport);
            Result result = client.dataCheck(action, taskID, jsonStr);
            System.out.println("Thrift client result1 =: " + result.toString());
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                close(transport);
            }
        }
    }

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
}