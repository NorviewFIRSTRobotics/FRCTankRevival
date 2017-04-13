package org.frc1793.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * Created by tyler on 4/11/17.
 */
public class Robot extends IterativeRobot {
    private Dashboard dashboard;
    private State state;

    @Override
    public void robotInit() {
        dashboard = new Dashboard();

    }

    @Override
    public void robotPeriodic() {
        state = isAutonomous() ? State.AUTO : isOperatorControl() ? State.TELEOP : State.DISABLED;
        dashboard.update(state);
    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {

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
