import java.util.*;

public class OldMaid {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        ArrayList<OldMaidPlayer> cards = new ArrayList<OldMaidPlayer>();
        ArrayList<CardList> players = new ArrayList<CardList>();
        ArrayList<CardList> playersWon = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();

        Deck deck = new Deck();
        OldMaid game = new OldMaid();

        game.getPlayers(scan, players, cards);
        game.showHand(deck, players);

        System.out.println(" ");

        Object firstLock = new Object();

        System.out.println("Removed Pairs: ");


        int[] currentPlayerIndex = {0};

        for (int i = 0; i < players.size(); i++)
        {
            int counter = i;
            Thread thread = new Thread(() -> {
                synchronized (firstLock) {
                    try {
                        // Wait until the player's turn
                        while (counter != currentPlayerIndex[0])
                        {
                            firstLock.wait();
                        }

                        // Player's turn,
                        ((OldMaidHand) players.get(counter)).removePairs();
                        ((OldMaidHand) players.get(counter)).display();

                        // Notify other players that it's their turn
                        currentPlayerIndex[0] = (currentPlayerIndex[0] + 1) % players.size();
                        firstLock.notifyAll();
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                        System.out.println("the synchronize area");
                    }
                }
            });

            thread.start();
            threads.add(thread);
        }

        // Wait for all threads to finish
        for (Thread thread : threads)
        {
            try {
                thread.join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println();

        System.out.println("Remaining on each hand: ");
        threads.clear();

        for (int i = 0; i < players.size(); i++)
        {
            int I = i;
            Thread thread = new Thread(() -> {
                ((OldMaidHand) players.get(I)).display();
                System.out.println();
            });
            thread.start();
            threads.add(thread);
        }

        // Wait for all threads to finish
        for (Thread thread : threads)
        {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Random r = new Random();
        int i = r.nextInt(players.size());
        System.out.println(((OldMaidHand) players.get(i)).getName() +
                " goes first!");
        System.out.println();
        int index = 0;
        Card c;

        while (players.size() != 1)
        {
            if (i >= (players.size())) {
                i = 0;
            }

            if (i == 0) {
                System.out.println(((OldMaidHand) players.get(i)).getName() + " is drawing a card from " +
                        ((OldMaidHand) players.get(players.size() - 1)).getName() + " cards");

                c = ((OldMaidHand) players.get(players.size() - 1)).drawCard();

                if (players.get(players.size() - 1).getSize() == 0) {
                    index++;
                    game.update(players.get(0), cards, index);
                    playersWon.add(players.get(0));
                    players.remove(players.get(0));
                }
                players.get(0).addCard(c);

                ((OldMaidHand) players.get(0)).removePairs();

                if (players.get(0).getSize() != 0) {
                    ((OldMaidHand) players.get(0)).shuffle();
                }

                if (players.get(0).getSize() == 0) {
                    index++;
                    game.update(players.get(0), cards, index);
                    playersWon.add(players.get(0));
                    players.remove(players.get(0));
                } else {
                    i++;
                }
            } else {
                System.out.println(((OldMaidHand) players.get(i)).getName() +
                        " is drawing a card from " + ((OldMaidHand) players.get(i - 1)).getName() + "\'s cards");
                c = ((OldMaidHand) players.get(i - 1)).drawCard();

                if (players.get(i - 1).getSize() == 0) {
                    index++;
                    game.update(players.get(i - 1), cards, index);
                    playersWon.add(players.get(i - 1));
                    players.remove(players.get(i - 1));
                }
                if (i >= players.size())
                {
                    i = players.size() - 1;
                }
                players.get(i).addCard(c);

                System.out.println("Remove pairs from " + ((OldMaidHand) players.get(i)).getName() + "'s hand");
                ((OldMaidHand) players.get(i)).removePairs();

                if (players.get(i).getSize() != 0) {
                    ((OldMaidHand) players.get(i)).shuffle();
                }

                if (players.get(i).getSize() == 0) {
                    index++;
                    game.update(players.get(i), cards, index);
                    playersWon.add(players.get(i));
                    players.remove(players.get(i));
                } else {
                    i++;
                }
            }
        }

        game.update(players.get(0), cards);

        System.out.print("Scores: ");
        for (int x = 0; x < cards.size(); x++) {
            System.out.println(cards.get(x));
        }
    }

    public void getPlayers(Scanner scan, ArrayList<CardList> players, ArrayList<OldMaidPlayer> cards)
    {
        boolean play = true;
        int numberOfPlayers = 0;
        while (play)
        {
            try {
                System.out.println("Enter the number of players form 3 to 5 : ");

                numberOfPlayers = scan.nextInt();
                String i = scan.nextLine();
                int numberPlayer3Min=3;
                int numberPlayer5Max=5;
                if (numberOfPlayers < numberPlayer3Min || numberOfPlayers > numberPlayer5Max) {
                    System.out.print("Error! Enter the number of players between 3 and 5.");
                    continue;
                } else {
                    break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scan.nextLine();  // Consume the invalid input
            }

        }



        String name;
        for (int i = 0; i < numberOfPlayers; i++)
        {
            System.out.println("Enter name of player " + (i + 1) + ":");
            name = scan.nextLine();
            players.add(new OldMaidHand(name));
            cards.add(new OldMaidPlayer(name));
        }
    }

    public void showHand(Deck deck, ArrayList<CardList> players)
    {
        int i = 0;
        while (deck.getSize() != 0) {
            players.get(i).addCard(deck.deal());
            i++;

            if (i == players.size()) {
                i = 0;
            }
        }
        for (int j = 0; j < players.size(); j++) {
            ((OldMaidHand) players.get(j)).display();
        }
    }

    public void update(CardList players, ArrayList<OldMaidPlayer> cards)
    {
        for (int i = 0; i < cards.size(); i++) {
            if (((OldMaidHand) players).getName().equals(cards.get(i).getName())) {
                cards.get(i).loss();
            }
        }
    }

    public void update(CardList players, ArrayList<OldMaidPlayer> cards, int index)
    {
        for (int i = 0; i < cards.size(); i++) {
            if (((OldMaidHand) players).getName().equals(cards.get(i).getName()) && index == 1) {
                cards.get(i).won();
                cards.get(i).setPoints(3);
            } else if (((OldMaidHand) players).getName().equals(cards.get(i).getName()) && index < cards.size()) {
                cards.get(i).setPoints(1);
            }
        }
    }
}
