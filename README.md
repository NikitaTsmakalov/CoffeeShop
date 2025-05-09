# CoffeeShop ☕
CoffeeShop — Android-приложение для кофейни, демонстрирующее навыки разработки. Позволяет просматривать меню, выбирать напитки и управлять корзиной. Использует Firebase Realtime Database и View Binding для современного UI. Отражает опыт работы с MVVM, Kotlin и Android-технологиями.

## 📖 О проекте:
CoffeeShop — удобное приложение для заказа напитков, которое позволяет:
1. Просматривать категории и популярные напитки.
2. Изучать детали товара (цена, рейтинг, описание).
3. Выбирать размер порции и добавлять в корзину.
4. Управлять корзиной с пересчётом стоимости, включая налоги и доставку.

## ✨ Особенности реализации
### Интуитивный UI:
-  View Binding для главного экрана, экрана деталей и корзины.
-  Динамические баннеры и адаптивный дизайн.

### Firebase Realtime Database:
-  Загрузка баннеров, категорий и товаров.
-  Фильтрация по категориям с индикаторами загрузки.

### Архитектура MVVM:
Разделение на View, ViewModel, Repository.
LiveData для реактивного UI.

### Корзина:
- Локальное хранение с TinyDB.
- Пересчёт стоимости с налогами и доставкой.

### UX:
- Плавные переходы и анимация выбора категорий.
- Обработка ошибок и индикаторы загрузки.

## Стек технологий:
1. Язык: Kotlin
2. UI: View Binding, XML
3. Навигация: Intent
4. Сеть: Firebase Realtime Database
5. Асинхронность: LiveData
6. Архитектура: MVVM
7. Хранилище: TinyDB
8. Изображения: Glide
9. Сборка: Gradle (Kotlin DSL)

## 📸 Демонстрация
<img src="/screenshots/Demo1.gif" width="30%" height="30%" alt="app demonstration"/> <img src="/screenshots/Demo2.gif" width="30%" height="30%" alt="app demonstration"/>  


