import java.util.*;

public class OldMaidPlayer extends Player
{
    private OldMaidHand player;
    private ArrayList<Card> cards;

    public OldMaidPlayer(String name)
    {
        super(name);
    }




    public ArrayList<Card> removeCard()
    {
        for (int i = 0; i < cards.size(); i++)
        {
            for (int j = 0; j < cards.size(); j++)
            {
                if (( cards.get(i).getFace() == cards.get(j).getFace() ) && ( cards.get(i).getSuit() != cards.get(j).getSuit()) )
                {
                      if (i > j)
                {
                    cards.remove(i);
                    cards.remove(j);
                    i = 0; j = 0;

                    break;
                }
                      else  if ( j > i )
                    {
                        cards.remove(j);
                        cards.remove(i);
                        i = 0; j = 0;
                        break;
                    }

                    else
                    {
                        continue;
                    }
                }
            }
        }
        return cards;
    }
}