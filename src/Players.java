import java.util.Arrays;
public class Players
{
    public int [] bets;
    public String [] category;
    public boolean winNumber = false;
    public boolean payOnce = false;
    public boolean payTwice = false;
    public int countForOnce = 0;
    public int countForTwice = 0;
    protected double origin = 5;
    public Players()
    {
        bets = null;
        category = null;
    }

    public Players (int [] Bets,String [] aCategory)
    {
        String [] temp1 = new String [aCategory.length];
        for (int i = 0; i < aCategory.length; i++)
            temp1[i] = aCategory[i];

        category = temp1;

        int [] temp2 = new int[Bets.length];
        for (int i = 0; i < Bets.length; i++)
            temp2[i] = Bets[i];
        this.bets = temp2;

        //sort the array bets to facilitate later
        //evaluation

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
        int numbersOfBet = 0;
        if ( category != null && bets != null)
            numbersOfBet = category.length + bets.length;
        else if (category == null && bets != null)
            numbersOfBet = bets.length;
        else if (category != null && bets == null)
            numbersOfBet = category.length;
        else
            numbersOfBet = 0;
        return (numbersOfBet);
    }

    public void addBet(int newBet)
    {
        if (this.bets == null || bets.length == 0)
        {
            int i = 1;
            int [] temp = new int[1];
            temp[0] = newBet;
            this.bets = temp;

        }
        else
        {
            int [] temp = new int[bets.length + 1];

            for (int i = 0; i < bets.length; i++)
                temp[i] = bets[i];
            temp[bets.length] = newBet;
            this.bets = temp;
        }
    }
    public void addCategory(String newCat)
    {
        if (category == null)
        {
            int i = 1;
            String [] temp = new String[1];
            temp[0] = newCat;
            this.category = temp;

        }
        else
        {
            String [] temp = new String[category.length + 1];

            for (int i = 0; i < category.length; i++)
                temp[i] = category[i];
            temp[category.length] = newCat;
            this.category = temp;
        }
    }


    public void setPlayer(int[] otherBet, String [] otherCategory)
    {
        String [] temp1 = new String [otherCategory.length];
        for (int i = 0; i < otherCategory.length; i++)
            temp1[i] = otherCategory[i];

        category = temp1;

        int [] temp2 = new int[otherBet.length];
        for (int i = 0; i < otherBet.length; i++)
            temp2[i] = otherBet[i];
        this.bets = temp2;
    }
    public void winNum(int x)
    {
        if (this.bets != null)
        {
            for (int i = 0; i < bets.length; i++)
            {
                if (x == bets[i])
                    winNumber = true;
            }
        }
        else
            winNumber = false;
    }

    public boolean equals(Players otherPlayer)
    {
        boolean equalsNum = false;
        boolean equalsCat = false;
        int sameNumValue = 0;
        int sameCatValue = 0;
        if (this.getNumbersOfBet() == otherPlayer.getNumbersOfBet()
                && this.getClass() == otherPlayer.getClass())
        {
            for (int i = 0; i < this.getNumbersOfBet(); i++)
                if (this.bets[i] == otherPlayer.bets[i])
                    sameNumValue = sameNumValue + 1;
            if (sameNumValue == this.getNumbersOfBet())
                equalsNum = true;
        }
        if (this.category.length == otherPlayer.category.length)
        {
            for (int i = 0; i < this.category.length; i++)
                for (int j = 0; j < this.category.hashCode(); j++)
                    if (this.category[i].equalsIgnoreCase(otherPlayer.category[i]))
                        sameCatValue++;
            if (sameCatValue == this.category.length)
                equalsCat = true;

        }
        return (equalsCat && equalsNum);
    }

    public boolean isStraight()
    {
        boolean isStraight;
        if (this.bets == null)
            isStraight = false;
        else
            isStraight = (bets.length == 1 && this.winNumber);
        return isStraight;
    }
    public boolean isSplit()
    {
        boolean adjoint = false;
        if (bets != null && bets.length == 2)
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
        if ( (bets!= null) && (bets.length == 3) && (bets[0] % 3 == 0) &&
                (((bets[0] - bets[1]) + (bets[0] - bets[2])) == 3))
            street = true;
        return street;
    }
    public boolean isSquare()
    {
        boolean square = false;
        int sum = 0;
        if (bets != null && bets.length == 4)
        {
            for (int i = 1; i < bets.length; i++)
                sum = bets[0] - bets[i] + sum;
            if (sum == 8)
                square = true;
        }
        return (square);
    }
    public boolean isDoubleStreet()
    {
        boolean doubleStreet = false;
        int sum = 0;
        if (bets != null && bets.length == 6)
        {
            for (int i = 1; i < bets.length; i++)
                sum = bets[0] - bets[i] + sum;
            if (sum == 15)
                doubleStreet = true;
        }
        return doubleStreet;
    }
    public void isPayOnce(int x)
    {
        int countOnce = 0;
        if (category != null)
        {
            for (int i = 0; i < category.length; i++)
            {
                if ((x % 2 == 0 && category[i].equalsIgnoreCase("A") ||
                        x % 2 == 1 && category[i].equalsIgnoreCase("B")) ||
                        ((x == 1 || x == 3 || x == 5 || x == 7 || x == 9||
                                x == 12 || x == 14 || x == 16 || x == 18 || x == 19||
                                x == 21 || x == 23 || x == 25 || x == 27 || x == 30||
                                x == 32 || x == 34 || x == 36 ) &&
                                category[i].equalsIgnoreCase("C")) ||
                        ((x == 2 || x == 4 || x == 6 || x == 8 || x == 10||
                                x == 11 || x == 13 || x == 15 || x == 17 || x == 20||
                                x == 22 || x == 24 || x == 26 || x == 28 || x == 31||
                                x == 33 || x == 35 ) &&
                                category[i].equalsIgnoreCase("D")) ||
                        (( x <= 18 && x > 0 && category[i].equalsIgnoreCase("E") ||
                                (( x <= 36 && x > 18 && category[i].equalsIgnoreCase("F"))))))
                {
                    payOnce = true;
                    countOnce++;
                }
            }
        }
        countForOnce = countOnce;

    }
    public void isPayTwice(int x)
    {
        int countTwice = 0;
        if (category != null)
        {
            for (int i = 0; i < category.length; i++)
                if ((x%3 ==0 && category[i].equalsIgnoreCase("G"))||
                        (x%3 == 1 && category[i].equalsIgnoreCase("H"))||
                        (x%3 == 0 && category[i].equalsIgnoreCase("I"))||
                        ((0 < x && x<13) && category[i].equalsIgnoreCase("J"))||
                        ((12 < x && x<25) && category[i].equalsIgnoreCase("K"))||
                        ((26 < x && x<37) && category[i].equalsIgnoreCase("J")))
                {
                    payTwice = true;
                    countTwice ++;
                }
        }
        countForTwice = countTwice;
    }

    public double getPay()
    {
        double winNumPay = 0;
        double winCatPay = 0;

        if (this.isStraight() && this.winNumber)
            winNumPay = origin*35;
        else if (this.isSplit() && this.winNumber)
            winNumPay = origin*17;
        else if (this.isStreet() && this.winNumber)
            winNumPay = origin*11;
        else if (this.isSquare())
            winNumPay = origin*8;
        else if (this.isDoubleStreet() && this.winNumber)
            winNumPay = origin*5;
        if (this.payOnce)
            winCatPay = origin*1*this.countForOnce;
        else if (this.payTwice)
            winCatPay = origin*2*this.countForTwice;
        return (winCatPay + winNumPay);
    }

    public String toString()
    {
        return "[bets=" + Arrays.toString(bets) + ", category="
                + Arrays.toString(category) + ", wins " + this.getPay();
    }


}
