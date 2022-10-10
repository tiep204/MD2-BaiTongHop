package ra.run;

import ra.entity.Student;
import ra.entity.StudentClass;

import java.util.*;

public class StudentManagement {
    static List<StudentClass> listClass = new ArrayList<>();
    static List<Student> listStudent = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("***************QUAN LY HOC VIEN*********************");
            System.out.println("1. Quản lý lớp học");
            System.out.println("2. Quản lý sinh viên");
            System.out.println("3. Thoát");
            System.out.println("Sự lựa chọn của bạn:");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.getClassManageMent(sc);
                    break;
                case 2:
                    StudentManagement.getStudentManagement(sc);
                    break;
                case 3:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chon 1-3");
            }
        } while (true);
    }

    ////////////////////////QUAN LY LOP HOC/////////////////////////////
    public static void getClassManageMent(Scanner sc) {
        boolean classExit = true;
        do {
            System.out.println("**********************QUẢN LÝ LỚP HỌC*********************");
            System.out.println("1. Thêm mới lớp học ");
            System.out.println("2. Cập nhật thông tin lớp học ");
            System.out.println("3. Hiển thị thong tin lớp học");
            System.out.println("4. Thống kê các lớp đang hoạt động");
            System.out.println("5. Tìm kiếm lớp học theo tên lớp học");
            System.out.println("6. Thoát");
            System.out.println("Sự lựa chọn của bạn ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    StudentManagement.inputListClass(sc);
                    break;
                case 2:
                    StudentManagement.updateClass(sc);
                    break;
                case 3:
                    StudentManagement.displayLisClass();
                    break;
                case 4:
                    StudentManagement.getClassActive();
                    break;
                case 5:
                    StudentManagement.SearchClassByName(sc);
                    break;
                case 6:
                    classExit = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-6");
            }

        } while (classExit);
    }

    //////////////////////////////CASE1///////////////////////
    public static void inputListClass(Scanner sc) {
        System.out.println("Nhập vào số lớp nhập thông tin: ");
        int countClass = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < countClass; i++) {
            /// nhap thong tin cho tung lop
            StudentClass studentClassNew = new StudentClass();
            studentClassNew.inputData(sc);
            ////sdd vao danh sach lop
            listClass.add(studentClassNew);
        }
    }
////////////////////////////////////HET CASE 1/////////////////////////


    //////////////////////////////////CASE2///////////////////////////
    public static void updateClass(Scanner sc) {
        System.out.println("Nhập vào mã lớp cần nhập thông tin:");
        String classId = sc.nextLine();
        /////kiem tra ma lop co ton tai trong danh sach khong? co----> cap nhat
        boolean existClass = false;
        for (StudentClass studentClass : listClass) {
            if (studentClass.getClassId().equals(classId)) {
                ///ton lai lop trong danh sach----> cap nhat
                System.out.println("Nhập vào tên lớp cần cập nhật: ");
                String className = sc.nextLine();
                if (className != "" && className.length() != 0) {
                    ////Cap nhat ten lop
                    studentClass.setClassName(className);
                }
                System.out.println("Nhập vào mô tả lớp cần cập nhật: ");
                String description = sc.nextLine();
                if (description != "" && description.length() != 0) {
                    studentClass.setDescriptions(description);
                }
                System.out.println(" Nhập vào trạng thái lớp cần cập nhật : ");
                String classStatus = sc.nextLine();
                if (classStatus != "" && classStatus.length() != 0) {
                    studentClass.setClassStatus(Integer.parseInt(classStatus));
                }
                existClass = true;
                break;
            }
        }
        if (!existClass) {
            System.out.println("không tồn lại mã lop như vậy ");
        }
    }
    ////////////////////////het case 2//////////////////////////////////


    ///////////////////////case3///////////////////////////////////

    public static void displayLisClass() {
        System.out.println("Thong tin danh sach lop hoc: ");
        for (StudentClass studentClass : listClass) {
            studentClass.displayData();
        }
    }
    ////////////////////////het case3/////////////////////////


    ///////////////////////case4//////////////////////
    public static void getClassActive() {
        System.out.println("Danh sách lớp học");
        int countClassActive = 0;
        for (StudentClass studentClass : listClass) {
            if (studentClass.getClassStatus() == 0) {
                studentClass.displayData();
                countClassActive++;
            }
        }
        System.out.printf("Có %d Lớp đang hoạt động \n", countClassActive);
    }
    ////////////////////het case4////////////////////

    ////////////////////case5///////////////////
    public static void SearchClassByName(Scanner sc) {
        System.out.println("Nhập vào tên lớp học cần tìm kiếm: ");
        String classNameSearch = sc.nextLine();
        boolean exitClass = false;
        for (StudentClass studentClass : listClass) {
            if (studentClass.getClassName().contains(classNameSearch)) {
                studentClass.displayData();
                exitClass = true;
            }
        }
        if (!exitClass) {
            System.out.println("Không có lớp nào có tên như vậy ");
        }
    }

    /////////////////////////het case 5///////////////////////////

////////////////////////////////HET QUAN LY LOP HOC///////////////////////////////////////////////


    ////////////////////////QUAN LY SINH VIEN/////////////////////////////////
    public static void getStudentManagement(Scanner sc) {
        boolean studentExit = true;
        do {
                System.out.println("*******************QUẢN LÝ SINH VIÊN************************");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Cập nhật thông tin sinh viên");
            System.out.println("3. Hiển thị thông tin sinh viên");
            System.out.println("4. Tính điểm trung bình sinh viên");
            System.out.println("5. Xếp loại sinh viên");
            System.out.println("6. Sắp sếp sinh viên theo điểm trung bình tăng dần");
            System.out.println("7. Tìm kiến sinh viên theo tên sinh viên: ");
            System.out.println("8. Thống kê sinh viên đạt giỏi, khá, trung bình ,yếu");
            System.out.println("9. Thống kê các sinh viên pass qua môn học");
            System.out.println("10. Thoát");
            System.out.println("Sự lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    StudentManagement.inputListStudent(sc);
                    break;
                case 2:
                    StudentManagement.updateStudent(sc);
                    break;
                case 3:
                    StudentManagement.displayListStudent();
                    break;
                case 4:
                    StudentManagement.calAvgMArkListStudent();
                    break;
                case 5:
                    StudentManagement.classifyStudent();
                    break;
                case 6:
                    StudentManagement.sortStudentByAvgMarkASC();
                    break;
                case 7:
                    StudentManagement.sortStuentByStudentName(sc);
                    break;
                case 8:
                    StudentManagement.getStatisticStuden();
                    break;
                case 9:
                    StudentManagement.getStaticticsAvgMark();
                    break;
                case 10:
                    studentExit = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-6");
            }
        } while (studentExit);
    }

    ////////////////////////////////CASE1/////////////////////////////////
    public static void inputListStudent(Scanner sc) {
        System.out.println("Nhập vào số sinh viên cần nhập thông tin : ");
        int cnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cnt; i++) {

            Student studentNew = new Student();
            studentNew.inputData(sc);

            System.out.println("Chọn lớp học cho sinh viên: ");
            int index = 1;
            for (StudentClass stClass : listClass) {
                System.out.printf("%d.%s\n", index, stClass.getClassName());
                index++;
            }
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            studentNew.setStudentClass(listClass.get(choice - 1));

            listStudent.add(studentNew);
        }
    }
    //////////////////////////////HET CASE1////////////////////////////////////


    ///////////////////////////CASE2////////////////////////////////
    public static void updateStudent(Scanner sc) {
        System.out.println("Nhập vào mã sinh viên cần cập nhật thông tin: ");
        String studentIdUpdate = sc.nextLine();
        for (Student student : listStudent) {
            if (student.getStudenId().equals(studentIdUpdate)) {
                ///cap nhat thong tin sinh vien
                System.out.println("Nhập vào tên sinh viên cần cập nhật: ");
                String studentName = "";
                do {
                    studentName = sc.nextLine();
                    if (studentName != "" && studentName.length() != 0) {
                        if (studentName.length() >= 6 && studentName.length() <= 50) {
                            student.setStudentName(studentName);
                            break;
                        } else {
                            System.out.println("Vui lòng nhập tên sinh viên từ 6-50 ký tự ");
                        }
                    }
                } while (true);
                System.out.println("Nhập vào tuổi sinh viên cần cập nhật: ");
                String age = "";
                do {
                    age = sc.nextLine();
                    if (age != "" && age.length() != 0) {
                        if (Integer.parseInt(age) >= 18) {
                            student.setAge(Integer.parseInt(age));
                            break;
                        } else {
                            System.out.println("Vui lòng nhập tuổi sinh viên lớn hơn 18 ");
                        }
                    }
                } while (true);
                System.out.println("Nhập vào giới tính cần cập nhật: ");
                String sex = sc.nextLine();
                if (sex != "" && sex.length() != 0) {
                    student.setSex(Boolean.parseBoolean(sex));
                }
                ///cap nhat lop cho sinh vien
                System.out.println("chon lop sinh vien: ");
                int cntClass = 1;
                for (StudentClass studentClass : listClass) {
                    System.out.printf("%d. %s \n", cntClass, studentClass.getClassName());
                    cntClass++;
                }
                System.out.printf("%d.Không cập nhật lớp \n", cntClass);
                System.out.println("su lua chon cua ban: ");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice != cntClass) {
                    ///cap nhat lop cho sinh vien
                    student.setStudentClass(listClass.get(choice - 1));
                }
                //cap nhat cac diem cho sinh vien
                StudentManagement.updateStudenMark(student.getListMarkJavaScript(), sc, student, "JavaScript");
                StudentManagement.updateStudenMark(student.getListMarkJavaCore(), sc, student, "JavaCore");
                StudentManagement.updateStudenMark(student.getListMarkJavaWeb(), sc, student, "JavaWeb");
                ////Tinh lai diem trung binh cho sinh vien
                student.getAvgMark();
                ////xep loai lai cho sinh vien
                student.getGPA();
                ////Cap nhat trang thai sinh vien
                System.out.println("Nhập vào trạng thái sinh viên cần cập nhật: ");
                String studentStatus = sc.nextLine();
                if (studentStatus != "" && studentStatus.length() != 0) {
                    student.setStudentStatus(Boolean.parseBoolean(studentStatus));
                }
            }
        }
    }

    public static void updateStudenMark(List<Float> listMark, Scanner sc, Student student, String subject) {
        System.out.printf("Cập nhật điểm %s Cho sinh viên: \n", subject);
        System.out.println("1. Nhập mới điểm cho sinh viên");
        System.out.println("2. Thêm mới điểm cho sinh viên");
        System.out.println("3. Cập nhật một điểm trong danh sách");
        System.out.println("4. Không cập nhật");
        System.out.println("Lựa chọn của bạn: ");

        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                List<Float> list = new ArrayList<>();
                Student.inputMark(list, sc);
                student.setListMarkJavaScript(list);
                break;
            case 2:
                Student.inputMark(student.getListMarkJavaScript(), sc);
                break;
            case 3:
                System.out.println("Nhập vào lần thi muốn cập nhật: ");
                int examTimes = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập vào điểm thi cập nhật: ");
                float mark = Float.parseFloat(sc.nextLine());
                //Cap nhat
                student.getListMarkJavaScript().set(examTimes - 1, mark);
                break;
        }
    }

    public static void displayListStudent() {
        System.out.println("Thông tin danh sách sinh viên: ");
        for (Student student : listStudent) {
            student.displayData();
        }
    }

    public static void calAvgMArkListStudent() {
        for (Student student : listStudent) {
            student.calAvgMark();
        }
        System.out.println("Đã tính xong điểm trung bình cho tất cả sinh viên ");
    }

    public static void classifyStudent() {
        for (Student student : listStudent) {
            student.getGPA();
        }
        System.out.println("Đã xếp loại xong cho tất cả sinh viên");
    }

    public static void sortStudentByAvgMarkASC() {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getAvgMark() - o2.getAvgMark());
            }
        });
    }


    public static void sortStuentByStudentName(Scanner sc) {
        System.out.println("Nhap vao ten sinh vien can tim: ");
        String studentNameSearch = sc.nextLine();
        boolean existStudent = false;
        for (Student student : listStudent) {
            if (student.getStudentName().contains(studentNameSearch)) {
                student.displayData();
                existStudent = true;
            }
        }
        if (!existStudent) {
            System.out.println("Không tìm thấy tên sinh viên");
        }
    }

    public static void getStatisticStuden() {
        int cntExellent = 0, cntGood = 0, cntAvegage = 0, cntWeek = 0;
        for (Student student : listStudent) {
            if (student.getAvgMark() < 5) {
                cntWeek++;
            } else if (student.getAvgMark() < 7) {
                cntAvegage++;
            } else {
                cntExellent++;
            }
        }
        System.out.printf("Số sinh viên giỏi : %d - Khá: %d - Trung bình: %d - Yếu: %d\n", cntExellent, cntGood, cntAvegage, cntWeek);
    }

    public static void getStaticticsAvgMark() {
        int cntPass = 0;
        for (Student student : listStudent) {
            int jsSize = student.getListMarkJavaScript().size();
            int jcSize = student.getListMarkJavaCore().size();
            int jwSize = student.getListMarkJavaWeb().size();
            if (student.getAvgMark() >= 5 && student.getListMarkJavaScript().get(jsSize - 1) >= 5
                    && student.getListMarkJavaCore().get(jcSize - 1) >= 5 && student.getListMarkJavaWeb().get(jwSize - 1) >= 5) {
                cntPass++;
            }
        }
        System.out.printf("Co %d Sinh viên Pass\n",cntPass);
    }
}
