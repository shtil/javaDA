package ua.ks.shtil.learning.src.ua.ks.shtil.learning;

/**
 * Если наш клиент – компания, то мы ещё храним имя контактного лица и величину скидки.
 */
public class Company extends Customer {
	//TODO implement class properly

    private String contactName;
    private int sale;

    public  Company(){

    }

    public Company(int sale, String contactName) {
        this.sale = sale;
        this.contactName = contactName;
    }

    public String getContactName() {
        return contactName;
    }

    public int getSale() {
        return sale;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public String toString(){
        String result = "Id :"+ this.getId()
                +"\nContact name" + contactName
                +"\nName: "+ getName()
                +"\nAddress: " + getAddress()
                +"Sale" + sale
                +"\nPhone :" + getPhone();
        return result;
    }
}
