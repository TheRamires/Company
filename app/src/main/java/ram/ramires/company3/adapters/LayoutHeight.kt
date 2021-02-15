package ram.ramires.company3.adapters

import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("android:layout_height")
fun setLayoutHeight(view: View, height: Number) {
    val layoutParams = view.layoutParams
    layoutParams.height = height.toInt()
    view.layoutParams = layoutParams
}