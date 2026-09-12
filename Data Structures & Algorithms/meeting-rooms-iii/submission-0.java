class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] rooms = new int[n];
        PriorityQueue<int[]> usedRooms = 
            new PriorityQueue<>((a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < meetings.length; i++) {
            int[] cur = meetings[i];
            while (!usedRooms.isEmpty() && usedRooms.peek()[1] <= cur[0]) {
                availableRooms.add(usedRooms.remove()[0]);
            }

            if (!availableRooms.isEmpty()) {
                int nextRoom = availableRooms.remove();
                rooms[nextRoom]++;
                usedRooms.add(new int[]{nextRoom, cur[1]});
            } else {
                int[] nextPendingRoom = usedRooms.remove();
                rooms[nextPendingRoom[0]]++;
                nextPendingRoom[1] += (cur[1] - cur[0]);
                usedRooms.add(nextPendingRoom);
            }
        }

        int most = 0;
        int maxBookings = 0;
        for (int i = 0; i < n; i++) {
            if (rooms[i] > maxBookings) {
                maxBookings = rooms[i];
                most = i;
            }
        }
        return most;
    }
}