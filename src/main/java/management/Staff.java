package management;

import list.JsonController;

import java.io.IOException;

import static list.JsonController.*;

public class Staff {
    public String firstName;
    public String lastName;
    public String password;
    public String employeeType;
    public String employeeID;

    public Staff(){

    }

    public Staff(String firstName, String lastName, String password, String employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.employeeID = employeeID;
        employeeType = "Staff";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

//    //    serialize a list of Orders and return a String of the json text
//    public static void serializeAList() {
//
////        GsonBuilder() will set the string to print nicely in the console
////        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Gson gson = new Gson();
//
////        list.JsonController.staffList is converted to json text
//        staffJSON = gson.toJson(staffList);
//
////        create new Json file
//        try{
//            FileWriter file = new FileWriter("Staff.json");
//            file.write(staffJSON);
//            file.flush();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //    deserialize a list of Orders and return the management.Staff list
//    public static List<Staff> deserializeAList() {
//
////        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
//        Type staffListType = new TypeToken<ArrayList<Staff>>(){}.getType();
//
////        returns deserialized / hydrated list
//        return new Gson().fromJson(staffJSON, staffListType);
//
//    }

    //    check username and password are valid
    public boolean loginVerification(String employeeID, String password){

        for (Staff s : staffList) {
            if(s.employeeID.equals(employeeID) && s.password.equals(password)) {
                return true;
            }
        }

        return false;
    }

    //    checks for existing customer
    public static void startOrder(String phoneNumber){
        // for loop to go through customerList to verify existing customer
    }

    public static boolean logout(){
        return true;
    }

    public static void goToPrevScreen(){
    }

    public static boolean updateCustomerInfo(String phoneNumber){
        return true;
    }

////    w/o generics
//    public static boolean createNewStaff(String firstName, String lastName, String password, String employeeID) throws IOException {
//        // Use list.JsonController class to make updates to the class list to be used in the json file
//        Staff staff = new Staff(firstName, lastName, password, employeeID);
//
////        re-writes the json file to add the new customer
//        JsonController.serializeAStaffList(staff);
//
//        return true;
//    }
//
//    public static boolean createNewManager(String firstName, String lastName, String password, String employeeID) throws IOException {
//        // Use list.JsonController class to make updates to the class list to be used in the json file
//        Staff staff = new Manager(firstName, lastName, password, employeeID);
//
////        re-writes the json file to add the new customer
//        JsonController.serializeAStaffList(staff);
//
//        return true;
//    }

    //    with generics


    public static boolean createNewManager(String firstName, String lastName, String password, String employeeID) throws IOException {


        for (Staff s : JsonController.staffList) {
            if (s.employeeID.equals(employeeID)) {
                return false;
            }
        }

        Staff staff = new Manager(firstName, lastName, password, employeeID);

        staffList.add(staff);

        serializeStaff();

        return true;
    }

    public static boolean isDuplicate(String employeeID) {
        for(Staff s : staffList) {
            if (s.employeeID.equals(employeeID)) {
                return true;
            }
        }

        return false;
    }


}