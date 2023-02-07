package com.github.kumo0621.moziplugin;

import net.kunmc.lab.commandlib.Command;
import net.kunmc.lab.commandlib.argument.IntegerArgument;

/**
 * By registering this, you can use the command below.
 * /config intValue // check intValue's current value.
 * /config intValue <integer> // change intValue's value to <integer>.
 */
public class intcommand extends Command {

    public intcommand() {
        super("moziconfig");

        addChildren(new Command("intdown") {
            {
                execute(ctx -> {
                    ctx.sendSuccess("最低値が " + moziplugin.down +"最高値が"+moziplugin.up);
                });

                argument(new IntegerArgument("number"), (number, ctx) -> {
                    moziplugin.down = number;
                    ctx.sendSuccess("最低値を変更しました。 " + moziplugin.down);
                });
            }
        });
        addChildren(new Command("intup") {
            {
                execute(ctx -> {
                    ctx.sendSuccess("最低値が " + moziplugin.down +"最高値が"+moziplugin.up);
                });

                argument(new IntegerArgument("number"), (number, ctx) -> {
                    moziplugin.up = number;
                    ctx.sendSuccess("最高値を変更しました。 " + moziplugin.up);
                });
            }
        });
    }
}
