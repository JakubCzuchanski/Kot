// Dodatkowa (5pkt) Napisac program który wyświetli informację o tym
// czy Mysz jest bezpieczna przed kotem (ruchy w pionie i poziomie, brak przechodzenia przez ściany)


public class KotIMysz {


    public static void main(String[] args) {
        char[][] mapa = new char[10][10];

        zapelnijX(mapa, 40);
        ustawKota(mapa);
        ustawMysz(mapa);
        wypisz(mapa);

//        char[][] tab = {
//                {'K', '_', '_', '_', '_', '_', '_', '_', '_', 'O'},
//                {'O', 'O', 'O', 'O', '_', '_', '_', '_', '_', '_'},
//                {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
//                {'_', '_', '_', 'O', 'O', '_', '_', '_', '_', 'O'},
//                {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
//                {'_', '_', '_', '0', '_', '_', '_', '_', '_', 'O'},
//                {'_', '_', '_', '_', '_', '_', 'O', 'O', 'M', 'O'},
//                {'_', '_', '_', '_', '_', 'O', '_', '_', '_', '_'},
//                {'O', '_', 'O', '_', '_', 'O', '_', '_', '_', '_'},
//                {'O', '_', 'O', 'O', '_', 'O', '_', '_', '_', '_'},
//        };
//        wypisz(tab);//
//        x = gdzieKot(tab)[0];
//        y = gdzieKot(tab)[1];//
//        czyZjeMysz(tab, gdzieKot(tab)[0], gdzieKot(tab)[1]);
//        wypisz(tab);


        czyZjeMysz(mapa, gdzieKot(mapa)[0], gdzieKot(mapa)[1]);
        wypisz(mapa);
        zjedzona(mapa);


    }

    private static boolean zjedzona(char[][] mapa) {

        boolean czyZyje = false;
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == 'X') {
                    czyZyje = true;
//                    System.out.println(i + " " + j); //pozycja zjedzonej myszy

                }
            }
        }

        if (czyZyje) {
            System.out.println("Mysz została zjedzona \n");
            return czyZyje;
        } else {
            System.out.println("Mysz przeżyła");
            return czyZyje;
        }
    }

    private static void czyZjeMysz(char[][] mapa, int pozycjaX, int pozycjaY) {


        if (pozycjaY < mapa[0].length - 1 &&
                (mapa[pozycjaX][pozycjaY + 1] == '_' || mapa[pozycjaX][pozycjaY + 1] == 'M')) {
            if (mapa[pozycjaX][pozycjaY + 1] == 'M') {
//
                mapa[pozycjaX][pozycjaY + 1] = 'X';
            } else
                mapa[pozycjaX][pozycjaY + 1] = '+';
            czyZjeMysz(mapa, pozycjaX, pozycjaY + 1);
        }

        if (pozycjaY > 0 &&
                (mapa[pozycjaX][pozycjaY - 1] == '_' || mapa[pozycjaX][pozycjaY - 1] == 'M')) {
            if (mapa[pozycjaX][pozycjaY - 1] == 'M') {
                mapa[pozycjaX][pozycjaY - 1] = 'X';
            } else
                mapa[pozycjaX][pozycjaY - 1] = '+';
            czyZjeMysz(mapa, pozycjaX, pozycjaY - 1);
        }


        if (pozycjaX < mapa.length - 1 &&
                (mapa[pozycjaX + 1][pozycjaY] == '_' || mapa[pozycjaX + 1][pozycjaY] == 'M')) {
            if (mapa[pozycjaX + 1][pozycjaY] == 'M') {
                mapa[pozycjaX + 1][pozycjaY] = 'X';
            } else
                mapa[pozycjaX + 1][pozycjaY] = '+';
            czyZjeMysz(mapa, pozycjaX + 1, pozycjaY);
        }

        if (pozycjaX > 0 && (mapa[pozycjaX - 1][pozycjaY] == '_' || mapa[pozycjaX - 1][pozycjaY] == 'M')) {
            if (mapa[pozycjaX - 1][pozycjaY] == 'M') {
                mapa[pozycjaX - 1][pozycjaY] = 'X';
            } else
                mapa[pozycjaX - 1][pozycjaY] = '+';
            czyZjeMysz(mapa, pozycjaX - 1, pozycjaY);
        }

    }

    private static int[] gdzieKot(char[][] mapa) {

        int[] tab = new int[2];

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == 'K') {
                    tab[0] = i;
                    tab[1] = j;
//                    System.out.println(i + " " + j);

                }
            }
        }

        return tab;
    }


    private static void ustawKota(char[][] mapa) {

        boolean czyUstawiony = false;

        do {
            int x = (int) (Math.random() * mapa.length);
            int y = (int) (Math.random() * mapa.length);

            if (mapa[x][y] == '_') {
                mapa[x][y] = 'K';
                czyUstawiony = true;

            }
        } while (!czyUstawiony);


    }

    private static void ustawMysz(char[][] mapa) {

        boolean czyUstawiony = false;

        do {
            int x = (int) (Math.random() * mapa.length);
            int y = (int) (Math.random() * mapa.length);

            if (mapa[x][y] == '_') {
                mapa[x][y] = 'M';
                czyUstawiony = true;

            }
        } while (!czyUstawiony);

    }

    private static void zapelnijX(char[][] mapa, int iloscX) {
        for (int i = 0; i < mapa.length; i++)
            for (int j = 0; j < mapa[i].length; j++)
                mapa[i][j] = '_';
        while (iloscX > 0) {
            int x = (int) (Math.random() * mapa.length);
            int y = (int) (Math.random() * mapa.length);
            if (mapa[x][y] != 'O') {
                mapa[x][y] = 'O';
                iloscX--;
            }
        }
    }

    private static void wypisz(char[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}