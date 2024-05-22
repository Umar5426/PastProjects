README Document for ENSF380 Final Individual Project

This project is designed around an application used for Emergency services. It is based on
the tracking of vital information and storage of said data. Data like victim names, genders, 
ages, supply locations, medical records, e.t.c. Inheritance was used to obtain this effect, 
thus a super class named DisasterEntity is used to hold names, date of births, ages, comments, 
genders, and dietary restrictions; as these feilds are used frequently. Furthermore, two sub 
classes inherit from DisasterEntity and are Implemented for the user, so they are interactable.

The project contains a total of 14 source java files, and 9 test java files (totalling 84 tests).
An sql file is used to set up a database, and is named project.sql, as well as a file named 
GenderOptions.txt is used ot verify the validity of the inputted genders. 

To round out the design and to offer a better view into the structure of this project, a UML
Diagram was included named UML.pdf. As well as a pdf file named statement.pdf which contains 
the specifcations/requirements attempted in this project as well as a performace goal.

The test libraries are missing, but the regular JUnit and Hamcrest Libraries are sufficeint to 
run any unit test files. The test libraries are missing sure to the submission requirements. 

The main exectuable files in this program are the DisasterVictimImplementation and
InquirerImplementation. These files include a main function, meaning that they execute commands and 
are able to be interacted with after compliation. The DisasterVictimImplementation file allows the 
user to observe the functionality of the DisasterEntity and DisasterVictim files, and well as showing
the interconnectedness of these structures. The InquirerImplementation file allows the user to see 
the use of a database and logs within the program. Both of these implementation files use DisasterEntity,
and thus use every single file in the project. 
