
public class Players
{
    public int [] bets = new int [6];
    public String category = " ";
    public boolean winNumber = false;
    public boolean winCategory1 = false;
    public boolean winCategory2 = false;
    protected double origin = 5;
    public Players (String aCategory)
    {
        if (aCategory.equalsIgnoreCase("A") || aCategory.equalsIgnoreCase("B") ||
                aCategory.equalsIgnoreCase("C") || aCategory.equalsIgnoreCase("D") ||
                aCategory.equalsIgnoreCase("E") || aCategory.equalsIgnoreCase("F") ||
                aCategory.equalsIgnoreCase("G") || aCategory.equalsIgnoreCase("G") ||
                aCategory.equalsIgnoreCase("H") || aCategory.equalsIgnoreCase("I") ||
                aCategory.equalsIgnoreCase("J") || aCategory.equalsIgnoreCase("K"))
            this.category = aCategory;
    }
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
        int numberOfBet = 0;
        if (bets != null)
            numberOfBet = bets.length;
        else if (this.category.length() != 0 && this.category.length() < 2)
            numberOfBet = 1;
        return numberOfBet;
    }
    public void getItNum(int x)
    {
        if (this.getNumbersOfBet() != 0)
        {
            for (int i = 0; i < bets.length; i++)
            {
                if (x == bets[i])
                    winNumber = true;
            }
        }
    }
    public void getItCat(String a)
    {
        if (a.equalsIgnoreCase("A")||)
            this.winCategory2 = true;
        else if (category == 'G' || category == 'g' || category == 'H' || category == 'h' ||
                category == 'I' || category == 'i' || category == 'J' || category == 'K' ||
                category == 'K' || category == 'k' || category == 'L' || category == 'l')
            this.winCategory1 = true;
    }
    public boolean equals(Players otherPlayer)
    {
        boolean equals = false;
        int sameValue = 0;
        if (this.bets != null)
        {
            if (this.getClass() == otherPlayer.getClass())
            {
                if (this.getNumbersOfBet() == otherPlayer.getNumbersOfBet())
                {
                    for (int i = 0; i < this.getNumbersOfBet(); i++)
                        if (this.bets[i] == otherPlayer.bets[i])
                            sameValue = sameValue + 1;
                }
            }
            if (sameValue == this.getNumbersOfBet())
                equals = true;
        }

        else
        {	String cat1 = " ", cat2 = " ";
            cat1 = Character.toString(this.category);
            cat2 = Character.toString(otherPlayer.category);
            if (cat1.equalsIgnoreCase(cat2))
                equals = true;
        }
        return equals;
    }
    public boolean isStraight()
    {
        return (bets.length == 1 && this.winNumber);
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
    public boolean isCategory1(int x)
    {
        boolean category1 = false;
        String category = Character.toString(this.category);
        if ((x % 2 == 0 && category.equalsIgnoreCase("A") ||
                x % 2 == 1 && category.equalsIgnoreCase("B")) ||
                ((x == 1 || x == 3 || x == 5 || x == 7 || x == 9||
                        x == 12 || x == 14 || x == 16 || x == 18 || x == 19||
                        x == 21 || x == 23 || x == 25 || x == 27 || x == 30||
                        x == 32 || x == 34 || x == 36 ) &&
                        category.equalsIgnoreCase("C")) ||
                ((x == 2 || x == 4 || x == 6 || x == 8 || x == 10||
                        x == 11 || x == 13 || x == 15 || x == 17 || x == 20||
                        x == 22 || x == 24 || x == 26 || x == 28 || x == 31||
                        x == 33 || x == 35 ) &&
                        category.equalsIgnoreCase("D")) ||
                ((18<= x && x > 0 && category.equalsIgnoreCase("E") ||
                        (36 <= x && x > 18 && category.equalsIgnoreCase("F")))))
            category1 = true;

        return (false);
    }
    public boolean isCategory2(int y)
    {
        return (false);
    }
    public double getPay()
    {
        double value = 0;
        if (this.isStraight() && this.winNumber)
            value = origin*35;
        else if (this.isSplit() && this.winNumber)
            value = origin*17;
        else if (this.isStreet() && this.winNumber)
            value = origin*11;
        else if (this.isSquare())
            value = origin*8;
        else if (this.isDoubleStreet() && this.winNumber)
            value = origin*5;
        else if (this.winCategory1)
            value = origin*1;
        else if (this.winCategory2)
            value = origin*2;
        return (value);
    }
    public String toString()
    {
        return ("total bets = " + (bets.length*origin) + "\n"
                + "winNumbers " + this.getPay());
    }
}
