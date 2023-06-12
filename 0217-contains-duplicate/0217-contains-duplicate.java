class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> myHashMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            myHashMap.put(nums[i], myHashMap.getOrDefault(nums[i], 0)+1);
            if(myHashMap.get(nums[i]) > 1) return true;
        }

        return false;
    }
}