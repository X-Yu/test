package com.example.demo.socket;

import io.netty.channel.local.LocalAddress;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName : ServerSocket  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-11-05 17:40  //时间
 */
public class ServerSocket {
    public static void main(String[] args) throws IOException {
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(800);
        Socket socket = serverSocket.accept();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        dos.writeUTF("server msg");
        dos.flush();


        String msg = dis.readUTF();
        System.out.println("server " + msg);

    }
}
