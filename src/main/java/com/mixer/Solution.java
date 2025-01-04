package com.mixer;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class BuildArrayFromPermutation {
    public static int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    public static int[] buildArrayBigO1(int[] nums) {
        //{0,2,1,5,3,4}
        //nums[0] = nums[0] + (nums[nums[0]] % 6) * 6 => nums[0] = 0+(0%6)*6 = 0+0*6 = 0+0 = 0
        //nums[1] = nums[1] + (nums[nums[1]] % 6) * 6 => nums[1] = 2+(1%6)*6 = 2+1*6 = 2+6 = 8
        //nums[2] = nums[2] + (nums[nums[2]] % 6) * 6 => nums[2] = 1+(8%6)*6 = 1+2*6 = 2+12= 14
        //nums[3] = nums[3] + (nums[nums[3]] % 6) * 6 => nums[3] = 5+(4%6)*6 = 5+4*6 = 5+24= 29
        //nums[4] = nums[4] + (nums[nums[4]] % 6) * 6 => nums[4] = 3+(29%6)*6= 3+5*6 = 3+30= 33
        //nums[5] = nums[5] + (nums[nums[5]] % 6) * 6 => nums[5] = 4+(33%6)*6= 4+3*6 = 4+18= 22
        //{0,8,14,29,33,22}
        for(int i=0; i< nums.length; i++) {
            nums[i] += (nums[nums[i]] % nums.length) * nums.length;
        }

        //nums[0] = nums[0]/6 = 0/6 = 0
        //nums[1] = nums[1]/6 = 8/6 = 1
        //nums[2] = nums[2]/6 = 14/6= 2
        //nums[3] = nums[3]/6 = 29/6= 4
        //nums[4] = nums[4]/6 = 33/6= 5
        //nums[5] = nums[5]/6 = 22/6= 3
        //{0,1,2,4,5,3}

        for(int i=0; i<nums.length; i++) {
            nums[i] /= nums.length;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildArray(new int[]{0,2,1,5,3,4})));
        System.out.println(Arrays.toString(buildArrayBigO1(new int[]{0,2,1,5,3,4})));
    }
}


class ConcatArrayTwice {
    public static int[] getConcatenationUsingStream(int[] nums) {
        return IntStream.concat(Arrays.stream(nums), Arrays.stream(nums)).toArray();
    }

    public static int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length*2];
        for(int i=0; i<nums.length*2; i++) {
            //3 = 0
            //4 = 1
            //5 = 2
            res[i] = nums[i%nums.length];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{0,2,1})));
    }
}

class ShuffleArray {
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        //0,1,2,3,4,5, n=3

        //0,3,1,4,2,5
        for(int i=0,j=1,idx=0; i<res.length; i+=2,j+=2,idx++,n++) {
            res[i] = nums[idx];
            res[j] = nums[n];
            //i=0, j=1, idx=0, n=3   res[0] = nums[0] && res[1] = nums[3]
            //i=2, j=3, idx=1, n=4   res[2] = nums[1] && res[3] = nums[4]
            //i=4, j=5, idx=2, n=5   res[4] = nums[2] && res[5] = nums[5]

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{0,1,2,3,4,5}, 3)));
    }
}

class KidWithGreatestCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for(int i=1; i<candies.length; i++) {
            if(candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<candies.length; i++) {
            if(candies[i]+extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }
}

class DecodeXORedArray {
    public static int[] decode(int[] encoded, int first) {
        int[] org = new int[encoded.length+1];
        org[0] = first;
        for(int i=0; i<encoded.length; i++) {
            org[i+1] = encoded[i]^org[i];
        }
        return org;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[]{1,2,3}, 1)));
    }
}

class RunningSumOf1dArray {
    public static int[] runningSum(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            output[i] = output[i-1]+nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1,1,1,1,1})));
    }
}

class FindHighestAltitude {
    public static int largestAltitude(int[] gain) {
        int high=0;
        int curr=0;
        for(int i=0; i<gain.length; i++) {
            curr += gain[i];
            if(high < curr) {
                high = curr;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7}));
    }
}


//A pair (i, j) is called good if nums[i] == nums[j] and i < j.
class GoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> countNumMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(countNumMap.containsKey(nums[i])) {
                int currValue = countNumMap.get(nums[i]);
                countNumMap.put(nums[i], currValue+1);
            } else {
                countNumMap.put(nums[i], 1);
            }
        }

        int count = 0;
        for(int key : countNumMap.keySet()) {
            if(countNumMap.get(key) > 1) {
                int countOfNum = countNumMap.get(key);
                count += (countOfNum*(countOfNum-1))/2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }
}

class RingsAndRods {
    public static int countPoints(String rings) {
        List<Boolean[]> output = new ArrayList<>();
        for(int i=0; i<9; i++) {
            output.add(new Boolean[]{false,false,false});
        }
        for(int i=1; i<rings.length(); i+=2) {
            int currRodNum = Integer.parseInt(rings.charAt(i)+"");
            String currColor = rings.charAt(i-1)+"";
            System.out.println("*"+currRodNum + " -- " + currColor);

            Boolean[] currVal = output.get(currRodNum);
            System.out.println("**"+Arrays.toString(currVal));

            if(currColor.equals("R")) {
                currVal[0] = true;
            } else if(currColor.equals("G")) {
                currVal[1] = true;
            } else {
                currVal[2] = true;
            }
            System.out.println("**"+Arrays.toString(currVal));
            output.set(currRodNum, currVal);


            /*
            String currRod = output.get(Integer.parseInt(rings.charAt(i)+""));

            if(null == curr || "".equals(curr))
                output.put(Integer.parseInt(rings.charAt(i)+""), rings.charAt(i-1)+"");
            else {
                output.put(Integer.parseInt(rings.charAt(i)+""), curr+rings.charAt(i-1));
            }*/
        }

        //System.out.println(Arrays.toString(output));
        int count = 0;
        for(Boolean[] valArray : output) {
            if(!Arrays.asList(valArray).contains(false)) {
                count++;
            }
        }



        /*
        for(Integer key : output.keySet()) {
            String colors = output.get(key);
            if(colors.contains("R") && colors.contains("G") && colors.contains("B")) {
                count++;
            }
        }*/

        return count;
    }

    public static void main(String[] args) {
        //System.out.println(countPoints("B0B6G0R6R0R6G9"));
        String s = "abcdefg";
        char[] c = new char[]{'s','d','f','g'};
        String w = String.valueOf(c);
        System.out.println(w);

    }
}
class AddDigits {


    static int sum = 0;
    public static int addDigits(int num) {
        if(!isSingleDigit(num)) {
            sum = sum+num%10;
            num = num/10;
            addDigits(num);
        }
        int finalSum = sum+num;
        if(!isSingleDigit(finalSum)) {
            sum=0;
            addDigits(finalSum);
        }
        return finalSum;

        /*
        do {
            sum += num%10;
            num = num/10;
        }while(!isSingleDigit(num));
        sum+=num;

        if(!isSingleDigit(sum)) {
            addDigits(sum);
        }
        return sum;*/
    }

    private static boolean isSingleDigit(int num) {
        if(num/10 == 0) {
            return true;
        }
        return false;
    }

    public static int countStudents(List<Integer> students, List<Integer> sandwiches) {

        int j=0;
        List<Integer> traversedStudents = new ArrayList<>();
        for(int i=0, k=0; k<students.size();k++) {

            System.out.println("j="+ j + " -- " + sandwiches.get(j));
            System.out.println("i="+ i + " -- " + students.get(i));
            System.out.println(students.size());

            if(sandwiches.get(j) == students.get(i)) {
                //i=0;
                j++;
                students.remove(students.get(i));
            } else {
                int currentStudent = students.get(i);
                System.out.println(currentStudent);
                System.out.println("Started"+students);
                students.remove(i);
                System.out.println("Intermediate"+students);
                students.add(currentStudent);
                System.out.println("Finished"+students);
            }
            System.out.println(students);
            System.out.println(sandwiches);
            System.out.println("--------------");
        }
        return students.size();
    }
    public static void main(String[] args) {
        countStudents(Arrays.asList(1,1,1,0,0,1), Arrays.asList(1,0,0,0,1,1));
    }


}

class SmallestLexicographicalString {
    public static String removeDuplicateLetters(String s) {

        Map<Character, Integer> charCount = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(charCount.containsKey(c)) {
                int currCount = charCount.get(c);
                charCount.put(c, currCount+1);
            } else {
                charCount.put(c, 1);
            }
        }

        Stack<Character> lex = new Stack<>();
        for(char c : s.toCharArray()) {
            charCount.put(c, charCount.get(c) - 1);

            if (lex.contains(c)) {
                continue;
            }

            while (!lex.isEmpty() && lex.peek() > c && charCount.get(lex.peek()) > 0) {
                lex.pop();
            }

            lex.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : lex) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }
}

class CountTrafficCollision {

    public static int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        int collisions = 0;

        for (char c : directions.toCharArray()) {
            // Handle 'R' (moving right)
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if(c == 'R') {
                    while (!stack.isEmpty()) {
                        if(stack.peek() == 'L') {
                            collisions += 2; // Head-on collision
                            stack.pop(); // Remove 'R' from the stack
                        } else if(stack.peek() == 'S') {
                            collisions += 1;
                            stack.pop();
                            break;
                        } else {
                            stack.pop();
                            break;
                        }

                    }
                    stack.push(c);
                }
                // Handle 'L' (moving left)
                else if (c == 'L') {
                    while (!stack.isEmpty()) {
                        if(stack.peek() == 'R') {
                            collisions += 2; // Head-on collision
                            stack.pop(); // Remove 'R' from the stack
                        } else if(stack.peek() == 'S') {
                            collisions += 1;
                            stack.pop();
                            break;
                        } else {
                            stack.pop();
                            break;
                        }

                    }
                    stack.push(c);
                    //stack.push(c); // Add 'L' to the stack
                }
                // Handle 'S' (stopped)
                else if (c == 'S') {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == 'R') {
                            collisions += 1; // R hits S
                            stack.pop(); // Remove 'R' from the stack
                        } else if (stack.peek() == 'L') {
                            collisions += 1; // L hits S
                            stack.pop(); // Remove 'L' from the stack
                            break; // Stop checking further for 'L' after it hits 'S'
                        } else {
                            stack.pop();
                            break; // No more relevant cars in the stack
                        }
                    }
                    stack.push(c);
                }
            }
            }



        return collisions;
    }

    public static void main(String[] args) {
        //RLRSLL

        String directions1 = "LSRRSLLRLS";
        System.out.println(countCollisions(directions1)); // Output: 5

        String directions2 = "LLRR";
        System.out.println(countCollisions(directions2)); // Output: 0
    }
}

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {

            int rem = target-nums[i];
            if(map.containsKey(rem)) {
                result[0] = i;
                result[1] = map.get(rem);
                break;
            }

            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }
}

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
 */
class ValidParantheses {
    public static void main(String[] args) {
        System.out.println( isValid("([)]"));
    }

    public static boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(c=='(' || c=='{' || c=='[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if(c==')' && top!='('
                    || c=='}' && top!='{'
                    || c==']' && top!='[') {
                    return false;
                }
            }
        }
        return true;
    }
}

class LongestValidParantheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Base index
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}

class BestTimeToSellAStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
    }

    public static int maxProfit(int[] prices) {
        //Below is incompetent solution with O(n^2) complexity.
        //For large set of data, it will take more time to process. ot it can go stackoverflow error.
        /*Set<Integer> results = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2) return -1;
                else if(o1 < o2) return 1;
                else return 0;
            }
        });
        results.add(0);
        for(int i=0; i<prices.length; i++) {
            for(int j=prices.length-1; j>=i; j--) {
                int diff = prices[j]-prices[i];
                if(diff >= 0)
                    results.add(diff);
            }
        }

        return results.iterator().next();
        */
        
        //Below is the optimized solution with O(n) complexity.
        //It is also called as Kadane's Algorithm.
        int buy = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            } else if(prices[i]-buy > profit) {
                profit = prices[i]-buy;
            }
        }
        return profit;
    }
}

class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        //a=97, z=122
        StringBuffer sb = new StringBuffer();
        for(char c : s.toCharArray()) {
            int asciiCode = (int)c;
            if(asciiCode>=97 && asciiCode<=122) {
                sb.append(c);
            }
        }
        if(sb.toString().equals(sb.reverse().toString()))
            return true;

        return false;
    }
}

class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(Character c : s.toCharArray()) {
           charCount.put(c, charCount.getOrDefault(c, 0)+1);
        }

        for(Character c : t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0)-1);
        }

        for(Character c : charCount.keySet()) {
            if(charCount.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}

class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
    }

    public static int search(int[] nums, int target) {
        int endIndex = nums.length-1;
        int startIndex = 0;
        while(startIndex <= endIndex) {
            int midIndex = (startIndex+endIndex)/2;
            if(nums[midIndex] == target) {
                return midIndex;
            } else {
                if(nums[midIndex] > target) {
                    endIndex = midIndex-1;
                } else {
                    startIndex = midIndex+1;
                }
            }
        }
        return -1;
    }
}
