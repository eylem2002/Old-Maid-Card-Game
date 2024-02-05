import java.util.*;

public class CardList
{
    private final ArrayList<Card> list;
    int counter=0;



    // Creates a full deck with the cards initial
    public CardList()
    {
        list = new ArrayList<Card>();

    }


    // Adds a card to the collection.

    public void addCard(Card c)
    {
        list.add(c);

    }

    // Deals the first card from the collection.

    public Card deal()
    {
        if (list.size() > 0)
        {
            return list.remove(0);
        }
        else
        {
            return null;
        }
    }


    // Deals a random card from the collection.

    public Card randomDeal()
    {
        Random generator = new Random();
        int index = generator.nextInt(list.size());

        if (list.size() > 0)
        {
            return list.remove(index);
        } else
        {
            return null;
        }
    }

    //  Returns the ith card from the stack of cards.
    public Card getCard(int i)
    {

        return list.get(i);

    }

    // Return the number of cards left in the deck
    public int getSize()
    {

        return list.size();
    }


    // Remove the card from the list
    public void removeCard(Card c)
    {
        System.out.println("------ remove from list ------"+c);
        list.remove(c);
    }

     //Overloaded
    //removing by index:

    public void removeCard(int i)
    {
        System.out.println("------ remove from list ------"+list.get(i));
        list.remove(i);
    }




  // if the deck has cards
    public boolean hasMoreCards()
    {
        return (list.size() > 0);
    }

    //  Swaps two cards in the list of Cards
    public void swap(int position1, int position2)
    {
        Card temp;
        temp = list.get(position1);
        list.set(position1, list.get(position2));
        list.set(position2, temp);
    }


    public String toString()
    {
         counter=0;
        String result = "";
        for(int i=0; i<list.size(); i++)
        {
            counter++;
            result+="("+list.get(i).toString()+")";
        }
        return result;
    }


    public void shuffle()
    {
        int random;
        for (int i=0; i<list.size(); i++)
        {
            random = (int)(Math.random()*list.size());
            swap(i,random);
        }
    }


}