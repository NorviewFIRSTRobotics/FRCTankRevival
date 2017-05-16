/*
 * Strongback
 * Copyright 2015, Strongback and individual contributors by the @authors tag.
 * See the COPYRIGHT.txt in the distribution for a full listing of individual
 * contributors.
 *
 * Licensed under the MIT License; you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.frc1793.robot.commands;

import org.strongback.command.Command;
import org.strongback.drive.TankDrive;

/**
 * The command that drives the robot at a constant forward and turn speed for a specific duration.
 */
@SuppressWarnings("ALL")
public class TimedDriveCommand extends Command {

    protected TankDrive drive;
    protected double driveSpeed;
    protected double turnSpeed;
    protected boolean squareInputs;
    protected double duration;
    /**
     * Create a new autonomous command.
     * @param drive the chassis
     * @param driveSpeed the speed at which to shooter forward; should be [-1.0, 1.0]
     * @param turnSpeed the speed at which to turn; should be [-1.0, 1.0]
     * @param squareInputs whether to increase sensitivity at low speeds
     * @param duration the duration of this command; should be positive
     */
    public TimedDriveCommand( TankDrive drive, double duration ,double driveSpeed, double turnSpeed, boolean squareInputs) {
        super(duration, drive);
        this.drive = drive;
        this.driveSpeed = driveSpeed;
        this.turnSpeed = turnSpeed;
        this.squareInputs = squareInputs;
        this.duration = duration;
    }

    public TimedDriveCommand(TankDrive drive, double duration, double driveSpeed, double turnSpeed) {
        this(drive,duration,driveSpeed,turnSpeed,false);
    }

    public TimedDriveCommand() {

    }

    @Override
    public boolean execute() {
        drive.arcade(driveSpeed, turnSpeed, squareInputs);
        return false;   // not complete; it will duration out automatically
    }

    @Override
    public void interrupted() {
        drive.stop();
    }

    @Override
    public void end() {
        drive.stop();
    }

    @Override
    public String toString() {
        return String.format("Drive > %s, Turn >  %s, Duration > %s", driveSpeed,turnSpeed,duration);
    }
}