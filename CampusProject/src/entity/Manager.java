package entity;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.*;

import entity.Security;
import dao.SecurityDAO;

public class Manager {
    private String managerID;
    private String fullName;
    public List<Security> securityList;
    SecurityDAO myDao = new SecurityDAO();
    private Map<Duty,Integer> scheduleMap;
    private ArrayList<Duty> schedule;

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Security> getSecurityList() {
        return securityList;
    }

    public void setSecurityList(List<Security> securityList) {
        this.securityList = securityList;
    }

    public SecurityDAO getMyDao() {
        return myDao;
    }

    public void setMyDao(SecurityDAO myDao) {
        this.myDao = myDao;
    }

    public Map<Duty, Integer> getScheduleMap() {
        return scheduleMap;
    }

    public void setScheduleMap(Map<Duty, Integer> scheduleMap) {
        this.scheduleMap = scheduleMap;
    }

    public Manager() throws IOException {
        securityList = myDao.readListSecurityAsByte();
//        securityList = new ArrayList<>();

    }

    //Add new security
    public boolean addSecurity(Security security) throws IOException {
//        securityList.add(new Security("1","Alice","Female",1000));
//        securityList.add(new Security("2", "Joe", "Male", 1000));
//        securityList.add(new Security("3", "John", "Male", 2000));
        boolean res = false;
        Security tempSecurity = this.getSecuritybyID(security.getSecurityID());
        if (tempSecurity == null) {
            this.securityList.add(security);
            res = true;
        }
        return res;
    }

    public Security getSecuritybyID(String id) {
        Security resSecurity = null;
        for (int i = 0; i < this.securityList.size(); i++) {
            if (this.securityList.get(i).getSecurityID().equalsIgnoreCase(id)) {
                return securityList.get(i);
            }
        }
        return resSecurity;
    }

    //View leaves
    public void viewLeaves(String id) {
        for (int i = 0; i < securityList.size(); i++) {
            if (id.equals(securityList.get(i).securityID)) {
                System.out.println("Leave days: " + securityList.get(i).leaves);
                System.out.println("Remain leave days: " + securityList.get(i).remainLeaves);
            }
        }
    }

    //Calculate salary
    public void calculateSalary() {
        for (int i = 0; i < securityList.size(); i++) {
            if (securityList.get(i).leaves ==0) {
                securityList.get(i).salary = 1.1 * securityList.get(i).baseSalary;
            } else {
                securityList.get(i).salary = securityList.get(i).baseSalary
                        - (securityList.get(i).leaves*0.1*securityList.get(i).baseSalary);
            }

        }
    }

//    public void resetSchedule(Admin a) {
//        a.getSchedule().clear();
//        a.getScheduleMap().clear();
//        for (Security s : securityList) {
//            s.getDutyList().clear();
//        }
//    }

    public void addSchedule(Security s, Date date, String placeID, int start, int end) {
        Duty d = new Duty(date, placeID, s, start, end);
        Map<Duty, Integer> map = scheduleMap;
        List<Duty> list = schedule;
        Security s1 = d.getS();
        Integer value = map.get(d);
        if (value == null) {
            map.put(d, 1);
            list.add(d);
        }
    }

//    public void save(List<Security> securityList) {
//        myDao.saveListSecurityAsChar(securityList);
//        myDao.saveListSecurityAsByte(securityList);
//    }

}

