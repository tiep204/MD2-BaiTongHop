package ra.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement {
    private String studenId;
    private String studentName;
    private int age;
    private boolean sex;
    private StudentClass studentClass;
    private List<Float> listMarkJavaScript = new ArrayList<>();
    private List<Float> listMarkJavaCore = new LinkedList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private float avgMark;
    private String gpa;
    private boolean studentStatus;

    public Student() {
    }

    public Student(String studenId, String studentName, int age, boolean sex, StudentClass studentClass, List<Float> listMarkJavaScript, List<Float> listMarkJavaCore, List<Float> listMarkJavaWeb, float avgMark, String gpa, boolean studentStatus) {
        this.studenId = studenId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.studentClass = studentClass;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        listMarkJavaCore = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.gpa = gpa;
        this.studentStatus = studentStatus;
    }

    public String getStudenId() {
        return studenId;
    }

    public void setStudenId(String studenId) {
        this.studenId = studenId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public List<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(List<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập vào mã sinh viên: ");
        do {
            this.studenId = sc.nextLine();
            if (this.studenId.trim().length() == 6){
                if(this.studenId.trim().charAt(0) == 'S'){
                    break;
                }else {
                    System.err.println("Vui lòng nhập mã sinh viên bắt đầu bằng ký tự S");
                }
            }else{
                System.err.println("Vui lòng nhập mã sinh viên có 6 ký tự");
            }
        }while (true);
        System.out.println("Nhập vào tên sinh viên: ");
        do {
            this.studentName = sc.nextLine();
            if(this.studentName.trim().length() >6 && this.studentName.trim().length() <50){
                break;
            }else{
                System.err.println("ten khong hơp le");
            }
        }while (true);
        System.out.println("Vui lòng nhập tuổi sinh viên ");
        do {
            try {
                this.age = Integer.parseInt(sc.nextLine());
                if(this.age >=18){
                    break;
                }else {
                    System.err.println("Vui lòng nhập tuổi sinh viên lớn hơn hoặc bằng 18 ");
                }
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại");
            }

        }while (true);
        System.out.println("Nhập vào giới tính sinh viên: ");
        this.sex = Boolean.parseBoolean(sc.nextLine());
        int cnt = 1;
        System.out.println("Nhập các điểm thi javascript: ");
        inputMark(listMarkJavaScript, sc);
        System.out.println("Nhập các điểm thi Java Core: ");
        inputMark(listMarkJavaCore, sc);
        System.out.println("Nhập các điểm thi Java Web: ");
        inputMark(listMarkJavaWeb, sc);
        System.out.println("Nhập vào trạng thái của sinh viên: ");
        this.studentStatus = Boolean.parseBoolean(sc.nextLine());
    }

    public static void inputMark(List<Float> listMark, Scanner sc){
        int cnt = 1;

        do {
            System.out.printf("Nhập điểm thi lần %d: \n", cnt);
            listMark.add(Float.parseFloat(sc.nextLine()));
            cnt++;
            System.out.printf("Bạn có muốn nhập điểm thi là %d không: \n", cnt);
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice !=1){
                break;
            }
        }while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d - Giới tính: %b - Lớp: %s\n",this.studenId, this.studentName, this.age, this.sex, this.studentClass.getClassName());
        System.out.println("Điểm Javascript: ");
        for (Float js_mark : listMarkJavaScript){
            System.out.printf("%f\t",js_mark);
        }
        System.out.printf("\n");
        System.out.println("Điểm Java Core: ");
        for(Float js_mark : listMarkJavaCore){
            System.out.printf("%f\t", js_mark);
        }
        System.out.printf("\n");
        System.out.println("Điểm Java Web: ");
        for (Float js_mark : listMarkJavaWeb){
            System.out.printf("%f\t", js_mark);
        }
        System.out.printf("\n");
        System.out.printf("Điểm TB: %f - Xếp loại: %s - Trạng thái: %b\n", this.avgMark, this.gpa, this.studentStatus);
    }
    public void calAvgMark(){
        this.avgMark = (listMarkJavaScript.get(listMarkJavaScript.size()-1))+
                listMarkJavaCore.get(listMarkJavaCore.size()-1)+
                listMarkJavaWeb.get(listMarkJavaWeb.size()-1)/3;
    }
    public void getGPA(){
        if ( this.avgMark<5){
            this.gpa = "Yeu";
        }else if(this.avgMark<7){
            this.gpa = "Trung binh";
        }else if (this.avgMark<9){
            this.gpa = "Kha";
        }else {
            this.gpa = "Gioi";
        }
    }

}
