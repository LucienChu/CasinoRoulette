import java.util.Arrays;


public class Players
{
    public int [] bets = new int [6];
    public String category = " ";
    public boolean winNumber = false;
    public boolean payOnce = false;
    public boolean payTwice = false;
    protected double origin = 5;
    public Players (int [] Bets,String aCategory)
    {
        if(aCategory != null && ((aCategory.equalsIgnoreCase("A") || aCategory.equalsIgnoreCase("B") ||
                aCategory.equalsIgnoreCase("C") || aCategory.equalsIgnoreCase("D") ||
                aCategory.equalsIgnoreCase("E") || aCategory.equalsIgnoreCase("F") ||
                aCategory.equalsIgnoreCase("G") || aCategory.equalsIgnoreCase("G") ||
                aCategory.equalsIgnoreCase("H") || aCategory.equalsIgnoreCase("I") ||
                aCategory.equalsIgnoreCase("J") || aCategory.equalsIgnoreCase("K"))))
            this.category = aCategory;
        if (Bets != null || bets.length != 0)
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
        if (a.equalsIgnoreCase("A") || a.equalsIgnoreCase("B") || a.equalsIgnoreCase("C") ||
                a.equalsIgnoreCase("D") || a.equalsIgnoreCase("E") || a.equalsIgnoreCase("F"))
            this.payTwice = true;
        else if (a.equalsIgnoreCase("G") || a.equalsIgnoreCase("H") || a.equalsIgnoreCase("I") ||
                a.equalsIgnoreCase("J") || a.equalsIgnoreCase("K") || a.equalsIgnoreCase("L"))
            this.payOnce = true;
    }
    public boolean equals(Players otherPlayer)
    {
        boolean equals = false;
        int sameValue = 0;
        if (this.bets != null && this.getNumbersOfBet() == otherPlayer.getNumbersOfBet()
                && this.getClass() == otherPlayer.getClass())
        {
            for (int i = 0; i < this.getNumbersOfBet(); i++)
                if (this.bets[i] == otherPlayer.bets[i])
                    sameValue = sameValue + 1;
            if (sameValue == this.getNumbersOfBet())
                equals = true;
        }
        else if (this.category.equalsIgnoreCase(otherPlayer.category))
            equals = true;

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
        boolean category2 = false;
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
        else if ((x%3 ==0 && category.equalsIgnoreCase("G"))||
                (x%3 == 1 && category.equalsIgnoreCase("H"))||
                (x%3 == 0 && category.equalsIgnoreCase("I"))||
                ((0 < x && x<13) && category.equalsIgnoreCase("J"))||
                ((12 < x && x<25) && category.equalsIgnoreCase("K"))||
                ((26 < x && x<37) && category.equalsIgnoreCase("J")))
            category2 = true;

        return (false);
    }
    public boolean isCategory2(int y)
    {
        return (false);
    }
    public double getPay()
    {
        double value = 0;
        if (this.bets != null && this.category == null)
        {
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
        }
        else if (this.bets == null && this.category != null)
        {
            if (this.payOnce)
                value = origin*1;
            else if (this.payTwice)
                value = origin*2;
        }
        return (value);

    }
    public String toString()
    {
        String aString = " ";
        if (this.bets != null && category == null)
            aString = "bets= " + Arrays.toString(bets) + " wins " + getPay();
        else if (category.equalsIgnoreCase("A"))
            aString = "bets on even number, wins " + getPay();
        else if (category.equalsIgnoreCase("B"))
            aString = "bets on odd number, wins " + getPay();
        else if (category.equalsIgnoreCase("C"))
            aString = "bets on red color, wins " + getPay();
        else if (category.equalsIgnoreCase("D"))
            aString = "bets on black color, wins " + getPay();
        else if (category.equalsIgnoreCase("E"))
            aString = "bets on the first 18 numbers, wins " + getPay();
        else if (category.equalsIgnoreCase("F"))
            aString = "bets on the last 18 numbers, wins " + getPay();
        else if (category.equalsIgnoreCase("G"))
            aString = "bets on the first column, wins " + getPay();
        else if (category.equalsIgnoreCase("H"))
            aString = "bets on the second column, wins " + getPay();
        else if (category.equalsIgnoreCase("I"))
            aString = "bets on the last column, wins " + getPay();
        else if (category.equalsIgnoreCase("J"))
            aString = "bets on the first 12 numbers, wins " + getPay();
        else if (category.equalsIgnoreCase("K"))
            aString = "bets on the second 12 numbers, wins " + getPay();
        else if (category.equalsIgnoreCase("L"))
            aString = "bets on the last 12 numbers, wins " + getPay();
        return aString;
    }

}
