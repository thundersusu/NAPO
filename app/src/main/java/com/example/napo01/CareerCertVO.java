package com.example.napo01;

public class CareerCertVO {

    private String cert_ser;
    private String certInst;
    private String certDate;

    public CareerCertVO(String cert_ser, String certInst, String certDate) {
        this.cert_ser = cert_ser;
        this.certInst = certInst;
        this.certDate = certDate;
    }

    public String getCert_ser() {
        return cert_ser;
    }

    public void setCert_ser(String cert_ser) {
        this.cert_ser = cert_ser;
    }

    public String getCertInst() {
        return certInst;
    }

    public void setCertInst(String certInst) {
        this.certInst = certInst;
    }

    public String getCertDate() {
        return certDate;
    }

    public void setCertDate(String certDate) {
        this.certDate = certDate;
    }
}
