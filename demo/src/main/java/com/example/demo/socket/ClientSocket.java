package com.example.demo.socket;

import io.netty.channel.local.LocalAddress;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @ClassName : ClientSocket  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-11-03 17:28  //时间
 */
public class ClientSocket {

    public static int prot;
    public static String ip;

    public static Socket socket;


    public static void main(String[] args) throws IOException {
        socket = new Socket("127.0.0.1",800);
            try {

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());


                String msg = dis.readUTF();
                System.out.println("client " + msg);

                dos.writeUTF("client msg");
                dos.flush();


            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
