package ModelTest.Manager;

import ModelTest.Model.Customer;
import ModelTest.Imanager.IManager;

import java.util.ArrayList;

public class CustomerManager implements IManager<Customer> {
    private ArrayList<Customer> list = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        this.list.add(customer);
    }

    @Override
    public void delete(int id) {
        int index = this.findbyId(id);
        this.list.remove(index);
    }

    @Override
    public void edit(int id, Customer customer) {
        int index = this.findbyId(id);
        this.list.set(index, customer);
    }

    public ArrayList<Customer> findByPhone(String phone) {
        ArrayList<Customer> listSreach = new ArrayList<>();
        for (Customer item : this.list) {
            if (item.getPhone().contains(phone)) {
                listSreach.add(item);
            }
        }
        return listSreach;
    }

    public ArrayList<Customer> findbyName(String name) {
        ArrayList<Customer> listSreach = new ArrayList<>();
        for (Customer item : this.list) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                listSreach.add(item);
            }
        }
        return listSreach;
    }

    @Override
    public int findbyId(int id) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Customer> findAll() {
        return this.list;
    }
}
