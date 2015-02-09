
public class VipPlayers extends Players
{
    double extraOfBet = 0.05;
    double extraOfWin = 1.1;
    public VipPlayers()
    {

    }
    public VipPlayers(int[] Bets, String[] aCategory)
    {
        super(Bets, aCategory);
        this.origin = 10;
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

        return (this.getNumbersOfBet()*extraOfBet*origin + extraOfWin*(winNumPay+winCatPay));
    }
}
