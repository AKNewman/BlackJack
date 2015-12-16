
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int nDp = 0, nPp = 0; //Player Placeholder
        int arnHouse[] = new int[10];  //House cards
        int arnHv[] = new int[10];    //House values
        int arnPlayer[] = new int[10];  //Player cards
        int arnPv[] = new int[10];    //Player values
        int arnDeck[] = new int[52];  //Deck cards
        int arnDv[] = new int[52];  //Deck Values
        int nPval = 0, nHval = 0; //House and player value
        String sHS;
        for (int i = 0; i < 52; i++) {
            arnDeck[i] = (int) (Math.random() * 13 + 1);
            arnDv[i] = arnDeck[i];
            if (arnDeck[i] == 11 || arnDeck[i] == 12 || arnDeck[i] == 13) {
                arnDv[i] = 10;
            }
            System.out.println("Deck " + arnDeck[i]);
            System.out.println("deck Value " + arnDv[i]);
        }
        System.arraycopy(arnHouse, 0, arnHv, 0, 10);
        System.arraycopy(arnPlayer, 0, arnPv, 0, 10);
        for (int i = 0; i < 2; i++) {  //openging deal
            arnHouse[i] = arnDeck[nDp];
            // arnHv[i] = arnHouse[i];
            nDp++;
            arnPlayer[i] = arnDeck[nDp];
            arnPv[i] = arnPlayer[i];
            nDp++;
            nPp++;
            System.out.println("Player card" + (i + 1) + " " + arnPlayer[i]);
            if (arnHouse[i] == 11 || arnHouse[i] == 12 || arnHouse[i] == 13) {
                arnHv[i] = 10;
            } else if (arnPlayer[i] == 11 || arnPlayer[i] == 12 || arnPlayer[i] == 13) {
                arnPv[i] = 10;
            }
        }
        nPval = arnPv[0] + arnPv[1];
        nHval = arnHouse[0] + arnHouse[1];
        // System.out.println("House value "+nHval);
        System.out.println("Player value " + nPval);
        if (nPval == 21) {
            System.out.println("21!!!!!!!!!!!!!!");
        }

        // System.out.println("Player position " + nPp);
        // System.out.println("Deck position " + nDp);

        for (int j = 0; j < 10; j++) {
            if (nPval < 22) {
                System.out.println("Hit or stand");
                sHS = sin.next();
                if ("hit".equals(sHS)) {
                    //System.out.println(arnPlayer[nPp]);
                    //System.out.println(arnDeck[nDp]);
                    arnPv[nPp] = arnDeck[nDp];
                    nPval += arnDeck[nDp];
                    nDp++;
                    nPp++;
                    System.out.println("Player value " + nPval);
                } else if ("stand".equals(sHS)) {
                    System.out.println("Player value " + nPval);
                    j = 100;
                }
            } else {
                System.out.println("BUST");
                j = 100;
            }
        }

    }
}
