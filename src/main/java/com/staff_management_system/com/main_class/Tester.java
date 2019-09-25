package com.main_class;

import com.exceptions.InvalidEmployeeDataException;
import com.staff.HourlyEmployee;
import com.staff.SalariedEmployee;
import com.user_interface.UserInterface;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Tester class used to extract and debug the code.
 *
 * @author Nour Al Jarrah
 * @version 2.0
 * @since 1.0
 */
public class Tester {

    public static void main(String[] args) throws InvalidEmployeeDataException {

        GregorianCalendar dm = new GregorianCalendar();
        Date startDate = dm.getTime();


        System.out.println("\t\t" + UserInterface.COMPANY_NAME);
        System.out.println("\t\t" + String.valueOf(UserInterface.PHONE_NUMBER).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)$2-$3\n"));


        HourlyEmployee Jane = new HourlyEmployee(100000, "password", "Jane", "Doe", "Underwriter",
                startDate, "524565187", 9052241451L, "jdoe@mail.com",
                "123 Main st, Toronto, ON, Canada", 15, true, "Reception");
        dm.set(2000, Calendar.DECEMBER, 14);


        SalariedEmployee Will = new SalariedEmployee(814201, "password1", "John", "Smith", "Branch Manager",
                startDate, "523845684", 6475294336L, "jsmith@mail.com",
                "55 Bloom Crt, Ajax, ON, Canada", 73000,
                true, "Whitby branch", "Bachelor degree");
        dm.set(2015, Calendar.JUNE, 12);


        Jane.displayToConsole();
        Will.displayToConsole();

    }
}
