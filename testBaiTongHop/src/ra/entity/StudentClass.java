package ra.entity;

import ra.entity.IStudentManagement;

import java.util.Scanner;

public class StudentClass implements IStudentManagement {
    private String classId;
    private String className;
    private String descriptions;
    private int classStatus;

    public StudentClass(){

    }

    public StudentClass(String classId, String className, String descriptions, int classStatus) {
        this.classId = classId;
        this.className = className;
        this.descriptions = descriptions;
        this.classStatus = classStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập vào mã lớp: ");
        do{
            this.classId = sc.nextLine();
            if (this.classId.trim().length()==5){
                if (this.classId.charAt(0)=='J'){
                    break;
                }else{
                    System.out.println("Vui lòng nhập mã lớp bắt đầu bằng chữ J");
                }
            }else{
                System.out.println("Vui lòng nhập mã lớp gồm 5 ký tự ");
            }
        }while (true);
        System.out.println("Nhập vào tên lớp: ");
        do{
            this.className = sc.nextLine();
            if(this.className.trim().length()<=10){
                break;
            }else{
                System.out.println("Vui lòng nhập tên lớp tồi đa 10 ký tự");
            }
        }while (true);
        System.out.println("Nhập vào mô tả lớp: ");
        this.descriptions = sc.nextLine();
        System.out.println("Nhập vào trạng thái của lớp: ");
        this.classStatus = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã Lớp: %s - Tên lớp: %s - Mô tả: %s -Trạng Thái: %d\n",this.classId,this.className,this.descriptions,this.classStatus);
    }
}
