package q202114069;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Exam2Client {

	public static void main(String[] args) {
		final String HOST = "localhost";
		final int PORT = 7071;
		try (Socket socket = new Socket(HOST, PORT)) {
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			Student s = (Student)in.readObject();
			System.out.printf("%s %s\n", s.getStudentNo(), s.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
