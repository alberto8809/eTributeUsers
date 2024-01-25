package org.example.users.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.example.users.util.EncryptionUtil;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long account_id;
    private String account_name;
    private String rfc;
    private String regimen;
    private String cer;
    private String key_value;
    private String e_firma;


    public Account() {
    }

    public Account(String account_name, String rfc, String regimen, String cer, String key_value, String e_firma) {
        this.account_name = account_name;
        this.rfc = rfc;
        this.regimen = regimen;
        this.cer = cer;
        this.key_value = key_value;
        this.e_firma = e_firma;
    }

    public long getAccount_id() {return account_id;}

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getAccount_name() {return account_name;}

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getRfc() {return rfc;}

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRegimen() {return regimen;}

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getCer() {
        return EncryptionUtil.decrypt(cer);
    }

    public void setCer(String cer) {this.cer =EncryptionUtil.encrypt(cer);}

    public String getKey_value() {
        return EncryptionUtil.decrypt(key_value);
    }

    public void setKey_value(String key_value) {
        this.key_value = EncryptionUtil.encrypt(key_value);
    }

    public String getE_firma() {return EncryptionUtil.decrypt(e_firma);}

    public void setE_firma(String e_firma) {
        this.e_firma = EncryptionUtil.encrypt(e_firma);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "account_id=" + account_id +
                ", account_name='" + account_name + '\'' +
                ", rfc='" + rfc + '\'' +
                ", regimen='" + regimen + '\'' +
                ", cer='" + cer + '\'' +
                ", key_value='" + key_value + '\'' +
                ", e_firma='" + e_firma + '\'' +
                '}';
    }
}
