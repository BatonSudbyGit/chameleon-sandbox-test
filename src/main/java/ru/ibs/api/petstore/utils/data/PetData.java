package ru.ibs.api.petstore.utils.data;

import static ru.ibs.api.common.swagger.utils.paths.FilePaths.*;

public class PetData {

    public static Object[][] positiveStatusData() {
        return new Object[][] {
                {new String[] {"available"}},
                {new String[] {"pending"}},
                {new String[] {"sold"}}};
    }

    public static Object[][] getIncorrectIdForPets() {
        return new Object[][]{
                {"asd"},
                {"213ddd"}};
    }

    public static Object[][] getIncorrectPetStatuses() {
        return new Object[][]{
                {new String[] {"availabqele"}},
                {new String[] {"qqqqq"}},
                {new String[] {"12345"}},
                {new String[] {"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"}},
                {new String[] {"DROP TABLE"}},
                {new String[] {"https://yandex.ru/"}}};
    }

    public static Object[][] getPathsToFiles() {
        return new Object[][]{
                {TEXT_FILE_PATH.getPath()},
                {DOC_FILE_PATH.getPath()},
                {HTML_FILE_PATH.getPath()}
        };
    }

    public static Object[][] getPathsToImages() {
        return new Object[][]{
                {IMAGE_FILE_PATH.getPath()}
        };
    }
}
