import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by CZ on 2018/8/5.
 */
public class FileChooserTest {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        final String[][] fileENames = {
                { ".xlsx", "Excel 2008 文件(*.xlsx)" },
                { ".xls", "MS-Excel 2003 文件(*.xls)" }
        };

        // 显示所有文件
        fileChooser.addChoosableFileFilter(new FileFilter() {

            public boolean accept(File file) {
                return true;
            }

            public String getDescription() {
                return "所有文件(*.*)";
            }
        });
        for (final String[] fileEName : fileENames) {
            fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File file) {
                    if (file.getName().endsWith(fileEName[0]) || file.isDirectory()) {
                        return true;
                    }
                    return false;
                }
                public String getDescription() {
                    return fileEName[1];
                }
            });
        }
        fileChooser.showDialog(null, null);
        fileChooser.showOpenDialog(null);
    }
}
