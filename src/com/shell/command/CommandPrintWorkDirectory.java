package com.shell.command;

import com.shell.Shell;
import com.shell.parser.Parser.CmdLineArgs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CommandPrintWorkDirectory extends SingleCommand {
    private static final String COMMAND_NAME = "pwd";

    public CommandPrintWorkDirectory(Shell shell, CmdLineArgs args,
                                     InputStream input, OutputStream output) {
        super(shell, args, input, output);
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    public void run() throws IOException {
        if(!getArgs().directory.isEmpty()) {
            System.out.println("命令'" + getCommandName() + "'用法错误");
            return;
        }
        String info = getShell().getDir().getAbsolutePath() + "\n";
        getOutput().write(info.getBytes());
    }
}
