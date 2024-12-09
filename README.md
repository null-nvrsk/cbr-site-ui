# Проект по автоматизации тестовых сценариев для сайта Центрального банка РФ
## :pushpin: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Запуск тестов из терминала](#arrow_forward-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :computer: Использованный стек технологий

<table align="center" border="0">
    <tr>
        <td align="center"><img src="media/icons/java.svg" height="48"></td>
        <td align="center"><img src="media/icons/idea.svg" height="48"></td>
        <td align="center"><img src="media/icons/github.svg" height="48"></td>
        <td align="center"><img src="media/icons/gradle.svg" height="48"></td>
        <td align="center"><img src="media/icons/junit5.svg" height="48"></td>
        <td align="center"><img src="media/icons/selenide.svg" height="48"></td>
        <td align="center"><img src="media/icons/selenoid.svg" height="48"></td>
        <td align="center"><img src="media/icons/allure_report.svg" height="48"></td>
        <td align="center"><img src="media/icons/jenkins.svg" height="48"></td>
        <td align="center"><img src="media/icons/telegram.svg" height="48"></td>
    </tr>
    <tr>
        <td align="center">Java</td>
        <td align="center">IntelliJ IDEA</td>
        <td align="center">GitHub</td>
        <td align="center">Gradle</td>
        <td align="center">JUnit 5</td>
        <td align="center">Selenide</td>
        <td align="center">Selenoid</td>
        <td align="center">Allure Report</td>
        <td align="center">Jenkins</td>
        <td align="center">Telegram</td>
    </tr>
</table>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide. 
- В качестве сборщика был использован - <code>Gradle</code>.  
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :arrow_forward: Запуск автотестов

### Запуск тестов локольно из терминала
```
gradle clean test
```
При выполнении команды, данные тесты запустятся локально в IDE.

### Запуск тестов на удаленном браузере
```
gradle clean test -DselenoidUrl="selenoid.autotests.cloud" -DselenoidAuth="some_login:some_password"
```
При выполнении команды, данные тесты запустятся удаленно в <code>Selenoid</code>.
При необходимости также можно переопределить параметры запуска

```
clean
test
-DselenoidUrl=${SELENOID_URL}
-DselenoidAuth=${SELENOID_AUTH}
-Dbrowser=${BROWSER}
-DbrowserVersion="${BROWSER_VERSION}"
-DbrowserSize=${BROWSER_SIZE}
```

### Параметры сборки

* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>125.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По-умолчанию - <code>1920x1080</code>.
* <code>SELENOID_URL</code> – адрес удаленного сервера Selenoid, на котором будут запускаться тесты.
* <code>SELENOID_AUTH</code> – логин:пароль для доступа к удаленному серверу Selenoid.
* 

## <img src="media/icons/jenkins.svg" title="Jenkins" height="32" style="vertical-align:middle"/> Сборка в Jenkins
<p align="center">
<img title="Jenkins Build" src="media/screens/jenkins_build.png">
</p>

## <img src="media/icons/allure_report.svg" title="Allure Report" height="32" style="vertical-align:middle"/> Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="media/screens/allure_overview.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/screens/allure_testcase.png">
</p>


## <img title="Telegram" src="media/icons/telegram.svg" height="32" style="vertical-align:middle"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/notification.png">
</p>

## <img title="Telegram" src="media/icons/selenoid.svg" height="32" style="vertical-align:middle"> Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>