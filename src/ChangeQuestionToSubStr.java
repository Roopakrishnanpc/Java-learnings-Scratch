import java.io.*;

class Result {

    public static String getSmallestString(String word, String substr) {
        int wordLength = word.length();
        int substrLength = substr.length();
        
        // Check if substr is longer than word
        if (substrLength > wordLength) {
            return "-1";
        }

        String result = null;

        for (int i = 0; i <= wordLength - substrLength; i++) {
            // Create a new version of the word with the substring initially
            StringBuilder newWord = new StringBuilder(word);
            boolean canInsert = true;

            // Attempt to insert the substring at position i
            for (int j = 0; j < substrLength; j++) {
                char currentChar = newWord.charAt(i + j);
                
                if (currentChar == '?') {
                    newWord.setCharAt(i + j, substr.charAt(j)); // Replace with substr char
                } else if (currentChar != substr.charAt(j)) {
                    canInsert = false; // Can't insert if there's a mismatch
                    break; 
                }
            }

            // Proceed only if insertion is valid
            if (canInsert) {
                // Replace remaining '?' with 'a'
                for (int j = 0; j < newWord.length(); j++) {
                    if (newWord.charAt(j) == '?') {
                        newWord.setCharAt(j, 'a');
                    }
                }

                String lexicographicallySmallest = newWord.toString();

                // Update result with the smallest string
                if (result == null || lexicographicallySmallest.compareTo(result) < 0) {
                    result = lexicographicallySmallest;
                }
            }
        }

        return result != null ? result : "-1";
    }

    public static String anotherMethodtoReplace(String word, String substr) {
        // Similar logic can be implemented here if needed
    	int wordLength = word.length();
    int substrLength = substr.length();
    String result = null;

    for (int i = 0; i <= wordLength - substrLength; i++) {
        StringBuilder newWord = new StringBuilder(word);

        // Attempt to insert the substring at position i
        for (int j = 0; j < substrLength; j++) {
        	System.out.println("i="+i+" & ");
        	System.out.println("j="+j);
        	
            char currentChar = newWord.charAt(i + j);
            //System.out.println(currentChar);
            if (newWord.charAt(i+j) == '?') {
            	System.out.println(j+i+"Joined "+i+j);
            	
                newWord.setCharAt(i+j, substr.charAt(j));
                System.out.println(newWord);
            } else if (currentChar != substr.charAt(j)) {
            	System.out.println("Break");
            	break; // Can't insert if there's a mismatch
            }
        }

        // Replace remaining '?' with 'a'
        for (int j = 0; j < newWord.length(); j++) {
            if (newWord.charAt(j) == '?') {
                newWord.setCharAt(j, 'a');
            }
        }

        String lexicographicallySmallest = newWord.toString();

        // Update result with the smallest string
        if (result == null || lexicographicallySmallest.compareTo(result) < 0) {
            result = lexicographicallySmallest;
        }
    }

    return result != null ? result : "-1";
    }
}

public class ChangeQuestionToSubStr {
    public static void main(String[] args) {
        String word = "s?hS?t?uv??";
        String substr = "mh";
        String result = Result.getSmallestString(word, substr);
        System.out.println(result); // Expected result: "sshShtjuvsa"
        
        // Call another method to test it as well
        String anotherResult = Result.anotherMethodtoReplace(word, substr);
        System.out.println(anotherResult); // Should match the output of the main method
    }
}
//another method

//public static String getSmallestString(String word, String substr) {
//    int wordLength = word.length();
//    int substrLength = substr.length();
//    String result = null;
//
//    for (int i = 0; i <= wordLength - substrLength; i++) {
//        boolean canInsert = true;
//
//        // Check if we can insert the substring at position i
//        for (int j = 0; j < substrLength; j++) {
//            char currentChar = word.charAt(i + j);
//            char substrChar = substr.charAt(j);
//
//            if (currentChar != '?' && currentChar != substrChar) {
//                canInsert = false;
//                break;
//            }
//        }
//
//        if (canInsert) {
//            // Create a new version of the word with the substring inserted
//            StringBuilder newWord = new StringBuilder(word);
//            for (int j = 0; j < substrLength; j++) {
//                newWord.setCharAt(i + j, substr.charAt(j));
//            }
//
//            // Replace all remaining '?' with 'a'
//            for (int j = 0; j < newWord.length(); j++) {
//                if (newWord.charAt(j) == '?') {
//                    newWord.setCharAt(j, 'a');
//                }
//            }
//
//            String lexicographicallySmallest = newWord.toString();
//
//            // Update result with the smallest string
//            if (result == null || lexicographicallySmallest.compareTo(result) < 0) {
//                result = lexicographicallySmallest;
//            }
//        }
//    }
//
//    return result != null ? result : "-1";
//}
//    public static String anotherMethodtoReplace(String word, String substr) {
//    	 int wordLength = word.length();
//         int substrLength = substr.length();
//         String result = null;
//
//         for (int i = 0; i <= wordLength - substrLength; i++) {
//             // Create a new version of the word with the substring initially
//             StringBuilder newWord = new StringBuilder(word);
//             boolean canInsert = true;
//
//             // Attempt to insert the substring at position i
//             for (int j = 0; j < substrLength; j++) {
//                 char currentChar = newWord.charAt(i + j);
//                 
//                 if (currentChar == '?') {
//                     newWord.setCharAt(i + j, substr.charAt(j));
//                 } else if (currentChar != substr.charAt(j)) {
//                     canInsert = false;
//                     break; // Can't insert if there's a mismatch
//                 }
//             }
//
//             // Proceed only if insertion is valid
//             if (canInsert) {
//                 // Replace remaining '?' with 'a'
//                 for (int j = 0; j < newWord.length(); j++) {
//                     if (newWord.charAt(j) == '?') {
//                         newWord.setCharAt(j, 'a');
//                     }
//                 }
//
//                 String lexicographicallySmallest = newWord.toString();
//
//                 // Update result with the smallest string
//                 if (result == null || lexicographicallySmallest.compareTo(result) < 0) {
//                     result = lexicographicallySmallest;
//                 }
//             }
//         }
//
//         return result != null ? result : "-1";
////        int wordLength = word.length();
////        int substrLength = substr.length();
////        String result = null;
////
////        for (int i = 0; i <= wordLength - substrLength; i++) {
////            StringBuilder newWord = new StringBuilder(word);
////
////            // Attempt to insert the substring at position i
////            for (int j = 0; j < substrLength; j++) {
////            	System.out.println("i="+i+" & ");
////            	System.out.println("j="+j);
////            	
////                char currentChar = newWord.charAt(i + j);
////                //System.out.println(currentChar);
////                if (newWord.charAt(i+j) == '?') {
////                	System.out.println(j+i+"Joined "+i+j);
////                	
////                    newWord.setCharAt(i+j, substr.charAt(j));
////                    System.out.println(newWord);
////                } else if (currentChar != substr.charAt(j)) {
////                	System.out.println("Break");
////                	break; // Can't insert if there's a mismatch
////                }
////            }
////
////            // Replace remaining '?' with 'a'
////            for (int j = 0; j < newWord.length(); j++) {
////                if (newWord.charAt(j) == '?') {
////                    newWord.setCharAt(j, 'a');
////                }
////            }
////
////            String lexicographicallySmallest = newWord.toString();
////
////            // Update result with the smallest string
////            if (result == null || lexicographicallySmallest.compareTo(result) < 0) {
////                result = lexicographicallySmallest;
////            }
////        }
////
////        return result != null ? result : "-1";
//    }
//}
