/*
    Problem Statement
            You are programming a robot which lives on an infinite grid of empty cells. Each cell can be described by
    two integer coordinates (x, y). The robot always occupies a single cell of the grid. Initially, the robot is at
    coordinates (0, 0). A program has already been uploaded into the robot. The program is a sequence of instructions.
    Each instruction is one of the letters U, D, L, or R. These letters correspond to the commands 'move up',
    'move down', 'move left', and 'move right' respectively. Once the robot is turned on, it will execute each
    instruction exactly once, in the given order. After executing all of the instructions, it will stop moving and it
    will turn itself off. You are given the robot's current program in the String instructions.

    Whenever the robot returns to the cell (0, 0), it claps its hands. You find that funny, so you want to maximize the
    number of times the robot returns to the cell (0, 0). You are allowed to make at most changesAllowed modifications
    to the robot's current program. Each modification consists of selecting a single character and changing it to a
    different character. (The new character still needs to be one of the letters U, D, L, or R. Note that you are not
    allowed to add or remove characters, you can only change the existing ones.)

    Please find and return the maximum number of times the robot can return to the cell (0, 0).

    Definition

    Class:	FriendlyRobot
    Method:	findMaximumReturns
    Parameters:	String, int
    Returns:	int
    Method signature:	int findMaximumReturns(String instructions, int changesAllowed)
    (be sure your method is public)

    Constraints
    -	instructions will contain between 2 and 300 characters, inclusive.
    -	Each character of instructions will be U, D, L, or R.
    -	changesAllowed will be between 0 and the length of instructions, inclusive.

    Examples
    0)
    "UULRRLLL"
    1
    Returns: 3
    By changing the the first U to a D, you can make the robot return to its starting location 3 times.
    (Changing the second U to a D is also a valid solution.)

    1)
    "ULDR"
    0
    Returns: 1

    2)
    "ULDR"
    2
    Returns: 2

    3)
    "ULDRRLRUDUDLURLUDRUDL"
    4
    Returns: 8

    4)
    "LRLDRURDRDUDDDDRLLRUUDURURDRRDRULRDLLDDDDRLRRLLRRDDLRURLRULLLLLRRRDULRULULRLRDLLDDLLRDLUUDUURRULUDUDURULULLDRUDUUU
    RRRURUULRLDLRRRDLLDLRDUULUURUDRURRLURLDLDDUUURRURRLRDLDDULLUDLUDULRDLDUURLUUUURRLRURRDLRRLLLRDRDUUUDRRRDLDRRUUDUDDU
    DDRLUDDULRURRDRUDLDLLLDLUDDRLURLDUDRUDDDDURLUUUDRLURDDDDLDDRDLUDDLDLURR"
    47
    Returns: 94

    5)
    "UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU
    UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU
    UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU"
    300
    Returns: 150

    6)
    "UD"
    1
    Returns: 1
    Remember that you can change fewer than changesAllowed characters if you wish.
 */

package srm682;

/**
 * Created by Ajay on 02-Mar-16.
 * //PENDING
 */
public class FriendlyRobot {

    int x = 0;
    int y = 0;

    public static void main(String[] args) {
//      String s = "UULRRLLL";  //3
//      int changesAllowed = 1;
//        String s = "ULDR";    //1
//        int changesAllowed = 0;
//        String s = "ULDR";    //2
//        int changesAllowed = 2;
        String s = "ULDRRLRUDUDLURLUDRUDL";//8
        int changesAllowed = 4;
//        String s = "LRLDRURDRDUDDDDRLLRUUDURURDRRDRULRDLLDDDDRLRRLLRRDDLRURLRULLLLLRRRDULRULULRLRDLLDDLLRDLUUDUURRULUDUDURULULLDRUDUUURRRURUULRLDLRRRDLLDLRDUULUURUDRURRLURLDLDDUUURRURRLRDLDDULLUDLUDULRDLDUURLUUUURRLRURRDLRRLLLRDRDUUUDRRRDLDRRUUDUDDUDDRLUDDULRURRDRUDLDLLLDLUDDRLURLDUDRUDDDDURLUUUDRLURDDDDLDDRDLUDDLDLURR";
//        int changesAllowed = 47;  //94
        int i = new FriendlyRobot().findMaximumReturns(s, changesAllowed);
        System.out.println("i = " + i);
    }

    private int findMaximumReturns(String s, int n) {
        int i = 0;
        int a = 0;
        updateXYValue(s.charAt(i++));
        boolean b = true;

        while (i < s.length()) {
//            System.out.println(s.charAt(i));
            updateXYValue(s.charAt(i));
            if (x == 0 && y == 0) {
                a++; b = false;
            } else {
                if (!b) {
                    i++;
                    b = !b;
                    continue;
                }else{

                    if(n>0){
                        a++;
                        n--;
                        System.out.println("inside");
                        x=0;
                        y=0;
                        b = !b;
                    }
                }

            }
            i++;
        }
        return a;
    }

    private void updateXYValue(char s) {
        if (s == 'U') ++y;
        if (s == 'D') --y;
        if (s == 'R') ++x;
        if (s == 'L') --x;
        System.out.println(s+" = "+x + "," + y);
    }
}