package q202114069;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam2Server {

	public static void main(String[] args) {
		final int PORT = 7071;
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			while (true) {
				try (Socket socket = serverSocket.accept()) {
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
					out.writeObject(new Student("202114069", "최지연"));
					out.flush();
				} catch (Exception ex) {

				}
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

}
