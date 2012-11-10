/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.nicola.jeremy.pi4jdemo.com;

import com.pi4j.io.gpio.*;
import info.nicola.jeremy.pi4jdemo.view.PortFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author jem
 */
public class Talker implements ChangeListener {

    private GpioController port;
    private PortFrame frame;
    private GpioPinDigitalOutput pins[];

    public Talker(PortFrame frame) {
        this.frame = frame;

        port = GpioFactory.getInstance();
        pins=new GpioPinDigitalOutput[17];
        pins[0] = port.provisionDigitalOutputPin(RaspiPin.GPIO_00, "pin0", PinState.LOW);
        pins[0].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[1] = port.provisionDigitalOutputPin(RaspiPin.GPIO_01, "pin1", PinState.LOW);
        pins[1].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[2] = port.provisionDigitalOutputPin(RaspiPin.GPIO_02, "pin2", PinState.LOW);
        pins[2].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[3] = port.provisionDigitalOutputPin(RaspiPin.GPIO_03, "pin3", PinState.LOW);
        pins[3].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[4] = port.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pin4", PinState.LOW);
        pins[4].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[5] = port.provisionDigitalOutputPin(RaspiPin.GPIO_05, "pin5", PinState.LOW);
        pins[5].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[6] = port.provisionDigitalOutputPin(RaspiPin.GPIO_06, "pin6", PinState.LOW);
        pins[6].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[7] = port.provisionDigitalOutputPin(RaspiPin.GPIO_07, "pin7", PinState.LOW);
        pins[7].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[8] = port.provisionDigitalOutputPin(RaspiPin.GPIO_08, "pin8", PinState.LOW);
        pins[8].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[9] = port.provisionDigitalOutputPin(RaspiPin.GPIO_09, "pin9", PinState.LOW);
        pins[9].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[10] = port.provisionDigitalOutputPin(RaspiPin.GPIO_10, "pin10", PinState.LOW);
        pins[10].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[11] = port.provisionDigitalOutputPin(RaspiPin.GPIO_11, "pin11", PinState.LOW);
        pins[11].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[12] = port.provisionDigitalOutputPin(RaspiPin.GPIO_12, "pin12", PinState.LOW);
        pins[12].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[13] = port.provisionDigitalOutputPin(RaspiPin.GPIO_13, "pin13", PinState.LOW);
        pins[13].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[14] = port.provisionDigitalOutputPin(RaspiPin.GPIO_14, "pin14", PinState.LOW);
        pins[14].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[15] = port.provisionDigitalOutputPin(RaspiPin.GPIO_15, "pin15", PinState.LOW);
        pins[15].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        pins[16] = port.provisionDigitalOutputPin(RaspiPin.GPIO_16, "pin16", PinState.LOW);
        pins[16].setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        
        frame.getPin0().addChangeListener(this);
        frame.getPin1().addChangeListener(this);
        frame.getPin2().addChangeListener(this);
        frame.getPin3().addChangeListener(this);
        frame.getPin4().addChangeListener(this);
        frame.getPin5().addChangeListener(this);
        frame.getPin6().addChangeListener(this);
        frame.getPin7().addChangeListener(this);
        frame.getPin8().addChangeListener(this);
        frame.getPin9().addChangeListener(this);
        frame.getPin10().addChangeListener(this);
        frame.getPin11().addChangeListener(this);
        frame.getPin12().addChangeListener(this);
        frame.getPin13().addChangeListener(this);
        frame.getPin14().addChangeListener(this);
        frame.getPin15().addChangeListener(this);
        frame.getPin16().addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        boolean state[] = this.frame.getPortFrameState();

        int i = 0;
        for (GpioPinDigitalOutput pin : pins) {
            if (state[i]) {
                pin.high();
            } else {
                pin.low();
            }
            i++;
        }
    }
}
