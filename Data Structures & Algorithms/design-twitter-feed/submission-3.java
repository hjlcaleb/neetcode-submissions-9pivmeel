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
        List<int[]> allTweets = new ArrayList<>();
        
        if (posts.containsKey(userId)) {
            allTweets.addAll(posts.get(userId));
        }

        if (following.containsKey(userId)) {
            for (int followee : following.get(userId)) {
                if (posts.containsKey(followee)) {
                    allTweets.addAll(posts.get(followee));
                }
            }
        }

        allTweets.sort((a, b) -> Integer.compare(b[1], a[1]));

        List<Integer> feed = new ArrayList<>();
        for (int i = 0; i < Math.min(allTweets.size(), 10); i++) {
            feed.add(allTweets.get(i)[0]);
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
