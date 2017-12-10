package org.ramaciotti.utilities;
import com.treestar.lib.xml.SElement;
import com.treestar.lib.xml.*;
import java.io.File;

public class FlowJoPluginTestbed {

        public static SElement getFcmlFromFile(String stringPath) {
            File fXmlFile = new File(stringPath);
            return JdomUtil.read(fXmlFile, true);
        }

        public static File createFileObject(String path) {
            return new File(path);
        }
}