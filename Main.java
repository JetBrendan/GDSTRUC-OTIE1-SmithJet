import java.util.Random; //random Generator
import java.util.Scanner; //read user inputs

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Creatong the 3 stacks
        CardStack playerDeck = new CardStack(30);
        CardStack playerHand = new CardStack(30);
        CardStack discardedPile = new CardStack(30);

        for (int i = 1; i <= 30; i++) {
            playerDeck.push(new Card("Card " + i));
        }


        System.out.println("Card Game");
        System.out.println("The game will end once the player's cards run out");

        while (!playerDeck.isEmpty()) {

            //Random command
            int command = random.nextInt(3) + 1;
            int amount = random.nextInt(5) + 1;//Random generator

            //Drawing
            if (command == 1) {
                System.out.println("\nCommand: Draw " + amount + " cards");

                for (int i = 0; i < amount; i++) {
                    if (!playerDeck.isEmpty()) {
                        Card card = playerDeck.pop();
                        playerHand.push(card);
                        System.out.println("Drew: " + card);
                    }
                }

            } else if (command == 2) {
                System.out.println("\nDiscard " + amount + " cards");// Discard cards

                for (int i = 0; i < amount; i++) {
                    if (!playerHand.isEmpty()) {
                        Card card = playerHand.pop();
                        discardedPile.push(card);
                        System.out.println("Discarded: " + card);
                    }
                }

            } else {
                // For getting cards from discarded
                System.out.println("\nCommand: Get " + amount
                        + " cards from the discarded pile");

                for (int i = 0; i < amount; i++) {
                    if (!discardedPile.isEmpty()) {
                        Card card = discardedPile.pop();
                        playerHand.push(card);
                        System.out.println("Got: " + card);
                    }
                }
            }

            //current player status
            System.out.println("\nYour cards");

            System.out.println("Player Hand:");
            if (playerHand.isEmpty()) {
                System.out.println("Empty");
            } else {
                playerHand.printStack();
            }

            System.out.println("\nRemaining cards in player deck: "
                    + playerDeck.size());

            System.out.println("Cards in discarded pile: "
                    + discardedPile.size());


            if (playerDeck.isEmpty()) {  //Stops once card deck is empty
                break;
            }

            System.out.println("\nPress Enter to continue the game"); //to continue the game

            scanner.nextLine();
        }

        System.out.println("\n Game over");
        System.out.println("The player deck is empty.");

        scanner.close(); //Closes input scanner
    }


}