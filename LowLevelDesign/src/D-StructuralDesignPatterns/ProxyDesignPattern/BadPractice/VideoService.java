package StructuralDesignPatterns.ProxyDesignPattern.BadPractice;

public class VideoService {
    public void playVideo(String userType, String videoName) {
        if (userType.equals("premium")) {
            System.out.println("Streaming premium video: " + videoName);
        } else if (userType.equals("free")) {
            System.out.println("Streaming free video: " + videoName);
        } else {
            System.out.println("Access denied: Invalid user type.");
        }
    }

}
