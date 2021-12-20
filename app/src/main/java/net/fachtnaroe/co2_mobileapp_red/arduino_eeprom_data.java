package net.fachtnaroe.co2_mobileapp_red;
class arduino_eeprom_data {
        private static final int max_SSID = 32;
        private static final int max_PSK = 64;
        private static final int max_DeviceName = 32;

        public char active;
        public byte config_Status;
        public byte config_Attempts;
        public char[] config_SSID = new char[max_SSID];
        public char[] config_PSK = new char[max_PSK];
        public char[] config_DeviceName = new char[max_DeviceName];
}
