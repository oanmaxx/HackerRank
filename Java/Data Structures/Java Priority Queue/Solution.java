import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*  there are a number of students in a school.
 *  two types of events, ENTER and SERVED, can take place:
 *  ENTER: A student with some priority enters the queue to be served
 *  SERVED: The student with the highest priority is served (removed) from the queue
 *  The queue serves the students based on the following criteria (priority criteria):
 *  1. The student having the highest Cumulative Grade Point Average (CGPA) is served first.
 *  2. Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
 *  3. Any students having the same CGPA and name will be served in ascending order of the id.
 *  TASK:
 *      create the Student(id, name, cgpa, constructor and getters) and
 *                 Priorities(should implement the method getStudents()) classes
 *  INPUT format:
 *      n - total number of events
 *      ENTER name CGPA id: The student to be inserted into the priority queue.     (i.e., ENTER John 3.75 50)
 *      SERVED: The highest priority student in the queue was served.
 *  OUTPUT format:
 *      the names of the students yet to be served in the priority order
 *      if there are no such student, then the code prints EMPTY
 */

class Student implements Comparable<Student> {
    //fields
    private final int id;
    private final String name;
    private final double cgpa;

    //constructor
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student student) {
        if (cgpa == student.getCgpa()) {
            if (name.compareTo(student.getName()) == 0) {
                return Integer.compare(id, student.getId());
            } else {
                return name.compareTo(student.getName());
            }
        } else if (cgpa > student.getCgpa()) {
            return -1;
        } else {
            return 1;
        }
    }
}

class Priorities {

    // getStudents method should process all the given events and
    // return all the students yet to be served in the priority order
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> studentPQ = new PriorityQueue<>();
        //traverse the list of events
        for (String event : events) {
            //split the event into fields
            String[] data = event.split(" ");
            //process ENTER
            if (data.length > 1) {
                //instantiate this student and add it to the Priority Queue
                studentPQ.add(new Student(Integer.parseInt(data[3]), data[1], Double.parseDouble(data[2])));
            } else {
                //process SERVED(highest priority) - retrieve and remove the head of the queue
                studentPQ.poll();
            }
        }
        while (studentPQ.size() > 1) {
            System.out.println(studentPQ.poll().getName());
        }
        return new ArrayList<>(studentPQ);
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}