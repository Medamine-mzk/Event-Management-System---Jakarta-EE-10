
# Event Management System (EMS)

## Description
The Event Management System (EMS) is a web-based application that allows users to manage events. The application enables users to create, edit, and delete events. It also allows users to view event details and register for events.

This system is built using Jakarta EE 10, and it can be deployed on application servers like TomEE or Payara. The application provides CRUD operations for managing events and utilizes a relational database for storing event data.

## Features
- **Create Event**: Allows users to create events with details such as title, description, and event date.
- **Edit Event**: Users can update event details.
- **Delete Event**: Allows users to delete events.
- **View Events**: Displays a list of all events with the option to register.
- **Responsive Design**: The application is fully responsive, built with Bootstrap for a mobile-friendly interface.

## Technologies Used
- **Backend**: Jakarta EE 10
- **Frontend**: JSP, JSTL, Bootstrap
- **Database**: MySQL (or other databases like MongoDB, Firebase, or PostgreSQL based on user preference)
- **Application Server**: TomEE or Payara (Web Profile)

## Setup Instructions
1. Clone the repository:
    ```bash
    git clone <https://github.com/Medamine-mzk/Event-Management-System---Jakarta-EE-10>
    ```

2. Navigate to the project directory:
    ```bash
    cd event-management-system
    ```

3. Setup the database:
   - If you are using MySQL, create a database `ems_db`.
   - Alternatively, you can choose a different database like PostgreSQL, MongoDB, etc.

4. Configure the database connection in `persistence.xml` (found in `WEB-INF`).

5. Deploy the application on your server:
   - Use TomEE or Payara for deployment. Make sure you select the Web Profile during setup.

6. Start the application and access it in your browser:
    ```bash
    http://localhost:8080/EMS_war_exploded
    ```

## How to Use
1. **Login/Registration**: If authentication is required, users can log in with their credentials.
2. **Create Event**: Navigate to the 'Create Event' page and fill in the form to create a new event.
3. **Edit/Delete Event**: Use the options next to the event to edit or delete existing events.
4. **Register for Event**: Users can register for available events.

## Contribution Guidelines
- Fork the repository.
- Create a new branch for your feature.
- Make changes and create a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements
- **Bootstrap**: For responsive design.
- **Jakarta EE**: For providing the framework to build enterprise-grade applications.
