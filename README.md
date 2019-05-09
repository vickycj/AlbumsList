# AlbumsList
Shows list of albums

Architecture Design Pattern - MVVM (Model View ViewModel) 

Tech Stack
-----------

- Programming language    - Kotlin
- NetWork API             - RetroFit
- Dependancy Injection    - Dagger 2 for Kotlin
- Offline Storing         - Room ORM (Arch components)
- Streams                 - RxAndroid and LiveData
- Architecture Components - ViewModel, LiveData, Android JetPAck Components
- Testing Framework       - Junit, Mockito , Expresso, AndroidJunit4

App Usage
----------

--Home page - Checks the local/offline data is avalilabe or not using the table count
--Home page - if count is 0 then Fetches data from the server and stores it in the ROOM SQL lite
--Home page - else it observes the room data table, hence any insertion will update the UI automatically using LIveData


Future Improvements
--------------------

- Use Workmanager for fetching the data from server frequently in the background and update the local storage 
- Grouping the collection using album id , and fetch corresponding data in seperate fragment
- Provide search functionality in the App bar 



