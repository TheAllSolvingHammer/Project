package sit.tu_varna.bg.project.contracts;


import sit.tu_varna.bg.project.exceptions.SaverException;

public interface FileManage {
    void execute() throws SaverException;
    boolean isSvgExtension();

}
