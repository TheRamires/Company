package ram.ramires.company3.adapters

import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import ram.ramires.company3.R
import ram.ramires.company3.utilities.BASE_URL

@BindingAdapter("bind:imageUrl")
    fun setImageUrl(imageView: ImageView,
                    @NonNull id:String?) {
        var urlll: String=
            BASE_URL+"test_images/"+id+".jpg"

        Picasso
            .with(imageView.context)
            .load(urlll)
            .resize(400, 400)
            //.error(R.drawable.ic_launcher_foreground)
            .into(imageView)
    }
