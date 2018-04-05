package fr.triple.data.accessor;

import java.util.List;

/**
 * Created by lionel on 17/03/17.
 */

public class Customer {
    private String custNo;
    private String name;
    private List<Team> supportTeams;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getSupportTeams() {
        return supportTeams;
    }

    public void setSupportTeams(List<Team> supportTeams) {
        this.supportTeams = supportTeams;
    }
}
