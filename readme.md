# Requirements

Refactor the code to make it as clean as you can. Please keep in mind the following:

 * As for any refactor, the functionality should not change
 * Consider that nothing is yet delivered, meaning: 
    * Feel free to improve the database design if you find it necessary 
    * Feel free to improve rest interface if you find it necessary
 * Write a short summary or a list of the improvements you made.


# What i added to the refractoring

I did important changes in the architecture of the project, added unit tests most importantly

* I did layering of the classes, (controller, repository, model, service)
* I added unit tests for the layers service and controller. (I believe it's important for the refractoring)
* I changed the repository parent interface to JpaRepository
* I divided the controller into three controllers: Employee controller, Office controller and ContryCity controller to retrieve countries and cities.   
* I added the service layer, to test flexibly the repository layer.
* In the service layer, i implemented two methods in the employee service layer and three in the office service layer
   * a method for get the employee and a method for creating/updating an existing employee
   * a method for get the list of offices, a method for creating an office, and a method for updating the office.
   * The reason why i created three in office service, it's because, i wanted to introduce the use of GET, POST, and PUT RESTful methods
* In this project, i didn't want to use DTOs, because if i wanted to used 
  i would use mapstruct to do the mapping between POJOs and DTOs, to have less code to deal with.   
