package ua.ks.shtil.learning.src.ua.ks.shtil.learning;

/**
 * Клиентов нужно учитывать в создаваемой системе. На текущий момент для каждого клиента мы храним
 * следующую информацию: имя, адрес и телефон. Также каждому новому клиенту мы присваиваем уникальный ID.
 */
public class Customer {
    private static int counter = 0;

    private int Id;
	private String name;
	private String address;
	private String phone;

    public Customer() {
        counter++;
        this.Id = counter;
    }

    public int getId(){
        return Id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
        this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
        this.address = address;
	}

	public String getPhone() {
        return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    @Override
    public String toString(){
        String result = "Id :"+ Id +"\nName: "+ name +  "\nAddress: " + address + "\nPhone :" + phone;
        return result;
    }
}
