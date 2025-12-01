package entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Invoice {
    private int id;
    private int customerId;
    private int vehicleId;
    private LocalDateTime createdAt;
    private List<InvoiceLine> lines = new ArrayList<>();

    public Invoice() {}
    public Invoice(int id, int customerId, int vehicleId, LocalDateTime createdAt) {
        this.id=id; this.customerId=customerId; this.vehicleId=vehicleId; this.createdAt=createdAt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", vehicleId=" + vehicleId +
                ", createdAt=" + createdAt +
                ", lines=" + lines +
                '}';
    }
}
