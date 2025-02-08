package singlylinkedlist.socialmediafriendconnections;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();
        
        // Adding users
        socialMedia.addUser (1, "Alice", 25);
        socialMedia.addUser (2, "Bob", 30);
        socialMedia.addUser (3, "Charlie", 22);
        socialMedia.addUser (4, "David", 28);
        socialMedia.addUser (5, "Eve", 27);
        
        // Adding friend connections
        socialMedia.addFriend(1, 2); // Alice <-> Bob
        socialMedia.addFriend(1, 3); // Alice <-> Charlie
        socialMedia.addFriend(2, 3); // Bob <-> Charlie (Mutual friend with Alice)
        socialMedia.addFriend(2, 4); // Bob <-> David
        socialMedia.addFriend(3, 4); // Charlie <-> David (Mutual friend with Bob)
        socialMedia.addFriend(4, 5); // David <-> Eve
        
        // Displaying friends
        socialMedia.displayFriends(1); // Should display Bob and Charlie
        
        socialMedia.displayFriends(2); // Should display Alice and Charlie, David
        
        socialMedia.displayFriends(3); // Should display Alice, Bob, and David
        
        // Finding mutual friends
        List<Integer> mutualFriends = socialMedia.findMutualFriends(1, 2); // Alice and Bob
        System.out.println("Mutual friends between Alice and Bob: " + mutualFriends); // Should be empty
        
        mutualFriends = socialMedia.findMutualFriends(2, 3); // Bob and Charlie
        System.out.println("Mutual friends between Bob and Charlie: " + mutualFriends); // Should be Charlie
        
        mutualFriends = socialMedia.findMutualFriends(1, 3); // Alice and Charlie
        System.out.println("Mutual friends between Alice and Charlie: " + mutualFriends); // Should be empty
        
        // Counting friends
        socialMedia.countFriends();
        
        // Removing a friend connection
        socialMedia.removeFriend(1, 2); // Remove Alice and Bob's friendship
        System.out.println("Friends of Alice after removing Bob:");
        socialMedia.displayFriends(1); // Should only display Charlie now
    }
}