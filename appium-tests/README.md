# Appium Tests Module

Модуль для black-box тестирования Android-приложения Pokedex с использованием Appium.

## Структура проекта

```
appium-tests/
├── build.gradle.kts                 # Конфигурация сборки модуля
├── proguard-rules.pro               # Правила ProGuard
├── src/
│   ├── main/
│   │   ├── AndroidManifest.xml
│   │   └── java/
│   │       └── dev/marcosfarias/pokedex/appium/
│   │           ├── config/
│   │           │   └── AppiumConfig.kt          # Конфигурация Appium
│   │           ├── driver/
│   │           │   └── DriverFactory.kt        # Фабрика драйвера
│   │           └── pages/
│   │               ├── BasePage.kt              # Базовый Page Object
│   │               ├── HomePage.kt             # Главный экран
│   │               ├── PokedexPage.kt          # Экран Покедекса
│   │               └── NewsDetailPage.kt       # Экран детальной информации
│   └── test/
│       └── java/
│           └── dev/marcosfarias/pokedex/appium/
│               ├── BaseAppiumTest.kt           # Базовый класс тестов
│               ├── HomeScreenTest.kt           # Тесты главного экрана
│               ├── PokedexScreenTest.kt        # Тесты экрана Покедекса
│               ├── NewsDetailScreenTest.kt     # Тесты экрана новостей
│               └── ErrorScenariosTest.kt       # Ошибочные сценарии
```

## Запуск тестов

### Предварительные требования

1. **Appium Server** должен быть запущен локально:
   ```bash
   npm install -g appium
   appium
   ```
   Сервер будет доступен по адресу `http://127.0.0.1:4723`

2. **Android Emulator** или физическое устройство должны быть подключены

### Запуск через Gradle

```bash
# Запуск всех тестов
./gradlew :appium-tests:test

# Запуск конкретного тестового класса
./gradlew :appium-tests:test --tests "dev.marcosfarias.pokedex.appium.HomeScreenTest"

# Запуск с отчетом
./gradlew :appium-tests:test --info
```

## Конфигурация

В файле `AppiumConfig.kt` можно изменить параметры:

- `APPIUM_SERVER_URL` - URL Appium сервера
- `DEVICE_NAME` - Имя устройства/эмулятора
- `PLATFORM_VERSION` - Версия Android
- `APP_PACKAGE` - Пакет приложения
- `IMPLICIT_WAIT_TIMEOUT` - Таймаут ожидания элементов

## Тестовые сценарии

### Главный экран (HomeScreenTest)
- Проверка отображения главного экрана
- Проверка заголовка "Pokedex"
- Проверка поля поиска
- Проверка списка меню
- Проверка списка новостей

### Экран Покедекса (PokedexScreenTest)
- Проверка отображения экрана Покедекса
- Проверка заголовка
- Проверка списка покемонов
- Проверка Speed Dial (FAB)
- Проверка наличия элементов в списке

### Экран новостей (NewsDetailScreenTest)
- Проверка отображения экрана детальной информации
- Проверка заголовка новости
- Проверка изображения
- Проверка даты
- Проверка описания

### Ошибочные сценарии (ErrorScenariosTest)
- Проверка неправильного заголовка (должен упасть)
- Проверка пустого списка покемонов (должен упасть)
- Проверка неправильного placeholder в поиске (должен упасть)

## Page Object паттерн

Каждый экран приложения представлен отдельным классом Page Object:
- `HomePage` - главный экран
- `PokedexPage` - экран со списком покемонов
- `NewsDetailPage` - экран детальной информации о новости

Базовый класс `BasePage` предоставляет общие методы для работы с элементами.

## Драйвер

`DriverFactory` управляет жизненным циклом Appium драйвера:
- Создание драйвера при первом обращении
- Переиспользование драйвера между тестами
- Корректное закрытие драйвера после завершения тестов