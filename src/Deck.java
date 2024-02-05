import java.util.Random;

public class Deck extends CardList {
    private int index = 0;

    public Deck() {
        super();
        initializeDeck();
        removeRandomCard();
        shuffleDeck();
    }

    private void initializeDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Face face : Card.Face.values()) {
                super.addCard(new Card(face, suit));
                index++;
            }
        }
    }

    private void removeRandomCard() {
        System.out.println("The card removed: " + super.randomDeal());
    }

    private void shuffleDeck() {
        Random random = new Random();
        for (int j = 0; j < super.getSize(); j++) {
            swap(j, random.nextInt(super.getSize()));
        }
        System.out.println("Shuffling!");
    }
}
