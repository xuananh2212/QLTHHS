import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TruongHoc implements NhapXuat {
	private ArrayList<Person> listPerson;
	private ArrayList<Student> listStudent;
	private ArrayList<Teacher> listeTeacher;

	/**
	 * @return the listPerson
	 */
	public ArrayList<Person> getListPerson() {
		return listPerson;
	}

	/**
	 * @return the listStudent
	 */
	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	/**
	 * @return the listeTeacher
	 */
	public ArrayList<Teacher> getListeTeacher() {
		return listeTeacher;
	}

	/**
	 * @param listPerson the listPerson to set
	 */
	public void setListPerson(ArrayList<Person> listPerson) {
		this.listPerson = listPerson;
	}

	/**
	 * @param listStudent the listStudent to set
	 */
	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}

	/**
	 * @param listeTeacher the listeTeacher to set
	 */
	public void setListeTeacher(ArrayList<Teacher> listeTeacher) {
		this.listeTeacher = listeTeacher;
	}

	public TruongHoc() {
		this.listeTeacher = new ArrayList<Teacher>();
		this.listPerson = new ArrayList<Person>();
		this.listStudent = new ArrayList<Student>();
	}

	/**
	 * @param listPerson
	 * @param listStudent
	 * @param listeTeacher
	 */
	public TruongHoc(ArrayList<Person> listPerson, ArrayList<Student> listStudent, ArrayList<Teacher> listeTeacher) {

		this.listeTeacher = new ArrayList<Teacher>();
		this.listPerson = new ArrayList<Person>();
		this.listStudent = new ArrayList<Student>();
		this.listPerson = listPerson;
		this.listStudent = listStudent;
		this.listeTeacher = listeTeacher;
	}

	public void themGiaoViecHoacHocSinh(Person ps) {

		this.listPerson.add(ps);

	}

	@Override
	public void xuat() {
		System.out.println(
				"================================================TEACHER & STUDENTS ===============================================================");
		for (Person ps : this.listPerson) {

			ps.xuatTenNoiNamSinh();

		}
		System.out.println(
				"==================================================== End =========================================================================");

	}

	public void menu() {

		System.out.println("1. nhập giáo viên");
		System.out.println("2. nhập học sinh");
		System.out.println("0. Thoát");

	}
	// nhap giao vien , hoc sinh

	@Override
	public void nhap(Scanner scan) {
		Person ps;
		boolean flag = true;
		do {
			menu();
			System.out.println(">> Mời chọn: ");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {

			case 1:
				ps = new Teacher();
				ps.nhap(scan);
				this.listeTeacher.add((Teacher) ps);
				break;
			case 2:
				ps = new Student();
				ps.nhap(scan);
				this.listStudent.add((Student) ps);
				break;
			case 0:
				flag = false;
				break;

			}
		} while (flag);

	}
	// doc file du lieu

	public void docFileduLieu() {

		try {
			FileReader reader = new FileReader("src/duLieuDanhSachPerson.txt");

			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {

				String[] listInfo = line.split(" # ");
		            Person ps;
				if (listInfo[listInfo.length - 1].equalsIgnoreCase("true")) {

					ps = new Student(listInfo[0], Integer.parseInt(listInfo[1]), listInfo[2], listInfo[3],
							Float.parseFloat(listInfo[4]), Float.parseFloat(listInfo[5]),
							Float.parseFloat(listInfo[6]));

				} else {
					ps = new Teacher(listInfo[0], Integer.parseInt(listInfo[1]), listInfo[2], listInfo[3],
							Integer.parseInt(listInfo[4]), listInfo[5]);
				}

				this.listPerson.add(ps);
			}
			reader.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	// danh sach cac hoc sinh trong truong
	public void danhsachStudent() {

		for (Person ps : this.listPerson) {

			if (ps instanceof Student) {

				this.listStudent.add((Student) ps);

			}

		}

	}
	// danh sach cac giao vien trong truong

	public void danhsachTeacher() {

		for (Person ps : this.listPerson) {

			if (ps instanceof Teacher) {

				this.listeTeacher.add((Teacher) ps);

			}

		}

	}
	// xep loai va tinh diem trung binh hoc sinh trong truong

	public void tinhDiemTBVaXepLoai() {

		for (Student hs : this.listStudent) {

			hs.TinhDTB();
			hs.XepLoai();
		}

	}
	// tinh tham nien cua cac giao vien

	public void tinhThamNien() {

		for (Teacher gv : this.listeTeacher) {

			gv.tinhThamNien();
		}

	}
	// tim danh sach cac giao vien co tham niem cao nhap

	public ArrayList<Teacher> TeacherCoThamNienCaoNhat() {

		ArrayList<Teacher> listTeacherMax = new ArrayList<Teacher>();

		Teacher gvMax = this.listeTeacher.get(0);
		int viTriMax = 0;
		for (int i = 1; i < this.listeTeacher.size(); i++) {

			if (gvMax.getThamNien() < this.listeTeacher.get(i).getThamNien()) {

				gvMax = this.listeTeacher.get(i);
				viTriMax = i;

			}

		}
		for (int i = viTriMax; i < this.listeTeacher.size(); i++) {

			if (gvMax.getThamNien() == this.listeTeacher.get(i).getThamNien()) {

				listTeacherMax.add(this.listeTeacher.get(i));

			}

		}
		return listTeacherMax;

	}

	// tim giao vien co tham niem > 5 nam va co chuyen mon tu nhien
	public ArrayList<Teacher> TeacherTren5NVTN() {
		ArrayList<Teacher> listTeacherTren5NVTN = new ArrayList<Teacher>();

		for (int i = 0; i < this.listeTeacher.size(); i++) {

			Teacher gv = this.listeTeacher.get(i);
			if (gv.getThamNien() > 5 && gv.getChuyenMon().equalsIgnoreCase("Tự Nhiên")) {

				listTeacherTren5NVTN.add(gv);

			}

		}

		return listTeacherTren5NVTN;
	}

	// tim hoc sinh co diem trung binh cao nhat
	public ArrayList<Student> StudentTBCN() {
		ArrayList<Student> listStudentTBCN = new ArrayList<Student>();
		Student hs = this.listStudent.get(0);
		int viTriMax = 0;
		for (int i = 1; i < this.listStudent.size(); i++) {

			if (hs.getDiemTB() < this.listStudent.get(i).getDiemTB()) {

				hs = this.listStudent.get(i);
				viTriMax = i;
			}

		}
		for (int i = viTriMax; i < this.listStudent.size(); i++) {

			if (hs.getDiemTB() == this.listStudent.get(i).getDiemTB()) {

				listStudentTBCN.add(this.listStudent.get(i));
			}

		}
		return listStudentTBCN;
	}

	// sap xep hoc sinh theo diem trung binh giam dan
	public void sapXepStudentTheoDiemTBgiamDanQuickSort(ArrayList<Student> list, int left, int right) {

		int i = left;

		int j = right;
		Student hs = list.get((left + right) / 2);

		do {

			while (list.get(i).getDiemTB() > hs.getDiemTB()) {
				i++;

			}
			while (list.get(j).getDiemTB() < hs.getDiemTB()) {

				j--;

			}
			if (i <= j) {
				Collections.swap(list, j, i);
				i++;
				j--;

			}
		} while (i < j);
		if (left < j) {

			sapXepStudentTheoDiemTBgiamDanQuickSort(list, left, j);
		}
		if (i < right) {

			sapXepStudentTheoDiemTBgiamDanQuickSort(list, i, right);
		}

	}

	// sap xep ten hoc sinh theo ki tu abc Bubble sort
	public void sapXepTenStudentTheoABC() {

		for (int i = 0; i < this.listStudent.size(); i++) {

			for (int j = (this.listStudent.size() - 1); j > i; j--) {

				if (this.listStudent.get(j).getHoTen()
						.compareToIgnoreCase(this.listStudent.get(j - 1).getHoTen()) < 0) {

					Collections.swap(this.listStudent, j, (j - 1));

				}

			}

		}

	}

	public void xuatLine() {

		System.out.println(
				"=================================================================================================");
	}

	public void xuatLine1() {

		System.out.println(
				"============================================================================================================================");
	}

	public String formatCell(String paddLeft, String tile, String paddRight) {

		return String.format(paddLeft, " ") + tile + String.format(paddRight, " ");

	}

	public void XuatRowhead1() {
		String paddString = "%1s";
		String paddString0 = "%2s";
		String paddString1 = "%3s";
		String paddString2 = "%4s";
		String paddString3 = "%5s";
		String paddString4 = "%8s";

		String text;
		text = "||" + formatCell(paddString0, "Tên HS", paddString3) + "|";
		text += formatCell(paddString2, "Năm sinh", paddString) + "|";
		text += formatCell(paddString0, "Nơi Sinh", paddString) + "|";
		text += formatCell(paddString0, "Địa Chỉ", paddString1) + "|";
		text += formatCell(paddString2, "Toán", paddString2) + "|";
		text += formatCell(paddString1, "Tiếng Anh", paddString1) + "|";
		text += formatCell(paddString1, "Ngữ Văn", paddString2) + "|";
		text += formatCell(paddString1, "Điểm TB", paddString) + "|";
		text += formatCell(paddString1, "Xếp Loại", paddString) + "||";

		System.out.println(text);

	}

	public void XuatRowhead2() {
		String paddString = "%1s";
		String paddString0 = "%2s";
		String paddString1 = "%3s";
		String paddString2 = "%4s";
		String paddString3 = "%5s";
		String paddString4 = "%8s";

		String text;
		text = "||" + formatCell(paddString0, "TênTeacher", paddString) + "|";
		text += formatCell(paddString2, "Năm sinh", paddString) + "|";
		text += formatCell(paddString0, "Nơi Sinh", paddString) + "|";
		text += formatCell(paddString0, "Địa Chỉ", paddString0) + "|";
		text += formatCell(paddString, "Năm Bắt Đầu", paddString) + "|";
		text += formatCell(paddString, "Thâm niên", paddString2) + "|";
		text += formatCell(paddString, "Chuyên Môn", paddString) + "||";
		System.out.println(text);

	}

	public void xuatFormat1(ArrayList<Student> list) {
		xuatLine1();
		XuatRowhead1();
		xuatLine1();
		for (Student hs : list) {
			hs.formatRow();
		}

		xuatLine1();

	}

	public void xuatFormat2(ArrayList<Teacher> list) {
		xuatLine();
		XuatRowhead2();
		xuatLine();
		for (Teacher hs : list) {
			hs.formatRow();
		}

		xuatLine();

	}

}
