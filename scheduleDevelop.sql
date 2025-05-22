-- 사용자 테이블
CREATE TABLE `user` (
                        `user_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                        `email` VARCHAR(255) NOT NULL,
                        `password` VARCHAR(255) NOT NULL,
                        `username` VARCHAR(255) NOT NULL,
                        `create_at` DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6),
                        `update_at` DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)
)

CREATE TABLE `schedule` (
                            `schedule_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                            `user_id` BIGINT NOT NULL,
                            `title` VARCHAR(255) NOT NULL,
                            `contents` LONGTEXT,
                            `create_at` DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6),
                            `update_at` DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
                            FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
)

CREATE TABLE `comment` (
                           `comment_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                           `schedule_id` BIGINT NOT NULL,
                           `user_id` BIGINT NOT NULL,
                           `comment_contents` LONGTEXT,
                           `create_at` DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6),
                           `update_at` DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
                           FOREIGN KEY (`schedule_id`) REFERENCES `schedule`(`schedule_id`) ON DELETE CASCADE,
                           FOREIGN KEY (`user_id`) REFERENCES `user`(`user_id`) ON DELETE CASCADE
)
