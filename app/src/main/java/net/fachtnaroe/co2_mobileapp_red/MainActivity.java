package net.fachtnaroe.co2_mobileapp_red;

import androidx.appcompat.app.AppCompatActivity;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListView;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.TableArrangement;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.TextToSpeech;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
import com.google.appinventor.components.runtime.Web;
import com.google.appinventor.components.runtime.WebViewer;
import com.google.appinventor.components.runtime.util.TimerInternal;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Console;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Switch;

public class MainActivity extends Form implements HandlesEventDispatching {

    private
    VerticalScrollArrangement Screen1;
    HorizontalArrangement HorizontalArrangement1, HorizontalArrangement2, HorizontalArrangement3, HorizontalArrangement4, HorizontalArrangement5;
    VerticalArrangement VerticalArrangement1;
    Label Null, Co2, Co2Reading, Co2Measurement, TVOC, TVOCReading, TVOCMeasurement, Temp, TempReading, TempMeasurement, SelectedNetwork, NetworkSelection, Logo;
    Button SettingsButton, GoButton;
    Web connectionDemo;
    Notifier notifier_Messages;
    String addressOfData = "https://t.fachtnaroe.net/qndco2?";

    protected void $define() {
        //Screen1-VScrollArrangement
        this.Sizing("Responsive");
        Screen1 = new VerticalScrollArrangement(this);
        notifier_Messages = new Notifier(this);
        Screen1.HeightPercent(100);
        Screen1.WidthPercent(100);
        Screen1.AlignVertical(1);
        Screen1.AlignHorizontal(1);
        Screen1.BackgroundColor(Color.parseColor("#00FF00"));

        //HorizontalArrangement1
        HorizontalArrangement1 = new HorizontalArrangement(Screen1);
        HorizontalArrangement1.HeightPercent(5);
        HorizontalArrangement1.WidthPercent(100);
        HorizontalArrangement1.BackgroundColor(Color.parseColor("#0000CD"));
        //Label-HorizontalArrangement1
        Logo = new Label(HorizontalArrangement1);
        Logo.Text("GREEN TEAM");
        Logo.FontBold(true);
        Logo.FontSize(20);
        Logo.TextAlignment(0);
        Logo.TextColor(Color.parseColor("#000000"));
        Logo.FontItalic(true);

        //VerticalArrangement1
        VerticalArrangement1 = new VerticalArrangement(Screen1);
        VerticalArrangement1.HeightPercent(40);
        VerticalArrangement1.WidthPercent(100);
        //Button-VerticalArrangement1
        SettingsButton = new Button(VerticalArrangement1);
        SettingsButton.HeightPercent(5);
        SettingsButton.WidthPercent(100);
        SettingsButton.FontBold(true);
        SettingsButton.FontSize(16);
        SettingsButton.Text("Connect");
        SettingsButton.TextAlignment(1);
        SettingsButton.BackgroundColor(COLOR_LTGRAY);
        SettingsButton.Shape(Component.BUTTON_SHAPE_DEFAULT);
        //Label-VerticalArrangement1
        SelectedNetwork = new Label(VerticalArrangement1);
        SelectedNetwork.WidthPercent(100);
        SelectedNetwork.HeightPercent(5);
        SelectedNetwork.Text("Selected Network");
        SelectedNetwork.FontSize(14);
        SelectedNetwork.TextAlignment(1);
        SelectedNetwork.HasMargins(true);
        //Label-VerticalArrangement1
        NetworkSelection = new Label(VerticalArrangement1);
        NetworkSelection.HeightPercent(5);
        NetworkSelection.WidthPercent(100);
        NetworkSelection.BackgroundColor(Color.parseColor("#8cc9ff"));
        NetworkSelection.FontSize(25);
        NetworkSelection.TextAlignment(1);
        NetworkSelection.Text("");
        NetworkSelection.HasMargins(false);
        //Label-VerticalArrangement1
        Null = new Label(VerticalArrangement1);
        Null.HeightPercent(20);
        //Button-VerticalArrangement1
        GoButton = new Button(VerticalArrangement1);
        GoButton.WidthPercent(100);
        GoButton.HeightPercent(5);
        GoButton.WidthPercent(100);
        GoButton.Text("Press for new readings");
        GoButton.FontBold(true);
        GoButton.FontSize(16);
        GoButton.TextAlignment(1);
        SettingsButton.BackgroundColor(Component.COLOR_RED);

        //HorizontalArrangement2
        HorizontalArrangement2 = new HorizontalArrangement(Screen1);
        HorizontalArrangement2.AlignHorizontal(1);
        HorizontalArrangement2.AlignVertical(1);
        HorizontalArrangement2.HeightPercent(10);
        HorizontalArrangement2.WidthPercent(100);
        HorizontalArrangement2.BackgroundColor(Color.parseColor("#000000"));
        //Co2-HorizontalArrangement2
        Co2 = new Label(HorizontalArrangement2);
        Co2.HeightPercent(10);
        Co2.WidthPercent(30);
        Co2.Text("CO2:");
        Co2.TextColor(Color.parseColor("#FFFAF0"));
        Co2.TextAlignment(2);
        Co2.HasMargins(false);
        Co2.FontBold(true);
        Co2.FontSize(38);
        Co2.FontItalic(true);
        Co2.HasMargins(false);
        Co2.FontItalic(true);
        //Co2Reading-HorizontalArrangement2
        Co2Reading = new Label(HorizontalArrangement2);
        Co2Reading.HeightPercent(10);
        Co2Reading.WidthPercent(40);
        Co2Reading.Text("0576");
        Co2Reading.TextColor(Color.parseColor("#f2f9ff"));
        Co2Reading.TextAlignment(1);
        Co2Reading.HasMargins(false);
        Co2Reading.FontBold(true);
        Co2Reading.FontSize(38);
        Co2Reading.FontItalic(true);
        Co2Reading.HasMargins(false);
        Co2Reading.FontItalic(true);
        //Co2Measurement-HorizontalArrangement2
        Co2Measurement = new Label(HorizontalArrangement2);
        Co2Measurement.HeightPercent(10);
        Co2Measurement.WidthPercent(30);
        Co2Measurement.Text("ppm");
        Co2Measurement.TextColor(Color.parseColor("#f2f9ff"));
        Co2Measurement.TextAlignment(0);
        Co2Measurement.HasMargins(false);
        Co2Measurement.FontBold(true);
        Co2Measurement.FontSize(38);
        Co2Measurement.FontItalic(true);
        Co2Measurement.HasMargins(false);
        Co2Measurement.FontItalic(true);

        //HorizontalArrangement3
        HorizontalArrangement3 = new HorizontalArrangement(Screen1);
        HorizontalArrangement3.AlignHorizontal(1);
        HorizontalArrangement3.AlignVertical(1);
        HorizontalArrangement3.HeightPercent(10);
        HorizontalArrangement3.WidthPercent(100);
        HorizontalArrangement3.BackgroundColor(Color.parseColor("#000000"));
        //TVOC-HorizontalArrangement3
        TVOC = new Label(HorizontalArrangement3);
        TVOC.HeightPercent(10);
        TVOC.WidthPercent(30);
        TVOC.Text("TVOC:");
        TVOC.TextColor(Color.parseColor("#FFFAF0"));
        TVOC.TextAlignment(2);
        TVOC.HasMargins(false);
        TVOC.FontBold(true);
        TVOC.FontSize(38);
        TVOC.FontItalic(true);
        TVOC.HasMargins(false);
        TVOC.FontItalic(true);
        //TVOCReading-HorizontalArrangement3
        TVOCReading = new Label(HorizontalArrangement3);
        TVOCReading.HeightPercent(10);
        TVOCReading.WidthPercent(40);
        TVOCReading.Text("0025");
        TVOCReading.TextColor(Color.parseColor("#FF0000"));
        TVOCReading.TextAlignment(1);
        TVOCReading.HasMargins(false);
        TVOCReading.FontBold(true);
        TVOCReading.FontSize(38);
        TVOCReading.FontItalic(true);
        TVOCReading.HasMargins(false);
        TVOCReading.FontItalic(true);
        //TVOCMeasurement-HorizontalArrangement3
        TVOCMeasurement = new Label(HorizontalArrangement3);
        TVOCMeasurement.HeightPercent(10);
        TVOCMeasurement.WidthPercent(30);
        TVOCMeasurement.Text("ppm");
        TVOCMeasurement.TextColor(Color.parseColor("#f2f9ff"));
        TVOCMeasurement.TextAlignment(0);
        TVOCMeasurement.HasMargins(false);
        TVOCMeasurement.FontBold(true);
        TVOCMeasurement.FontSize(38);
        TVOCMeasurement.FontItalic(true);
        TVOCMeasurement.HasMargins(false);
        TVOCMeasurement.FontItalic(true);

        //HorizontalArrangement4
        HorizontalArrangement4 = new HorizontalArrangement(Screen1);
        HorizontalArrangement4.AlignHorizontal(1);
        HorizontalArrangement4.AlignVertical(1);
        HorizontalArrangement4.HeightPercent(10);
        HorizontalArrangement4.WidthPercent(100);
        HorizontalArrangement4.BackgroundColor(Color.parseColor("#000000"));
        //Temp-HorizontalArrangement4
        Temp = new Label(HorizontalArrangement4);
        Temp.HeightPercent(10);
        Temp.WidthPercent(30);
        Temp.Text("TEMP:");
        Temp.TextColor(Color.parseColor("#f2f9ff"));
        Temp.TextAlignment(2);
        Temp.HasMargins(false);
        Temp.FontBold(true);
        Temp.FontSize(38);
        Temp.FontItalic(true);
        Temp.HasMargins(false);
        Temp.FontItalic(true);
        //TempReading-HorizontalArrangement4
        TempReading = new Label(HorizontalArrangement4);
        TempReading.HeightPercent(10);
        TempReading.WidthPercent(40);
        TempReading.Text("19.7");
        TempReading.TextColor(Color.parseColor("#f2f9ff"));
        TempReading.TextAlignment(1);
        TempReading.HasMargins(false);
        TempReading.FontBold(true);
        TempReading.FontSize(38);
        TempReading.FontItalic(true);
        TempReading.HasMargins(false);
        TempReading.FontItalic(true);
        //TempMeasurement-HorizontalArrangement4
        TempMeasurement = new Label(HorizontalArrangement4);
        TempMeasurement.HeightPercent(10);
        TempMeasurement.WidthPercent(30);
        TempMeasurement.Text("C°");
        TempMeasurement.TextColor(Color.parseColor("#f2f9ff"));
        TempMeasurement.TextAlignment(0);
        TempMeasurement.HasMargins(false);
        TempMeasurement.FontBold(true);
        TempMeasurement.FontSize(38);
        TempMeasurement.FontItalic(true);
        TempMeasurement.HasMargins(false);
        TempMeasurement.FontItalic(true);

        //HorizontalArrangement5
        HorizontalArrangement5 = new HorizontalArrangement(Screen1);
        HorizontalArrangement5.HeightPercent(25);
        HorizontalArrangement5.WidthPercent(100);

        //Web-connectionDemo
        connectionDemo = new Web(this);
        connectionDemo.Url("addressOfData");

        //Event Dispatcher
        EventDispatcher.registerEventForDelegation(this, formName, "BackPressed");
        EventDispatcher.registerEventForDelegation(this, formName, "Click");
        EventDispatcher.registerEventForDelegation(this, formName, "GotText");
    }

    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params) {
        System.err.print("dispatchEvent: " + formName + " [" + component.toString() + "] [" + componentName + "] " + eventName);
        if (eventName.equals("BackPressed")) {
            return true;
        }
        else if (eventName.equals("GotText")) {
            if (component.equals(connectionDemo)) {
                String status = params[1].toString();
                String textOfResponse = (String) params[3];
                manageResponse(component, status, textOfResponse);
            }
        }
        else if (eventName.equals("Click")) {
            if (component.equals(SettingsButton)) {
                connectionDemo.Url(addressOfData +  NetworkSelection.Text());
                connectionDemo.Get();
                return true;
            }
        }
        return false;
    }

    void manageResponse(Component c, String status, String textOfResponse) {
        System.err.print("GOT SOME TEXT");
        if (status.equals("200")) try {
            JSONObject parser = new JSONObject(textOfResponse);
            if (!parser.getString("Status").equals("OK")) {
            }
        }
        catch (JSONException e) {
            notifier_Messages.ShowAlert("JSON exception(" + textOfResponse + ")");
        }
    }
    public static void dbg (String debugMsg) {
        System.err.print("~~~>" + debugMsg + "<~~~\n");
    }
}