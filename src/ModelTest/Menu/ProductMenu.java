package ModelTest.Menu;

import ModelTest.Manager.ProductManager;
import ModelTest.Model.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductMenu {
    ProductManager productManager = new ProductManager();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMain() {
        int choice;
        do {
            System.out.println("======Menu Quản Lí Sản Phẩm ======\n" +
                    "1. Thêm mới \n" +
                    "2. Sửa \n" +
                    "3. Xóa \n" +
                    "4. Hiển thị tất cả \n" +
                    "5. Tìm kiếm tên gần đúng\n" +
                    "0. Thoát");
            System.out.println("Nhập sự lựa chọn của bạn");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuDelete();
                    break;
                case 4:
                    showMenuList();
                    break;
                case 5:
                    showFormSreachByName();
                    break;
                case 6:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }
        while (choice != 0);
    }
/*
  public void showPriceSreachPrice() {
        System.out.println("====== Tìm kiếm khoản giá =====");
        System.out.println("Nhập giá cần tìm");
        double price = inputNumber.nextInt();
        //ArrayList<Product> productArrayList = productManager.findByPrice(price);
    }
 */


    public void showFormSreachByName() {
        System.out.println("===== Tìm kiếm theo tên =====");
        System.out.println("Nhập tên cần tìm: ");
        String name = inputString.nextLine();
        ArrayList<Product> productArrayList = productManager.findByNameContain(name);
        for (int i = 0; i < productArrayList.size(); i++) {
            System.out.println(i + 1 + ". " + productArrayList.get(i));
        }
        if (productArrayList.size() == 0) {
            System.out.println("Không có tên nào cần tìm");
            return;
        }
    }

    public void showMenuList() {
        System.out.println("===== Danh sách sản phẩm =====");
        ArrayList<Product> listProduct = productManager.findAll();
        for (int i = 0; i < listProduct.size(); i++) {
            System.out.println(i + 1 + ". " + listProduct.get(i));
        }
    }

    public void showMenuEdit() {
        System.out.println("===== Menu sửa =====");
        System.out.println("Nhập Id sửa");
        int id = inputNumber.nextInt();
         /* tìm kiếm id không tồn tại
        boolean isCheck = findById();

        if (isCheck == false)
        {
            System.out.println("Không có Id tồn tại");
            return;
        }*/
        System.out.println("Nhập tên sửa");
        String name = inputString.nextLine();
        System.out.println("Nhập giá mới của sản phẩm");
        int price = inputNumber.nextInt();
        Product newProduct = new Product(id,name,price);
        productManager.edit(id, newProduct);
        System.out.println("Sửa Thành Công");
    }

    public void showMenuDelete() {
        System.out.println("===== Menu xóa =====");
        System.out.println("Nhập Id sản phẩm: ");
        int idDelete = inputNumber.nextInt();
        productManager.delete(idDelete);
        System.out.println("Xóa Thành Công! ");
    }

    public void showMenuAdd() {
        System.out.println("===== Menu thêm mới ===== ");
        System.out.println("Nhập Tên: ");
        String name = inputString.nextLine();
        System.out.println("Nhập giá: ");
        double price = inputNumber.nextDouble();
        Product newProduct = new Product(name, price);
        productManager.add(newProduct);
        System.out.println("Thêm Sản Phẩm Thành Công");
    }
}
