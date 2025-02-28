/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Liliana Dhaliwal
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */

    public static String firstDoc;
    public static String secondDoc;

    public static int longestSharedSubstring(String doc1, String doc2) {
        int[][] longest = new int[doc1.length() + 1][doc2.length() + 1];

        firstDoc = doc1;
        secondDoc = doc2;

        int left;
        int up;

        for(int i = 1; i <= doc1.length(); i++){
            for(int j = 1; j <= doc2.length(); j++){
                // Checks if the current characters are equal
                if(doc1.charAt(i - 1) == doc2.charAt(j - 1)){
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                }
                else{
                    up = longest[i - 1][j];
                    left = longest[i][j - 1];

                    longest[i][j] = Math.max(up, left);
                }
            }
        }

        String substring = String.valueOf(findSubstring(longest, doc1.length(), doc2.length(), longest[doc1.length()][doc2.length()], new StringBuilder()));

        System.out.println(substring);

        // Returns the longest count
        return longest[doc1.length()][doc2.length()];
    }

    public static StringBuilder findSubstring(int[][] longest, int i, int j, int current, StringBuilder substring){
        if(longest[i][j] == 0){
            return substring;
        }

        if(firstDoc.charAt(i - 1) == secondDoc.charAt(j - 1)){
            substring.insert(0, secondDoc.charAt(j - 1));
            return findSubstring(longest, i - 1, j - 1, longest[i - 1][j - 1], substring);
        }

        int up = longest[i - 1][j];
        int left = longest[i][j - 1];

        if(up == current){
            substring.insert(0, firstDoc.charAt(i - 1));
            return findSubstring(longest, i - 1, j, up, substring);
        }
        if(left == current){
            substring.insert(0, secondDoc.charAt(j - 1));
            return findSubstring(longest, i, j - 1, left, substring);
        }

        return substring;
    }


    // Original Problem (just find length):
//    public static int longestSharedSubstring(String doc1, String doc2) {
//        int[][] longest = new int[doc1.length() + 1][doc2.length() + 1];
//
//        int left;
//        int up;
//
//        for(int i = 1; i <= doc1.length(); i++){
//            for(int j = 1; j <= doc2.length(); j++){
//                // Checks if the current characters are equal
//                if(doc1.charAt(i - 1) == doc2.charAt(j - 1)){
//                    longest[i][j] = longest[i - 1][j - 1] + 1;
//                }
//                else{
//                    up = longest[i - 1][j];
//                    left = longest[i][j - 1];
//
//                    longest[i][j] = Math.max(up, left);
//                }
//            }
//        }
//
//        // Returns the longest count
//        return longest[doc1.length()][doc2.length()];
//    }
}
