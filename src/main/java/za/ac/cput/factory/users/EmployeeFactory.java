/*  Davin Carstens 220021333
 */
package za.ac.cput.factory.users;

import za.ac.cput.domain.users.Employee;
import za.ac.cput.util.StringHelper;

public class EmployeeFactory {

    public static Employee build(String staffId, Name name, String email){
        StringHelper.setEmptyIfNull(staffId);
        StringHelper.setEmptyIfNull(name);
        StringHelper.setEmptyIfNull(email);
        return new Employee.Builder()
                .setStaffId(staffId)
                .setName(name)
                .setEmail(email)
                .build();
    }
}
