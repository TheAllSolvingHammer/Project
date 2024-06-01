package sit.tu_varna.bg.project.contracts;


import sit.tu_varna.bg.project.exceptions.FileWorkerException;

public interface FileManage {
    void execute() throws FileWorkerException;
    boolean isSvgExtension();

}
