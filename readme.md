# TSE - Server

## Endpoints

| Type   | Link                                                | Parameters    | Description                                                                                                                                   |
|--------|-----------------------------------------------------|---------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
|        |                                                     | Create a user |                                                                                                                                               |
|        |                                                     | Sign in user  |                                                                                                                                               |
|        |                                                     |               | Forgot password                                                                                                                               |
|        |                                                     |               | Sign in via app                                                                                                                               |
| `GET`  | `/api/appointment/all`                              |               | Get all appointments retaining to a user                                                                                                      |
| `GET`  | `/api/appointment/{id}`                             |               | Get an appointment by its ID                                                                                                                  |
| `GET`  | `/api/appointment/{id}/status`                      |               | Get the status of an appointment.(See [AppointmentStatus.kt](./src/main/kotlin/cmp2804/tse/server/storage/appointments/AppointmentStatus.kt)) |
| `PUT`  | `/api/appointment/{id}/status`                      |               | Set an appointment's status                                                                                                                   |
| `POST` | `/api/appointment/{id}/date/suggest/{datetime}`     |               | Suggest a date for an appointment as a doctor.                                                                                                |
| `POST` | `/api/appointment/{id}/date/approve`                |               | Approve a date for an appointment as a patient.                                                                                               |
| `POST` | `/api/appointment/{id}/date/reject/{newDatetimess}` |               | Reject a date for an appointment as a patient.                                                                                                |
| `POST` | `/api/doctor/acceptingAppointments/{state}`         |               | As a doctor, set your accepting appointments toggle                                                                                           |
| `GET`  | `/api/doctor/range/{lat}/{long}/range`              |               | Get all doctors within a KM range of a lat-long                                                                                               |
| `GET`  | `/api/patient/notifications/new`                    |               | Get all new notifications                                                                                                                     |
| `GET`  | `/api/patient/notifications/all`                    |               | Get all stored notifications                                                                                                                  |
