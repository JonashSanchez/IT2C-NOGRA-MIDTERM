
package midtermnogra;

import java.util.Scanner;


public class Midtermnogra {

    public void addInsurance() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        
        
        System.out.println(" Name:");
        String fname = sc.next();
        
        System.out.println("Coverage Amount:");
        String amount = sc.next();
        
        System.out.println("Policy Number:");
        String number = sc.next();
        
        String sql = "INSERT INTO insurance (insurance_name, coverage_amount, policy_number) VALUES (?, ?, ?)";
        conf.addRecord(sql, fname, amount, number);
    }
     private void viewInsurance() {
        String insuranceQuery = "SELECT * FROM insurance";
        String[] insuranceHeaders = {"ID", " Name", "Coverage Amount", "Policy Number"};
        String[] insuranceColumns = {"insurance_id", "insurance_name", "coverage_amount", "policy_number"};
        config conf = new config();
        conf.viewRecords(insuranceQuery, insuranceHeaders, insuranceColumns);
    }
     
     private void updateInsurance(){
         Scanner sc = new Scanner(System.in);
             System.out.println("Enter Insurance ID:");
             int id = sc.nextInt();
          
             
           System.out.println("Enter the new name:");
           String ufname = sc.next();
           
             System.out.println("Enter the new coverage amount:");
           String camount = sc.next();
           
             System.out.println("Enter new policy number:");
           String pnumber = sc.next();
           
            
             
           String qry = "UPDATE insurance SET insurance_name = ?, coverage_amount = ?, policy_number = ? WHERE insurance_id =?";
           
           config conf = new config();
           conf.updateRecord(qry, ufname, camount,pnumber , id);
         
     }
             
             
             
    private void deleteInsurance(){
         Scanner sc = new Scanner(System.in);
             System.out.println("Enter Insurance to delete:");
             int id = sc.nextInt();
             String sqlDelete = "DELETE FROM insurance WHERE insurance_id = ?";
           config conf = new config();
           conf.deleteInsurance(sqlDelete, id);
           
    }       
    
    
     
     
    
     
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Midtermnogra demo = new Midtermnogra();
        String response;

        do {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.println("SELECT ACTION:");
            int action = sc.nextInt();

            switch(action) {
                case 1:               
                    demo.addInsurance();
                    
                    break;
                case 2:
                    demo.viewInsurance();
                    break;
                
                case 3:
                    demo.viewInsurance();
                    demo.updateInsurance();
                    break;
               
                    
                case 4:
                    demo.viewInsurance();
                    
                    demo.deleteInsurance();
                    demo.viewInsurance();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println("Continue? (yes/no):");
            response = sc.next();
        } while(response.equals("yes"));
        System.out.println("Thank You");
    }
}

