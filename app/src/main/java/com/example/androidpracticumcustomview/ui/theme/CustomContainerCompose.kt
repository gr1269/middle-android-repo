package com.example.androidpracticumcustomview.ui.theme

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

/*
Задание:
Реализуйте необходимые компоненты;
Создайте проверку что дочерних элементов не более 2-х;
Предусмотрите обработку ошибок рендера дочерних элементов.
Задание по желанию:
Предусмотрите параметризацию длительности анимации.
 */
@Composable
fun CustomContainerCompose(
    firstChild: @Composable (() -> Unit)?,
    secondChild: @Composable (() -> Unit)?
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    var firstChildVisibility by remember { mutableStateOf(false) }
    var secondChildVisibility by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        firstChildVisibility = true
        delay(2000)
        secondChildVisibility = true
    }

    val density = LocalDensity.current

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        val slideInYTop = animateDpAsState(
            targetValue = if(firstChildVisibility) 0.dp else screenHeight/2,
            animationSpec = tween(durationMillis = 5000)
        )

        val fadeInFirst = animateFloatAsState(
            targetValue = if(firstChildVisibility) 1f else 0f,
            animationSpec = tween(durationMillis = 1000)
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .graphicsLayer(
                    alpha = fadeInFirst.value,
                    translationY = with(density) {
                        slideInYTop.value.toPx()
                    }
                )
        ) {
            if (firstChild != null) {
                firstChild()
            }
        }

        val slideInYBottom = animateDpAsState(
            targetValue = if(secondChildVisibility) 0.dp else -screenHeight/2,
            animationSpec = tween(durationMillis = 5000)
        )

        val fadeInSecond = animateFloatAsState(
            targetValue = if(secondChildVisibility) 1f else 0f,
            animationSpec = tween(durationMillis = 1000)
        )


        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .graphicsLayer(
                    alpha = fadeInSecond.value,
                    translationY = with(density) {
                        slideInYBottom.value.toPx()
                    }
                )
        ) {
            if (secondChild != null) {
                secondChild()
            }
        }

    }
}