public class Card {

    public enum Face {
        ACE("Ace"), TWO("Two"), THREE("Three"), FOUR("Four"), FIVE("Five"),
        SIX("Six"), SEVEN("Seven"), EIGHT("Eight"), NINE("Nine"), TEN("Ten"),
        JACK("Jack"), QUEEN("Queen"), KING("King");

        private final String name;

        Face(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum Suit {
        CLUBS("Clubs"), HEARTS("Hearts"), DIAMONDS("Diamonds"), SPADES("Spades");

        private final String name;

        Suit(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private Face face;
    private Suit suit;

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return face.getName() +" - "+ suit.getName();
    }
}
