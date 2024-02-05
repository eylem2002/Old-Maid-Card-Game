import java.util.*;


public class OldMaidHand extends CardList
{
    private String name;
    private CardList cards;


    public OldMaidHand(String name)
    {
        super();
        this.name = name;
    }

    public void removePairs()
    {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < super.getSize())
        {
            j = i + 1;
            while (j < super.getSize())
            {
                if (super.getCard(i).getFace() == super.getCard(j).getFace())
                {
                    super.removeCard(super.getCard(j));
                    k++;
                    break;
                }
                j++;
            }
            if (k == 1)
            {
                super.removeCard(super.getCard(i));
                k = 0;
            }
            else
            {
                i++;
            }
        }
    }

    public void display()
    {
        System.out.println(name + "'s Hand: " + super.toString());
        System.out.println();
    }

    public void addHand(Card card)
    {
        this.cards.addCard(card);
    }




    public Card drawCard()
    {
        Random random = new Random();
        System.out.println("Choosing a card from " + this.getName() + "'s hand");

        int size = super.getSize();

        if (size == 0)
        {
            System.out.println("No cards left in " + this.getName() + "'s hand.");
            return null;
        }

        int randomIndex = random.nextInt(size);
        Card c = super.getCard(randomIndex);

        System.out.println(this.getName() + " drew a card: " + c.toString());
        super.removeCard(c);

        return c;
    }

    public void shuffle()
    {
        Random random = new Random();
        for (int j = 0; j < super.getSize(); j++)
        {
            swap(j, random.nextInt(super.getSize()));
        }
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return this.cards.toString();
    }
}
