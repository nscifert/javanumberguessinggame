/**
   Program #6
   
 Develop a Java application that plays a "UnknownNum the number" game as described below.
 1. The user interface is displayed and the user clicks the “Start Game” button to begin the game.

 2. Your application then gets a random UnknownNum in the range 1-1000 inclusive (you might want to use Math.random or the Random class).

 3. The application then displays the following prompt (probably via a JLabel):

   Programmed By: Nicholas Scifert, (03/01/2020)   **/
   
   
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.util.Random;

public class NumberGuessingGame     //beginging of NumberGuessingGame class
{
    public static void main(String args[]) throws Exception
    {
        GuessingGame game = new GuessingGame();                   //object creation 
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // closes Java Frame
        game.setSize(750, 100);                               //  Creates the size of frame
        game.setVisible(true);                                   // Makes visiable to users
    }
}  // ending of NumberGuessingGame class


class GuessingGame extends JFrame // begining of class GuessingGame
{
   
    private int PostGuess;
    private int UnknownNum;
    private JTextField UnknownNumInPField;
    private JLabel prompt1JLabel;
    private JLabel prompt2JLabel;
    private JLabel statement1;
    private JLabel statement2;
    private JLabel rand = new JLabel("");
    private JButton startGameButton;
    private Color background;
    private int Guesses = 1;

   
    public GuessingGame() 
    {
        super("The Number Guessings Game");
//**        GUI Setup      **//
        setLayout(new FlowLayout());
        background = Color.LIGHT_GRAY;
        setLayout(new FlowLayout());
        prompt1JLabel = new JLabel("I have a number between 1 and 1000 can you guess my number?");
        prompt2JLabel = new JLabel("Please enter your guess and then hit Enter.");
        UnknownNumInPField = new JTextField(4);
        statement1 = new JLabel("");
        statement2 = new JLabel("");
        startGameButton = new JButton("Start New Game");
        add(prompt1JLabel);
        add(prompt2JLabel);
        add(startGameButton);
        add(UnknownNumInPField);
        UnknownNumInPField.addActionListener(new GameCal());
        add(statement1);
        add(statement2);

        Random ran = new Random();  //creates a random number
        UnknownNum = ran.nextInt(101);
        
                       
        letsPlayAGame();
    }
   
    public void letsPlayAGame() 
    {

    }

    class GameCal implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {

            int guess;

            guess = Integer.parseInt(UnknownNumInPField.getText());
          
           
       
            
            PostGuess = guess;
           
            if (PostGuess > UnknownNum) {                               //test if the number is too high and if so changes the box red
                statement1.setText(guess + " is Too High....");
                SwingUtilities.updateComponentTreeUI(statement1);
                getContentPane().setBackground(Color.RED);

            }
            
            if (PostGuess < UnknownNum) 
            {

                statement1.setText(guess +" is Too Low....");           //test if the number is too low and if so changes the box blue
                SwingUtilities.updateComponentTreeUI(statement1);
                getContentPane().setBackground(Color.BLUE);

            }           
           
            if (PostGuess == UnknownNum)                                //test if the number is correct and if so changes the box pink
            {
                statement1.setText(guess + " is Correct!");
                SwingUtilities.updateComponentTreeUI(statement1);
                UnknownNumInPField.setEditable(false);
                getContentPane().setBackground(Color.PINK); //makes background pink

            }
            
        startGameButton.addActionListener(
        
        new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) 
                    {

                        UnknownNumInPField.setText("");
                       
                        Random ran = new Random();
                        UnknownNum = ran.nextInt(1001);
                        rand.setText("" + UnknownNum);
                        SwingUtilities.updateComponentTreeUI(rand);
                        statement1.setText("");
                        UnknownNumInPField.setEditable(true);
                        Guesses = 0;
                        statement2.setText("Number of Guesses: " + Guesses);
                        Guesses++;
                        getContentPane().setBackground(Color.LIGHT_GRAY);
                        
                    }
                }
                );
         
         statement2.setText("Number of Guesses: " + Guesses++);
           
        }

    }
}     // ending of GuessingGame class


