package q;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class login {
    String name;
    int num;
    String email;
    String password;
    String re_password;
}

class discount_clothes {
    String sex[] = new String[]{"male", "male", "female", "male", "female", "male", "male", "female", "male", "male", "male", "female"};
    String name[] = new String[]{"pants", "shirt", "Baloot", "shoes", "shose", "T-shirt", "watch", "watch", "watch", "pants", "T-shirt", "hoodi"};
    String quality[] = new String[]{"hige", "hige", "very hige", "excellent", "hige", "very hige", "hige", "hige", "hige", "very hige", "excellent", "hige"};
    double price[] = new double[]{5.99, 3.99, 9.45, 7.89, 8.60, 6.99, 3.50, 4.99, 5.20, 8.25, 3.55, 4.0};
    String mark[] = new String[]{"PRADA", "GUCCI", "Queen", "Nike", "Adidas", "LACOSTE", "Rolex", "Rado", "Luxury", "Boss", "Mask", "Dior"};
    String color[] = new String[]{"blue", "white", "black", "black", "white", "white", "black", "gold", "silver", "black", "gray", "beige"};
    String discount[] = new String[]{"30%", "45%", "20%", "50%", "60%", "55%", "72%", "40%", "35%", "80%", "65%", "48%"};
}

public class Main {
    static Scanner in = new Scanner(System.in);
    static String time = "";
    public static void main(String[] args) throws InterruptedException {
        
        
        System.out.println("\t\tSign Up Page\n");
        login loginData = new login();

        System.out.println("Enter your name: ");
        loginData.name = in.nextLine();

        System.out.println("\nEnter your phone number: ");
        loginData.num = in.nextInt();

        checkPassword();
        loading();
        System.out.println("\nSign up successfully!");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\bWelcome to our app Mr." + loginData.name + "!\n\n");
        //TimeUnit.SECONDS.sleep(3);
        System.out.print("\033[H\033[2J");

        String country = getCountry();
        System.out.println("\nCountry: " + country);

        String location = getLocation();
        System.out.println("Your location has been selected");
        System.out.print("\033[H\033[2J");

       

        double totalCost = 0.0;
        discount_clothes dis = new discount_clothes();
        for (int i = 0; i < 12; i++) {
            System.out.println("\nOffers for this week:\n");
            printOffer(dis, i);
            totalCost += askUser(dis.price[i]);
            System.out.print("\033[H\033[2J");
        }

        System.out.println("Total cost of items in your cart: $" + totalCost);

        System.out.println("buy \\ cancel");

        String buy = "";
        while (!buy.equals("buy") && !buy.equals("cancel")) {
            buy = in.next();
            if (!buy.equals("buy") && !buy.equals("cancel"))
                System.out.println("Invalid input, ( buy \\ cancel )");
        }

        if (buy.equals("buy")) {
            loading();
            
            System.out.println("\n " + time);
        } else if (buy.equals("cancel")) 
            System.out.println("Order canceled...");
    }

    static double askUser(double price) {
        char choice;

        do {
            System.out.println("Do you want to add this offer to your cart? (Y/N)");
            choice = in.next().charAt(0);
            choice = Character.toUpperCase(choice);
            
        } while (choice != 'Y' && choice != 'N');
        

        if (choice == 'Y'){
            System.out.println("Offer added to cart successfully.");
        return price;
        }
        else {
        System.out.println("Offer not added to cart.");
        return 0.0;
    }
}
    

    static void checkPassword() throws InterruptedException {
        login loginData = new login();
        System.out.println("\nCreate password: ");
        loginData.password = in.next();
        System.out.println("\nRe-Password: ");
        loginData.re_password = in.next();

        while (!loginData.password.equals(loginData.re_password)) {
            System.out.println("Wrong password, try again.");
            System.out.println("\nRe-Password: ");
            loginData.re_password = in.next();
        }
    }

    static void printOffer(discount_clothes offer, int index) {
        System.out.println("Sex: " + offer.sex[index]);
        System.out.println("Name: " + offer.name[index]);
        System.out.println("Color: " + offer.color[index]);
        System.out.println("Quantity: " + offer.quality[index]);
        System.out.println("Mark: " + offer.mark[index]);
        System.out.println("Discount: " + offer.discount[index]);
        System.out.println("Price: " + offer.price[index] + "$");
        System.out.println("------------------------------------");
        
    }

    static String getLocation() {
        System.out.println("Locate?");
        System.out.println("Skip");
        System.out.println("Enter locate/skip");
        return in.next();
    }

    static String getCountry() {
        
        do {
            System.out.println("choose Your Country: \n1- Saudi Arabia\n2- Egypt\n3- Jordan\n4- Yemen");
            int choose = in.nextInt();

            switch (choose) {
                case 1:
                    time = "Total time for your offer (1-2)hours to receive it";
                   return "Saudi Arabia";
                case 2:
                    time = "Total time for your offer (3-6)hours to receive it";
                  return "Egypt";
                case 3:
                    time = "Total time for your offer (2-5)hours to receive it";
                   return "Jordan";
                case 4:
                    time = "Total time for your offer (0.5-1)month to receive it";
                   return "Yemen";
                default:
                    System.out.println("Just (1-4) ");
            }
           return time;
        } while (true);
    }

    public static void loading() throws InterruptedException {
        System.out.print("Loading");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(240);
            System.out.print(".");
        }

        Thread.sleep(130);
        System.out.print("\b\b\b   \b\b\b");

        for (int i = 0; i < 3; i++) {
            Thread.sleep(240);
            System.out.print(".");
        }

        Thread.sleep(130);
        System.out.print("\b\b\b   \b\b\b");

        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        System.out.print("                ");
    }
}