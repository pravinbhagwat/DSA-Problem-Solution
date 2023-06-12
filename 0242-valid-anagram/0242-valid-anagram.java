class Solution {

    // TC- n*Logn, SC- s.length+t.length
    public boolean isAnagram1(String s, String t) {
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

    // TC - N, SC- N
    public boolean isAnagram(String s, String t) {
       Map<Character, Integer> countMap = new HashMap<>();

       for(int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);
           countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
       }

       for(int i = 0; i < t.length(); i++) {
           char ch = t.charAt(i);
           if(!countMap.containsKey(ch)) return false;
           if(countMap.get(ch) == 1) countMap.remove(ch);
           else {
               countMap.put(ch, countMap.get(ch)-1);
           }
       }

       return countMap.size() == 0;
    }
}