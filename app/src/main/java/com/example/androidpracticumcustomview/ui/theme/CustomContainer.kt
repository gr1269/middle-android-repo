package com.example.androidpracticumcustomview.ui.theme

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

/*
Задание:
Реализуйте необходимые компоненты;
Создайте проверку что дочерних элементов не более 2-х;
Предусмотрите обработку ошибок рендера дочерних элементов.
Задание по желанию:
Предусмотрите параметризацию длительности анимации.
 */
const val OFFSET_DURATION: Long = 5000
const val ALPHA_START = 0f
const val ALPHA_END = 1f
const val ALPHA_DURATION: Long = 1000
class CustomContainer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {



    init {
        setWillNotDraw(false)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun addView(child: View) {
        if (childCount >= 2) {
            throw IllegalStateException("Cannot add more 2 views")
        }

        try {
            super.addView(child)
            post { animate(child) }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun animate(child: View) {


        val startPosition = height / 2f

        child.alpha = ALPHA_START
        child.translationY = startPosition

        if (child == getChildAt(0)){
            child.animate()
                .translationY(0f)
                .setDuration(OFFSET_DURATION)
                .withStartAction {
                    child.animate()
                        .alpha(ALPHA_END)
                        .setDuration(ALPHA_DURATION)
                        .start()
                }
                .start()
        }
        if (child == getChildAt(1)){
            child.animate()
                .translationY(height.toFloat() - child.height.toFloat())
                .setDuration(OFFSET_DURATION)
                .withStartAction {
                    child.animate()
                        .alpha(ALPHA_END)
                        .setDuration(ALPHA_DURATION)
                        .start()
                }
                .start()
        }

    }
}