import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;  // Import the Scanner class
import java.util.Random; 

public class TexasHoldEm {

    public static void main(String[] args) throws Exception {
        // variables
        Deck holdemDeck = new Deck();
        int check=0;
        int numPlayers = 0;
        int cardCounter = 0;
        int burnCounter = 0;
        int boardCounter = 0;
        int player1Won=0;
        int player2Won=0;
        int player3Won=0;
        int count=0;
        Board board = new Board();

        // initializations      
        numPlayers = 3;
        Player[] player = new Player[numPlayers];

        /* 3 shuffles just like in real life. */
        for(int i=0;i<3;i++){
            holdemDeck.shuffle();
        }

        // Cut Deck
        holdemDeck.cutDeck();

        // Initialize players
        for (int i=0;i<numPlayers;i++){
            player[i] = new Player();
        }

        // Main processing
        // Deal hole cards to players
        for (int i=0;i<2;i++){
            for (int j=0;j<numPlayers;j++){
                player[j].setCard(holdemDeck.getCard(cardCounter++), i);
            }
        }

        // Start dealing board

        // Burn one card before flop
        board.setBurnCard(holdemDeck.getCard(cardCounter++), burnCounter++);

        // deal flop
        for (int i=0; i<3;i++){
            board.setBoardCard(holdemDeck.getCard(cardCounter++), boardCounter++);
        }

        // Burn one card before turn
        board.setBurnCard(holdemDeck.getCard(cardCounter++), burnCounter++);

        // deal turn
        board.setBoardCard(holdemDeck.getCard(cardCounter++), boardCounter++);

        // Burn one card before river
        board.setBurnCard(holdemDeck.getCard(cardCounter++), burnCounter++);

        // deal river
        board.setBoardCard(holdemDeck.getCard(cardCounter++), boardCounter++);

        //------------------------
        // end dealing board
        //------------------------

        System.out.println("The hand is complete...\n");

        // print deck
        //holdemDeck.printDeck();
//////////////////////////////////////////////////////////////////


  for(int rounds=0;rounds<10;rounds++)
  {
      cardCounter = 0;
     burnCounter = 0;
     boardCounter = 0; 
      
      System.out.println(" \n\n----------------------------------------------------\nRound "+ (rounds+1));
     
       for(int i=0;i<3;i++){
            holdemDeck.shuffle();
        }

        // Cut Deck
        holdemDeck.cutDeck();
         holdemDeck.printDeck();
           for (int i=0;i<2;i++){
            for (int j=0;j<numPlayers;j++){
                player[j].setCard(holdemDeck.getCard(cardCounter++), i);
            }
        }
      
        for (int i=0;i<1;i++){
            player[i].printPlayerCards(i);
        }
         // Burn one card before flop
        board.setBurnCard(holdemDeck.getCard(cardCounter++), burnCounter++);

        // deal flop
        for (int i=0; i<3;i++){
            board.setBoardCard(holdemDeck.getCard(cardCounter++), boardCounter++);
        }

        // Burn one card before turn
        board.setBurnCard(holdemDeck.getCard(cardCounter++), burnCounter++);

        // deal turn
        board.setBoardCard(holdemDeck.getCard(cardCounter++), boardCounter++);

        // Burn one card before river
        board.setBurnCard(holdemDeck.getCard(cardCounter++), burnCounter++);

        // deal river
        board.setBoardCard(holdemDeck.getCard(cardCounter++), boardCounter++);


       
      
        
      
for(int p=0;p<3;p++)
{
    //print board
        board.printBoard(p+3);
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Choose\n\t1.FOLD\n\t2.CALL\n\t3.RAISE  : ");
        
        int choice = myObj.nextInt();
        while(choice!=1&&choice!=2&&choice!=3)
        {
            System.out.println("\n\n!!! WRONG CHOICE : \n");
            System.out.println("Choose Agian\n\t1.FOLD\n\t2.CALL\n\t3.RAISE  : ");
        
            choice = myObj.nextInt();
            
        }
         for (int i=1;i<3;i++){
             Random rand = new Random(); 
            int num = rand.nextInt(10); 
            if(player[i].folding!=1)
            {
                if(num<1)
            {
                player[i].folding=1;
            }
            if(num<6 && num>=1)
            {
                player[i].folding=2;
            }
            }
            
        }
        
        
         /*for (int i=0;i<3;i++)
         {
             if( player[i].folding==1)
                count++;
         }
         if(count==2)
         {
             check=1;
         }
         if(count==3)
         {
             check=2;
         }
        */
         if(player[0].folding==1 && player[1].folding==1 && player[2].folding==1)
         {
            player3Won++;
            count = 2;
            player[2].folding=2;
             System.out.println("\n\n\t!!! PLAYER 3 WON !!!  \n\n");
         }
         else if(player[1].folding==1 && player[0].folding==1)
         {
           player3Won++;
            count = 2;
             System.out.println("\n\n\t!!! PLAYER 3 WON !!!  \n\n");
         }
          else if(player[2].folding==1 && player[1].folding==1)
         {
           player1Won++;
            count = 2;
             System.out.println("\n\n\t!!! USER WON !!!  \n\n");
         }
          else if(player[2].folding==1 && player[0].folding==1)
         {
           player2Won++;
            count = 2;
            System.out.println("\n\n\t!!! PLAYER 2 WON !!!  \n\n");
         }
         if(count!=2)
         {
        if(choice==1)
        {
             System.out.println("\n\n\t!!! USER HAS FOLDED HIS HAND !!!  \n\n");
             p=2;
             player[0].folding=1;
        }
        else if(choice==3)
        {
             System.out.println("\n\n\t!!! USER HAS RAISED !!!  \n\n");
 
        }
        else
            {
             System.out.println("\n\n\t!!! USER HAS CALLED !!!  \n\n");
 
        }
            



        
        for (int i=1;i<3;i++){
            
            if(player[i].folding==1)
            {
                System.out.println("Player "+(i+1)+" Has Folded his hand"  );
            }
            else if(player[i].folding==2)
            {
                System.out.println("Player "+(i+1)+" Has Called"  );
            }
            else
            {
                System.out.println("Player "+(i+1)+" Has Raised"  );
            }
        }
       
         }
         else
         {
         p++;
         }
}
        // print player cards
        if(count!=2)
        {
        System.out.println("The player cards are the following:\n");
        for (int i=0;i<numPlayers;i++){
            player[i].printPlayerCards(i);
        }

        // print burn cards
        board.printBurnCards();

        //------------------------
        // Begin hand comparison
        //------------------------
        
        for (int i=0;i<numPlayers;i++){
            HandEval handToEval = new HandEval();

            // populate with player cards           
            for (int j=0;j<player[i].holeCardsSize();j++){
                handToEval.addCard(player[i].getCard(j),j);
            }

            //populate with board cards
            for (int j=player[i].holeCardsSize();j<(player[i].holeCardsSize()+board.boardSize());j++){
                handToEval.addCard(board.getBoardCard(j-player[i].holeCardsSize()),j);
            }

            System.out.println("Player " + (i+1) + " hand value: " + handToEval.evaluateHand()); 
            player[i].handresult=handToEval.evaluateHandvalue();
            
        }
        
        int id=0,temp=0;
        for (int a=0;a<numPlayers;a++){
            if(player[a].folding!=1)
            {
            if(temp<player[a].handresult)
            { temp=player[a].handresult;
              id=a;
            }
            }
        }
        
         System.out.println("Player " +(id+1)+" won");
         if(id==0)
          {
              player1Won++;
         }
         else if(id==1)
         {
             player2Won++;
         }
          else
         {
             player3Won++;
         }
        
       
    }
    
    else
    {
        count=0;
    }

    }
   System.out.println("\n\nFinal Result after 10 rounds ");
   if(player1Won>=player2Won && player1Won>=player3Won )
   {
       System.out.println("USER won");
   }
    if(player1Won<=player2Won && player3Won<=player2Won )
   {
       System.out.println("player 2 won");
   }
     if(player3Won>=player1Won && player3Won>=player2Won )
   {
       System.out.println("PLAYER 3 won");
   }
     
     cardCounter = 0;
     burnCounter = 0;
     boardCounter = 0;
    }
   
}