package tictactoe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.F;

//Runnable interface should be implemented by any class whose instances are intended to be executed by a thread. The class must define a method of no arguments called run.
public class TicTacToe implements Runnable {

    private String ip = "localhost";
    private int port = 22222;
    private Scanner scanner = new Scanner(System.in);
    private JFrame frame;
    private final int WIDTH = 506;
    private final int HEIGHT = 527;
    private Thread thread;

    private Painter painter;
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private ServerSocket serverSocket;

    private BufferedImage board;
    private BufferedImage redX;
    private BufferedImage blueX;
    private BufferedImage redCircle;
    private BufferedImage blueCircle;

    private String[] spaces = new String[9];

    private boolean yourTurn = false;
    private boolean circle = true;
    private boolean accepted = false;
    private boolean uanbleToCommunicateWithOpponent = false;
    private boolean won = false;
    private boolean enemyWon = false;

    private int lengthOfSpace = 160;
    private int errors = 0;
    private int firstSpot = -1;
    private int secondSpot = -2;

    private Font font = new Font("Verdana", Font.BOLD, 32);
    private Font smallFont = new Font("Verdana", Font.BOLD, 20);
    private Font bigFont = new Font("Verdana", Font.BOLD, 50);

    private String waitingString = "Waiting for player";
    private String unableToCommunicateWithComponentString = "Unable to communicate with component";
    private String wonString = "You won!";
    private String enemyWonString = "You lose.";


    public TicTacToe() {
        System.out.println("Please input IP: ");
        ip = scanner.nextLine();
        System.out.println("Please input the port: ");
        port = scanner.nextInt();
        while (port < 1 || port > 65535) {
            System.out.println("Port you entered is invalid, please input another port");
            port = scanner.nextInt();
        }
        loadImages();
    }

    public void run() {

    }

    private void loadImages() {
        try {
            board = ImageIO.read(getClass().getResourceAsStream("/res/board.png"));
            redX = ImageIO.read(getClass().getResourceAsStream("/res/redX.png"));
            redCircle = ImageIO.read(getClass().getResourceAsStream("/res/redCircle.png"));
            blueX = ImageIO.read(getClass().getResourceAsStream("/res/blueX.png"));
            blueCircle = ImageIO.read(getClass().getResourceAsStream("/res/blueCircle.png"));
        } catch (IOException e) {

        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();

    }

    public class Painter {

    }
}
