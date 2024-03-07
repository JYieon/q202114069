package q202114069;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam1Server {

	public static void main(String[] args) {
		final int PORT = 7071;
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			while (true) {
				try (Socket socket = serverSocket.accept()) {
					ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
					Student s = (Student)in.readObject();
					System.out.printf("%s %s\n", s.getStudentNo(), s.getName());
				} catch (Exception ex) {

				}
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

}
