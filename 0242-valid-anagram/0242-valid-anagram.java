class Solution {
    public boolean isAnagram(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        
        Arrays.sort(array1);
        Arrays.sort(array2);

        // System.out.println(array1[0] + " " + array2[0]);
        s = Arrays.toString(array1);
        t = Arrays.toString(array2);
        
        if(s.equals(t)) return true;
        return false;
    }
}