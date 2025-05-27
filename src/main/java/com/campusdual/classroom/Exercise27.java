package com.campusdual.classroom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise27 {

    public static void main(String[] args) {
        createShoppingListXML();
        createShoppingListJSON();
        System.out.println("Shopping list XML and JSON files created successfully.");
    }
    private static void createShoppingListXML() {
        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<shoppinglist>\n" +
                "    <items>\n" +
                "        <item quantity=\"2\">Manzana</item>\n" +
                "        <item quantity=\"1\">Leche</item>\n" +
                "        <item quantity=\"3\">Pan</item>\n" +
                "        <item quantity=\"2\">Huevo</item>\n" +
                "        <item quantity=\"1\">Queso</item>\n" +
                "        <item quantity=\"1\">Cereal</item>\n" +
                "        <item quantity=\"4\">Agua</item>\n" +
                "        <item quantity=\"6\">Yogur</item>\n" +
                "        <item quantity=\"2\">Arroz</item>\n" +
                "    </items>\n" +
                "</shoppinglist>\n";
        writeToFile("src/main/resources/shoppingList.xml", xmlContent);
    }

    private static void createShoppingListJSON() {
        String jsonContent = "{\n" +
                "  \"items\": [\n" +
                "    { \"quantity\": 2, \"text\": \"Manzana\" },\n" +
                "    { \"quantity\": 1, \"text\": \"Leche\" },\n" +
                "    { \"quantity\": 3, \"text\": \"Pan\" },\n" +
                "    { \"quantity\": 2, \"text\": \"Huevo\" },\n" +
                "    { \"quantity\": 1, \"text\": \"Queso\" },\n" +
                "    { \"quantity\": 1, \"text\": \"Cereal\" },\n" +
                "    { \"quantity\": 4, \"text\": \"Agua\" },\n" +
                "    { \"quantity\": 6, \"text\": \"Yogur\" },\n" +
                "    { \"quantity\": 2, \"text\": \"Arroz\" }\n" +
                "  ]\n" +
                "}\n";
        writeToFile("src/main/resources/shoppingList.json", jsonContent);
    }

    private static void writeToFile(String path, String content) {
        try {
            File file = new File(path);
            file.getParentFile().mkdirs();
            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write(content);
            }
        } catch (IOException e) {
            System.err.println("Error escribiendo el archivo: " + path);
        }
    }
}
