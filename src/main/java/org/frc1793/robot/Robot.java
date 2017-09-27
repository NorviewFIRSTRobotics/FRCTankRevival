package org.frc1793.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import org.frc1793.robot.commands.TimedDriveCommand;
import org.strongback.Strongback;
import org.strongback.components.Motor;
import org.strongback.components.ui.ContinuousRange;
import org.strongback.components.ui.Gamepad;
import org.strongback.drive.TankDrive;
import org.strongback.hardware.Hardware;

/**
 * Created by tyler on 4/11/17.`
 */
public class Robot extends IterativeRobot {
    private Dashboard dashboard;
    private State state;

    public TankDrive drive;
    public ContinuousRange driveSpeed, turnSpeed;
    public ContinuousRange throttle;
    @Override
    public void robotInit() {
        dashboard = new Dashboard();
        Motor left = Motor.compose(Hardware.Motors.talon(0),Hardware.Motors.talon(1));
        Motor right = Motor.compose(Hardware.Motors.talon(2), Hardware.Motors.talon(3));
        drive = new TankDrive(left,right);
        initHumanInteractions();
    }

    private void initHumanInteractions() {
        Gamepad controller = Hardware.HumanInterfaceDevices.logitechDualAction(0);
        throttle = controller.getRightY().map( x -> (x+1)/2d + 1d/2d);
        driveSpeed = controller.getLeftX().scale( () -> throttle.read());
        turnSpeed = controller.getLeftY().invert().scale( () -> throttle.read());

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

    @Override
    public void teleopPeriodic() {
        drive.arcade(driveSpeed.read(),turnSpeed.read());
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
