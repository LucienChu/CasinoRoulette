import java.util.Scanner;
import java.util.StringTokenizer;
public class Dealer
{
    public static void main (String[] args)
    {
        int playerLimit = 6;
        int betLimit = 5;
        Scanner input = new Scanner(System.in);
        int gameOption = 0 ;
        do
        {
            System.out.println ("Welcome to Lucien's Roulette game\n" +
                    "Please int put the correspoding number for the roulette games\n1. European ROulette\n" +
                    "2. American Roulette game.\n3. Exit");
            gameOption = input.nextInt();
            if (gameOption != 1 && gameOption != 2 && gameOption != 3)
                System.out.println("Sorry, your answer is invalid, please try again.");
        }while (gameOption != 1 && gameOption!= 2 && gameOption != 3);


        if (gameOption == 1)
            System.out.println("Welcome, the European Roulette is about to star.");
        else if (gameOption == 2)
            System.out.println("Welcome, the American Roulette is about to star.");
        else
            System.out.println("Wishes you have a nice game, see you next time.");

        Players [] playersOfEuropeanRoulette = null;
        Players [] playersOfAmericanRoulette = null;
        EuropeanRoulette europeanRoulette = new EuropeanRoulette(playersOfEuropeanRoulette);
        AmericanRoulette americanRoulette = new AmericanRoulette(playersOfAmericanRoulette);
        int playerCounter = 0;
        boolean nextPlayer = true;
        int VIP = 0;
        do
        {
            System.out.println ("PLayer " + (playerCounter + 1) + " Are you interested in being our VIP players?\n1. Sure.\n2. Maybe next Time\n3. No more players.");
            VIP = input.nextInt();
            for (int i = playerCounter; i < playerCounter + 1; i++)
            {
                VipPlayers aVipPlayer = new VipPlayers();
                Players aRegularPlayer = new Players();
                if (VIP == 1)
                {
                    europeanRoulette.addPlayer(aVipPlayer);
                    americanRoulette.addPlayer(aVipPlayer);
                }
                else if (VIP == 2)
                {
                    europeanRoulette.addPlayer(aRegularPlayer);
                    americanRoulette.addPlayer(aRegularPlayer);
                }
                else if (VIP == 3)
                    nextPlayer = false;
            }

            if (VIP != 1 && VIP != 2 && VIP != 3)
            {
                System.out.println("Sorry, the answer is invalid, please try again");
                playerCounter --;
            }

            playerCounter ++;
        } while ( (VIP != 1 && VIP != 2 && VIP != 3) || (playerCounter < playerLimit && nextPlayer));
        String garbage = input.nextLine();
        System.out.println("There are " + europeanRoulette.getNumOfPlayers() + " players");
        System.out.println("Before sorting Vip Players are: ");
        VipPlayers vipObj = new VipPlayers();

        for (int i = 0; i < europeanRoulette.getNumOfPlayers(); i++)
            if (europeanRoulette.players[i].getClass() == vipObj.getClass())
                System.out.println("Player " + (i+1));

        //sort the players, those vip player(s) will be
        //placed in front of the list
        europeanRoulette.sortPlayers();
        americanRoulette.sortPlayers();
        System.out.println("After sorting, Vip Players are: ");
        for (int i = 0; i < europeanRoulette.getNumOfPlayers(); i++)
            if (europeanRoulette.players[i].getClass() == vipObj.getClass())
                System.out.println("Player " + (i+1));

        if (gameOption == 1)
        {
            System.out.println("Here is the table\n" + "  0 ");
            int count = 0;
            for (int i = 1; i < 37;i++)
            {
                System.out.print(i + " ");
                count++;
                if (count >= 3)
                {
                    System.out.println();
                    count = 0;
                }
            }
        }
        else if (gameOption == 2)
            System.out.println("I will give u the table later");

        System.out.println("Or you can also bet on the categories below:");
        System.out.println("A. Even\nB. Odd\nC. Red\nD. Black\n" +
                "E. First 18\nF. Last 18\n" + "G. First Column\n" +
                "H. Second Column\nI. Third column\n" +
                "J. First 12\nK. Second 12\nL. Third 12");
        int gameCounter = 0;
        do
        {
            System.out.println("This is game " +(gameCounter + 1));
            for (int i = 0; i < europeanRoulette.getNumOfPlayers(); i++)
            {
                boolean invalidInput = false;
                do
                {
                    String inputBets = null;
                    System.out.println("Player " + (i+1) + ", please input you bet(s) based on the table given above and press ENTER (Please seperate your bets with SPACE!");
                    inputBets = input.nextLine();
                    StringTokenizer wordFactory = new StringTokenizer(inputBets);
                    int totalTokens = wordFactory.countTokens();
                    if (totalTokens > betLimit || totalTokens == 0)
                        invalidInput = true;
                    String [] tokenString = new String[totalTokens];
                    //only the first 5 value would be accepted.
                    for (int j = 0; (j < totalTokens); j++)
                        tokenString[j] = wordFactory.nextToken();
                    for (int k = 0; k < totalTokens; k++)
                    {
                        if (tokenString[k].equalsIgnoreCase("0")||
                                tokenString[k].equalsIgnoreCase("1")||
                                tokenString[k].equalsIgnoreCase("2")||
                                tokenString[k].equalsIgnoreCase("3")||
                                tokenString[k].equalsIgnoreCase("4")||
                                tokenString[k].equalsIgnoreCase("5")||
                                tokenString[k].equalsIgnoreCase("6")||
                                tokenString[k].equalsIgnoreCase("7")||
                                tokenString[k].equalsIgnoreCase("8")||
                                tokenString[k].equalsIgnoreCase("9")||
                                tokenString[k].equalsIgnoreCase("10")||
                                tokenString[k].equalsIgnoreCase("11")||
                                tokenString[k].equalsIgnoreCase("12")||
                                tokenString[k].equalsIgnoreCase("13")||
                                tokenString[k].equalsIgnoreCase("14")||
                                tokenString[k].equalsIgnoreCase("15")||
                                tokenString[k].equalsIgnoreCase("16")||
                                tokenString[k].equalsIgnoreCase("17")||
                                tokenString[k].equalsIgnoreCase("18")||
                                tokenString[k].equalsIgnoreCase("19")||
                                tokenString[k].equalsIgnoreCase("20")||
                                tokenString[k].equalsIgnoreCase("21")||
                                tokenString[k].equalsIgnoreCase("22")||
                                tokenString[k].equalsIgnoreCase("23")||
                                tokenString[k].equalsIgnoreCase("24")||
                                tokenString[k].equalsIgnoreCase("25")||
                                tokenString[k].equalsIgnoreCase("26")||
                                tokenString[k].equalsIgnoreCase("27")||
                                tokenString[k].equalsIgnoreCase("28")||
                                tokenString[k].equalsIgnoreCase("29")||
                                tokenString[k].equalsIgnoreCase("30")||
                                tokenString[k].equalsIgnoreCase("31")||
                                tokenString[k].equalsIgnoreCase("32")||
                                tokenString[k].equalsIgnoreCase("33")||
                                tokenString[k].equalsIgnoreCase("34")||
                                tokenString[k].equalsIgnoreCase("35")||
                                tokenString[k].equalsIgnoreCase("36"))
                        {
                            if (gameOption == 1)
                            {
                                int betValueInNum = Integer.parseInt(tokenString[k]);
                                europeanRoulette.players[i].addBet(betValueInNum);
                            }
                            else if (gameOption == 2)
                            {
                                int betValueInNum = Integer.parseInt(tokenString[k]);
                                americanRoulette.players[i].addBet(betValueInNum);
                            }
                        }
                        else if (tokenString[k].equalsIgnoreCase("00") && gameOption == 2)
                        {
                            int betValueInNum = Integer.parseInt(tokenString[k]);
                            americanRoulette.players[i].addBet(betValueInNum);
                        }
                        else if (tokenString[k].equalsIgnoreCase("A")||
                                tokenString[k].equalsIgnoreCase("B")||
                                tokenString[k].equalsIgnoreCase("C")||
                                tokenString[k].equalsIgnoreCase("D")||
                                tokenString[k].equalsIgnoreCase("E")||
                                tokenString[k].equalsIgnoreCase("F")||
                                tokenString[k].equalsIgnoreCase("G")||
                                tokenString[k].equalsIgnoreCase("H")||
                                tokenString[k].equalsIgnoreCase("I")||
                                tokenString[k].equalsIgnoreCase("J")||
                                tokenString[k].equalsIgnoreCase("K")||
                                tokenString[k].equalsIgnoreCase("L"))
                        {
                            if (gameOption == 1)
                                europeanRoulette.players[i].addCategory(tokenString[k]);
                            else if (gameOption == 2)
                                americanRoulette.players[i].addCategory(tokenString[k]);

                        }
                        else
                        {
                            System.out.println("Sorry, you answer is invalid, please try again!!!");
                            invalidInput = true;
                        }

                    }

                }while(invalidInput);
            }

            int result = 34;
            for (int i = 0; i < europeanRoulette.getNumOfPlayers(); i++)
            {
                if (gameOption == 1)
                {
                    if (europeanRoulette.players[i].bets != null)
                        europeanRoulette.players[i].winNum(result);
                    if (europeanRoulette.players[i].category != null);
                    {
                        europeanRoulette.players[i].isPayOnce(result);
                        europeanRoulette.players[i].isPayTwice(result);
                    }
                    System.out.println(europeanRoulette.players[i].toString());
                }
                if (gameOption == 2)
                {
                    if (americanRoulette.players[i].bets != null)
                        americanRoulette.players[i].winNum(result);
                    if (americanRoulette.players[i].category != null);
                    {
                        americanRoulette.players[i].isPayOnce(result);
                        americanRoulette.players[i].isPayTwice(result);
                    }
                    System.out.println(americanRoulette.players[i].toString());
                }
            }
            gameCounter++;
        }while (gameCounter < 10);
    }
}
