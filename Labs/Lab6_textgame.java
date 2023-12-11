package Labs;

import java.util.Scanner;
class Lab6_textgame {
    public static void main(String[] args) {
        Room spawnRoom = new Room("Spawn Room", new String[]{"next"});
        Room puzzleRoom1 = new Room("Puzzle Room 1", new String[]{"next"});
        Room puzzleRoom2 = new Room("Puzzle Room 2", new String[]{"next"});
        Room goalRoom = new Room("Goal Room", new String[]{"exit"});

        spawnRoom.setNextRoom(puzzleRoom1);
        puzzleRoom1.setNextRoom(puzzleRoom2);
        puzzleRoom2.setNextRoom(goalRoom);

        Room currentRoom = spawnRoom;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            currentRoom.displayRoom();
            System.out.print("Enter your action: ");
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "next":
                    if (currentRoom.getNextRoom() == null) {
                        System.out.println("You can't go that way.");
                    } else {
                        if (unlockRoom(currentRoom)) {
                            currentRoom = currentRoom.getNextRoom();
                        } else {
                            System.out.println("You need to solve the puzzle to proceed.");
                        }
                    }
                    break;
                case "exit":
                    System.out.println("You have exited the game.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }
        }
    }

    private static boolean unlockRoom(Room room) {
        Scanner scanner = new Scanner(System.in);

        if (room.getName().contains("Puzzle Room 1")) {
            System.out.print("What is 1 + 1? ");
            int userAnswer = scanner.nextInt();

            return userAnswer == 2;
        } else if (room.getName().contains("Puzzle Room 2")) {
            System.out.print("What is 2 + 2? ");
            int userAnswer = scanner.nextInt();

            return userAnswer == 4;
        } else {
            System.out.println("This room doesn't have a puzzle.");
            return true;
        }
    }
}

class Room {
    private String name;
    private Room nextRoom;
    private String[] validActions;

    public Room(String name, String[] validActions) {
        this.name = name;
        this.validActions = validActions;
    }

    public String getName() {
        return name;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public String[] getValidActions() {
        return validActions;
    }

    public void displayRoom() {
        System.out.println("You are in the " + name + ".");
        System.out.println("Valid actions: " + String.join(", ", validActions));
    }
}