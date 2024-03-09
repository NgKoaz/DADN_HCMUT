import serial.tools.list_ports

class UART:

    def processData(self):
        pass

    def readSerial(self):
        pass

    @staticmethod
    def getPort(self):
        for port in serial.tools.list_ports.comports():
            print(port)
