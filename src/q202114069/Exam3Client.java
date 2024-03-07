package q202114069;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Exam3Client {
	public static void main(String[] args) {
		final String HOST = "localhost";
		final int PORT = 7071;
		try (Socket socket = new Socket(HOST, PORT)) {
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(new Student("202114069", "최지연"));
			out.flush();
			} catch (Exception e) {  }
	}
}
