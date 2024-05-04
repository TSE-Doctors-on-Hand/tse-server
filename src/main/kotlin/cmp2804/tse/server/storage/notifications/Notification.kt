package cmp2804.tse.server.storage.notifications

import cmp2804.tse.server.storage.users.USER_TABLE_NAME
import cmp2804.tse.server.storage.users.User
import jakarta.persistence.*

const val NOTIFICATION_TABLE_NAME = "notifications"

/**
 * **Notification table**
 *
 * Stores all notifications
 *
 * This table has a relation to a [User]
 *
 * @see [User]
 * @author Ben Soones
 */
@Entity
@Table(name = NOTIFICATION_TABLE_NAME)
data class Notification(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    /**
     * Corresponding user
     * @see [User]
     */
    @JoinColumn(name = "${USER_TABLE_NAME}_id")
    @OneToOne(mappedBy = USER_TABLE_NAME, cascade = [CascadeType.ALL])
    val user: User,

    /**
     * Notification text
     *
     * This will be shown to the user
     */
    val text: String,

    /**
     * This will be used when a user clicks on a notification
     */
    val link: String,

    /**
     * Whether the notificaiton has been seen or not
     */
    val seen: Boolean = false,


    ) {
    constructor() : this(
        null,
        User(),
        "",
        "",
        false,

        )
}