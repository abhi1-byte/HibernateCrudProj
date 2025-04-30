package com.zeroesones.controller;

import com.zeroesones.dto.Student;
import com.zeroesones.service.IStudentService;
import com.zeroesones.servicefactory.StudentServiceFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Controller layer
public class MainApp {
    static IStudentService studentService;

    static {
        studentService = StudentServiceFactory.getStudentService();
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1.CREATE\n2.SELECT\n3.UPDATE\n4.DELETE\n5.Exit the Application");
            System.out.println("ENTER UR CHOICE, PRESS[1/2/3/4/5]:: ");
            String option = br.readLine();
            switch (option) {
                case "1":
                    insertStudent();
                    break;
                case "2":
                    getStudent();
                    break;
                case "3":
                    updateStudent();
                    break;
                case "4":
                    deleteStudent();
                    break;
                case "5":
                    System.out.println("******* Thanks for using the application *****");
                    System.exit(0);
                default:
                    System.out.println("Invalid option plz try again with valid options....");
            }

        }
    }

    private static void insertStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student name :: ");
        String sname = scanner.next();

        System.out.print("Enter the student age :: ");
        int sage = scanner.nextInt();

        System.out.print("Enter the student address :: ");
        String saddress = scanner.next();

        Integer inserted = studentService.addStudent(sname, sage, saddress);
        if (inserted == 1)
            System.out.println("Insertion Successful");
        else
            System.out.println("Insertion failed");
    }

    private static void getStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student id :: ");
        int sid = scanner.nextInt();
        Student std = studentService.searchStudent(sid);
        if (std != null) {
            System.out.println("sid\tsname\tsage\tsaddress");
            System.out.println(std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddress());
        } else {
            System.out.println("Record not found for sid::" + sid);
        }
    }

    @SuppressWarnings("unused")
    private static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student id to delete:: ");
        int sid = scanner.nextInt();
        Integer deleted = studentService.deleteStudent(sid);
        if (deleted == 1) {
            System.out.println("The Student Id " + sid + " got deleted successfully");
        } else {
            System.out.println("The Student Id " + sid + " did not deleted");
        }
    }

    @SuppressWarnings("unused")
    private static void updateStudent() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oldName = null;
        Integer oldAge = null;
        String oldAddress = null;
        System.out.println("Enter the student id to update:: ");
        String sid = br.readLine();
        Student std = studentService.searchStudent(Integer.parseInt(sid));
        if (std != null) {
            oldName = std.getSname();
            oldAge = std.getSage();
            oldAddress = std.getSaddress();
            System.out.println("sid\tsname\tsage\tsaddress");
            System.out.println(sid + "\t" + oldName + "\t" + oldAge + "\t" + oldAddress);
        } else {
            System.out.println("Record not found for sid::" + sid);
            System.out.println("Exited the application");
            System.exit(0);
        }

        System.out.println("Enter the student name :: ");
        String sname = br.readLine();
        if (sname.equals(oldName) || sname.equals("")) {
            sname = oldName;
        }

        System.out.println("Enter the student age :: ");
        String sage = br.readLine();
        if (sage.equals(oldAge) || sage.equals("")) {
            sage = oldAge.toString();
        }

        System.out.println("Enter the student address :: ");
        String saddress = br.readLine();
        if (saddress.equals(oldAddress) || saddress.equals("")) {
            saddress = oldAddress;
        }

        System.out.println("Oldname is " + oldName + " newname is:" + sname);
        System.out.println("Oldage is " + oldAge + " newage is:" + sage);
        System.out.println("Oldaddress is " + oldAddress + " newaddress is:" + saddress);
        Integer updated = studentService.updateStudent(Integer.valueOf(sid), sname, Integer.valueOf(sage), saddress);
        if (updated == 1) {
            System.out.println("The Student Id " + sid + " got updated successfully");
        } else {
            System.out.println("The Student Id " + sid + " did not updated");
        }
    }
}
