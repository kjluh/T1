package konsalting.t1.service;

import konsalting.t1.model.miniModel;

import java.util.*;

@org.springframework.stereotype.Service
public class Service {

    /**
     * Метод принимает строку, преобразует в массив символов и сортирует. Затем высчитывает количество одинаковых
     * символов
     *
     * @param s строка для расчета.
     * @return количество одинаковых
     * * символов
     */
    public String helpMetod(String s) {
        List<String> strings = Arrays.stream(s.split("")).sorted().toList();
// из строки получаем мапу с количеством каждого символа (чтоб исключить повторения)
        int count = 0;
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < strings.size(); i++) {
            for (int i1 = 0; i1 < strings.size(); i1++) {
                if (strings.get(i).equals(strings.get(i1))) {
                    count++;
                }
            }
            map.put(strings.get(i), count);
            count = 0;
        }
        //из мапы собираем лист
        List<miniModel> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            miniModel miniModel = new miniModel();
            miniModel.setCount(entry.getValue());
            miniModel.setValue(entry.getKey());
            list.add(miniModel);
        }
// разворачиваем лист
        List<miniModel> collect = list.stream().sorted(Comparator.comparingInt(miniModel::getCount).reversed()).toList();

        StringBuilder stringBuilder = new StringBuilder();
// из листа собираем строку для ответа контроллеру
        for (miniModel miniModel : collect) {
            stringBuilder.append("\"").append(miniModel.getValue()).append("\": ").append(miniModel.getCount()).append(", ");
        }

        return String.valueOf(stringBuilder.substring(0, stringBuilder.length() - 2));
    }
}
