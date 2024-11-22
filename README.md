Requirements
Java Development Kit (JDK) version 8 or higher.
Network-enabled environment for client-server communication.
Setup Instructions
Clone the Repository:

Copy code
cd distributed-task-manager
Compile the Code:
Navigate to the project directory and compile all .java files:

Copy code
javac *.java
Run the Server:
Start the server by running:


Copy code
java Server
This initializes the RMI registry on port 2020 and binds the TaskManager service.

Run the Client:
Open a new terminal window and start the client application:

Copy code
java Client
