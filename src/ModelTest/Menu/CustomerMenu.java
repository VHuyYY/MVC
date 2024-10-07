package ModelTest.Menu;

import ModelTest.Manager.CustomerManager;
import ModelTest.Model.Customer;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMenu {
    CustomerManager customerManager = new CustomerManager();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMain() {
        int choice;
        do {
            System.out.println("======Menu Nhân Viên FullTime======\n" +
                    "1. Thêm Nhân Viên FullTime \n" +
                    "2. Sửa \n" +
                    "3. Xóa \n" +
                    "4. Hiển thị tất cả nhân viên FullTime \n" +
                    "5. Tìm kiếm tên gần đúng\n" +
                    "6. Tìm kiếm Phone gần đúng\n " +
                    "0. Thoát");
            System.out.println("Nhập sự lựa chọn của bạn");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    showAdd();
                    break;
                case 2:
                    showEdit();
                    break;
                case 3:
                    showDelete();
                    break;
                case 4:
                    showCustomer();
                    break;
                case 5:
                    showSreachByName();
                    break;
                case 6:
                    showPhone();
                    break;
                case 0:
                    break;
                default:
                    System.out.printf("Không có lựa chọn nào");
            }
        } while (choice != 0);
    }

    public void showAdd() {
        System.out.println("===== Menu Thêm Mới =====");
        System.out.println("Nhập Tên Nhân Viên: ");
        String name = inputString.nextLine();
        System.out.println("Nhập Email: ");
        String email = inputString.nextLine();
        System.out.println("Nhập Phone:");
        String phone = inputString.nextLine();
        System.out.println("Nhập Địa Chỉ: ");
        String address = inputString.nextLine();
        Customer newCustomer = new Customer(name, email, phone, address);
        customerManager.add(newCustomer);
        System.out.println("Thêm Nhân Viên FullTime Thành Công");
    }

    public void showDelete() {
        System.out.println("===== Menu Xóa Nhân Viên =====");
        System.out.println("Nhập Id cần xóa: ");
        int idDelete = inputNumber.nextInt();
        customerManager.delete(idDelete);
        System.out.println("Xóa Nhân Viên Thành Công");
    }

    public void showSreachByName() {
        System.out.println("===== Tìm kiếm theo tên =====");
        System.out.println("Nhập Tên cần tìm");
        String name = inputString.nextLine();
        ArrayList<Customer> customerArrayList = customerManager.findbyName(name);
        for (int i = 0; i < customerArrayList.size(); i++) {
            System.out.println(i + 1 + ". " + customerArrayList.get(i));
        }
        if (customerArrayList.size() == 0) {
            System.out.println("Không có tên nào cần tìm");
            return;
        }
    }

    /*
    public void showPhone() {
            System.out.println("====== Menu Hiển Thị Phone Gần Đúng =====");
            System.out.printf("Nhập Phone cần tìm: ");
            String phone = inputString.nextLine();
            ArrayList<Customer> customerArrayList = customerManager.findByPhone(phone);
            for (int i = 0; i < customerArrayList.size(); i++) {
                System.out.println(i + 1 + ". " + customerArrayList.get(i));
            }
            if (customerArrayList.size() == 0) {
                System.out.println("Không có Phone nào cần tìm ");
                return;
            }

        }
     */
    public void showPhone() {
        System.out.println("====== Menu Hiển Thị Phone Gần Đúng =====");
        System.out.printf("Nhập Phone cần tìm: ");
        String phone = inputString.nextLine();
        ArrayList<Customer> customerArrayList = customerManager.findByPhone(phone);
        for (int i = 0; i < customerArrayList.size(); i++) {
            System.out.println(i + 1 + ". " + customerArrayList.get(i));
        }
        if (customerArrayList.size() == 0) {
            System.out.println("Không có Phone nào cần tìm ");
            return;
        }

    }

    public void showEdit() {
        System.out.println("===== Menu Sửa Nhân Viên FullTime =====");
        System.out.println("Nhập Id Nhân Viên FullTime Cần Sửa: ");
        int id = inputNumber.nextInt();
        System.out.println("Nhập Tên Nhân Viên Cần Sửa: ");
        String name = inputString.nextLine();
        System.out.println("Nhập Email Nhân Viên Cần Sửa: ");
        String email = inputString.nextLine();
        System.out.println("Nhân Phone Nhân Viên Cần Sửa: ");
        String phone = inputString.nextLine();
        System.out.println("Nhập Địa Chỉ Nhân Viên Cần Sửa: ");
        String address = inputString.nextLine();
        Customer newCustomer = new Customer(id, name, email, phone, address);
        customerManager.edit(id, newCustomer);
        System.out.println("Sửa Nhân Viên Thành Công");

    }

    public void showCustomer() {
        System.out.println("===== Danh Sách Nhân Viên FullTime =====");
        ArrayList<Customer> listCustomer = customerManager.findAll();
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println(i + 1 + ". " + listCustomer.get(i));
        }
    }
}
