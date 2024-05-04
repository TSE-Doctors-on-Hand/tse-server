package cmp2804.tse.server.storage.notifications

import cmp2804.tse.server.storage.users.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository interface for notification storage
 *
 * @param [Notification] entity type
 * @param [Long] ID type
 * @author Ben Soones
 */
interface NotificationRepository : JpaRepository<Notification, Long> {
    fun findByUser(user: User): List<Notification>
}