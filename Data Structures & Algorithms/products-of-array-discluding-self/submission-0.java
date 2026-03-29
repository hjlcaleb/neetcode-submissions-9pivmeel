class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        //find our prefixes first
        int prefix = 1;
        for(int i = 0; i < nums.length; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }

        //find our postfixes
        int postfix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}  
