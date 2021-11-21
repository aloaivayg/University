import ui.MainFrame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        Manager manager = new Manager("01", "Alice");

//        manager.addSecurity();
        String id = in.nextLine();
        manager.viewLeaves(id);
//        manager.calculateSalary(id);
//        manager.viewSalary(id);

    }

    static class Manager {
        private String managerID;
        private String fullName;
        private List<Security> securities;
        InputReader in = new InputReader(System.in);

        public Manager(String managerID, String fullName) {
            this.managerID = managerID;
            this.fullName = fullName;
            securities = new ArrayList<>();
        }

        //Add new security
        public void addSecurity() throws IOException {
            System.out.println("Enter security's information.");

            System.out.println("ID:");
            String securityID = in.nextLine();

            System.out.println("Full Name:");
            String fullName = in.nextLine();

            System.out.println("Base salary:");
            double base = in.nextDouble();

            Security security = new Security(securityID, fullName, base);
            securities.add(security);
            System.out.println("Successful");
        }

        //View leaves
        public void viewLeaves(String id) {
            for (int i = 0; i < securities.size(); i++) {
                if (id.equals(securities.get(i).securityID)) {
                    System.out.println("Leave days: " + securities.get(i).leaves);
                    System.out.println("Remain leave days: " + securities.get(i).remainLeaves);
                }
            }
        }

        //Calculate salary
        public void calculateSalary(String id) {
            for (int i = 0; i < securities.size(); i++) {
                if (id.equals(securities.get(i).securityID)) {
                    if (securities.get(i).leaves ==0) {
                        securities.get(i).salary = 1.1 * securities.get(i).baseSalary;
                    } else {
                        securities.get(i).salary = securities.get(i).baseSalary - (securities.get(i).leaves*0.1*securities.get(i).baseSalary);
                    }
                }
            }
        }

        //View salary
        public void viewSalary(String id) {
            for (int i = 0; i < securities.size(); i++) {
                if (id.equals(securities.get(i).securityID)) {
                    System.out.println(securities.get(i).securityID + " " + securities.get(i).fullName
                                        + " " + securities.get(i).salary);
                }
            }
        }
    }

    static class Security {
        private String securityID;
        private String fullName;
        private double baseSalary;
        private double salary;
        private int leaves;
        private int remainLeaves;
        public Security(String managerID, String fullName, double base) {
            this.securityID = managerID;
            this.fullName = fullName;
            this.baseSalary = base;
            this.leaves = 0;
            this.remainLeaves = 3;
        }

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
