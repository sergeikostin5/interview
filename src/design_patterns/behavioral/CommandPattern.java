package design_patterns.behavioral;

/**
 *  A Command pattern is an object behavioral pattern that allows us to achieve complete decoupling between the sender
 *  and the receiver. (A sender is an object that invokes an operation, and a receiver is an object that receives the
 *  request to execute a certain operation. With decoupling, the sender has no knowledge of the Receiver's interface.)
 *  Use it when you need to undo previous command, for example database transaction
 */
public class CommandPattern {

    private interface FileHandler{
        void openFile();
        void readFile();
        void closeFile();
    }

    private interface FileCommand{
        void execute();
        void undo();
    }

    private static class WindowsFileHandler implements FileHandler{

        @Override
        public void openFile() {
            System.out.println("Opening file on Windows");
        }

        @Override
        public void readFile() {
            System.out.println("Reading file on Windows");
        }

        @Override
        public void closeFile() {
            System.out.println("Closing file on Windows");
        }
    }

    private static class LinuxFileHandler implements FileHandler{

        @Override
        public void openFile() {
            System.out.println("Opening file on Linux");
        }

        @Override
        public void readFile() {
            System.out.println("Reading file on Linux");
        }

        @Override
        public void closeFile() {
            System.out.println("Closing file on Linux");
        }
    }

    private static class OpenFileCommand implements FileCommand{
        private FileHandler fileHandler;

        OpenFileCommand(FileHandler fileHandler){
            this.fileHandler = fileHandler;
        }

        @Override
        public void execute() {
            fileHandler.openFile();
        }

        @Override
        public void undo() {
            fileHandler.closeFile();
        }
    }

    private static class CloseFileCommand implements FileCommand{
        private FileHandler fileHandler;

        CloseFileCommand(FileHandler fileHandler){
            this.fileHandler = fileHandler;
        }

        @Override
        public void execute() {
            fileHandler.closeFile();
        }

        @Override
        public void undo() {
            fileHandler.openFile();
        }
    }

    private static class ReadFileCommand implements FileCommand{
        private FileHandler fileHandler;

        ReadFileCommand(FileHandler fileHandler){
            this.fileHandler = fileHandler;
        }

        @Override
        public void execute() {
            fileHandler.readFile();
        }

        @Override
        public void undo() {
            fileHandler.closeFile();
        }
    }

    private static class FileInvoker{

        private FileCommand command;

        FileInvoker(FileCommand command){
            this.command = command;
        }

        public void execute(){
            command.execute();
        }

        public void undo(){
            command.undo();
        }

    }

    public static void main(String[] args) {
        FileHandler fHandler = new WindowsFileHandler();
        FileCommand oCommand = new OpenFileCommand(fHandler);
        FileCommand cCommand = new CloseFileCommand(fHandler);
        FileInvoker fileInvoker = new FileInvoker(oCommand);
        fileInvoker.execute();
        fileInvoker.undo();

    }







}
