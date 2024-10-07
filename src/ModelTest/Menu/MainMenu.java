package ModelTest.Menu;

import java.util.Scanner;

public class MainMenu {
    private CustomerMenu customerMenu = new CustomerMenu();

    private ProductMenu productMenu = new ProductMenu();

    Scanner inputNumber = new Scanner(System.in);

    public void selectMenu() {
        int choice;
        do {
            System.out.println("===== Trang Chủ =====\n" +
                    "1. Quản Lí Nhân Viên FullTime \n" +
                    "2. Quản Lí Sản Phẩm\n" +
                    "0. Thoát");
            System.out.println("Nhập sự lựa chọn của bạn");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    customerMenu.showMain();
                    break;
                case 2:
                    productMenu.showMain();
                    break;
                case 0:
                    break;
                default:
                    System.out.printf("Không có lựa chọn nào: ");
            }
        } while (choice != 0);
    }
}


