import java.util.Arrays;
public class EuropeanRoulette
{
    public static int total = 37;
    public int [] numbers = new int[38];
    Players [] players;
    public EuropeanRoulette()
    {
        players = null;
    }

    public EuropeanRoulette(Players[] players)
    {
        numbers[0] =0;
        numbers[1] =32;
        numbers[2] =15;
        numbers[3] =19;
        numbers[4] =4;
        numbers[5] =21;
        numbers[6] =2;
        numbers[7] =25;
        numbers[8] =17;
        numbers[9] =34;
        numbers[10] = 6;
        numbers[11] = 27;
        numbers[12] = 13;
        numbers[13] = 36;
        numbers[14] =11;
        numbers[15] =30;
        numbers[16] =8;
        numbers[17] =23;
        numbers[18] =10;
        numbers[19] =5;
        numbers[20] =24;
        numbers[21] =16;
        numbers[22] =33;
        numbers[23] =1;
        numbers[24] =20;
        numbers[25] =14;
        numbers[26] =31;
        numbers[27] =9;
        numbers[28] =22;
        numbers[29] =18;
        numbers[30] =29;
        numbers[31] =7;
        numbers[32] =28;
        numbers[33] =12;
        numbers[34] =35;
        numbers[35] =3;
        numbers[36] = 26;
    }
    public void sortPlayers()
    {
        int start = 0;
        int last = 1;
        Players regObject = new Players();
        VipPlayers vipObject = new VipPlayers();
        Players [] temp = new Players[this.getNumOfPlayers()];
        for (int i = 0; i < this.getNumOfPlayers(); i++)
        {
            if (players[i].getClass() == vipObject.getClass())
            {
                temp[start] = players[i];
                start++;
            }
            else
            {
                temp[this.getNumOfPlayers() - last] = players[i];
                last++;
            }
        }
        this.players = temp;
    }
    public int getNumOfPlayers()
    {
        return players.length;
    }

    public void addPlayer(Players newPlayer)
    {
        if (this.players == null)
        {
            int i = 1;
            Players [] temp = new Players[1];
            temp[0] = newPlayer;
            this.players = temp;

        }
        else
        {
            Players [] temp = new Players[this.players.length + 1];

            for (int i = 0; i < players.length; i++)
                temp[i] = players[i];
            temp[this.players.length] = newPlayer;
            this.players = temp;
        }
    }
    public String toString() {
        return "EuropeanRoulette [numbers=" + Arrays.toString(numbers);
    }


}
