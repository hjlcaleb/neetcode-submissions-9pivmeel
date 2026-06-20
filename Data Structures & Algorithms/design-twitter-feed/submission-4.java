class Twitter {
    public static int time;
    private Map<Integer, ArrayList<int[]>> posts;
    private Map<Integer, Set<Integer>> following;
    
    public Twitter() {
        time = 0;
        posts = new HashMap<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!posts.containsKey(userId)) {
            posts.put(userId, new ArrayList<>());
        }
        posts.get(userId).add(new int[]{tweetId, time++});
        if (posts.get(userId).size() > 10) {
            posts.get(userId).remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        Set<Integer> users = new HashSet<>();
        if (following.containsKey(userId)) users.addAll(following.get(userId));
        users.add(userId);
        
        for (int user : users) {
            List<int[]> userPosts = posts.get(user);
            if (userPosts != null && !userPosts.isEmpty()) {
                int lastIdx = userPosts.size() - 1;
                int[] tweet = userPosts.get(lastIdx);
                maxHeap.add(new int[]{tweet[0], tweet[1], user, lastIdx});
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            int[] top = maxHeap.poll();
            feed.add(top[0]);

            int prevIdx = top[3] - 1;
            if (prevIdx >= 0) {
                int[] nextTweet = posts.get(top[2]).get(prevIdx);
                maxHeap.add(new int[]{nextTweet[0], nextTweet[1], top[2], prevIdx});
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
