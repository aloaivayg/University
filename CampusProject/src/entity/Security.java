package entity;

import java.io.*;
import java.util.*;

public class Security implements Serializable{
    protected String securityID;
    protected String fullName;
    protected String gender;
    protected double baseSalary;
    protected double salary;
    protected int leaves;
    protected int remainLeaves;
    protected List<Duty> dutyList;
    protected Map<Duty,Integer> attendance;

    public Security(String securityID, String fullName, String gender, double baseSalary) {
        this.securityID = securityID;
        this.fullName = fullName;
        this.gender = gender;
        this.baseSalary = baseSalary;
        this.dutyList = new ArrayList<>();
        this.attendance = new HashMap<>();
    }

    public String getSecurityID() {
        return securityID;
    }

    public void setSecurityID(String securityID) {
        this.securityID = securityID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getLeaves() {
        return leaves;
    }

    public void setLeaves(int leaves) {
        this.leaves = leaves;
    }

    public int getRemainLeaves() {
        return remainLeaves;
    }

    public void setRemainLeaves(int remainLeaves) {
        this.remainLeaves = remainLeaves;
    }

    public List<Duty> getDutyList() {
        return dutyList;
    }

    public void setDutyList(List<Duty> dutyList) {
        this.dutyList = dutyList;
    }

    public Map<Duty, Integer> getAttendance() {
        return attendance;
    }

    public void setAttendance(Map<Duty, Integer> attendance) {
        this.attendance = attendance;
    }

    public String getInfoAsString() {
        String str = this.getSecurityID();
        str += "," + this.getFullName();
        str += "," + this.getGender();
        str += "," + this.getBaseSalary();
        str += "," + this.getLeaves();
        str += "," + this.getRemainLeaves();
        str += "," + this.getSalary();
        return str;
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}

