package com.example.yjp_capstone.domain.storage;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column
    private String storageDetailAddress;


    @Column
    private double latitude;//위도
    @Column
    private double longitude;//경도

    @Column
    private String storageState = "0";

    @JsonManagedReference
    @OneToMany(mappedBy = "storageCode",cascade = CascadeType.ALL)
    private List<StorageBox> storageBoxes = new ArrayList<>();


    public Storage() {
    }

    public Storage(String storageName, String storageZipcode, String storageAddress, String storageDetailAddress, double latitude, double longitude, String storageState, List<StorageBox> storageBoxes) {
        this.storageName = storageName;
        this.storageZipcode = storageZipcode;
        this.storageAddress = storageAddress;
        this.storageDetailAddress = storageDetailAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.storageState = storageState;
        this.storageBoxes = storageBoxes;
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

    public String getStorageDetailAddress() {
        return storageDetailAddress;
    }

    public void setStorageDetailAddress(String storageDetailAddress) {
        this.storageDetailAddress = storageDetailAddress;
    }

    public String getStorageState() {
        return storageState;
    }

    public void setStorageState(String storageState) {
        this.storageState = storageState;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<StorageBox> getStorageBoxes() {
        return storageBoxes;
    }

    public void setStorageBoxes(List<StorageBox> storageBoxes) {
        this.storageBoxes = storageBoxes;
    }
 }
