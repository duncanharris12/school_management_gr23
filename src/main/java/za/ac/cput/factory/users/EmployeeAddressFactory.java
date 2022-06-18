/*  Davin Carstens 220021333
 */
package za.ac.cput.factory.users;

import za.ac.cput.domain.details.Address;
import za.ac.cput.domain.users.EmployeeAddress;
import za.ac.cput.util.StringHelper;

public class EmployeeAddressFactory {
    public static EmployeeAddress build(String staffId, Address address) {
        StringHelper.checkStringParam("staff ID", staffId);
        return new EmployeeAddress.Builder()
                .setStaffId(staffId)
                .setAddress(address)
                .build();
    }
}
