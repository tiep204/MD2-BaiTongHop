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
        System.out.println("Nh???p v??o m?? sinh vi??n: ");
        do {
            this.studenId = sc.nextLine();
            if (this.studenId.trim().length() == 6){
                if(this.studenId.trim().charAt(0) == 'S'){
                    break;
                }else {
                    System.err.println("Vui l??ng nh???p m?? sinh vi??n b???t ?????u b???ng k?? t??? S");
                }
            }else{
                System.err.println("Vui l??ng nh???p m?? sinh vi??n c?? 6 k?? t???");
            }
        }while (true);
        System.out.println("Nh???p v??o t??n sinh vi??n: ");
        do {
            this.studentName = sc.nextLine();
            if(this.studentName.trim().length() >6 && this.studentName.trim().length() <50){
                break;
            }else{
                System.err.println("ten khong h??p le");
            }
        }while (true);
        System.out.println("Vui l??ng nh???p tu???i sinh vi??n ");
        do {
            try {
                this.age = Integer.parseInt(sc.nextLine());
                if(this.age >=18){
                    break;
                }else {
                    System.err.println("Vui l??ng nh???p tu???i sinh vi??n l???n h??n ho???c b???ng 18 ");
                }
            }catch (Exception e){
                System.out.println("M???i b???n nh???p l???i");
            }

        }while (true);
        System.out.println("Nh???p v??o gi???i t??nh sinh vi??n: ");
        this.sex = Boolean.parseBoolean(sc.nextLine());
        int cnt = 1;
        System.out.println("Nh???p c??c ??i???m thi javascript: ");
        inputMark(listMarkJavaScript, sc);
        System.out.println("Nh???p c??c ??i???m thi Java Core: ");
        inputMark(listMarkJavaCore, sc);
        System.out.println("Nh???p c??c ??i???m thi Java Web: ");
        inputMark(listMarkJavaWeb, sc);
        System.out.println("Nh???p v??o tr???ng th??i c???a sinh vi??n: ");
        this.studentStatus = Boolean.parseBoolean(sc.nextLine());
    }

    public static void inputMark(List<Float> listMark, Scanner sc){
        int cnt = 1;

        do {
            System.out.printf("Nh???p ??i???m thi l???n %d: \n", cnt);
            listMark.add(Float.parseFloat(sc.nextLine()));
            cnt++;
            System.out.printf("B???n c?? mu???n nh???p ??i???m thi l?? %d kh??ng: \n", cnt);
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("S??? l???a ch???n c???a b???n: ");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice !=1){
                break;
            }
        }while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("M?? SV: %s - T??n SV: %s - Tu???i: %d - Gi???i t??nh: %b - L???p: %s\n",this.studenId, this.studentName, this.age, this.sex, this.studentClass.getClassName());
        System.out.println("??i???m Javascript: ");
        for (Float js_mark : listMarkJavaScript){
            System.out.printf("%f\t",js_mark);
        }
        System.out.printf("\n");
        System.out.println("??i???m Java Core: ");
        for(Float js_mark : listMarkJavaCore){
            System.out.printf("%f\t", js_mark);
        }
        System.out.printf("\n");
        System.out.println("??i???m Java Web: ");
        for (Float js_mark : listMarkJavaWeb){
            System.out.printf("%f\t", js_mark);
        }
        System.out.printf("\n");
        System.out.printf("??i???m TB: %f - X???p lo???i: %s - Tr???ng th??i: %b\n", this.avgMark, this.gpa, this.studentStatus);
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
