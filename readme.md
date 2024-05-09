# TSE - Server

Refer to the setup tutorial on the [main README](https://github.com/tSE-Doctors-on-Hand/#setup-backend)

### Admin Endpoints

| Type  | Link                | Parameters | Description                         |
|-------|---------------------|------------|-------------------------------------|
| `GET` | `/api/admin/insert` |            | Inserts Mock data into the database |

### Auth Endpoints

| Type   | Link                 | Parameters                                                             | Description                                                                                           |
|--------|----------------------|------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|
| `POST` | `/api/auth/register` | [RegisterDTO](./src/main/kotlin/cmp2804/tse/server/dto/RegisterDTO.kt) | Registers a new user. This will add an authorisation token to the user's local storage                |
| `POST` | `/api/auth/login`    | [LoginDTO](./src/main/kotlin/cmp2804/tse/server/dto/LoginDTO.kt)       | Login via a username and a password. This will add an authorisation token to the user's local storage |
| `POST` | `/api/auth/logout`   |                                                                        | Logs out a user. This will remove the authorisation token from the user's local storage               |

### Appointment Endpoints

| Type   | Link                                 | Parameters                                                                                                                                        | Description                                                                                                                 |
|--------|--------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| `PUT`  | `/api/appointment/`                  | [Appointment](./src/main/kotlin/cmp2804/tse/server/storage/appointments/Appointment.kt)                                                           | This adds an appointment to the database                                                                                    |
| `GET`  | `/api/appointment/all`               |                                                                                                                                                   | Retrieves all appointments viewable by the sender                                                                           |
| `GET`  | `/api/appointment/{id}`              | `AppointmentID`: A Long representing an Appointment's ID                                                                                          | Retrieves an appointment by its ID, if the user is allowed to view this appointment                                         |
| `GET`  | `/api/appointment/{id}/status`       | `AppointmentID`: A Long representing an Appointment's ID                                                                                          | Retrieves an appointment's status by its ID, if the user is allowed to view this appointment                                |
| `PUT`  | `/api/appointment/{id}/status`       | `AppointmentID`: A Long representing an Appointment's ID                                                                                          | Edit's an appointment's status by its ID, if the user is allowed to edit this appointment                                   |
| `POST` | `/api/appointment/{id}/date/suggest` | `AppointmentID`: A Long representing an Appointment's ID <br/> `SuggestedDate`: A long representing the timestamp of the selected appointment     | Suggests a date (by a Doctor) for an appointment by its ID, if the user is a doctor and is allowed to edit this appointment |
| `POST` | `/api/appointment/{id}/approve`      | `AppointmentID`: A Long representing an Appointment's ID                                                                                          | Approves a date (by a Patient) for an appointment by its ID. if the user is allowed to approve appointment dates            |
| `PUT`  | `/api/appointment/{id}/reject`       | `AppointmentID`: A Long representing an Appointment's ID <br/> `SuggestedDate`: A new long representing the timestamp of the selected appointment | Rejects a date (by a Patient or Doctor) for an appointment, suggesting a new one.                                           |

### Doctor Endpoints

| Type   | Link                | Parameters                                                                     | Description                                                                         |
|--------|---------------------|--------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| `POST` | `/api/doctor/match` | [DoctorSearchDTO](./src/main/kotlin/cmp2804/tse/server/dto/DoctorSearchDTO.kt) | Retrieves all matching Doctors based on the `DoctorSearchDTO` data transfer object. |
| `GET`  | `/api/doctor/{id}`  | `DoctorID`: A long representing a Doctor's ID                                  | Retrieves a Doctor by its ID, if the user is allowed to view this information       |

### Symptom Endpoints

| Type  | Link                | Parameters                                      | Description                   |
|-------|---------------------|-------------------------------------------------|-------------------------------|
| `GET` | `/api/symptom/{id}` | `SymptomId`: A long representing a Symptom's ID | Retrieves a Symptom by its ID |
| `GET` | `/api/symptom/all`  |                                                 | Retrieves all Symptoms        |

### User Endpoints

| Type     | Link                          | Parameters                                | Description                                                            |
|----------|-------------------------------|-------------------------------------------|------------------------------------------------------------------------|
| `GET`    | `/api/user/all`               |                                           | Retrieves all Users the requester is allowed to see                    |
| `GET`    | `/api/user/{id}`              | `UserID`: A long representing a User's ID | Retrieves a User by their ID, if the requester is allowed to access it |
| `GET`    | `/api/user/`                  |                                           | Gets the requester's User object if they are logged in                 |
| `PUT`    | `/api/user/`                  |                                           | Edits the requester's User object if they are logged in                |
| `DELETE` | `/api/user/`                  |                                           | Deletes the requester's User object if they are logged in              |
| `GET`    | `/api/user/notifications/all` |                                           | Retrieves all requester's notifications if they are logged in          |
| `GET`    | `/api/user/notifications/new` |                                           | Retrieves all requester's **new** notifications if they are logged in  |

