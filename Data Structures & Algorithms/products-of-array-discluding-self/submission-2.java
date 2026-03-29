class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        
        // Compute prefix products
        products[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }

        // Compute suffix products
        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            products[i] *= suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }
        return products;
    }
}  
