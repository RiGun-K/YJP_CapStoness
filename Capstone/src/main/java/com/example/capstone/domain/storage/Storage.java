package com.example.capstone.domain.storage;

import javax.persistence.*;

@Entity
@Table(name="STORAGE")
public class Storage {  // 보관소

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) //int.autoincrement
    private long storageCode;

    @Column(length = 50)
    private String storageName;

    @Column(length = 50)
    private String storageZipcode;

    @Column(length = 50)
    private String storageAddress;

    public Storage() {
    }

    public Storage(long storageCode, String storageName, String storageZipcode, String storageAddress) {
        this.storageCode = storageCode;
        this.storageName = storageName;
        this.storageZipcode = storageZipcode;
        this.storageAddress = storageAddress;
    }

    public long getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(long storageCode) {
        this.storageCode = storageCode;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageZipcode() {
        return storageZipcode;
    }

    public void setStorageZipcode(String storageZipcode) {
        this.storageZipcode = storageZipcode;
    }

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

 }
