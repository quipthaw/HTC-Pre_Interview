package HTC.Pre_Interview;

/*
 * Manning Graham
 * HTC Pre-Interview Questions
 * 2-7-2023
 */

public class Solutions {
    public static void main(String[] args){

        String words[] = {"mouse", "state", "road", "cat", "catch", "building", "catcher", "chase", "dog", "when", "dogcatcher", "tunnel"};
        String numbers[] = {"123", "213", "321"};

        System.out.println("\nSolution to Pre-Interview questions:");

        CompanySize(2);
        LongestWord(words);
        PinCodes(numbers);
    }


    /*
     * CompanySize
     * A company has a hierarchical structure where a manager can manage at most 8 employees.  All employees have exactly 1 manager
     * except for the top level manager who does not have a manager.
     *
     * Write a function to calculate the maximum number of employees possible at the company for a given number of management levels n.
     * Solve recursively or iteratively using no built-in math power libraries.
     *
     *   solve(int n);
     *
     *     Ex 1 solve(0) = 1
     *     Ex 2 solve(1) = 9
     *     Ex 3 solve(2) = 73
     */
    public static int CompanySize(int n) {

        System.out.println("\nCompanySize: ");

        int sum = 0;
        for( int i = 0; i <= n; i++)
        {
            int a = 8, b = i, tmp = 1;
            for(int j = 0; j < i; j++)
            {
                tmp *= 8;
            }
            sum += tmp;
        }
        System.out.println("Given " + n + " management levels, the maximum number of employees is " + sum);
        return sum;
    }


    /*
     * LongestWord
     * Write a function to find the longest compound word in a list that is made up of other words in that same list.
     * Solve with a custom built data structure, no 3rd party libraries.
     *
     * Example {mouse, state, road, cat, catch, building, catcher, chase, dog, when, dogcatcher, tunnel} = dogcatcher
     *
     *  public String solve(String[] words};
     *
     * The ideal time complexity for a solution is O(n)
     */
    public static String LongestWord(String[] words) {

        System.out.println("\nLongestWord: ");

        // Orders strings from largest to smallest into new list
        for(int i = 1 ;i < words.length; i++)
        {
            String temp = words[i];
            int j = i-1;
            while (j >= 0 && temp.length() < words[j].length())
            {
                words[j+1] = words[j];
                j--;
            }
            words[j+1] = temp;
        }

        // Returns the first compound word found since it is the largest.
        for(int k = words.length - 1; k >= 0; k--) {
            String input = words[k];
            int len = 0;
            for(int l = 0; l < words.length; l++)
            {
                if(input.indexOf(words[l]) != -1) {
                    System.out.println("Longest Compound Word: " + words[k]);
                    return words[k];
                }
            }
        }
        return "none";
    }


    /*
     * PinCodes
     * You are given a list of pin codes that can be between 3 - 10 numbers.  A PIN code
     * is considered a duplicate of another PIN code if it is in the same or reversed order.
     *
     *  Example:
     *     123 is a duplicate of 123
     *     123 is a duplicate of 321
     *     123 is not a duplicate of 213 or 312, etc
     *
     * Given pin codes 123,213,321, there are a total of 2 distinct pin codes, 123 and 213
     * Write a function that will return the count of distinct PIN codes
     * The ideal time complexity for a solution is O(n)
     * public int solve(String[] codes);
     */
    public static int PinCodes(String[] codes) {

        System.out.println("\nPinCodes: ");

        String str, rev;
        int tmp, count=0;

        // iterates through string
        for(int i = 0; i < codes.length; i++){
            tmp = 0;
            str = codes[i];
            rev = "";
            char ch[]=str.toCharArray();

            // gets reversed string
            for(int p=ch.length-1;p>=0;p--) { rev+=ch[p];}

            // iterates again and checks for duplicates
            for(int k = codes.length - 1; k >=0 && tmp !=1; k--){
                if((str.equals(codes[k]) || rev.equals(codes[k])) && i!=k)
                {
                    System.out.println(codes[i]+ " is a duplicate of " + codes[k]);
                    tmp = 1;
                }
            }

            // adds to duplicate count
            if(tmp != 1){
                System.out.println( codes[i] +" is not a duplicate");
                count++;
            }
        }
        System.out.println("Total Non-Duplicates: " + count);
        return count;
    }
}