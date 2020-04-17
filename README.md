# SpringbootAppwithJuint5
This project more concentrated on Spring boot + Junit 5 + Mockito
Controllers:
Customer controller: which is more concentrated on customer personal data. It will give account info when you are getting customers info  through any endpoints such as “/getCustomers” , /customer/{id}, and /customer/{firstName}/{lastName} (this endpoint is search customer by full name).
This provide save and delete end points to. This controller won’t modify account details.
Account Controller:
This does account management. To modify account balance you need to know account id. You can get account id when you run /accounts end point. Also when you create account response will give account id. There is common end point for delete and save. 
Main endpoint is “/transfer” using this you can transfer balance from account to other. If there isn’t any balance to transfer it throws AccountTransactionException. If any of account ids not found, it throws ResourceNotFoundException. 
Services:
There is Customer and Account services. There is also Address service.
Repository:
All three repositories extends CrudRepository.
Only CustomerRepository have Quary base method to get customer by full name.
Models:
Account
Address
Customer
TranferForm (this is not entity. This for /transfer end point json request body)
Customer and address entities have one to one relation. 
