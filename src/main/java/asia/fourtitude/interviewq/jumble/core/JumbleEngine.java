package asia.fourtitude.interviewq.jumble.core;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class JumbleEngine {
	

    /**
     * From the input `word`, produces/generates a copy which has the same
     * letters, but in different ordering.
     *
     * Example: from "elephant" to "aeehlnpt".
     *
     * Evaluation/Grading:
     * a) pass unit test: JumbleEngineTest#scramble()
     * b) scrambled letters/output must not be the same as input
     *
     * @param word  The input word to scramble the letters.
     * @return  The scrambled output/letters.
     */
    public String scramble(String word) {
    	  if (word == null || word.length() < 2) {
    	        return word;  // If the word is null or too short, return as-is
    	    }
    	    List<Character> characters = new ArrayList<>();
    	    for (char c : word.toCharArray()) {
    	        characters.add(c);
    	    }
    	    Collections.shuffle(characters);
    	    
    	    StringBuilder scrambled = new StringBuilder();
    	    for (char c : characters) {
    	        scrambled.append(c);
    	    }
    	    
    	    String scrambledWord = scrambled.toString();
    	    
    	    // Ensure the scrambled word is different from the original
    	    if (scrambledWord.equals(word)) {
    	        return scramble(word);
    	    }
    	    
    	    return scrambledWord;
//        throw new UnsupportedOperationException("to be implemented");
    }

    /**
     * Retrieves the palindrome words from the internal
     * word list/dictionary ("src/main/resources/words.txt").
     *
     * Word of single letter is not considered as valid palindrome word.
     *
     * Examples: "eye", "deed", "level".
     *
     * Evaluation/Grading:
     * a) able to access/use resource from classpath
     * b) using inbuilt Collections
     * c) using "try-with-resources" functionality/statement
     * d) pass unit test: JumbleEngineTest#palindrome()
     *
     * @return  The list of palindrome words found in system/engine.
     * @see https://www.google.com/search?q=palindrome+meaning
     */
    public Collection<String> retrievePalindromeWords() {
        List<String> palindromes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("words.txt")))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.trim().toLowerCase();
                if (word.length() > 1 && word.equals(new StringBuilder(word).reverse().toString())) {
                    palindromes.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return palindromes;
    }

    /**
     * Picks one word randomly from internal word list.
     *
     * Evaluation/Grading:
     * a) pass unit test: JumbleEngineTest#randomWord()
     * b) provide a good enough implementation, if not able to provide a fast lookup
     * c) bonus points, if able to implement a fast lookup/scheme
     *
     * @param length  The word picked, must of length.
     * @return  One of the word (randomly) from word list.
     *          Or null if none matching.
     */
    public String pickOneRandomWord(Integer length) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("words.txt")))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.trim();
                if (length == null || word.length() == length) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (words.isEmpty()) {
            return null;
        }
        
        return words.get(new Random().nextInt(words.size()));
    }

    /**
     * Checks if the `word` exists in internal word list.
     * Matching is case insensitive.
     *
     * Evaluation/Grading:
     * a) pass related unit tests in "JumbleEngineTest"
     * b) provide a good enough implementation, if not able to provide a fast lookup
     * c) bonus points, if able to implement a fast lookup/scheme
     *
     * @param word  The input word to check.
     * @return  true if `word` exists in internal word list.
     */
    public boolean exists(String word) {
    	  if (word == null || word.trim().isEmpty()) {
    	        return false;
    	    }
    	    String lowerCaseWord = word.toLowerCase().trim();
    	    try (BufferedReader reader = new BufferedReader(
    	            new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("words.txt")))) {
    	        String line;
    	        while ((line = reader.readLine()) != null) {
    	            if (line.trim().equalsIgnoreCase(lowerCaseWord)) {
    	                return true;
    	            }
    	        }
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    	    return false;
    }

    /**
     * Finds all the words from internal word list which begins with the
     * input `prefix`.
     * Matching is case insensitive.
     *
     * Invalid `prefix` (null, empty string, blank string, non letter) will
     * return empty list.
     *
     * Evaluation/Grading:
     * a) pass related unit tests in "JumbleEngineTest"
     * b) provide a good enough implementation, if not able to provide a fast lookup
     * c) bonus points, if able to implement a fast lookup/scheme
     *
     * @param prefix  The prefix to match.
     * @return  The list of words matching the prefix.
     */
    public Collection<String> wordsMatchingPrefix(String prefix) {
        List<String> matchingWords = new ArrayList<>();
        if (prefix == null || prefix.trim().isEmpty() || !prefix.matches("[a-zA-Z]+")) {
            return matchingWords; // Return empty list for invalid prefix
        }
        
        prefix = prefix.trim().toLowerCase();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("words.txt")))) {
            String word;
            while ((word = reader.readLine()) != null) {
                if (word.toLowerCase().startsWith(prefix)) {
                    matchingWords.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return matchingWords;
    }

    /**
     * Finds all the words from internal word list that is matching
     * the searching criteria.
     *
     * `startChar` and `endChar` must be 'a' to 'z' only. And case insensitive.
     * `length`, if have value, must be positive integer (>= 1).
     *
     * Words are filtered using `startChar` and `endChar` first.
     * Then apply `length` on the result, to produce the final output.
     *
     * Must have at least one valid value out of 3 inputs
     * (`startChar`, `endChar`, `length`) to proceed with searching.
     * Otherwise, return empty list.
     *
     * Evaluation/Grading:
     * a) pass related unit tests in "JumbleEngineTest"
     * b) provide a good enough implementation, if not able to provide a fast lookup
     * c) bonus points, if able to implement a fast lookup/scheme
     *
     * @param startChar  The first character of the word to search for.
     * @param endChar    The last character of the word to match with.
     * @param length     The length of the word to match.
     * @return  The list of words matching the searching criteria.
     */
    public Collection<String> searchWords(Character startChar, Character endChar, Integer length) {
    	 List<String> matchingWords = new ArrayList<>();
    	    
    	    // If all parameters are null, return an empty list immediately
    	    if (startChar == null && endChar == null && length == null) {
    	        return matchingWords;
    	    }
    	    
    	    try (BufferedReader reader = new BufferedReader(
    	            new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("words.txt")))) {
    	        String word;
    	        while ((word = reader.readLine()) != null) {
    	            word = word.trim();
    	            boolean matches = true;
    	            
    	            if (startChar != null && !word.toLowerCase().startsWith(startChar.toString().toLowerCase())) {
    	                matches = false;
    	            }
    	            if (endChar != null && !word.toLowerCase().endsWith(endChar.toString().toLowerCase())) {
    	                matches = false;
    	            }
    	            if (length != null && word.length() != length) {
    	                matches = false;
    	            }
    	            
    	            if (matches) {
    	                matchingWords.add(word);
    	            }
    	        }
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    	    
    	    return matchingWords;
    }

    /**
     * Generates all possible combinations of smaller/sub words using the
     * letters from input word.
     *
     * The `minLength` set the minimum length of sub word that is considered
     * as acceptable word.
     *
     * If length of input `word` is less than `minLength`, then return empty list.
     *
     * Example: From "yellow" and `minLength` = 3, the output sub words:
     *     low, lowly, lye, ole, owe, owl, well, welly, woe, yell, yeow, yew, yowl
     *
     * Evaluation/Grading:
     * a) pass related unit tests in "JumbleEngineTest"
     * b) provide a good enough implementation, if not able to provide a fast lookup
     * c) bonus points, if able to implement a fast lookup/scheme
     *
     * @param word       The input word to use as base/seed.
     * @param minLength  The minimum length (inclusive) of sub words.
     *                   Expects positive integer.
     *                   Default is 3.
     * @return  The list of sub words constructed from input `word`.
     */
    
    public Collection<String> generateSubWords(String word, Integer minLength) {
        Set<String> subWords = new HashSet<>();

        // If word is null, empty, or minLength is invalid, return an empty list
        if (word == null || word.trim().isEmpty() || (minLength != null && minLength <= 0)) {
            return subWords;
        }

        // Set default minLength to 3 if it is null
        if (minLength == null) {
            minLength = 3;
        }

        word = word.trim().toLowerCase();

        // If word length is less than minLength, return an empty list
        if (word.length() < minLength) {
            return subWords;
        }

        // Generate subwords and filter them
        Set<String> dictionary = loadDictionary();
        generateSubWordsHelper(word, "", subWords, minLength, dictionary);

        // Remove the original word if it's in the set
        subWords.remove(word);

        return subWords;
    }

    private void generateSubWordsHelper(String remaining, String current, Set<String> subWords, int minLength, Set<String> dictionary) {
        if (current.length() >= minLength && dictionary.contains(current) && isValidSubWord(remaining + current, current)) {
            subWords.add(current);
        }

        for (int i = 0; i < remaining.length(); i++) {
            generateSubWordsHelper(
                remaining.substring(0, i) + remaining.substring(i + 1),
                current + remaining.charAt(i),
                subWords,
                minLength,
                dictionary
            );
        }
    }

    private boolean isValidSubWord(String originalWord, String subWord) {
        // Check if subWord uses at least half of its letters from the original word
        int commonLetters = 0;
        for (char c : subWord.toCharArray()) {
            if (originalWord.indexOf(c) != -1) {
                commonLetters++;
                originalWord = originalWord.replaceFirst(String.valueOf(c), "");
            }
        }
        return commonLetters >= Math.ceil(subWord.length() / 2.0);
    }

    private Set<String> loadDictionary() {
        Set<String> dictionary = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("words.txt")))) {
            String word;
            while ((word = reader.readLine()) != null) {
                dictionary.add(word.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    /**
     * Creates a game state with word to guess, scrambled letters, and
     * possible combinations of words.
     *
     * Word is of length 6 characters.
     * The minimum length of sub words is of length 3 characters.
     *
     * @param length     The length of selected word.
     *                   Expects >= 3.
     * @param minLength  The minimum length (inclusive) of sub words.
     *                   Expects positive integer.
     *                   Default is 3.
     * @return  The game state.
     */
    public GameState createGameState(Integer length, Integer minLength) {
        Objects.requireNonNull(length, "length must not be null");
        if (minLength == null) {
            minLength = 3;
        } else if (minLength <= 0) {
            throw new IllegalArgumentException("Invalid minLength=[" + minLength + "], expect positive integer");
        }
        if (length < 3) {
            throw new IllegalArgumentException("Invalid length=[" + length + "], expect greater than or equals 3");
        }
        if (minLength > length) {
            throw new IllegalArgumentException("Expect minLength=[" + minLength + "] greater than length=[" + length + "]");
        }
        String original = this.pickOneRandomWord(length);
        if (original == null) {
            throw new IllegalArgumentException("Cannot find valid word to create game state");
        }
        String scramble = this.scramble(original);
        Map<String, Boolean> subWords = new TreeMap<>();
        for (String subWord : this.generateSubWords(original, minLength)) {
            subWords.put(subWord, Boolean.FALSE);
        }
        return new GameState(original, scramble, subWords);
    }
    
    public String getValidSubWord(String originalWord) {
        Collection<String> subWords = generateSubWords(originalWord, 3);
        if (!subWords.isEmpty()) {
            return subWords.iterator().next();
        }
        return null;
    }

    public String[] getAllValidSubWords(String originalWord) {
        Collection<String> subWords = generateSubWords(originalWord, 3);
        return subWords.toArray(new String[0]);
    }

}
