import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

class Student implements Serializable {
    int rollNo;
    int marks;
    String subject;

    Student(int rollNo, int marks, String subject) {
        this.rollNo = rollNo;
        this.marks = marks;
        this.subject = subject;
    }

    Student(int rollNo, int marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }
}

public class serialize {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException {
        ArrayList<Student> arr = new ArrayList<>();
        File file = new File("student.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
       
        NodeList students = doc.getElementsByTagName("student");
        for (int i=0;i<students.getLength();i++) {
            Element student = (Element) students.item(i);
            int roll_no = Integer.parseInt(student.getElementsByTagName("roll").item(0).getTextContent());
            int marks = Integer.parseInt(student.getElementsByTagName("marks").item(0).getTextContent());
            System.out.println("Student " + (i+1) + " details:");
            System.out.println("Roll No: " + roll_no);
            System.out.println("Marks: " + marks);
            System.out.println();
            String subject = student.getElementsByTagName("subject").item(0).getTextContent();
            arr.add(new Student(roll_no, marks, subject));
        }

        ArrayList<Student> ls = new ArrayList<>();
        for(Student s: arr) {
            ls.add(new Student(s.rollNo, s.marks));
        }

        File outputFile = new File("students.txt");
        FileOutputStream fos = new FileOutputStream(outputFile);
        ObjectOutputStream obj = new ObjectOutputStream(fos);

        for (Student s: ls) {
            obj.writeObject(s);
        }
        System.out.println("Successfully serialized!!");
    }
}