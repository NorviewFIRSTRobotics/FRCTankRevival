package org.frc1793.robot.commands;

import org.strongback.Strongback;
import org.strongback.command.Command;
import org.strongback.command.Requirable;

/**
 * Created by tyler on 4/11/17.
 */
public class ExampleCommand extends Command {
    private String word;

    public ExampleCommand(String word) {
        this.word = word;
    }
    
    @Override
    public boolean execute() {
        Strongback.logger().info(word);
        return true;
    }
}
