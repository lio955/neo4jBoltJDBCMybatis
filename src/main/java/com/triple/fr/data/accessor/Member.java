package fr.triple.data.accessor;

import java.util.List;

/**
 * Created by lionel on 17/03/17.
 */
public class Member {
    private String empNo;
    private String name;
    private List<Address> addresses;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
