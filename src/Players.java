/**
 * Created by Steven on 2015-02-04.
 */

public class Players
{
    public int [] bets = new int [6];
    public boolean win = false;
    protected int origin = 5;
    public Players(int [] Bets)
    {
        if (Bets.length <= bets.length)
        {
            int[] temp = new int [Bets.length];
            for (int i = 0; i < Bets.length; i++)
                temp[i] = Bets[i];
            this.bets = temp;
        }
        //sort the array to facilitate later
        //evaluation.
        for (int i = 0; i < bets.length; i++)
        {
            int larger = 0;
            for (int j = i + 1; j < bets.length; j++)
            {
                if (bets[i] < bets[j])
                {
                    larger = bets[j];
                    bets[j] = bets[i];
                    bets[i] = larger;
                }
            }
        }
    }
    public int getNumbersOfBet()
    {
        return (bets.length);
    }
    public void getIt(int x)
    {
        for (int i = 0; i < bets.length; i++)
        {
            if (x == bets[i])
                win = true;
        }
    }
    public boolean equals(Players otherPlayer)
    {
        int sameValue = 0;
        if (this.getNumbersOfBet() == otherPlayer.getNumbersOfBet())
        {
            for (int i = 0; i < this.getNumbersOfBet(); i++)
                if (this.bets[i] == otherPlayer.bets[i])
                    sameValue = sameValue + 1;
        }
        return (sameValue == this.getNumbersOfBet());
    }
    public boolean isStraight()
    {
        return (bets.length == 1 && this.win);
    }
    public boolean isSplit()
    {
        boolean adjoint = false;
        if (bets.length == 2)
        {
            int diff = 0, i = 0;
            diff = bets[i] - bets[i+1];
            if (diff == 1 || diff == -1 || diff == 3 || diff == -3)
                adjoint = true;
        }
        return adjoint;
    }
    public boolean isStreet()
    {
        boolean street = false;
        if (bets.length == 3 && bets[0] % 3 == 0 &&
                (((bets[0] - bets[1]) + (bets[0] - bets[2])) == 3))
            street = true;
        return street;
    }
    public boolean isSquare()
    {
        boolean square = false;
        int sum = 0;
        for (int i = 1; i < bets.length; i++)
            sum = bets[0] - bets[i] + sum;
        if (sum == 8)
            square = true;
        return (square);
    }
    public boolean isDoubleStreet()
    {
        boolean doubleStreet = false;
        int sum = 0;
        for (int i = 1; i < bets.length; i++)
            sum = bets[0] - bets[i] + sum;
        if (sum == 15)
            doubleStreet = true;
        return doubleStreet;
    }
    public int getPay()
    {
        int value = 0;
        if (this.isStraight() && this.win)
            value = origin*35;
        else if (this.isSplit() && this.win)
            value = origin*17;
        else if (this.isStreet() && this.win)
            value = origin*11;
        else if (this.isSquare())
            value = origin*8;
        else if (this.isDoubleStreet() && this.win)
            value = origin*5;
        return (value);
    }
    public String toString()
    {
        return ("total bets = " + (bets.length*origin) + "\n"
                + "wins " + this.getPay());
    }
}