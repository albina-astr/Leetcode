package design;

import java.util.*;

public class Twitter {
    Map<Integer, User> users;
    static int timestamp = 0;

    public Twitter() {
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        users.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) {
            return List.of();
        }

        Queue<Tweet> pq = new PriorityQueue<>((a, b) -> b.ts - a.ts);
        Set<Integer> subs = users.get(userId).getSubscriptions();

        for (int sub : subs) {
            Tweet pre = users.get(sub).prehead;
            if (pre != null) {
                pq.offer(pre);
            }
        }
        List<Integer> res = new ArrayList<>();
        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            if (t.next != null) {
                pq.add(t.next);
            }
        }
        return res;
    }

    public void follow(int userId, int followeeId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }
        users.get(userId).subscribe(followeeId);
    }

    public void unfollow(int userId, int followeeId) {
        if (users.containsKey(userId) && userId != followeeId) {
            users.get(userId).unsubscribe(followeeId);
        }
    }

    private class Tweet {
        int id;
        int userId;
        int ts;
        Tweet next;

        public Tweet() {}

        public Tweet(int id, int userId) {
            this.id = id;
            this.userId = userId;
            this.ts = timestamp++;
        }
    }

    private class User {
        int id;
        Set<Integer> subscriptions;
        Tweet prehead;

        public User(int id) {
            this.id = id;
            this.subscriptions = new HashSet<>();
            subscribe(id);
            this.prehead = null;
        }

        public Set<Integer> getSubscriptions() {
            return subscriptions; //make immutable
        }

        public void subscribe(int followeeId) {
            subscriptions.add(followeeId);
        }

        public void unsubscribe(int followeeId) {
            subscriptions.remove(followeeId);
        }

        public void post(int tweetId) {
            Tweet t = new Tweet(tweetId, this.id);
            t.next = prehead;
            prehead = t;
        }
    }
}

