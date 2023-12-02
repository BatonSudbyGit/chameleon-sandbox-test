package ru.ibs.utils.enums;


import java.util.ArrayList;
import java.util.List;

/**
 * Класс-singleton для хранения и передачи данных во время работы программы
 */
public enum DataWarehousing {

    INSTANCE;

    private final List<Process> processesList = new ArrayList<>();

    public List<Process> getProcessesList() {
        return processesList;
    }
}
