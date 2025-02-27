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
    public static int longestSharedSubstring(String doc1, String doc2) {

        int[][] longest = new int[doc1.length() + 1][doc2.length() + 1];

        int count;
        int left;
        int up;


        for(int i = 0; i < doc1.length(); i++){
            for(int j = 0; j < doc2.length(); j++){
                count = 0;
                left = 0;
                up = 0;

                // Checks if the current characters are equal
                if(doc1.charAt(i) == doc2.charAt(j)){
                    count += 1;
                }

                // Find the value of the cell above
                if((i - 1) >= 0){
                    up = longest[i - 1][j];
                }

                // Find the value of the cell to the left
                if((j - 1) >= 0){
                    left = longest[i][j - 1];
                }

                count += Math.max(up, left);

                if (count > Math.min((i + 1), (j + 1))){
                    count = Math.min(i, j);
                }
                longest[i][j] = count;
            }
        }
        return longest[doc1.length() - 1][doc2.length() - 1];
    }
}
