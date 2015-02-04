/**
 * Created by Steven on 2015-02-04.
 */
public class EuropeanRoulette
{
    public int [] numbers = new int[37];
    Players players[] = new Players[6];

    public EuropeanRoulette (int[] Numbers, Players [] p)
    {
        for (int i = 0; i < Numbers.length; i++)
        {
            Numbers[i] = i;
        }
        numbers = Numbers;
    }
    public String toString()
    {
        return("Hello, this is an European Roulette, we have " + players.length + " players right now");
    }
}
