package com.example.appproto01;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.TableArrangement;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
import com.google.appinventor.components.runtime.Web;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Color;
import android.os.CountDownTimer;

import static com.example.appproto01.GeneralApplicationSettings.EXTERNALLY_STORED_1;

public class MainActivity extends Form implements HandlesEventDispatching {

    private
    VerticalScrollArrangement Screen1;
    HorizontalArrangement HorizontalArrangement1, HorizontalArrangement2, HorizontalArrangement3, HorizontalArrangement4, HorizontalArrangement5;
    VerticalArrangement VerticalArrangement1;
    TableArrangement LocalNetworkSetup;
    Label TimeUntilRefreshNull, TimeUntilRefresh, lbl_IP, lbl_DeviceName, Co2, Co2Reading, Co2Measurement, TVOC, TVOCReading, TVOCMeasurement, Temp, TempReading, TempMeasurement, Logo;
    Button FindDeviceButton;
    Web  RelayConnection, RelayConnectionCO2, RelayConnectionVOC, RelayConnectionCELCIUS;
    Notifier notifier_Messages;
    TextBox txt_DeviceName, txt_IP;
    int TimeLeft;
    private static final String URL_MAIN = EXTERNALLY_STORED_1;

    protected void $define() {
        this.Sizing("Responsive");
        Screen1 = new VerticalScrollArrangement(this);
        notifier_Messages = new Notifier(this);
        Screen1.HeightPercent(100);
        Screen1.WidthPercent(100);
        Screen1.AlignVertical(1);
        Screen1.AlignHorizontal(1);
        Screen1.BackgroundColor(Color.parseColor("#FA1E0E"));


        HorizontalArrangement1 = new HorizontalArrangement(Screen1);
        HorizontalArrangement1.HeightPercent(5);
        HorizontalArrangement1.WidthPercent(100);
        HorizontalArrangement1.BackgroundColor(Color.parseColor("#FFFFFF"));

        Logo = new Label(HorizontalArrangement1);
        Logo.Text("RED TEAM™");
        Logo.FontBold(true);
        Logo.FontSize(20);
        Logo.TextAlignment(0);
        Logo.TextColor(Color.parseColor("#ff595e"));
        Logo.FontItalic(true);


        VerticalArrangement1 = new VerticalArrangement(Screen1);
        VerticalArrangement1.HeightPercent(35);
        VerticalArrangement1.WidthPercent(100);

        LocalNetworkSetup = new TableArrangement(VerticalArrangement1);
        LocalNetworkSetup.WidthPercent(100);
        LocalNetworkSetup.HeightPercent(10);
        LocalNetworkSetup.Columns(3);
        LocalNetworkSetup.Rows(2);

        lbl_DeviceName = new Label(LocalNetworkSetup);
        lbl_DeviceName.Text("Device Name:");
        lbl_DeviceName.FontSize(15);
        lbl_DeviceName.Column(0);
        lbl_DeviceName.Row(0);
        lbl_DeviceName.HeightPercent(5);
        lbl_DeviceName.WidthPercent(25);
        lbl_DeviceName.TextAlignment(1);
        lbl_DeviceName.TextColor(Color.parseColor("#FFFFFF"));

        txt_DeviceName = new TextBox(LocalNetworkSetup);
        txt_DeviceName.Text("TCFE-CO2-49-8F");
        txt_DeviceName.Column(1);
        txt_DeviceName.Row(0);
        txt_DeviceName.HeightPercent(5);
        txt_DeviceName.WidthPercent(50);
        txt_DeviceName.FontSize(15);
        txt_DeviceName.TextColor(Color.parseColor("#FFFFFF"));

        FindDeviceButton = new Button(LocalNetworkSetup);
        FindDeviceButton.HeightPercent(5);
        FindDeviceButton.WidthPercent(25);
        FindDeviceButton.FontBold(true);
        FindDeviceButton.FontSize(16);
        FindDeviceButton.Text("CONNECT");
        FindDeviceButton.TextAlignment(1);
        FindDeviceButton.BackgroundColor(Component.COLOR_WHITE);
        FindDeviceButton.Shape(Component.BUTTON_SHAPE_DEFAULT);
        FindDeviceButton.Column(2);
        FindDeviceButton.Row(0);

        lbl_IP = new Label(LocalNetworkSetup);
        lbl_IP.Text("IP Address:");
        lbl_IP.FontSize(15);
        lbl_IP.Column(0);
        lbl_IP.Row(1);
        lbl_IP.HeightPercent(5);
        lbl_IP.WidthPercent(25);
        lbl_IP.TextAlignment(1);
        lbl_IP.TextColor(Color.parseColor("#FFFFFF"));

        txt_IP = new TextBox(LocalNetworkSetup);
        txt_IP.Column(1);
        txt_IP.Row(1);
        txt_IP.HeightPercent(5);
        txt_IP.WidthPercent(50);
        txt_IP.FontSize(15);
        txt_IP.TextColor(Color.parseColor("#FFFFFF"));

        HorizontalArrangement2 = new HorizontalArrangement(Screen1);
        HorizontalArrangement2.AlignHorizontal(1);
        HorizontalArrangement2.AlignVertical(1);
        HorizontalArrangement2.HeightPercent(10);
        HorizontalArrangement2.WidthPercent(100);
        HorizontalArrangement2.BackgroundColor(Color.parseColor("#8C0000"));

        Co2 = new Label(HorizontalArrangement2);
        Co2.HeightPercent(10);
        Co2.WidthPercent(30);
        Co2.Text("CO2:");
        Co2.TextColor(Color.parseColor("#FFFFFF"));
        Co2.TextAlignment(2);
        Co2.HasMargins(false);
        Co2.FontBold(true);
        Co2.FontSize(38);
        Co2.FontItalic(true);
        Co2.HasMargins(false);
        Co2.FontItalic(true);

        Co2Reading = new Label(HorizontalArrangement2);
        Co2Reading.HeightPercent(10);
        Co2Reading.WidthPercent(40);
        Co2Reading.Text("");
        Co2Reading.TextColor(Color.parseColor("#FFFFFF"));
        Co2Reading.TextAlignment(1);
        Co2Reading.HasMargins(false);
        Co2Reading.FontBold(true);
        Co2Reading.FontSize(38);
        Co2Reading.FontItalic(true);
        Co2Reading.HasMargins(false);
        Co2Reading.FontItalic(true);

        Co2Measurement = new Label(HorizontalArrangement2);
        Co2Measurement.HeightPercent(10);
        Co2Measurement.WidthPercent(30);
        Co2Measurement.Text("ppm");
        Co2Measurement.TextColor(Color.parseColor("#FFFFFF"));
        Co2Measurement.TextAlignment(0);
        Co2Measurement.HasMargins(false);
        Co2Measurement.FontBold(true);
        Co2Measurement.FontSize(38);
        Co2Measurement.FontItalic(true);
        Co2Measurement.HasMargins(false);
        Co2Measurement.FontItalic(true);


        HorizontalArrangement3 = new HorizontalArrangement(Screen1);
        HorizontalArrangement3.AlignHorizontal(1);
        HorizontalArrangement3.AlignVertical(1);
        HorizontalArrangement3.HeightPercent(10);
        HorizontalArrangement3.WidthPercent(100);
        HorizontalArrangement3.BackgroundColor(Color.parseColor("#BD2000"));

        TVOC = new Label(HorizontalArrangement3);
        TVOC.HeightPercent(10);
        TVOC.WidthPercent(30);
        TVOC.Text("TVOC:");
        TVOC.TextColor(Color.parseColor("#FFFFFF"));
        TVOC.TextAlignment(2);
        TVOC.HasMargins(false);
        TVOC.FontBold(true);
        TVOC.FontSize(38);
        TVOC.FontItalic(true);
        TVOC.HasMargins(false);
        TVOC.FontItalic(true);

        TVOCReading = new Label(HorizontalArrangement3);
        TVOCReading.HeightPercent(10);
        TVOCReading.WidthPercent(40);
        TVOCReading.Text("");
        TVOCReading.TextColor(Color.parseColor("#FFFFFF"));
        TVOCReading.TextAlignment(1);
        TVOCReading.HasMargins(false);
        TVOCReading.FontBold(true);
        TVOCReading.FontSize(38);
        TVOCReading.FontItalic(true);
        TVOCReading.HasMargins(false);
        TVOCReading.FontItalic(true);

        TVOCMeasurement = new Label(HorizontalArrangement3);
        TVOCMeasurement.HeightPercent(10);
        TVOCMeasurement.WidthPercent(30);
        TVOCMeasurement.Text("ppm");
        TVOCMeasurement.TextColor(Color.parseColor("#FFFFFF"));
        TVOCMeasurement.TextAlignment(0);
        TVOCMeasurement.HasMargins(false);
        TVOCMeasurement.FontBold(true);
        TVOCMeasurement.FontSize(38);
        TVOCMeasurement.FontItalic(true);
        TVOCMeasurement.HasMargins(false);
        TVOCMeasurement.FontItalic(true);


        HorizontalArrangement4 = new HorizontalArrangement(Screen1);
        HorizontalArrangement4.AlignHorizontal(1);
        HorizontalArrangement4.AlignVertical(1);
        HorizontalArrangement4.HeightPercent(10);
        HorizontalArrangement4.WidthPercent(100);
        HorizontalArrangement4.BackgroundColor(Color.parseColor("#FF2626"));

        Temp = new Label(HorizontalArrangement4);
        Temp.HeightPercent(10);
        Temp.WidthPercent(30);
        Temp.Text("TEMP:");
        Temp.TextColor(Color.parseColor("#FFFFFF"));
        Temp.TextAlignment(2);
        Temp.HasMargins(false);
        Temp.FontBold(true);
        Temp.FontSize(38);
        Temp.FontItalic(true);
        Temp.HasMargins(false);
        Temp.FontItalic(true);

        TempReading = new Label(HorizontalArrangement4);
        TempReading.HeightPercent(10);
        TempReading.WidthPercent(40);
        TempReading.Text("");
        TempReading.TextColor(Color.parseColor("#FFFFFF"));
        TempReading.TextAlignment(1);
        TempReading.HasMargins(false);
        TempReading.FontBold(true);
        TempReading.FontSize(38);
        TempReading.FontItalic(true);
        TempReading.HasMargins(false);
        TempReading.FontItalic(true);

        TempMeasurement = new Label(HorizontalArrangement4);
        TempMeasurement.HeightPercent(10);
        TempMeasurement.WidthPercent(30);
        TempMeasurement.Text("C°");
        TempMeasurement.TextColor(Color.parseColor("#FFFFFF"));
        TempMeasurement.TextAlignment(0);
        TempMeasurement.HasMargins(false);
        TempMeasurement.FontBold(true);
        TempMeasurement.FontSize(38);
        TempMeasurement.FontItalic(true);
        TempMeasurement.HasMargins(false);
        TempMeasurement.FontItalic(true);


        HorizontalArrangement5 = new HorizontalArrangement(Screen1);
        HorizontalArrangement5.HeightPercent(25);
        HorizontalArrangement5.WidthPercent(100);

//        TimeUntilRefreshNull = new Label(HorizontalArrangement5);
//        TimeUntilRefreshNull.WidthPercent(100);
//        TimeUntilRefreshNull.HeightPercent(5);
//        TimeUntilRefreshNull.TextAlignment(1);
//        TimeUntilRefreshNull.Text("Waiting For Data");
//        TimeUntilRefreshNull.FontBold(true);
//        TimeUntilRefreshNull.FontItalic(true);
//        TimeUntilRefreshNull.TextColor(Color.parseColor("#FFFFFF"));
//
//        TimeUntilRefresh = new Label(HorizontalArrangement5);
//        TimeUntilRefresh.WidthPercent(100);
//        TimeUntilRefresh.HeightPercent(5);
//        TimeUntilRefresh.TextAlignment(1);
//        TimeUntilRefresh.Text(String.valueOf(TimeLeft));
//        TimeUntilRefresh.FontBold(true);
//        TimeUntilRefresh.FontItalic(true);
//        TimeUntilRefresh.TextColor(Color.parseColor("#FFFFFF"));

        RelayConnection = new Web(this);
        RelayConnectionCO2 = new Web(this);
        RelayConnectionVOC = new Web(this);
        RelayConnectionCELCIUS = new Web(this);


        EventDispatcher.registerEventForDelegation(this, formName, "BackPressed");
        EventDispatcher.registerEventForDelegation(this, formName, "Click");
        EventDispatcher.registerEventForDelegation(this, formName, "GotText");
    }

        public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {
            System.err.print("dispatchEvent: " + formName + " [" + component.toString() + "] [" + componentName + "] " + eventName);
            if (eventName.equals("BackPressed")) {
                return true;
            } else if (eventName.equals("GotText")) {
                if (component.equals(RelayConnection)) {
                    dbg("A");
                    String status = params[1].toString();
                    String textOfResponse = (String) params[3];
                    handler_Response(component, status, textOfResponse);
                    return true;
                }
                if (component.equals(RelayConnectionCO2)) {
                    dbg("B");
                    String status = params[1].toString();
                    String textOfResponse = (String) params[3];
                    handler_Response(component, status, textOfResponse);
                    return true;
                }
                if (component.equals(RelayConnectionVOC)) {
                    dbg("C");
                    String status = params[1].toString();
                    String textOfResponse = (String) params[3];
                    handler_Response(component, status, textOfResponse);
                    return true;
                }
                if (component.equals(RelayConnectionCELCIUS)) {
                    dbg("D");
                    String status = params[1].toString();
                    String textOfResponse = (String) params[3];
                    handler_Response(component, status, textOfResponse);
                    return true;
                }

            } else if (eventName.equals("Click")) {
                if (component.equals(FindDeviceButton)) {
                    dbg("E");
                    RelayConnection.Url(makeGetString_IPv4());
                    RelayConnectionCO2.Url(makeGetString_Co2());
                    RelayConnectionVOC.Url(makeGetString_VOC());
                    RelayConnectionCELCIUS.Url(makeGetString_CELCIUS());
                    RelayConnection.Get();
                    RelayConnectionCO2.Get();
                    RelayConnectionVOC.Get();
                    RelayConnectionCELCIUS.Get();
                }
            return true;
        }
        return false;
    }

    String makeGetString_IPv4(){
        String test1 = URL_MAIN+"?device=";
        test1+= txt_DeviceName.Text();
        test1+="&";
        test1+="sensor=IPv4";
        return test1;
    }

    String makeGetString_Co2(){
        String test1 = URL_MAIN+"?device=";
        test1+= txt_DeviceName.Text();
        test1+="&";
        test1+="sensor=CO2";
        return test1;
    }

    String makeGetString_VOC(){
        String test1 = URL_MAIN+"?device=";
        test1+= txt_DeviceName.Text();
        test1+="&";
        test1+="sensor=VOC";
        return test1;
    }

    String makeGetString_CELCIUS(){
        String test1 = URL_MAIN+"?device=";
        test1+= txt_DeviceName.Text();
        test1+="&";
        test1+="sensor=CELCIUS";
        return test1;
    }

    void handler_Response(Component c, String status, String textOfResponse) {
        if (status.equals("200")) try {
            JSONObject parser = new JSONObject(textOfResponse);
            if (parser.getString("Status").equals("OK")) {
                if (c.equals(RelayConnection)) {
                    if (parser.getString("sensor").equals("IPv4")) {
                        if (!parser.getString("value").equals("")) {
                            dbg("G");
                            txt_IP.Text(parser.getString("value"));
                        }
                    }
                }
                if(c.equals(RelayConnectionCO2)){
                    parser.getString("sensor").equals("CO2");
                    Co2Reading.Text(parser.getString("value"));
                    dbg("F");
                }
                if(c.equals(RelayConnectionVOC)){
                    parser.getString("sensor").equals("VOC");
                    TVOCReading.Text(parser.getString("value"));
                    dbg("F");
                }
                if(c.equals(RelayConnectionCELCIUS)){
                    parser.getString("sensor").equals("CELCIUS");
                    TempReading.Text(parser.getString("value"));
                    dbg("F");
                }
                new CountDownTimer(60000, 1000) {
                    public void onFinish() {
                        RelayConnectionCO2.Url(makeGetString_Co2());
                        RelayConnectionVOC.Url(makeGetString_VOC());
                        RelayConnectionCELCIUS.Url(makeGetString_CELCIUS());
                        RelayConnectionCO2.Get();
                        RelayConnectionVOC.Get();
                        RelayConnectionCELCIUS.Get();
                        this.cancel();
                        this.start();
                    }
                    public void onTick(long millisUntilFinished) {
                        TimeLeft= (int) (millisUntilFinished/1000);
                        dbg("TimeLeft:"+String.valueOf(TimeLeft));
                    }
                }.start();
            }
        }
        catch(JSONException e){
                notifier_Messages.ShowAlert("JSON Error 422");
                dbg("android JSON exception (" + textOfResponse + ")");
            }
        }
        public static void dbg (String debugMsg) {
        System.err.print( "~~~> " + debugMsg + " <~~~\n");
    }
}