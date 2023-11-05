package com.hack.hacksa
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hackutd.calculate.R

class CompanyAdapter(private val mList: List<Company>) : RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.job_card, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.name.text = ItemsViewModel.name
        holder.description.text = ItemsViewModel.description
        holder.ranking.text = ItemsViewModel.ranking.toString()
        holder.hours.text = ItemsViewModel.hours.toString()
        holder.pay.text = ItemsViewModel.pay
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val hours: TextView = itemView.findViewById(R.id.hours)
        val pay: TextView = itemView.findViewById(R.id.pay)
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val name: TextView = itemView.findViewById(R.id.name)
        val ranking: TextView = itemView.findViewById(R.id.ranking)
        val description: TextView = itemView.findViewById(R.id.description)
    }
}