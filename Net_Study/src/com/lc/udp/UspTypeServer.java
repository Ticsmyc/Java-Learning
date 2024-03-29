package com.lc.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 基本类型接收端
 * 1. 使用DatagramSocket 指定端口 创建接收端
 * 2. 准备容器，封装成DatagramPacket
 * 3. 阻塞式接收包裹 receive(DatagramPacket p)
 * 4. 分析数据，将字节数组还原为对应的类型即可
 * byte[] getData()
 * 		  getLength()
 * 5.释放资源
 * @author Trail
 */
public class UspTypeServer {
	public static void main(String[] args) throws IOException {
		System.out.println("接收方启动中");
		
		 //* 1. 使用DatagramSocket 指定端口 创建接收端
		DatagramSocket server = new DatagramSocket(9999);
		// * 2. 准备容器，封装成DatagramPacket
		byte[] container = new byte[1024*60]; //60k
		DatagramPacket packet = new DatagramPacket(container, 0 ,container.length);
		// * 3. 阻塞式接收包裹 receive(DatagramPacket p)
		server.receive(packet);
		// * 4. 分析数据
		byte[] datas = packet.getData();
		int len = packet.getLength();
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		
		String msg = dis.readUTF();
		int age= dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		System.out.println(len + "  "+msg +"  "+ age +"  "+ flag +"  " + ch);
		 //* 5.释放资源
		server.close();
	}
}
