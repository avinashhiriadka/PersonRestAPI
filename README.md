This repository contains the code to run the Person API service as a Springboot Application.
The client code for invoking this service is under this repo:
https://github.com/avinashhiriadka/PersonAPIClient

The steps for installing and starting this service are given below.
1. Clone the GIT repo into the server where Java and Maven is installed using the command:
git clone https://github.com/avinashhiriadka/PersonRestAPI.git
2. cd PersonRestAPI/
3. Run the maven command to build the package
./mvnw clean package
4.You should see a build success with 3 tests run and target folder created
5. Start the Springboot application using the command:
./mvnw spring-boot:run
6. This will start the application on port 8080 on the server


