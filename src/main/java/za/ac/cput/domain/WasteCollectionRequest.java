package za.ac.cput.domain;

public class WasteCollectionRequest {

    private String requestId;// optional
    private User resident;
    private PickUpSchedule schedule;
    private Payment payment;
    private PrivateCollector privateCollector;
    private PublicCollector publicCollector;

    private WasteCollectionRequest(Builder builder) {
        this.requestId = builder.requestId;
        this.resident = builder.resident;
        this.schedule = builder.schedule;
        this.payment = builder.payment;
        this.privateCollector = builder.privateCollector;
        this.publicCollector = builder.publicCollector;
    }

    public boolean isPickupScheduled() {
        return schedule != null;
    }

    public String getRequestId() {
        return requestId;
    }

    public User getResident() {
        return resident;
    }

    public PickUpSchedule getSchedule() {
        return schedule;
    }

    public Payment getPayment() {
        return payment;
    }

    public PrivateCollector getPrivateCollector() {
        return privateCollector;
    }

    public PublicCollector getPublicCollector() {
        return publicCollector;
    }

    // Builder class
    public static class Builder {
        private String requestId;
        private User resident;
        private PickUpSchedule schedule;
        private Payment payment;
        private PrivateCollector privateCollector;
        private PublicCollector publicCollector;

        public Builder setRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder setResident(User resident) {
            this.resident = resident;
            return this;
        }

        public Builder setSchedule(PickUpSchedule schedule) {
            this.schedule = schedule;
            return this;
        }

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder setPrivateCollector(PrivateCollector privateCollector) {
            this.privateCollector = privateCollector;
            return this;
        }

        public Builder setPublicCollector(PublicCollector publicCollector) {
            this.publicCollector = publicCollector;
            return this;
        }

        public WasteCollectionRequest build() {
            if (requestId == null || resident == null) {
                throw new IllegalStateException("requestId and resident cannot be null");
            }
            return new WasteCollectionRequest(this);
        }
    }
}