package com.youmeek.ssm.module.query.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * Created by fanbo on 2017/3/30.
 */
public class Client2 {

    //public static final String SERVER_IP = "localhost";
    public static final String SERVER_IP = "101.201.210.129";
    public static final int SERVER_PORT = 8020;//Thrift server listening port
    public static final int TIMEOUT = 30000;

    /**
     * @param jsonStr
     */
    public void startClient(ConfirmAction action, long taskID, String jsonStr) {
        TFramedTransport transport = new TFramedTransport(new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT));
        // 协议要和服务端一致

        TProtocol protocol = new TCompactProtocol(transport);
        TMultiplexedProtocol mp2 = new TMultiplexedProtocol(protocol, IDataCheckConfirmThriftService.class.getName());
        IDataCheckConfirmThriftService.Client client = new IDataCheckConfirmThriftService.Client(mp2);
        try {
            open(transport);
            ThriftResult result = client.dataCheckConfirm(action, taskID, jsonStr);
            System.out.println("Thrift confirm client result =: " + result.toString());
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

    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     *
     * @param filePath
     */
    public static JSONArray readTxtFile(String filePath) {
        JSONArray array = new JSONArray();
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式

                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = new String();

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    JSONObject jsonObj = JSON.parseObject(lineTxt);
                    array.add(jsonObj);
                    //System.out.println(lineTxt);
                }
                read.close();

            } else {
                System.out.println("找不到指定的文件");
                return null;
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }finally {
            return array;
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Client2 client = new Client2();
        JSONArray jsonArray = readTxtFile("C:\\Thrift\\java\\json.txt");
        System.out.println(jsonArray.toJSONString());

        client.startClient(ConfirmAction.UPDATE, 1, jsonArray.toJSONString());
    }

}
