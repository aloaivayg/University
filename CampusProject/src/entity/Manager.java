package entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import entity.Security;
import dao.SecurityDAO;

public class Manager {
    private String managerID;
    private String fullName;
    public List<Security> securityList;
    SecurityDAO myDao = new SecurityDAO();
    InputReader in = new InputReader(System.in);

    public Manager() throws IOException {
        securityList = new ArrayList<>();
        addSecurity();
    }

    //Add new security
    public void addSecurity() throws IOException {
        securityList.add(new Security("1","Alice","Female",1000));
        securityList.add(new Security("2", "Joe", "Male", 1000));
        securityList.add(new Security("3", "John", "Male", 2000));
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
//    public void calculateSalary(String id) {
//        for (int i = 0; i < securityList.size(); i++) {
//            if (id.equals(securities.get(i).securityID)) {
//                if (securities.get(i).leaves ==0) {
//                    securities.get(i).salary = 1.1 * securities.get(i).baseSalary;
//                } else {
//                    securities.get(i).salary = securities.get(i).baseSalary - (securities.get(i).leaves*0.1*securities.get(i).baseSalary);
//                }
//            }
//        }
//    }

    //View salary
//    public void viewSalary(String id) {
//        for (int i = 0; i < securities.size(); i++) {
//            if (id.equals(securities.get(i).securityID)) {
//                System.out.println(securities.get(i).securityID + " " + securities.get(i).fullName
//                        + " " + securities.get(i).salary);
//            }
//        }
//    }
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

