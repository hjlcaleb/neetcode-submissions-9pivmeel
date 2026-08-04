class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int leftProduct = 1;
        products[0] = 1;
        for (int i = 1; i < products.length; i++) {
            leftProduct *= nums[i - 1];
            products[i] = leftProduct;
        }

        int rightProduct = 1;
        for (int i = products.length - 2; i >= 0; i--) {
            rightProduct *= nums[i + 1];
            products[i] *= rightProduct;
        }

        return products;
    }
}  
