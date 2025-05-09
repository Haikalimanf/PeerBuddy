package com.example.peerbuddy

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.peerbuddy.data.local.Counselor

class ListCounselorAdapter(private val listCounselor: ArrayList<Counselor>): RecyclerView.Adapter<ListCounselorAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Counselor)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_counselor, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listCounselor[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
//        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listCounselor[holder.adapterPosition]) }

        holder.btnChat.setOnClickListener {
            val context = holder.itemView.context
            val phoneNumber =  listCounselor[position].phoneNumber
            val message = Uri.encode("Halo, saya ingin berkonsultasi!")
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://wa.me/$phoneNumber?text=$message")
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listCounselor.size

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val btnChat: Button = itemView.findViewById(R.id.btn_chat)
    }
}