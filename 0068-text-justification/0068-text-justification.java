import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();
        int n = words.length;

        int wordsDone = 0;

        while (wordsDone < n) {

      
            int start = wordsDone;
            int end = start;
            int currLength = 0;

            while (end < n) {

                int wordLen = words[end].length();

    
                if (currLength + wordLen + (end - start) <= maxWidth) {
                    currLength += wordLen;
                    end++;
                } else {
                    break;
                }
            }


            int wordCount = end - start;
            int totalSpaces = maxWidth - currLength;

            StringBuilder line = new StringBuilder();

          
            if (end == n || wordCount == 1) {

                for (int i = start; i < end; i++) {

                    line.append(words[i]);

                    if (i < end - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            }

            else {

                int gaps = wordCount - 1;

                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int i = start; i < end; i++) {

                    line.append(words[i]);

                    if (i < end - 1) {

                        int spaces = spacesPerGap;

                     
                        if (i - start < extraSpaces) {
                            spaces++;
                        }

                        for (int j = 0; j < spaces; j++) {
                            line.append(" ");
                        }
                    }
                }
            }

            ans.add(line.toString());

         
            wordsDone = end;
        }

        return ans;
    }
}