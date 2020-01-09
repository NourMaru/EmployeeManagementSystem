# EmployeeManagementSystem

This application is developed for managing employees' data; (hourly employees) and executives (salaried employees) who work for the same company.
The application requires the user to log-in to be able to use it. After that, the user has a control of the database of the company including company info, employee personal information, and executives’ personal information.
The application allows the user to add, remove, and edit an existing data record.

The application prompts the user with an error message when entering duplicate data information, invalid name values (such as numbers and symbols), password values, and any other invalid data. 

The application prompts the user with a "Record not found" error message upon searching for a non-existing employee record.

The application contains classes and interface as shown below:


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
