class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> uniqueVals = new HashSet<>();
        int res = 0;

        for(int n : nums){
            uniqueVals.add(n);
        }

        for(int num : nums){
            if(!uniqueVals.contains(num - 1)){
                int length = 1;
                while(uniqueVals.contains(num + length)){
                    length ++;
                }

                if(res < length){
                    res = length;
                }
            }
        }

        return res;

        

    }
}
