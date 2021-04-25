import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This method launch the frame and manage the connection to the server.
 * 
 * @author Nur Afiqah Raman
 *
 */

public class ClientTransactionApplication {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		// Launch client-side frame
		ClientTransactionFrame clientTransactionFrame = new ClientTransactionFrame();
		clientTransactionFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 1123
		Socket socket = new Socket(InetAddress.getLocalHost(), 1123);
		
		// Update the status of the connection
		clientTransactionFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display 
		String orderID = bufferedReader.readLine();
		clientTransactionFrame.updateServer(orderID);
		
		String orderName = bufferedReader.readLine();
		clientTransactionFrame.updateServer(orderName);
		
		String mPayment= bufferedReader.readLine();
		clientTransactionFrame.updateServer(mPayment);
		
		String cNumber = bufferedReader.readLine();
		clientTransactionFrame.updateServer(cNumber);
		
		String aTrans = bufferedReader.readLine();
		clientTransactionFrame.updateServer(aTrans);
		
		String tRefNo = bufferedReader.readLine();
		clientTransactionFrame.updateServer(tRefNo);
		
		String oRefNo = bufferedReader.readLine();
		clientTransactionFrame.updateServer(oRefNo);
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}
