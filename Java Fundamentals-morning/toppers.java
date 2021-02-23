import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class toppers {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       
        File file = new File("students.txt");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream obj1 = new ObjectInputStream(fis);
        boolean flag = true;
        PriorityQueue<Student> pq = new PriorityQueue<>(5, new StudentComparator()); //max pq
        while (flag) {
            try {
                Student stud = (Student) obj1.readObject();
                pq.add(stud);
                if (pq.size() > 5) pq.poll(); //jabtk size 5 se zada hai nikalte rho.
            } 
            catch (EOFException exc) {
              flag = false;
            }
        }

        FileWriter myWriter = new FileWriter("topstudents.csv");
        myWriter.write("S.No, Roll No, Marks per subject\n");
        int i = 1;
        while(!pq.isEmpty()) {
            myWriter.write(String.valueOf(i) + "," + String.valueOf(pq.peek().rollNo) + "," + String.valueOf(pq.peek().marks) + "\n");
            pq.poll();
            i++;
            
        }
        myWriter.close();
       
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Integer.compare(s2.marks, s1.marks);
    }
}