package cmp2804.tse.server.service

import cmp2804.tse.server.service.base.BaseService
import cmp2804.tse.server.storage.notifications.Notification
import cmp2804.tse.server.storage.notifications.NotificationRepository
import cmp2804.tse.server.storage.users.User
import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.stereotype.Service

/**
 * Notification service
 *
 * This service is responsible for all functions interacting with notifications
 *
 * @author Ben Soones
 */
@Service
class NotificationService(
    private val notificationRepository: NotificationRepository,
): BaseService<Notification, Long> {

    /**
     * Retrieves all notifications of a user
     *
     * @return List of [Notification]
     */
    fun getNotifications(user: User): List<Notification> {
        return notificationRepository.findByUser(user)
    }

    override fun getRepository(): JpaRepository<Notification, Long> = notificationRepository
}