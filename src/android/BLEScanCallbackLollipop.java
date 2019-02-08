package com.megster.cordova.ble.central;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.Handler;

import java.util.List;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class BLEScanCallbackLollipop extends ScanCallback {
    final com.megster.cordova.ble.central.BLECentralPlugin service;
    final Handler handler;

    BLEScanCallbackLollipop(com.megster.cordova.ble.central.BLECentralPlugin service) {
        this.service = service;
        this.handler = new Handler();
    }

    @Override
    public void onScanResult(int callbackType, ScanResult result) {
        service.onLeScan(result.getDevice(), result.getRssi(), result.getScanRecord() == null ? null : result.getScanRecord().getBytes());
    }

    @Override
    public void onBatchScanResults(List<ScanResult> results) {
        for (ScanResult result : results) {
            service.onLeScan(result.getDevice(), result.getRssi(), result.getScanRecord() == null ? null : result.getScanRecord().getBytes());
        }
    }

    @Override
    public void onScanFailed(int errorCode) {
        if (errorCode != SCAN_FAILED_ALREADY_STARTED) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //  service.onDiscoveryCanceled();
                }
            });
        }
    }
}
