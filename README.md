

Проект по созданию ViewGroup в верстке Xml и для компоновки экрана JetpackCompose,
навигация осуществляется в MainActivity двумя кнопками через Intent на другие Activity.
В CustomContainer реализован метод AddView(), при добавлении более 2ух View выкидывает IllegalStateException
и при добавлении view после ее отрисовки происходит ее анимация.
В CustomContainerCompose для анимации использовал функцию animateDpAsState(),
в начале пытался реализовать AnimatedVisibility, но оказалось что отвечает за появление на экране.
