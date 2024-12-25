import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pupupunk.Model.ItemActivity
import com.example.pupupunk.R

class CustomAdapter(private val mList: List<ItemActivity>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.imageView.setImageResource(R.drawable.avatar)
        holder.nickNameText.text = ItemsViewModel.userName
        holder.descriptionText.text = ItemsViewModel.activityDescription
        holder.placeText.text = ItemsViewModel.place
        holder.dataText.text = "Date: " + ItemsViewModel.date
        holder.timeText.text = "Time: " + ItemsViewModel.time



    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.avatarPhoto)
        val descriptionText: TextView = itemView.findViewById(R.id.activityDescription)
        val nickNameText: TextView = itemView.findViewById(R.id.authorNickname)
        val placeText: TextView = itemView.findViewById(R.id.textPlace)
        val dataText: TextView = itemView.findViewById(R.id.textDate)
        val timeText: TextView = itemView.findViewById(R.id.textTime)
    }
}