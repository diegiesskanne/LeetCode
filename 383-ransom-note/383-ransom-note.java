class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        String[] cs1 = ransomNote.split("");
        String[] cs2 = magazine.split("");
        for (String s : cs1) {
            boolean found = false;
            for (int j = 0; j < cs2.length; j++) {
                if (s.equals(cs2[j])) {
                    cs2[j] = "-";
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }
}