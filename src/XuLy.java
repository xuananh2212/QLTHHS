import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TruongHoc th = new TruongHoc();
		doMenu(th, scan);

	}

	public static void menu() {

		System.out.println("1. nhập thông tin ");
		System.out.println("2. Đọc file dữ liệu cho học sinh và giáo viên");
		System.out.println("3. xuất thông tin giáo viên và học sinh");
		System.out.println("4. xuất thông tin giáo viên ");
		System.out.println("5. xuất thông tin học sinh");
		System.out.println("6. tìm giáo viên của thâm niên cao nhất");
		System.out.println("7. tìm giáo viên có thâm niên > 5 năm  và khối tự nhiên");
		System.out.println("8. tìm Điểm trung Bình cao nhất của học sinh");
		System.out.println("9. sắp xếp học sinh theo điểm trung bình giảm dần QuickSort");
		System.out.println("10. sắp xếp tên học sinh theo thứ tự ABC bubbleSort");
		System.out.println("0. Thoát");

	}

	public static void doMenu(TruongHoc th, Scanner scan) {
		boolean flag = true;
		do {
			menu();
			System.out.print(">>Mời chọn: ");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 0:
				flag = false;
				break;
			case 1:
				th.nhap(scan);
				break;
			case 2:
				th.docFileduLieu();
				th.danhsachStudent();
				th.danhsachTeacher();
				break;
			case 3:
				th.xuat();
				break;
			case 4:
				
				th.tinhThamNien();
				ArrayList<Teacher> listTeacher = th.getListeTeacher();
				th.xuatFormat2(listTeacher);

				break;
			case 5:
				
				th.tinhDiemTBVaXepLoai();
				ArrayList<Student> listStudent = th.getListStudent();
				th.xuatFormat1(listStudent);

				break;
			case 6:
				th.tinhThamNien();
				ArrayList<Teacher> listTeacherMax = th.TeacherCoThamNienCaoNhat();
				th.xuatFormat2(listTeacherMax);

				break;
			case 7:
				
				th.tinhThamNien();
				ArrayList<Teacher> listTeacherMaxAnd = th.TeacherTren5NVTN();
				th.xuatFormat2(listTeacherMaxAnd);

				break;
			case 8:
				th.tinhDiemTBVaXepLoai();
				ArrayList<Student> listStudentTBMax = th.StudentTBCN();
				th.xuatFormat1(listStudentTBMax);

				break;
			case 9:
				th.tinhDiemTBVaXepLoai();
				ArrayList<Student> list = th.getListStudent();
				th.sapXepStudentTheoDiemTBgiamDanQuickSort(list, 0, list.size() - 1);
				th.xuatFormat1(list);

				break;
			case 10:
				th.tinhDiemTBVaXepLoai();
				ArrayList<Student> list1 = th.getListStudent();
				th.sapXepTenStudentTheoABC();
				th.xuatFormat1(list1);
				break;

			}

		} while (flag);

	}
}
