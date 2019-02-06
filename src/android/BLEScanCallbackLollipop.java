package com.siliconlabs.bledemo.ble;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.Handler;
import timber.log.Timber;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class BLEScanCallbackLollipop extends ScanCallback {
    final BlueToothService service;
    final Handler handler;

    BLEScanCallbackLollipop(BlueToothService service) {
        this.service = service;
        this.handler = new Handler();
    }

    @Override
    public void onScanResult(int callbackType, ScanResult result) {
        final BluetoothDevice device = result.getDevice();

        Timber.d("Discovered bluetoothLE +" + result.toString());
        //Log.d("onScanResult","Discovered bluetoothLE +" + result.toString());
        if (service.addDiscoveredDevice(ScanResultCompat.from(result))) {
            service.bluetoothAdapter.getBluetoothLeScanner().stopScan(this);
        }
    }
}
