# project2


Использованы паттерны композит, приспособленец + фабричный метод + классический синглтон, стратегия.


Представлена модель и тесты, включая интеграционные. Юниты controller и view не представлены.


Создан enum c типами контента - знак препинания, знак препинания конца предложения, символ, слово, предложение, абзац, листинг программы, текст

Листинг программы начинается после знака новой строки (возможен знак табуляции перед ключевыми словами) и со слов package, import, public, protected, class, interface, enum, abstract или private и заканчивается последней парной закрытой фигурной скобкой с последующим знаком новой строки. Листинг состоит исключительно из всех символов которые были в листинге, включая escape поледовательности.

Остальные перечисленные элементы логично вложены друг в друга с сохранением порядка. 

Примечание по 7 варианту задания. При сортировке слов сохранено их положение в тексте.
