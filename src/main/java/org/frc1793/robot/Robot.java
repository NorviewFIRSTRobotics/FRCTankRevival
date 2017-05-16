package org.frc1793.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import org.frc1793.robot.commands.TimedDriveCommand;
import org.strongback.Strongback;
import org.strongback.components.Motor;
import org.strongback.components.ui.ContinuousRange;
import org.strongback.components.ui.FlightStick;
import org.strongback.drive.TankDrive;
import org.strongback.hardware.Hardware;

/**
 * Created by tyler on 4/11/17.
 */
public class Robot extends IterativeRobot {
    private Dashboard dashboard;
    private State state;

    public TankDrive drive;
    public ContinuousRange driveSpeed, turnSpeed;

    @Override
    public void robotInit() {
        dashboard = new Dashboard();
        Motor left = Motor.compose(Hardware.Motors.talon(0),Hardware.Motors.talon(1));
        Motor right = Motor.compose(Hardware.Motors.talon(2), Hardware.Motors.talon(3));
        drive = new TankDrive(left,right);
        initHumanInteractions();
    }

    private void initHumanInteractions() {
        FlightStick driveStick = Hardware.HumanInterfaceDevices.microsoftSideWinder(0);
        driveSpeed = driveStick.getPitch();
        turnSpeed = driveStick.getYaw().invert();
    }
    @Override
    public void robotPeriodic() {
        state = isAutonomous() ? State.AUTO : isOperatorControl() ? State.TELEOP : State.DISABLED;
        dashboard.update(state);
    }

    @Override
    public void autonomousInit() {
        Strongback.submit(new TimedDriveCommand(drive,2,0.5,0,false));
    }
    
    protected enum State {
        AUTO("Autonomous"), TELEOP("Teleop"), DISABLED("Disabled");
        private String value;

        State(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
