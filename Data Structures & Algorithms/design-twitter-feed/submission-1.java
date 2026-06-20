class Twitter {
    public static int time;
    private Map<Integer, PriorityQueue<int[]>> posts;
    private Map<Integer, Set<Integer>> following;
    
    public Twitter() {
        time = 0;
        posts = new HashMap<>();
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!posts.containsKey(userId)) {
            posts.put(userId, new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])));
        }
        posts.get(userId).add(new int[]{tweetId, time++});
        if (posts.get(userId).size() > 10) {
            posts.get(userId).remove();
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<int[]> sharedFeed = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> users = new HashSet<>();
        
        if (following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }
        users.add(userId);

        for (int user : users) {
            if (posts.containsKey(user)) {
                for (int[] post : posts.get(user)) {
                    sharedFeed.add(post);
                    if (sharedFeed.size() > 10) {
                        sharedFeed.remove();
                    }
                }
            }
        }

        while (!sharedFeed.isEmpty()) {
            feed.add(0, sharedFeed.remove()[0]);
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
