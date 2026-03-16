package za.ac.cput.domain;
import java.time.LocalDateTime;

public class Notifications {

    private int notificationsID;
    private String message;
    private String notificationsType;
    private LocalDateTime dateSent;
    private String status;
    private int userID;

    private Notifications(Builder builder) {
        this.notificationsID = builder.notificationsID;
        this.message = builder.message;
        this.notificationsType = builder.notificationsType;
        this.dateSent = builder.dateSent;
        this.status = builder.status;
        this.userID = builder.userID;
    }

    public int getNotificationsID() {
        return notificationsID;
    }

    public String getMessage() {
        return message;
    }

    public String getNotificationsType() {
        return notificationsType;
    }

    public LocalDateTime getDateSent() {
        return dateSent;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder {

        private int notificationsID;
        private String message;
        private String notificationsType;
        private LocalDateTime dateSent;
        private String status;
        private int userID;

        public Builder setNotificationsID(int notificationsID) {
            this.notificationsID = notificationsID;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setNotificationsType(String notificationsType) {
            this.notificationsType = notificationsType;
            return this;
        }

        public Builder setDateSent(LocalDateTime dateSent) {
            this.dateSent = dateSent;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setUserID(int userID) {
            this.userID = userID;
            return this;
        }

        public Notifications build() {
            return new Notifications(this);
        }
    }
}

