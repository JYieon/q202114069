package q202114069;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Exam5Client {

	public static void main(String[] args) {
		final String HOST = "localhost";
		final int PORT = 7071;
		try(DatagramSocket socket = new DatagramSocket(0)) {
			//send
			InetAddress  hostAddress = InetAddress.getByName(HOST);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bout);
			out.writeObject(new Student("202114069", ""));
			byte[] data1 = bout.toByteArray();
			DatagramPacket packet1 = new DatagramPacket(data1, data1.length, hostAddress, PORT);
			socket.send(packet1);

			//receive
			byte[] data2 = new byte[512];
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
			socket.receive(packet2);
			ObjectInputStream in = new ObjectInputStream(
					new ByteArrayInputStream(packet2.getData(), 0, packet2.getLength()));
			Student s2 = (Student)in.readObject();
			System.out.printf("%s %s\n", s2.getStudentNo(), s2.getName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
