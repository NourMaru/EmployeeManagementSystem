# EmployeeManagementSystem

This application was developed for the porpuse of mangaing employees (hourly employees) and executives(salaried employees) who work for the same company.
The application requires the user to log in in order to use it. Afterthat, the user has a control of the database of the company including company info, employee personal information, and executives personal information.
The application allows the user to add, remove, and edit an exsiting data record.

The application prompts the user with an error message when entering duplicate data information, invalid name valuse (such as numbers and symbols), invalid password values, and any other invalid data. 

The application also prompt the user with a "Record not found" error message upon searching for a non-existing employee record.

The application contain classes and intreface as shown below:

	Classes:
		DatabaseConnect
		DuplicateEmployeeException
		HourlyEmployee
		HourlyEmployeeDataAccess
		InvalidEmployeeDataException
		InvalidIdException
		InvalidNameException
		InvalidPasswordException
		InvalidUserDataException
		Login
		NotFoundException
		SalariedEmployee
		SalariedEmployeeDataAccess
		Tester
		User
	Interface:
		EmployeeInterface
