/*
    Problem Statement
            For the purposes of this problem, a DNA sequence is a string consisting of the letters A, C, G, and T.
    You have been hired to help researchers at TopBiologist uncover the secrets of the human genome. The researchers
    have identified a DNA sequence, which is given to you in the String sequence. They have asked you to write a program
    which finds the shortest DNA sequence that is not contained in sequence.

    For example, if sequence is the string "AGGTCTA", then one possible answer would be the string "AC". Other solutions,
     such as "CC", would also be accepted. "AG" would be an invalid answer because "AG" is contained in sequence.
     "AAA" would also be invalid: although it isn't contained in sequence, it is 3 characters long, and there are better
     answers which are only 2 characters long.

    You are not really sure how this could possibly help anyone's research, but it's not your job to question
    TopBiologist. Find and return the shortest DNA sequence which is not contained in sequence. If there are multiple
    possible answers, you may return any of them.

    Definition

    Class:	TopBiologist
    Method:	findShortestNewSequence
    Parameters:	String
    Returns:	String
    Method signature:	String findShortestNewSequence(String sequence)
    (be sure your method is public)

    Notes
    -	Formally, we say that sequence X is contained in sequence Y if we can obtain X by erasing some (possibly none)
    elements from the beginning and from the end of Y. For example, "AB" is contained in "ABC", but "AC" is not
    contained in "ABC".

    Constraints
    -	sequence will contain between 1 and 2000 characters, inclusive.
    -	Each character of sequence will be A, C, G, or T.

    Examples
    0)
    "AGGTCTA"
    Returns: "AC"
    This is the example from the problem statement. Any of the following answers will be accepted:
    "AA", "AC", "AT", "CA", "CC", "CG", "GA", "GC", "TG", and "TT".

    1)
    "AGACGACGGAGAACGA"
    Returns: "T"

    2)
    "A"
    Returns: "C"

    3)
    "AAGATACACCGGCTTCGTG"
    Returns: "CAT"
 */

package srm682;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay on 2/25/2016.
 */
public class TopBiologist {
    public static void main(String[] args) {
        String seq = new TopBiologist().findShortestNewSequence("AAGATACACCGGCTTCGTG");
        System.out.println("seq = " + seq);
    }

    private String findShortestNewSequence(String seq) {
        List<String> l = new ArrayList<String>();
        l.add("");

        while (true){
            l = getSequences(l);
            for(String s: l){
                if (!seq.contains(s)) {
                    return s;
                }
            }
        }
    }

    private List getSequences(List<String> l) {
        List<String> l2 = new ArrayList<String>();
        for (String s : l) {
            l2.add(s + "A");
            l2.add(s + "T");
            l2.add(s + "G");
            l2.add(s + "C");
        }
        return l2;
    }
}
