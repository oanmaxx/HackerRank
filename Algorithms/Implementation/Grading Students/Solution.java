import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Grading policy of HackerLand University: every student receives a grade in the inclusive range from 0 to 100.
 * Any grade less than 40 is a failing grade.
 * Sam, a professor at the university likes to round each student's grade according to the rules:
 *      - if the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5;
 *      - if the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
 *      ex: grade = 84 => round to 85(85-54 is less than 3)
 *          grade = 29 => do not round(result is less than 40)
 *          grade = 57 => do not round(60-57 is 3 or higher)
 *  Sample INPUT:
 *          4       (n=4, the number of students)
 *          73      (each of the subsequent lines contains the grades)
 *          67
 *          38
 *          33
 *  Sample OUTPUT:
 *          75      (75-73<3)
 *          67      (70-67=3)
 *          40      (40-38<3)
 *          33      (less than 40 -> the grade will not be modified)
 */

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        int nextMultipleOf5;
        List<Integer> gradesAfterRounding = new ArrayList<>();
        for (Integer grade : grades) {
            if (grade < 38) {
                gradesAfterRounding.add(grade);
                continue;
            }
            nextMultipleOf5 = 5 - (grade % 5) + grade;
            if (nextMultipleOf5 - grade < 3) {
                gradesAfterRounding.add(nextMultipleOf5);
            } else {
                gradesAfterRounding.add(grade);
            }
        }
        return gradesAfterRounding;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
