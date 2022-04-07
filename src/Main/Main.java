
package Main;

import Interfaces.StudentEnrolmentManager;
import Class.StudentEnrolment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        try {
            String line = "";
//            String splitBy = ",";
            BufferedReader br = null;


            StudentEnrolmentManager studentEnrolmentManager = new StudentEnrolmentManager();
            try {
                br = new BufferedReader(new FileReader("default.csv"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] data = line.split(",");    // use comma as separator
                studentEnrolmentManager.add(data[0], data[3], data[6]);
            }
            
            
            boolean flag = true;
            Scanner sc = new Scanner(System.in);
            
            do{
                System.out.println("Welcome to the student enrolment system. Please choose an option" +
                        "\n1. Enrolment" +
                        "\n2. List Course Of Student and Update Course" +
                        "\n3. List Course Of Student in a Semester" +
                        "\n4. Exit the program");
                System.out.print("Choose an option: ");
                int a = sc.nextInt();
                sc.nextLine();
                switch (a){
                    case 1:
                        System.out.print("Please input student ID: ");
                        String studentID = sc.next();
                        sc.nextLine();
                        System.out.print("Please input semester: ");
                        String semester = sc.next();
                        sc.nextLine();
                        System.out.print("Please input course ID: ");
                        String courseID = sc.next();
                        sc.nextLine();
                        if(studentEnrolmentManager.add(studentID, courseID, semester)){
                            System.out.println("Successfully enroll!");
                        }else{
                            System.out.println("ERROR");
                        }
                        //sc.nextLine();
                        break;
                    case 2:
                        System.out.print("Please input student ID: ");
                        String IDstudent = sc.next();
                        sc.nextLine();
                        System.out.print("Please input semester:  ");
                        String semes = sc.next();
                        sc.nextLine();
                        List<StudentEnrolment> listStudentEnrolment = studentEnrolmentManager.getOne(IDstudent,semes);
                        int count = 0;
                        for (StudentEnrolment studentEnrolment : listStudentEnrolment) {
                            System.out.println("Row "+(count+1)+": Student ID: "+studentEnrolment.getIdStudent()+",Course ID: "+studentEnrolment.getIdCourse()
                                    +" Semester: "+studentEnrolment.getSemester());
                            count++;
                        }
                        boolean flag1 = true;
                        do{
                            System.out.println("1. DELETE COURSE" +
                                    "\n2. ADD COURSE" +
                                    " \n3. EXIT");
                            System.out.print("Choose an option:");
                            int b = sc.nextInt();
                            sc.nextLine();
                            switch(b){
                                case 1:
                                    System.out.print("Choose a row to delete: ");
                                    int row = sc.nextInt();
                                    sc.nextLine();
                                    if(row<listStudentEnrolment.size()+1){
                                        studentEnrolmentManager.delete(listStudentEnrolment.get(row-1).getIdStudent(),
                                                listStudentEnrolment.get(row-1).getIdCourse(),
                                                listStudentEnrolment.get(row-1).getSemester());
                                        listStudentEnrolment.remove(row-1);
                                    }else{
                                        System.out.println("Row undefined");
                                    }
                                    break;
                                case 2:
                                    //sc.nextLine();
                                    System.out.print("Course ID: ");
                                    String CourseID = sc.next();
                                    sc.nextLine();
                                    if(studentEnrolmentManager.add(IDstudent, CourseID, semes)){
                                        listStudentEnrolment.add(new StudentEnrolment(IDstudent,CourseID,semes));
                                        System.out.println("Successful");
                                    }else{
                                        System.out.println("Error");
                                    }
                                    break;
                                default:
                                    flag1 = false;
                                    break;
                            }
                        }while (flag1);
                        break;
                    case 3:
                        System.out.print("Please input student ID:  ");
                        String idstudent = sc.next();
                        sc.nextLine();
                        System.out.print("Please input semester: ");
                        String semesters = sc.next();
                        sc.nextLine();
                        List<StudentEnrolment> listStudentEnrolments = studentEnrolmentManager.getOne(idstudent,semesters);
                        /*  private static final String COMMA_DELIMITER = ",";
                        private static final String NEW_LINE_SEPARATOR = "\n";

                        // CSV file header
                        private static final String FILE_HEADER = "id,code,name";*/
                        FileWriter fileWriter = null;
                        try {
                            fileWriter = new FileWriter("Enrolment.csv");
                            
                            // Write the CSV file header
                            fileWriter.append("StudentID,CourseID,Semester");
                            
                            // Add a new line separator after the header
                            fileWriter.append("\n");
                            for (StudentEnrolment listStudentEnrolment1 : listStudentEnrolments) {
                                fileWriter.append(String.valueOf(listStudentEnrolment1.getIdStudent()));
                                fileWriter.append(",");
                                fileWriter.append(String.valueOf(listStudentEnrolment1.getIdCourse()));
                                fileWriter.append(",");
                                fileWriter.append(listStudentEnrolment1.getSemester());
                                fileWriter.append("\n");
                            }
                            System.out.println("CSV file was created successfully !!!");
                        } catch (Exception e) {
                            System.out.println("Error in CsvFileWriter !!!");
                            e.printStackTrace();
                        }finally {
                            try {
                                fileWriter.flush();
                                fileWriter.close();
                            } catch (IOException e) {
                                System.out.println("Error while flushing/closing fileWriter !!!");
                                e.printStackTrace();
                            }
                        }
                        
                        break;
                        
                    default:
                        flag = false;
                        System.out.println("The End. Thank you for using our program");
                        break;
                }
            }while (flag);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
