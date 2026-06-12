class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] balance = new int[3];
        int customer = 0;
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                balance[0]++;
            } else if (bill == 10) {
                balance[1]++;
                if (balance[0] == 0) {
                    return false;
                }
                balance[0] --;
            } else if (bill == 20) {
                if (balance[1] >= 1 && balance[0] >= 1) {
                    balance[1] --;
                    balance[0] --;
                } else if (balance[0] >= 3){
                    balance[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}