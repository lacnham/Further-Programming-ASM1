/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Pojo.StudentEnrolment;
import java.util.ArrayList;
import java.util.List;


public class StudentEnrolmentManager {
    private List<StudentEnrolment> listStudentEnrolment;

    public StudentEnrolmentManager() {
        listStudentEnrolment = new ArrayList<>();
        
    }
    
    public boolean add(String studentID,String courseID,String semester){
        //listStudentEnrolment.add(studentEnrolment);
        for (StudentEnrolment studentEnrolment1 : listStudentEnrolment) {
            if(studentEnrolment1.getIdStudent().equals(studentID) ){
                if(studentEnrolment1.getIdCourse().equals(courseID)
                        && studentEnrolment1.getSemester().equals(semester)){
                    return false;
                }
            }
        }
        StudentEnrolment studentEnrolment = new StudentEnrolment(studentID,courseID,semester);
        listStudentEnrolment.add(studentEnrolment);
        return true;
    }
    //use ADD instead of UPDATE
//    public boolean update(String studentID,String courseID,String semester){
//
//          for (int i = 0; i < listStudentEnrolment.size(); i++) {
//           if(listStudentEnrolment.get(i).getIdStudent().equals(studentID)
//                   && listStudentEnrolment.get(i).getSemester().equals(semester)){
//               listStudentEnrolment.set(i, new StudentEnrolment(studentID,courseID,semester));
//               return true;
//           }
//        }
//        return false;
//    }
    
    public boolean delete(String studentID,String courseID,String semester){
         for (int i = 0; i < listStudentEnrolment.size(); i++) {
           if(listStudentEnrolment.get(i).getIdStudent().equals(studentID)
                   && listStudentEnrolment.get(i).getSemester().equals(semester)){
               listStudentEnrolment.remove(i);
               return true;
           }
        }
        return false;
    }
    
    public List<StudentEnrolment> getOne(String studentID, String semester){
        List<StudentEnrolment> list = new ArrayList<>();
        for (StudentEnrolment studentEnrolment : listStudentEnrolment) {
            if(studentEnrolment.getIdStudent().equals(studentID)&& studentEnrolment.getSemester().equals(semester)){
                list.add(studentEnrolment);
            }
        }
        return  list;
    }
    
    public List<StudentEnrolment> getAll(){
        return listStudentEnrolment;
    }
}
