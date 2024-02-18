public class Main {

    public static void main(String[] args) {

        main3();
    }

    public static void main0() {

        //int[] teams = new int[20];
        int numberOfMatches = 0;
        int matchNumber;
        //int numberOfRounds = 0;
        //String[][] rounds = new String[38][10];

        /*for (int i = 0; i < 20; i++) {

            teams[i] = i;
        }*/

        for (int i = 0; i < 20; i++) {

            System.out.println("I = " + i);

            for (int j = i; j < 20; j++) {

                if(i != j){

                    matchNumber = defineMatchNumber(i+1);

                    System.out.println("First-half match: " + i + " X " + j + " (round = " +
                            j + ", match = " + matchNumber + ")");
                    //rounds[j-1][matchNumber-1] = ("First-half match: " + i + " X " + j);
                    numberOfMatches++;
                    System.out.println("Second-half match: " + j + " X " + i + " (round = " +
                            (j+19) + ", match = " + matchNumber + ")");
                    //rounds[(j+19) - 1][matchNumber-1] = ("Second-half match: " + j + " X " + i);
                    numberOfMatches++;
                }
            }
        }

        System.out.println("Number of matches: " + numberOfMatches);

        /*for (int i = 0; i < 38; i++) {

            System.out.println("Round " + (i+1) + ":");

            for (int j = 0; j < 10; j++) {

                System.out.println(rounds[i][j]);
            }
        }*/
    }

    public static void main1(){

        int matches[][] = new int[20][20];
        int counter0 = 0;

        for(int line = 0; line < 20; line++){

            if(line == 0){

                System.out.println("   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19");
            }

            System.out.print(line);

            if (line < 10)
                System.out.print("  ");
            else
                System.out.print(" ");

            for(int column = 0; column < 20; column++){

                System.out.print(matches[line][column]);

                if(column < 19)
                    System.out.print(" ");

                counter0++;
            }

            System.out.println();
        }

        System.out.println("counter0 = " + counter0);
    }

    public static void main2(){

        int teams[] = new int[20];
        int shiftedPosition = 0;

        for (int i = 0; i < 20; i++) {

            teams[i] = i;
        }

        for(int team = 0; team < 4; team+=2){

            System.out.println("Team " + team + ":");

            for(int shift = 1; shift < 20; shift++){

                shiftedPosition = team + shift;

                if (shiftedPosition > 19)
                    shiftedPosition -= 20;

                System.out.println(teams[team] + " " + teams[shiftedPosition]);
            }
        }
    }

    public static void main3(){

        int[][] matrix0 = new int[20][20];
        int contDifNumbers[] = new int[38];
        Match newMatch; //a match that is created on each iteration of the repetition of the inner loop

        matrix0 = fillMatrix(matrix0);

        print2DMatrix(matrix0);

        for (int i = 0; i < 20; i++) {

            for (int j = 0; j < 20; j++) {

                if (matrix0[i][j] != 0)
                    contDifNumbers[matrix0[i][j]-1]++;
            }
        }

        for (int i = 0; i < 38; i++) {

            System.out.println("contDifNumbers[" + i + "] = " + contDifNumbers[i]);
        }
    }

    private static int defineMatchNumber(int i){

        if( (i%2) == 0 )
            return (i/2);
        else
            return ( (i+1)/2 );
    }

    private static void print2DMatrix(int[][] matrix){

        int numberOfLines = matrix.length;
        int numberOfColumns = matrix[0].length;

        System.out.print("     "); //space before the columns numbers indication for alignment

        //Printing the columns numbers indication
        for (int i = 0; i < numberOfColumns; i++) {

            System.out.print(i);

            /*Decision structure that prints the space after each number according
            * to it's number of digits, besides the last number*/
            if (i < numberOfColumns-1)

                if (i < 10)
                    System.out.print("   ");
                else if (i < 100)
                    System.out.print("  ");
                else System.out.print(" ");
        }

        System.out.println();
        System.out.print("    "); //space before separation line for alignment

        //Printing a line of "-" to separate
        for (int i = 0; i < (numberOfColumns * 4 - 2); i++)
            System.out.print("-");

        System.out.println(); //space before printing the matrix

        //Repetition structure that prints the matrix
        for (int lineNumber = 0; lineNumber < numberOfLines; lineNumber++) {

            System.out.print(lineNumber); //printing the line number indicator

            /*Decision structure that prints the space after each number according
             * to it's number of digits*/
            if (lineNumber < 10)
                System.out.print("  | ");
            else if (lineNumber < 100)
                System.out.print(" | ");
            else System.out.print("| ");

            for (int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {

                System.out.print(matrix[lineNumber][columnNumber]);

                /*Decision structure that prints space after each element besides
                * the last one, according to it's number of digits*/
                if (columnNumber < numberOfColumns-1){

                    if (matrix[lineNumber][columnNumber] < 10)
                        System.out.print("   ");
                    else if (matrix[lineNumber][columnNumber] < 100)
                        System.out.print("  ");
                    else if (matrix[lineNumber][columnNumber] < 1000)
                        System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    private static int[][] fillMatrix(int[][] matrix){

        int numberOfLines = matrix.length;
        int numberOfColumns = matrix[0].length;
        int roundNubmer;

        for (int line = 0; line < numberOfLines; line++) {

            for (int column = 0; column < numberOfColumns; column++) {

                if(line < column){
                    //portion of the matrix above the main diagonal

                    roundNubmer = line + column;

                    if (roundNubmer > 19)
                        roundNubmer -= 19;

                    if ((roundNubmer%2) == 0)
                        roundNubmer += 19;

                    matrix[line][column] = roundNubmer;
                } else if (line > column) {
                    //portion of the matrix below the main diagonal

                    roundNubmer = line + column;

                    if (roundNubmer > 19)
                        roundNubmer -= 19;

                    if ((roundNubmer%2) != 0)
                        roundNubmer += 19;

                    matrix[line][column] = roundNubmer;
                }
            }
        }

        return matrix;
    }
}