package protocol.chapter_02;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestServer {
	public static void serverSocket() throws IOException{
		ServerSocket server=new ServerSocket(80);
		server.accept();
		
	}
	public static void cilentSocket() throws UnknownHostException, IOException{
		Socket socket=new Socket("localhost",80);
		DataInputStream input=new DataInputStream(socket.getInputStream());
		float f=input.readFloat();
		System.out.println("f:"+f);
		input.close();
		socket.close();
	}
	public static void main(String[] args) {
		try {
			serverSocket();
			cilentSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
