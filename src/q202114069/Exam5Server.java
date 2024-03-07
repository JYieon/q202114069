package q202114069;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Exam5Server {

	public static void main(String[] args) {
		final int PORT = 7071;
		try(DatagramSocket socket = new DatagramSocket(PORT)) {
			while(true) {
				//receive
				byte[] data1 = new byte[512];
				DatagramPacket packet1 = new DatagramPacket(data1, data1.length);
				socket.receive(packet1);
				ObjectInputStream in = new ObjectInputStream(
						new ByteArrayInputStream(packet1.getData(), 0, packet1.getLength()));
				Student s = (Student)in.readObject();
				s.setName("최지연");
				InetAddress remoteAddr = packet1.getAddress();
				int remotePort = packet1.getPort();

				//send
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(bout);
				out.writeObject(s);
				byte[] data2 = bout.toByteArray();
				DatagramPacket packet2 = new DatagramPacket(data2, data2.length, remoteAddr, remotePort);
				socket.send(packet2);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
