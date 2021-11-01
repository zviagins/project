package InterviewQuestions;

import java.util.*;

class Twitter {

    Map<Integer, Queue<Integer>> usersTweets;
    Map<Integer, List<Integer>> usersFollowings; //key user and users he is following

    /** Initialize your data structure here. */
    public Twitter() {
        this.usersTweets = new HashMap<>();
        this.usersFollowings = new HashMap<>();
    }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if (!usersTweets.containsKey(userId))
                usersTweets.put(userId, new LinkedList<>());

            usersTweets.get(userId).add(tweetId);
        }



        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {

            List<Integer> allTweets = new LinkedList<>(usersTweets.get(userId));
            if (usersFollowings.get(userId) != null) {
                for (Integer followingId : usersFollowings.get(userId)) {
                    allTweets.addAll(usersTweets.get(followingId));
                }
            }
            Collections.sort(allTweets, Collections.reverseOrder());
            if (allTweets.size() > 10)
                return allTweets.subList(0, 9);
            return allTweets;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (!usersFollowings.containsKey(followerId))
                usersFollowings.put(followerId, new LinkedList<>());
            usersFollowings.get(followerId).add(followeeId);

        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            usersFollowings.get(followerId).remove(new Integer(followeeId));
        }


        public static void main(String[] args){
Twitter twitter = new Twitter();
// User 1 posts a new tweet (id = 5).
            twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
            twitter.getNewsFeed(1);

// User 1 follows user 2.
            twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
            twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
            twitter.getNewsFeed(1);

// User 1 unfollows user 2.
            twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
            twitter.getNewsFeed(1);

        }
    }


