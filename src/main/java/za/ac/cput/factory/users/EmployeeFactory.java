/*  Davin Carstens 220021333
 */
package za.ac.cput.factory.users;

import za.ac.cput.domain.details.Name;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.util.EmailAddressValidator;
import za.ac.cput.util.StringHelper;
public class EmployeeFactory {

    public static Employee build(String staffId, String email, Name name){
        StringHelper.checkStringParam("staffId", staffId);
        StringHelper.checkStringParam("email", email);

        EmailAddressValidator.validator("email", email);
        return new Employee.Builder()
                .setStaffId(staffId)
                .setEmail(email)
                .setName(name)
                .build();
    }
}
