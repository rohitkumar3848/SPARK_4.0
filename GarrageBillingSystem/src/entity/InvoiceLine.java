package entity;

import java.math.BigDecimal;

public class InvoiceLine {
    private int id;
    private int invoiceId;
    private int serviceId;
    private int qty;
    private BigDecimal subtotal;



    public InvoiceLine() {}
    public InvoiceLine(int id, int invoiceId, int serviceId, int qty, BigDecimal subtotal) {
        this.id=id; this.invoiceId=invoiceId; this.serviceId=serviceId; this.qty=qty; this.subtotal=subtotal;
    }
    public InvoiceLine(int serviceId, int qty, BigDecimal subtotal) {
        this.serviceId=serviceId; this.qty=qty; this.subtotal=subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }



    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" +
                "id=" + id +
                ", invoiceId=" + invoiceId +
                ", serviceId=" + serviceId +
                ", qty=" + qty +
                ", subtotal=" + subtotal +
                '}';
    }

}
