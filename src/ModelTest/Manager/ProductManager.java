package ModelTest.Manager;

import ModelTest.Imanager.IManager;
import ModelTest.Model.Product;

import java.util.ArrayList;

public class ProductManager implements IManager<Product> {
    private ArrayList<Product> list = new ArrayList<>();


    public Product getDetail (int id) {
       int index = this.findbyId(id);
       Product product = this.list.get(index);
        return product;
    }
    public ArrayList<Product> findByPrice (double from, double to) {
        ArrayList<Product> listSreach = new ArrayList<>();
        for (Product item : this.list) {
            if (item.getPrice() > from && item.getPrice() < to) {
                listSreach.add(item);
            }
        }
        return listSreach;
    }
    public ArrayList<Product> findByNameContain(String name) {
        ArrayList<Product> listSreach = new ArrayList<>();
        for (Product item : this.list) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                listSreach.add(item);
            }
        }
        return listSreach;
    }

    @Override
    public void add(Product product) {
        this.list.add(product);
    }

    @Override
    public void delete(int id) {
        int index = this.findbyId(id);
        this.list.remove(index);
    }

    @Override
    public void edit(int id, Product product) {
        int index = this.findbyId(id);
        this.list.set(index, product);
    }

    @Override
    public int findbyId(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Product> findAll() {
        return this.list;
    }
}
