import java.util.*;

/**
 * You are given a phone book that consists of people's names and their phone number.
 * After that you will be given some person's name as query.
 * For each query, print the phone number of that person.
 */

class Solution{
    public static void main(String []argh) {
        Scanner in = new Scanner(System.in);
        //number of entries in the phonebook
        int n=in.nextInt();
        in.nextLine();
        HashMap<String, Integer> phoneBook = new HashMap<>();
        for(int i=0;i<n;i++) {
            String name=in.nextLine();
            int phone=in.nextInt();
            //add person's name and phone number in the phonebook
            phoneBook.put(name, phone);
            in.nextLine();
        }

        while(in.hasNext()) {
            String s = in.nextLine();
            //if the person has an entry in the phonebook, print the person's name and phone number
            if (phoneBook.containsKey(s)) {
                System.out.println(s + "=" + phoneBook.get(s));
            } else {
                //if the person has no entry in the phone book print "Not found"
                System.out.println("Not found.");
            }
        }
    }
}