package com.example.individualproject;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import android.bluetooth.BluetoothSocket;

public class AddingFragment extends Fragment {

    ListView lv;
    Button connectBtn;
    BluetoothAdapter bluetoothAdapter;
    static BluetoothDevice selectedDevice;
    BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
    static BluetoothSocket clientSocket;

    public AddingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adding, container, false);
        lv = (ListView) view.findViewById(R.id.deviceListView);
        connectBtn = (Button) view.findViewById(R.id.connectBtn);
        connectBtn.setVisibility(View.INVISIBLE);

        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    //Инициируем соединение с устройством
                    Method m = selectedDevice.getClass().getMethod(
                            "createRfcommSocket", new Class[] {int.class});

                    clientSocket = (BluetoothSocket) m.invoke(selectedDevice, 1);
                    clientSocket.connect();

                    //В случае появления любых ошибок, выводим в лог сообщение
                } catch (IOException e) {
                    Toast.makeText(getActivity().getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                } catch (SecurityException e) {
                    Toast.makeText(getActivity().getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                } catch (NoSuchMethodException e) {
                    Toast.makeText(getActivity().getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                } catch (IllegalArgumentException e) {
                    Toast.makeText(getActivity().getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                } catch (IllegalAccessException e) {
                    Toast.makeText(getActivity().getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                } catch (InvocationTargetException e) {
                    Toast.makeText(getActivity().getApplicationContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(getActivity().getApplicationContext(), "Успешно подключено", Toast.LENGTH_LONG).show();
            }
        });

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getActivity().getApplicationContext(), "Ваше устройство не поддерживает Bluetooth", Toast.LENGTH_SHORT).show();
        }//проверка поддерживаемости bluetooth на устройстве
        String enableBT = BluetoothAdapter.ACTION_REQUEST_ENABLE;
        startActivityForResult(new Intent(enableBT), 0);//запрос на включение bluetooth

        pairedDevicesAdapter adapter = new pairedDevicesAdapter(getActivity().getApplicationContext(), getMyBondedDevices());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                MyBTDevice dev = (MyBTDevice) adapterView.getItemAtPosition(position);
                selectedDevice = bluetooth.getRemoteDevice(dev.address);
                Toast.makeText(getActivity().getApplicationContext(), "Выбрано устройство: " + dev.name, Toast.LENGTH_SHORT).show();
                connectBtn.setVisibility(View.VISIBLE);

            }
        });
        return view;
    }

    private ArrayList<MyBTDevice> getMyBondedDevices() {

        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        ArrayList<MyBTDevice> arrOfBondedDevices = new ArrayList<>();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device: pairedDevices) {
                String ad = device.getAddress();
                MyBTDevice dev = new MyBTDevice(device.getName(), device.getAddress());
                arrOfBondedDevices.add(dev);
            }
            return arrOfBondedDevices;
        }
        else {
            Toast.makeText(getActivity().getApplicationContext(), "Произведите сопряжение с Bluetooth-устройством", Toast.LENGTH_SHORT).show();
            ArrayList<MyBTDevice> emptyArr = new ArrayList<>();
            return emptyArr;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}