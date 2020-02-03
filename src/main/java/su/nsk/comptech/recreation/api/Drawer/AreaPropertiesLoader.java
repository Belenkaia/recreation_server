package su.nsk.comptech.recreation.api.Drawer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 * Используется для загрузки списка зон и их координат
 * из properties-файлов
 */

class AreaPropertiesLoader {
    private static DrawerArea loadSingleArea(final Properties properties, final String areaName) {
        int startX, startY, width, height;
        startX = Integer.parseInt(properties.getProperty(areaName + ".start_x"));
        startY = Integer.parseInt(properties.getProperty(areaName + ".start_y"));
        width = Integer.parseInt(properties.getProperty(areaName + ".width"));
        height = Integer.parseInt(properties.getProperty(areaName + ".height"));
        return new DrawerArea(startX, startY, width, height,0, areaName);
    }

    static List<DrawerArea> loadProperties(final String floorNumber) {
        List<DrawerArea> result = new ArrayList<>();
        try {
            FileInputStream fisAreaProperties = new FileInputStream("src/main/resources/properties/" + floorNumber + "_floor_areas.properties");
            Properties properties = new Properties();
            properties.load(fisAreaProperties);

            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/properties/" + floorNumber + "_floor_list_areas.properties"));
            String string = reader.readLine(); // skipping comment
            string = reader.readLine();
            if (string == null)
                throw new IOException(floorNumber + "_floor_list_areas.properties is empty or doesn't exist");
            String[] listAreas = string.split(",");

            for (String area : listAreas) {
                result.add(loadSingleArea(properties, area));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
