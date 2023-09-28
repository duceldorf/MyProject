package somepack;

import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static java.util.Arrays.asList;
import static java.util.Collections.reverse;
import static java.util.List.of;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.testng.Assert.assertEquals;

public class ExampleTests {

    @DataProvider(name = "firstProvider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {" мама мыла раму ", of("раму", "мыла", "мама")}};
    }

    @Step("Конвертируем строку в лист")
    public List<String> convertStringToList(String text) {
        return asList(text.trim().split(" "));
    }

    @Test(dataProvider = "firstProvider", description = "Переворачиваем фразу")
    void reverseListTest(String originalText, List<String> reversedText) {
        var convertedList = convertStringToList(originalText);
        step("Разворачиваем лист", () -> reverse(convertedList));
        step("Сравнение строк", () -> assertEquals(convertedList, reversedText));
    }

    @Test(description = "Считаем количество повторений строк в массиве")
    void countRepeatedStringsTest() {
        var someList = of("apple", "banana", "apple", "orange", "apple");
        step("Производим подсчет и выводим результат", () -> {
            var result = someList.stream().collect(groupingBy(e -> e, counting()));
            System.out.println(result);
        });
    }
}
