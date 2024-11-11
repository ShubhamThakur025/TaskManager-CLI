# Task Manager

### Models
1. **Task**: TaskID(Java's uuid), Task(String), TaskStatus(String), UserId (UserId), isLogin(boolean).
2. **User**: UserId(Java's uuid), Username(String), TaskList(List[Task])

### Flow
1. #### User Authentication:
    The tool would start with a prompt to the user to either register or log in.
    - <u>Registration:</u> The user would follow the registration prompts. Usernames should be unique. Have used Bcrypt for password hashing. His uuid would be mapped to his data for fast access in future.
    - <u>Logging in:</u> A step that involves user logging in. His account would be fetched through his username. Bcrypt would verify the enetered password with the hashed one.
    - <u>Exit:</u> Pressing any other key would close the application. 
    - Here, we need to maintain a data structure to note the registered users. Since we're not utilizing any database, the data won't be persisting. We can add a set of dummy users in the data structure while the program initializes just to populate it. A good choice would probably be a **HashMap(userId -> username)**. Now, how'd we track the users who've logged in? There are two major options: We can put a flag in the model itself: isLogin: Boolean. We can update it or A separate data structure to list logged-in users.  The first approach feels a bit optimal. This is because checking isLogin is far more efficient than dedicating a separate data structure for listing. However, this statement betrays us the second we realize that this approach violates the functional paradigm. Therefore, we'll be following the second approach i.e. Maintaining a data structure. We shall be creating a LoginManager to maintain a global state of logged-in users.

### Repositories
Contain the core storage and CRUD operations.

### Services
Responsible for seamlessly working with the respositories. Act as bridge between the high-level controllers and low-level repositories. Contains the logic for login manager.

### Controllers
High level logic that bridges between the services and cli. Perform crucial operations like logging and hashing. Tailored for specific user operations.

### CLIHandler
Handles user input and calls necessary controllers.