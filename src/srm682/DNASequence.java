/*
    Problem Statement
    	For the purposes of this problem, a DNA sequence is a string consisting of the letters A, C, G, and T.
    You have been hired by researchers at TopBiologist to help them with some programming tasks. The researchers have
    found a sequence of uppercase letters, which is given to you in the String sequence. They have asked you to write
    a program which find the length of the longest DNA sequence that is a substring of sequence.

    A substring can be obtained from sequence by deleting some (possibly zero) characters from the beginning or end.
    For example, suppose sequence is the string "TOPBOATER". Then "TOP", "PBOA", "T", and "AT" are some examples of
    substrings of sequence. Of these examples, "T" and "AT" are DNA sequences. The answer to the problem would be 2
    because "AT" is the longest such sequence and its length is 2.

    Please find and return the length of the longest DNA sequence that is a substring of sequence.

    Definition

    Class:	DNASequence
    Method:	longestDNASequence
    Parameters:	String
    Returns:	int
    Method signature:	int longestDNASequence(String sequence)
    (be sure your method is public)

    Constraints
    -	sequence will contain between 1 and 50 characters, inclusive.
    -	Each character of sequence will be an upper-case English letter ('A'-'Z').

    Examples
    0)
    "TOPBOATER"
    Returns: 2
    This is the example from the problem statement.

    1)
    "SUSHI"
    Returns: 0
    None of the substrings of "SUSHI" are DNA sequences, so the answer is 0.

    2)
    "GATTACA"
    Returns: 7

    3)
    "GOODLUCK"
    Returns: 1

    4)
    "VVZWKCSIQEGANULDLZESHUYHUQGRKUMFCGTATGOHMLKBIRCA"
    Returns: 6
 */

package srm682;

/**
 * Created by Ajay on 2/25/2016.
 */
public class DNASequence {
    public static void main(String[] args) {
        int i = new DNASequence().longestDNASequence("ATGCWOIFGATAGGCDF");
        System.out.println("i = " + i);
    }

    public int longestDNASequence(String s) {
        int maxLength = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (checkLetter(s.charAt(i))) {
                j++;
            } else {
                maxLength = Math.max(maxLength, j);
                j = 0;
            }
        }
        return maxLength;
    }

    private boolean checkLetter(char c){
        if(c == 'A' || c == 'T' || c == 'G' || c == 'C'){
            return true;
        } else {
            return false;
        }
    }
}
