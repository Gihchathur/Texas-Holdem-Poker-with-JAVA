public class Player {
    private Card[] holeCards = new Card[2];
    public int folding; 
    public int handresult; 
    //constructor
    public Player(){
        folding=0;
        handresult=0;
    }

    public Player(Card card1, Card card2){
        holeCards[0] = card1;
        holeCards[1] = card2;

        
    }

    //methods
    protected void setCard(Card card, int cardNum){
        holeCards[cardNum] = card;
    }

    protected Card getCard(int cardNum){
        return holeCards[cardNum];
    }

    protected int holeCardsSize(){
        return holeCards.length;
    }

    protected void printPlayerCards(int playerNumber){
        if(playerNumber!=0)
        System.out.println("Player " + (playerNumber+1) + " hole cards:");
        else
         System.out.println("User cards:");
        for (int i=0;i<2;i++){
            System.out.println(holeCards[i].printCard());
        }
        System.out.println("\n");
    }
}