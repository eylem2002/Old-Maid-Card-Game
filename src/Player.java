public class Player {
    private int currentPoints;
    private String name;
    private int numberPoints;//number of points each player has earned throughout the game
    private int losses;
    private int wins;



    public Player(String name)
    {
        wins = 0;
        losses = 0;
        this.name = name;
        currentPoints = 0;
        numberPoints = 0;
    }


    public int getLosses()
    {
        return this.losses;
    }


    public int getWins()
    {
        return this.losses;
    }


    public void setName(String name)
    {

        this.name = name;
    }


    public String getName()
    {
        return name;
    }
    public void won()
    {
        wins++;
    }


    public int getPoints()
    {
        return this.currentPoints;
    }


    public int getTotalPoints()
    {
        return numberPoints;
    }

    public void loss()
    {
        losses++;
    }



    public void setPoints(int points)
    {
        this.currentPoints = points;
        this.numberPoints+=points;
    }


    public String toString()
    {
        String result = "\n"+name+" ===> number of points: "
                +numberPoints+"\n"+
                "wins: "+wins+"\nlosses: "+losses+"\n";
        return result;
    }
}