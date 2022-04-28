import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DzTests {

    /*
     $("h1 div") найдет первый элемент "h1 div", который подойдет по параметрам;
     $("h1").$("div") найдет сначала элемент "h1" и уже внутри него будет искать элемент"div"
     Если во втором случае у нас не будет "div" в "h1" будет ошибка
     */

    @BeforeAll
    static void setUp () {
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void GitHubSearchJunit5 () {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".Layout-sidebar").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}



