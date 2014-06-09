package ua.ks.shtil.learning.src.ua.ks.shtil.learning;

/**
 * Кроме того, для каждого клиента ещё должен быть определен номер лицензии.
 */
public class Individual extends Customer {
	//TODO Implement class properly

    private int license ;

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }



    @Override
    public String toString(){
        String result = "Id :"+ this.getId()
                +"\nName: "+ getName()
                +"\nAddress: " + getAddress()
                +"\nPhone :" + getPhone()
                +"\nlicense :" + getPhone();
        return result;
    }
}
