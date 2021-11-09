package array;/**
 * @author Weiyan Xiang on 2021/11/9
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1178. Number of Valid Words for Each Puzzle
 * <p>
 * https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/
 * <p>
 * my initial ans: TLE
 */
public class NumberOfValidWordsForEachPuzzle {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // process puzzles to be linkedHashMap, key is letter, value is 1
        // for each work, loop through letters, if fulfills, count++
        int[] ans = new int[puzzles.length];
        List<LinkedHashMap<Character, Integer>> maps = process(puzzles);
        for (String word : words) {
            for (int i = 0; i < maps.size(); i++) {
                if (isValid(word, maps.get(i))) ans[i]++;
            }
        }
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }

    private List<LinkedHashMap<Character, Integer>> process(String[] puzzles) {
        List<LinkedHashMap<Character, Integer>> ans = new ArrayList<>();
        for (String puz : puzzles) {
            LinkedHashMap<Character, Integer> newMap = new LinkedHashMap<>();
            for (int i = 0; i < puz.length(); i++) {
                char ch = puz.charAt(i);
                if (!newMap.containsKey(ch)) newMap.put(ch, 1);
            }
            ans.add(newMap);
        }
        return ans;
    }

    private boolean isValid(String word, Map<Character, Integer> puzzle) {
        char firstLetter = puzzle.entrySet().stream().findFirst().map(Map.Entry::getKey).orElse('&');
        boolean containsFirstLetter = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!puzzle.containsKey(ch)) return false;
            if (ch == firstLetter) containsFirstLetter = true;
        }
        return containsFirstLetter;
    }
}
