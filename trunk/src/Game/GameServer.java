/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author michal
 */
public class GameServer {

    ArrayList<Socket> clients;

    public GameServer() {
    }

    /**
     * Try and find a port that is not in use within the specified range of ports.
     * @param rangeStart
     * @param rangeEnd
     * @return
     */
    public int findUsablePort(int rangeStart, int rangeEnd) {
        if (!validRange(rangeStart, rangeEnd)) {
            rangeStart = 2000;
            rangeEnd = 3000;
            System.err.printf("Invalid range entered. using the range %d to %d instead.\n", rangeStart, rangeEnd);
        }
        int usablePort = Integer.MIN_VALUE;
        ServerSocket testSock = null;
        for (int i = rangeStart; i <= rangeEnd; i++) {
            try {
                testSock = new ServerSocket(i);
                usablePort = i;
                System.out.printf("Port %d is available.\n", usablePort);
                break;
            } catch (IOException ex) {
                System.out.printf("Port %d in use.\n", i);
            } finally {
                try {
                    testSock.close();
                } catch (IOException ex) {
                    System.err.printf("Unable to close the test socket at port %d\n", i);
                } catch (Exception ex) {
                    System.err.println("Some other error ocurred while trying to close the test socket. "
                            + "The connection was probably null. This shouldn't be a problem.");
                }
            }
        }
        return usablePort;
    }

    /**
     * Checks whether a port range specified is valid.
     * @param rangeStart
     * @param rangeEnd
     * @return
     */
    private boolean validRange(int rangeStart, int rangeEnd) {
        int diff = rangeEnd - rangeStart;
        if (diff > 0 && rangeEnd > rangeStart && rangeStart > 0 && rangeEnd <= 65535) {
            return true;
        }
        return false;
    }
}
