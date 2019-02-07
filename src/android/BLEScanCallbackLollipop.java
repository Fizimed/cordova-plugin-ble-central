package com.megster.cordova.ble.central;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.Handler;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class BLEScanCallbackLollipop extends ScanCallback {
    final BLECentralPlugin service;
    final Handler handler;

    BLEScanCallbackLollipop(BLECentralPlugin service) {
        this.service = service;
        this.handler = new Handler();
    }

    @Override
    public void onScanResult(int callbackType, ScanResult result) {
        service.onLeScan(result.getDevice(), result.getRssi(), result.getScanRecord() == null ? null : result.getScanRecord().getBytes());
    }
}

