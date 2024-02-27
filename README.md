							Section A: Description
	
	A.1) State of System

 Working Components:

 Addition of Address Entries: Users can successfully add new address entries. This function prompts the user for details like name, address, email, and phone number, creating a comprehensive contact record.
 Listing of Address Entries: The application can list all saved entries in alphabetical order by last name, showcasing its capability to organize and display data effectively.
 Finding Address Entries: The search functionality, based on the beginning or the entirety of the last name, is operational. It returns a list of matching entries, if any, allowing users to quickly locate specific contacts.
 Removal of Address Entries: Users can remove entries from the address book. This is done by first finding the entry using a part of the last name, then selecting the correct entry to remove.

 Components with Issues or Not Working:

 Loading Entries from File: While the system is designed to load entries from a .txt file, this feature has encountered issues. Specifically, [describe any known issues, e.g., "the application does not correctly parse all file formats, leading to incomplete data being loaded"].

 Debugging Efforts:

 Issue Identification: Upon discovering the issue with file loading, initial steps were taken to identify the root cause. Debugging output indicated that the parsing logic fails on certain line formats.
 Breakpoints and Analysis: Breakpoints were inserted at the beginning of the file reading function, as well as immediately before and after parsing logic to inspect variable states. 
 Attempted Fixes: Several fixes were attempted, including modifying the parsing logic to be more robust against varying line formats.
 Current Status: As of the latest debugging session, the file loading feature remains partially operational. Efforts to resolve the issue are ongoing, with plans review alternative parsing libraries or methods to handle file input more reliably.

 Conclusion
The Address Book application is largely functional, with core features like adding, listing, and finding entries working as intended. The primary area of concern revolves around the file loading feature, which is currently under investigation. Debugging efforts have been documented, and solutions are actively being explored to ensure full system functionality.


	A.2) List of Classes
 AddressBook
 Purpose: Serves as the central repository for storing and managing address entries. It allows for the addition, removal, finding, and listing of entries.
 Data Structures/Algorithms: Utilizes a `TreeMap<String, AddressEntry>` to store entries, keyed by the last name of the contacts. This choice of data structure ensures that entries are automatically sorted by the last name, facilitating efficient search operations.
   Loading: O(n log n) for inserting n entries, as each insertion in a TreeMap is O(log n).
   Addition: O(log n), as adding a new entry requires inserting a new element into the TreeMap.
   Removal: O(log n), as removing an entry involves deleting an element from the TreeMap based on its key.
   Find: The find operation benefits from the TreeMap's sorting, allowing for quick retrieval based on last name prefix. Finding entries is O(log n) due to the nature of TreeMap search operations.
   Listing: O(n), as it involves iterating over all entries in the TreeMap to list them.
   Saving: Not explicitly covered, but saving the current state to a file would be O(n), as it requires iterating over each entry to write it to a file.

 AddressEntry
 Purpose: Represents a single address book entry, encapsulating all relevant contact information such as name, address, email, and phone number.
 Data Structures/Algorithms: Primarily uses basic data types (strings, integers) to store information. Efficiency is not directly applicable as it does not involve complex operations or data manipulation.

 Menu
 Purpose: Handles user interaction, allowing for the execution of various operations such as loading from a file, adding, removing, finding, and listing entries, and exiting the program.
 Data Structures/Algorithms: No complex data structures are used within the Menu class itself; it primarily orchestrates calls to AddressBook methods and handles user input/output.
   The efficiency of the Menu operations largely depends on the efficiency of the corresponding operations in the AddressBook class, as the Menu class acts as an interface to these functionalities.

 Efficiency Considerations
The use of a `TreeMap` in the AddressBook class is pivotal for maintaining a sorted collection of address entries, which significantly optimizes find and list operations. While addition and removal operations are not as efficient as in a HashMap (O(1)), the automatic sorting feature of TreeMap (O(log n)) provides a balanced approach between efficiency and functionality, particularly valuable for operations like listing and searching entries which are frequent in an address book context.

The choice of data structures and algorithms directly supports the main operations of the system, striking a balance between operational efficiency and the ease of use expected from an address book application.


	Section B: JavaDoc URL: 

	Section C: UML/Design:


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
<img width="410" alt="image" src="https://github.com/ErmakovGeorge/Ermakov_AddressBook/assets/98370485/d67ee15d-4432-41ec-b8ee-e67d84e528b8">
                                                           
<img width="468" alt="image" src="https://github.com/ErmakovGeorge/Ermakov_AddressBook/assets/98370485/25ad45d3-5fa8-4481-b23f-8c5427cb104d">

Section D: Working Screenshots:
Loading from file 

<img width="468" alt="image" src="https://github.com/ErmakovGeorge/Ermakov_AddressBook/assets/98370485/9404da5f-9508-4101-a6f0-088f5e227218">

<img width="468" alt="image" src="https://github.com/ErmakovGeorge/Ermakov_AddressBook/assets/98370485/624d1493-176f-4b24-960a-4987732dc919">


<img width="468" alt="image" src="https://github.com/ErmakovGeorge/Ermakov_AddressBook/assets/98370485/d9cdadec-9287-43b6-afd8-72fdf138e262">

<img width="468" alt="image" src="https://github.com/ErmakovGeorge/Ermakov_AddressBook/assets/98370485/05ec60cf-6d89-476f-9e44-882155c7f407">

<img width="468" alt="image" src="https://github.com/ErmakovGeorge/Ermakov_AddressBook/assets/98370485/00a920d6-4be7-43d1-a97d-f71837e15a94">

<img width="468" alt="image" src="https://github.com/ErmakovGeorge/Ermakov_AddressBook/assets/98370485/d68a1d22-882a-4aa0-af02-a550e4a4a585">


<img width="468" alt="image" src="https://github.com/ErmakovGeorge/Ermakov_AddressBook/assets/98370485/5f687f56-52fd-482e-a97b-434fb4b553bf">



	Section E: Commit History:


<img width="468" alt="image" src="https://github.com/ErmakovGeorge/Ermakov_AddressBook/assets/98370485/370aed90-e2b5-44aa-87e6-aba49eccb63c">






