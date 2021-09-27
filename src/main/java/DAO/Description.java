package DAO;

import javax.persistence.*;

@Entity
public class Description {
    @Id
    private int pno;
    private int langCode;
    private String text;
    @OneToOne
    @JoinColumn(name="pno")
    @MapsId
    private Product product;

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public int getLangCode() {
        return langCode;
    }

    public void setLangCode(int langCode) {
        this.langCode = langCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
