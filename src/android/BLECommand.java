package com.megster.cordova.ble.central;

import org.apache.cordova.CallbackContext;

import java.util.UUID;

class BLECommand {
    // Types
    public static int READ = 10000;
    public static int REGISTER_NOTIFY = 10001;
    public static int REMOVE_NOTIFY = 10002;
    public static int READ_RSSI = 10003;

    private CallbackContext callbackContext;
    private UUID serviceUUID;
    private UUID characteristicUUID;
    private byte[] data;
    private int type;


    public BLECommand(CallbackContext callbackContext, UUID serviceUUID, UUID characteristicUUID, int type) {
        this.callbackContext = callbackContext;
        this.serviceUUID = serviceUUID;
        this.characteristicUUID = characteristicUUID;
        this.type = type;
    }

    public BLECommand(CallbackContext callbackContext, UUID serviceUUID, UUID characteristicUUID, byte[] data, int type) {
        this.callbackContext = callbackContext;
        this.serviceUUID = serviceUUID;
        this.characteristicUUID = characteristicUUID;
        this.data = data;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public CallbackContext getCallbackContext() {
        return callbackContext;
    }

    public UUID getServiceUUID() {
        return serviceUUID;
    }

    public UUID getCharacteristicUUID() {
        return characteristicUUID;
    }

    public byte[] getData() {
        return data;
    }
}
