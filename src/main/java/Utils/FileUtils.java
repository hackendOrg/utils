package Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    /**
     *
     * @param rootPath of the root directory
     * @return list of al the subFiles in sub directories
     */
    public static List<File> getSubFilesOnly(String rootPath) {
        List<File> allFiles = new ArrayList<>();
        File[] files = getBaseFilesTree(rootPath);
        if (files != null) {
            for (File file : files) {
                addSubFiles(allFiles, file);
            }
        }
        return allFiles;
    }

    /**
     *
     * @param rootPath of the root directory
     * @return the directories and files under the root directory
     */
    public static File[] getBaseFilesTree(String rootPath) {
        File dir = new File(rootPath);
        //if doesn't path exists
        if (!dir.exists()) {
            System.out.println("Error. Unknown Path.");
            return null;
        }
        return dir.listFiles();
    }

    /**
     * recursively adding files, if file is dir it adds files in that dir
     * @param allFiles list of all files
     * @param dir or a file to add to the list
     */
    public static void addSubFiles(List<File> allFiles, File dir) {
        if (dir.isFile()) {
            allFiles.add(dir);
        } else if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    addSubFiles(allFiles, file);
                }
            }
        }
    }
}
