//Use regex to find match and solve
class leetcode392Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        StringBuilder sb = new StringBuilder();
        sb.append(".*");
        for(int i =0; i<s.length(); i++){
            sb.append(s.charAt(i)).append(".*");
        }
        String regex = sb.toString();

        return t.matches(regex);
    }
}