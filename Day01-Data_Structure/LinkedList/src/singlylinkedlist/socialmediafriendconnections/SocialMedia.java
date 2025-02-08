package singlylinkedlist.socialmediafriendconnections;
import java.util.ArrayList;
import java.util.List;
class SocialMedia {
    private UserNode head;

    // Add a user
    public void addUser (int userId, String name, int age) {
        UserNode newUser  = new UserNode(userId, name, age);
        newUser .next = head;
        head = newUser ;
    }

    // Add a friend connection between two users
    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUser (userId1);
        UserNode user2 = findUser (userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        addFriendToList(user1, userId2);
        addFriendToList(user2, userId1);
    }

    private void addFriendToList(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friendsHead;
        user.friendsHead = newFriend;
    }

    // Remove a friend connection
    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUser (userId1);
        UserNode user2 = findUser (userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        removeFriendFromList(user1, userId2);
        removeFriendFromList(user2, userId1);
    }

    private void removeFriendFromList(UserNode user, int friendId) {
        FriendNode current = user.friendsHead;
        FriendNode previous = null;
        while (current != null && current.friendId != friendId) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Friend ID " + friendId + " not found for user ID " + user.userId);
            return;
        }
        if (previous == null) {
            user.friendsHead = current.next; // Deleting the head of the friends list
        } else {
            previous.next = current.next; // Bypass the current node
        }
    }

    // Find mutual friends between two users
    public List<Integer> findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUser (userId1);
        UserNode user2 = findUser (userId2);
        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return mutualFriends;
        }
        FriendNode friend1 = user1.friendsHead;
        while (friend1 != null) {
            if (isFriend(user2, friend1.friendId)) {
                mutualFriends.add(friend1.friendId);
            }
            friend1 = friend1.next;
        }
        return mutualFriends;
    }

    private boolean isFriend(UserNode user, int friendId) {
        FriendNode current = user.friendsHead;
        while (current != null) {
            if (current.friendId == friendId) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUser (userId);
        if (user == null) {
            System.out.println("User  ID " + userId + " not found.");
            return;
        }
        
        FriendNode current = user.friendsHead;
        if (current == null) {
            System.out.println("No friends found.");
            return;
        }

        List<String> friendNames = new ArrayList<>();
        while (current != null) {
            UserNode friend = findUser (current.friendId);
            if (friend != null) {
                friendNames.add(friend.name);
            }
            current = current.next;
        }
        
        System.out.println("Friends of " + user.name + ": "+String.join(", ", friendNames));
    }
    // Search for a user by Name or User ID
    public UserNode searchUser (String nameOrId) {
        try {
            int userId = Integer.parseInt(nameOrId);
            return findUser (userId);
        } catch (NumberFormatException e) {
            return findUserByName(nameOrId);
        }
    }

    private UserNode findUser (int userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private UserNode  findUserByName(String name) {
        UserNode current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode current = head;
        while (current != null) {
            int count = 0;
            FriendNode friendCurrent = current.friendsHead;
            while (friendCurrent != null) {
                count++;
                friendCurrent = friendCurrent.next;
            }
            System.out.println("User  ID " + current.userId + " has " + count + " friends.");
            current = current.next;
        }
    }
}