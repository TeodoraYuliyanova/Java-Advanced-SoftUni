import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipReservationList = new TreeSet<>();
        Set<String> regularReservationList = new TreeSet<>();

        String guestExpectedToCome = scanner.nextLine();
        while (!guestExpectedToCome.equals("PARTY")) {

            char vipOrRegular = guestExpectedToCome.charAt(0);
            if (Character.isDigit(vipOrRegular)) {
                vipReservationList.add(guestExpectedToCome);
            } else {
                regularReservationList.add(guestExpectedToCome);
            }


            guestExpectedToCome = scanner.nextLine();
        }

        String arrivingGuest = scanner.nextLine();
        while (!arrivingGuest.equals("END")) {

            if (vipReservationList.contains(arrivingGuest)) {
                vipReservationList.remove(arrivingGuest);//because he has arrived
            } else if (regularReservationList.contains(arrivingGuest)) {
                regularReservationList.remove(arrivingGuest);
            }


            arrivingGuest = scanner.nextLine();
        }

        System.out.println(vipReservationList.size() + regularReservationList.size());

        if (!vipReservationList.isEmpty()) {
            for (String guestHasntArrived : vipReservationList) {
                System.out.println(guestHasntArrived);
            }
        }

        if (!regularReservationList.isEmpty()) {
            for (String guestHasntArrived : regularReservationList) {
                System.out.println(guestHasntArrived);
            }
        }
    }
}
