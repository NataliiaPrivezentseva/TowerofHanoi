import java.util.Scanner;

class Input {

    int getTowerHeightFromUser(){
        int towerHeight;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Please, enter the height of the tower. It must be positive integer");

            while (!input.hasNextInt()) {
                String usersInput = input.next();
                System.out.println(usersInput + " — improper value of the height of the tower. " +
                        "Please, enter the proper height of the tower");
            }
            towerHeight = input.nextInt();

        } while (towerHeight <= 0);

        return towerHeight;
    }
}
